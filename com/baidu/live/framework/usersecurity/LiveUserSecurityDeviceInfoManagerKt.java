package com.baidu.live.framework.usersecurity;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a!\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0005\u001a!\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0005\u001a\u0019\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\n\u001a\u0019\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\n\u001a!\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u0005\u001a\u0019\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\n\u001a\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011\"%\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroid/content/Context;", "context", "", "purpose", "getAndroidId", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getHarmonyVersion", "getIMEI", "getMacAddress", "getManufacturer", "(Ljava/lang/String;)Ljava/lang/String;", "getModel", "getOAID", "getOperator", "getOsVersion", "", "isDeviceInfoServiceAvailable", "()Z", "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;", "kotlin.jvm.PlatformType", "service$delegate", "Lkotlin/Lazy;", "getService", "()Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;", "service", "lib-live-feed-page_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveUserSecurityDeviceInfoManagerKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Lazy a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(266001502, "Lcom/baidu/live/framework/usersecurity/LiveUserSecurityDeviceInfoManagerKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(266001502, "Lcom/baidu/live/framework/usersecurity/LiveUserSecurityDeviceInfoManagerKt;");
                return;
            }
        }
        a = LazyKt__LazyJVMKt.lazy(LiveUserSecurityDeviceInfoManagerKt$service$2.INSTANCE);
    }

    public static final String a(String str) {
        InterceptResult invokeL;
        String manufacturer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            LiveUserSecurityDeviceInfoService c = c();
            return (c == null || (manufacturer = c.getManufacturer(str)) == null) ? "" : manufacturer;
        }
        return (String) invokeL.objValue;
    }

    public static /* synthetic */ String b(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return a(str);
    }

    public static final LiveUserSecurityDeviceInfoService c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LiveUserSecurityDeviceInfoService) a.getValue() : (LiveUserSecurityDeviceInfoService) invokeV.objValue;
    }

    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c() != null : invokeV.booleanValue;
    }
}
