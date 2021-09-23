package c.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class z1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f31484h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31485a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f31486b;

    /* renamed from: c  reason: collision with root package name */
    public final y1 f31487c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f31488d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<s1> f31489e;

    /* renamed from: f  reason: collision with root package name */
    public final SharedPreferences f31490f;

    /* renamed from: g  reason: collision with root package name */
    public int f31491g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074064623, "Lc/b/a/z1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2074064623, "Lc/b/a/z1;");
                return;
            }
        }
        f31484h = new String[]{"channel", AsInstallService.SCHEME_PACKAGE_ADDED, "app_version"};
    }

    public z1(Context context, y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, y1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31489e = new ArrayList<>(32);
        this.f31491g = 0;
        this.f31486b = context;
        this.f31487c = y1Var;
        this.f31490f = y1Var.D();
        this.f31488d = new JSONObject();
        n0.d(this.f31486b);
    }

    public static void g(JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, jSONObject, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public static boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int length = str != null ? str.length() : 0;
            if (length < 13 || length > 128) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            boolean z = false;
            if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
                return false;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    z = true;
                    break;
                } else if (str.charAt(i2) != '0') {
                    break;
                } else {
                    i2++;
                }
            }
            return !z;
        }
        return invokeL.booleanValue;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? G().optString("user_unique_id", "") : (String) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? G().optString("clientudid", "") : (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? G().optString("openudid", "") : (String) invokeV.objValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String optString = G().optString("device_id", "");
            G().optString("install_id", "");
            if (s(optString)) {
                return this.f31490f.getInt("version_code", 0) == G().optInt("version_code", -1) ? 1 : 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? G().optLong("register_time", 0L) : invokeV.longValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? G().optString("ab_sdk_version", "") : (String) invokeV.objValue;
    }

    @NonNull
    public final JSONObject G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31488d : (JSONObject) invokeV.objValue;
    }

    @Nullable
    public <T> T a(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, t)) == null) {
            JSONObject G = G();
            Object obj = (G == null || (obj = G.opt(str)) == null) ? null : null;
            return obj == null ? t : (T) obj;
        }
        return (T) invokeLL.objValue;
    }

    public final String b(Set<String> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, set)) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f31485a) {
                return G();
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && m("ab_sdk_version", str)) {
            this.f31487c.s(str);
        }
    }

    public void e(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hashMap) == null) {
            JSONObject jSONObject = null;
            if (hashMap != null && !hashMap.isEmpty()) {
                try {
                    jSONObject = G().optJSONObject(SchedulerSupport.CUSTOM);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey())) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                } catch (JSONException e2) {
                    h0.b(e2);
                }
            }
            if (m(SchedulerSupport.CUSTOM, jSONObject)) {
                this.f31487c.z(jSONObject);
            }
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.f31487c.C(jSONObject);
            l(jSONObject);
        }
    }

    public final boolean h(s1 s1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, s1Var)) == null) {
            boolean z = !this.f31487c.S() && s1Var.f31446d;
            if (h0.f31368b) {
                h0.a("needSyncFromSub " + s1Var + " " + z, null);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean i(JSONObject jSONObject, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, jSONObject, str, str2, str3)) == null) {
            if (h0.f31368b) {
                h0.a("saveRegisterInfo, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONObject, null);
            }
            boolean s = s(str);
            boolean s2 = s(str2);
            try {
                boolean s3 = s(str3);
                int i2 = this.f31490f.getInt("version_code", 0);
                try {
                    int optInt = G().optInt("version_code", 0);
                    SharedPreferences.Editor edit = this.f31490f.edit();
                    if (i2 != optInt) {
                        edit.putInt("version_code", optInt);
                    }
                    if (s) {
                        long currentTimeMillis = System.currentTimeMillis();
                        edit.putLong("register_time", currentTimeMillis);
                        m("register_time", Long.valueOf(currentTimeMillis));
                    } else if (!s) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("response", jSONObject);
                        AppLog.onEventV3("tt_fetch_did_error", jSONObject2);
                    }
                    String optString = G().optString("device_id", "");
                    if (s && m("device_id", str)) {
                        edit.putString("device_id", str);
                        z = true;
                    } else {
                        z = false;
                    }
                    String optString2 = G().optString("install_id", "");
                    if (s2 && m("install_id", str2)) {
                        edit.putString("install_id", str2);
                        z = true;
                    }
                    String optString3 = G().optString("ssid", "");
                    if (s3 && m("ssid", str3)) {
                        edit.putString("ssid", str3);
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    AppLog.getDataObserver().onRemoteIdGet(z2, optString, str, optString2, str2, optString3, str3);
                    edit.apply();
                } catch (JSONException e2) {
                    e = e2;
                    h0.b(e);
                    if (s) {
                    }
                }
            } catch (JSONException e3) {
                e = e3;
            }
            return !s && s2;
        }
        return invokeLLLL.booleanValue;
    }

    @Nullable
    public JSONObject j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JSONObject c2 = c();
            if (c2 != null) {
                try {
                    String b2 = n0.b(c2.optJSONObject("oaid"));
                    if (!TextUtils.isEmpty(b2)) {
                        JSONObject jSONObject = new JSONObject();
                        i0.h(jSONObject, c2);
                        jSONObject.put("oaid", b2);
                        return jSONObject;
                    }
                } catch (Exception e2) {
                    h0.b(e2);
                }
            }
            return c2;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && m(com.alipay.sdk.cons.b.f35968b, str)) {
            this.f31487c.E(str);
        }
    }

    public final synchronized void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            synchronized (this) {
                if (jSONObject == null) {
                    h0.c("null abconfig", null);
                    return;
                }
                String optString = G().optString("ab_version");
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    Set<String> hashSet = new HashSet<>();
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            hashSet.add(str);
                        }
                    }
                    Iterator<String> keys = jSONObject.keys();
                    HashSet hashSet2 = new HashSet();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next instanceof String) {
                            String str2 = next;
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    hashSet2.add(jSONObject.getJSONObject(str2).optString(TiebaStatic.Params.VID));
                                } catch (JSONException e2) {
                                    h0.b(e2);
                                }
                            }
                        }
                    }
                    hashSet.retainAll(hashSet2);
                    m("ab_version", b(hashSet));
                }
            }
        }
    }

    public final boolean m(String str, Object obj) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, obj)) == null) {
            Object opt = G().opt(str);
            if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
                z = false;
            } else {
                synchronized (this) {
                    try {
                        JSONObject jSONObject = this.f31488d;
                        JSONObject jSONObject2 = new JSONObject();
                        i0.h(jSONObject2, jSONObject);
                        jSONObject2.put(str, obj);
                        this.f31488d = jSONObject2;
                    } catch (JSONException e2) {
                        h0.b(e2);
                    }
                }
                z = true;
            }
            h0.a("updateHeader, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + opt + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj, null);
            return z;
        }
        return invokeLL.booleanValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int optInt = this.f31485a ? G().optInt("version_code", -1) : -1;
            for (int i2 = 0; i2 < 3 && optInt == -1; i2++) {
                r();
                optInt = this.f31485a ? G().optInt("version_code", -1) : -1;
            }
            return optInt;
        }
        return invokeV.intValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && m("user_unique_id", str)) {
            this.f31487c.y(str);
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String optString = this.f31485a ? G().optString("app_version", null) : null;
            for (int i2 = 0; i2 < 3 && optString == null; i2++) {
                r();
                optString = this.f31485a ? G().optString("app_version", null) : null;
            }
            return optString;
        }
        return (String) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this.f31489e) {
                if (this.f31489e.size() == 0) {
                    this.f31489e.add(new t1());
                    this.f31489e.add(new w1(this.f31486b));
                    this.f31489e.add(new x1(this.f31486b, this.f31487c));
                    this.f31489e.add(new a(this.f31486b));
                    this.f31489e.add(new c(this.f31486b));
                    this.f31489e.add(new d(this.f31486b, this.f31487c));
                    this.f31489e.add(new e(this.f31486b));
                    this.f31489e.add(new g(this.f31486b));
                    this.f31489e.add(new h(this.f31486b, this.f31487c));
                    this.f31489e.add(new i());
                    this.f31489e.add(new j(this.f31487c));
                    this.f31489e.add(new k(this.f31486b));
                    this.f31489e.add(new l(this.f31486b));
                    this.f31489e.add(new m(this.f31486b, this.f31487c));
                    this.f31489e.add(new q1(this.f31486b, this.f31487c));
                    this.f31489e.add(new f(this.f31486b, this.f31487c));
                    this.f31489e.add(new v1(this.f31486b, this.f31487c));
                }
            }
            JSONObject G = G();
            JSONObject jSONObject = new JSONObject();
            i0.h(jSONObject, G);
            Iterator<s1> it = this.f31489e.iterator();
            boolean z = true;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                s1 next = it.next();
                if (!next.f31443a || next.f31445c || h(next)) {
                    try {
                        next.f31443a = next.b(jSONObject);
                    } catch (SecurityException e2) {
                        if (!next.f31444b) {
                            i2++;
                            h0.c("loadHeader, " + this.f31491g, e2);
                            if (!next.f31443a && this.f31491g > 10) {
                                next.f31443a = true;
                            }
                        }
                    } catch (JSONException e3) {
                        h0.b(e3);
                    }
                    if (!next.f31443a && !next.f31444b) {
                        i3++;
                    }
                }
                z &= next.f31443a || next.f31444b;
            }
            if (z) {
                int length = f31484h.length;
                for (int i4 = 0; i4 < length; i4++) {
                    z &= !TextUtils.isEmpty(jSONObject.optString(strArr[i4]));
                }
                String optString = jSONObject.optString("user_unique_id", null);
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        jSONObject.put("user_unique_id", optString);
                    } catch (JSONException unused) {
                    }
                }
            }
            this.f31488d = jSONObject;
            this.f31485a = z;
            if (h0.f31368b) {
                h0.a("loadHeader, " + this.f31485a + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f31491g + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f31488d.toString(), null);
            } else {
                h0.e("loadHeader, " + this.f31485a + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f31491g, null);
            }
            if (i2 > 0 && i2 == i3) {
                this.f31491g++;
                if (D() != 0) {
                    this.f31491g += 10;
                }
            }
            if (this.f31485a) {
                AppLog.getDataObserver().onIdLoaded(v(), y(), z());
            }
            return this.f31485a;
        }
        return invokeV.booleanValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? G().optString("user_unique_id", "") : (String) invokeV.objValue;
    }

    public synchronized void u(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            synchronized (this) {
                String optString = G().optString("ab_version");
                if (!TextUtils.isEmpty(optString)) {
                    for (String str2 : optString.split(",")) {
                        if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                            if (h0.f31368b) {
                                h0.a("addExposedVid ready added " + optString, null);
                            }
                            return;
                        }
                    }
                    str = optString + "," + str;
                }
                m("ab_version", str);
                this.f31487c.F(str);
                if (h0.f31368b) {
                    h0.a("addExposedVid " + str, null);
                }
            }
        }
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? G().optString("device_id", "") : (String) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? G().optString("aid", "") : (String) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? G().optString("udid", "") : (String) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? G().optString("install_id", "") : (String) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? G().optString("ssid", "") : (String) invokeV.objValue;
    }
}
