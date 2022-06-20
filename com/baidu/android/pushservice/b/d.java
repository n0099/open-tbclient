package com.baidu.android.pushservice.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.i;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.down.utils.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.core.diskCache.ImagesInvalidService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int d = 0;
    public static int f = -1;
    public static int g = -1;
    public static int h = -1;
    public static int i = -1;
    public static int j = -1;
    public static int k = -1;
    public static int l = -1;
    public static d m;
    public static String[] u;
    public transient /* synthetic */ FieldHolder $fh;
    public String e;
    public int n;
    public c o;
    public int p;
    public int q;
    public final String r;
    public final String s;
    public Map<String, c> t;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-677108474, "Lcom/baidu/android/pushservice/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-677108474, "Lcom/baidu/android/pushservice/b/d;");
                return;
            }
        }
        u = new String[]{"/default.prop", SnapshotConstant.DeviceFilePathConstants.DEVICE_BUILD_CONFIG, "/system/default.prop", "/data/local.prop"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updateconfig";
        this.p = 0;
        this.q = com.baidu.android.pushservice.a.a();
        this.r = CloudStabilityUBCUtils.KEY_RESPONSE_CODE;
        this.s = "responseResult";
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        e();
    }

    private c a(String str) {
        InterceptResult invokeL;
        c cVar;
        Map<String, c> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String upperCase = str.toUpperCase();
            if (!m.c(this.a, true).equalsIgnoreCase("unknown") || (map = this.t) == null) {
                Map<String, c> map2 = this.t;
                if (map2 != null && map2.containsKey(upperCase) && a(this.t.get(upperCase), upperCase)) {
                    cVar = this.t.get(upperCase);
                    return cVar;
                }
                return null;
            }
            for (Map.Entry<String, c> entry : map.entrySet()) {
                String key = entry.getKey();
                if (a(this.t.get(key), key)) {
                    cVar = this.t.get(key);
                    return cVar;
                }
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public static d a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (m == null) {
                synchronized (d.class) {
                    if (m == null) {
                        m = new d(context);
                    }
                }
            }
            return m;
        }
        return (d) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, hashMap)) == null) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            this.e = (g.f() ? g.a() : g.b()) + "/rest/3.0/clientfile/updateconf";
            int i2 = 2;
            do {
                com.baidu.android.pushservice.d.b b = com.baidu.android.pushservice.d.c.b(this.a, this.e, "POST", hashMap, "BCCS_SDK/3.0", g.c());
                if (b != null) {
                    int b2 = b.b();
                    hashMap2.put(CloudStabilityUBCUtils.KEY_RESPONSE_CODE, b2 + "");
                    hashMap2.put("responseResult", m.a(this.a, b.a()));
                    if (b2 == 200) {
                        return hashMap2;
                    }
                }
                i2--;
            } while (i2 > 0);
            return hashMap2;
        }
        return (HashMap) invokeL.objValue;
    }

    private void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, cVar) == null) {
            i.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", cVar != null ? cVar.toString() : "CONFIG_MANUFACTURER_DEFAULT");
            i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.n);
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, jSONObject) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data_sensitive");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("time_sensitive");
                JSONArray optJSONArray = jSONObject.optJSONArray("bind_attr");
                int optInt = jSONObject.optInt("click_data_size", -1);
                if (optInt != i.b(this.a, "click_data_size", -1) && optInt == -1) {
                    com.baidu.android.pushservice.c.c.g(this.a);
                }
                i.a(this.a, "click_data_size", optInt);
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        arrayList.add(next);
                        com.baidu.android.pushservice.c.c.a(this.a, next, 1, optJSONObject.getLong(next));
                    }
                }
                if (optJSONObject2 != null) {
                    Iterator<String> keys2 = optJSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        arrayList.add(next2);
                        com.baidu.android.pushservice.c.c.a(this.a, next2, 0, optJSONObject2.getLong(next2));
                    }
                }
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    optJSONArray = new JSONArray("[\"alert_freq\", \"bduss\", \"app_notify_status\"]");
                }
                com.baidu.android.pushservice.c.c.b(this.a, optJSONArray);
                com.baidu.android.pushservice.c.c.a(this.a, arrayList);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(c cVar, String str) {
        InterceptResult invokeLL;
        String str2;
        String str3;
        String z;
        String a2;
        String str4;
        int i2;
        int i3;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, cVar, str)) == null) {
            if (cVar != null && cVar.d() != null && cVar.d().size() > 0) {
                for (int i4 = 0; i4 < cVar.d().size(); i4++) {
                    e eVar = cVar.d().get(i4);
                    try {
                        z = m.z(this.a);
                        a2 = eVar.a();
                    } catch (Exception unused) {
                    }
                    if (eVar.b() == 0) {
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(z)) {
                            double d3 = 0.0d;
                            try {
                                d2 = Double.parseDouble(a2);
                                try {
                                    d3 = Double.parseDouble(z);
                                } catch (NumberFormatException unused2) {
                                }
                            } catch (NumberFormatException unused3) {
                                d2 = 0.0d;
                            }
                            if (d3 >= d2) {
                                return true;
                            }
                            str4 = "manufaturer can not Matched, osversion is not ABOVE ";
                        }
                    } else if (eVar.b() == 1) {
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(z)) {
                            try {
                                i2 = Integer.parseInt(a2);
                            } catch (NumberFormatException unused4) {
                                i2 = 0;
                            }
                            try {
                                i3 = Integer.parseInt(z);
                            } catch (NumberFormatException unused5) {
                                i3 = 0;
                                if (i3 != i2) {
                                }
                            }
                            if (i3 != i2) {
                                return true;
                            }
                            str4 = "manufaturer can not Matched, osversion is not EQUAL ";
                        }
                    } else if (eVar.b() != 2) {
                        continue;
                    } else if (Pattern.matches(a2, z)) {
                        return true;
                    } else {
                        str4 = "manufaturer can not Matched, osversion is not REGULAR ";
                    }
                    com.baidu.android.pushservice.f.a.a("ModeConfig", str4, this.a);
                }
            }
            if (cVar != null && cVar.e() != null && cVar.e().size() > 0) {
                for (int i5 = 0; i5 < cVar.e().size(); i5++) {
                    f fVar = cVar.e().get(i5);
                    try {
                        if (Build.VERSION.SDK_INT >= 28) {
                            str2 = SystemProperties.get(fVar.a());
                        } else {
                            Class<?> cls = Class.forName("android.os.SystemProperties");
                            str2 = (String) cls.getDeclaredMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).invoke(cls, fVar.a());
                        }
                        if (((str.equalsIgnoreCase("HUAWEI") && m.b()) || str.equalsIgnoreCase("HONOR")) && !m.t(this.a) && !str2.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.k(this.a)) {
                            str2 = Constants.SDK_VER;
                        }
                        if (str.equalsIgnoreCase("OPPO") && PushSettings.i(this.a) && !q(this.a)) {
                            str2 = "V1.0";
                        }
                        Matcher matcher = Pattern.compile(fVar.c()).matcher(str2);
                        if (matcher.find()) {
                            Double valueOf = Double.valueOf(str.equalsIgnoreCase("OPPO") ? matcher.group(1) : matcher.group());
                            Double valueOf2 = Double.valueOf(fVar.b());
                            if (fVar.d() == 0) {
                                if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                    return true;
                                }
                                str3 = "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ";
                            } else if (fVar.d() != 1) {
                                continue;
                            } else if (valueOf == valueOf2) {
                                return true;
                            } else {
                                str3 = "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ";
                            }
                            com.baidu.android.pushservice.f.a.a("ModeConfig", str3, this.a);
                        } else {
                            continue;
                        }
                    } catch (Throwable unused6) {
                    }
                }
            }
            if (cVar == null || cVar.h() != 1) {
                return false;
            }
            return (m.q(this.a) || m.r(this.a)) && q(this.a);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (k == -1) {
                k = i.b(context, "enable_newcid", 0);
            }
            return k == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (i == -1) {
                i = i.b(context, "enable_conn_for_proxy", 0);
            }
            return i == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            if (l == -1) {
                l = i.b(context, "enable_front_switch", 0);
            }
            return l == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            if (j == -1) {
                j = i.b(context, "bddns_enable", 1);
            }
            return !g.f() && j == 1;
        }
        return invokeL.booleanValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            try {
                return ((Integer) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("getDelayTime", new Class[0]).invoke(null, new Object[0])).intValue();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (h == -1) {
                h = (com.baidu.android.pushservice.a.a(context.getPackageName()) || i.b(context, "enable_single_conn", 1) == 1) ? 1 : 0;
            }
            return h == 1;
        }
        return invokeL.booleanValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? i.b(context, "push_bind_interval", 12) : invokeL.intValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                return ((Boolean) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            if (g()) {
                return new Random().nextInt(com.baidu.android.imsdk.internal.Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) + 10;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            if (f == -1) {
                f = i.b(context, "enable_stat_upload", 0);
            }
            return f == 1;
        }
        return invokeL.booleanValue;
    }

    public static int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) ? i.b(context, "stat_upload_interval", 6) : invokeL.intValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject(this.b);
                this.n = jSONObject.getInt("version");
                this.t = new HashMap();
                JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    c cVar = new c(this.a, jSONArray.getString(i2));
                    this.t.put(cVar.b(), cVar);
                }
                c a2 = a(m.c(this.a, true));
                this.o = a2;
                a(a2);
            } catch (Exception unused) {
            }
        }
    }

    public static List<String> j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            String a2 = i.a(context, "keep_alive_pkgs");
            if (!TextUtils.isEmpty(a2)) {
                try {
                    JSONArray jSONArray = new JSONArray(a2);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string = jSONArray.getString(i2);
                        if (!TextUtils.equals(context.getPackageName(), string)) {
                            arrayList.add(string);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            int b = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
            this.n = b;
            if (b == -1) {
                return false;
            }
            String a2 = i.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            if (a2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
                return true;
            }
            this.o = new c(this.a, a2);
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            if (System.currentTimeMillis() - i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > 604800000) {
                return true;
            }
            long b = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
            File file = new File(this.c);
            if (file.exists()) {
                long j2 = 0;
                if (b <= 0 || b != file.lastModified()) {
                    return true;
                }
                long b2 = i.b(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
                for (String str : u) {
                    File file2 = new File(str);
                    if (file2.exists()) {
                        j2 = (file2.lastModified() / 10) + j2;
                    }
                }
                return b2 != j2;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            try {
                if (s(context)) {
                    return a(context).b() == 7;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            File file = new File(this.c);
            if (file.exists()) {
                i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
                long j2 = 0;
                for (String str : u) {
                    File file2 = new File(str);
                    if (file2.exists()) {
                        j2 = (file2.lastModified() / 10) + j2;
                    }
                }
                i.b(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j2);
                i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
            }
        }
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            try {
                if (a(context).b() == 6) {
                    return t(context);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) ? u(context) && a(context).b() == 5 : invokeL.booleanValue;
    }

    public static boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            try {
                if (a(context).b() == 8 && PushSettings.i(context)) {
                    return Class.forName("com.heytap.mcssdk.PushManager") != null;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            try {
                if (p(context)) {
                    return i.b(context, "vi_push_proxy_mode", 0) == 1;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            try {
                if (v(context)) {
                    return a(context).b() == 9;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            try {
                Class.forName("com.heytap.mcssdk.PushService");
                Class.forName("com.heytap.mcssdk.PushManager");
                return PushManager.isSupportPush(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            switch (a(context).b()) {
                case 5:
                    return PushSettings.k(context);
                case 6:
                    return PushSettings.g(context);
                case 7:
                    return PushSettings.h(context);
                case 8:
                    return PushSettings.i(context);
                case 9:
                    return PushSettings.j(context);
                default:
                    return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
            try {
                if (m.n(context) && PushSettings.h(context)) {
                    return Class.forName("com.meizu.cloud.pushsdk.PushManager") != null;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            try {
                if (m.m(context) && PushSettings.g(context)) {
                    return Class.forName("com.xiaomi.mipush.sdk.MiPushClient") != null;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) ? m.o(context) && PushSettings.k(context) : invokeL.booleanValue;
    }

    public static boolean v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) {
            try {
                if (m.s(context) && PushSettings.j(context)) {
                    return Class.forName("com.vivo.push.PushClient") != null;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x013f */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
        if (java.lang.Float.parseFloat(r4) >= 4.0d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b2, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.0d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e2, code lost:
        if (java.lang.Float.parseFloat(r4) >= 6.0d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0111, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x013b, code lost:
        if (q(r12.a) != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0165 A[Catch: all -> 0x017b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:8:0x001e, B:10:0x002b, B:12:0x0033, B:14:0x003b, B:16:0x0047, B:81:0x013f, B:84:0x0153, B:87:0x0165, B:22:0x0055, B:24:0x005d, B:26:0x0065, B:28:0x006d, B:30:0x0079, B:34:0x0085, B:36:0x008d, B:38:0x0095, B:40:0x009d, B:42:0x00a9, B:46:0x00b5, B:48:0x00bd, B:50:0x00c5, B:52:0x00cd, B:54:0x00d9, B:58:0x00e6, B:60:0x00ee, B:62:0x00f6, B:64:0x00fe, B:66:0x010a, B:70:0x0115, B:72:0x011d, B:74:0x0125, B:76:0x012d, B:78:0x0135), top: B:98:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, a aVar) {
        long b;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048576, this, str, aVar) != null) {
            return;
        }
        synchronized (this) {
            long b2 = i.b(this.a, "cloud_update_config_time", 0) * 24 * 3600 * 1000;
            long j2 = 0;
            if (b2 <= 0) {
                b2 = ImagesInvalidService.FILE_VALID_TIME;
            }
            if (m.o(this.a) && PushSettings.k(this.a) && !m(this.a)) {
                if (!TextUtils.isEmpty(m.z(this.a))) {
                }
                j2 = b2;
            } else if (m.m(this.a) && PushSettings.g(this.a) && !l(this.a)) {
                if (!TextUtils.isEmpty(m.z(this.a))) {
                }
                j2 = b2;
            } else if (m.p(this.a) && PushSettings.i(this.a) && !n(this.a)) {
                if (!TextUtils.isEmpty(m.z(this.a))) {
                }
                j2 = b2;
            } else if (m.n(this.a) && PushSettings.h(this.a) && !k(this.a)) {
                if (!TextUtils.isEmpty(m.z(this.a))) {
                }
                j2 = b2;
            } else if (!m.s(this.a) || !PushSettings.j(this.a) || o(this.a)) {
                if ((m.q(this.a) || m.r(this.a)) && PushSettings.i(this.a) && !n(this.a)) {
                }
                b = i.b(this.a, "last_update_config_time");
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - b <= b2) {
                    com.baidu.android.pushservice.g.e.a().a(new com.baidu.android.pushservice.g.c(this, "ModeConfig-updateConfig", (short) 100, str, currentTimeMillis, aVar) { // from class: com.baidu.android.pushservice.b.d.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String a;
                        public final /* synthetic */ long b;
                        public final /* synthetic */ a c;
                        public final /* synthetic */ d d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9, Short.valueOf(r10), str, Long.valueOf(currentTimeMillis), aVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.d = this;
                            this.a = str;
                            this.b = currentTimeMillis;
                            this.c = aVar;
                        }

                        @Override // com.baidu.android.pushservice.g.c
                        public void a() {
                            JSONObject jSONObject;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    HashMap hashMap = new HashMap();
                                    com.baidu.android.pushservice.httpapi.b.a(this.d.a, hashMap);
                                    hashMap.put("version", this.d.n + "");
                                    hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                                    hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.a);
                                    hashMap.put("front_conn_avaliable", d.d + "");
                                    if ((m.o(this.d.a) && PushSettings.k(this.d.a)) || ((m.m(this.d.a) && PushSettings.g(this.d.a)) || ((m.n(this.d.a) && PushSettings.h(this.d.a)) || ((m.p(this.d.a) && PushSettings.i(this.d.a)) || (m.s(this.d.a) && PushSettings.j(this.d.a)))))) {
                                        hashMap.put("rom_version", m.z(this.d.a));
                                    }
                                    if ((m.q(this.d.a) || m.r(this.d.a)) && PushSettings.i(this.d.a)) {
                                        hashMap.put("rom_version", m.z(this.d.a));
                                        hashMap.put("support_proxy", d.q(this.d.a) ? "1" : "0");
                                    }
                                    hashMap.put("manufacture", m.c(this.d.a, false));
                                    hashMap.put("sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                                    hashMap.put("cuid", DeviceId.getCUID(this.d.a));
                                    hashMap.put("package_name", this.d.a.getPackageName());
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    HashMap a2 = this.d.a(hashMap);
                                    String str2 = (String) a2.get("responseResult");
                                    if (!TextUtils.isEmpty(str2) && (jSONObject = (JSONObject) new JSONObject(str2).get("response_params")) != null) {
                                        if (jSONObject.getInt("status") == 1) {
                                            String string = jSONObject.getString("sdkconfig");
                                            if (!TextUtils.isEmpty(string) && this.d.a(this.d.a, string)) {
                                                this.d.e();
                                            }
                                        }
                                        i.b(this.d.a, "last_update_config_time", this.b);
                                        int optInt = jSONObject.optInt("newcid", -1);
                                        if (optInt != -1) {
                                            int unused = d.k = optInt;
                                            i.a(this.d.a, "enable_newcid", optInt);
                                        }
                                        int optInt2 = jSONObject.optInt("mode", -1);
                                        if (optInt2 != -1) {
                                            int unused2 = d.i = optInt2;
                                            i.a(this.d.a, "enable_conn_for_proxy", optInt2);
                                        }
                                        int optInt3 = jSONObject.optInt("front_switch", -1);
                                        if (optInt3 != -1) {
                                            int unused3 = d.l = optInt3;
                                            i.a(this.d.a, "enable_front_switch", optInt3);
                                        }
                                        int optInt4 = jSONObject.optInt("enable_bddns", -1);
                                        if (optInt4 != -1) {
                                            int unused4 = d.j = optInt4;
                                            i.a(this.d.a, "bddns_enable", optInt4);
                                        }
                                        int optInt5 = jSONObject.optInt("single", -1);
                                        if (optInt5 != -1) {
                                            int unused5 = d.h = optInt5;
                                            i.a(this.d.a, "enable_single_conn", optInt5);
                                        }
                                        i.a(this.d.a, "cloud_update_config_time", jSONObject.optInt("update_time", 0));
                                        int optInt6 = jSONObject.optInt("bind_time", -1);
                                        if (optInt6 != -1) {
                                            i.a(this.d.a, "push_bind_interval", optInt6);
                                        }
                                        int optInt7 = jSONObject.optInt("stat", -1);
                                        if (optInt7 != -1) {
                                            int unused6 = d.f = optInt7;
                                            i.a(this.d.a, "enable_stat_upload", optInt7);
                                        }
                                        int optInt8 = jSONObject.optInt("stat_real_time", -1);
                                        if (optInt8 != -1) {
                                            int unused7 = d.g = optInt8;
                                            i.a(this.d.a, "enable_stat_real_time", optInt8);
                                        }
                                        int optInt9 = jSONObject.optInt("stat_time", -1);
                                        if (optInt9 != -1) {
                                            i.a(this.d.a, "stat_upload_interval", optInt9);
                                        }
                                        i.b(this.d.a, "keep_alive_pkgs", jSONObject.optString("keep_alive", null));
                                        i.a(this.d.a, "key_vip_type", jSONObject.optInt("vip_type", 3));
                                        JSONObject optJSONObject = jSONObject.optJSONObject("upload_control");
                                        if (optJSONObject != null) {
                                            this.d.a(optJSONObject);
                                        }
                                    }
                                    int parseInt = Integer.parseInt((String) a2.get(CloudStabilityUBCUtils.KEY_RESPONSE_CODE));
                                    new b.d(this.d.a).d(501001L).c(parseInt).a(currentTimeMillis2).b(System.currentTimeMillis()).a(this.d.e).c(parseInt != 200 ? str2 : "").a();
                                } catch (Exception unused8) {
                                }
                                a aVar2 = this.c;
                                if (aVar2 != null) {
                                    aVar2.a();
                                }
                            }
                        }
                    });
                    return;
                }
                if (aVar != null) {
                    com.baidu.android.pushservice.g.e.a().a(new com.baidu.android.pushservice.g.c(this, "updateConfig-local", (short) 99, aVar) { // from class: com.baidu.android.pushservice.b.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a a;
                        public final /* synthetic */ d b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9, Short.valueOf(r10), aVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.b = this;
                            this.a = aVar;
                        }

                        @Override // com.baidu.android.pushservice.g.c
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.a.a();
                            }
                        }
                    });
                }
                return;
            } else {
                if (!TextUtils.isEmpty(m.z(this.a))) {
                }
                j2 = b2;
            }
            b2 = j2;
            b = i.b(this.a, "last_update_config_time");
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b <= b2) {
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = this.o;
            if (cVar == null) {
                return true;
            }
            if (cVar.c() == 5) {
                this.p = 5;
                return true;
            } else if (this.o.c() == 6) {
                this.p = 6;
                return true;
            } else if (this.o.c() == 7) {
                this.p = 7;
                return true;
            } else if (this.o.c() == 8) {
                this.p = 8;
                return true;
            } else if (this.o.c() == 9) {
                this.p = 9;
                return true;
            } else {
                if (this.o.c() == 2 && !TextUtils.isEmpty(this.o.f())) {
                    try {
                        PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.o.f(), 16448);
                        if (packageInfo != null) {
                            int i2 = packageInfo.versionCode;
                            if ((this.o.a() != null && (this.o.a().b != -1 ? !(i2 < this.o.a().a || i2 > this.o.a().b) : i2 >= this.o.a().a)) && BaiduAppSSOJni.encodeBySha1(packageInfo.signatures[0].toByteArray()).equalsIgnoreCase(this.o.g())) {
                                this.q = m.g(this.a, this.o.f());
                                this.p = this.a.getPackageName().equalsIgnoreCase(this.o.f()) ? 3 : 4;
                                return true;
                            }
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        return false;
                    }
                }
                com.baidu.android.pushservice.f.a.a("ModeConfig", " Current Mode = " + this.p, this.a);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean k2 = k();
            boolean j2 = j();
            if ((k2 || !j2) && a()) {
                i();
            }
            if (this.o != null) {
                d();
            } else {
                com.baidu.android.pushservice.f.a.a("ModeConfig", "Config File Not Matched", this.a);
            }
        }
    }
}
