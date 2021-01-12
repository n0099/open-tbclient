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
/* loaded from: classes5.dex */
public class a implements com.baidu.k.c.a {
    private static final String TAG = a.class.getSimpleName();
    private static final String cix = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // com.baidu.k.c.a
    public void e(Activity activity, String str, com.baidu.k.a.a aVar) {
        com.baidu.swan.apps.t.a.awN().e(activity, str, aVar);
    }

    @Override // com.baidu.k.c.a
    public void f(Activity activity, String str, com.baidu.k.a.a aVar) {
        com.baidu.swan.apps.t.a.awN().f(activity, str, aVar);
    }

    @Override // com.baidu.k.c.a
    public void b(Context context, JSONObject jSONObject, com.baidu.k.a.a aVar) {
        com.baidu.swan.apps.t.a.awN().b(context, jSONObject, aVar);
    }

    @Override // com.baidu.k.c.a
    public void f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.k.a.af(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.k.a.af(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, cix + optString + optString2);
        }
    }

    @Override // com.baidu.k.c.a
    public void b(Activity activity, JSONObject jSONObject, com.baidu.k.a.a aVar) {
    }

    @Override // com.baidu.k.c.a
    public boolean bH(Context context) {
        return com.baidu.swan.apps.t.a.awN().bH(context);
    }

    @Override // com.baidu.k.c.a
    public void iG(String str) {
        com.baidu.swan.apps.aa.a.aDg().appId = str;
    }

    @Override // com.baidu.k.c.a
    public void k(Bundle bundle) {
        String str = com.baidu.swan.apps.aa.a.aDg().appId;
        if (TextUtils.isEmpty(str)) {
            d.l(bundle);
        } else {
            com.baidu.swan.apps.process.messaging.a.aFe().a(new c(119, bundle).D(str).gC(true));
        }
    }

    @Override // com.baidu.k.c.a
    public String getZid(Context context) {
        return com.baidu.swan.apps.t.a.axq().cT(context);
    }
}
