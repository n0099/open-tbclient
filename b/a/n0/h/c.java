package b.a.n0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f3662a;

    /* renamed from: b  reason: collision with root package name */
    public static String f3663b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3664c;

    /* renamed from: d  reason: collision with root package name */
    public static String f3665d;

    /* renamed from: e  reason: collision with root package name */
    public static String f3666e;
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
                if (TextUtils.isEmpty(f3662a)) {
                    f3662a = b.a.n0.l.c.e(context);
                }
                return TextUtils.isEmpty(f3662a) ? "" : f3662a;
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
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
                jSONObject.put("8", b.a.n0.a.f3491b);
                jSONObject.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject.put("10", "1.0.7");
                jSONObject.put("14", b.a.n0.l.c.j(context));
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, e(context));
                jSONObject.put("26", b.a.n0.g.a.a(context));
                jSONObject.put("31", b.a.n0.b.a.h(context).J());
                return jSONObject;
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
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
                if (TextUtils.isEmpty(f3663b)) {
                    f3663b = b.a.n0.l.c.h(context);
                }
                return TextUtils.isEmpty(f3663b) ? "" : f3663b;
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
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
                if (!TextUtils.isEmpty(f3666e)) {
                    return f3666e;
                }
                String b2 = b.a.n0.g.a.b(context, true, false);
                f3666e = b2;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(f3664c)) {
                    f3664c = context.getPackageName();
                }
                return TextUtils.isEmpty(f3664c) ? "" : f3664c;
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(f3665d)) {
                    return f3665d;
                }
                String j = b.a.n0.l.d.j(context);
                f3665d = j;
                return j;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public b.a.n0.j.a a(Context context, String str, String str2, int i2, int i3) {
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
                b.a.n0.j.a aVar = new b.a.n0.j.a();
                aVar.e(i2);
                aVar.c(c2.toString());
                aVar.g(i3);
                return aVar;
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
                return null;
            }
        }
        return (b.a.n0.j.a) invokeCommon.objValue;
    }
}
