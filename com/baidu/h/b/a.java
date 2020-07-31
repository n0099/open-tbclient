package com.baidu.h.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.h.d;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.messaging.c;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a implements com.baidu.h.c.a {
    private static final String TAG = a.class.getSimpleName();
    private static final String byQ = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // com.baidu.h.c.a
    public void e(Activity activity, String str, com.baidu.h.a.a aVar) {
        com.baidu.swan.apps.t.a.ahy().e(activity, str, aVar);
    }

    @Override // com.baidu.h.c.a
    public void f(Activity activity, String str, com.baidu.h.a.a aVar) {
        com.baidu.swan.apps.t.a.ahy().f(activity, str, aVar);
    }

    @Override // com.baidu.h.c.a
    public void b(Context context, JSONObject jSONObject, com.baidu.h.a.a aVar) {
        com.baidu.swan.apps.t.a.ahy().b(context, jSONObject, aVar);
    }

    @Override // com.baidu.h.c.a
    public void g(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.h.a.L(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.h.a.L(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, byQ + optString + optString2);
        }
    }

    @Override // com.baidu.h.c.a
    public boolean aG(Context context) {
        return com.baidu.swan.apps.t.a.ahy().aG(context);
    }

    @Override // com.baidu.h.c.a
    public void gy(String str) {
        com.baidu.swan.apps.ab.a.anv().appId = str;
    }

    @Override // com.baidu.h.c.a
    public void k(Bundle bundle) {
        String str = com.baidu.swan.apps.ab.a.anv().appId;
        if (TextUtils.isEmpty(str)) {
            d.l(bundle);
        } else {
            com.baidu.swan.apps.process.messaging.a.apw().a(new c(119, bundle).t(str).eV(true));
        }
    }

    @Override // com.baidu.h.c.a
    public String getZid(Context context) {
        return com.baidu.swan.apps.t.a.aia().bV(context);
    }
}
