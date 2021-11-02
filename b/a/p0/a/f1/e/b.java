package b.a.p0.a.f1.e;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.c2.f.p0.j;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.k;
import b.a.p0.a.v2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f5048i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public long f5049h;

    /* loaded from: classes.dex */
    public static final class a extends b<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a G1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        @Override // b.a.p0.a.f1.e.b, b.a.p0.a.f1.e.e
        public /* bridge */ /* synthetic */ e O0(int i2) {
            return super.O0(i2);
        }

        @Override // b.a.p0.a.v2.e1.d
        public /* bridge */ /* synthetic */ b.a.p0.a.v2.e1.d a() {
            G1();
            return this;
        }

        @Override // b.a.p0.a.f1.e.b, b.a.p0.a.f1.e.e
        public /* bridge */ /* synthetic */ e t0(String str) {
            return super.t0(str);
        }

        @Override // b.a.p0.a.f1.e.b, b.a.p0.a.f1.e.f.c
        public /* bridge */ /* synthetic */ b.a.p0.a.f1.e.f.c update(Bundle bundle) {
            return super.update(bundle);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-149034927, "Lb/a/p0/a/f1/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-149034927, "Lb/a/p0/a/f1/e/b;");
                return;
            }
        }
        f5048i = k.f6397a;
    }

    public b() {
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

    public static b a1(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            boolean z = f5048i;
            return new a().update(intent);
        }
        return (b) invokeL.objValue;
    }

    public static String i1(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, swanAppConfigData)) == null) {
            if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
                return null;
            }
            String f2 = o0.f(str);
            if (b.a.p0.a.t1.b.a.e(f2)) {
                return o0.i(str, b.a.p0.a.c2.g.a.f4513b);
            }
            if (swanAppConfigData.o(j.b(f2))) {
                return str;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String j1(b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, swanAppConfigData)) == null) ? i1(u1(bVar.d0()), swanAppConfigData) : (String) invokeLL.objValue;
    }

    public static String k1(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, swanAppConfigData)) == null) {
            if (!TextUtils.isEmpty(str) && swanAppConfigData != null) {
                return i1(u1(l1(str)), swanAppConfigData);
            }
            if (f5048i) {
                String str2 = "getPageInfo ret null - " + str;
                return null;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String l1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parse = Uri.parse(str);
            String j = o0.j(parse);
            if (TextUtils.isEmpty(j)) {
                boolean z = f5048i;
                return null;
            }
            String n = o0.n(j, parse, true);
            if (TextUtils.isEmpty(n)) {
                boolean z2 = f5048i;
                return null;
            }
            String i2 = o0.i(parse.getEncodedQuery(), b.a.p0.a.c2.g.a.f4513b);
            if (f5048i) {
                String str2 = "query: " + i2;
            }
            if (!TextUtils.isEmpty(i2)) {
                n = n + "?" + i2;
            }
            if (f5048i) {
                String str3 = "launch path - " + n;
            }
            return n;
        }
        return (String) invokeL.objValue;
    }

    public static String u1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? (TextUtils.isEmpty(str) || !str.startsWith(File.separator)) ? str : str.substring(1) : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.f1.e.e
    /* renamed from: A1 */
    public SelfT O0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 != null) {
                e0.setOrientation(i2);
                return (SelfT) super.O0(i2);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT B1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 != null) {
                e0.serviceCategory = str;
                return (SelfT) super.S0(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    @Override // b.a.p0.a.f1.e.f.c
    public Bundle C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Bundle C = super.C();
            b.a.p0.a.e0.f.b.g(C);
            String G = G();
            if (!TextUtils.isEmpty(G)) {
                C.putString("mAppId", G);
            }
            return C;
        }
        return (Bundle) invokeV.objValue;
    }

    public SelfT C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 != null) {
                e0.subjectInfo = str;
                return (SelfT) super.U0(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT D1(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            if (this.f5049h < 1 && j > 0) {
                this.f5049h = j;
                return (SelfT) super.V0(j);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeJ.objValue;
    }

    public SelfT E1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            PMSAppInfo e0 = e0();
            if (!TextUtils.isEmpty(str) && e0 != null) {
                try {
                    e0.versionCode = Integer.parseInt(str);
                    return (SelfT) super.Y0(str);
                } catch (NumberFormatException e2) {
                    if (f5048i) {
                        e2.printStackTrace();
                    }
                }
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public String F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "SwanAppLaunchInfo{mAppId='" + G() + ExtendedMessageFormat.QUOTE + ", mAppKey='" + H() + ExtendedMessageFormat.QUOTE + ", mAppTitle='" + J() + ExtendedMessageFormat.QUOTE + ", pmsAppInfo is null='" + j0() + ExtendedMessageFormat.QUOTE + ", launchFrom='" + S() + ExtendedMessageFormat.QUOTE + ", launchScheme='" + V() + ExtendedMessageFormat.QUOTE + ", page='" + d0() + ExtendedMessageFormat.QUOTE + ", mErrorCode=" + c1() + ", mErrorDetail='" + d1() + ExtendedMessageFormat.QUOTE + ", mErrorMsg='" + e1() + ExtendedMessageFormat.QUOTE + ", mResumeDate='" + o1() + ExtendedMessageFormat.QUOTE + ", maxSwanVersion='" + Y() + ExtendedMessageFormat.QUOTE + ", minSwanVersion='" + Z() + ExtendedMessageFormat.QUOTE + ", mVersion='" + s1() + ExtendedMessageFormat.QUOTE + ", mType=" + getType() + ", extraData=" + O() + ", isDebug=" + l0() + ", isLocalDebug=" + n0() + ", targetSwanVersion='" + i0() + ExtendedMessageFormat.QUOTE + ", swanCoreVersion=" + h0() + ", appFrameType=" + F() + ", consoleSwitch=" + k0() + ", orientation=" + c0() + ", versionCode='" + t1() + ExtendedMessageFormat.QUOTE + ", launchFlags=" + R() + ", swanAppStartTime=" + r1() + ", extStartTimestamp=" + M() + ", remoteDebug='" + f0() + ExtendedMessageFormat.QUOTE + ", extJSonObject=" + L() + ", launchId=" + U() + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.f1.e.e
    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PMSAppInfo e0 = e0();
            return (e0 == null || TextUtils.isEmpty(e0.appId)) ? super.G() : e0.appId;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.f1.e.e
    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PMSAppInfo e0 = e0();
            return (e0 == null || TextUtils.isEmpty(e0.appKey)) ? super.H() : e0.appKey;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.f1.e.e
    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo e0 = e0();
            return (e0 == null || TextUtils.isEmpty(e0.appName)) ? super.J() : e0.appName;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.f1.e.e
    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            PMSAppInfo e0 = e0();
            return (e0 == null || TextUtils.isEmpty(e0.iconUrl)) ? super.P() : e0.iconUrl;
        }
        return (String) invokeV.objValue;
    }

    public String b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PMSAppInfo e0 = e0();
            return e0 == null ? "" : e0.description;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.f1.e.e
    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PMSAppInfo e0 = e0();
            int orientation = e0 == null ? -1 : e0.getOrientation();
            return -1 < orientation ? orientation : super.c0();
        }
        return invokeV.intValue;
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 == null) {
                return 0;
            }
            return e0.appStatus;
        }
        return invokeV.intValue;
    }

    public String d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            PMSAppInfo e0 = e0();
            return e0 == null ? "" : e0.statusDetail;
        }
        return (String) invokeV.objValue;
    }

    public String e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PMSAppInfo e0 = e0();
            return e0 == null ? "" : e0.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 == null) {
                return 0L;
            }
            return e0.pkgSize;
        }
        return invokeV.longValue;
    }

    public JSONObject g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String V = V();
            if (V != null) {
                String queryParameter = Uri.parse(V).getQueryParameter("_swaninfo");
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        return new JSONObject(queryParameter).optJSONObject("baidusearch");
                    } catch (JSONException e2) {
                        if (f5048i) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // b.a.p0.a.f1.e.e
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 == null) {
                return 0;
            }
            return e0.type;
        }
        return invokeV.intValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public SwanAppBearInfo h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 == null) {
                return null;
            }
            String str = e0.bearInfo;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new SwanAppBearInfo(str);
        }
        return (SwanAppBearInfo) invokeV.objValue;
    }

    public int m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PMSAppInfo e0 = e0();
            return e0 == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : e0.payProtected;
        }
        return invokeV.intValue;
    }

    public String n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 == null) {
                return null;
            }
            return e0.quickAppKey;
        }
        return (String) invokeV.objValue;
    }

    public String o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PMSAppInfo e0 = e0();
            return e0 == null ? "" : e0.resumeDate;
        }
        return (String) invokeV.objValue;
    }

    public String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PMSAppInfo e0 = e0();
            return e0 == null ? "" : e0.serviceCategory;
        }
        return (String) invokeV.objValue;
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            PMSAppInfo e0 = e0();
            return e0 == null ? "" : e0.subjectInfo;
        }
        return (String) invokeV.objValue;
    }

    public long r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f5049h : invokeV.longValue;
    }

    public String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PMSAppInfo e0 = e0();
            return e0 == null ? "" : String.valueOf(e0.versionCode);
        }
        return (String) invokeV.objValue;
    }

    public String t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            PMSAppInfo e0 = e0();
            return e0 == null ? "" : e0.versionName;
        }
        return (String) invokeV.objValue;
    }

    public SelfT v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 != null) {
                e0.description = str;
                return (SelfT) super.r0(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.f1.e.e
    /* renamed from: w1 */
    public SelfT t0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            super.t0(str);
            PMSAppInfo e0 = e0();
            if (e0 != null) {
                e0.appId = str;
                return (SelfT) super.t0(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT x1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 != null) {
                e0.appKey = str;
            }
            return (SelfT) super.u0(str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT y1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            PMSAppInfo e0 = e0();
            if (e0 != null) {
                e0.appName = str;
            }
            return (SelfT) super.v0(str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT z1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            super.C0(str);
            PMSAppInfo e0 = e0();
            if (e0 != null) {
                e0.iconUrl = str;
                return (SelfT) super.C0(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT update(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, intent)) == null) {
            if (intent == null) {
                return (SelfT) a();
            }
            update(intent.getExtras());
            if (d.a(intent)) {
                G0("1250000000000000");
                w("box_cold_launch", -1L);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.f1.e.f.c
    public SelfT update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bundle)) == null) {
            if (bundle == null) {
                return (SelfT) a();
            }
            b.a.p0.a.e0.f.b.h(bundle);
            b.a.p0.a.r1.j.e().h(bundle);
            super.update(bundle);
            if (TextUtils.isEmpty(bundle.getString("mPage"))) {
                A("mPage");
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }
}
