package b.a.e0.p;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e0.r.h;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static long f2659a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f2660b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1785557931, "Lb/a/e0/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1785557931, "Lb/a/e0/p/b;");
                return;
            }
        }
        f2660b = new JSONObject();
    }

    public static final void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, str, j) == null) {
            try {
                if (f2660b == null) {
                    f2660b = new JSONObject();
                }
                JSONObject jSONObject = f2660b;
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || f2659a <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("3", f2659a);
            jSONObject.put("4", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        c cVar = new c(Constants.DEFAULT_UIN);
        cVar.c(jSONObject);
        f.e(cVar);
        f2659a = 0L;
    }

    public static final void e() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || (jSONObject = f2660b) == null) {
            return;
        }
        if ((jSONObject != null ? jSONObject.length() : 0) > 0) {
            a("2", System.currentTimeMillis());
            c cVar = new c(Constants.DEFAULT_UIN);
            cVar.c(f2660b);
            f.e(cVar);
            f2660b = null;
        }
    }

    public static final void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j) == null) {
            f2659a = j;
        }
    }

    public static final void g(int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), str, str2, str3, str4}) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exceptionType", i2);
            jSONObject.put("payChannel", str2);
            jSONObject.put("errCode", str3);
            jSONObject.put("errMsg", str4);
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
