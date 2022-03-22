package c.a.l0.i;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f3646b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3647c;

    /* renamed from: d  reason: collision with root package name */
    public static String f3648d;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(a)) {
                    a = c.a.l0.m.c.e(context);
                }
                return TextUtils.isEmpty(a) ? "" : a;
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", b(context));
                jSONObject.put("3", d(context));
                jSONObject.put("2", e(context));
                jSONObject.put("4", f(context));
                jSONObject.put("5", str);
                jSONObject.put("6", System.currentTimeMillis());
                jSONObject.put("7", "0");
                jSONObject.put("8", c.a.l0.a.f3508b);
                jSONObject.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject.put("10", "1.1.1");
                jSONObject.put("14", c.a.l0.m.c.i(context));
                jSONObject.put("23", c.a.l0.h.a.a(context));
                jSONObject.put("26", "");
                jSONObject.put("31", c.a.l0.b.a.f(context).J());
                return jSONObject;
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(f3646b)) {
                    f3646b = c.a.l0.m.c.g(context);
                }
                return TextUtils.isEmpty(f3646b) ? "" : f3646b;
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(f3647c)) {
                    f3647c = context.getPackageName();
                }
                return TextUtils.isEmpty(f3647c) ? "" : f3647c;
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(f3648d)) {
                    return f3648d;
                }
                String b2 = c.a.l0.m.d.b(context);
                f3648d = b2;
                return b2;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public c.a.l0.k.a a(Context context, String str, String str2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(str);
                JSONObject c2 = c(context, str2);
                c2.put("module_section", jSONArray);
                c.a.l0.k.a aVar = new c.a.l0.k.a();
                aVar.e(i);
                aVar.c(c2.toString());
                aVar.g(i2);
                return aVar;
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return null;
            }
        }
        return (c.a.l0.k.a) invokeCommon.objValue;
    }
}
