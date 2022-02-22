package c.a.q0.h;

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
    public static String f4900b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4901c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4902d;

    /* renamed from: e  reason: collision with root package name */
    public static String f4903e;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    a = c.a.q0.l.c.e(context);
                }
                return TextUtils.isEmpty(a) ? "" : a;
            } catch (Throwable th) {
                c.a.q0.l.c.d(th);
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
                jSONObject.put("2", f(context));
                jSONObject.put("4", g(context));
                jSONObject.put("5", str);
                jSONObject.put("6", System.currentTimeMillis());
                jSONObject.put("7", "0");
                jSONObject.put("8", c.a.q0.a.f4756b);
                jSONObject.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject.put("10", "1.0.7");
                jSONObject.put("14", c.a.q0.l.c.j(context));
                jSONObject.put("23", e(context));
                jSONObject.put("26", c.a.q0.g.a.a(context));
                jSONObject.put("31", c.a.q0.b.a.h(context).J());
                return jSONObject;
            } catch (Throwable th) {
                c.a.q0.l.c.d(th);
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
                if (TextUtils.isEmpty(f4900b)) {
                    f4900b = c.a.q0.l.c.h(context);
                }
                return TextUtils.isEmpty(f4900b) ? "" : f4900b;
            } catch (Throwable th) {
                c.a.q0.l.c.d(th);
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
                if (!TextUtils.isEmpty(f4903e)) {
                    return f4903e;
                }
                String b2 = c.a.q0.g.a.b(context, true, false);
                f4903e = b2;
                return b2;
            } catch (Throwable unused) {
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
                if (TextUtils.isEmpty(f4901c)) {
                    f4901c = context.getPackageName();
                }
                return TextUtils.isEmpty(f4901c) ? "" : f4901c;
            } catch (Throwable th) {
                c.a.q0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(f4902d)) {
                    return f4902d;
                }
                String j2 = c.a.q0.l.d.j(context);
                f4902d = j2;
                return j2;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public c.a.q0.j.a a(Context context, String str, String str2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(str);
                JSONObject c2 = c(context, str2);
                c2.put("module_section", jSONArray);
                c.a.q0.j.a aVar = new c.a.q0.j.a();
                aVar.e(i2);
                aVar.c(c2.toString());
                aVar.g(i3);
                return aVar;
            } catch (Throwable th) {
                c.a.q0.l.c.d(th);
                return null;
            }
        }
        return (c.a.q0.j.a) invokeCommon.objValue;
    }
}
