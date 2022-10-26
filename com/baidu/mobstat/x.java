package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public static final x a;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler b;
    public boolean c;
    public int d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366709524, "Lcom/baidu/mobstat/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366709524, "Lcom/baidu/mobstat/x;");
                return;
            }
        }
        a = new x();
    }

    public x() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new Handler();
        this.c = false;
        this.d = 0;
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, jSONObject) == null) {
            aa aaVar = new aa(jSONObject);
            z.b = aaVar.a;
            z.c = aaVar.b;
            z.d = aaVar.c;
        }
    }

    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (w.a(context).a() && !a(context)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            int i = 0;
            try {
                jSONObject.put("detector_count", this.d);
                jSONObject2.put(Config.HEADER_PART, jSONObject);
                i = 0 + jSONObject.toString().length();
            } catch (JSONException e) {
                ba.c().a(e);
            }
            ba.c().a("APP_MEM");
            if (!w.a(context).b()) {
                String v = bw.v(context);
                JSONArray jSONArray = new JSONArray();
                ba.c().a(v);
                jSONArray.put(v);
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject2.put("app_mem3", jSONArray);
                        i += jSONArray.toString().length();
                    } catch (JSONException e2) {
                        ba.c().a(e2);
                    }
                }
            }
            ba.c().a("APP_APK");
            List<String> a2 = k.e.a(context, 20480);
            JSONArray jSONArray2 = new JSONArray();
            for (String str : a2) {
                ba.c().a(str);
                jSONArray2.put(str);
            }
            if (jSONArray2.length() > 0) {
                try {
                    jSONObject2.put("app_apk3", jSONArray2);
                    i += jSONArray2.toString().length();
                } catch (JSONException e3) {
                    ba.c().a(e3);
                }
            }
            ba.c().a("APP_CHANGE");
            List<String> a3 = k.d.a(context, 10240);
            JSONArray jSONArray3 = new JSONArray();
            for (String str2 : a3) {
                ba.c().a(str2);
                jSONArray3.put(str2);
            }
            if (jSONArray3.length() > 0) {
                try {
                    jSONObject2.put("app_change3", jSONArray3);
                    i += jSONArray3.toString().length();
                } catch (JSONException e4) {
                    ba.c().a(e4);
                }
            }
            ba.c().a("APP_TRACE");
            List<String> a4 = k.c.a(context, 15360);
            JSONArray jSONArray4 = new JSONArray();
            for (String str3 : a4) {
                ba.c().a(str3);
                jSONArray4.put(str3);
            }
            if (jSONArray4.length() > 0) {
                try {
                    jSONObject2.put("app_trace3", jSONArray4);
                    i += jSONArray4.toString().length();
                } catch (JSONException e5) {
                    ba.c().a(e5);
                }
            }
            ba.c().a("APP_LIST");
            List<String> a5 = k.b.a(context, 46080);
            JSONArray jSONArray5 = new JSONArray();
            for (String str4 : a5) {
                ba.c().a(str4);
                jSONArray5.put(str4);
            }
            if (jSONArray5.length() > 0) {
                try {
                    jSONObject2.put("app_list3", jSONArray5);
                    i += jSONArray5.toString().length();
                } catch (JSONException e6) {
                    ba.c().a(e6);
                }
            }
            ba.c().a("AP_LIST");
            List<String> a6 = k.a.a(context, 184320 - i);
            JSONArray jSONArray6 = new JSONArray();
            for (String str5 : a6) {
                ba.c().a(str5);
                jSONArray6.put(str5);
            }
            if (jSONArray6.length() > 0) {
                try {
                    jSONObject2.put("ap_list3", jSONArray6);
                    i += jSONArray6.toString().length();
                } catch (JSONException e7) {
                    ba.c().a(e7);
                }
            }
            ba c = ba.c();
            c.a("log in bytes is almost :" + i);
            JSONArray jSONArray7 = new JSONArray();
            jSONArray7.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("payload", jSONArray7);
                r.a().a(context, jSONObject3.toString());
            } catch (Exception e8) {
                ba.c().a(e8);
            }
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            ba.c().a("collectAPWithStretegy 1");
            w a2 = w.a(context);
            long a3 = a2.a(g.a);
            long currentTimeMillis = System.currentTimeMillis();
            long e = a2.e();
            ba c = ba.c();
            c.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + e);
            if (a3 == 0 || currentTimeMillis - a3 > e) {
                ba.c().a("collectAPWithStretegy 2");
                c.a(context);
            }
        }
    }

    private void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            ba.c().a("collectAPKWithStretegy 1");
            long currentTimeMillis = System.currentTimeMillis();
            w a2 = w.a(context);
            long a3 = a2.a(g.g);
            long h = a2.h();
            ba c = ba.c();
            c.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; interval : " + h);
            if (a3 == 0 || currentTimeMillis - a3 > h) {
                ba.c().a("collectAPKWithStretegy 2");
                c.b(context);
            }
        }
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (!bw.c().booleanValue()) {
                return false;
            }
            w a2 = w.a(context);
            long a3 = a2.a(g.i);
            long c = a2.c();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a3 > c) {
                ba c2 = ba.c();
                c2.a("need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
                return true;
            }
            ba c3 = ba.c();
            c3.a("no need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
            return false;
        }
        return invokeL.booleanValue;
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            w a2 = w.a(context);
            long a3 = a2.a(g.b);
            long f = a2.f();
            ba c = ba.c();
            c.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; userInterval : " + f);
            if (a3 == 0 || currentTimeMillis - a3 > f || !a2.a(a3)) {
                ba.c().a("collectUserAPPListWithStretegy 1");
                c.a(context, false);
            }
            long a4 = a2.a(g.c);
            long g = a2.g();
            ba c2 = ba.c();
            c2.a("now time: " + currentTimeMillis + ": last time: " + a4 + "; sysInterval : " + g);
            if (a4 == 0 || currentTimeMillis - a4 > g) {
                ba.c().a("collectSysAPPListWithStretegy 2");
                c.a(context, true);
            }
        }
    }

    private void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            w a2 = w.a(context);
            long a3 = a2.a(g.e);
            long i = a2.i();
            ba c = ba.c();
            c.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + i);
            if (a3 == 0 || currentTimeMillis - a3 > i) {
                ba.c().a("collectAPPTraceWithStretegy 2");
                c.b(context, false);
            }
        }
    }

    private void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            w.a(context).a(g.h, System.currentTimeMillis());
            JSONObject a2 = h.a(context);
            ba c = ba.c();
            c.a("header: " + a2);
            int i = 0;
            while (h(context)) {
                int i2 = i + 1;
                if (i > 0) {
                    h.c(a2);
                }
                b(context, a2);
                i = i2;
            }
        }
    }

    private boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, context)) == null) {
            if (!k.a.b(context) || !k.b.b(context) || !k.c.b(context) || !k.d.b(context) || !k.e.b(context)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, context, j) == null) {
            w.a(context).a(g.i, j);
        }
    }

    public void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            w.a(context).b(str);
        }
    }

    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            w.a(context).a(str);
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject) == null) {
            boolean z = true;
            if (bp.a().y(context) != 0) {
                i = bp.a().y(context) + 1;
            } else {
                i = 0;
            }
            this.d = i;
            ba.c().a("startDataAnynalyzed start");
            a(jSONObject);
            w a2 = w.a(context);
            boolean a3 = a2.a();
            ba c = ba.c();
            c.a("is data collect closed:" + a3);
            if (!a3) {
                if (!k.a.b(context, 10000)) {
                    c(context);
                }
                String str = android.os.Build.MANUFACTURER;
                z = (TextUtils.isEmpty(str) || !RomUtils.MANUFACTURER_HUAWEI.equals(str.trim().toLowerCase()) || Build.VERSION.SDK_INT < 28) ? false : false;
                if (!k.b.b(context, 10000) && !z) {
                    d(context);
                }
                if (!k.c.b(context, 10000) && !z) {
                    e(context);
                }
                if (z.e && !k.e.b(context, 10000) && !z) {
                    f(context);
                }
                boolean o = bw.o(context);
                if (o && a2.l()) {
                    ba.c().a("sendLog");
                    g(context);
                } else if (!o) {
                    ba.c().a("isWifiAvailable = false, will not sendLog");
                } else {
                    ba.c().a("can not sendLog due to time stratergy");
                }
            }
            ba.c().a("startDataAnynalyzed finished");
        }
    }
}
