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
import kotlin.jvm.internal.p;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a extends com.baidu.swan.b.d.a {
    public a() {
        super("navigateToSwanGame");
    }

    @Override // com.baidu.swan.b.d.a
    public b b(JSONObject jSONObject, com.baidu.swan.apps.p.b bVar) {
        b.a ZV;
        b.a ZV2;
        p.j(jSONObject, "paramsJson");
        p.j(bVar, BuyTBeanActivityConfig.CALLBACK);
        Application Rk = com.baidu.swan.apps.w.a.Rk();
        if (Rk == null) {
            bVar.onFail(202, "params may be error");
        } else {
            String optString = jSONObject.optString("appKey");
            String str = optString;
            if (str == null || str.length() == 0) {
                bVar.onFail(202, "params may be error");
            } else {
                JSONObject jSONObject2 = new JSONObject();
                e ZT = e.ZT();
                jSONObject2.put("pre_source", (ZT == null || (ZV2 = ZT.ZV()) == null || (r0 = ZV2.SW()) == null) ? "" : "");
                e ZT2 = e.ZT();
                jSONObject2.put("pre_appid", (ZT2 == null || (ZV = ZT2.ZV()) == null || (r0 = ZV.getAppKey()) == null) ? "" : "");
                jSONObject.put("ubc", jSONObject2);
                String b = c.b(optString, 1, jSONObject);
                String str2 = b;
                Uri parse = str2 == null || str2.length() == 0 ? null : Uri.parse(b);
                if (parse == null) {
                    bVar.onFail(202, "params may be error");
                } else if (SchemeRouter.invokeScheme(Rk, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    bVar.K(null);
                } else {
                    bVar.onFail(202, "params may be error");
                }
            }
        }
        return null;
    }
}
