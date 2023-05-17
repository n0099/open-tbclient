package com.baidu.searchbox.live.nps;

import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/nps/LiveNpsLoadHelper;", "", "getLiveNpsPluginWillLoadVersion", "()I", "", "NPS_PLUGIN_PKG_NAME", "Ljava/lang/String;", "<init>", "()V", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveNpsLoadHelper {
    public static final LiveNpsLoadHelper INSTANCE = new LiveNpsLoadHelper();
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";

    public final int getLiveNpsPluginWillLoadVersion() {
        BundleInfo bundleInfo;
        BundleInfo bundleInfo2;
        if (LiveMediaPluginManager.getInstance().isLoaded("com.baidu.searchbox.livenps")) {
            return LiveMediaPluginManager.getInstance().getInstallPluginVersion("com.baidu.searchbox.livenps");
        }
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
        BundleInfo bundleInfo3 = null;
        if (bundleGroup != null) {
            bundleInfo = bundleGroup.getBundleByType(1);
        } else {
            bundleInfo = null;
        }
        if (bundleInfo != null && bundleInfo.needForceUpdate()) {
            return bundleInfo.getVersionCode();
        }
        if (bundleGroup != null) {
            bundleInfo2 = bundleGroup.getBundleByType(2);
        } else {
            bundleInfo2 = null;
        }
        if (bundleInfo2 != null) {
            return bundleInfo2.getVersionCode();
        }
        if (bundleGroup != null) {
            bundleInfo3 = bundleGroup.getBundleByType(3);
        }
        if (bundleInfo3 != null) {
            return bundleInfo3.getVersionCode();
        }
        if (bundleInfo != null) {
            return bundleInfo.getVersionCode();
        }
        return 0;
    }
}
