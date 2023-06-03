package com.baidu.searchbox.download.ioc;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface IDownloadDownloadCenter {
    public static final IDownloadDownloadCenter EMPTY = new IDownloadDownloadCenter() { // from class: com.baidu.searchbox.download.ioc.IDownloadDownloadCenter.1
        @Override // com.baidu.searchbox.download.ioc.IDownloadDownloadCenter
        public boolean checkTopActivityIsFileManagerOrDownloadList() {
            return false;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadDownloadCenter
        public Intent getDocCategoryActivityIntent(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadDownloadCenter
        public Intent getDownloadedCategorySecActivityIntent(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadDownloadCenter
        public Intent getPictureCategoryActivityIntent(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadDownloadCenter
        public void invokeCommonAppDownload() {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadDownloadCenter
        public void notifyPersonalCenter() {
        }
    };
    public static final String LOG_TAG = "IDownloadDownloadCenter";

    boolean checkTopActivityIsFileManagerOrDownloadList();

    Intent getDocCategoryActivityIntent(Context context);

    Intent getDownloadedCategorySecActivityIntent(Context context);

    Intent getPictureCategoryActivityIntent(Context context);

    void invokeCommonAppDownload();

    void notifyPersonalCenter();

    /* loaded from: classes3.dex */
    public static final class Impl {
        public static IDownloadDownloadCenter sIDownloadDownloadCenter = DownloadRuntime.getDownloadDownloadCenter();

        @NonNull
        public static IDownloadDownloadCenter get() {
            if (sIDownloadDownloadCenter == null) {
                Log.w(IDownloadDownloadCenter.LOG_TAG, "Fetch IDownloadCenter implementation failed, IDownloadCenter.EMPTY applied");
                sIDownloadDownloadCenter = IDownloadDownloadCenter.EMPTY;
            }
            return sIDownloadDownloadCenter;
        }
    }
}
