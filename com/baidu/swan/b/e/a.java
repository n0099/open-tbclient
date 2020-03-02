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
        b.a acI;
        b.a acI2;
        q.j(jSONObject, "paramsJson");
        q.j(bVar, BuyTBeanActivityConfig.CALLBACK);
        Application TW = com.baidu.swan.apps.w.a.TW();
        if (TW == null) {
            bVar.onFail(202, "params may be error");
        } else {
            String optString = jSONObject.optString("appKey");
            String str = optString;
            if (str == null || str.length() == 0) {
                bVar.onFail(202, "params may be error");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                e acG = e.acG();
                jSONObject2.put("pre_source", (acG == null || (acI2 = acG.acI()) == null || (r0 = acI2.VJ()) == null) ? "" : "");
                e acG2 = e.acG();
                jSONObject2.put("pre_appid", (acG2 == null || (acI = acG2.acI()) == null || (r0 = acI.getAppKey()) == null) ? "" : "");
                jSONObject.put("ubc", jSONObject2);
                String b = c.b(optString, 1, jSONObject);
                String str2 = b;
                Uri parse = str2 == null || str2.length() == 0 ? null : Uri.parse(b);
                if (parse == null) {
                    bVar.onFail(202, "params may be error");
                } else if (SchemeRouter.invokeScheme(TW, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    bVar.K(null);
                } else {
                    bVar.onFail(202, "params may be error");
                }
            }
        }
        return null;
    }
}
