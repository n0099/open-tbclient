package com.baidu.android.pushservice.l;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushServiceReceiver;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.a0.k;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.msp.push.HeytapPushManager;
import com.hihonor.push.sdk.ipc.HonorApiAvailability;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends com.baidu.android.pushservice.l.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int j = -1;
    public static int k = -1;
    public static int l = -1;
    public static int m = -1;
    public static int n = -1;
    public static int o = -1;
    public static int p = -1;
    public static int q = -1;
    public static int r = -1;
    public static int s = -1;
    public static d t;
    public static int u;
    public static String[] v;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public int e;
    public com.baidu.android.pushservice.l.c f;
    public int g;
    public int h;
    public Map<String, com.baidu.android.pushservice.l.c> i;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterfaceC0029d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, String str, short s, InterfaceC0029d interfaceC0029d) {
            super(str, s);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Short.valueOf(s), interfaceC0029d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = interfaceC0029d;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements InterfaceC0029d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.android.pushservice.l.d.InterfaceC0029d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ InterfaceC0029d e;
        public final /* synthetic */ d f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, String str, short s, String str2, boolean z, InterfaceC0029d interfaceC0029d) {
            super(str, s);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Short.valueOf(s), str2, Boolean.valueOf(z), interfaceC0029d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = dVar;
            this.c = str2;
            this.d = z;
            this.e = interfaceC0029d;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    HashMap hashMap = new HashMap();
                    com.baidu.android.pushservice.p.b.a(this.f.a, hashMap);
                    hashMap.put("version", this.f.e + "");
                    hashMap.put("osSdkInt", Build.VERSION.SDK_INT + "");
                    hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.c);
                    hashMap.put("front_conn_avaliable", d.u + "");
                    if ((Utility.H(this.f.a) && PushSettings.h(this.f.a)) || ((Utility.T(this.f.a) && PushSettings.m(this.f.a)) || ((Utility.J(this.f.a) && PushSettings.j(this.f.a)) || ((Utility.N(this.f.a) && PushSettings.k(this.f.a)) || (Utility.S(this.f.a) && PushSettings.l(this.f.a)))))) {
                        hashMap.put("rom_version", Utility.z(this.f.a));
                    }
                    String str = "1";
                    if ((Utility.M(this.f.a) || Utility.P(this.f.a)) && PushSettings.k(this.f.a)) {
                        hashMap.put("rom_version", Utility.z(this.f.a));
                        hashMap.put("support_proxy", d.w(this.f.a) ? "1" : "0");
                    }
                    hashMap.put("manufacture", Utility.a(this.f.a, false));
                    hashMap.put("sdk_version", ((int) com.baidu.android.pushservice.a.a()) + "");
                    hashMap.put("cuid", DeviceId.getCUID(this.f.a));
                    hashMap.put("package_name", this.f.a.getPackageName());
                    if (!d.l(this.f.a)) {
                        str = "0";
                    }
                    hashMap.put("support_honor", str);
                    hashMap.put("app_last_update_ts", Utility.u(this.f.a) + "");
                    System.currentTimeMillis();
                    HashMap a = this.f.a((HashMap<String, String>) hashMap);
                    String str2 = (String) a.get("responseResult");
                    if (!TextUtils.isEmpty(str2) && (jSONObject = (JSONObject) new JSONObject(str2).get("response_params")) != null) {
                        if (jSONObject.getInt("status") == 1) {
                            String string = jSONObject.getString("sdkconfig");
                            if (!TextUtils.isEmpty(string) && this.f.a(this.f.a, string)) {
                                this.f.h();
                            }
                        }
                        if (this.d) {
                            this.f.a(jSONObject);
                        } else {
                            d.b(this.f.a, jSONObject.toString());
                        }
                    }
                    Integer.parseInt((String) a.get(CloudStabilityUBCUtils.KEY_RESPONSE_CODE));
                } catch (Exception unused) {
                }
                InterfaceC0029d interfaceC0029d = this.e;
                if (interfaceC0029d != null) {
                    interfaceC0029d.a();
                }
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.l.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0029d {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676810564, "Lcom/baidu/android/pushservice/l/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676810564, "Lcom/baidu/android/pushservice/l/d;");
                return;
            }
        }
        v = new String[]{"/default.prop", SnapshotConstant.DeviceFilePathConstants.DEVICE_BUILD_CONFIG, "/system/default.prop", "/data/local.prop"};
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updateconfig";
        this.g = 0;
        this.h = com.baidu.android.pushservice.a.a();
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        h();
    }

    public static boolean A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (y(context)) {
                    return i.a(context, "vi_push_proxy_mode", 0) == 1;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (i(context).b() == 6) {
                    return z(context);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            String c2 = i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
            long a2 = k.a(context, "last_update_config_time", 0L) / 1000;
            long u2 = Utility.u(context);
            boolean a3 = k.a(context, "last_update_config_time");
            if (TextUtils.isEmpty(c2) || a2 > u2 || !a3) {
                return;
            }
            k.b(context, "last_update_config_time", System.currentTimeMillis());
            i(context).a(true, c2, new b());
        }
    }

    public static void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, context, i) == null) {
            k.c(context, "ach_register", i);
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, jSONObject) == null) {
            int optInt = jSONObject.optInt("ach_service", -1);
            p = optInt;
            c(context, optInt);
            int optInt2 = jSONObject.optInt("ach_service_hpkit", -1);
            q = optInt2;
            d(context, optInt2);
            k.b(context, "last_update_config_time", System.currentTimeMillis());
            int optInt3 = jSONObject.optInt("ach_register");
            r = optInt3;
            a(context, optInt3);
            int optInt4 = jSONObject.optInt("data_report_switch");
            s = optInt4;
            com.baidu.android.pushservice.v.c.a().a(context, jSONObject.optJSONObject("ach_sw_info"));
            b(context, optInt4);
            k.a(context, "push_ach_bypass_key", jSONObject.optString("ach_bypass_key"));
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (l == -1) {
                l = i.a(context, "bddns_enable", 1);
            }
            return !g.f() && l == 1;
        }
        return invokeL.booleanValue;
    }

    public static void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, context, i) == null) {
            k.c(context, "data_report_switch", i);
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.SAVE_PUSH_PROCESS_SP");
            intent.setPackage(context.getPackageName());
            intent.setClass(context, PushServiceReceiver.class);
            intent.putExtra("com.baidu.android.pushservice.UPDATE_CONF_RESPONSE_DATA", str);
            context.sendBroadcast(intent);
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (n == -1) {
                n = i.a(context, "enable_front_switch", 0);
            }
            return n == 1;
        }
        return invokeL.booleanValue;
    }

    public static void c(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, context, i) == null) {
            k.c(context, "ach_service_switch", i);
            boolean z = false;
            if (i.a(context, "key_push_launch_task_level", 0) == 0 && i == 1) {
                z = true;
            }
            com.baidu.android.pushservice.v.c.a().a(context, "com.baidu.android.pushservice.ach.PushAchService", z ? 1 : 2);
        }
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (r == -1) {
                r = k.a(context, "ach_register", 0);
            }
            return r == 1;
        }
        return invokeL.booleanValue;
    }

    public static void d(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65552, null, context, i) == null) {
            k.c(context, "ach_service_hpkit_switch", i);
            boolean z = false;
            if (i.a(context, "key_push_launch_task_level", 0) == 0 && i == 1) {
                z = true;
            }
            com.baidu.android.pushservice.v.c.a().a(context, "com.baidu.android.pushservice.ach.power.PushAchHpkitService", z ? 1 : 2);
        }
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (s == -1) {
                s = k.a(context, "data_report_switch", 0);
            }
            return s == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            if (p == -1) {
                p = k.a(context, "ach_service_switch", 0);
            }
            return p == 1;
        }
        return invokeL.booleanValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) ? i.a(context, "push_bind_interval", 12) : invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            if (o == -1) {
                o = i.a(context, "honor_bind_type", 0);
            }
            return o;
        }
        return invokeL.intValue;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            if (q == -1) {
                q = k.a(context, "ach_service_hpkit_switch", 0);
            }
            return q == 1;
        }
        return invokeL.booleanValue;
    }

    public static d i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            if (t == null) {
                synchronized (d.class) {
                    if (t == null) {
                        t = new d(context);
                    }
                }
            }
            return t;
        }
        return (d) invokeL.objValue;
    }

    public static List<String> j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            String c2 = i.c(context, "keep_alive_pkgs");
            if (!TextUtils.isEmpty(c2)) {
                try {
                    JSONArray jSONArray = new JSONArray(c2);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
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

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            try {
                return HonorApiAvailability.b(context) == 0;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? i(context).b() == 10 && PushSettings.g(context) && k(context) : invokeL.booleanValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) ? u(context) && i(context).b() == 5 : invokeL.booleanValue;
    }

    public static boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            try {
                if (v(context)) {
                    return i(context).b() == 7;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            if (m == -1) {
                m = i.a(context, "enable_newcid", 0);
            }
            return m == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            try {
                if (i(context).b() == 8 && PushSettings.k(context)) {
                    return Class.forName("com.heytap.msp.push.HeytapPushManager") != null;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            if (k == -1) {
                k = i.a(context, "enable_conn_for_proxy", 0);
            }
            return k == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            switch (i(context).b()) {
                case 5:
                    return PushSettings.h(context);
                case 6:
                    return PushSettings.m(context);
                case 7:
                    return PushSettings.j(context);
                case 8:
                    return PushSettings.k(context);
                case 9:
                    return PushSettings.l(context);
                case 10:
                    return PushSettings.g(context);
                default:
                    return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (j == -1) {
                j = (com.baidu.android.pushservice.a.a(context.getPackageName()) || i.a(context, "enable_single_conn", 1) == 1) ? 1 : 0;
            }
            return j == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) ? i(context).b() == 10 : invokeL.booleanValue;
    }

    public static boolean u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? Utility.H(context) && PushSettings.h(context) : invokeL.booleanValue;
    }

    public static boolean v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            try {
                if (Utility.J(context) && PushSettings.j(context)) {
                    return Class.forName("com.meizu.cloud.pushsdk.PushManager") != null;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            try {
                Class.forName("com.heytap.mcssdk.PushService");
                Class.forName("com.heytap.msp.push.HeytapPushManager");
                return HeytapPushManager.isSupportPush(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            try {
                if (Utility.S(context) && PushSettings.l(context)) {
                    return Class.forName("com.vivo.push.PushClient") != null;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            try {
                if (x(context)) {
                    return i(context).b() == 9;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            try {
                if (Utility.T(context) && PushSettings.m(context)) {
                    return Class.forName("com.xiaomi.mipush.sdk.MiPushClient") != null;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final com.baidu.android.pushservice.l.c a(String str) {
        InterceptResult invokeL;
        Map<String, com.baidu.android.pushservice.l.c> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String upperCase = str.toUpperCase();
            String a2 = Utility.a(this.a, true);
            if (!a2.equalsIgnoreCase("unknown") || (map = this.i) == null) {
                Map<String, com.baidu.android.pushservice.l.c> map2 = this.i;
                if (map2 != null && map2.containsKey(upperCase)) {
                    if (a2.equalsIgnoreCase("HONOR")) {
                        return a(this.i);
                    }
                    if (a(this.i.get(upperCase), upperCase)) {
                        return this.i.get(upperCase);
                    }
                    if (upperCase.equalsIgnoreCase("OPPO") && PushSettings.k(this.a) && w(this.a)) {
                        return this.i.get(upperCase);
                    }
                }
            } else {
                for (Map.Entry<String, com.baidu.android.pushservice.l.c> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (a(this.i.get(key), key)) {
                        return this.i.get(key);
                    }
                }
            }
            return null;
        }
        return (com.baidu.android.pushservice.l.c) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (a(r5.get("HONOR"), "HONOR") != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.baidu.android.pushservice.l.c a(Map<String, com.baidu.android.pushservice.l.c> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            String str = (PushSettings.g(this.a) && k(this.a)) ? "HONOR" : "HUAWEI";
            if (!a(map.get("HUAWEI"), "HUAWEI")) {
                return null;
            }
            return this.i.get(str);
        }
        return (com.baidu.android.pushservice.l.c) invokeL.objValue;
    }

    public final HashMap<String, String> a(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap)) == null) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            this.d = (g.f() ? g.c() : g.d()) + "/rest/3.0/clientfile/updateconf";
            int i = 2;
            do {
                com.baidu.android.pushservice.q.b a2 = com.baidu.android.pushservice.q.c.a(this.a, this.d, "POST", hashMap, "BCCS_SDK/3.0", g.b());
                if (a2 != null) {
                    int a3 = a2.a();
                    hashMap2.put(CloudStabilityUBCUtils.KEY_RESPONSE_CODE, a3 + "");
                    hashMap2.put("responseResult", Utility.a(this.a, a2.b()));
                    if (a3 == 200) {
                        return hashMap2;
                    }
                }
                i--;
            } while (i > 0);
            return hashMap2;
        }
        return (HashMap) invokeL.objValue;
    }

    public final void a(com.baidu.android.pushservice.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            i.b(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", cVar != null ? cVar.toString() : "CONFIG_MANUFACTURER_DEFAULT");
            i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.e);
            i();
        }
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x0051 */
    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x016b */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
        if (java.lang.Float.parseFloat(r4) >= 5.0d) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00af, code lost:
        if (java.lang.Float.parseFloat(r4) >= 4.0d) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e0, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.0d) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0111, code lost:
        if (java.lang.Float.parseFloat(r4) >= 6.0d) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x013f, code lost:
        if (java.lang.Float.parseFloat(r4) >= 3.1d) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0150, code lost:
        if (com.baidu.android.pushservice.util.Utility.P(r9.a) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0168, code lost:
        if (w(r9.a) == false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0191 A[Catch: all -> 0x019c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:8:0x001e, B:10:0x002b, B:12:0x0033, B:14:0x003b, B:16:0x0047, B:20:0x0051, B:22:0x0059, B:24:0x0061, B:26:0x0069, B:28:0x0075, B:91:0x016b, B:94:0x017e, B:97:0x0191, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a6, B:44:0x00b3, B:46:0x00bb, B:48:0x00c3, B:50:0x00cb, B:52:0x00d7, B:56:0x00e4, B:58:0x00ec, B:60:0x00f4, B:62:0x00fc, B:64:0x0108, B:68:0x0114, B:70:0x011c, B:72:0x0124, B:74:0x012c, B:76:0x0138, B:80:0x0142, B:82:0x014a, B:84:0x0152, B:86:0x015a, B:88:0x0162), top: B:109:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, InterfaceC0029d interfaceC0029d) {
        String z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048580, this, str, interfaceC0029d) != null) {
            return;
        }
        synchronized (this) {
            long a2 = i.a(this.a, "cloud_update_config_time", 0) * 24 * 3600 * 1000;
            if (a2 <= 0) {
                a2 = 259200000;
            }
            if (Utility.H(this.a) && PushSettings.h(this.a) && !m(this.a)) {
                try {
                    if (!TextUtils.isEmpty(Utility.z(this.a))) {
                        if (Float.parseFloat(z) >= 3.1d) {
                            a2 = 0;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (Utility.G(this.a) && PushSettings.g(this.a) && !l(this.a)) {
                if (!TextUtils.isEmpty(Utility.z(this.a))) {
                }
                if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
                }
            } else if (Utility.T(this.a) && PushSettings.m(this.a) && !B(this.a)) {
                if (!TextUtils.isEmpty(Utility.z(this.a))) {
                }
                if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
                }
            } else if (Utility.N(this.a) && PushSettings.k(this.a) && !p(this.a)) {
                if (!TextUtils.isEmpty(Utility.z(this.a))) {
                }
                if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
                }
            } else if (Utility.J(this.a) && PushSettings.j(this.a) && !n(this.a)) {
                if (!TextUtils.isEmpty(Utility.z(this.a))) {
                }
                if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
                }
            } else if (!Utility.S(this.a) || !PushSettings.l(this.a) || A(this.a)) {
                if (!Utility.M(this.a)) {
                }
                if (PushSettings.k(this.a)) {
                    if (!p(this.a)) {
                    }
                }
                if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
                    a(Utility.I(this.a), str, interfaceC0029d);
                    return;
                }
                if (interfaceC0029d != null) {
                    com.baidu.android.pushservice.z.e.a().a(new a(this, "updateConfig-local", (short) 99, interfaceC0029d));
                }
                return;
            } else {
                if (!TextUtils.isEmpty(Utility.z(this.a))) {
                }
                if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
                }
            }
            a2 = 0;
            if (System.currentTimeMillis() - k.a(this.a, "last_update_config_time", 0L) > a2) {
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            int optInt = jSONObject.optInt("newcid", -1);
            if (optInt != -1) {
                m = optInt;
                i.b(this.a, "enable_newcid", optInt);
            }
            int optInt2 = jSONObject.optInt("honor_bind_type", -1);
            if (optInt2 != -1) {
                o = optInt2;
                i.b(this.a, "honor_bind_type", optInt2);
            }
            int optInt3 = jSONObject.optInt("mode", -1);
            if (optInt3 != -1) {
                k = optInt3;
                i.b(this.a, "enable_conn_for_proxy", optInt3);
            }
            int optInt4 = jSONObject.optInt("front_switch", -1);
            if (optInt4 != -1) {
                n = optInt4;
                i.b(this.a, "enable_front_switch", optInt4);
            }
            int optInt5 = jSONObject.optInt("enable_bddns", -1);
            if (optInt5 != -1) {
                l = optInt5;
                i.b(this.a, "bddns_enable", optInt5);
            }
            int optInt6 = jSONObject.optInt("single", -1);
            if (optInt6 != -1) {
                j = optInt6;
                i.b(this.a, "enable_single_conn", optInt6);
            }
            i.b(this.a, "cloud_update_config_time", jSONObject.optInt("update_time", 0));
            int optInt7 = jSONObject.optInt("bind_time", -1);
            if (optInt7 != -1) {
                i.b(this.a, "push_bind_interval", optInt7);
            }
            int optInt8 = jSONObject.optInt("stat", -1);
            if (optInt8 != -1) {
                i.b(this.a, "enable_stat_upload", optInt8);
            }
            int optInt9 = jSONObject.optInt("stat_real_time", -1);
            if (optInt9 != -1) {
                i.b(this.a, "enable_stat_real_time", optInt9);
            }
            int optInt10 = jSONObject.optInt("stat_time", -1);
            if (optInt10 != -1) {
                i.b(this.a, "stat_upload_interval", optInt10);
            }
            i.c(this.a, "keep_alive_pkgs", jSONObject.optString("keep_alive", null));
            i.b(this.a, "key_vip_type", jSONObject.optInt("vip_type", 3));
            JSONObject optJSONObject = jSONObject.optJSONObject("upload_control");
            if (optJSONObject != null) {
                b(optJSONObject);
            }
            if (jSONObject.has("pull_config")) {
                com.baidu.android.pushservice.y.c.b(this.a, jSONObject.optJSONObject("pull_config"));
            }
            if (jSONObject.has("am_config")) {
                com.baidu.android.pushservice.y.c.a(this.a, jSONObject.optJSONObject("am_config"));
            }
            b(this.a, jSONObject.toString());
        }
    }

    public void a(boolean z, String str, InterfaceC0029d interfaceC0029d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, interfaceC0029d}) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.android.pushservice.z.e.a().a(new c(this, "ModeConfig-updateConfig", (short) 100, str, z, interfaceC0029d));
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085 A[Catch: Exception -> 0x009f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x009f, blocks: (B:14:0x0031, B:16:0x0041, B:18:0x0047, B:21:0x004f, B:22:0x0053, B:29:0x0060, B:53:0x009c, B:31:0x0065, B:33:0x006b, B:35:0x0071, B:37:0x0077, B:38:0x007b, B:44:0x0085, B:46:0x008a, B:48:0x0091, B:51:0x0098), top: B:131:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.baidu.android.pushservice.l.c cVar, String str) {
        InterceptResult invokeLL;
        String str2;
        Context context;
        String str3;
        String i;
        String b2;
        Context context2;
        String str4;
        int i2;
        int i3;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, cVar, str)) == null) {
            if (cVar != null && cVar.f() != null && cVar.f().size() > 0) {
                for (int i4 = 0; i4 < cVar.f().size(); i4++) {
                    e eVar = cVar.f().get(i4);
                    try {
                        i = Utility.i(this.a, str);
                        b2 = eVar.b();
                    } catch (Exception unused) {
                    }
                    if (eVar.a() == 0) {
                        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(i)) {
                            double d2 = 0.0d;
                            try {
                                d = Double.parseDouble(b2);
                                try {
                                    d2 = Double.parseDouble(i);
                                } catch (NumberFormatException unused2) {
                                }
                            } catch (NumberFormatException unused3) {
                                d = 0.0d;
                            }
                            if (d2 >= d) {
                                return true;
                            }
                            context2 = this.a;
                            str4 = "manufaturer can not Matched, osversion is not ABOVE ";
                        }
                    } else if (eVar.a() == 1) {
                        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(i)) {
                            try {
                                i2 = Integer.parseInt(b2);
                                try {
                                    i3 = Integer.parseInt(i);
                                } catch (NumberFormatException unused4) {
                                    i3 = 0;
                                    if (i3 != i2) {
                                    }
                                }
                            } catch (NumberFormatException unused5) {
                                i2 = 0;
                            }
                            if (i3 != i2) {
                                return true;
                            }
                            context2 = this.a;
                            str4 = "manufaturer can not Matched, osversion is not EQUAL ";
                        }
                    } else if (eVar.a() != 2) {
                        continue;
                    } else if (Pattern.matches(b2, i)) {
                        return true;
                    } else {
                        context2 = this.a;
                        str4 = "manufaturer can not Matched, osversion is not REGULAR ";
                    }
                    com.baidu.android.pushservice.u.a.a("ModeConfig", str4, context2);
                }
            }
            if (cVar != null && cVar.h() != null && cVar.h().size() > 0) {
                for (int i5 = 0; i5 < cVar.h().size(); i5++) {
                    f fVar = cVar.h().get(i5);
                    try {
                        if (Build.VERSION.SDK_INT >= 28) {
                            str2 = SystemProperties.get(fVar.a());
                        } else {
                            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                            str2 = (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, fVar.a());
                        }
                        if (((str.equalsIgnoreCase("HUAWEI") && Utility.b()) || str.equalsIgnoreCase("HONOR")) && !Utility.K(this.a) && !Utility.a(str2, "\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21 && PushSettings.h(this.a)) {
                            str2 = com.baidu.down.utils.Constants.SDK_VER;
                        }
                        if (str.equalsIgnoreCase("OPPO") && PushSettings.k(this.a) && !w(this.a)) {
                            str2 = "V1.0";
                        }
                        Matcher matcher = Pattern.compile(fVar.c()).matcher(str2);
                        if (matcher.find()) {
                            Double valueOf = Double.valueOf(str.equalsIgnoreCase("OPPO") ? matcher.group(1) : matcher.group());
                            Double valueOf2 = Double.valueOf(fVar.d());
                            if (fVar.b() == 0) {
                                if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                    return true;
                                }
                                context = this.a;
                                str3 = "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ";
                            } else if (fVar.b() != 1) {
                                continue;
                            } else if (valueOf == valueOf2) {
                                return true;
                            } else {
                                context = this.a;
                                str3 = "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ";
                            }
                            com.baidu.android.pushservice.u.a.a("ModeConfig", str3, context);
                        } else {
                            continue;
                        }
                    } catch (Throwable unused6) {
                    }
                }
            }
            if (cVar == null || cVar.g() != 1) {
                return false;
            }
            return (Utility.M(this.a) || Utility.P(this.a)) && w(this.a);
        }
        return invokeLL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : invokeV.intValue;
    }

    public final void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data_sensitive");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("time_sensitive");
                JSONArray optJSONArray = jSONObject.optJSONArray("bind_attr");
                int optInt = jSONObject.optInt("click_data_size", -1);
                if (optInt != i.a(this.a, "click_data_size", -1) && optInt == -1) {
                    com.baidu.android.pushservice.m.d.b(this.a);
                }
                i.b(this.a, "click_data_size", optInt);
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        arrayList.add(next);
                        com.baidu.android.pushservice.m.d.a(this.a, next, 1, optJSONObject.getLong(next));
                    }
                }
                if (optJSONObject2 != null) {
                    Iterator<String> keys2 = optJSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        arrayList.add(next2);
                        com.baidu.android.pushservice.m.d.a(this.a, next2, 0, optJSONObject2.getLong(next2));
                    }
                }
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    optJSONArray = new JSONArray("[\"alert_freq\", \"bduss\", \"app_notify_status\"]");
                }
                com.baidu.android.pushservice.m.d.b(this.a, optJSONArray);
                com.baidu.android.pushservice.m.d.a(this.a, (ArrayList<String>) arrayList);
            } catch (Exception unused) {
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : invokeV.intValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int a2 = i.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
            this.e = a2;
            if (a2 == -1) {
                return false;
            }
            String c2 = i.c(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            if (c2.equals("CONFIG_MANUFACTURER_DEFAULT")) {
                return true;
            }
            this.f = new com.baidu.android.pushservice.l.c(this.a, c2);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (System.currentTimeMillis() - i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > 604800000) {
                return true;
            }
            long b2 = i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
            File file = new File(this.c);
            if (file.exists()) {
                long j2 = 0;
                if (b2 <= 0 || b2 != file.lastModified()) {
                    return true;
                }
                long b3 = i.b(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
                for (String str : v) {
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

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject(this.b);
                this.e = jSONObject.getInt("version");
                this.i = new HashMap();
                JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.baidu.android.pushservice.l.c cVar = new com.baidu.android.pushservice.l.c(this.a, jSONArray.getString(i));
                    this.i.put(cVar.d(), cVar);
                }
                com.baidu.android.pushservice.l.c a2 = a(Utility.a(this.a, true));
                this.f = a2;
                a(a2);
            } catch (Exception unused) {
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            com.baidu.android.pushservice.l.c cVar = this.f;
            if (cVar == null) {
                return true;
            }
            if (cVar.e() == 5) {
                this.g = 5;
                return true;
            } else if (this.f.e() == 6) {
                this.g = 6;
                return true;
            } else if (this.f.e() == 7) {
                this.g = 7;
                return true;
            } else if (this.f.e() == 8) {
                this.g = 8;
                return true;
            } else if (this.f.e() == 9) {
                this.g = 9;
                return true;
            } else if (this.f.e() == 10) {
                this.g = 10;
                return true;
            } else {
                if (this.f.e() == 2 && !TextUtils.isEmpty(this.f.a())) {
                    try {
                        PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.f.a(), 16448);
                        if (packageInfo != null) {
                            int i = packageInfo.versionCode;
                            if ((this.f.c() != null && (this.f.c().b != -1 ? !(i < this.f.c().a || i > this.f.c().b) : i >= this.f.c().a)) && BaiduAppSSOJni.encodeBySha1(packageInfo.signatures[0].toByteArray()).equalsIgnoreCase(this.f.b())) {
                                this.h = Utility.g(this.a, this.f.a());
                                this.g = this.a.getPackageName().equalsIgnoreCase(this.f.a()) ? 3 : 4;
                                return true;
                            }
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        return false;
                    }
                }
                com.baidu.android.pushservice.u.a.a("ModeConfig", " Current Mode = " + this.g, this.a);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean e = e();
            boolean d = d();
            if ((e || !d) && a()) {
                f();
            }
            if (this.f != null) {
                g();
            } else {
                com.baidu.android.pushservice.u.a.a("ModeConfig", "Config File Not Matched", this.a);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            File file = new File(this.c);
            if (file.exists()) {
                i.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
                long j2 = 0;
                for (String str : v) {
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
}
