package com.baidu.swan.apps.scheme.actions.b;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.support.annotation.AnyThread;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.api.module.favorite.a;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends aa implements a.InterfaceC0391a {
    private long cwE;
    private long cwF;
    private long cwG;
    private CallbackHandler mCallbackHandler;
    private String mCallbackKey;

    public g(j jVar) {
        super(jVar, "/swanAPI/showFavoriteGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        if (!ak.aMs()) {
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
        final String optString = b.optString("type");
        if (com.baidu.swan.apps.api.module.favorite.a.aiU().kC(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        p.aLR().execute(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.b.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.storage.c.b aKk = h.aKk();
                final ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(optString);
                final String string = context.getString(parse.defaultText);
                g.this.mCallbackKey = b.optString("cb");
                String str = eVar.id;
                String str2 = "favorite_guide_count_" + str;
                if (com.baidu.swan.apps.database.favorite.a.nI(str)) {
                    com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "favorite already");
                    h.aKk().putString(str2, "-1");
                    return;
                }
                String string2 = h.aKk().getString(str2, "");
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
                g.this.cwE = aKk.getLong("swan_favorite_guide_duration", 3L);
                g.this.cwF = aKk.getLong("swan_favorite_guide_intervalDays", 3L);
                g.this.cwG = aKk.getLong("swan_favorite_guide_maxTimes", 3L);
                com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "duration=" + g.this.cwE + ", mIntervalDays=" + g.this.cwF + ", mMaxTimes=" + g.this.cwG + " ,storageValue=" + string2);
                if (i < g.this.cwG && currentTimeMillis - j > g.this.cwF * 86400000) {
                    h.aKk().putString(str2, (i + 1) + "#" + currentTimeMillis);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.b.g.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.api.module.favorite.a.aiU().a(g.this, (Activity) context, eVar, parse, string, eVar.aGQ().getIconUrl(), g.this.cwE);
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

    @Override // com.baidu.swan.apps.api.module.favorite.a.InterfaceC0391a
    @AnyThread
    public void ev(boolean z) {
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
