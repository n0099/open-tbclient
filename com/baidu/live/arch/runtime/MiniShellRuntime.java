package com.baidu.live.arch.runtime;

import android.app.Application;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.utils.MixUriUtilKt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b \u0010!J\u001d\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0014\u0010\u0013R\u001d\u0010\u0017\u001a\u00020\u00108F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\u0018\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0018\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/baidu/live/arch/runtime/MiniShellRuntime;", "", ILiveNPSPlugin.PARAMS_ROOM_ID, "source", "buildLiveScheme", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/app/Application;", "appApplication", "Landroid/app/Application;", "getAppApplication", "()Landroid/app/Application;", "Landroid/content/Context;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "", "isDebug", "Z", "()Z", "isMobileBaidu", "isNps$delegate", "Lkotlin/Lazy;", "isNps", "isTieba", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "service", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "getService", "()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "setService", "(Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;)V", "<init>", "()V", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MiniShellRuntime {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic;
    public static final MiniShellRuntime INSTANCE;
    public static final Application appApplication;
    public static final Context appContext;
    public static final boolean isDebug;
    public static final boolean isMobileBaidu;
    public static final Lazy isNps$delegate;
    public static final boolean isTieba;
    public static AppInfoService service;
    public transient /* synthetic */ FieldHolder $fh;

    public final boolean isNps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Lazy lazy = isNps$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return ((Boolean) lazy.getValue()).booleanValue();
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        Boolean bool;
        String str;
        String str2;
        Application application;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1541994305, "Lcom/baidu/live/arch/runtime/MiniShellRuntime;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1541994305, "Lcom/baidu/live/arch/runtime/MiniShellRuntime;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MiniShellRuntime.class), "isNps", "isNps()Z"))};
        INSTANCE = new MiniShellRuntime();
        Object service2 = ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        Intrinsics.checkExpressionValueIsNotNull(service2, "ServiceManager.getServic…panion.SERVICE_REFERENCE)");
        AppInfoService appInfoService = (AppInfoService) service2;
        service = appInfoService;
        Application application2 = null;
        if (appInfoService != null) {
            bool = Boolean.valueOf(appInfoService.isDebug());
        } else {
            bool = null;
        }
        isDebug = bool.booleanValue();
        AppInfoService appInfoService2 = service;
        if (appInfoService2 != null) {
            str = appInfoService2.getLiveAppId();
        } else {
            str = null;
        }
        isMobileBaidu = "mobilebaidu".equals(str);
        AppInfoService appInfoService3 = service;
        if (appInfoService3 != null) {
            str2 = appInfoService3.getLiveAppId();
        } else {
            str2 = null;
        }
        isTieba = "tieba".equals(str2);
        AppInfoService appInfoService4 = service;
        if (appInfoService4 != null) {
            application = appInfoService4.getApplication();
        } else {
            application = null;
        }
        appApplication = application;
        AppInfoService appInfoService5 = service;
        if (appInfoService5 != null) {
            application2 = appInfoService5.getApplication();
        }
        appContext = application2;
        isNps$delegate = LazyKt__LazyJVMKt.lazy(MiniShellRuntime$isNps$2.INSTANCE);
    }

    public MiniShellRuntime() {
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

    public final Application getAppApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return appApplication;
        }
        return (Application) invokeV.objValue;
    }

    public final Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return appContext;
        }
        return (Context) invokeV.objValue;
    }

    public final AppInfoService getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return service;
        }
        return (AppInfoService) invokeV.objValue;
    }

    public final boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return isDebug;
        }
        return invokeV.booleanValue;
    }

    public final boolean isMobileBaidu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return isMobileBaidu;
        }
        return invokeV.booleanValue;
    }

    public final boolean isTieba() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return isTieba;
        }
        return invokeV.booleanValue;
    }

    public final String buildLiveScheme(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            return MixUriUtilKt.buildScheme(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public final void setService(AppInfoService appInfoService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, appInfoService) == null) {
            service = appInfoService;
        }
    }
}
