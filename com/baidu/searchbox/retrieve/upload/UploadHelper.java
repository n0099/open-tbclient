package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.util.Constants;
import com.baidu.searchbox.retrieve.file.util.FileZipUtil;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.tieba.lub;
import com.baidu.tieba.mub;
import com.baidu.tieba.oub;
import com.baidu.tieba.pub;
import com.baidu.tieba.ytb;
import com.baidu.tieba.ztb;
import com.baidu.yalog.LoggerManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UploadHelper {
    public static final String CHAR_UNDERLINE = "_";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String FILTER_ALL_DEFAULT = "*";
    public static final String FILTER_DIVIDER_DEFAULT = "/";
    public static final String LOG_FILE_FETCHZIP_SUFFIX = ".zip";
    public static final String LOG_FILE_FETCH_ZIP_PATH = "/.fetch_zip";
    public static final String LOG_FILE_SNAP_PATH = "/.yalog_snap";
    public static final boolean SNAP_SHOT_FLUSH_DEFAULT = true;
    public static final String TAG = "FetchLogUpload";
    public static final String UPLOAD_RESULT_VALID = "1";
    public static ExecutorService mExecutorService;
    public static volatile UploadHelper sSingleton;
    public mub mVoyager;

    public UploadHelper() {
        mExecutorService = Executors.newSingleThreadExecutor();
        if (this.mVoyager == null) {
            this.mVoyager = (mub) ServiceManager.getService(mub.a);
        }
    }

    public static UploadHelper getInstance() {
        if (sSingleton == null) {
            synchronized (UploadHelper.class) {
                if (sSingleton == null) {
                    sSingleton = new UploadHelper();
                }
            }
        }
        return sSingleton;
    }

    public void activeUploadSnapShot(final String str, final String str2, final List<String> list, final String str3, final long j, final long j2, final long j3, final boolean z, final JSONObject jSONObject) {
        mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.5
            @Override // java.lang.Runnable
            public void run() {
                UploadHelper.this.statActiveData(true, StatConstants.VALUE_TYPE_RECEIVE, str2, str);
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "type, dataId can not null");
                    }
                    UploadHelper.this.statActiveData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                    return;
                }
                UploadHelper.this.statActiveData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                String str4 = AppRuntime.getAppContext().getApplicationInfo().dataDir + UploadHelper.LOG_FILE_SNAP_PATH + File.separator + str2 + "_" + new SimpleDateFormat("yyMMddhhmmss").format(new Date());
                if (UploadHelper.DEBUG) {
                    Log.d(UploadHelper.TAG, "snap short dir: " + str4);
                }
                HashSet<String> snapShotSet = UploadHelper.this.getSnapShotSet(j2, j3, list, z, true, str4);
                if (snapShotSet == null || snapShotSet.size() == 0) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "not get upload dir");
                    }
                    UploadHelper.this.statActiveData(false, "query", str2, str);
                    return;
                }
                UploadHelper.this.statActiveData(true, "query", str2, str);
                JSONObject jSONObject2 = new JSONObject();
                File zipFetchFile = UploadHelper.this.zipFetchFile(snapShotSet, str4, str, str2, "", j, j2, j3, jSONObject2);
                if (zipFetchFile == null || zipFetchFile.length() == 0) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                    }
                    UploadHelper.this.statActiveData(false, "zip", str2, str);
                    return;
                }
                UploadHelper.this.statActiveData(true, "zip", str2, str);
                FileZipUtil.deleteDirWithFile(new File(str4));
                UploadHelper.this.activeUploadZipFile(str, str2, list, str3, jSONObject2.toString(), zipFetchFile, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statActiveData(boolean z, String str, String str2, String str3) {
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordActiveUploadData(z, str, str2, str3, "1");
        }
    }

    private void statActiveFileData(boolean z, String str, String str2, String str3) {
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordActiveUploadData(z, str, str2, str3, "2");
        }
    }

    public void activeUploadFile(final String str, final String str2, final List<String> list, final long j, final IActiveUploadListener iActiveUploadListener) {
        mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.6
            @Override // java.lang.Runnable
            public void run() {
                UploadHelper.this.startUploadActiveFile(str, str2, list, j, iActiveUploadListener);
            }
        });
    }

    public void uploadFetchZipFile(final String str, final String str2, final String str3, final File file, final JSONObject jSONObject) {
        mub mubVar;
        if (file != null && file.length() != 0 && (mubVar = this.mVoyager) != null) {
            mubVar.e(file.getAbsolutePath(), "fetchlog", new lub() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.8
                @Override // com.baidu.tieba.lub
                public void onFailure(String str4, JSONObject jSONObject2) {
                    UploadHelper uploadHelper = UploadHelper.this;
                    String str5 = str;
                    String str6 = str2;
                    String str7 = str3;
                    JSONObject jSONObject3 = jSONObject;
                    oub.a(jSONObject3, str4);
                    uploadHelper.reportTaskDone(str5, str6, str7, "", "1", jSONObject3);
                }

                @Override // com.baidu.tieba.lub
                public void onSuccess(String str4, JSONObject jSONObject2) {
                    UploadHelper.this.statFetchData("upload", true, str2, str, str3, "", str4, jSONObject);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "fetch upload success");
                    }
                    UploadHelper.this.reportTaskDone(str, str2, str3, str4, "0", jSONObject);
                }
            });
        }
    }

    public void activeUploadFile(final String str, final String str2, final List<String> list, final String str3, final long j, final JSONObject jSONObject) {
        mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.7
            @Override // java.lang.Runnable
            public void run() {
                UploadHelper.this.startUploadActiveFile(str, str2, list, str3, j, jSONObject);
            }
        });
    }

    public void activeUpload(final String str, final String str2, final List<String> list, final long j, final long j2, final long j3, final IActiveUploadListener iActiveUploadListener) {
        mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.3
            @Override // java.lang.Runnable
            public void run() {
                UploadHelper.this.statActiveData(true, StatConstants.VALUE_TYPE_RECEIVE, str2, str);
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "type, dataId can not null");
                    }
                    UploadHelper.this.statActiveData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                    IActiveUploadListener iActiveUploadListener2 = iActiveUploadListener;
                    if (iActiveUploadListener2 != null) {
                        iActiveUploadListener2.onFailure(IActiveUploadListener.PARAM_ERR_MSG);
                        return;
                    }
                    return;
                }
                UploadHelper.this.statActiveData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                HashSet fetchDirSet = UploadHelper.this.getFetchDirSet(j2, j3, list);
                if (fetchDirSet == null || fetchDirSet.size() == 0) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "not get upload dir");
                    }
                    UploadHelper.this.statActiveData(false, "zip", str2, str);
                    IActiveUploadListener iActiveUploadListener3 = iActiveUploadListener;
                    if (iActiveUploadListener3 != null) {
                        iActiveUploadListener3.onFailure(IActiveUploadListener.DIR_ERR_MSG);
                        return;
                    }
                    return;
                }
                UploadHelper.this.statActiveData(true, "query", str2, str);
                JSONObject jSONObject = new JSONObject();
                File zipFetchFile = UploadHelper.this.zipFetchFile(fetchDirSet, LoggerManager.getBaseDir(), str, str2, "", j, j2, j3, jSONObject);
                if (zipFetchFile == null || zipFetchFile.length() == 0) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                    }
                    UploadHelper.this.statActiveData(false, "zip", str2, str);
                    IActiveUploadListener iActiveUploadListener4 = iActiveUploadListener;
                    if (iActiveUploadListener4 != null) {
                        iActiveUploadListener4.onFailure(IActiveUploadListener.PRE_ZIP_ERR_MSG);
                        return;
                    }
                    return;
                }
                UploadHelper.this.statActiveData(true, "zip", str2, str);
                UploadHelper.this.activeUploadZipFile(str, str2, list, jSONObject.toString(), zipFetchFile, iActiveUploadListener);
            }
        });
    }

    public void fetchUpload(final String str, final String str2, final String str3, final long j, final long j2, final long j3, final List<String> list) {
        mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    UploadHelper.this.statFetchData(StatConstants.VALUE_TYPE_CHECK_PARAM, true, str2, str, str3, "", "", null);
                    FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(str, "3", str2, str3, "", "", ""), new IUploadListener() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.1.1
                        @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                        public void onFailure() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            UploadHelper.this.statFetchData("start", false, str2, str, str3, StatConstants.ERR_MSG_START_FAIL, "", null);
                        }

                        @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                        public void onSuccess(FetchResult fetchResult) {
                            if (fetchResult != null && TextUtils.equals("1", fetchResult.getValid())) {
                                if (UploadHelper.DEBUG) {
                                    Log.d(UploadHelper.TAG, "日志回捞命开始上传");
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                UploadHelper.this.statFetchData("start", true, str2, str, str3, "", "", null);
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                HashSet fetchDirSet = UploadHelper.this.getFetchDirSet(j2, j3, list);
                                if (fetchDirSet != null && fetchDirSet.size() > 0) {
                                    AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                    UploadHelper.this.statFetchData("query", true, str2, str, str3, "", "", null);
                                    JSONObject jSONObject = new JSONObject();
                                    String baseDir = LoggerManager.getBaseDir();
                                    AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                                    File zipFetchFile = UploadHelper.this.zipFetchFile(fetchDirSet, baseDir, str, str2, str3, j, j2, j3, jSONObject);
                                    if (zipFetchFile != null && zipFetchFile.length() > 0) {
                                        AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                                        UploadHelper.this.statFetchData("zip", true, str2, str, str3, "", "", jSONObject);
                                        AnonymousClass1 anonymousClass16 = AnonymousClass1.this;
                                        UploadHelper.this.uploadFetchZipFile(str, str2, str3, zipFetchFile, jSONObject);
                                        return;
                                    }
                                    if (UploadHelper.DEBUG) {
                                        Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                                    }
                                    AnonymousClass1 anonymousClass17 = AnonymousClass1.this;
                                    UploadHelper.this.reportTaskDone(str, str2, str3, "", "1", jSONObject);
                                    AnonymousClass1 anonymousClass18 = AnonymousClass1.this;
                                    UploadHelper.this.statFetchData("zip", false, str2, str, str3, "zip failed", "", jSONObject);
                                    return;
                                }
                                AnonymousClass1 anonymousClass19 = AnonymousClass1.this;
                                UploadHelper.this.reportTaskDone(str, str2, str3, "", "1", oub.c(list));
                                AnonymousClass1 anonymousClass110 = AnonymousClass1.this;
                                UploadHelper.this.statFetchData("query", false, str2, str, str3, StatConstants.ERR_MSG_QUERY_FAIL, "", oub.c(list));
                                return;
                            }
                            AnonymousClass1 anonymousClass111 = AnonymousClass1.this;
                            UploadHelper.this.statFetchData("start", false, str2, str, str3, StatConstants.ERR_MSG_START_FAIL, "", null);
                        }
                    });
                    return;
                }
                if (UploadHelper.DEBUG) {
                    Log.d(UploadHelper.TAG, "日志回捞命令校验失败");
                }
                UploadHelper.this.statFetchData(StatConstants.VALUE_TYPE_CHECK_PARAM, false, str2, str, str3, StatConstants.ERR_MSG_CHECK_PARAM_FAIL, "", null);
            }
        });
    }

    private boolean checkValid(String str, long j, long j2) {
        if (TextUtils.isEmpty(str) || !str.endsWith(".log") || j >= j2 || j > System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashSet<String> getFetchDirSet(long j, long j2, List<String> list) {
        File[] listFiles;
        String substring;
        String str;
        String str2;
        String baseDir = LoggerManager.getBaseDir();
        HashSet<String> hashSet = new HashSet<>();
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    int indexOf = next.indexOf("/");
                    if (indexOf == -1) {
                        substring = "";
                    } else {
                        String substring2 = next.substring(0, indexOf);
                        substring = next.substring(indexOf + 1);
                        next = substring2;
                    }
                    if (TextUtils.isEmpty(next)) {
                        str = "*";
                    } else {
                        str = next;
                    }
                    if (TextUtils.isEmpty(substring)) {
                        str2 = "*";
                    } else {
                        str2 = substring;
                    }
                    List<String> queryLogFiles = LoggerManager.queryLogFiles(j / 1000, j2 / 1000, str, str2);
                    if (queryLogFiles != null && queryLogFiles.size() != 0) {
                        Iterator<String> it2 = queryLogFiles.iterator();
                        while (it2.hasNext()) {
                            hashSet.add(baseDir + File.separator + it2.next());
                        }
                    }
                }
            }
        } else {
            File file = new File(baseDir);
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.isDirectory()) {
                        hashSet.add(baseDir + File.separatorChar + file2.getName());
                    }
                }
            }
        }
        if (DEBUG) {
            Log.d(TAG, "fetchDirList size is: " + hashSet.size());
            Log.d(TAG, "fetchDirList: " + Arrays.asList(hashSet));
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadActiveFile(String str, String str2, List<String> list, long j, final IActiveUploadListener iActiveUploadListener) {
        statActiveFileData(true, StatConstants.VALUE_TYPE_RECEIVE, str2, str);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && list.size() != 0) {
            statActiveFileData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
            mub mubVar = (mub) ServiceManager.getService(mub.a);
            if (mubVar == null) {
                if (DEBUG) {
                    Log.d(TAG, "loss voyager impl component");
                    return;
                }
                return;
            }
            final ActiveUpObj activeUpObj = new ActiveUpObj(str, str2, list, null);
            activeUpObj.setFileType("2");
            mubVar.g(list, "acupload", j * 1024, new lub() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.10
                @Override // com.baidu.tieba.lub
                public void onFailure(String str3, JSONObject jSONObject) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "Active upload normal file failed, errMsg: " + str3);
                    }
                    UploadHelper.this.statMultiActiveFileData(false, activeUpObj.getDataId(), activeUpObj.getType(), str3);
                    if (iActiveUploadListener != null) {
                        if (!TextUtils.isEmpty(str3)) {
                            iActiveUploadListener.onFailure(str3);
                        } else {
                            iActiveUploadListener.onFailure(IActiveUploadListener.UPLOAD_ERR_MSG);
                        }
                    }
                }

                @Override // com.baidu.tieba.lub
                public void onSuccess(String str3, JSONObject jSONObject) {
                    activeUpObj.setFileID(str3);
                    activeUpObj.setFileMeta(jSONObject.toString());
                    UploadHelper.this.statMultiActiveFileData(true, activeUpObj.getDataId(), activeUpObj.getType(), jSONObject.toString());
                    ActiveUploadManager.getInstance().activeUploadReportContent(activeUpObj, iActiveUploadListener);
                }
            });
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "type, dataId can not null");
        }
        statActiveFileData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadActiveFile(String str, String str2, List<String> list, String str3, long j, JSONObject jSONObject) {
        JSONObject jSONObject2;
        statActiveFileData(true, StatConstants.VALUE_TYPE_RECEIVE, str2, str);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && list.size() != 0) {
            statActiveFileData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
            mub mubVar = (mub) ServiceManager.getService(mub.a);
            if (mubVar == null) {
                if (DEBUG) {
                    Log.d(TAG, "loss voyager impl component");
                    return;
                }
                return;
            }
            long j2 = j * 1024;
            if (jSONObject == null) {
                jSONObject2 = new JSONObject();
            } else {
                jSONObject2 = jSONObject;
            }
            try {
                jSONObject2.put("type", str);
                jSONObject2.put("dataId", str2);
                jSONObject2.put("space", list.toString());
                jSONObject2.put("source", str3);
                jSONObject2.put("fileType", "2");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            mubVar.b(list, "acupload", j2, jSONObject2);
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "type, dataId can not null");
        }
        statActiveFileData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
    }

    public void reportTaskDone(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        String jSONObject2;
        String str6 = "";
        if (DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("report task done: type: ");
            sb.append(str);
            sb.append(", jobId: ");
            sb.append(str2);
            sb.append(", version: ");
            sb.append(str3);
            sb.append(", fileID: ");
            sb.append(str4);
            sb.append(", status: ");
            sb.append(str5);
            sb.append(", fileMeta: ");
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            sb.append(jSONObject2);
            Log.d(TAG, sb.toString());
        }
        if (!"2".equals(str5) && !Constants.FetchType.isTimerType(str) && !Constants.FetchType.isCancelType(str)) {
            FetchTaskManager.getInstance().clearOriginData();
            FetchTaskManager.getInstance().saveRetryCount(0);
        }
        IFetchTask iFetchTask = (IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE);
        if (jSONObject != null) {
            str6 = jSONObject.toString();
        }
        iFetchTask.reportTaskDone(str, str2, str3, str5, str4, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statFetchData(String str, boolean z, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordUploadRetrieveData(str, z, str2, str3, str4, str5, str6, jSONObject);
        }
    }

    public void activeUpload(final String str, final String str2, final List<String> list, final String str3, final long j, final long j2, final long j3, final JSONObject jSONObject) {
        mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.2
            @Override // java.lang.Runnable
            public void run() {
                UploadHelper.this.statActiveData(true, StatConstants.VALUE_TYPE_RECEIVE, str2, str);
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "type, dataId can not null");
                    }
                    UploadHelper.this.statActiveData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                    return;
                }
                UploadHelper.this.statActiveData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                HashSet fetchDirSet = UploadHelper.this.getFetchDirSet(j2, j3, list);
                if (fetchDirSet == null || fetchDirSet.size() == 0) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "not get upload dir");
                    }
                    UploadHelper.this.statActiveData(false, "query", str2, str);
                    return;
                }
                UploadHelper.this.statActiveData(true, "query", str2, str);
                JSONObject jSONObject2 = new JSONObject();
                File zipFetchFile = UploadHelper.this.zipFetchFile(fetchDirSet, LoggerManager.getBaseDir(), str, str2, "", j, j2, j3, jSONObject2);
                if (zipFetchFile == null || zipFetchFile.length() == 0) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                    }
                    UploadHelper.this.statActiveData(false, "zip", str2, str);
                    return;
                }
                UploadHelper.this.statActiveData(true, "zip", str2, str);
                UploadHelper.this.activeUploadZipFile(str, str2, list, str3, jSONObject2.toString(), zipFetchFile, jSONObject);
            }
        });
    }

    public void activeUploadSnapShot(final String str, final String str2, final List<String> list, final long j, final long j2, final long j3, final boolean z, final IActiveUploadListener iActiveUploadListener) {
        mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.4
            @Override // java.lang.Runnable
            public void run() {
                UploadHelper.this.statActiveData(true, StatConstants.VALUE_TYPE_RECEIVE, str2, str);
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "type, dataId can not null");
                    }
                    UploadHelper.this.statActiveData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                    IActiveUploadListener iActiveUploadListener2 = iActiveUploadListener;
                    if (iActiveUploadListener2 != null) {
                        iActiveUploadListener2.onFailure(IActiveUploadListener.PARAM_ERR_MSG);
                        return;
                    }
                    return;
                }
                UploadHelper.this.statActiveData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                String str3 = AppRuntime.getAppContext().getApplicationInfo().dataDir + UploadHelper.LOG_FILE_SNAP_PATH + File.separator + str2 + "_" + new SimpleDateFormat("yyMMddhhmmss").format(new Date());
                if (UploadHelper.DEBUG) {
                    Log.d(UploadHelper.TAG, "snap short dir: " + str3);
                }
                HashSet<String> snapShotSet = UploadHelper.this.getSnapShotSet(j2, j3, list, z, true, str3);
                if (snapShotSet == null || snapShotSet.size() == 0) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "not get upload dir");
                    }
                    UploadHelper.this.statActiveData(false, "query", str2, str);
                    IActiveUploadListener iActiveUploadListener3 = iActiveUploadListener;
                    if (iActiveUploadListener3 != null) {
                        iActiveUploadListener3.onFailure(IActiveUploadListener.DIR_ERR_MSG);
                        return;
                    }
                    return;
                }
                UploadHelper.this.statActiveData(true, "query", str2, str);
                JSONObject jSONObject = new JSONObject();
                File zipFetchFile = UploadHelper.this.zipFetchFile(snapShotSet, str3, str, str2, "", j, j2, j3, jSONObject);
                if (zipFetchFile == null || zipFetchFile.length() == 0) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                    }
                    UploadHelper.this.statActiveData(false, "zip", str2, str);
                    IActiveUploadListener iActiveUploadListener4 = iActiveUploadListener;
                    if (iActiveUploadListener4 != null) {
                        iActiveUploadListener4.onFailure("zip failed");
                        return;
                    }
                    return;
                }
                UploadHelper.this.statActiveData(true, "zip", str2, str);
                FileZipUtil.deleteDirWithFile(new File(str3));
                UploadHelper.this.activeUploadZipFile(str, str2, list, jSONObject.toString(), zipFetchFile, iActiveUploadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statMultiActiveFileData(boolean z, String str, String str2, String str3) {
        if (z) {
            statActiveFileData(true, "query", str, str2);
            statActiveFileData(true, "zip", str, str2);
            statActiveFileData(true, "upload", str, str2);
        } else if (TextUtils.equals("dir not found", str3)) {
            statActiveFileData(false, "query", str, str2);
        } else if (TextUtils.equals("zip failed", str3)) {
            statActiveFileData(true, "query", str, str2);
            statActiveFileData(false, "zip", str, str2);
        } else {
            statActiveFileData(true, "query", str, str2);
            statActiveFileData(true, "zip", str, str2);
            statActiveFileData(false, "upload", str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File zipFetchFile(HashSet<String> hashSet, String str, String str2, String str3, String str4, long j, long j2, long j3, JSONObject jSONObject) {
        if (hashSet == null || hashSet.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        long j4 = 1000 * j;
        if (hashSet.size() > 0) {
            Iterator<String> it = hashSet.iterator();
            long j5 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                File file = new File(next);
                if (file.exists()) {
                    int lastIndexOf = next.lastIndexOf("/");
                    if (lastIndexOf > -1) {
                        next = next.substring(lastIndexOf + 1);
                    }
                    if (checkValid(next, j2, j3)) {
                        j5 += file.length();
                        if (j5 > j4) {
                            ztb.g().e(file.getAbsolutePath(), "3", file.getAbsolutePath() + "size exceed maxFileSize ", null, null, true, jSONObject);
                            break;
                        }
                        String substring = file.getAbsolutePath().substring(str.length());
                        if (DEBUG) {
                            Log.d(TAG, "new Path:" + substring);
                        }
                        ztb.g().e(file.getAbsolutePath(), "0", " success", file, substring, true, jSONObject);
                    } else {
                        continue;
                    }
                }
            }
            String str5 = AppRuntime.getAppContext().getCacheDir().getAbsolutePath() + LOG_FILE_FETCH_ZIP_PATH + File.separator;
            String str6 = UUID.randomUUID().toString().replace("-", "") + ".zip";
            File file2 = new File(str5);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String str7 = str5 + str6;
            if (DEBUG) {
                Log.d(TAG, "zipPath: " + str7);
            }
            File file3 = new File(str7);
            if (pub.i(new ArrayList(hashSet), str7, str)) {
                if (file3.length() > 0) {
                    if (DEBUG) {
                        Log.d(TAG, "zip directory is succeed, zip length is: " + file3.length());
                    }
                    return file3;
                }
                reportTaskDone(str2, str3, str4, "", "1", jSONObject);
            } else {
                reportTaskDone(str2, str3, str4, "", "1", jSONObject);
            }
        }
        return null;
    }

    public void activeUploadZipFile(String str, String str2, List<String> list, String str3, File file, final IActiveUploadListener iActiveUploadListener) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && file != null && file.length() != 0) {
            final ActiveUpObj activeUpObj = new ActiveUpObj(str, str2, list, str3);
            activeUpObj.setFileType("1");
            mub mubVar = this.mVoyager;
            if (mubVar == null) {
                if (DEBUG) {
                    Log.d(TAG, "voyager component fail");
                }
                if (iActiveUploadListener != null) {
                    iActiveUploadListener.onFailure("voyager component fail");
                    return;
                }
                return;
            }
            mubVar.a(file.getAbsolutePath(), "acupload", ytb.m, new lub() { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.9
                @Override // com.baidu.tieba.lub
                public void onFailure(String str4, JSONObject jSONObject) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "Active upload yalog file failed");
                    }
                    UploadHelper.this.statActiveData(false, "upload", activeUpObj.getDataId(), activeUpObj.getType());
                    if (iActiveUploadListener != null) {
                        if (!TextUtils.isEmpty(str4)) {
                            iActiveUploadListener.onFailure(str4);
                        } else {
                            iActiveUploadListener.onFailure(IActiveUploadListener.UPLOAD_ERR_MSG);
                        }
                    }
                }

                @Override // com.baidu.tieba.lub
                public void onSuccess(String str4, JSONObject jSONObject) {
                    activeUpObj.setFileID(str4);
                    UploadHelper.this.statActiveData(true, "upload", activeUpObj.getDataId(), activeUpObj.getType());
                    ActiveUploadManager.getInstance().activeUploadReportContent(activeUpObj, iActiveUploadListener);
                }
            });
        }
    }

    public void activeUploadZipFile(String str, String str2, List<String> list, String str3, String str4, File file, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && file != null && file.length() != 0) {
            if (this.mVoyager == null) {
                if (DEBUG) {
                    Log.d(TAG, "voyager component fail");
                    return;
                }
                return;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("type", str);
                jSONObject.put("dataId", str2);
                jSONObject.put("space", list.toString());
                jSONObject.put("fileMeta", str4);
                jSONObject.put("source", str3);
                jSONObject.put("fileType", "1");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            this.mVoyager.c(file.getAbsolutePath(), "acupload", jSONObject);
        }
    }

    public HashSet<String> getSnapShotSet(long j, long j2, List<String> list, boolean z, boolean z2, String str) {
        String substring;
        String str2;
        String str3;
        HashSet<String> hashSet = new HashSet<>();
        if (list != null && list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    int indexOf = next.indexOf("/");
                    if (indexOf == -1) {
                        substring = "";
                    } else {
                        String substring2 = next.substring(0, indexOf);
                        substring = next.substring(indexOf + 1);
                        next = substring2;
                    }
                    if (TextUtils.isEmpty(next)) {
                        str2 = "*";
                    } else {
                        str2 = next;
                    }
                    if (TextUtils.isEmpty(substring)) {
                        str3 = "*";
                    } else {
                        str3 = substring;
                    }
                    List<String> createLogSnapShot = LoggerManager.createLogSnapShot(j / 1000, j2 / 1000, str2, str3, z, z2, str);
                    if (createLogSnapShot != null) {
                        if (createLogSnapShot.size() != 0) {
                            for (String str4 : createLogSnapShot) {
                                sb.setLength(0);
                                sb.append(str);
                                sb.append(File.separator);
                                sb.append(str4);
                                hashSet.add(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        if (DEBUG) {
            Log.d(TAG, "snapShotDirList size is: " + hashSet.size());
            Log.d(TAG, "snapShotDirList: " + Arrays.asList(hashSet));
        }
        return hashSet;
    }
}
