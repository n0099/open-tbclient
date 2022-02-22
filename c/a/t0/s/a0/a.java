package c.a.t0.s.a0;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static SharedPreferences a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f13398b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f13399c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f13400d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f13401e = null;

    /* renamed from: f  reason: collision with root package name */
    public static int f13402f = 99;

    /* renamed from: g  reason: collision with root package name */
    public static int f13403g = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1178314607, "Lc/a/t0/s/a0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1178314607, "Lc/a/t0/s/a0/a;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f(TbadkCoreApplication.getInst());
            g();
            c("c14483", 0, f13403g < 1 ? 1 : 2);
            try {
                q(2, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (f13403g < 0) {
                f13403g = context.getSharedPreferences("settings", 0).getInt("app_restart_times", 0);
            }
            f(context);
            d("c14429", 1, f13403g < 1 ? 1 : 2);
            try {
                q(1, true, null);
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

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            g();
            return f13403g;
        }
        return invokeV.intValue;
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, context) == null) && a == null) {
            a = context.getSharedPreferences("growth_funnel_sp", 0);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || f13403g >= 0) {
            return;
        }
        f13403g = c.a.t0.s.j0.b.k().l("app_restart_times", 0);
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            g();
            TiebaStatic.log(new StatisticItem("c14484").addParam("obj_source", f13403g < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
            try {
                q(3, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65545, null, j2) == null) {
            g();
            TiebaStatic.log(new StatisticItem("c14429").addParam("obj_type", 2).addParam("obj_source", f13403g < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, j2));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hotGap", j2);
                q(1, false, jSONObject);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void j(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, str, z) == null) {
            g();
            boolean z2 = true;
            TiebaStatic.log(new StatisticItem("c14430").addParam("obj_type", z ? 2 : 1).addParam("obj_source", f13403g < 1 ? 1 : 2).addParam("obj_param1", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, str));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isAgr", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2);
                if (z) {
                    z2 = false;
                }
                q(4, z2, jSONObject);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_type", b.a().b()).addParam("obj_param1", b.a().d() ? 1 : 2).addParam("obj_source", 5));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", b.a().b());
                q(5, b.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_type", b.a().b()).addParam("obj_param1", b.a().d() ? 1 : 2).addParam("obj_source", 6));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", b.a().b());
                q(6, b.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void m(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65549, null, i2, str) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", b.a().b()).addParam("obj_param1", b.a().d() ? 1 : 2).addParam("obj_source", 8));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", i2);
                jSONObject.put("pg", str);
                q(8, b.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", b.a().b()).addParam("obj_param1", b.a().d() ? 1 : 2).addParam("obj_source", 7));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_type", b.a().b());
                jSONObject.put("pg", str);
                q(7, b.a().d(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            g();
            f(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = a.edit();
            p("c14429", edit);
            p("c14483", edit);
            p("c14482", edit);
            a = null;
        }
    }

    public static void p(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, str, editor) == null) || (stringSet = a.getStringSet(str, null)) == null) {
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

    public static void q(int i2, boolean z, JSONObject jSONObject) throws JSONException {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), jSONObject}) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("cuid", ((i2 == 1 && z) || !PermissionUtil.isAgreePrivacyPolicy()) ? "unauthorized" : TbadkCoreApplication.getInst().getCuid());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", i2);
        jSONObject2.put("from", z ? 1 : 2);
        jSONObject2.put("source", f13403g >= 1 ? 2 : 1);
        jSONObject2.put("ext", jSONObject);
        uBCManager.onEvent("5109", jSONObject2);
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(f13402f);
            String str = "";
            sb.append("");
            hashMap.put("start_type", sb.toString());
            try {
                if (!StringUtils.isNull(f13401e)) {
                    str = URLEncoder.encode(f13401e, "utf-8");
                }
                hashMap.put("start_scheme", str);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("uniqueKey", "kTBCUpdateLaunchTypeNotification");
            hashMap2.put("data", hashMap);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921542, hashMap2));
        }
    }

    public static void s(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65555, null, str, z) == null) {
            f13399c = str;
            f13400d = z ? 1 : 0;
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            f13401e = f13399c;
            f13402f = f13400d;
            r();
        }
    }
}
