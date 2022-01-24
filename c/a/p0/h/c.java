package c.a.p0.h;

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
    public static String f4825b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4826c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4827d;

    /* renamed from: e  reason: collision with root package name */
    public static String f4828e;
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
                    a = c.a.p0.l.c.e(context);
                }
                return TextUtils.isEmpty(a) ? "" : a;
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
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
                jSONObject.put("8", c.a.p0.a.f4681b);
                jSONObject.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject.put("10", "1.0.7");
                jSONObject.put("14", c.a.p0.l.c.j(context));
                jSONObject.put("23", e(context));
                jSONObject.put("26", c.a.p0.g.a.a(context));
                jSONObject.put("31", c.a.p0.b.a.h(context).J());
                return jSONObject;
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
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
                if (TextUtils.isEmpty(f4825b)) {
                    f4825b = c.a.p0.l.c.h(context);
                }
                return TextUtils.isEmpty(f4825b) ? "" : f4825b;
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
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
                if (!TextUtils.isEmpty(f4828e)) {
                    return f4828e;
                }
                String b2 = c.a.p0.g.a.b(context, true, false);
                f4828e = b2;
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
                if (TextUtils.isEmpty(f4826c)) {
                    f4826c = context.getPackageName();
                }
                return TextUtils.isEmpty(f4826c) ? "" : f4826c;
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
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
                if (!TextUtils.isEmpty(f4827d)) {
                    return f4827d;
                }
                String j2 = c.a.p0.l.d.j(context);
                f4827d = j2;
                return j2;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public c.a.p0.j.a a(Context context, String str, String str2, int i2, int i3) {
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
                c.a.p0.j.a aVar = new c.a.p0.j.a();
                aVar.e(i2);
                aVar.c(c2.toString());
                aVar.g(i3);
                return aVar;
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
                return null;
            }
        }
        return (c.a.p0.j.a) invokeCommon.objValue;
    }
}
