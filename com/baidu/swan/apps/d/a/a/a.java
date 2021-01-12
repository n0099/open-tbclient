package com.baidu.swan.apps.d.a.a;

import android.content.Context;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.d.a.f;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.c.h;
import com.baidu.webkit.sdk.CookieManager;
import kotlin.e;
import kotlin.jvm.internal.p;
import kotlin.text.l;
import org.json.JSONObject;
@e
/* loaded from: classes8.dex */
public final class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/setTplBdussSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        p.o(unitedSchemeEntity, "entity");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f.cBW.eO(true);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.a.a ajc = f.cBW.ajc();
            if (ajc != null) {
                ajc.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        int optInt = optParamsAsJo.optInt(BaseJsonData.TAG_ERRNO);
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
        ak.l(RunnableC0420a.cCa);
        if (optInt != 0) {
            com.baidu.swan.apps.a.a ajc2 = f.cBW.ajc();
            if (ajc2 != null) {
                ajc2.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
            return false;
        } else if (optJSONObject != null) {
            String str = h.xl(CookieManager.getInstance().getCookie(".baidu.com")).get("OPENBDUSS");
            String str2 = str;
            if (!(str2 == null || l.isBlank(str2))) {
                com.baidu.swan.apps.d.a.h.cBZ.d(optInt, optJSONObject);
                com.baidu.swan.apps.d.a.a.ad(context, str);
                f.cBW.eE(true);
                com.baidu.swan.apps.a.a ajc3 = f.cBW.ajc();
                if (ajc3 != null) {
                    ajc3.onResult(0);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                z = true;
            } else {
                com.baidu.swan.apps.a.a ajc4 = f.cBW.ajc();
                if (ajc4 != null) {
                    ajc4.onResult(-1);
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "bduss is null");
                z = false;
            }
            return z;
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "json data is null");
            return false;
        }
    }

    @e
    /* renamed from: com.baidu.swan.apps.d.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    static final class RunnableC0420a implements Runnable {
        public static final RunnableC0420a cCa = new RunnableC0420a();

        RunnableC0420a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.baidu.swan.apps.d.a.e.apn();
        }
    }
}
