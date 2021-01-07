package com.baidu.swan.apps.scheme.actions.b;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.api.module.favorite.a;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g extends aa implements a.InterfaceC0395a {
    private long cIm;
    private long cIn;
    private long cIo;
    private CallbackHandler mCallbackHandler;
    private String mCallbackKey;

    public g(j jVar) {
        super(jVar, "/swanAPI/showFavoriteGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        if (!ak.aRQ()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
            com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "not support outside baiduboxapp");
            return false;
        }
        this.mCallbackHandler = callbackHandler;
        final JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null || eVar == null || !(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "params parse error");
            return false;
        }
        final String optString = b2.optString("type");
        if (com.baidu.swan.apps.api.module.favorite.a.ann().lc(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        p.aRq().execute(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.b.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.storage.c.b aPI = h.aPI();
                final ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(optString);
                final String string = context.getString(parse.defaultText);
                g.this.mCallbackKey = b2.optString("cb");
                String str = eVar.id;
                String str2 = "favorite_guide_count_" + str;
                if (com.baidu.swan.apps.database.favorite.a.oj(str)) {
                    com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "favorite already");
                    h.aPI().putString(str2, "-1");
                    return;
                }
                String string2 = h.aPI().getString(str2, "");
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
                g.this.cIm = aPI.getLong("swan_favorite_guide_duration", 3L);
                g.this.cIn = aPI.getLong("swan_favorite_guide_intervalDays", 3L);
                g.this.cIo = aPI.getLong("swan_favorite_guide_maxTimes", 3L);
                com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "duration=" + g.this.cIm + ", mIntervalDays=" + g.this.cIn + ", mMaxTimes=" + g.this.cIo + " ,storageValue=" + string2);
                if (i < g.this.cIo && currentTimeMillis - j > g.this.cIn * 86400000) {
                    h.aPI().putString(str2, (i + 1) + "#" + currentTimeMillis);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.b.g.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.api.module.favorite.a.ann().a(g.this, (Activity) context, eVar, parse, string, eVar.aMp().getIconUrl(), g.this.cIm);
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

    @Override // com.baidu.swan.apps.api.module.favorite.a.InterfaceC0395a
    @AnyThread
    public void eT(boolean z) {
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
