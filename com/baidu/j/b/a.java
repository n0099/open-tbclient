package com.baidu.j.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.j.d;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.messaging.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.j.c.a {
    private static final String TAG = a.class.getSimpleName();
    private static final String aPR = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // com.baidu.j.c.a
    public void e(Activity activity, String str, com.baidu.j.a.a aVar) {
        com.baidu.swan.apps.w.a.Um().e(activity, str, aVar);
    }

    @Override // com.baidu.j.c.a
    public void f(Activity activity, String str, com.baidu.j.a.a aVar) {
        com.baidu.swan.apps.w.a.Um().f(activity, str, aVar);
    }

    @Override // com.baidu.j.c.a
    public void b(Context context, JSONObject jSONObject, com.baidu.j.a.a aVar) {
        com.baidu.swan.apps.w.a.Um().b(context, jSONObject, aVar);
    }

    @Override // com.baidu.j.c.a
    public void g(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.j.a.s(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.j.a.s(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, aPR + optString + optString2);
        }
    }

    @Override // com.baidu.j.c.a
    public boolean aU(Context context) {
        return com.baidu.swan.apps.w.a.Um().aU(context);
    }

    @Override // com.baidu.j.c.a
    public void eK(String str) {
        com.baidu.swan.apps.ae.a.Zu().appId = str;
    }

    @Override // com.baidu.j.c.a
    public void i(Bundle bundle) {
        String str = com.baidu.swan.apps.ae.a.Zu().appId;
        if (TextUtils.isEmpty(str)) {
            d.j(bundle);
        } else {
            com.baidu.swan.apps.process.messaging.a.aaL().a(new c(119, bundle).u(str).dr(true));
        }
    }
}
