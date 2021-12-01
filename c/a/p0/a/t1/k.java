package c.a.p0.a.t1;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.h0.g.l;
import c.a.p0.a.n2.n;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, callbackHandler, unitedSchemeEntity)) == null) {
            String b2 = b(unitedSchemeEntity);
            if (TextUtils.isEmpty(b2)) {
                c.a.p0.a.e0.d.i("WxWebViewPayment", "wxPay: url is empty");
                c.a.p0.a.e0.d.k("WxWebViewPayment", "param check error - src" + b2);
                n.H(false, "wechatH5Action", n.m(b2, "param check error - src"));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (!c.a.e0.a.a().b(context)) {
                c.a.p0.a.c2.b.f.e.g(context, context.getText(c.a.p0.a.h.aiapps_wx_not_install_toast_msg)).G();
                c.a.p0.a.e0.d.k("WxWebViewPayment", "Error: wechat not install. " + b2);
                n.H(false, "wechatH5Action", n.m(b2, "Error: wechat not install. "));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
                return false;
            } else {
                c.a.p0.a.m1.b e2 = c.a.p0.a.m1.b.e(b2, b2);
                c.a.p0.a.e0.d.k("WxWebViewPayment", "Info: open wechat pay webview, pageParam =" + e2);
                if (!l.e3("wxPay", e2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.a.p0.a.e0.d.k("WxWebViewPayment", "Error: webview fragment not opened.");
                    return false;
                }
                c.a.p0.a.e0.d.k("WxWebViewPayment", "Success:open wxPay page success");
                c.a.p0.a.e0.d.k("WxWebViewPayment", "Info: end WeChat H5 redirect " + b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(d.c(b2), 0));
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static String b(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new JSONObject(str).optString("src");
            } catch (JSONException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
