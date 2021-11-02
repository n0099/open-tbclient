package b.a.e0.k.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Long f2622a;

    /* renamed from: b  reason: collision with root package name */
    public static Long f2623b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1922771234, "Lb/a/e0/k/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1922771234, "Lb/a/e0/k/h/a;");
                return;
            }
        }
        f2622a = 0L;
        f2623b = 0L;
    }

    public static final void a() {
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (l = f2623b) == null) {
            return;
        }
        if (l == null) {
            Intrinsics.throwNpe();
        }
        if (l.longValue() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                Long l2 = f2623b;
                if (l2 == null) {
                    Intrinsics.throwNpe();
                }
                jSONObject.put("3", l2.longValue());
                jSONObject.put("4", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            b bVar = new b(Constants.DEFAULT_UIN);
            bVar.b(jSONObject);
            d.b(bVar);
            f2623b = 0L;
        }
    }

    public static final void b() {
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (l = f2622a) == null) {
            return;
        }
        if (l == null) {
            Intrinsics.throwNpe();
        }
        if (l.longValue() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                Long l2 = f2622a;
                if (l2 == null) {
                    Intrinsics.throwNpe();
                }
                jSONObject.put("1", l2.longValue());
                jSONObject.put("2", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            b bVar = new b(Constants.DEFAULT_UIN);
            bVar.b(jSONObject);
            d.b(bVar);
            f2622a = 0L;
        }
    }

    public static final void c(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, l) == null) {
            f2622a = l;
        }
    }

    public static final void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3) == null) {
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
            b bVar = new b(str);
            bVar.b(jSONObject);
            d.b(bVar);
        }
    }

    public static final void e(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, l) == null) {
            f2623b = l;
        }
    }

    public static final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionCode", 1);
            } catch (Exception unused) {
            }
            b bVar = new b(str);
            bVar.b(jSONObject);
            d.b(bVar);
        }
    }

    public static final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionCode", 0);
            } catch (Exception unused) {
            }
            b bVar = new b(str);
            bVar.b(jSONObject);
            d.b(bVar);
        }
    }
}
