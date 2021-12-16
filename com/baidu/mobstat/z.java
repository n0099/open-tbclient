package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
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
/* loaded from: classes10.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public static final z a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366709462, "Lcom/baidu/mobstat/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366709462, "Lcom/baidu/mobstat/z;");
                return;
            }
        }
        a = new z();
    }

    public z() {
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

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            bb.c().a("collectAPWithStretegy 1");
            y a2 = y.a(context);
            long a3 = a2.a(g.a);
            long currentTimeMillis = System.currentTimeMillis();
            long e2 = a2.e();
            bb c2 = bb.c();
            c2.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + e2);
            if (a3 == 0 || currentTimeMillis - a3 > e2) {
                bb.c().a("collectAPWithStretegy 2");
                c.a(context);
            }
        }
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            bb.c().a("collectAPPListWithStretegy 1");
            long currentTimeMillis = System.currentTimeMillis();
            y a2 = y.a(context);
            long a3 = a2.a(g.f37976b);
            long f2 = a2.f();
            bb c2 = bb.c();
            c2.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; userInterval : " + f2);
            if (a3 == 0 || currentTimeMillis - a3 > f2 || !a2.a(a3)) {
                bb.c().a("collectUserAPPListWithStretegy 2");
                c.a(context, false);
            }
            long a4 = a2.a(g.f37977c);
            long g2 = a2.g();
            bb c3 = bb.c();
            c3.a("now time: " + currentTimeMillis + ": last time: " + a4 + "; sysInterval : " + g2);
            if (a4 == 0 || currentTimeMillis - a4 > g2) {
                bb.c().a("collectSysAPPListWithStretegy 2");
                c.a(context, true);
            }
        }
    }

    private void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            bb.c().a("collectAPPTraceWithStretegy 1");
            long currentTimeMillis = System.currentTimeMillis();
            y a2 = y.a(context);
            long a3 = a2.a(g.f37979e);
            long i2 = a2.i();
            bb c2 = bb.c();
            c2.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + i2);
            if (a3 == 0 || currentTimeMillis - a3 > i2) {
                bb.c().a("collectAPPTraceWithStretegy 2");
                c.b(context, false);
            }
        }
    }

    private void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            bb.c().a("collectAPKWithStretegy 1");
            long currentTimeMillis = System.currentTimeMillis();
            y a2 = y.a(context);
            long a3 = a2.a(g.f37981g);
            long h2 = a2.h();
            bb c2 = bb.c();
            c2.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; interval : " + h2);
            if (a3 == 0 || currentTimeMillis - a3 > h2) {
                bb.c().a("collectAPKWithStretegy 2");
                c.b(context);
            }
        }
    }

    private void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            y.a(context).a(g.f37982h, System.currentTimeMillis());
            JSONObject a2 = h.a(context);
            bb c2 = bb.c();
            c2.a("header: " + a2);
            int i2 = 0;
            while (a()) {
                int i3 = i2 + 1;
                if (i2 > 0) {
                    h.c(a2);
                }
                b(context, a2);
                i2 = i3;
            }
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject) == null) {
            bb.c().a("startDataAnynalyzed start");
            a(jSONObject);
            y a2 = y.a(context);
            boolean a3 = a2.a();
            bb c2 = bb.c();
            c2.a("is data collect closed:" + a3);
            if (!a3) {
                if (!k.a.b(10000)) {
                    c(context);
                }
                String str = android.os.Build.MANUFACTURER;
                int i2 = Build.VERSION.SDK_INT;
                boolean z = false;
                if (!TextUtils.isEmpty(str) && RomUtils.MANUFACTURER_HUAWEI.equals(str.trim().toLowerCase()) && i2 >= 28) {
                    z = true;
                }
                if (!k.f37988b.b(10000) && !z) {
                    d(context);
                }
                if (!k.f37989c.b(10000) && !z) {
                    e(context);
                }
                if (ab.f37445e && !k.f37991e.b(10000) && !z) {
                    f(context);
                }
                boolean q = bw.q(context);
                if (q && a2.l()) {
                    bb.c().a("sendLog");
                    g(context);
                } else if (!q) {
                    bb.c().a("isWifiAvailable = false, will not sendLog");
                } else {
                    bb.c().a("can not sendLog due to time stratergy");
                }
            }
            bb.c().a("startDataAnynalyzed finished");
        }
    }

    public void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            y.a(context).b(str);
        }
    }

    private void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            int i2 = 0;
            try {
                jSONObject2.put("he", jSONObject);
                i2 = 0 + jSONObject.toString().length();
            } catch (JSONException e2) {
                bb.c().a(e2);
            }
            bb.c().a("APP_MEM");
            if (!y.a(context).b()) {
                String x = bw.x(context);
                JSONArray jSONArray = new JSONArray();
                bb.c().a(x);
                jSONArray.put(x);
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject2.put("app_mem3", jSONArray);
                        i2 += jSONArray.toString().length();
                    } catch (JSONException e3) {
                        bb.c().a(e3);
                    }
                }
            }
            bb.c().a("APP_APK");
            List<String> a2 = k.f37991e.a(LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA);
            JSONArray jSONArray2 = new JSONArray();
            for (String str : a2) {
                bb.c().a(str);
                jSONArray2.put(str);
            }
            if (jSONArray2.length() > 0) {
                try {
                    jSONObject2.put("app_apk3", jSONArray2);
                    i2 += jSONArray2.toString().length();
                } catch (JSONException e4) {
                    bb.c().a(e4);
                }
            }
            bb.c().a("APP_CHANGE");
            List<String> a3 = k.f37990d.a(10240);
            JSONArray jSONArray3 = new JSONArray();
            for (String str2 : a3) {
                bb.c().a(str2);
                jSONArray3.put(str2);
            }
            if (jSONArray3.length() > 0) {
                try {
                    jSONObject2.put("app_change3", jSONArray3);
                    i2 += jSONArray3.toString().length();
                } catch (JSONException e5) {
                    bb.c().a(e5);
                }
            }
            bb.c().a("APP_TRACE");
            List<String> a4 = k.f37989c.a(15360);
            JSONArray jSONArray4 = new JSONArray();
            for (String str3 : a4) {
                bb.c().a(str3);
                jSONArray4.put(str3);
            }
            if (jSONArray4.length() > 0) {
                try {
                    jSONObject2.put("app_trace3", jSONArray4);
                    i2 += jSONArray4.toString().length();
                } catch (JSONException e6) {
                    bb.c().a(e6);
                }
            }
            bb.c().a("APP_LIST");
            List<String> a5 = k.f37988b.a(46080);
            JSONArray jSONArray5 = new JSONArray();
            for (String str4 : a5) {
                bb.c().a(str4);
                jSONArray5.put(str4);
            }
            if (jSONArray5.length() > 0) {
                try {
                    jSONObject2.put("app_list3", jSONArray5);
                    i2 += jSONArray5.toString().length();
                } catch (JSONException e7) {
                    bb.c().a(e7);
                }
            }
            bb.c().a("AP_LIST");
            List<String> a6 = k.a.a(184320 - i2);
            JSONArray jSONArray6 = new JSONArray();
            for (String str5 : a6) {
                bb.c().a(str5);
                jSONArray6.put(str5);
            }
            if (jSONArray6.length() > 0) {
                try {
                    jSONObject2.put("ap_list3", jSONArray6);
                    i2 += jSONArray6.toString().length();
                } catch (JSONException e8) {
                    bb.c().a(e8);
                }
            }
            bb c2 = bb.c();
            c2.a("log in bytes is almost :" + i2);
            JSONArray jSONArray7 = new JSONArray();
            jSONArray7.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("payload", jSONArray7);
                s.a().a(context, jSONObject3.toString());
            } catch (Exception e9) {
                bb.c().a(e9);
            }
        }
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, jSONObject) == null) {
            ac acVar = new ac(jSONObject);
            ab.f37442b = acVar.a;
            ab.f37443c = acVar.f37446b;
            ab.f37444d = acVar.f37447c;
        }
    }

    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            y.a(context).a(str);
        }
    }

    public void a(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, context, j2) == null) {
            y.a(context).a(g.f37983i, j2);
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? (k.a.b() && k.f37988b.b() && k.f37989c.b() && k.f37990d.b() && k.f37991e.b()) ? false : true : invokeV.booleanValue;
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (bw.c().booleanValue()) {
                y a2 = y.a(context);
                long a3 = a2.a(g.f37983i);
                long c2 = a2.c();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - a3 > c2) {
                    bb c3 = bb.c();
                    c3.a("need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c2);
                    return true;
                }
                bb c4 = bb.c();
                c4.a("no need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c2);
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? !y.a(context).a() || a(context) : invokeL.booleanValue;
    }
}
