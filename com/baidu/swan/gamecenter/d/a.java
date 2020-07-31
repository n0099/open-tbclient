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
/* loaded from: classes20.dex */
public final class a extends com.baidu.swan.gamecenter.c.a {
    public a() {
        super("navigateToSwanGame");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public b b(JSONObject jSONObject, com.baidu.swan.apps.n.b bVar) {
        b.a arz;
        b.a arz2;
        q.m(jSONObject, "paramsJson");
        q.m(bVar, BuyTBeanActivityConfig.CALLBACK);
        Application ahj = com.baidu.swan.apps.t.a.ahj();
        if (ahj == null) {
            bVar.onFail(202, "params may be error");
        } else {
            String optString = jSONObject.optString("appKey");
            String str = optString;
            if (str == null || str.length() == 0) {
                bVar.onFail(202, "params may be error");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                e arw = e.arw();
                jSONObject2.put("pre_source", (arw == null || (arz2 = arw.arz()) == null || (r0 = arz2.ajg()) == null) ? "" : "");
                e arw2 = e.arw();
                jSONObject2.put("pre_appid", (arw2 == null || (arz = arw2.arz()) == null || (r0 = arz.getAppKey()) == null) ? "" : "");
                jSONObject.put("ubc", jSONObject2);
                String b = c.b(optString, 1, jSONObject);
                String str2 = b;
                Uri parse = str2 == null || str2.length() == 0 ? null : Uri.parse(b);
                if (parse == null) {
                    bVar.onFail(202, "params may be error");
                } else if (SchemeRouter.invokeScheme(ahj, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    bVar.aj(null);
                } else {
                    bVar.onFail(202, "params may be error");
                }
            }
        }
        return null;
    }
}
