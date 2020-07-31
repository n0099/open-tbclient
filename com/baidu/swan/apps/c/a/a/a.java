package com.baidu.swan.apps.c.a.a;

import android.content.Context;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.c.a.f;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.webkit.sdk.CookieManager;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONObject;
@h
/* loaded from: classes7.dex */
public final class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/setTplBdussSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        boolean z;
        q.m(unitedSchemeEntity, "entity");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f.bOu.dr(true);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.a.a Vq = f.bOu.Vq();
            if (Vq != null) {
                Vq.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        int optInt = optParamsAsJo.optInt(BaseJsonData.TAG_ERRNO);
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
        al.p(RunnableC0324a.bOy);
        if (optInt != 0) {
            com.baidu.swan.apps.a.a Vq2 = f.bOu.Vq();
            if (Vq2 != null) {
                Vq2.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
            return false;
        } else if (optJSONObject != null) {
            String str = com.baidu.swan.d.h.tS(CookieManager.getInstance().getCookie(".baidu.com")).get("BDUSS");
            String str2 = str;
            if (!(str2 == null || l.isBlank(str2))) {
                com.baidu.swan.apps.c.a.h.bOx.d(optInt, optJSONObject);
                com.baidu.swan.apps.c.a.a.M(context, str);
                f.bOu.dj(true);
                com.baidu.swan.apps.a.a Vq3 = f.bOu.Vq();
                if (Vq3 != null) {
                    Vq3.onResult(0);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                z = true;
            } else {
                com.baidu.swan.apps.a.a Vq4 = f.bOu.Vq();
                if (Vq4 != null) {
                    Vq4.onResult(-1);
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

    @h
    /* renamed from: com.baidu.swan.apps.c.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static final class RunnableC0324a implements Runnable {
        public static final RunnableC0324a bOy = new RunnableC0324a();

        RunnableC0324a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.baidu.swan.apps.c.a.e.abo();
        }
    }
}
