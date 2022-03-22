package c.a.e0.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.i.h;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f2783b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(712189887, "Lc/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712189887, "Lc/a/e0/g/b;");
                return;
            }
        }
        f2783b = new JSONObject();
    }

    public static final void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, str, j) == null) {
            try {
                if (f2783b == null) {
                    f2783b = new JSONObject();
                }
                JSONObject jSONObject = f2783b;
                if (jSONObject != null) {
                    jSONObject.put(str, j);
                }
            } catch (Exception unused) {
                h.g("add panelShow json error");
            }
        }
    }

    public static final void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionCode", 3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("errno", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("errmsg", str3);
                }
            } catch (Exception unused) {
            }
            c cVar = new c(str);
            cVar.c(jSONObject);
            f.e(cVar);
        }
    }

    public static final void c(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, hashMap) == null) {
            if (hashMap != null) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                c cVar = new c(str);
                cVar.c(jSONObject);
                f.e(cVar);
                return;
            }
            f.e(new c(str));
        }
    }

    public static final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || a <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("3", a);
            jSONObject.put("4", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        c cVar = new c(Constants.DEFAULT_UIN);
        cVar.c(jSONObject);
        f.e(cVar);
        a = 0L;
    }

    public static final void e() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || (jSONObject = f2783b) == null) {
            return;
        }
        if ((jSONObject != null ? jSONObject.length() : 0) > 0) {
            a("2", System.currentTimeMillis());
            c cVar = new c(Constants.DEFAULT_UIN);
            cVar.c(f2783b);
            f.e(cVar);
            f2783b = null;
        }
    }

    public static final void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j) == null) {
            a = j;
        }
    }

    public static final void g(int i, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), str, str2, str3, str4}) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exceptionType", i);
            jSONObject.put("payChannel", str2);
            jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, str3);
            jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str4);
            c cVar = new c(str);
            cVar.c(jSONObject);
            f.e(cVar);
        }
    }

    public static final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionCode", 0);
            } catch (Exception unused) {
            }
            c cVar = new c(str);
            cVar.c(jSONObject);
            f.e(cVar);
        }
    }
}
