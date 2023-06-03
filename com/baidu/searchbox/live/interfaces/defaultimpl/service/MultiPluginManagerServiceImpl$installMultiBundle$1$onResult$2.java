package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import com.baidu.nps.pm.BundleInfo;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginInstallCallback;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import java.io.File;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2", "com/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$PluginDownloadCallback", "", "pkgName", "", "downloadedSize", CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, "", "onProgress", "(Ljava/lang/String;JJ)V", "", "isSuc", "msg", "onResult", "(Ljava/lang/String;ZLjava/lang/String;)V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2 implements MultiPluginManagerServiceImpl.PluginDownloadCallback {
    public final /* synthetic */ BundleInfo $bkBundle;
    public final /* synthetic */ File $cacheDir;
    public final /* synthetic */ String $cacheFileName;
    public final /* synthetic */ String $completedFileName;
    public final /* synthetic */ MultiPluginManagerServiceImpl$installMultiBundle$1 this$0;

    public MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2(MultiPluginManagerServiceImpl$installMultiBundle$1 multiPluginManagerServiceImpl$installMultiBundle$1, File file, String str, String str2, BundleInfo bundleInfo) {
        this.this$0 = multiPluginManagerServiceImpl$installMultiBundle$1;
        this.$cacheDir = file;
        this.$cacheFileName = str;
        this.$completedFileName = str2;
        this.$bkBundle = bundleInfo;
    }

    @Override // com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl.PluginDownloadCallback
    public void onProgress(String str, long j, long j2) {
        MultiPluginInstallCallback multiPluginInstallCallback = this.this$0.$installCallback;
        if (multiPluginInstallCallback != null) {
            multiPluginInstallCallback.onProgress(str, j, j2);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl.PluginDownloadCallback
    public void onResult(String str, boolean z, String str2) {
        if (z) {
            File file = new File(this.$cacheDir, this.$cacheFileName);
            File file2 = new File(this.$cacheDir, this.$completedFileName);
            if (file.exists()) {
                file.renameTo(file2);
            }
            this.this$0.this$0.installLocalMultiBundle(this.$bkBundle, file2, new MultiPluginManagerServiceImpl.PluginInstallCallback() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2$onResult$1
                @Override // com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl.PluginInstallCallback
                public void onResult(String str3, int i, String str4) {
                    MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2.this.this$0.$installCallback.onResult(str3, false, i, str4);
                }
            });
            return;
        }
        this.this$0.$installCallback.onResult(str, false, -130, str2);
    }
}
