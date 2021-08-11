package com.baidu.mapsdkplatform.comapi.synchronization.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f42131a = "f";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f42132c = true;

    /* renamed from: d  reason: collision with root package name */
    public static int f42133d = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.d.d f42134b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-879695017, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-879695017, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/f;");
        }
    }

    public f(HistoryTraceQueryOptions historyTraceQueryOptions) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {historyTraceQueryOptions};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42134b = new com.baidu.mapsdkplatform.comapi.synchronization.d.d();
        a(historyTraceQueryOptions);
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            f42133d = i2;
        }
    }

    private void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, historyTraceQueryOptions) == null) {
            this.f42134b.a("order_id", b(historyTraceQueryOptions));
            this.f42134b.a("original_order_id", historyTraceQueryOptions.getOrderId().toLowerCase());
            this.f42134b.a("company", historyTraceQueryOptions.getUserId());
            this.f42134b.a("order_attr", historyTraceQueryOptions.getDriverId());
            this.f42134b.a("track_status", String.valueOf(historyTraceQueryOptions.getQueryOrderState()));
            this.f42134b.a("status", String.valueOf(historyTraceQueryOptions.getCurrentOrderState()));
            if (CoordType.BD09LL != SDKInitializer.getCoordType() && CoordType.GCJ02 == SDKInitializer.getCoordType()) {
                this.f42134b.a("coord_type", "gcj02");
            } else {
                this.f42134b.a("coord_type", "bd09ll");
            }
            this.f42134b.a("page_index", String.valueOf(f42133d));
            f42133d = 1;
            this.f42134b.a("page_size", "5000");
            this.f42134b.a("is_processed", "1");
            b();
        }
    }

    private String b(HistoryTraceQueryOptions historyTraceQueryOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, historyTraceQueryOptions)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(historyTraceQueryOptions.getUserId().toLowerCase());
            stringBuffer.append("-");
            stringBuffer.append(historyTraceQueryOptions.getOrderId().toLowerCase());
            stringBuffer.append("-");
            stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
            String a2 = com.baidu.mapsdkplatform.comapi.synchronization.d.c.a(stringBuffer.toString());
            String str = f42131a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "The orderId = " + stringBuffer.toString() + "; result = " + a2);
            return a2;
        }
        return (String) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            String authToken = SyncSysInfo.getAuthToken();
            if (authToken == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42131a, "Token is null, permission check again");
                int permissionCheck = PermissionCheck.permissionCheck();
                if (permissionCheck != 0) {
                    String str = f42131a;
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Permission check result is: " + permissionCheck);
                    return;
                }
                authToken = SyncSysInfo.getAuthToken();
            }
            this.f42134b.a("token", authToken);
        }
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? f42132c ? g.a() : g.b() : (String) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer(this.f42134b.a());
            stringBuffer.append(SyncSysInfo.getPhoneInfo());
            String signMD5String = AppMD5.getSignMD5String(stringBuffer.toString());
            stringBuffer.append("&sign=");
            stringBuffer.append(signMD5String);
            StringBuffer stringBuffer2 = new StringBuffer(c());
            stringBuffer2.append("?");
            stringBuffer2.append(stringBuffer);
            return stringBuffer2.toString();
        }
        return (String) invokeV.objValue;
    }
}
