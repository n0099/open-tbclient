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
    private static final String bNl = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // com.baidu.l.c.a
    public void e(Activity activity, String str, com.baidu.l.a.a aVar) {
        com.baidu.swan.apps.t.a.asv().e(activity, str, aVar);
    }

    @Override // com.baidu.l.c.a
    public void f(Activity activity, String str, com.baidu.l.a.a aVar) {
        com.baidu.swan.apps.t.a.asv().f(activity, str, aVar);
    }

    @Override // com.baidu.l.c.a
    public void b(Context context, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        com.baidu.swan.apps.t.a.asv().b(context, jSONObject, aVar);
    }

    @Override // com.baidu.l.c.a
    public void g(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.l.a.W(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.l.a.W(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, bNl + optString + optString2);
        }
    }

    @Override // com.baidu.l.c.a
    public void b(Activity activity, JSONObject jSONObject, com.baidu.l.a.a aVar) {
    }

    @Override // com.baidu.l.c.a
    public boolean aO(Context context) {
        return com.baidu.swan.apps.t.a.asv().aO(context);
    }

    @Override // com.baidu.l.c.a
    public void iO(String str) {
        com.baidu.swan.apps.aa.a.ayK().appId = str;
    }

    @Override // com.baidu.l.c.a
    public void k(Bundle bundle) {
        String str = com.baidu.swan.apps.aa.a.ayK().appId;
        if (TextUtils.isEmpty(str)) {
            d.l(bundle);
        } else {
            com.baidu.swan.apps.process.messaging.a.aAK().a(new c(119, bundle).v(str).fJ(true));
        }
    }

    @Override // com.baidu.l.c.a
    public String getZid(Context context) {
        return com.baidu.swan.apps.t.a.asY().cg(context);
    }
}
