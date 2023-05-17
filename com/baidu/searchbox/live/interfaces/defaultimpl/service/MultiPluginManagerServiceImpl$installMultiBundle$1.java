package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import android.app.Application;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginInstallCallback;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$installMultiBundle$1", "Lcom/baidu/nps/main/install/IInstallCallback;", "", "downloadedSize", CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, "", "onProgress", "(JJ)V", "", "retCode", "", "retMsg", "onResult", "(ILjava/lang/String;)V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MultiPluginManagerServiceImpl$installMultiBundle$1 implements IInstallCallback {
    public final /* synthetic */ MultiPluginInstallCallback $installCallback;
    public final /* synthetic */ String $pkgName;
    public final /* synthetic */ MultiPluginManagerServiceImpl this$0;

    public MultiPluginManagerServiceImpl$installMultiBundle$1(MultiPluginManagerServiceImpl multiPluginManagerServiceImpl, MultiPluginInstallCallback multiPluginInstallCallback, String str) {
        this.this$0 = multiPluginManagerServiceImpl;
        this.$installCallback = multiPluginInstallCallback;
        this.$pkgName = str;
    }

    @Override // com.baidu.nps.main.install.IInstallCallback
    public void onProgress(long j, long j2) {
        MultiPluginInstallCallback multiPluginInstallCallback = this.$installCallback;
        if (multiPluginInstallCallback != null) {
            multiPluginInstallCallback.onProgress(this.$pkgName, j, j2);
        }
    }

    @Override // com.baidu.nps.main.install.IInstallCallback
    public void onResult(int i, String str) {
        BundleInfo validBackupBundle;
        AppInfoService appInfoService;
        File file;
        String genBundleCacheFileName;
        String genBundleFileName;
        Application application;
        if (i == 13) {
            this.$installCallback.onResult(this.$pkgName, true, i, str);
        } else if (i == 3) {
            validBackupBundle = this.this$0.getValidBackupBundle(this.$pkgName);
            if (validBackupBundle == null) {
                this.$installCallback.onResult(this.$pkgName, false, i, str);
                return;
            }
            appInfoService = this.this$0.appService;
            if (appInfoService != null && (application = appInfoService.getApplication()) != null) {
                file = application.getCacheDir();
            } else {
                file = null;
            }
            File file2 = new File(file, "multi_bundle_cache");
            genBundleCacheFileName = this.this$0.genBundleCacheFileName(validBackupBundle);
            genBundleFileName = this.this$0.genBundleFileName(validBackupBundle);
            if (!new File(file2.getAbsolutePath(), genBundleFileName).exists()) {
                MultiPluginManagerServiceImpl multiPluginManagerServiceImpl = this.this$0;
                String str2 = this.$pkgName;
                String downloadUrl = validBackupBundle.getDownloadUrl();
                Intrinsics.checkExpressionValueIsNotNull(downloadUrl, "bkBundle.downloadUrl");
                String absolutePath = file2.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "cacheDir.absolutePath");
                multiPluginManagerServiceImpl.downloadBundleFile(str2, downloadUrl, absolutePath, genBundleCacheFileName, new MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2(this, file2, genBundleCacheFileName, genBundleFileName, validBackupBundle));
                return;
            }
            this.this$0.installLocalMultiBundle(validBackupBundle, new File(file2, genBundleFileName), new MultiPluginManagerServiceImpl.PluginInstallCallback() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$1
                @Override // com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl.PluginInstallCallback
                public void onResult(String str3, int i2, String str4) {
                    MultiPluginManagerServiceImpl$installMultiBundle$1.this.$installCallback.onResult(str3, false, i2, str4);
                }
            });
        } else {
            this.$installCallback.onResult(this.$pkgName, false, i, str);
        }
    }
}
