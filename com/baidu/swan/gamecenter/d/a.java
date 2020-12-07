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
/* loaded from: classes16.dex */
public final class a extends com.baidu.swan.gamecenter.c.a {
    public a() {
        super("navigateToSwanGame");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public b b(JSONObject jSONObject, com.baidu.swan.apps.o.b bVar) {
        b.a aJY;
        b.a aJY2;
        p.o(jSONObject, "paramsJson");
        p.o(bVar, BuyTBeanActivityConfig.CALLBACK);
        Application aza = com.baidu.swan.apps.t.a.aza();
        if (aza == null) {
            bVar.onFail(202, "params may be error");
        } else {
            String optString = jSONObject.optString("appKey");
            String str = optString;
            if (str == null || str.length() == 0) {
                bVar.onFail(202, "params may be error");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
                jSONObject2.put("pre_source", (aJV == null || (aJY2 = aJV.aJY()) == null || (r0 = aJY2.aBe()) == null) ? "" : "");
                com.baidu.swan.apps.runtime.e aJV2 = com.baidu.swan.apps.runtime.e.aJV();
                jSONObject2.put("pre_appid", (aJV2 == null || (aJY = aJV2.aJY()) == null || (r0 = aJY.getAppKey()) == null) ? "" : "");
                jSONObject.put("ubc", jSONObject2);
                String b = c.b(optString, 1, jSONObject);
                String str2 = b;
                Uri parse = str2 == null || str2.length() == 0 ? null : Uri.parse(b);
                if (parse == null) {
                    bVar.onFail(202, "params may be error");
                } else if (SchemeRouter.invokeScheme(aza, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    bVar.aA(null);
                } else {
                    bVar.onFail(202, "params may be error");
                }
            }
        }
        return null;
    }
}
