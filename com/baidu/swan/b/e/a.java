package com.baidu.swan.b.e;

import android.app.Application;
import android.net.Uri;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.api.b.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.apps.x.b.c;
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
    public b b(JSONObject jSONObject, com.baidu.swan.apps.p.b bVar) {
        b.a acG;
        b.a acG2;
        q.j(jSONObject, "paramsJson");
        q.j(bVar, BuyTBeanActivityConfig.CALLBACK);
        Application TU = com.baidu.swan.apps.w.a.TU();
        if (TU == null) {
            bVar.onFail(202, "params may be error");
        } else {
            String optString = jSONObject.optString("appKey");
            String str = optString;
            if (str == null || str.length() == 0) {
                bVar.onFail(202, "params may be error");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                e acE = e.acE();
                jSONObject2.put("pre_source", (acE == null || (acG2 = acE.acG()) == null || (r0 = acG2.VH()) == null) ? "" : "");
                e acE2 = e.acE();
                jSONObject2.put("pre_appid", (acE2 == null || (acG = acE2.acG()) == null || (r0 = acG.getAppKey()) == null) ? "" : "");
                jSONObject.put("ubc", jSONObject2);
                String b = c.b(optString, 1, jSONObject);
                String str2 = b;
                Uri parse = str2 == null || str2.length() == 0 ? null : Uri.parse(b);
                if (parse == null) {
                    bVar.onFail(202, "params may be error");
                } else if (SchemeRouter.invokeScheme(TU, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    bVar.K(null);
                } else {
                    bVar.onFail(202, "params may be error");
                }
            }
        }
        return null;
    }
}
