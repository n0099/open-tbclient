package com.baidu.l.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.l.d;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.messaging.c;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements com.baidu.l.c.a {
    private static final String TAG = a.class.getSimpleName();
    private static final String bEB = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // com.baidu.l.c.a
    public void e(Activity activity, String str, com.baidu.l.a.a aVar) {
        com.baidu.swan.apps.t.a.aoY().e(activity, str, aVar);
    }

    @Override // com.baidu.l.c.a
    public void f(Activity activity, String str, com.baidu.l.a.a aVar) {
        com.baidu.swan.apps.t.a.aoY().f(activity, str, aVar);
    }

    @Override // com.baidu.l.c.a
    public void b(Context context, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        com.baidu.swan.apps.t.a.aoY().b(context, jSONObject, aVar);
    }

    @Override // com.baidu.l.c.a
    public void g(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.l.a.K(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.l.a.K(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, bEB + optString + optString2);
        }
    }

    @Override // com.baidu.l.c.a
    public void b(Activity activity, JSONObject jSONObject, com.baidu.l.a.a aVar) {
    }

    @Override // com.baidu.l.c.a
    public boolean aL(Context context) {
        return com.baidu.swan.apps.t.a.aoY().aL(context);
    }

    @Override // com.baidu.l.c.a
    public void hT(String str) {
        com.baidu.swan.apps.aa.a.avq().appId = str;
    }

    @Override // com.baidu.l.c.a
    public void k(Bundle bundle) {
        String str = com.baidu.swan.apps.aa.a.avq().appId;
        if (TextUtils.isEmpty(str)) {
            d.l(bundle);
        } else {
            com.baidu.swan.apps.process.messaging.a.axs().a(new c(119, bundle).u(str).fp(true));
        }
    }

    @Override // com.baidu.l.c.a
    public String getZid(Context context) {
        return com.baidu.swan.apps.t.a.apC().cb(context);
    }
}
