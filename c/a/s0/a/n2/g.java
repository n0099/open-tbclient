package c.a.s0.a.n2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.n2.c;
import c.a.s0.a.z2.q0;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f8145b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(235067365, "Lc/a/s0/a/n2/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(235067365, "Lc/a/s0/a/n2/g;");
                return;
            }
        }
        a = c.a.s0.a.k.a;
        f8145b = c.a.s0.a.c1.a.g0().v() * 1024;
    }

    public static boolean a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? !TextUtils.isEmpty(str) && str.getBytes().length > f8145b : invokeL.booleanValue;
    }

    public static boolean b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (c()) {
                boolean a2 = a(str);
                if (a2) {
                    d(str);
                }
                return a2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f8145b > 0 : invokeV.booleanValue;
    }

    public static void d(@NonNull String str) {
        c.a.s0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || (a0 = c.a.s0.a.d2.e.a0()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            b.a V = a0.V();
            SwanCoreVersion M = c.a.s0.a.g1.f.U().M();
            int l = a0.l();
            jSONObject.putOpt("scheme", V.W());
            jSONObject.putOpt("swanjs", c.a.s0.a.q2.b.i(M, l));
            if (str != null && str.length() > 1024) {
                jSONObject.putOpt("params", str.substring(0, 1024));
            }
            c.b bVar = new c.b(10020);
            bVar.j(q0.n().f());
            bVar.i(jSONObject.toString());
            bVar.h(a0.getAppId());
            bVar.m();
            c.a.s0.a.e0.d.k("SwanAppParamChecker", "10020, params: " + str);
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
    }
}
