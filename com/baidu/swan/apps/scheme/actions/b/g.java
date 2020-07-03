package com.baidu.swan.apps.scheme.actions.b;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.support.annotation.AnyThread;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.api.module.favorite.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends aa implements a.InterfaceC0311a {
    private long bPf;
    private long bPg;
    private long bPh;
    private CallbackHandler mCallbackHandler;
    private String mCallbackKey;

    public g(j jVar) {
        super(jVar, "/swanAPI/showFavoriteGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        if (!aj.auY()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
            com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "not support outside baiduboxapp");
            return false;
        }
        this.mCallbackHandler = callbackHandler;
        final JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null || eVar == null || !(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "params parse error");
            return false;
        }
        n.auA().execute(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.b.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.storage.c.b asV = h.asV();
                final ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(b.optString("type"));
                final String string = context.getString(parse.defaultText);
                g.this.mCallbackKey = b.optString("cb");
                String str = eVar.id;
                String str2 = "favorite_guide_count_" + str;
                if (com.baidu.swan.apps.database.favorite.a.ke(str)) {
                    com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "favorite already");
                    h.asV().putString(str2, "-1");
                    return;
                }
                String string2 = h.asV().getString(str2, "");
                if (TextUtils.equals("-1", string2)) {
                    com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "favorite at one time");
                    return;
                }
                String[] split = string2.split("#");
                int i = 0;
                long j = 0;
                if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                    i = Integer.parseInt(split[0]);
                    j = Long.parseLong(split[1]);
                }
                long currentTimeMillis = System.currentTimeMillis();
                g.this.bPf = asV.getLong("swan_favorite_guide_duration", 3L);
                g.this.bPg = asV.getLong("swan_favorite_guide_intervalDays", 3L);
                g.this.bPh = asV.getLong("swan_favorite_guide_maxTimes", 3L);
                com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "duration=" + g.this.bPf + ", mIntervalDays=" + g.this.bPg + ", mMaxTimes=" + g.this.bPh + " ,storageValue=" + string2);
                if (i < g.this.bPh && currentTimeMillis - j > g.this.bPg * 86400000) {
                    h.asV().putString(str2, (i + 1) + "#" + currentTimeMillis);
                    aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.b.g.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.api.module.favorite.a.Vc().a(g.this, (Activity) context, eVar, parse, string, eVar.apQ().getIconUrl(), g.this.bPf);
                        }
                    });
                    return;
                }
                com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "Not satisfying display conditions");
            }
        }, "ShowFavoriteGuideAction");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, unitedSchemeEntity.result);
        return true;
    }

    @Override // com.baidu.swan.apps.api.module.favorite.a.InterfaceC0311a
    @AnyThread
    public void dp(boolean z) {
        if (this.mCallbackKey != null && this.mCallbackHandler != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", z ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mCallbackHandler.handleSchemeDispatchCallback(this.mCallbackKey, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
        }
    }
}
