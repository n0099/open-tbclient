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
/* loaded from: classes6.dex */
public class a implements com.baidu.m.c.a {
    private static final String TAG = a.class.getSimpleName();
    private static final String cnk = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // com.baidu.m.c.a
    public void e(Activity activity, String str, com.baidu.m.a.a aVar) {
        com.baidu.swan.apps.t.a.aAG().e(activity, str, aVar);
    }

    @Override // com.baidu.m.c.a
    public void f(Activity activity, String str, com.baidu.m.a.a aVar) {
        com.baidu.swan.apps.t.a.aAG().f(activity, str, aVar);
    }

    @Override // com.baidu.m.c.a
    public void b(Context context, JSONObject jSONObject, com.baidu.m.a.a aVar) {
        com.baidu.swan.apps.t.a.aAG().b(context, jSONObject, aVar);
    }

    @Override // com.baidu.m.c.a
    public void f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.m.a.ae(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.m.a.ae(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, cnk + optString + optString2);
        }
    }

    @Override // com.baidu.m.c.a
    public void b(Activity activity, JSONObject jSONObject, com.baidu.m.a.a aVar) {
    }

    @Override // com.baidu.m.c.a
    public boolean bI(Context context) {
        return com.baidu.swan.apps.t.a.aAG().bI(context);
    }

    @Override // com.baidu.m.c.a
    public void jR(String str) {
        com.baidu.swan.apps.aa.a.aGZ().appId = str;
    }

    @Override // com.baidu.m.c.a
    public void k(Bundle bundle) {
        String str = com.baidu.swan.apps.aa.a.aGZ().appId;
        if (TextUtils.isEmpty(str)) {
            d.l(bundle);
        } else {
            com.baidu.swan.apps.process.messaging.a.aIX().a(new c(119, bundle).D(str).gG(true));
        }
    }

    @Override // com.baidu.m.c.a
    public String getZid(Context context) {
        return com.baidu.swan.apps.t.a.aBj().cU(context);
    }
}
