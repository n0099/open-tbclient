package com.baidu.clientupdate.download;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.android.common.jni.MiniGzip;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.clientupdata.key.PublicKey;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.a.d;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.b.b;
import com.baidu.clientupdate.d.g;
import com.baidu.clientupdate.d.i;
import com.baidu.clientupdate.d.j;
import com.baidu.down.common.DownDetail;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.TaskObserver;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.taskmanager.BinaryTaskMng;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.utils.Utils;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.tieba.lc.LcUpdateDialogActivity;
import com.baidu.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class DownloadManager {
    public static final String ACTION_DOWNLOAD_MERGE_STATUS = "com.baidu.clientupdate.download.STATUS_MERGE";
    public static final String ACTION_DOWNLOAD_PROGRESS_CHANGE = "com.baidu.clientupdate.download.PROGRESS_CHANGE";
    public static final String ACTION_DOWNLOAD_STATUS_CHANGE = "com.baidu.clientupdate.download.STATUS_CHANGE";
    public static final long MIN_LEFT_SIZE = 20971520;
    public static final long MIN_PROGRESS_INTERVAL = 200;
    public static final long MIN_PROGRESS_SAVE_INTERVAL = 2000;
    public static final String TAG = "DownloadManager";
    public static DownloadManager sInstance;
    public File apkFile;
    public Download download;
    public Boolean isDownloadPublicKey;
    public boolean isQuietDownload;
    public Boolean isUseRSA;
    public Thread loadThread;
    public com.baidu.clientupdate.c.a mBaiduParamManager;
    public Context mContext;
    public a mDbHelper;
    public HashMap mHeaders;
    public d mLogUtils;
    public BinaryTaskMng mTaskManager;
    public TaskObserver mtaskObserver;
    public File privateApkFile;
    public String sign;
    public Hashtable mDownloadMap = new Hashtable();
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public ExecutorService mExecutor = Executors.newFixedThreadPool(1, new i("DownloadManagerAsync"));

    public DownloadManager(Context context) {
        Boolean bool = Boolean.TRUE;
        this.isDownloadPublicKey = bool;
        this.isUseRSA = bool;
        this.isQuietDownload = false;
        this.mtaskObserver = new TaskObserver() { // from class: com.baidu.clientupdate.download.DownloadManager.1
            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadCancel(String str, long j, long j2, long j3, String str2) {
                LogUtil.logE("DownloadManager", "--- onDownloadCancel : " + j);
                DownloadManager.this.changeState(DownloadState.CANCEL, j);
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadFail(String str, long j, long j2, String str2, String str3, int i2, DownDetail downDetail) {
                d dVar = DownloadManager.this.mLogUtils;
                String c2 = DownloadManager.this.mBaiduParamManager.c();
                String b2 = DownloadManager.this.mBaiduParamManager.b();
                dVar.a(c2, "0", b2, "a7", "1", (System.currentTimeMillis() / 1000) + "", "", "DownloadFail", "");
                LogUtil.logE("DownloadManager", "--- onDownloadFail : " + j);
                Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
                if (download != null) {
                    if (j2 <= download.mFileLength) {
                        download.mCurrentLength = j2;
                    }
                    download.mFailReason = str3;
                }
                LogUtil.logE("DownloadManager", "-- onDownloadFail : " + str3);
                DownloadManager.this.changeState(DownloadState.FAILED, j);
            }

            @Override // com.baidu.down.common.TaskObserverInterface
            public void onDownloadMsgType(String str, long j, int i2, Object obj) {
                LogUtil.logE("DownloadManager", "--- onDownloadMsgType ");
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadPause(String str, long j, long j2, long j3, String str2) {
                d dVar = DownloadManager.this.mLogUtils;
                String c2 = DownloadManager.this.mBaiduParamManager.c();
                String b2 = DownloadManager.this.mBaiduParamManager.b();
                dVar.a(c2, "0", b2, "a7", "-1", (System.currentTimeMillis() / 1000) + "", "", "DownloadPause", "");
                LogUtil.logE("DownloadManager", "--- onDownloadPause : " + j);
                Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
                if (download != null) {
                    download.mCurrentLength = j2;
                }
                DownloadManager.this.changeState(DownloadState.PAUSE, j);
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadRunning(String str, long j, long j2, long j3) {
                LogUtil.logE("DownloadManager", "--- onDownloadRunning ");
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadStart(String str, long j, long j2, String str2, String str3, String str4, String str5, boolean z, DownDetail downDetail) {
                DownloadManager downloadManager;
                DownloadState downloadState;
                d dVar;
                String c2;
                String b2;
                String str6;
                String str7;
                String str8;
                String str9;
                String str10;
                String str11;
                LogUtil.logE("DownloadManager", "--- onDownloadStart : " + j);
                Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
                if (download != null) {
                    if (download.mMimeType.equals(SchemeDescPatchListener.PATCH)) {
                        dVar = DownloadManager.this.mLogUtils;
                        c2 = DownloadManager.this.mBaiduParamManager.c();
                        b2 = DownloadManager.this.mBaiduParamManager.b();
                        str6 = (System.currentTimeMillis() / 1000) + "";
                        str7 = "0";
                        str8 = "a6";
                        str9 = "0";
                        str10 = "";
                        str11 = "PatchDownload";
                    } else {
                        dVar = DownloadManager.this.mLogUtils;
                        c2 = DownloadManager.this.mBaiduParamManager.c();
                        b2 = DownloadManager.this.mBaiduParamManager.b();
                        str6 = (System.currentTimeMillis() / 1000) + "";
                        str7 = "0";
                        str8 = "a6";
                        str9 = "0";
                        str10 = "";
                        str11 = "normalDownload";
                    }
                    dVar.a(c2, str7, b2, str8, str9, str6, str10, str11, "");
                    DownloadManager.processAPKInDataLocation(DownloadManager.this.mContext, str3);
                    File file = new File(str3);
                    String parent = file.getParent();
                    if (!TextUtils.equals(parent, download.mSavedPath)) {
                        String str12 = download.mFileName;
                        if (str12 != null) {
                            new File(download.mSavedPath, Uri.encode(str12)).delete();
                        }
                        download.mSavedPath = parent;
                        download.mCurrentLength = 0L;
                    }
                    String decode = Uri.decode(file.getName());
                    download.mETag = str4;
                    download.mFileLength = j2;
                    download.mFileName = decode;
                    downloadManager = DownloadManager.this;
                    downloadState = DownloadState.DOWNLOADING;
                } else {
                    downloadManager = DownloadManager.this;
                    downloadState = DownloadState.FAILED;
                }
                downloadManager.changeState(downloadState, j);
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadSuccess(String str, long j, long j2, long j3, String str2, long j4) {
                LogUtil.logE("DownloadManager", "--- onDownloadSuccess : " + j);
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadWait(String str, long j) {
                LogUtil.logE("DownloadManager", "--- onDownloadWait : " + j);
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloading(String str, long j, long j2, long j3, long j4, String str2) {
                LogUtil.logE("DownloadManager", "--- onDownloading : " + j);
                if (j3 == 0 || j2 == 0 || j2 > j3) {
                    return;
                }
                Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
                if (download == null) {
                    LogUtil.logE("DownloadManager", "*** onDownloading, found download is null!");
                    return;
                }
                download.mCurrentLength = j2;
                download.mFileLength = j3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - download.f4610a < 200) {
                    return;
                }
                download.f4610a = currentTimeMillis;
                int progress = download.getProgress();
                if (progress != download.f4612c) {
                    DownloadManager.this.notifyProgressChange(j, progress);
                    download.f4612c = progress;
                }
                if (currentTimeMillis - download.f4611b > 2000) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    DownloadManager.this.mDbHelper.b(download);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    LogUtil.logE("DownloadManager", "1新的更新数据库用时time:" + (currentTimeMillis3 - currentTimeMillis2) + "ms");
                    download.f4611b = currentTimeMillis;
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onWriteFinish(String str, long j, long j2, long j3, DownDetail downDetail) {
                DownloadManager.this.mLogUtils.a(DownloadManager.this.mBaiduParamManager.c(), "0", DownloadManager.this.mBaiduParamManager.b(), "a7", "0", (System.currentTimeMillis() / 1000) + "", "", "DownloadFinish", "");
                LogUtil.logE("DownloadManager", "--- onWriteFinish : " + j);
                final Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
                if (download != null) {
                    download.mCurrentLength = download.mFileLength;
                    final String str2 = download.mSavedPath + "/" + Uri.encode(download.mFileName);
                    LogUtil.logD("DownloadManager", "Download path:" + str2 + str2.endsWith(DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION));
                    if (!DownloadManager.this.isQuietDownload && (!com.baidu.clientupdate.d.a.a(DownloadManager.this.mContext).d() || !str2.endsWith(DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION))) {
                        DownloadManager.this.mHandler.post(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LogUtil.logE("DownloadManager", "onWriteFinish   launchSystemInstalller");
                                DownloadManager.this.launchSystemInstalller(str2, download);
                            }
                        });
                    }
                }
                DownloadManager.this.changeState(DownloadState.FINISH, j);
            }
        };
        this.mContext = context;
        this.mDbHelper = a.a(context);
        this.mLogUtils = d.a(this.mContext);
        this.mBaiduParamManager = com.baidu.clientupdate.c.a.a(context);
        BinaryTaskMng binaryTaskMng = TaskFacade.getInstance(this.mContext).getBinaryTaskMng();
        this.mTaskManager = binaryTaskMng;
        binaryTaskMng.addObserver(this.mtaskObserver);
        HashMap hashMap = new HashMap();
        this.mHeaders = hashMap;
        hashMap.put(Config.LAUNCH_REFERER, "https://update.baidu.com");
        try {
            queryAll();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(DownloadState downloadState, long j) {
        Download download = (Download) this.mDownloadMap.get(Long.valueOf(j));
        if (download != null) {
            if (downloadState == DownloadState.CANCEL) {
                if (download.f4613d) {
                    try {
                        new File(download.mSavedPath, Uri.encode(download.mFileName)).delete();
                    } catch (Exception e2) {
                        LogUtil.logE("DownloadManager", "delete download file error!!");
                        e2.printStackTrace();
                    }
                }
                this.mDownloadMap.remove(Long.valueOf(j));
                LogUtil.logI("DownloadManager", "mDownloadMap remove downloadId: " + j + "  mDownloadMap size: " + this.mDownloadMap.size());
                this.mDbHelper.a(j);
            } else if (download.getState() == DownloadState.FINISH) {
                return;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                this.mDbHelper.b(download);
                long currentTimeMillis2 = System.currentTimeMillis();
                LogUtil.logE("DownloadManager", "2新的更新数据库用时time:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                StringBuilder sb = new StringBuilder();
                sb.append("downloadmanger notification :");
                sb.append(download);
                LogUtil.logD("DownloadManager", sb.toString());
            }
            download.mState = downloadState;
            notifyStateChange(j, download);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String chooseExtension(String str, String str2, String str3) {
        String str4;
        int lastIndexOf;
        int lastIndexOf2;
        StringBuilder sb;
        int lastIndexOf3 = (str2 == null || str2.endsWith("/")) ? -1 : str2.lastIndexOf(46);
        String str5 = null;
        if (lastIndexOf3 >= 0 && lastIndexOf3 < str2.length() - 1) {
            String substring = str2.substring(lastIndexOf3 + 1);
            if (!TextUtils.isEmpty(MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring))) {
                str4 = "." + substring;
                if (TextUtils.isEmpty(str3)) {
                    str4 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                    if (str4 != null) {
                        sb = new StringBuilder();
                        sb.append(".");
                    } else if (str3.toLowerCase().startsWith("text/")) {
                        str4 = str3.equalsIgnoreCase(SapiWebView.DATA_MIME_TYPE) ? DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION : str3.equalsIgnoreCase("text/bin") ? DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION : DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION;
                    } else if (str3.toLowerCase().startsWith("audio/")) {
                        sb = new StringBuilder();
                        sb.append(".");
                        str4 = str3.substring(6);
                    }
                    sb.append(str4);
                    str4 = sb.toString();
                } else {
                    String decode = Uri.decode(str);
                    if (decode != null && !decode.endsWith("/") && decode.indexOf(63) < 0 && (lastIndexOf2 = decode.lastIndexOf(47) + 1) > 0) {
                        str5 = decode.substring(lastIndexOf2);
                    }
                    if (str5 != null && (lastIndexOf = str5.lastIndexOf(46)) > 0) {
                        str4 = str5.substring(lastIndexOf);
                    }
                }
                return str4 != null ? DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION : str4;
            }
        }
        str4 = null;
        if (TextUtils.isEmpty(str3)) {
        }
        if (str4 != null) {
        }
    }

    public static String chooseFilename(String str, String str2, String str3) {
        String decode;
        int lastIndexOf;
        if (str2 == null || str2.endsWith("/")) {
            str2 = null;
        } else {
            int lastIndexOf2 = str2.lastIndexOf(47) + 1;
            if (lastIndexOf2 > 0) {
                str2 = str2.substring(lastIndexOf2);
            }
        }
        if (str2 == null && (decode = Uri.decode(str)) != null && !decode.endsWith("/") && decode.indexOf(63) < 0 && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
            str2 = decode.substring(lastIndexOf);
        }
        if (str2 == null) {
            str2 = Utils.DEFAULT_DL_FILENAME;
        } else {
            int lastIndexOf3 = str2.lastIndexOf(46);
            if (lastIndexOf3 > 0) {
                str2 = str2.substring(0, lastIndexOf3);
            }
        }
        return str2.replaceAll("[()（）.,：:\\-|^$#_，。：=、/+《》<>*?？‘“”''\"\"]", "_");
    }

    private void downloadPublicKey(final String str, final String str2) {
        Thread thread = new Thread() { // from class: com.baidu.clientupdate.download.DownloadManager.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpURLConnection httpURLConnection;
                DownloadManager downloadManager;
                String str3;
                super.run();
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        StringBuilder sb = new StringBuilder();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            sb.append(new String(bArr, 0, read, "utf-8"));
                        }
                        inputStream.close();
                        LogUtil.logD("DownloadManager", "获取公钥的返回结果: " + sb.toString());
                        if (sb.toString() == null || sb.toString().equals("")) {
                            downloadManager = DownloadManager.this;
                            str3 = "sign==null||result==null";
                        } else {
                            String str4 = new String(b.a(b.a(sb.toString()), com.baidu.clientupdate.b.a.a(com.baidu.clientupdate.d.a.a(DownloadManager.this.mContext).a().mSign)));
                            LogUtil.logE("DownloadManager", "公钥解密：" + str4);
                            LogUtil.logE("DownloadManager", "apk的md5值：" + str2);
                            if (str4.equals(str2)) {
                                LogUtil.logE("DownloadManager", "第二次RSA验证通过");
                                j.a(DownloadManager.this.mContext, DownloadManager.this.privateApkFile);
                            } else {
                                downloadManager = DownloadManager.this;
                                str3 = "RSAstr!=apkMd5";
                            }
                        }
                        downloadManager.sendBroadcastRSAFail(str3);
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection2 = httpURLConnection;
                    e.printStackTrace();
                    DownloadManager.this.sendBroadcastRSAFail(e.toString());
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            }
        };
        this.loadThread = thread;
        thread.start();
    }

    public static synchronized DownloadManager getInstance(Context context) {
        DownloadManager downloadManager;
        synchronized (DownloadManager.class) {
            if (sInstance == null) {
                sInstance = new DownloadManager(context);
            }
            downloadManager = sInstance;
        }
        return downloadManager;
    }

    public static boolean isGzipFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            byte[] bArr = new byte[4];
            try {
                new FileInputStream(file).read(bArr);
                return "1F8B0800".equalsIgnoreCase(bytesToHexString(bArr));
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProgressChange(final long j, final int i2) {
        LogUtil.logD("DownloadManager", "notifyStateChange downloadId " + j + " progress " + i2);
        this.mHandler.post(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.3
            @Override // java.lang.Runnable
            public void run() {
                Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
                if (download != null) {
                    Intent intent = new Intent("com.baidu.clientupdate.download.PROGRESS_CHANGE");
                    intent.putExtra("downloadid", j);
                    intent.putExtra("download", download);
                    intent.putExtra("progress", i2);
                    intent.setPackage(DownloadManager.this.mContext.getPackageName());
                    DownloadManager.this.mContext.sendBroadcast(intent);
                }
            }
        });
    }

    private void notifyStateChange(final long j, final Download download) {
        LogUtil.logD("DownloadManager", "notifyStateChange downloadId " + j + " state " + download.getState());
        this.mHandler.post(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.4
            @Override // java.lang.Runnable
            public void run() {
                File file;
                GDiffPatcher gDiffPatcher = new GDiffPatcher();
                Intent intent = new Intent("com.baidu.clientupdate.download.STATUS_CHANGE");
                intent.putExtra("downloadid", j);
                intent.putExtra("state", download.getState());
                intent.putExtra("download", download);
                intent.setPackage(DownloadManager.this.mContext.getPackageName());
                DownloadManager.this.mContext.sendBroadcast(intent);
                if (download.mMimeType.equals(SchemeDescPatchListener.PATCH) && download.getState() == DownloadState.FINISH) {
                    String[] strArr = new String[4];
                    strArr[0] = "-d";
                    strArr[1] = j.b(DownloadManager.this.mContext, DownloadManager.this.mContext.getPackageName()).applicationInfo.publicSourceDir;
                    String str = download.mFileName;
                    String encode = str != null ? Uri.encode(str) : null;
                    strArr[2] = download.mSavedPath + File.separator + DownloadManager.chooseFilename(download.mUrl, encode, SchemeDescPatchListener.PATCH) + DownloadManager.chooseExtension(download.mUrl, encode, SchemeDescPatchListener.PATCH);
                    strArr[3] = download.mSavedPath + File.separator + DownloadManager.chooseFilename(download.mUrl, encode, "application/vnd.android.package-archive") + DownloadManager.chooseExtension(download.mUrl, encode, "application/vnd.android.package-archive");
                    File file2 = new File(strArr[1]);
                    final File file3 = new File(strArr[3]);
                    if (file3.exists()) {
                        file3.delete();
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (DownloadManager.isGzipFile(strArr[2])) {
                        String str2 = strArr[2];
                        MiniGzip.unGzipFile(str2, strArr[2] + XAdSimpleImageLoader.TEMP_SUFFIX);
                        file = new File(strArr[2] + XAdSimpleImageLoader.TEMP_SUFFIX);
                    } else {
                        file = new File(strArr[2]);
                    }
                    Intent intent2 = new Intent("com.baidu.clientupdate.download.STATUS_MERGE");
                    intent2.putExtra("downloadid", j);
                    intent2.putExtra("state", DownloadState.MEAGESTART);
                    Download download2 = download;
                    download2.mState = DownloadState.MEAGESTART;
                    intent2.putExtra("download", download2);
                    intent2.setPackage(DownloadManager.this.mContext.getPackageName());
                    DownloadManager.this.mContext.sendBroadcast(intent2);
                    try {
                        gDiffPatcher.patch(file2, file, file3);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("msgId", "2");
                            jSONObject.put("messageDetail", e2.getMessage());
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        ClientUpdater.getInstance(DownloadManager.this.mContext).throwError(jSONObject);
                    }
                    LogUtil.logD("DownloadManager", "time is >>>  " + (System.currentTimeMillis() - currentTimeMillis) + "");
                    Intent intent3 = new Intent("com.baidu.clientupdate.download.STATUS_MERGE");
                    intent3.putExtra("downloadid", j);
                    intent3.putExtra("state", DownloadState.MEAGEEND);
                    Download download3 = download;
                    download3.mState = DownloadState.MEAGEEND;
                    intent3.putExtra("download", download3);
                    intent3.setPackage(DownloadManager.this.mContext.getPackageName());
                    DownloadManager.this.mContext.sendBroadcast(intent3);
                    if (DownloadManager.this.isQuietDownload) {
                        return;
                    }
                    DownloadManager.this.mHandler.post(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LogUtil.logE("DownloadManager", "notifyStateChange   launchSystemInstalller");
                            DownloadManager.this.launchSystemInstalller(file3.getAbsolutePath(), download);
                        }
                    });
                }
            }
        });
    }

    public static void processAPKInDataLocation(Context context, String str) {
        if (str.startsWith(context.getFilesDir().getAbsolutePath())) {
            try {
                context.openFileOutput(new File(str).getName(), 0).close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    private void queryAll() {
        Cursor a2;
        Hashtable hashtable = this.mDownloadMap;
        if ((hashtable == null || hashtable.size() == 0) && (a2 = this.mDbHelper.a()) != null) {
            a2.moveToFirst();
            while (!a2.isAfterLast()) {
                Download readDownload = readDownload(a2);
                this.mDownloadMap.put(Long.valueOf(readDownload.mId), readDownload);
                a2.moveToNext();
            }
            a2.close();
        }
    }

    private Download readDownload(Cursor cursor) {
        Download download = new Download();
        download.mId = cursor.getLong(cursor.getColumnIndex("_id"));
        download.mUrl = cursor.getString(cursor.getColumnIndex("uri"));
        download.mFileName = cursor.getString(cursor.getColumnIndex("_data"));
        download.mSavedPath = cursor.getString(cursor.getColumnIndex("saved_path_for_user"));
        download.mFileLength = cursor.getLong(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES));
        download.mCurrentLength = cursor.getLong(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES));
        String encode = Uri.encode(download.mFileName);
        File file = new File(download.mSavedPath + File.separator + encode);
        download.mCurrentLength = file.exists() ? file.length() : 0L;
        download.mState = DownloadState.getState(cursor.getInt(cursor.getColumnIndex("status")));
        download.mFailReason = cursor.getString(cursor.getColumnIndex("failreason"));
        download.mMimeType = cursor.getString(cursor.getColumnIndex("mimetype"));
        download.mETag = cursor.getString(cursor.getColumnIndex("etag"));
        download.mSourceKey = cursor.getString(cursor.getColumnIndex("saved_source_key_user"));
        download.mNeedNotification = cursor.getInt(cursor.getColumnIndex("notificationneeded")) == 1;
        download.mNotificationShowed = cursor.getInt(cursor.getColumnIndex("notificationshowed")) == 1;
        return download;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBroadcastRSAFail(String str) {
        File file = this.apkFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.privateApkFile;
        if (file2 != null) {
            file2.delete();
        }
        Intent intent = new Intent(LcUpdateDialogActivity.LC_UPDATE_FAIL);
        intent.putExtra("download", this.download);
        this.mContext.sendBroadcast(intent);
        d dVar = this.mLogUtils;
        String c2 = this.mBaiduParamManager.c();
        String b2 = this.mBaiduParamManager.b();
        dVar.a(c2, "0", b2, "a8", "1", (System.currentTimeMillis() / 1000) + "", "", "RSA", str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0187 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0202  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long startDownload(Download download) {
        String encode;
        File file;
        boolean z;
        File a2;
        String str;
        ?? r7;
        String str2;
        download.mFailReason = "";
        String str3 = download.mSavedPath;
        long j = download.mFileLength;
        long j2 = download.mCurrentLength;
        String str4 = download.mFileName;
        if (str4 != null) {
            try {
                encode = Uri.encode(str4);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            file = (download.mSavedPath != null || download.mFileName == null) ? null : new File(download.mSavedPath, encode);
            z = false;
            if (file == null && file.exists()) {
                a2 = null;
            } else {
                a2 = com.baidu.clientupdate.d.b.a(this.mContext, (download.mFileLength - download.mCurrentLength) + MIN_LEFT_SIZE, download.mSavedPath);
                if (a2 == null) {
                    z = true;
                }
            }
            if (a2 == null && j2 == 0) {
                String path = a2.getPath();
                String str5 = path + File.separator + chooseFilename(download.mUrl, encode, download.mMimeType) + chooseExtension(download.mUrl, encode, download.mMimeType);
                String str6 = chooseFilename(download.mUrl, encode, download.mMimeType) + chooseExtension(download.mUrl, encode, download.mMimeType);
                File file2 = new File(str5);
                LogUtil.logE("DownloadManager", "file path is >>>>>>" + file2.getAbsolutePath());
                if (file2.exists()) {
                    try {
                    } catch (IOException e3) {
                        e = e3;
                        r7 = path;
                    }
                    if (download.mMimeType.equals(SchemeDescPatchListener.PATCH)) {
                        String valueOf = String.valueOf(file2.length());
                        download.mSavedPath = file2.getParent();
                        if (valueOf.equals(com.baidu.clientupdate.d.a.a(this.mContext).a().mPatchSize)) {
                            notifyProgressChange(download.mId, 100);
                            changeState(DownloadState.FINISH, download.mId);
                            return download.mId;
                        }
                        file2.delete();
                    } else {
                        String a3 = g.a(file2);
                        LogUtil.logE("DownloadManager", "apkMd5 is >>> " + a3 + ", server_mApkMd5 is >>>" + com.baidu.clientupdate.d.a.a(this.mContext).a().mApkMd5);
                        r7 = a3.equals(com.baidu.clientupdate.d.a.a(this.mContext).a().mApkMd5);
                        try {
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            str2 = r7;
                            str = str2;
                            if (a2 == null) {
                            }
                            if (z) {
                            }
                            return download.mId;
                        }
                        if (r7 != 0) {
                            download.mSavedPath = file2.getParent();
                            if (str6 != null) {
                                download.mFileName = Uri.decode(str6);
                            } else {
                                download.mFileName = null;
                            }
                            this.mDownloadMap.put(Long.valueOf(download.mId), download);
                            notifyProgressChange(download.mId, 100);
                            changeState(DownloadState.FINISH, download.mId);
                            LogUtil.logE("DownloadManager", "startDownload   launchSystemInstalller");
                            if (!this.isQuietDownload) {
                                launchSystemInstalller(file2.getAbsolutePath(), download);
                            }
                            return download.mId;
                        }
                        str2 = path;
                        file2.delete();
                        str = str2;
                    }
                }
                str2 = path;
                str = str2;
            } else {
                str = str3;
            }
            if (a2 == null && !TextUtils.equals(a2.getPath(), download.mSavedPath)) {
                String path2 = a2.getPath();
                com.baidu.util.a.a(this.mContext).b("lcsdk_xml", "path", path2);
                this.mTaskManager.startDownload(new FileMsg(download.mUrl, download.mId, path2, download.mFileName, download.mMimeType, Boolean.TRUE, this.mHeaders, 0L, 0L, download.mETag));
            } else if (z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msgId", "5");
                    jSONObject.put("messageDetail", "not enough free space");
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
                ClientUpdater.getInstance(this.mContext).throwError(jSONObject);
            } else {
                this.mTaskManager.startDownload(new FileMsg(download.mUrl, download.mId, str, download.mFileName, download.mMimeType, Boolean.TRUE, this.mHeaders, j2, j, download.mETag));
            }
            return download.mId;
        }
        encode = null;
        if (download.mSavedPath != null) {
        }
        z = false;
        if (file == null) {
        }
        a2 = com.baidu.clientupdate.d.b.a(this.mContext, (download.mFileLength - download.mCurrentLength) + MIN_LEFT_SIZE, download.mSavedPath);
        if (a2 == null) {
        }
        if (a2 == null) {
        }
        str = str3;
        if (a2 == null) {
        }
        if (z) {
        }
        return download.mId;
    }

    public void cancel(final long... jArr) {
        runAsync(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.10
            @Override // java.lang.Runnable
            public void run() {
                for (int i2 = 0; i2 < jArr.length; i2++) {
                    Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(jArr[i2]));
                    if (download != null) {
                        download.f4613d = true;
                        DownloadManager.this.mTaskManager.stopDownload(download.mUrl, jArr[i2], false);
                    }
                }
            }
        });
    }

    public void delete(long... jArr) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            Download download = (Download) this.mDownloadMap.get(Long.valueOf(jArr[i2]));
            if (download != null) {
                download.f4613d = false;
                this.mTaskManager.stopDownload(download.mUrl, jArr[i2], false);
            }
        }
    }

    public void launchSystemInstalller(String str, Download download) {
        this.download = download;
        String str2 = this.mContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/" + download.mFileName;
        LogUtil.logD("DownloadManager", "安装包路径：" + str + "   " + download.mFileName);
        StringBuilder sb = new StringBuilder();
        sb.append("复制apk到data/data路径：");
        sb.append(str2);
        LogUtil.logE("DownloadManager", sb.toString());
        try {
            FileOutputStream openFileOutput = this.mContext.openFileOutput(download.mFileName, 0);
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[2048];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    break;
                }
                openFileOutput.write(bArr, 0, read);
            }
            openFileOutput.close();
            fileInputStream.close();
            this.apkFile = new File(str);
            this.privateApkFile = new File(str2);
            new ProcessBuilder("chmod", "755", str2).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!this.isUseRSA.booleanValue()) {
            try {
                if (g.a(this.privateApkFile).equals(com.baidu.clientupdate.d.a.a(this.mContext).a().mApkMd5)) {
                    j.a(this.mContext, this.privateApkFile);
                } else {
                    sendBroadcastRSAFail("");
                }
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        try {
            ClientUpdateInfo a2 = com.baidu.clientupdate.d.a.a(this.mContext).a();
            this.sign = a2.mSign;
            com.baidu.util.a.a(this.mContext).b("lcsdk_xml", "apkMD5", a2.mApkMd5);
            String str3 = com.baidu.clientupdate.c.a.a(this.mContext).a() + "/lcmanage/index.php?r=InterfaceAction&method=pub_key&prodline=" + a2.mProdline;
            LogUtil.logE("DownloadManager", "下载公钥url==" + str3);
            String a3 = g.a(this.privateApkFile);
            if (TextUtils.isEmpty(this.sign) || TextUtils.isEmpty(a3)) {
                sendBroadcastRSAFail("sign=null");
                return;
            }
            try {
                LogUtil.logE("DownloadManager", "RSA验证");
                LogUtil.logE("DownloadManager", "返回接口的sign值：" + this.sign);
                String str4 = new String(b.a(b.a(PublicKey.get()), com.baidu.clientupdate.b.a.a(this.sign)));
                LogUtil.logE("DownloadManager", "公钥解密：" + str4);
                LogUtil.logE("DownloadManager", "apk的md5值：" + a3);
                if (str4.equals(a3)) {
                    LogUtil.logE("DownloadManager", "第一次RSA验证通过");
                    this.mLogUtils.a(this.mBaiduParamManager.c(), "0", this.mBaiduParamManager.b(), "a8", "0", (System.currentTimeMillis() / 1000) + "", "", "RSA", "");
                    j.a(this.mContext, this.privateApkFile);
                } else if (this.isDownloadPublicKey.booleanValue()) {
                    LogUtil.logE("DownloadManager", "RSA验证失败，下载公钥重新验证");
                    downloadPublicKey(str3, a3);
                } else {
                    sendBroadcastRSAFail("");
                }
            } catch (Exception e4) {
                LogUtil.logE("DownloadManager", "RSA异常，下载公钥重新验证");
                downloadPublicKey(str3, a3);
                LogUtil.logE("DownloadManager", e4.toString());
                LogUtil.logE("DownloadManager", e4.getMessage());
                e4.printStackTrace();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            sendBroadcastRSAFail(e5.toString());
        }
    }

    public void pause(final long j) {
        final Download download = (Download) this.mDownloadMap.get(Long.valueOf(j));
        if (download != null) {
            runAsync(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.7
                @Override // java.lang.Runnable
                public void run() {
                    DownloadManager.this.mTaskManager.pauseDownload(download.mUrl, j);
                }
            });
        }
    }

    public void pauseAll() {
        runAsync(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.8
            @Override // java.lang.Runnable
            public void run() {
                DownloadManager.this.mTaskManager.pauseAllTask();
            }
        });
    }

    public void resume(long j) {
        final Download download = (Download) this.mDownloadMap.get(Long.valueOf(j));
        if (download == null) {
            return;
        }
        download.mState = DownloadState.WAITING;
        runAsync(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.9
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                Download download2 = download;
                if (download2 != null) {
                    DownloadManager.this.startDownload(download2);
                }
            }
        });
    }

    public void runAsync(Runnable runnable) {
        this.mExecutor.submit(runnable);
    }

    public void setDownloadPublicKey(boolean z) {
        this.isDownloadPublicKey = Boolean.valueOf(z);
    }

    public void setUseRSA(boolean z) {
        this.isUseRSA = Boolean.valueOf(z);
    }

    public long start(final Download download) {
        long a2 = this.mDbHelper.a(download);
        if (a2 == -1) {
            return a2;
        }
        download.mId = a2;
        this.mDownloadMap.put(Long.valueOf(a2), download);
        runAsync(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.5
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                DownloadManager.this.startDownload(download);
            }
        });
        return a2;
    }

    public long start(final Download download, boolean z) {
        this.isQuietDownload = z;
        long a2 = this.mDbHelper.a(download);
        if (a2 == -1) {
            return a2;
        }
        download.mId = a2;
        this.mDownloadMap.put(Long.valueOf(a2), download);
        runAsync(new Runnable() { // from class: com.baidu.clientupdate.download.DownloadManager.6
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                DownloadManager.this.startDownload(download);
            }
        });
        return a2;
    }
}
