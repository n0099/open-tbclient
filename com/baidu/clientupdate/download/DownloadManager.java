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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.jni.MiniGzip;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.tieba.lc.LcUpdateDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class DownloadManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_DOWNLOAD_MERGE_STATUS = "com.baidu.clientupdate.download.STATUS_MERGE";
    public static final String ACTION_DOWNLOAD_PROGRESS_CHANGE = "com.baidu.clientupdate.download.PROGRESS_CHANGE";
    public static final String ACTION_DOWNLOAD_STATUS_CHANGE = "com.baidu.clientupdate.download.STATUS_CHANGE";
    public static final long MIN_LEFT_SIZE = 20971520;
    public static final long MIN_PROGRESS_INTERVAL = 200;
    public static final long MIN_PROGRESS_SAVE_INTERVAL = 2000;
    public static final String TAG = "DownloadManager";
    public static DownloadManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public File apkFile;
    public Download download;
    public Boolean isDownloadPublicKey;
    public boolean isQuietDownload;
    public Boolean isUseRSA;
    public Thread loadThread;
    public com.baidu.clientupdate.c.a mBaiduParamManager;
    public Context mContext;
    public a mDbHelper;
    public Hashtable mDownloadMap;
    public ExecutorService mExecutor;
    public Handler mHandler;
    public HashMap mHeaders;
    public d mLogUtils;
    public BinaryTaskMng mTaskManager;
    public TaskObserver mtaskObserver;
    public File privateApkFile;
    public String sign;

    public DownloadManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDownloadMap = new Hashtable();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mExecutor = Executors.newFixedThreadPool(1, new i("DownloadManagerAsync"));
        Boolean bool = Boolean.TRUE;
        this.isDownloadPublicKey = bool;
        this.isUseRSA = bool;
        this.isQuietDownload = false;
        this.mtaskObserver = new TaskObserver(this) { // from class: com.baidu.clientupdate.download.DownloadManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadCancel(String str, long j, long j2, long j3, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
                    LogUtil.logE("DownloadManager", "--- onDownloadCancel : " + j);
                    this.this$0.changeState(DownloadState.CANCEL, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadFail(String str, long j, long j2, String str2, String str3, int i4, DownDetail downDetail) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2, str3, Integer.valueOf(i4), downDetail}) == null) {
                    d dVar = this.this$0.mLogUtils;
                    String c2 = this.this$0.mBaiduParamManager.c();
                    String b2 = this.this$0.mBaiduParamManager.b();
                    dVar.a(c2, "0", b2, "a7", "1", (System.currentTimeMillis() / 1000) + "", "", "DownloadFail", "");
                    LogUtil.logE("DownloadManager", "--- onDownloadFail : " + j);
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download != null) {
                        if (j2 <= download.mFileLength) {
                            download.mCurrentLength = j2;
                        }
                        download.mFailReason = str3;
                    }
                    LogUtil.logE("DownloadManager", "-- onDownloadFail : " + str3);
                    this.this$0.changeState(DownloadState.FAILED, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserverInterface
            public void onDownloadMsgType(String str, long j, int i4, Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i4), obj}) == null) {
                    LogUtil.logE("DownloadManager", "--- onDownloadMsgType ");
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadPause(String str, long j, long j2, long j3, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
                    d dVar = this.this$0.mLogUtils;
                    String c2 = this.this$0.mBaiduParamManager.c();
                    String b2 = this.this$0.mBaiduParamManager.b();
                    dVar.a(c2, "0", b2, "a7", "-1", (System.currentTimeMillis() / 1000) + "", "", "DownloadPause", "");
                    LogUtil.logE("DownloadManager", "--- onDownloadPause : " + j);
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download != null) {
                        download.mCurrentLength = j2;
                    }
                    this.this$0.changeState(DownloadState.PAUSE, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadRunning(String str, long j, long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    LogUtil.logE("DownloadManager", "--- onDownloadRunning ");
                }
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
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2, str3, str4, str5, Boolean.valueOf(z), downDetail}) == null) {
                    LogUtil.logE("DownloadManager", "--- onDownloadStart : " + j);
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download != null) {
                        if (download.mMimeType.equals(SchemeDescPatchListener.PATCH)) {
                            dVar = this.this$0.mLogUtils;
                            c2 = this.this$0.mBaiduParamManager.c();
                            b2 = this.this$0.mBaiduParamManager.b();
                            str6 = (System.currentTimeMillis() / 1000) + "";
                            str7 = "0";
                            str8 = "a6";
                            str9 = "0";
                            str10 = "";
                            str11 = "PatchDownload";
                        } else {
                            dVar = this.this$0.mLogUtils;
                            c2 = this.this$0.mBaiduParamManager.c();
                            b2 = this.this$0.mBaiduParamManager.b();
                            str6 = (System.currentTimeMillis() / 1000) + "";
                            str7 = "0";
                            str8 = "a6";
                            str9 = "0";
                            str10 = "";
                            str11 = "normalDownload";
                        }
                        dVar.a(c2, str7, b2, str8, str9, str6, str10, str11, "");
                        DownloadManager.processAPKInDataLocation(this.this$0.mContext, str3);
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
                        downloadManager = this.this$0;
                        downloadState = DownloadState.DOWNLOADING;
                    } else {
                        downloadManager = this.this$0;
                        downloadState = DownloadState.FAILED;
                    }
                    downloadManager.changeState(downloadState, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadSuccess(String str, long j, long j2, long j3, String str2, long j4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2, Long.valueOf(j4)}) == null) {
                    LogUtil.logE("DownloadManager", "--- onDownloadSuccess : " + j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadWait(String str, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLJ(1048583, this, str, j) == null) {
                    LogUtil.logE("DownloadManager", "--- onDownloadWait : " + j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloading(String str, long j, long j2, long j3, long j4, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str2}) == null) {
                    LogUtil.logE("DownloadManager", "--- onDownloading : " + j);
                    if (j3 == 0 || j2 == 0 || j2 > j3) {
                        return;
                    }
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download == null) {
                        LogUtil.logE("DownloadManager", "*** onDownloading, found download is null!");
                        return;
                    }
                    download.mCurrentLength = j2;
                    download.mFileLength = j3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - download.f36926a < 200) {
                        return;
                    }
                    download.f36926a = currentTimeMillis;
                    int progress = download.getProgress();
                    if (progress != download.f36928c) {
                        this.this$0.notifyProgressChange(j, progress);
                        download.f36928c = progress;
                    }
                    if (currentTimeMillis - download.f36927b > 2000) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        this.this$0.mDbHelper.b(download);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        LogUtil.logE("DownloadManager", "1新的更新数据库用时time:" + (currentTimeMillis3 - currentTimeMillis2) + "ms");
                        download.f36927b = currentTimeMillis;
                    }
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onWriteFinish(String str, long j, long j2, long j3, DownDetail downDetail) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), downDetail}) == null) {
                    this.this$0.mLogUtils.a(this.this$0.mBaiduParamManager.c(), "0", this.this$0.mBaiduParamManager.b(), "a7", "0", (System.currentTimeMillis() / 1000) + "", "", "DownloadFinish", "");
                    LogUtil.logE("DownloadManager", "--- onWriteFinish : " + j);
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download != null) {
                        download.mCurrentLength = download.mFileLength;
                        String str2 = download.mSavedPath + "/" + Uri.encode(download.mFileName);
                        LogUtil.logD("DownloadManager", "Download path:" + str2 + str2.endsWith(DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION));
                        if (!this.this$0.isQuietDownload && (!com.baidu.clientupdate.d.a.a(this.this$0.mContext).d() || !str2.endsWith(DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION))) {
                            this.this$0.mHandler.post(new Runnable(this, str2, download) { // from class: com.baidu.clientupdate.download.DownloadManager.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
                                public final /* synthetic */ Download val$download;
                                public final /* synthetic */ String val$path;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                                        newInitContext2.initArgs = r2;
                                        Object[] objArr2 = {this, str2, download};
                                        interceptable3.invokeUnInit(65536, newInitContext2);
                                        int i4 = newInitContext2.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext2.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext2);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$path = str2;
                                    this.val$download = download;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        LogUtil.logE("DownloadManager", "onWriteFinish   launchSystemInstalller");
                                        this.this$1.this$0.launchSystemInstalller(this.val$path, this.val$download);
                                    }
                                }
                            });
                        }
                    }
                    this.this$0.changeState(DownloadState.FINISH, j);
                }
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
        hashMap.put("referer", "https://update.baidu.com");
        try {
            queryAll();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(DownloadState downloadState, long j) {
        Download download;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65551, this, downloadState, j) == null) || (download = (Download) this.mDownloadMap.get(Long.valueOf(j))) == null) {
            return;
        }
        if (downloadState == DownloadState.CANCEL) {
            if (download.f36929d) {
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String chooseExtension(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        int lastIndexOf;
        int lastIndexOf2;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65552, null, str, str2, str3)) != null) {
            return (String) invokeLLL.objValue;
        }
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
        InterceptResult invokeLLL;
        String decode;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, str, str2, str3)) == null) {
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
        return (String) invokeLLL.objValue;
    }

    private void downloadPublicKey(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, str, str2) == null) {
            Thread thread = new Thread(this, str, str2) { // from class: com.baidu.clientupdate.download.DownloadManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ String val$apkMd5;
                public final /* synthetic */ String val$mUrl;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$mUrl = str;
                    this.val$apkMd5 = str2;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    HttpURLConnection httpURLConnection;
                    DownloadManager downloadManager;
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.run();
                        HttpURLConnection httpURLConnection2 = null;
                        try {
                            try {
                                httpURLConnection = (HttpURLConnection) new URL(this.val$mUrl).openConnection();
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Exception e2) {
                            e = e2;
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
                                    downloadManager = this.this$0;
                                    str3 = "sign==null||result==null";
                                } else {
                                    String str4 = new String(b.a(b.a(sb.toString()), com.baidu.clientupdate.b.a.a(com.baidu.clientupdate.d.a.a(this.this$0.mContext).a().mSign)));
                                    LogUtil.logE("DownloadManager", "公钥解密：" + str4);
                                    LogUtil.logE("DownloadManager", "apk的md5值：" + this.val$apkMd5);
                                    if (str4.equals(this.val$apkMd5)) {
                                        LogUtil.logE("DownloadManager", "第二次RSA验证通过");
                                        j.a(this.this$0.mContext, this.this$0.privateApkFile);
                                    } else {
                                        downloadManager = this.this$0;
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
                            this.this$0.sendBroadcastRSAFail(e.toString());
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
                }
            };
            this.loadThread = thread;
            thread.start();
        }
    }

    public static synchronized DownloadManager getInstance(Context context) {
        InterceptResult invokeL;
        DownloadManager downloadManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            synchronized (DownloadManager.class) {
                if (sInstance == null) {
                    sInstance = new DownloadManager(context);
                }
                downloadManager = sInstance;
            }
            return downloadManager;
        }
        return (DownloadManager) invokeL.objValue;
    }

    public static boolean isGzipFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProgressChange(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            LogUtil.logD("DownloadManager", "notifyStateChange downloadId " + j + " progress " + i2);
            this.mHandler.post(new Runnable(this, j, i2) { // from class: com.baidu.clientupdate.download.DownloadManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ long val$downloadId;
                public final /* synthetic */ int val$progress;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$downloadId = j;
                    this.val$progress = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Download download;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(this.val$downloadId))) == null) {
                        return;
                    }
                    Intent intent = new Intent("com.baidu.clientupdate.download.PROGRESS_CHANGE");
                    intent.putExtra("downloadid", this.val$downloadId);
                    intent.putExtra("download", download);
                    intent.putExtra("progress", this.val$progress);
                    intent.setPackage(this.this$0.mContext.getPackageName());
                    this.this$0.mContext.sendBroadcast(intent);
                }
            });
        }
    }

    private void notifyStateChange(long j, Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65558, this, j, download) == null) {
            LogUtil.logD("DownloadManager", "notifyStateChange downloadId " + j + " state " + download.getState());
            this.mHandler.post(new Runnable(this, j, download) { // from class: com.baidu.clientupdate.download.DownloadManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ Download val$download;
                public final /* synthetic */ long val$downloadId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), download};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$downloadId = j;
                    this.val$download = download;
                }

                @Override // java.lang.Runnable
                public void run() {
                    File file;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        GDiffPatcher gDiffPatcher = new GDiffPatcher();
                        Intent intent = new Intent("com.baidu.clientupdate.download.STATUS_CHANGE");
                        intent.putExtra("downloadid", this.val$downloadId);
                        intent.putExtra("state", this.val$download.getState());
                        intent.putExtra("download", this.val$download);
                        intent.setPackage(this.this$0.mContext.getPackageName());
                        this.this$0.mContext.sendBroadcast(intent);
                        if (this.val$download.mMimeType.equals(SchemeDescPatchListener.PATCH) && this.val$download.getState() == DownloadState.FINISH) {
                            String[] strArr = new String[4];
                            strArr[0] = "-d";
                            strArr[1] = j.b(this.this$0.mContext, this.this$0.mContext.getPackageName()).applicationInfo.publicSourceDir;
                            String str = this.val$download.mFileName;
                            String encode = str != null ? Uri.encode(str) : null;
                            strArr[2] = this.val$download.mSavedPath + File.separator + DownloadManager.chooseFilename(this.val$download.mUrl, encode, SchemeDescPatchListener.PATCH) + DownloadManager.chooseExtension(this.val$download.mUrl, encode, SchemeDescPatchListener.PATCH);
                            strArr[3] = this.val$download.mSavedPath + File.separator + DownloadManager.chooseFilename(this.val$download.mUrl, encode, "application/vnd.android.package-archive") + DownloadManager.chooseExtension(this.val$download.mUrl, encode, "application/vnd.android.package-archive");
                            File file2 = new File(strArr[1]);
                            File file3 = new File(strArr[3]);
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
                            intent2.putExtra("downloadid", this.val$downloadId);
                            intent2.putExtra("state", DownloadState.MEAGESTART);
                            Download download2 = this.val$download;
                            download2.mState = DownloadState.MEAGESTART;
                            intent2.putExtra("download", download2);
                            intent2.setPackage(this.this$0.mContext.getPackageName());
                            this.this$0.mContext.sendBroadcast(intent2);
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
                                ClientUpdater.getInstance(this.this$0.mContext).throwError(jSONObject);
                            }
                            LogUtil.logD("DownloadManager", "time is >>>  " + (System.currentTimeMillis() - currentTimeMillis) + "");
                            Intent intent3 = new Intent("com.baidu.clientupdate.download.STATUS_MERGE");
                            intent3.putExtra("downloadid", this.val$downloadId);
                            intent3.putExtra("state", DownloadState.MEAGEEND);
                            Download download3 = this.val$download;
                            download3.mState = DownloadState.MEAGEEND;
                            intent3.putExtra("download", download3);
                            intent3.setPackage(this.this$0.mContext.getPackageName());
                            this.this$0.mContext.sendBroadcast(intent3);
                            if (this.this$0.isQuietDownload) {
                                return;
                            }
                            this.this$0.mHandler.post(new Runnable(this, file3) { // from class: com.baidu.clientupdate.download.DownloadManager.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 this$1;
                                public final /* synthetic */ File val$bakfile;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, file3};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$bakfile = file3;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        LogUtil.logE("DownloadManager", "notifyStateChange   launchSystemInstalller");
                                        this.this$1.this$0.launchSystemInstalller(this.val$bakfile.getAbsolutePath(), this.this$1.val$download);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    public static void processAPKInDataLocation(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65559, null, context, str) == null) && str.startsWith(context.getFilesDir().getAbsolutePath())) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
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
    }

    private Download readDownload(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, cursor)) == null) {
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
        return (Download) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBroadcastRSAFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, str) == null) {
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
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x018b */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0206  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long startDownload(Download download) {
        InterceptResult invokeL;
        String encode;
        File file;
        boolean z;
        File a2;
        String str;
        ?? r7;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, download)) == null) {
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
        return invokeL.longValue;
    }

    public void cancel(long... jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jArr) == null) {
            runAsync(new Runnable(this, jArr) { // from class: com.baidu.clientupdate.download.DownloadManager.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ long[] val$downloadIds;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$downloadIds = jArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (int i2 = 0; i2 < this.val$downloadIds.length; i2++) {
                            Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(this.val$downloadIds[i2]));
                            if (download != null) {
                                download.f36929d = true;
                                this.this$0.mTaskManager.stopDownload(download.mUrl, this.val$downloadIds[i2], false);
                            }
                        }
                    }
                }
            });
        }
    }

    public void delete(long... jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jArr) == null) {
            for (int i2 = 0; i2 < jArr.length; i2++) {
                Download download = (Download) this.mDownloadMap.get(Long.valueOf(jArr[i2]));
                if (download != null) {
                    download.f36929d = false;
                    this.mTaskManager.stopDownload(download.mUrl, jArr[i2], false);
                }
            }
        }
    }

    public void launchSystemInstalller(String str, Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, download) == null) {
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
    }

    public void pause(long j) {
        Download download;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || (download = (Download) this.mDownloadMap.get(Long.valueOf(j))) == null) {
            return;
        }
        runAsync(new Runnable(this, download, j) { // from class: com.baidu.clientupdate.download.DownloadManager.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadManager this$0;
            public final /* synthetic */ Download val$download;
            public final /* synthetic */ long val$downloadId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, download, Long.valueOf(j)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$download = download;
                this.val$downloadId = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mTaskManager.pauseDownload(this.val$download.mUrl, this.val$downloadId);
                }
            }
        });
    }

    public void pauseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            runAsync(new Runnable(this) { // from class: com.baidu.clientupdate.download.DownloadManager.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mTaskManager.pauseAllTask();
                    }
                }
            });
        }
    }

    public void resume(long j) {
        Download download;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || (download = (Download) this.mDownloadMap.get(Long.valueOf(j))) == null) {
            return;
        }
        download.mState = DownloadState.WAITING;
        runAsync(new Runnable(this, download) { // from class: com.baidu.clientupdate.download.DownloadManager.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadManager this$0;
            public final /* synthetic */ Download val$download;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, download};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$download = download;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Process.setThreadPriority(10);
                    Download download2 = this.val$download;
                    if (download2 != null) {
                        this.this$0.startDownload(download2);
                    }
                }
            }
        });
    }

    public void runAsync(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            this.mExecutor.submit(runnable);
        }
    }

    public void setDownloadPublicKey(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.isDownloadPublicKey = Boolean.valueOf(z);
        }
    }

    public void setUseRSA(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.isUseRSA = Boolean.valueOf(z);
        }
    }

    public long start(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, download)) == null) {
            long a2 = this.mDbHelper.a(download);
            if (a2 == -1) {
                return a2;
            }
            download.mId = a2;
            this.mDownloadMap.put(Long.valueOf(a2), download);
            runAsync(new Runnable(this, download) { // from class: com.baidu.clientupdate.download.DownloadManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ Download val$download;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, download};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$download = download;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Process.setThreadPriority(10);
                        this.this$0.startDownload(this.val$download);
                    }
                }
            });
            return a2;
        }
        return invokeL.longValue;
    }

    public long start(Download download, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, download, z)) == null) {
            this.isQuietDownload = z;
            long a2 = this.mDbHelper.a(download);
            if (a2 == -1) {
                return a2;
            }
            download.mId = a2;
            this.mDownloadMap.put(Long.valueOf(a2), download);
            runAsync(new Runnable(this, download) { // from class: com.baidu.clientupdate.download.DownloadManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ Download val$download;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, download};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$download = download;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Process.setThreadPriority(10);
                        this.this$0.startDownload(this.val$download);
                    }
                }
            });
            return a2;
        }
        return invokeLZ.longValue;
    }
}
