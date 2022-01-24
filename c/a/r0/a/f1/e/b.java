package c.a.r0.a.f1.e;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.f2.f.o0.j;
import c.a.r0.a.k;
import c.a.r0.a.z2.g1.f;
import c.a.r0.a.z2.o0;
import com.baidu.android.imsdk.internal.Constants;
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
    public static final boolean f5971i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public long f5972h;

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

        public a J1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        @Override // c.a.r0.a.f1.e.b, c.a.r0.a.f1.e.e
        public /* bridge */ /* synthetic */ e Q0(int i2) {
            return super.Q0(i2);
        }

        @Override // c.a.r0.a.z2.g1.f
        public /* bridge */ /* synthetic */ f a() {
            J1();
            return this;
        }

        @Override // c.a.r0.a.f1.e.b, c.a.r0.a.f1.e.f.c
        public /* bridge */ /* synthetic */ c.a.r0.a.f1.e.f.c update(Bundle bundle) {
            return super.update(bundle);
        }

        @Override // c.a.r0.a.f1.e.b, c.a.r0.a.f1.e.e
        public /* bridge */ /* synthetic */ e v0(String str) {
            return super.v0(str);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401403666, "Lc/a/r0/a/f1/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-401403666, "Lc/a/r0/a/f1/e/b;");
                return;
            }
        }
        f5971i = k.a;
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

    public static b d1(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            boolean z = f5971i;
            return new a().update(intent);
        }
        return (b) invokeL.objValue;
    }

    public static String l1(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, swanAppConfigData)) == null) {
            if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
                return null;
            }
            String f2 = o0.f(str);
            if (c.a.r0.a.w1.c.a.k(f2)) {
                return o0.i(str, c.a.r0.a.f2.g.a.f6344b);
            }
            if (swanAppConfigData.p(j.b(f2))) {
                return str;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String m1(b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, swanAppConfigData)) == null) ? l1(x1(bVar.e0()), swanAppConfigData) : (String) invokeLL.objValue;
    }

    public static String n1(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, swanAppConfigData)) == null) {
            if (!TextUtils.isEmpty(str) && swanAppConfigData != null) {
                return l1(x1(o1(str)), swanAppConfigData);
            }
            if (f5971i) {
                String str2 = "getPageInfo ret null - " + str;
                return null;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String o1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parse = Uri.parse(str);
            String j2 = o0.j(parse);
            if (TextUtils.isEmpty(j2)) {
                boolean z = f5971i;
                return null;
            }
            String n = o0.n(j2, parse, true);
            if (TextUtils.isEmpty(n)) {
                boolean z2 = f5971i;
                return null;
            }
            String i2 = o0.i(parse.getEncodedQuery(), c.a.r0.a.f2.g.a.f6344b);
            if (f5971i) {
                String str2 = "query: " + i2;
            }
            if (!TextUtils.isEmpty(i2)) {
                n = n + "?" + i2;
            }
            if (f5971i) {
                String str3 = "launch path - " + n;
            }
            return n;
        }
        return (String) invokeL.objValue;
    }

    public static String x1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? (TextUtils.isEmpty(str) || !str.startsWith(File.separator)) ? str : str.substring(1) : (String) invokeL.objValue;
    }

    public SelfT A1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.appKey = str;
            }
            return (SelfT) super.w0(str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT B1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.appName = str;
            }
            return (SelfT) super.x0(str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            super.E0(str);
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.iconUrl = str;
                return (SelfT) super.E0(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    @Override // c.a.r0.a.f1.e.f.c
    public Bundle D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bundle D = super.D();
            c.a.r0.a.e0.f.b.g(D);
            String H = H();
            if (!TextUtils.isEmpty(H)) {
                D.putString("mAppId", H);
            }
            return D;
        }
        return (Bundle) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.f1.e.e
    /* renamed from: D1 */
    public SelfT Q0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.setOrientation(i2);
                return (SelfT) super.Q0(i2);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT E1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.serviceCategory = str;
                return (SelfT) super.U0(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT F1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.subjectInfo = str;
                return (SelfT) super.W0(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT G1(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
            if (this.f5972h < 1 && j2 > 0) {
                this.f5972h = j2;
                return (SelfT) super.Y0(j2);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeJ.objValue;
    }

    @Override // c.a.r0.a.f1.e.e
    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PMSAppInfo f0 = f0();
            return (f0 == null || TextUtils.isEmpty(f0.appId)) ? super.H() : f0.appId;
        }
        return (String) invokeV.objValue;
    }

    public SelfT H1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (!TextUtils.isEmpty(str) && f0 != null) {
                try {
                    f0.versionCode = Integer.parseInt(str);
                    return (SelfT) super.b1(str);
                } catch (NumberFormatException e2) {
                    if (f5971i) {
                        e2.printStackTrace();
                    }
                }
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    @Override // c.a.r0.a.f1.e.e
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PMSAppInfo f0 = f0();
            return (f0 == null || TextUtils.isEmpty(f0.appKey)) ? super.I() : f0.appKey;
        }
        return (String) invokeV.objValue;
    }

    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "SwanAppLaunchInfo{mAppId='" + H() + ExtendedMessageFormat.QUOTE + ", mAppKey='" + I() + ExtendedMessageFormat.QUOTE + ", mAppTitle='" + K() + ExtendedMessageFormat.QUOTE + ", pmsAppInfo is null='" + l0() + ExtendedMessageFormat.QUOTE + ", launchFrom='" + T() + ExtendedMessageFormat.QUOTE + ", launchScheme='" + W() + ExtendedMessageFormat.QUOTE + ", page='" + e0() + ExtendedMessageFormat.QUOTE + ", mErrorCode=" + f1() + ", mErrorDetail='" + g1() + ExtendedMessageFormat.QUOTE + ", mErrorMsg='" + h1() + ExtendedMessageFormat.QUOTE + ", mResumeDate='" + r1() + ExtendedMessageFormat.QUOTE + ", maxSwanVersion='" + Z() + ExtendedMessageFormat.QUOTE + ", minSwanVersion='" + a0() + ExtendedMessageFormat.QUOTE + ", mVersion='" + v1() + ExtendedMessageFormat.QUOTE + ", mType=" + getType() + ", extraData=" + P() + ", isDebug=" + n0() + ", isLocalDebug=" + p0() + ", targetSwanVersion='" + k0() + ExtendedMessageFormat.QUOTE + ", swanCoreVersion=" + j0() + ", appFrameType=" + G() + ", consoleSwitch=" + m0() + ", orientation=" + d0() + ", versionCode='" + w1() + ExtendedMessageFormat.QUOTE + ", launchFlags=" + S() + ", swanAppStartTime=" + u1() + ", extStartTimestamp=" + N() + ", remoteDebug='" + g0() + ExtendedMessageFormat.QUOTE + ", extJSonObject=" + M() + ", launchId=" + V() + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.f1.e.e
    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PMSAppInfo f0 = f0();
            return (f0 == null || TextUtils.isEmpty(f0.appName)) ? super.K() : f0.appName;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.f1.e.e
    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PMSAppInfo f0 = f0();
            return (f0 == null || TextUtils.isEmpty(f0.iconUrl)) ? super.Q() : f0.iconUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.f1.e.e
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            PMSAppInfo f0 = f0();
            int orientation = f0 == null ? -1 : f0.getOrientation();
            return -1 < orientation ? orientation : super.d0();
        }
        return invokeV.intValue;
    }

    public String e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PMSAppInfo f0 = f0();
            return f0 == null ? "" : f0.description;
        }
        return (String) invokeV.objValue;
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return 0;
            }
            return f0.appStatus;
        }
        return invokeV.intValue;
    }

    public String g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            PMSAppInfo f0 = f0();
            return f0 == null ? "" : f0.statusDetail;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.f1.e.e
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return 0;
            }
            return f0.type;
        }
        return invokeV.intValue;
    }

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PMSAppInfo f0 = f0();
            return f0 == null ? "" : f0.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    public long i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return 0L;
            }
            return f0.pkgSize;
        }
        return invokeV.longValue;
    }

    public JSONObject j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String W = W();
            if (W != null) {
                String queryParameter = Uri.parse(W).getQueryParameter("_swaninfo");
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        return new JSONObject(queryParameter).optJSONObject("baidusearch");
                    } catch (JSONException e2) {
                        if (f5971i) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public SwanAppBearInfo k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return null;
            }
            String str = f0.bearInfo;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new SwanAppBearInfo(str);
        }
        return (SwanAppBearInfo) invokeV.objValue;
    }

    public int p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PMSAppInfo f0 = f0();
            return f0 == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : f0.payProtected;
        }
        return invokeV.intValue;
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return null;
            }
            return f0.quickAppKey;
        }
        return (String) invokeV.objValue;
    }

    public String r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PMSAppInfo f0 = f0();
            return f0 == null ? "" : f0.resumeDate;
        }
        return (String) invokeV.objValue;
    }

    public String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PMSAppInfo f0 = f0();
            return f0 == null ? "" : f0.serviceCategory;
        }
        return (String) invokeV.objValue;
    }

    public String t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PMSAppInfo f0 = f0();
            return f0 == null ? "" : f0.subjectInfo;
        }
        return (String) invokeV.objValue;
    }

    public long u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f5972h : invokeV.longValue;
    }

    public String v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            PMSAppInfo f0 = f0();
            return f0 == null ? "" : String.valueOf(f0.versionCode);
        }
        return (String) invokeV.objValue;
    }

    public String w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PMSAppInfo f0 = f0();
            return f0 == null ? "" : f0.versionName;
        }
        return (String) invokeV.objValue;
    }

    public SelfT y1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.description = str;
                return (SelfT) super.t0(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.f1.e.e
    /* renamed from: z1 */
    public SelfT v0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            super.v0(str);
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.appId = str;
                return (SelfT) super.v0(str);
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
                I0("1250000000000000");
                x("box_cold_launch", -1L);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.f1.e.f.c
    public SelfT update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bundle)) == null) {
            if (bundle == null) {
                return (SelfT) a();
            }
            c.a.r0.a.e0.f.b.h(bundle);
            c.a.r0.a.u1.j.e().h(bundle);
            super.update(bundle);
            if (TextUtils.isEmpty(bundle.getString("mPage"))) {
                B("mPage");
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }
}
