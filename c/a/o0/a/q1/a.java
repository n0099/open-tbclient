package c.a.o0.a.q1;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.h;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8032e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f8033f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8034a;

    /* renamed from: b  reason: collision with root package name */
    public String f8035b;

    /* renamed from: c  reason: collision with root package name */
    public String f8036c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d0.e.a f8037d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1023861971, "Lc/a/o0/a/q1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1023861971, "Lc/a/o0/a/q1/a;");
                return;
            }
        }
        f8032e = k.f7049a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != -2) {
                return i2 != 0 ? 6 : 0;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f8033f == null) {
                synchronized (a.class) {
                    if (f8033f == null) {
                        f8033f = new a();
                    }
                }
            }
            return f8033f;
        }
        return (a) invokeV.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, str2);
            } catch (JSONException e2) {
                if (f8032e) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String f(UnitedSchemeEntity unitedSchemeEntity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, unitedSchemeEntity, str)) == null) {
            String str2 = unitedSchemeEntity.getParams().get(str);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                return new JSONObject(str2).optString("src");
            } catch (JSONException e2) {
                if (f8032e) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("finalUrl", str);
            } catch (JSONException e2) {
                if (f8032e) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public boolean e(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, callbackHandler, unitedSchemeEntity)) == null) {
            String f2 = f(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(f2)) {
                c.a.o0.a.e0.d.g("SwanAppPayLaunchMsg", "wxPay: url is empty");
                c.a.o0.a.e0.d.h("SwanAppPayLaunchMsg", "param check error - src" + f2);
                c.a.o0.a.j2.k.D(false, "wechatH5Action", c(f2, "param check error - src"));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (!c.a.d0.b.a().a(context)) {
                c.a.o0.a.z1.b.f.e.g(context, context.getText(h.aiapps_wx_not_install_toast_msg)).F();
                c.a.o0.a.e0.d.h("SwanAppPayLaunchMsg", "Error: wechat not install. " + f2);
                c.a.o0.a.j2.k.D(false, "wechatH5Action", c(f2, "Error: wechat not install. "));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
                return false;
            } else {
                c.a.o0.a.l1.b g2 = c.a.o0.a.l1.b.g(f2, f2);
                c.a.o0.a.e0.d.h("SwanAppPayLaunchMsg", "Info: open wechat pay webview, pageParam =" + g2);
                if (!c.a.o0.a.h0.g.k.O2("wxPay", g2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.a.o0.a.e0.d.h("SwanAppPayLaunchMsg", "Error: webview fragment not opened.");
                    return false;
                }
                c.a.o0.a.e0.d.h("SwanAppPayLaunchMsg", "Success:open wxPay page success");
                c.a.o0.a.e0.d.h("SwanAppPayLaunchMsg", "Info: end WeChat H5 redirect " + f2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(d(f2), 0));
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }
}
