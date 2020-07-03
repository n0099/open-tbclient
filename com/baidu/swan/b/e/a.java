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
        b.a apQ;
        b.a apQ2;
        q.m(jSONObject, "paramsJson");
        q.m(bVar, BuyTBeanActivityConfig.CALLBACK);
        Application afX = com.baidu.swan.apps.u.a.afX();
        if (afX == null) {
            bVar.onFail(202, "params may be error");
        } else {
            String optString = jSONObject.optString("appKey");
            String str = optString;
            if (str == null || str.length() == 0) {
                bVar.onFail(202, "params may be error");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                e apN = e.apN();
                jSONObject2.put("pre_source", (apN == null || (apQ2 = apN.apQ()) == null || (r0 = apQ2.ahQ()) == null) ? "" : "");
                e apN2 = e.apN();
                jSONObject2.put("pre_appid", (apN2 == null || (apQ = apN2.apQ()) == null || (r0 = apQ.getAppKey()) == null) ? "" : "");
                jSONObject.put("ubc", jSONObject2);
                String b = c.b(optString, 1, jSONObject);
                String str2 = b;
                Uri parse = str2 == null || str2.length() == 0 ? null : Uri.parse(b);
                if (parse == null) {
                    bVar.onFail(202, "params may be error");
                } else if (SchemeRouter.invokeScheme(afX, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    bVar.ah(null);
                } else {
                    bVar.onFail(202, "params may be error");
                }
            }
        }
        return null;
    }
}
