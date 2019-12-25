package com.baidu.swan.apps.c.a.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.c.a.d;
import com.baidu.swan.apps.c.a.h;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import kotlin.jvm.internal.p;
import kotlin.text.l;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/setMaBdussSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        boolean z;
        p.j(unitedSchemeEntity, "entity");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        com.baidu.swan.apps.c.a.e.aXk.bM(true);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.a.a Gy = com.baidu.swan.apps.c.a.e.aXk.Gy();
            if (Gy != null) {
                Gy.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        int optInt = optParamsAsJo.optInt("errno");
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
        ai.l(RunnableC0216a.aXq);
        if (optInt != 0) {
            com.baidu.swan.apps.a.a Gy2 = com.baidu.swan.apps.c.a.e.aXk.Gy();
            if (Gy2 != null) {
                Gy2.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
            return false;
        } else if (optJSONObject != null) {
            String optString = optJSONObject.optString("ma_bduss");
            String str = optString;
            if (!(str == null || l.isBlank(str))) {
                h.aXp.d(optInt, optJSONObject);
                com.baidu.swan.apps.c.a.a.ac(context, optString);
                com.baidu.swan.apps.c.a.e.aXk.bF(true);
                com.baidu.swan.apps.a.a Gy3 = com.baidu.swan.apps.c.a.e.aXk.Gy();
                if (Gy3 != null) {
                    Gy3.onResult(0);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                z = true;
            } else {
                com.baidu.swan.apps.a.a Gy4 = com.baidu.swan.apps.c.a.e.aXk.Gy();
                if (Gy4 != null) {
                    Gy4.onResult(-1);
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "maBduss is null");
                z = false;
            }
            return z;
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "json data is null");
            return false;
        }
    }

    /* renamed from: com.baidu.swan.apps.c.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static final class RunnableC0216a implements Runnable {
        public static final RunnableC0216a aXq = new RunnableC0216a();

        RunnableC0216a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.LR();
        }
    }
}
