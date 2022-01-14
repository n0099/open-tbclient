package c.a.s0.s.y;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.h0.b;
import com.baidu.adp.lib.util.BdLog;
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
    public static boolean f13676b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f13677c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f13678d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f13679e = null;

    /* renamed from: f  reason: collision with root package name */
    public static int f13680f = 99;

    /* renamed from: g  reason: collision with root package name */
    public static int f13681g = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1970618120, "Lc/a/s0/s/y/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1970618120, "Lc/a/s0/s/y/a;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f(TbadkCoreApplication.getInst());
            g();
            c("c14483", 0, f13681g < 1 ? 1 : 2);
            try {
                m(2, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (f13681g < 0) {
                f13681g = context.getSharedPreferences("settings", 0).getInt("app_restart_times", 0);
            }
            f(context);
            d("c14429", 1, f13681g < 1 ? 1 : 2);
            try {
                m(1, true, null);
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
            return f13681g;
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
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || f13681g >= 0) {
            return;
        }
        f13681g = b.k().l("app_restart_times", 0);
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            g();
            TiebaStatic.log(new StatisticItem("c14484").addParam("obj_source", f13681g < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
            try {
                m(3, true, null);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65545, null, j2) == null) {
            g();
            TiebaStatic.log(new StatisticItem("c14429").addParam("obj_type", 2).addParam("obj_source", f13681g < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, j2));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hotGap", j2);
                m(1, false, jSONObject);
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
            TiebaStatic.log(new StatisticItem("c14430").addParam("obj_type", z ? 2 : 1).addParam("obj_source", f13681g < 1 ? 1 : 2).addParam("obj_param1", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, str));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isAgr", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2);
                if (z) {
                    z2 = false;
                }
                m(4, z2, jSONObject);
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            g();
            f(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = a.edit();
            l("c14429", edit);
            l("c14483", edit);
            l("c14482", edit);
            a = null;
        }
    }

    public static void l(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, str, editor) == null) || (stringSet = a.getStringSet(str, null)) == null) {
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

    public static void m(int i2, boolean z, JSONObject jSONObject) throws JSONException {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), jSONObject}) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("cuid", ((i2 == 1 && z) || !PermissionUtil.isAgreePrivacyPolicy()) ? "unauthorized" : TbadkCoreApplication.getInst().getCuid());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", i2);
        jSONObject2.put("from", z ? 1 : 2);
        jSONObject2.put("source", f13681g >= 1 ? 2 : 1);
        jSONObject2.put("ext", jSONObject);
        uBCManager.onEvent("5109", jSONObject2);
    }

    public static void n(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, str, z) == null) {
            f13677c = str;
            f13678d = z ? 1 : 0;
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            f13679e = f13677c;
            f13680f = f13678d;
        }
    }
}
