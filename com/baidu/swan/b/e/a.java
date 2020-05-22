package com.baidu.swan.b.e;

import android.app.Application;
import android.net.Uri;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.api.c.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.v.b.c;
import kotlin.h;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
@h
/* loaded from: classes11.dex */
public final class a extends com.baidu.swan.b.d.a {
    public a() {
        super("navigateToSwanGame");
    }

    @Override // com.baidu.swan.b.d.a
    public b b(JSONObject jSONObject, com.baidu.swan.apps.n.b bVar) {
        b.a aoJ;
        b.a aoJ2;
        q.m(jSONObject, "paramsJson");
        q.m(bVar, BuyTBeanActivityConfig.CALLBACK);
        Application aeR = com.baidu.swan.apps.u.a.aeR();
        if (aeR == null) {
            bVar.onFail(202, "params may be error");
        } else {
            String optString = jSONObject.optString("appKey");
            String str = optString;
            if (str == null || str.length() == 0) {
                bVar.onFail(202, "params may be error");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                e aoG = e.aoG();
                jSONObject2.put("pre_source", (aoG == null || (aoJ2 = aoG.aoJ()) == null || (r0 = aoJ2.agK()) == null) ? "" : "");
                e aoG2 = e.aoG();
                jSONObject2.put("pre_appid", (aoG2 == null || (aoJ = aoG2.aoJ()) == null || (r0 = aoJ.getAppKey()) == null) ? "" : "");
                jSONObject.put("ubc", jSONObject2);
                String b = c.b(optString, 1, jSONObject);
                String str2 = b;
                Uri parse = str2 == null || str2.length() == 0 ? null : Uri.parse(b);
                if (parse == null) {
                    bVar.onFail(202, "params may be error");
                } else if (SchemeRouter.invokeScheme(aeR, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    bVar.aa(null);
                } else {
                    bVar.onFail(202, "params may be error");
                }
            }
        }
        return null;
    }
}
