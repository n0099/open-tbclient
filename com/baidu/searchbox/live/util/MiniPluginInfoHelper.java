package com.baidu.searchbox.live.util;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR%\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00010\u00010\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0003¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/live/util/MiniPluginInfoHelper;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "getPluginInvokeService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "", "getSdkName", "()Ljava/lang/String;", "pkgName", "", "getVersionCode", "(Ljava/lang/String;)I", "getVersionName", "(Ljava/lang/String;)Ljava/lang/String;", "MEDIA_TOP_PLUGIN_PKG_NAME", "Ljava/lang/String;", "YY_TOP_PLUGIN_PKG_NAME", "kotlin.jvm.PlatformType", "pluginManagerService$delegate", "Lkotlin/Lazy;", "getPluginManagerService", "pluginManagerService", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MiniPluginInfoHelper {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final MiniPluginInfoHelper INSTANCE;
    public static final String MEDIA_TOP_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String YY_TOP_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static final Lazy pluginManagerService$delegate;
    public transient /* synthetic */ FieldHolder $fh;

    private final PluginInvokeService getPluginManagerService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Lazy lazy = pluginManagerService$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (PluginInvokeService) lazy.getValue();
        }
        return (PluginInvokeService) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1130608815, "Lcom/baidu/searchbox/live/util/MiniPluginInfoHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1130608815, "Lcom/baidu/searchbox/live/util/MiniPluginInfoHelper;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MiniPluginInfoHelper.class), "pluginManagerService", "getPluginManagerService()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;"))};
        INSTANCE = new MiniPluginInfoHelper();
        pluginManagerService$delegate = LazyKt__LazyJVMKt.lazy(MiniPluginInfoHelper$pluginManagerService$2.INSTANCE);
    }

    public MiniPluginInfoHelper() {
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

    public final PluginInvokeService getPluginInvokeService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getPluginManagerService();
        }
        return (PluginInvokeService) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v1 int), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v1 int), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    public final String getSdkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int versionCode = getVersionCode("com.baidu.searchbox.livenps");
            StringBuilder sb = new StringBuilder();
            int i = versionCode / 100000000;
            int i2 = versionCode % 100000000;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(IStringUtil.EXTENSION_SEPARATOR);
            sb.append(sb2.toString());
            int i3 = i2 / 1000000;
            int i4 = i2 % 1000000;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i3);
            sb3.append(IStringUtil.EXTENSION_SEPARATOR);
            sb.append(sb3.toString());
            int i5 = i4 / 100000;
            int i6 = i4 % 100000;
            sb.append(String.valueOf(i5));
            String sb4 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb4, "versionNameBuilder.toString()");
            return sb4;
        }
        return (String) invokeV.objValue;
    }

    public final int getVersionCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            PluginInvokeService pluginManagerService = getPluginManagerService();
            if (pluginManagerService != null) {
                return pluginManagerService.getPluginVersionCode(str);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v1 int), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v1 int), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0051: ARITH  (r1v11 int A[REMOVE]) = (r5v4 int) / (1000 int)), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    public final String getVersionName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            int versionCode = getVersionCode(str);
            StringBuilder sb = new StringBuilder();
            int i = versionCode / 100000000;
            int i2 = versionCode % 100000000;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(IStringUtil.EXTENSION_SEPARATOR);
            sb.append(sb2.toString());
            int i3 = i2 / 1000000;
            int i4 = i2 % 1000000;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i3);
            sb3.append(IStringUtil.EXTENSION_SEPARATOR);
            sb.append(sb3.toString());
            int i5 = i4 / 100000;
            int i6 = i4 % 100000;
            sb.append(String.valueOf(i5));
            sb.append(".");
            StringBuilder sb4 = new StringBuilder();
            sb4.append(i6 / 1000);
            sb4.append(IStringUtil.EXTENSION_SEPARATOR);
            sb.append(sb4.toString());
            sb.append(i6 % 1000);
            String sb5 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb5, "versionNameBuilder.toString()");
            return sb5;
        }
        return (String) invokeL.objValue;
    }
}
