package com.baidu.searchbox.download.lightdownload;

import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.lightdownload.callback.ILightDownloadListener;
import com.baidu.searchbox.download.lightdownload.error.LightDownloadError;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class LightDownloadManager {
    public static void downloadOnIOThread(final String str, final File file, final ILightDownloadListener iLightDownloadListener) {
        ExecutorUtilsExt.getElasticExecutor("downloadResource", 2).execute(new Runnable() { // from class: com.baidu.searchbox.download.lightdownload.LightDownloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                LightDownloadManager.doDownload(str, file, iLightDownloadListener);
            }
        });
    }

    public static void doDownload(String str, final File file, final ILightDownloadListener iLightDownloadListener) {
        if (!TextUtils.isEmpty(str) && HttpUrl.parse(str) != null) {
            try {
                Response executeSync = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(str).enableStat(true).requestFrom(10).requestSubFrom(1022).build().executeSync();
                if (executeSync != null) {
                    if (executeSync.code() == 200) {
                        final String string = executeSync.body().string();
                        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.lightdownload.LightDownloadManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (FileUtils.createNewFileSafely(file)) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes());
                                    FileUtils.saveToFile(byteArrayInputStream, file);
                                    Closeables.closeSafely(byteArrayInputStream);
                                    iLightDownloadListener.onSuccess();
                                    return;
                                }
                                iLightDownloadListener.onFail(new LightDownloadError());
                            }
                        }, "saveDownloadResource", 2);
                    } else {
                        iLightDownloadListener.onFail(new LightDownloadError());
                    }
                } else {
                    iLightDownloadListener.onFail(new LightDownloadError());
                }
                return;
            } catch (IOException e) {
                iLightDownloadListener.onFail(new LightDownloadError());
                e.printStackTrace();
                return;
            }
        }
        iLightDownloadListener.onFail(new LightDownloadError());
    }

    public static void tryDownloadFile(String str, String str2, String str3, ILightDownloadListener iLightDownloadListener) {
        String filePathByUrl = LightFileUtils.getFilePathByUrl(str, str2);
        if (TextUtils.isEmpty(filePathByUrl)) {
            iLightDownloadListener.onFail(new LightDownloadError());
            return;
        }
        LightFileCache.getInstance().storeChecksumByUrl(str, str3);
        File file = new File(filePathByUrl);
        if (!file.exists()) {
            downloadOnIOThread(str, file, iLightDownloadListener);
        } else if (!TextUtils.equals(String.valueOf(LightFileUtils.checkCrcFile(file)), str3)) {
            FileUtils.deleteFile(file);
            downloadOnIOThread(str, file, iLightDownloadListener);
        } else {
            iLightDownloadListener.onSuccess();
        }
    }
}
