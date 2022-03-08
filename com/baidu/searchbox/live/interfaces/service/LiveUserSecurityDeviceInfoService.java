package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\u0007J%\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\u0007J%\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\u0007J\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000e\u0010\fJ%\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000f\u0010\u0007J\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0010\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "purpose", "getAndroidId", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getHarmonyVersion", "getIMEI", "getMacAddress", "getManufacturer", "(Ljava/lang/String;)Ljava/lang/String;", "getModel", "getOAID", "getOperator", "getOsVersion", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface LiveUserSecurityDeviceInfoService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic;
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(14630111, "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(14630111, "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_USER_SECURITY_DEVICE_INFO);
        }

        public Companion() {
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

        public final ServiceReference getSERVICE_REFERENCE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SERVICE_REFERENCE : (ServiceReference) invokeV.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ String getAndroidId$default(LiveUserSecurityDeviceInfoService liveUserSecurityDeviceInfoService, Context context, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = "";
                }
                return liveUserSecurityDeviceInfoService.getAndroidId(context, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAndroidId");
        }

        public static /* synthetic */ String getHarmonyVersion$default(LiveUserSecurityDeviceInfoService liveUserSecurityDeviceInfoService, Context context, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = "";
                }
                return liveUserSecurityDeviceInfoService.getHarmonyVersion(context, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHarmonyVersion");
        }

        public static /* synthetic */ String getIMEI$default(LiveUserSecurityDeviceInfoService liveUserSecurityDeviceInfoService, Context context, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = "";
                }
                return liveUserSecurityDeviceInfoService.getIMEI(context, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIMEI");
        }

        public static /* synthetic */ String getMacAddress$default(LiveUserSecurityDeviceInfoService liveUserSecurityDeviceInfoService, Context context, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = "";
                }
                return liveUserSecurityDeviceInfoService.getMacAddress(context, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMacAddress");
        }

        public static /* synthetic */ String getManufacturer$default(LiveUserSecurityDeviceInfoService liveUserSecurityDeviceInfoService, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                return liveUserSecurityDeviceInfoService.getManufacturer(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getManufacturer");
        }

        public static /* synthetic */ String getModel$default(LiveUserSecurityDeviceInfoService liveUserSecurityDeviceInfoService, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                return liveUserSecurityDeviceInfoService.getModel(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getModel");
        }

        public static /* synthetic */ String getOAID$default(LiveUserSecurityDeviceInfoService liveUserSecurityDeviceInfoService, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                return liveUserSecurityDeviceInfoService.getOAID(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOAID");
        }

        public static /* synthetic */ String getOperator$default(LiveUserSecurityDeviceInfoService liveUserSecurityDeviceInfoService, Context context, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = "";
                }
                return liveUserSecurityDeviceInfoService.getOperator(context, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOperator");
        }

        public static /* synthetic */ String getOsVersion$default(LiveUserSecurityDeviceInfoService liveUserSecurityDeviceInfoService, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                return liveUserSecurityDeviceInfoService.getOsVersion(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOsVersion");
        }
    }

    String getAndroidId(Context context, String str);

    String getHarmonyVersion(Context context, String str);

    String getIMEI(Context context, String str);

    String getMacAddress(Context context, String str);

    String getManufacturer(String str);

    String getModel(String str);

    String getOAID(String str);

    String getOperator(Context context, String str);

    String getOsVersion(String str);
}
