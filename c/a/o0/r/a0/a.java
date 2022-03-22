package c.a.o0.r.a0;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.o0.j0.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static SharedPreferences a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f10491b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f10492c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f10493d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f10494e = null;

    /* renamed from: f  reason: collision with root package name */
    public static int f10495f = 99;

    /* renamed from: g  reason: collision with root package name */
    public static int f10496g = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1083250763, "Lc/a/o0/r/a0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1083250763, "Lc/a/o0/r/a0/a;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            h(TbadkCoreApplication.getInst());
            i();
            c("c14483", 0, f10496g < 1 ? 1 : 2);
            try {
                s(2, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (f10496g < 0) {
                f10496g = context.getSharedPreferences("settings", 0).getInt("app_restart_times", 0);
            }
            h(context);
            d("c14429", 1, f10496g < 1 ? 1 : 2);
            try {
                s(1, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void c(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) {
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.commit();
        }
    }

    public static void d(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            String str2 = str + "_lastTime";
            long j = a.getLong(str2, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - j)));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.putLong(str2, currentTimeMillis);
            edit.commit();
        }
    }

    @NonNull
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f10495f != 99) {
                return StringUtils.isNull(f10494e) ? "" : f10494e;
            }
            String c2 = f.c();
            return m.isEmpty(c2) ? "" : c2;
        }
        return (String) invokeV.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            i();
            return f10496g;
        }
        return invokeV.intValue;
    }

    public static String g(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (dataString == null || !dataString.startsWith("custom")) {
                return dataString;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(dataString);
            sb.append(".action.");
            sb.append(intent.getAction());
            if (intent.getCategories() != null) {
                sb.append("categories.");
                for (String str : intent.getCategories()) {
                    sb.append(str);
                    sb.append(".");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, context) == null) && a == null) {
            a = context.getSharedPreferences("growth_funnel_sp", 0);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || f10496g >= 0) {
            return;
        }
        f10496g = c.a.o0.r.j0.b.k().l("app_restart_times", 0);
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            i();
            TiebaStatic.log(new StatisticItem("c14484").addParam("obj_source", f10496g < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
            try {
                s(3, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65547, null, j) == null) {
            i();
            TiebaStatic.log(new StatisticItem("c14429").addParam("obj_type", 2).addParam("obj_source", f10496g < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, j));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hotGap", j);
                s(1, false, jSONObject);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void l(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, str, z) == null) {
            i();
            boolean z2 = true;
            TiebaStatic.log(new StatisticItem("c14430").addParam("obj_type", z ? 2 : 1).addParam("obj_source", f10496g < 1 ? 1 : 2).addParam("obj_param1", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, str));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isAgr", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2);
                if (z) {
                    z2 = false;
                }
                s(4, z2, jSONObject);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_type", c.a().b()).addParam("obj_param1", c.a().d() ? 1 : 2).addParam("obj_source", 5));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", c.a().b());
                s(5, c.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_type", c.a().b()).addParam("obj_param1", c.a().d() ? 1 : 2).addParam("obj_source", 6));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", c.a().b());
                s(6, c.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void o(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65551, null, i, str) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", c.a().b()).addParam("obj_param1", c.a().d() ? 1 : 2).addParam("obj_source", 8));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", i);
                jSONObject.put("pg", str);
                s(8, c.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", c.a().b()).addParam("obj_param1", c.a().d() ? 1 : 2).addParam("obj_source", 7));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", c.a().b());
                jSONObject.put("pg", str);
                s(7, c.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            i();
            h(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = a.edit();
            r("c14429", edit);
            r("c14483", edit);
            r("c14482", edit);
            a = null;
        }
    }

    public static void r(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, str, editor) == null) || (stringSet = a.getStringSet(str, null)) == null) {
            return;
        }
        for (String str2 : stringSet) {
            String[] split = str2.split("_");
            if (split != null) {
                if (split.length == 3) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]));
                } else if (split.length == 4) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]).addParam(TiebaStatic.Params.OBJ_PARAM4, split[3]));
                }
            }
        }
        editor.remove(str).apply();
    }

    public static void s(int i, boolean z, JSONObject jSONObject) throws JSONException {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), jSONObject}) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("cuid", ((i == 1 && z) || !PermissionUtil.isAgreePrivacyPolicy()) ? "unauthorized" : TbadkCoreApplication.getInst().getCuid());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", i);
        jSONObject2.put("from", z ? 1 : 2);
        jSONObject2.put("source", f10496g >= 1 ? 2 : 1);
        jSONObject2.put("ext", jSONObject);
        uBCManager.onEvent("5109", jSONObject2);
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("start_type", f10495f + "");
            hashMap.put("start_scheme", e());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("uniqueKey", "kTBCUpdateLaunchTypeNotification");
            hashMap2.put("data", hashMap);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921542, hashMap2));
        }
    }

    public static void u(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65557, null, str, z) == null) {
            f10492c = str;
            f10493d = z ? 1 : 0;
        }
    }

    public static void v(Activity activity) {
        ActivityManager activityManager;
        ActivityManager.AppTask appTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, activity) == null) || activity == null || activity.getClass() == null || Build.VERSION.SDK_INT < 23 || (activityManager = (ActivityManager) activity.getSystemService("activity")) == null || (appTask = (ActivityManager.AppTask) ListUtils.getItem(activityManager.getAppTasks(), 0)) == null || appTask.getTaskInfo() == null || appTask.getTaskInfo().baseActivity == null || !activity.getClass().getName().equals(appTask.getTaskInfo().baseActivity.getClassName())) {
            return;
        }
        String g2 = g(appTask.getTaskInfo().baseIntent);
        u(g2, m.isEmpty(g2));
        z();
    }

    public static void w(ActivityManager.AppTask appTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, appTask) == null) || appTask == null || appTask.getTaskInfo() == null || f10495f < 99) {
            return;
        }
        if (appTask.getTaskInfo().baseIntent != null) {
            String g2 = g(appTask.getTaskInfo().baseIntent);
            u(g2, m.isEmpty(g2));
            z();
        } else if (Build.VERSION.SDK_INT < 23 || appTask.getTaskInfo().baseActivity == null || !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(appTask.getTaskInfo().baseActivity.getClassName()) || !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(appTask.getTaskInfo().topActivity.getClassName())) {
        } else {
            u(null, m.isEmpty(null));
            z();
        }
    }

    public static void x(Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, null, message) == null) || message == null || f10495f < 99) {
            return;
        }
        Object obj = message.obj;
        if (obj == null) {
            y("msg.obj=null", 100);
            return;
        }
        String name = obj.getClass().getName();
        Object d2 = c.a.d.f.b.a.a.d(message.obj, "intent");
        boolean z = d2 instanceof Intent;
        String g2 = z ? g((Intent) d2) : "no intent";
        ComponentName component = z ? ((Intent) d2).getComponent() : null;
        if (name.contains("ReceiverData")) {
            f10493d = 98;
            f10492c = "CallReceiver_" + component + "_" + g2;
        } else if (name.contains("CreateServiceData")) {
            f10493d = 98;
            f10492c = "CallCreateService_" + component + "_" + g2;
        } else if (name.contains("BindServiceData")) {
            f10493d = 98;
            f10492c = "CallBindService_" + component + "_" + g2;
        } else if (component != null && SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(component.getClassName())) {
            u(g2, m.isEmpty(g2));
        } else {
            f10493d = 101;
            if (!m.isEmpty(f10492c) && f10492c.length() >= 10000) {
                f10492c = "tooLong_" + message.toString();
            } else {
                f10492c += message.toString();
            }
        }
        z();
    }

    @Deprecated
    public static void y(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65561, null, str, i) == null) {
            int i2 = f10495f;
            if (i2 == 99 || i2 == 100) {
                f10493d = i;
                f10492c = str;
                z();
            }
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            f10494e = f10492c;
            f10495f = f10493d;
            t();
        }
    }
}
