package com.baidu.swan.apps.scheme.actions.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.support.annotation.AnyThread;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.api.module.favorite.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends ab implements a.InterfaceC0271a {
    private Bitmap bBY;
    private long bBZ;
    private long bCa;
    private long bCb;
    private CallbackHandler mCallbackHandler;
    private String mCallbackKey;

    public g(j jVar) {
        super(jVar, "/swanAPI/showFavoriteGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        if (!ai.aps()) {
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
        m.aoT().execute(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.b.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.storage.c.b any = h.any();
                final ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(b.optString("type"));
                final String string = context.getString(parse.defaultText);
                g.this.mCallbackKey = b.optString("cb");
                String str = eVar.id;
                String str2 = "favorite_guide_count_" + str;
                if (com.baidu.swan.apps.database.favorite.a.iP(str)) {
                    com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "favorite already");
                    h.any().putString(str2, "-1");
                    return;
                }
                String string2 = h.any().getString(str2, "");
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
                g.this.bBZ = any.getLong("swan_favorite_guide_duration", 3L);
                g.this.bCa = any.getLong("swan_favorite_guide_intervalDays", 3L);
                g.this.bCb = any.getLong("swan_favorite_guide_maxTimes", 3L);
                com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "duration=" + g.this.bBZ + ", mIntervalDays=" + g.this.bCa + ", mMaxTimes=" + g.this.bCb + " ,storageValue=" + string2);
                if (i < g.this.bCb && currentTimeMillis - j > g.this.bCa * 86400000) {
                    h.any().putString(str2, (i + 1) + "#" + currentTimeMillis);
                    g.this.bBY = ai.a((com.baidu.swan.apps.x.b.b) eVar.Ov(), "ShowFavoriteGuideAction", false);
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.b.g.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.api.module.favorite.a.Rv().a(g.this, (Activity) context, eVar, parse, string, g.this.bBY, g.this.bBZ);
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

    @Override // com.baidu.swan.apps.api.module.favorite.a.InterfaceC0271a
    @AnyThread
    public void cX(boolean z) {
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
