package c.a.r0.s.z;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.b.d;
import c.a.r0.s.g0.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mytransformapp.util.LogUtil;
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
    public static String f13626b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f13627c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static String f13628d = null;

    /* renamed from: e  reason: collision with root package name */
    public static int f13629e = 99;

    /* renamed from: f  reason: collision with root package name */
    public static int f13630f = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-163133866, "Lc/a/r0/s/z/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-163133866, "Lc/a/r0/s/z/a;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            g(TbadkCoreApplication.getInst());
            h();
            d("c14483", 0, f13630f >= 1 ? 2 : 1);
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (f13630f < 0) {
                f13630f = context.getSharedPreferences("settings", 0).getInt("app_restart_times", 0);
            }
            g(context);
            e("c14429", 1, f13630f < 1 ? 1 : 2);
        }
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            g(TbadkCoreApplication.getInst());
            h();
            d("c14482", i2, f13630f >= 1 ? 2 : 1);
        }
    }

    public static void d(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3) == null) {
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

    public static void e(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65541, null, str, i2, i3) == null) {
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

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            h();
            return f13630f;
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
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f13630f >= 0) {
            return;
        }
        f13630f = b.j().k("app_restart_times", 0);
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            h();
            TiebaStatic.log(new StatisticItem("c14484").addParam("obj_source", f13630f >= 1 ? 2 : 1).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
            n(3);
        }
    }

    public static void j(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j2) == null) {
            h();
            TiebaStatic.log(new StatisticItem("c14429").addParam("obj_type", 2).addParam("obj_source", f13630f < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, j2));
        }
    }

    public static void k(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            h();
            TiebaStatic.log(new StatisticItem("c14430").addParam("obj_type", z ? 2 : 1).addParam("obj_source", f13630f < 1 ? 1 : 2).addParam("obj_param1", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, str));
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            h();
            g(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = a.edit();
            m("c14429", edit);
            m("c14483", edit);
            m("c14482", edit);
            a = null;
        }
    }

    public static void m(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, str, editor) == null) || (stringSet = a.getStringSet(str, null)) == null) {
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

    public static void n(int i2) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, null, i2) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("position", i2);
            jSONObject.put("isLaunchUpA", d.E());
            jSONObject.put("cuid", TbadkCoreApplication.getInst().getCuid());
            jSONObject.put("galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            jSONObject.put("galaxy3", TbadkCoreApplication.getInst().getCuidGalaxy3());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("value", jSONObject);
            uBCManager.onEvent(LogUtil.LOG_ID, jSONObject2);
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void o(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, null, str, z) == null) {
            f13626b = str;
            f13627c = z ? 1 : 0;
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            f13628d = f13626b;
            f13629e = f13627c;
        }
    }
}
