package c.a.q0.r.a0;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.q0.j0.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    public static boolean f12814b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f12815c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f12816d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f12817e = null;

    /* renamed from: f  reason: collision with root package name */
    public static int f12818f = 99;

    /* renamed from: g  reason: collision with root package name */
    public static int f12819g = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1476277773, "Lc/a/q0/r/a0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1476277773, "Lc/a/q0/r/a0/a;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            g(TbadkCoreApplication.getInst());
            h();
            c("c14483", 0, f12819g < 1 ? 1 : 2);
            try {
                r(2, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (f12819g < 0) {
                f12819g = context.getSharedPreferences("settings", 0).getInt("app_restart_times", 0);
            }
            g(context);
            d("c14429", 1, f12819g < 1 ? 1 : 2);
            try {
                r(1, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void c(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, str, i2, i3) == null) {
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis())));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.commit();
        }
    }

    public static void d(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3) == null) {
            String str2 = str + "_lastTime";
            long j2 = a.getLong(str2, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d_%d", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - j2)));
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
            if (f12818f != 99) {
                return StringUtils.isNull(f12817e) ? "" : f12817e;
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
            h();
            return f12819g;
        }
        return invokeV.intValue;
    }

    public static void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, context) == null) && a == null) {
            a = context.getSharedPreferences("growth_funnel_sp", 0);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f12819g >= 0) {
            return;
        }
        f12819g = c.a.q0.r.j0.b.k().l("app_restart_times", 0);
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            h();
            TiebaStatic.log(new StatisticItem("c14484").addParam("obj_source", f12819g < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
            try {
                r(3, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void j(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j2) == null) {
            h();
            TiebaStatic.log(new StatisticItem("c14429").addParam("obj_type", 2).addParam("obj_source", f12819g < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, j2));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hotGap", j2);
                r(1, false, jSONObject);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void k(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            h();
            boolean z2 = true;
            TiebaStatic.log(new StatisticItem("c14430").addParam("obj_type", z ? 2 : 1).addParam("obj_source", f12819g < 1 ? 1 : 2).addParam("obj_param1", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, str));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isAgr", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2);
                if (z) {
                    z2 = false;
                }
                r(4, z2, jSONObject);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_type", b.a().b()).addParam("obj_param1", b.a().d() ? 1 : 2).addParam("obj_source", 5));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", b.a().b());
                r(5, b.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_type", b.a().b()).addParam("obj_param1", b.a().d() ? 1 : 2).addParam("obj_source", 6));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", b.a().b());
                r(6, b.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void n(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65550, null, i2, str) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", b.a().b()).addParam("obj_param1", b.a().d() ? 1 : 2).addParam("obj_source", 8));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", i2);
                jSONObject.put("pg", str);
                r(8, b.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", b.a().b()).addParam("obj_param1", b.a().d() ? 1 : 2).addParam("obj_source", 7));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", b.a().b());
                jSONObject.put("pg", str);
                r(7, b.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            h();
            g(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = a.edit();
            q("c14429", edit);
            q("c14483", edit);
            q("c14482", edit);
            a = null;
        }
    }

    public static void q(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, str, editor) == null) || (stringSet = a.getStringSet(str, null)) == null) {
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

    public static void r(int i2, boolean z, JSONObject jSONObject) throws JSONException {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), jSONObject}) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("cuid", ((i2 == 1 && z) || !PermissionUtil.isAgreePrivacyPolicy()) ? "unauthorized" : TbadkCoreApplication.getInst().getCuid());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", i2);
        jSONObject2.put("from", z ? 1 : 2);
        jSONObject2.put("source", f12819g >= 1 ? 2 : 1);
        jSONObject2.put("ext", jSONObject);
        uBCManager.onEvent("5109", jSONObject2);
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("start_type", f12818f + "");
            hashMap.put("start_scheme", e());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("uniqueKey", "kTBCUpdateLaunchTypeNotification");
            hashMap2.put("data", hashMap);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921542, hashMap2));
        }
    }

    public static void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65556, null, str, z) == null) {
            f12815c = str;
            f12816d = z ? 1 : 0;
        }
    }

    @Deprecated
    public static void u(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65557, null, str, i2) == null) || f12818f < 99) {
            return;
        }
        f12816d = i2;
        f12815c = str;
        v();
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            f12817e = f12815c;
            f12818f = f12816d;
            s();
        }
    }
}
