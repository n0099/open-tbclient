package com.baidu.m.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.m.d;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.messaging.c;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a implements com.baidu.m.c.a {
    private static final String TAG = a.class.getSimpleName();
    private static final String cgi = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // com.baidu.m.c.a
    public void e(Activity activity, String str, com.baidu.m.a.a aVar) {
        com.baidu.swan.apps.t.a.azp().e(activity, str, aVar);
    }

    @Override // com.baidu.m.c.a
    public void f(Activity activity, String str, com.baidu.m.a.a aVar) {
        com.baidu.swan.apps.t.a.azp().f(activity, str, aVar);
    }

    @Override // com.baidu.m.c.a
    public void b(Context context, JSONObject jSONObject, com.baidu.m.a.a aVar) {
        com.baidu.swan.apps.t.a.azp().b(context, jSONObject, aVar);
    }

    @Override // com.baidu.m.c.a
    public void g(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.m.a.ac(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.m.a.ac(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, cgi + optString + optString2);
        }
    }

    @Override // com.baidu.m.c.a
    public void b(Activity activity, JSONObject jSONObject, com.baidu.m.a.a aVar) {
    }

    @Override // com.baidu.m.c.a
    public boolean bu(Context context) {
        return com.baidu.swan.apps.t.a.azp().bu(context);
    }

    @Override // com.baidu.m.c.a
    public void jV(String str) {
        com.baidu.swan.apps.aa.a.aFF().appId = str;
    }

    @Override // com.baidu.m.c.a
    public void k(Bundle bundle) {
        String str = com.baidu.swan.apps.aa.a.aFF().appId;
        if (TextUtils.isEmpty(str)) {
            d.l(bundle);
        } else {
            com.baidu.swan.apps.process.messaging.a.aHE().a(new c(119, bundle).w(str).gx(true));
        }
    }

    @Override // com.baidu.m.c.a
    public String getZid(Context context) {
        return com.baidu.swan.apps.t.a.azS().cM(context);
    }
}
