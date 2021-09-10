package c.a.p0.a.f1.e;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.e;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e<SelfT extends e<SelfT>> extends c.a.p0.a.f1.e.f.c<SelfT> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5690g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Pair<String, JSONObject> f5691f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-659569011, "Lc/a/p0/a/f1/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-659569011, "Lc/a/p0/a/f1/e/e;");
                return;
            }
        }
        f5690g = k.f7077a;
    }

    public e() {
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

    public SelfT A0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? (SelfT) w("last_start_timestamp", j2) : (SelfT) invokeJ.objValue;
    }

    public SelfT B0(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extensionCore)) == null) ? (SelfT) x("extensionCore", extensionCore) : (SelfT) invokeL.objValue;
    }

    public SelfT C0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) ? (SelfT) t("mExtraData", bundle) : (SelfT) invokeL.objValue;
    }

    public SelfT D0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            y("app_icon_url", str);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? G0(i2 | S()) : (SelfT) invokeI.objValue;
    }

    public SelfT E0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) ? (SelfT) s("swan_app_independent", z) : (SelfT) invokeZ.objValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? n("launch_app_download_url") : (String) invokeV.objValue;
    }

    public SelfT F0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            s("cts_launch_mode", z);
            return (SelfT) a();
        }
        return (SelfT) invokeZ.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? i("appFrameType") : invokeV.intValue;
    }

    public SelfT G0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? (SelfT) v("launchFlags", i2) : (SelfT) invokeI.objValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? o("mAppId", "") : (String) invokeV.objValue;
    }

    public SelfT H0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            y("mFromLast", T());
            return (SelfT) y("mFrom", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? n("mAppKey") : (String) invokeV.objValue;
    }

    public SelfT I0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? (SelfT) y("launch_id", str) : (SelfT) invokeL.objValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? n("launch_app_open_url") : (String) invokeV.objValue;
    }

    public SelfT J0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? (SelfT) y("launchScheme", str) : (SelfT) invokeL.objValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? n("mAppTitle") : (String) invokeV.objValue;
    }

    public SelfT K0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) ? (SelfT) s("local_debug_switch", z) : (SelfT) invokeZ.objValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? n("mClickId") : (String) invokeV.objValue;
    }

    public SelfT L0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? (SelfT) y("local_debug_ws_host", str) : (SelfT) invokeL.objValue;
    }

    public JSONObject M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            String W = W();
            Pair<String, JSONObject> pair = this.f5691f;
            if (pair != null && TextUtils.equals((CharSequence) pair.first, W)) {
                return (JSONObject) this.f5691f.second;
            }
            this.f5691f = null;
            if (TextUtils.isEmpty(W)) {
                this.f5691f = null;
                return null;
            }
            String queryParameter = Uri.parse(W).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    this.f5691f = new Pair<>(W, new JSONObject(queryParameter).optJSONObject("ext"));
                } catch (JSONException e2) {
                    if (f5690g) {
                        e2.printStackTrace();
                    }
                }
            }
            Pair<String, JSONObject> pair2 = this.f5691f;
            if (pair2 == null) {
                return null;
            }
            return (JSONObject) pair2.second;
        }
        return (JSONObject) invokeV.objValue;
    }

    public SelfT M0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? (SelfT) y("local_debug_ws_port", str) : (SelfT) invokeL.objValue;
    }

    public long N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? k("last_start_timestamp") : invokeV.longValue;
    }

    public SelfT N0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j2)) == null) {
            if (2147483648L != j2) {
                w("navigate_bar_color_key", j2);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeJ.objValue;
    }

    public ExtensionCore O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (ExtensionCore) m("extensionCore") : (ExtensionCore) invokeV.objValue;
    }

    public SelfT O0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? (SelfT) y("notInHistory", str) : (SelfT) invokeL.objValue;
    }

    public Bundle P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? f("mExtraData") : (Bundle) invokeV.objValue;
    }

    public SelfT P0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) ? (SelfT) v("appFrameOrientation", i2) : (SelfT) invokeI.objValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? n("app_icon_url") : (String) invokeV.objValue;
    }

    public SelfT Q0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? (SelfT) y("mPage", str) : (SelfT) invokeL.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? e("cts_launch_mode", false) : invokeV.booleanValue;
    }

    public SelfT R0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, pMSAppInfo)) == null) ? (SelfT) x("pms_db_info_onload", pMSAppInfo) : (SelfT) invokeL.objValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? j("launchFlags", 0) : invokeV.intValue;
    }

    public SelfT S0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) ? (SelfT) y("remoteDebugUrl", str) : (SelfT) invokeL.objValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? n("mFrom") : (String) invokeV.objValue;
    }

    public SelfT T0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) ? (SelfT) a() : (SelfT) invokeL.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? n("mFromLast") : (String) invokeV.objValue;
    }

    public SelfT U0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) ? (SelfT) y("swan_app_sub_root_path", str) : (SelfT) invokeL.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? n("launch_id") : (String) invokeV.objValue;
    }

    public SelfT V0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) ? (SelfT) a() : (SelfT) invokeL.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? n("launchScheme") : (String) invokeV.objValue;
    }

    public SelfT W0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048617, this, j2)) == null) ? (SelfT) a() : (SelfT) invokeJ.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? n("local_debug_ws_host") : (String) invokeV.objValue;
    }

    public SelfT X0(SwanCoreVersion swanCoreVersion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, swanCoreVersion)) == null) ? (SelfT) x("swanCoreVersion", swanCoreVersion) : (SelfT) invokeL.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? n("local_debug_ws_port") : (String) invokeV.objValue;
    }

    public SelfT Y0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) ? (SelfT) y("targetSwanVersion", str) : (SelfT) invokeL.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? n("max_swan_version") : (String) invokeV.objValue;
    }

    public SelfT Z0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) ? (SelfT) a() : (SelfT) invokeL.objValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? n("min_swan_version") : (String) invokeV.objValue;
    }

    public SelfT a1(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, pMSAppInfo)) == null) {
            if (pMSAppInfo != null) {
                x("pms_db_info_updated", pMSAppInfo);
                if (!k0()) {
                    R0(pMSAppInfo);
                }
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public long b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? l("navigate_bar_color_key", 2147483648L) : invokeV.longValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? n("notInHistory") : (String) invokeV.objValue;
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            int j2 = j("appFrameOrientation", -1);
            if (-1 < j2) {
                return j2;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? n("mPage") : (String) invokeV.objValue;
    }

    public PMSAppInfo f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? (PMSAppInfo) m("pms_db_info_onload") : (PMSAppInfo) invokeV.objValue;
    }

    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? n("remoteDebugUrl") : (String) invokeV.objValue;
    }

    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? n("swan_app_sub_root_path") : (String) invokeV.objValue;
    }

    public SwanCoreVersion i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? (SwanCoreVersion) m("swanCoreVersion") : (SwanCoreVersion) invokeV.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? n("targetSwanVersion") : (String) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? c("pms_db_info_onload") && f0() != null : invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? e("console_switch", false) : invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? e("mIsDebug", false) : invokeV.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? e("swan_app_independent", false) : invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? e("local_debug_switch", false) : invokeV.booleanValue;
    }

    public SelfT p0(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048640, this, str, j2)) == null) {
            r0().putLong(str, j2);
            return (SelfT) a();
        }
        return (SelfT) invokeLJ.objValue;
    }

    public SelfT q0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048641, this, str, str2)) == null) {
            if (str != null && str2 != null) {
                r0().putString(str, str2);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    @NonNull
    public Bundle r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            Bundle P = P();
            if (P == null) {
                Bundle bundle = new Bundle();
                C0(bundle);
                return bundle;
            }
            return P;
        }
        return (Bundle) invokeV.objValue;
    }

    public SelfT s0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, str)) == null) ? (SelfT) a() : (SelfT) invokeL.objValue;
    }

    public SelfT t0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i2)) == null) ? (SelfT) v("appFrameType", i2) : (SelfT) invokeI.objValue;
    }

    public SelfT u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, str)) == null) {
            y("mAppId", str);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT v0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, str)) == null) {
            y("mAppKey", str);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT w0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) {
            y("mAppTitle", str);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT x0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, str)) == null) ? (SelfT) y("mClickId", str) : (SelfT) invokeL.objValue;
    }

    public SelfT y0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048649, this, z)) == null) ? (SelfT) s("console_switch", z) : (SelfT) invokeZ.objValue;
    }

    public SelfT z0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048650, this, z)) == null) ? (SelfT) s("mIsDebug", z) : (SelfT) invokeZ.objValue;
    }
}
