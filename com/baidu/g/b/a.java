package com.baidu.g.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.g.d;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.messaging.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.g.c.a {
    private static final String TAG = a.class.getSimpleName();
    private static final String byE = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // com.baidu.g.c.a
    public void e(Activity activity, String str, com.baidu.g.a.a aVar) {
        com.baidu.swan.apps.u.a.agm().e(activity, str, aVar);
    }

    @Override // com.baidu.g.c.a
    public void f(Activity activity, String str, com.baidu.g.a.a aVar) {
        com.baidu.swan.apps.u.a.agm().f(activity, str, aVar);
    }

    @Override // com.baidu.g.c.a
    public void b(Context context, JSONObject jSONObject, com.baidu.g.a.a aVar) {
        com.baidu.swan.apps.u.a.agm().b(context, jSONObject, aVar);
    }

    @Override // com.baidu.g.c.a
    public void g(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.baidu.g.a.L(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.g.a.L(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, byE + optString + optString2);
        }
    }

    @Override // com.baidu.g.c.a
    public boolean aF(Context context) {
        return com.baidu.swan.apps.u.a.agm().aF(context);
    }

    @Override // com.baidu.g.c.a
    public void gz(String str) {
        com.baidu.swan.apps.ac.a.amc().appId = str;
    }

    @Override // com.baidu.g.c.a
    public void k(Bundle bundle) {
        String str = com.baidu.swan.apps.ac.a.amc().appId;
        if (TextUtils.isEmpty(str)) {
            d.l(bundle);
        } else {
            com.baidu.swan.apps.process.messaging.a.anM().a(new c(119, bundle).t(str).eM(true));
        }
    }

    @Override // com.baidu.g.c.a
    public String getZid(Context context) {
        return com.baidu.swan.apps.u.a.agN().bS(context);
    }
}
