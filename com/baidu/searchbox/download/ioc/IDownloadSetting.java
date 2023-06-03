package com.baidu.searchbox.download.ioc;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.settings.base.UpdatePackageDownloadInfo;
import java.io.File;
/* loaded from: classes3.dex */
public interface IDownloadSetting {
    public static final IDownloadSetting EMPTY = new IDownloadSetting() { // from class: com.baidu.searchbox.download.ioc.IDownloadSetting.1
        @Override // com.baidu.searchbox.download.ioc.IDownloadSetting
        public void asyncInstallPatchPackage(Context context, long j, File file, UpdatePackageDownloadInfo updatePackageDownloadInfo) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadSetting
        public void clearFullUpdateDownloadInfo(Context context) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadSetting
        public void doDownloadedNormalStatistic() {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadSetting
        public void doInstallNormalStatistic() {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadSetting
        public UpdatePackageDownloadInfo getFullUpdateDownloadInfo(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadSetting
        public UpdatePackageDownloadInfo getUpdateDownloadInfo(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadSetting
        public void installClientUpdateApk(Context context, String str) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadSetting
        public boolean needPatch(Context context, Uri uri, UpdatePackageDownloadInfo updatePackageDownloadInfo) {
            return false;
        }
    };
    public static final String LOG_TAG = "IDownloadSetting";

    void asyncInstallPatchPackage(Context context, long j, File file, UpdatePackageDownloadInfo updatePackageDownloadInfo);

    void clearFullUpdateDownloadInfo(Context context);

    void doDownloadedNormalStatistic();

    void doInstallNormalStatistic();

    UpdatePackageDownloadInfo getFullUpdateDownloadInfo(Context context);

    UpdatePackageDownloadInfo getUpdateDownloadInfo(Context context);

    void installClientUpdateApk(Context context, String str);

    boolean needPatch(Context context, Uri uri, UpdatePackageDownloadInfo updatePackageDownloadInfo);

    /* loaded from: classes3.dex */
    public static final class Impl {
        public static IDownloadSetting sDownloadSetting = DownloadRuntime.getDownloadSetting();

        @NonNull
        public static IDownloadSetting get() {
            if (sDownloadSetting == null) {
                Log.w(IDownloadSetting.LOG_TAG, "Fetch IHomeFeed implementation failed, IHomeFeed.EMPTY applied");
                sDownloadSetting = IDownloadSetting.EMPTY;
            }
            return sDownloadSetting;
        }
    }
}
