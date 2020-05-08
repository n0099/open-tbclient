package com.baidu.swan.apps.c.a.a;

import android.content.Context;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.c.a.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONObject;
@h
/* loaded from: classes11.dex */
public final class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/setMaBdussSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        boolean z;
        q.j(unitedSchemeEntity, "entity");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        com.baidu.swan.apps.c.a.e.bAU.cW(true);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.a.a QZ = com.baidu.swan.apps.c.a.e.bAU.QZ();
            if (QZ != null) {
                QZ.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        int optInt = optParamsAsJo.optInt(BaseJsonData.TAG_ERRNO);
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
        ai.o(RunnableC0279a.bBa);
        if (optInt != 0) {
            com.baidu.swan.apps.a.a QZ2 = com.baidu.swan.apps.c.a.e.bAU.QZ();
            if (QZ2 != null) {
                QZ2.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
            return false;
        } else if (optJSONObject != null) {
            String optString = optJSONObject.optString("ma_bduss");
            String str = optString;
            if (!(str == null || l.isBlank(str))) {
                com.baidu.swan.apps.c.a.h.bAZ.d(optInt, optJSONObject);
                com.baidu.swan.apps.c.a.a.M(context, optString);
                com.baidu.swan.apps.c.a.e.bAU.cP(true);
                com.baidu.swan.apps.a.a QZ3 = com.baidu.swan.apps.c.a.e.bAU.QZ();
                if (QZ3 != null) {
                    QZ3.onResult(0);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                z = true;
            } else {
                com.baidu.swan.apps.a.a QZ4 = com.baidu.swan.apps.c.a.e.bAU.QZ();
                if (QZ4 != null) {
                    QZ4.onResult(-1);
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

    @h
    /* renamed from: com.baidu.swan.apps.c.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static final class RunnableC0279a implements Runnable {
        public static final RunnableC0279a bBa = new RunnableC0279a();

        RunnableC0279a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.Wu();
        }
    }
}
