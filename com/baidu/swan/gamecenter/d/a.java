package com.baidu.swan.gamecenter.d;

import android.app.Application;
import android.net.Uri;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.api.c.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.u.c.c;
import kotlin.h;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
@h
/* loaded from: classes6.dex */
public final class a extends com.baidu.swan.gamecenter.c.a {
    public a() {
        super("navigateToSwanGame");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public b b(JSONObject jSONObject, com.baidu.swan.apps.o.b bVar) {
        b.a aHy;
        b.a aHy2;
        q.n(jSONObject, "paramsJson");
        q.n(bVar, BuyTBeanActivityConfig.CALLBACK);
        Application awA = com.baidu.swan.apps.t.a.awA();
        if (awA == null) {
            bVar.onFail(202, "params may be error");
        } else {
            String optString = jSONObject.optString("appKey");
            String str = optString;
            if (str == null || str.length() == 0) {
                bVar.onFail(202, "params may be error");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                e aHv = e.aHv();
                jSONObject2.put("pre_source", (aHv == null || (aHy2 = aHv.aHy()) == null || (r0 = aHy2.ayD()) == null) ? "" : "");
                e aHv2 = e.aHv();
                jSONObject2.put("pre_appid", (aHv2 == null || (aHy = aHv2.aHy()) == null || (r0 = aHy.getAppKey()) == null) ? "" : "");
                jSONObject.put("ubc", jSONObject2);
                String b = c.b(optString, 1, jSONObject);
                String str2 = b;
                Uri parse = str2 == null || str2.length() == 0 ? null : Uri.parse(b);
                if (parse == null) {
                    bVar.onFail(202, "params may be error");
                } else if (SchemeRouter.invokeScheme(awA, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    bVar.aE(null);
                } else {
                    bVar.onFail(202, "params may be error");
                }
            }
        }
        return null;
    }
}
