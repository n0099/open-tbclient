package com.baidu.swan.gamecenter.d;

import android.app.Application;
import android.net.Uri;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.api.c.b;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.u.c.c;
import kotlin.e;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
@e
/* loaded from: classes3.dex */
public final class a extends com.baidu.swan.gamecenter.c.a {
    public a() {
        super("navigateToSwanGame");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public b b(JSONObject jSONObject, com.baidu.swan.apps.o.b bVar) {
        b.a aMp;
        b.a aMp2;
        p.o(jSONObject, "paramsJson");
        p.o(bVar, BuyTBeanActivityConfig.CALLBACK);
        Application aAs = com.baidu.swan.apps.t.a.aAs();
        if (aAs == null) {
            bVar.onFail(202, "params may be error");
        } else {
            String optString = jSONObject.optString("appKey");
            String str = optString;
            if (str == null || str.length() == 0) {
                bVar.onFail(202, "params may be error");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
                jSONObject2.put("pre_source", (aMm == null || (aMp2 = aMm.aMp()) == null || (r0 = aMp2.aCw()) == null) ? "" : "");
                com.baidu.swan.apps.runtime.e aMm2 = com.baidu.swan.apps.runtime.e.aMm();
                jSONObject2.put("pre_appid", (aMm2 == null || (aMp = aMm2.aMp()) == null || (r0 = aMp.getAppKey()) == null) ? "" : "");
                jSONObject.put("ubc", jSONObject2);
                String b2 = c.b(optString, 1, jSONObject);
                String str2 = b2;
                Uri parse = str2 == null || str2.length() == 0 ? null : Uri.parse(b2);
                if (parse == null) {
                    bVar.onFail(202, "params may be error");
                } else if (SchemeRouter.invokeScheme(aAs, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    bVar.aI(null);
                } else {
                    bVar.onFail(202, "params may be error");
                }
            }
        }
        return null;
    }
}
