package com.baidu.searchbox.live.nps.util;

import android.util.Log;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
/* loaded from: classes4.dex */
public class PluginUtils {
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";

    public static boolean isLivenpsMatchMultiNps() {
        BundleInfo bundleByType;
        boolean z;
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
        if (bundleGroup == null || (bundleByType = bundleGroup.getBundleByType(3)) == null) {
            return false;
        }
        boolean isMainBundle = bundleByType.isMainBundle();
        boolean isMultiBundle = bundleByType.isMultiBundle();
        boolean isSubBundle = bundleByType.isSubBundle();
        Log.e("nps-multi-plugin", "PluginUtils-isLivenpsMatchMultiNps--isMultiBundle = " + isMultiBundle + ", isSubBundle = " + isSubBundle);
        if (bundleByType.getSubBundle() != null && bundleByType.getSubBundle().size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.e("nps-multi-plugin", "PluginUtils-isLivenpsMatchMultiNps--isMainBundle = " + isMainBundle + ", hasSubBundle = " + z);
        if (!isMainBundle || !z) {
            return false;
        }
        return true;
    }
}
