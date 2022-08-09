package com.baidu.searchbox.live.nps;

import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/nps/LiveNpsLoadHelper;", "", "getLiveNpsPluginWillLoadVersion", "()I", "", "NPS_PLUGIN_PKG_NAME", "Ljava/lang/String;", "<init>", "()V", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveNpsLoadHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final LiveNpsLoadHelper INSTANCE;
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1593311273, "Lcom/baidu/searchbox/live/nps/LiveNpsLoadHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1593311273, "Lcom/baidu/searchbox/live/nps/LiveNpsLoadHelper;");
                return;
            }
        }
        INSTANCE = new LiveNpsLoadHelper();
    }

    public LiveNpsLoadHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final int getLiveNpsPluginWillLoadVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (LiveMediaPluginManager.getInstance().isLoaded("com.baidu.searchbox.livenps")) {
                return LiveMediaPluginManager.getInstance().getInstallPluginVersion("com.baidu.searchbox.livenps");
            }
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
            BundleInfo bundleByType = bundleGroup != null ? bundleGroup.getBundleByType(1) : null;
            if (bundleByType != null && bundleByType.needForceUpdate()) {
                return bundleByType.getVersionCode();
            }
            BundleInfo bundleByType2 = bundleGroup != null ? bundleGroup.getBundleByType(2) : null;
            if (bundleByType2 != null) {
                return bundleByType2.getVersionCode();
            }
            BundleInfo bundleByType3 = bundleGroup != null ? bundleGroup.getBundleByType(3) : null;
            if (bundleByType3 != null) {
                return bundleByType3.getVersionCode();
            }
            if (bundleByType != null) {
                return bundleByType.getVersionCode();
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
