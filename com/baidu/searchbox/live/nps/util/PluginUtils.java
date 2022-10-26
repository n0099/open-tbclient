package com.baidu.searchbox.live.nps.util;

import android.util.Log;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PluginUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public transient /* synthetic */ FieldHolder $fh;

    public PluginUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isLivenpsMatchMultiNps() {
        InterceptResult invokeV;
        BundleInfo bundleByType;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
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
        return invokeV.booleanValue;
    }
}
