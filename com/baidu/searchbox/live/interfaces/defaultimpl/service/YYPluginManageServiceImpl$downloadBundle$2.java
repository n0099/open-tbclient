package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import c.a.e0.f.a;
import c.a.e0.f.b;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "bundle", "Lcom/baidu/nps/pm/IBundleInfo;", "kotlin.jvm.PlatformType", "type", "", "listener", "Lcom/baidu/nps/plugin/IDownloadAuthorListener;", "checkAuthorization"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class YYPluginManageServiceImpl$downloadBundle$2 implements a {
    public static /* synthetic */ Interceptable $ic;
    public static final YYPluginManageServiceImpl$downloadBundle$2 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-623395256, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl$downloadBundle$2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-623395256, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl$downloadBundle$2;");
                return;
            }
        }
        INSTANCE = new YYPluginManageServiceImpl$downloadBundle$2();
    }

    public YYPluginManageServiceImpl$downloadBundle$2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.e0.f.a
    public final void checkAuthorization(IBundleInfo iBundleInfo, int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, iBundleInfo, i2, bVar) == null) {
            bVar.onResult(1);
        }
    }
}
