package com.baidu.k.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.k.d;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.messaging.c;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a implements com.baidu.k.c.a {
    private static final String TAG = a.class.getSimpleName();
    private static final String coo = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // com.baidu.k.c.a
    public void e(Activity activity, String str, com.baidu.k.a.a aVar) {
        com.baidu.swan.apps.t.a.axo().e(activity, str, aVar);
    }

    @Override // com.baidu.k.c.a
    public void f(Activity activity, String str, com.baidu.k.a.a aVar) {
        com.baidu.swan.apps.t.a.axo().f(activity, str, aVar);
    }

    @Override // com.baidu.k.c.a
    public void b(Context context, JSONObject jSONObject, com.baidu.k.a.a aVar) {
        com.baidu.swan.apps.t.a.axo().b(context, jSONObject, aVar);
    }

    @Override // com.baidu.k.c.a
    public void f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.k.a.aj(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.k.a.aj(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, coo + optString + optString2);
        }
    }

    @Override // com.baidu.k.c.a
    public void b(Activity activity, JSONObject jSONObject, com.baidu.k.a.a aVar) {
    }

    @Override // com.baidu.k.c.a
    public boolean bJ(Context context) {
        return com.baidu.swan.apps.t.a.axo().bJ(context);
    }

    @Override // com.baidu.k.c.a
    public void js(String str) {
        com.baidu.swan.apps.aa.a.aDF().appId = str;
    }

    @Override // com.baidu.k.c.a
    public void k(Bundle bundle) {
        String str = com.baidu.swan.apps.aa.a.aDF().appId;
        if (TextUtils.isEmpty(str)) {
            d.l(bundle);
        } else {
            com.baidu.swan.apps.process.messaging.a.aFC().a(new c(119, bundle).D(str).gE(true));
        }
    }

    @Override // com.baidu.k.c.a
    public String getZid(Context context) {
        return com.baidu.swan.apps.t.a.axR().cR(context);
    }
}
