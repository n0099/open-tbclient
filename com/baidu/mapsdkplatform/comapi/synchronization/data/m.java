package com.baidu.mapsdkplatform.comapi.synchronization.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.synchronization.data.f;
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
public class m {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f42446a = "m";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f42447e = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.d.d f42448b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42449c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42450d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-178203682, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-178203682, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/m;");
        }
    }

    public m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42448b = new com.baidu.mapsdkplatform.comapi.synchronization.d.d();
        this.f42449c = true;
        this.f42450d = true;
        a(fVar);
    }

    private void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, fVar) == null) {
            this.f42448b.a("order_id", b(fVar));
            this.f42448b.a("company", fVar.c());
            this.f42448b.a("order_attr", fVar.b());
            this.f42448b.a("status", String.valueOf(fVar.h()));
            this.f42448b.a("pull_type", String.valueOf(fVar.i()));
            this.f42448b.a("route_finger", fVar.d());
            this.f42448b.a("traffic_finger", fVar.e());
            this.f42448b.a("pos_num", String.valueOf(fVar.j()));
            c(fVar);
            d(fVar);
            if (this.f42449c) {
                b();
            }
        }
    }

    private String b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, fVar)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(fVar.c().toLowerCase());
            stringBuffer.append("-");
            stringBuffer.append(fVar.a().toLowerCase());
            stringBuffer.append("-");
            stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
            String a2 = com.baidu.mapsdkplatform.comapi.synchronization.d.c.a(stringBuffer.toString());
            String str = f42446a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "The orderId = " + stringBuffer.toString() + "; result = " + a2);
            return a2;
        }
        return (String) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            String authToken = SyncSysInfo.getAuthToken();
            if (authToken == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42446a, "Token is null, permission check again");
                int permissionCheck = PermissionCheck.permissionCheck();
                if (permissionCheck != 0) {
                    String str = f42446a;
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Permission check result is: " + permissionCheck);
                }
                authToken = SyncSysInfo.getAuthToken();
            }
            this.f42448b.a("token", authToken);
        }
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? f42447e ? com.baidu.mapsdkplatform.comapi.synchronization.c.f.a() : com.baidu.mapsdkplatform.comapi.synchronization.c.f.b() : (String) invokeV.objValue;
    }

    private void c(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, fVar) == null) {
            f.b g2 = fVar.g();
            if (f.b.f42428a != g2 && f.b.f42429b == g2) {
                this.f42448b.a("trip_mode", "riding");
            } else {
                this.f42448b.a("trip_mode", "driving");
            }
        }
    }

    private void d(f fVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.d.d dVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, fVar) == null) {
            f.a f2 = fVar.f();
            if (f.a.f42425c != f2) {
                if (f.a.f42426d == f2) {
                    dVar = this.f42448b;
                    str = CoordinateType.BD09MC;
                } else if (f.a.f42423a == f2) {
                    dVar = this.f42448b;
                    str = CoordinateType.WGS84;
                } else if (f.a.f42424b == f2) {
                    dVar = this.f42448b;
                    str = "gcj02";
                }
                dVar.a("coord_type", str);
                return;
            }
            this.f42448b.a("coord_type", "bd09ll");
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer(this.f42448b.a());
            stringBuffer.append(SyncSysInfo.getPhoneInfo());
            if (this.f42450d) {
                String signMD5String = AppMD5.getSignMD5String(stringBuffer.toString());
                stringBuffer.append("&sign=");
                stringBuffer.append(signMD5String);
            }
            StringBuffer stringBuffer2 = new StringBuffer(c());
            stringBuffer2.append("?");
            stringBuffer2.append(stringBuffer);
            return stringBuffer2.toString();
        }
        return (String) invokeV.objValue;
    }
}
