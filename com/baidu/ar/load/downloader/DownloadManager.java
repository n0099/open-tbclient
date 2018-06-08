package com.baidu.ar.load.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.load.DownloadTask;
import com.baidu.ar.load.FileManageTask;
import com.baidu.ar.load.QueryTask;
import com.baidu.ar.load.downloader.DownloadController;
import com.baidu.ar.load.util.DownloadConstants;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.MD5Utils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class DownloadManager {
    private static volatile DownloadManager sInstance;
    private boolean mActivityResumed = false;
    Map<String, DownloadController> mDownloadControllerMap = new HashMap();

    private DownloadManager() {
    }

    public static DownloadManager getInstance() {
        if (sInstance == null) {
            synchronized (DownloadManager.class) {
                if (sInstance == null) {
                    sInstance = new DownloadManager();
                }
            }
        }
        return sInstance;
    }

    public static void releaseInstance() {
        synchronized (DownloadManager.class) {
            sInstance = null;
        }
    }

    private void setDownloadControllerMapResumed(boolean z) {
        for (DownloadController downloadController : this.mDownloadControllerMap.values()) {
            downloadController.a(this.mActivityResumed);
        }
    }

    public void cancel(String str, String str2) {
        DownloadController downloadController = this.mDownloadControllerMap.get(TextUtils.isEmpty(str2) ? MD5Utils.md5(str + "_main") : MD5Utils.md5(str + "_" + str2));
        if (downloadController != null) {
            downloadController.e();
        }
    }

    public void cancel(String str, String str2, ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2, ActionResponseListener<String> actionResponseListener3) {
        DownloadController downloadController = this.mDownloadControllerMap.get(TextUtils.isEmpty(str2) ? MD5Utils.md5(str + "_main") : MD5Utils.md5(str + "_" + str2));
        if (downloadController != null) {
            downloadController.a(actionResponseListener, actionResponseListener2, actionResponseListener3);
        }
    }

    public void cancelAll() {
        for (DownloadController downloadController : this.mDownloadControllerMap.values()) {
            downloadController.d();
        }
        this.mDownloadControllerMap.clear();
        releaseInstance();
    }

    public void doQuery(String str, String str2, Bundle bundle, QueryTask.ExtraOperateListener extraOperateListener, ActionResponseListener<String> actionResponseListener) {
        if (TextUtils.isEmpty(str)) {
            ARLog.e("arkey cannot be null!!!");
            return;
        }
        String md5 = TextUtils.isEmpty(str2) ? MD5Utils.md5(str + "_main") : MD5Utils.md5(str + "_" + str2);
        DownloadController downloadController = this.mDownloadControllerMap.get(md5);
        if (downloadController != null) {
            if (downloadController.a()) {
                downloadController.b(actionResponseListener, null, null);
                return;
            }
            this.mDownloadControllerMap.remove(md5);
        }
        DownloadController downloadController2 = new DownloadController();
        downloadController2.a(this.mActivityResumed);
        HashMap hashMap = new HashMap();
        hashMap.put(DownloadConstants.QUERY_INFO, bundle);
        hashMap.put(DownloadConstants.QUERY_EXTRA_OPERATOR, extraOperateListener);
        hashMap.put(DownloadConstants.DOWNLOAD_SAVE_PATH, "");
        hashMap.put(DownloadConstants.FILE_STORE_STRATEGY, DownloadTask.FileStoreStrategy.SKIP);
        hashMap.put(DownloadConstants.USE_PARALLEL, false);
        hashMap.put(DownloadConstants.TARGET_PATH, "");
        hashMap.put(DownloadConstants.FILE_MERGE_STRATEGY, FileManageTask.FileMergeStrategy.SKIP);
        hashMap.put(DownloadConstants.FILE_MANAGE_EXTRA_OPERATOR, null);
        hashMap.put(DownloadConstants.QUERY_CALLBACK, actionResponseListener);
        hashMap.put(DownloadConstants.DOWNLOAD_CALLBACK, null);
        hashMap.put(DownloadConstants.FILE_MANAGE_CALLBACK, null);
        hashMap.put(DownloadConstants.DOWNLOAD_PARAMS_PARSER, null);
        downloadController2.a(DownloadController.EVENT.START_QUERY, hashMap);
        this.mDownloadControllerMap.put(md5, downloadController2);
    }

    public void downloadRes(String str, String str2, Bundle bundle, QueryTask.ExtraOperateListener extraOperateListener, IDownloadParamsParser iDownloadParamsParser, String str3, DownloadTask.FileStoreStrategy fileStoreStrategy, String str4, boolean z, FileManageTask.FileMergeStrategy fileMergeStrategy, FileManageTask.ExtraOperateListener extraOperateListener2, ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2, ActionResponseListener<String> actionResponseListener3) {
        if (TextUtils.isEmpty(str)) {
            ARLog.e("arkey cannot be null!!!");
            return;
        }
        String md5 = TextUtils.isEmpty(str2) ? MD5Utils.md5(str + "_main") : MD5Utils.md5(str + "_" + str2);
        DownloadController downloadController = this.mDownloadControllerMap.get(md5);
        if (downloadController != null) {
            if (downloadController.a()) {
                downloadController.b(actionResponseListener, actionResponseListener2, actionResponseListener3);
                return;
            }
            this.mDownloadControllerMap.remove(md5);
        }
        DownloadController downloadController2 = new DownloadController();
        downloadController2.a(this.mActivityResumed);
        HashMap hashMap = new HashMap();
        hashMap.put(DownloadConstants.QUERY_INFO, bundle);
        hashMap.put(DownloadConstants.QUERY_EXTRA_OPERATOR, extraOperateListener);
        hashMap.put(DownloadConstants.DOWNLOAD_SAVE_PATH, str3);
        hashMap.put(DownloadConstants.FILE_STORE_STRATEGY, fileStoreStrategy);
        hashMap.put(DownloadConstants.USE_PARALLEL, Boolean.valueOf(z));
        hashMap.put(DownloadConstants.TARGET_PATH, str4);
        hashMap.put(DownloadConstants.FILE_MERGE_STRATEGY, fileMergeStrategy);
        hashMap.put(DownloadConstants.FILE_MANAGE_EXTRA_OPERATOR, extraOperateListener2);
        hashMap.put(DownloadConstants.QUERY_CALLBACK, actionResponseListener);
        hashMap.put(DownloadConstants.DOWNLOAD_CALLBACK, actionResponseListener2);
        hashMap.put(DownloadConstants.FILE_MANAGE_CALLBACK, actionResponseListener3);
        hashMap.put(DownloadConstants.DOWNLOAD_PARAMS_PARSER, iDownloadParamsParser);
        downloadController2.a(DownloadController.EVENT.START_QUERY, hashMap);
        this.mDownloadControllerMap.put(md5, downloadController2);
    }

    public void downloadRes(String str, String str2, String str3, DownloadTask.FileStoreStrategy fileStoreStrategy, String str4, boolean z, FileManageTask.FileMergeStrategy fileMergeStrategy, FileManageTask.ExtraOperateListener extraOperateListener, ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2) {
        if (TextUtils.isEmpty(str2)) {
            ARLog.e("arkey cannot be null!!!");
            return;
        }
        String md5 = TextUtils.isEmpty(str) ? MD5Utils.md5(str2) : MD5Utils.md5(str + "_" + str2);
        DownloadController downloadController = this.mDownloadControllerMap.get(md5);
        if (downloadController != null) {
            if (downloadController.a()) {
                downloadController.b(null, actionResponseListener, actionResponseListener2);
                return;
            }
            this.mDownloadControllerMap.remove(md5);
        }
        DownloadController downloadController2 = new DownloadController();
        downloadController2.a(this.mActivityResumed);
        HashMap hashMap = new HashMap();
        hashMap.put(DownloadConstants.DOWNLOAD_URL, str2);
        hashMap.put(DownloadConstants.DOWNLOAD_SAVE_PATH, str3);
        hashMap.put(DownloadConstants.FILE_STORE_STRATEGY, fileStoreStrategy);
        hashMap.put(DownloadConstants.TARGET_PATH, str4);
        hashMap.put(DownloadConstants.USE_PARALLEL, Boolean.valueOf(z));
        hashMap.put(DownloadConstants.FILE_MERGE_STRATEGY, fileMergeStrategy);
        hashMap.put(DownloadConstants.FILE_MANAGE_EXTRA_OPERATOR, extraOperateListener);
        hashMap.put(DownloadConstants.DOWNLOAD_CALLBACK, actionResponseListener);
        hashMap.put(DownloadConstants.FILE_MANAGE_CALLBACK, actionResponseListener2);
        downloadController2.a(DownloadController.EVENT.START_DOWNLOAD, hashMap);
        this.mDownloadControllerMap.put(md5, downloadController2);
    }

    public void onActivityPaused() {
        this.mActivityResumed = false;
        setDownloadControllerMapResumed(false);
    }

    public void onActivityResumed() {
        this.mActivityResumed = true;
        setDownloadControllerMapResumed(true);
    }

    public void pause(String str, String str2) {
        DownloadController downloadController = this.mDownloadControllerMap.get(TextUtils.isEmpty(str2) ? MD5Utils.md5(str + "_main") : MD5Utils.md5(str + "_" + str2));
        if (downloadController != null) {
            downloadController.c();
        }
    }

    public void pauseAll() {
        for (DownloadController downloadController : this.mDownloadControllerMap.values()) {
            downloadController.c();
        }
    }

    public void resume(String str, String str2) {
        DownloadController downloadController = this.mDownloadControllerMap.get(TextUtils.isEmpty(str2) ? MD5Utils.md5(str + "_main") : MD5Utils.md5(str + "_" + str2));
        if (downloadController != null) {
            downloadController.b();
        }
    }

    public void resumeAll() {
        for (DownloadController downloadController : this.mDownloadControllerMap.values()) {
            downloadController.b();
        }
    }
}
