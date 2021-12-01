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
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.i;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.down.utils.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
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
/* loaded from: classes8.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static int f32178e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f32179f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static int f32180g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static int f32181h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f32182i = -1;

    /* renamed from: j  reason: collision with root package name */
    public static int f32183j = -1;

    /* renamed from: k  reason: collision with root package name */
    public static int f32184k = -1;
    public static d l;
    public static String[] t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f32185d;
    public int m;
    public c n;
    public int o;
    public int p;
    public final String q;
    public final String r;
    public Map<String, c> s;

    /* loaded from: classes8.dex */
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
        t = new String[]{"/default.prop", SnapshotConstant.DeviceFilePathConstants.DEVICE_BUILD_CONFIG, "/system/default.prop", "/data/local.prop"};
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
        this.f32185d = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updateconfig";
        this.o = 0;
        this.p = com.baidu.android.pushservice.a.a();
        this.q = CloudStabilityUBCUtils.KEY_RESPONSE_CODE;
        this.r = "responseResult";
        this.f32167c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
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
            if (!Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") || (map = this.s) == null) {
                Map<String, c> map2 = this.s;
                if (map2 != null && map2.containsKey(upperCase) && a(this.s.get(upperCase), upperCase)) {
                    cVar = this.s.get(upperCase);
                    return cVar;
                }
                return null;
            }
            for (Map.Entry<String, c> entry : map.entrySet()) {
                String key = entry.getKey();
                if (a(this.s.get(key), key)) {
                    cVar = this.s.get(key);
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
            if (l == null) {
                synchronized (d.class) {
                    if (l == null) {
                        l = new d(context);
                    }
                }
            }
            return l;
        }
        return (d) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, hashMap)) == null) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            this.f32185d = (h.f() ? h.a() : h.b()) + "/rest/3.0/clientfile/updateconf";
            int i2 = 2;
            do {
                com.baidu.android.pushservice.e.b b2 = com.baidu.android.pushservice.e.c.b(this.a, this.f32185d, "POST", hashMap, "BCCS_SDK/3.0", h.c());
                if (b2 != null) {
                    int b3 = b2.b();
                    hashMap2.put(CloudStabilityUBCUtils.KEY_RESPONSE_CODE, b3 + "");
                    hashMap2.put("responseResult", m.a(this.a, b2.a()));
                    if (b3 == 200) {
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
            i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.m);
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

    /* JADX WARN: Removed duplicated region for block: B:136:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(c cVar, String str) {
        InterceptResult invokeLL;
        String str2;
        String str3;
        String n;
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
                        n = m.n(this.a);
                        a2 = eVar.a();
                    } catch (Exception unused) {
                    }
                    if (eVar.b() == 0) {
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(n)) {
                            double d3 = 0.0d;
                            try {
                                d2 = Double.parseDouble(a2);
                                try {
                                    d3 = Double.parseDouble(n);
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
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(n)) {
                            try {
                                i2 = Integer.parseInt(a2);
                            } catch (NumberFormatException unused4) {
                                i2 = 0;
                            }
                            try {
                                i3 = Integer.parseInt(n);
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
                    } else if (Pattern.matches(a2, n)) {
                        return true;
                    } else {
                        str4 = "manufaturer can not Matched, osversion is not REGULAR ";
                    }
                    com.baidu.android.pushservice.g.a.a("ModeConfig", str4, this.a);
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
                            str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, fVar.a());
                        }
                        if ((str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR")) && !m.i() && !str2.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.k(this.a)) {
                            str2 = Constants.SDK_VER;
                        }
                        if (str.equalsIgnoreCase("OPPO") && PushSettings.i(this.a) && !p(this.a)) {
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
                            com.baidu.android.pushservice.g.a.a("ModeConfig", str3, this.a);
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
            return (m.f() || m.g()) && p(this.a);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (f32183j == -1) {
                f32183j = i.b(context, "enable_newcid", 0);
            }
            return f32183j == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (f32181h == -1) {
                f32181h = i.b(context, "enable_conn_for_proxy", 0);
            }
            return f32181h == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            if (f32184k == -1) {
                f32184k = i.b(context, "enable_front_switch", 0);
            }
            return f32184k == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            if (f32180g == -1) {
                f32180g = (com.baidu.android.pushservice.a.a(context.getPackageName()) || i.b(context, "enable_single_conn", 1) == 1) ? 1 : 0;
            }
            return f32180g == 1;
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

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) ? i.b(context, "push_bind_interval", 12) : invokeL.intValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
                return ((Boolean) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            if (f32178e == -1) {
                f32178e = i.b(context, "enable_stat_upload", 0);
            }
            return f32178e == 1;
        }
        return invokeL.booleanValue;
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

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) ? i.b(context, "stat_upload_interval", 6) : invokeL.intValue;
    }

    public static List<String> i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
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

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f32166b);
                this.m = jSONObject.getInt("version");
                this.s = new HashMap();
                JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    c cVar = new c(this.a, jSONArray.getString(i2));
                    this.s.put(cVar.b(), cVar);
                }
                c a2 = a(Build.MANUFACTURER.toUpperCase());
                this.n = a2;
                a(a2);
            } catch (Exception unused) {
            }
        }
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            int b2 = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
            this.m = b2;
            if (b2 == -1) {
                return false;
            }
            String a2 = i.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            if (a2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
                return true;
            }
            this.n = new c(this.a, a2);
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            try {
                if (r(context)) {
                    return a(context).b() == 7;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            if (System.currentTimeMillis() - i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > 604800000) {
                return true;
            }
            long b2 = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
            File file = new File(this.f32167c);
            if (file.exists()) {
                long j2 = 0;
                if (b2 <= 0 || b2 != file.lastModified()) {
                    return true;
                }
                long b3 = i.b(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
                for (String str : t) {
                    File file2 = new File(str);
                    if (file2.exists()) {
                        j2 = (file2.lastModified() / 10) + j2;
                    }
                }
                return b3 != j2;
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
                if (a(context).b() == 6) {
                    return s(context);
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
            File file = new File(this.f32167c);
            if (file.exists()) {
                i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
                long j2 = 0;
                for (String str : t) {
                    File file2 = new File(str);
                    if (file2.exists()) {
                        j2 = (file2.lastModified() / 10) + j2;
                    }
                }
                i.a(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j2);
                i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
            }
        }
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) ? t(context) && a(context).b() == 5 : invokeL.booleanValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
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

    public static boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            try {
                if (o(context)) {
                    return i.b(context, "vi_push_proxy_mode", 0) == 1;
                }
                return false;
            } catch (Exception unused) {
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
                if (u(context)) {
                    return a(context).b() == 9;
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
                Class.forName("com.heytap.mcssdk.PushService");
                Class.forName("com.heytap.mcssdk.PushManager");
                return PushManager.isSupportPush(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
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

    public static boolean r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            try {
                if (m.c() && PushSettings.h(context)) {
                    return Class.forName("com.meizu.cloud.pushsdk.PushManager") != null;
                }
                return false;
            } catch (Throwable unused) {
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
                if (m.b() && PushSettings.g(context)) {
                    return Class.forName("com.xiaomi.mipush.sdk.MiPushClient") != null;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) ? m.d() && PushSettings.k(context) : invokeL.booleanValue;
    }

    public static boolean u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            try {
                if (m.h() && PushSettings.j(context)) {
                    return Class.forName("com.vivo.push.PushManager") != null;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x0131 */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        if (java.lang.Float.parseFloat(r4) >= 4.0d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ac, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.0d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00da, code lost:
        if (java.lang.Float.parseFloat(r4) >= 6.0d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0107, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012d, code lost:
        if (p(r12.a) != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0157 A[Catch: all -> 0x016d, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x001e, B:10:0x0029, B:12:0x0031, B:14:0x0039, B:16:0x0045, B:81:0x0131, B:84:0x0145, B:87:0x0157, B:22:0x0053, B:24:0x0059, B:26:0x0061, B:28:0x0069, B:30:0x0075, B:34:0x0081, B:36:0x0087, B:38:0x008f, B:40:0x0097, B:42:0x00a3, B:46:0x00af, B:48:0x00b5, B:50:0x00bd, B:52:0x00c5, B:54:0x00d1, B:58:0x00de, B:60:0x00e4, B:62:0x00ec, B:64:0x00f4, B:66:0x0100, B:70:0x010b, B:72:0x0111, B:74:0x0117, B:76:0x011f, B:78:0x0127), top: B:97:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, a aVar) {
        long b2;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048576, this, str, aVar) != null) {
            return;
        }
        synchronized (this) {
            long b3 = i.b(this.a, "cloud_update_config_time", 0) * 24 * 3600 * 1000;
            long j2 = 0;
            if (b3 <= 0) {
                b3 = 259200000;
            }
            if (m.d() && PushSettings.k(this.a) && !l(this.a)) {
                if (!TextUtils.isEmpty(m.n(this.a))) {
                }
                j2 = b3;
            } else if (m.b() && PushSettings.g(this.a) && !k(this.a)) {
                if (!TextUtils.isEmpty(m.n(this.a))) {
                }
                j2 = b3;
            } else if (m.e() && PushSettings.i(this.a) && !m(this.a)) {
                if (!TextUtils.isEmpty(m.n(this.a))) {
                }
                j2 = b3;
            } else if (m.c() && PushSettings.h(this.a) && !j(this.a)) {
                if (!TextUtils.isEmpty(m.n(this.a))) {
                }
                j2 = b3;
            } else if (!m.h() || !PushSettings.j(this.a) || n(this.a)) {
                if ((m.f() || m.g()) && PushSettings.i(this.a) && !m(this.a)) {
                }
                b2 = i.b(this.a, "last_update_config_time");
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - b2 <= b3) {
                    com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "ModeConfig-updateConfig", (short) 100, str, currentTimeMillis, aVar) { // from class: com.baidu.android.pushservice.b.d.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f32187b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ a f32188c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ d f32189d;

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
                            this.f32189d = this;
                            this.a = str;
                            this.f32187b = currentTimeMillis;
                            this.f32188c = aVar;
                        }

                        @Override // com.baidu.android.pushservice.h.c
                        public void a() {
                            JSONObject jSONObject;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    HashMap hashMap = new HashMap();
                                    com.baidu.android.pushservice.d.b.a(this.f32189d.a, hashMap);
                                    hashMap.put("version", this.f32189d.m + "");
                                    hashMap.put("model", Build.MODEL);
                                    hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                                    hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.a);
                                    if ((m.d() && PushSettings.k(this.f32189d.a)) || ((m.b() && PushSettings.g(this.f32189d.a)) || ((m.c() && PushSettings.h(this.f32189d.a)) || ((m.e() && PushSettings.i(this.f32189d.a)) || (m.h() && PushSettings.j(this.f32189d.a)))))) {
                                        hashMap.put("rom_version", m.n(this.f32189d.a));
                                    }
                                    if ((m.f() || m.g()) && PushSettings.i(this.f32189d.a)) {
                                        hashMap.put("rom_version", m.n(this.f32189d.a));
                                        hashMap.put("support_proxy", d.p(this.f32189d.a) ? "1" : "0");
                                    }
                                    hashMap.put("manufacture", Build.MANUFACTURER);
                                    hashMap.put("sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                                    hashMap.put("cuid", DeviceId.getCUID(this.f32189d.a));
                                    hashMap.put("package_name", this.f32189d.a.getPackageName());
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    HashMap a2 = this.f32189d.a(hashMap);
                                    String str2 = (String) a2.get("responseResult");
                                    if (!TextUtils.isEmpty(str2) && (jSONObject = (JSONObject) new JSONObject(str2).get("response_params")) != null) {
                                        if (jSONObject.getInt("status") == 1) {
                                            String string = jSONObject.getString("sdkconfig");
                                            if (!TextUtils.isEmpty(string) && this.f32189d.a(this.f32189d.a, string)) {
                                                this.f32189d.e();
                                            }
                                        }
                                        i.a(this.f32189d.a, "last_update_config_time", this.f32187b);
                                        int optInt = jSONObject.optInt("newcid", -1);
                                        if (optInt != -1) {
                                            int unused = d.f32183j = optInt;
                                            i.a(this.f32189d.a, "enable_newcid", optInt);
                                        }
                                        int optInt2 = jSONObject.optInt("mode", -1);
                                        if (optInt2 != -1) {
                                            int unused2 = d.f32181h = optInt2;
                                            i.a(this.f32189d.a, "enable_conn_for_proxy", optInt2);
                                        }
                                        int optInt3 = jSONObject.optInt("front_switch", -1);
                                        if (optInt3 != -1) {
                                            int unused3 = d.f32184k = optInt3;
                                            i.a(this.f32189d.a, "enable_front_switch", optInt3);
                                        }
                                        int optInt4 = jSONObject.optInt("enable_bddns", -1);
                                        if (optInt4 != -1) {
                                            int unused4 = d.f32182i = optInt4;
                                            i.a(this.f32189d.a, "bddns_enable", optInt4);
                                        }
                                        int optInt5 = jSONObject.optInt("single", -1);
                                        if (optInt5 != -1) {
                                            int unused5 = d.f32180g = optInt5;
                                            i.a(this.f32189d.a, "enable_single_conn", optInt5);
                                        }
                                        i.a(this.f32189d.a, "cloud_update_config_time", jSONObject.optInt("update_time", 0));
                                        int optInt6 = jSONObject.optInt("bind_time", -1);
                                        if (optInt6 != -1) {
                                            i.a(this.f32189d.a, "push_bind_interval", optInt6);
                                        }
                                        int optInt7 = jSONObject.optInt("stat", -1);
                                        if (optInt7 != -1) {
                                            int unused6 = d.f32178e = optInt7;
                                            i.a(this.f32189d.a, "enable_stat_upload", optInt7);
                                        }
                                        int optInt8 = jSONObject.optInt("stat_real_time", -1);
                                        if (optInt8 != -1) {
                                            int unused7 = d.f32179f = optInt8;
                                            i.a(this.f32189d.a, "enable_stat_real_time", optInt8);
                                        }
                                        int optInt9 = jSONObject.optInt("stat_time", -1);
                                        if (optInt9 != -1) {
                                            i.a(this.f32189d.a, "stat_upload_interval", optInt9);
                                        }
                                        i.b(this.f32189d.a, "keep_alive_pkgs", jSONObject.optString("keep_alive", null));
                                        i.a(this.f32189d.a, "key_vip_type", jSONObject.optInt("vip_type", 3));
                                        JSONObject optJSONObject = jSONObject.optJSONObject("upload_control");
                                        if (optJSONObject != null) {
                                            this.f32189d.a(optJSONObject);
                                        }
                                    }
                                    int parseInt = Integer.parseInt((String) a2.get(CloudStabilityUBCUtils.KEY_RESPONSE_CODE));
                                    new b.d(this.f32189d.a).d(501001L).c(parseInt).a(currentTimeMillis2).b(System.currentTimeMillis()).a(this.f32189d.f32185d).c(parseInt != 200 ? str2 : "").a();
                                } catch (Exception unused8) {
                                }
                                a aVar2 = this.f32188c;
                                if (aVar2 != null) {
                                    aVar2.a();
                                }
                            }
                        }
                    });
                    return;
                }
                if (aVar != null) {
                    com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "updateConfig-local", (short) 99, aVar) { // from class: com.baidu.android.pushservice.b.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ d f32186b;

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
                            this.f32186b = this;
                            this.a = aVar;
                        }

                        @Override // com.baidu.android.pushservice.h.c
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
                if (!TextUtils.isEmpty(m.n(this.a))) {
                }
                j2 = b3;
            }
            b3 = j2;
            b2 = i.b(this.a, "last_update_config_time");
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b2 <= b3) {
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = this.n;
            if (cVar == null) {
                return true;
            }
            if (cVar.c() == 5) {
                this.o = 5;
                return true;
            } else if (this.n.c() == 6) {
                this.o = 6;
                return true;
            } else if (this.n.c() == 7) {
                this.o = 7;
                return true;
            } else if (this.n.c() == 8) {
                this.o = 8;
                return true;
            } else if (this.n.c() == 9) {
                this.o = 9;
                return true;
            } else {
                if (this.n.c() == 2 && !TextUtils.isEmpty(this.n.f())) {
                    try {
                        PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.n.f(), 16448);
                        if (packageInfo != null) {
                            int i2 = packageInfo.versionCode;
                            if ((this.n.a() != null && (this.n.a().f32176b != -1 ? !(i2 < this.n.a().a || i2 > this.n.a().f32176b) : i2 >= this.n.a().a)) && BaiduAppSSOJni.encodeBySha1(packageInfo.signatures[0].toByteArray()).equalsIgnoreCase(this.n.g())) {
                                this.p = m.g(this.a, this.n.f());
                                this.o = this.a.getPackageName().equalsIgnoreCase(this.n.f()) ? 3 : 4;
                                return true;
                            }
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        return false;
                    }
                }
                com.baidu.android.pushservice.g.a.a("ModeConfig", " Current Mode = " + this.o, this.a);
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
            if (this.n != null) {
                d();
            } else {
                com.baidu.android.pushservice.g.a.a("ModeConfig", "Config File Not Matched", this.a);
            }
        }
    }
}
