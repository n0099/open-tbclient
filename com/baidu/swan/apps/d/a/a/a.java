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
        p.p(unitedSchemeEntity, "entity");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f.cFS.eQ(true);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.a.a ajD = f.cFS.ajD();
            if (ajD != null) {
                ajD.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        int optInt = optParamsAsJo.optInt(BaseJsonData.TAG_ERRNO);
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
        ak.j(RunnableC0423a.cFW);
        if (optInt != 0) {
            com.baidu.swan.apps.a.a ajD2 = f.cFS.ajD();
            if (ajD2 != null) {
                ajD2.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
            return false;
        } else if (optJSONObject != null) {
            String str = h.xL(CookieManager.getInstance().getCookie(".baidu.com")).get("OPENBDUSS");
            String str2 = str;
            if (!(str2 == null || l.isBlank(str2))) {
                com.baidu.swan.apps.d.a.h.cFV.d(optInt, optJSONObject);
                com.baidu.swan.apps.d.a.a.ab(context, str);
                f.cFS.eG(true);
                com.baidu.swan.apps.a.a ajD3 = f.cFS.ajD();
                if (ajD3 != null) {
                    ajD3.onResult(0);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                z = true;
            } else {
                com.baidu.swan.apps.a.a ajD4 = f.cFS.ajD();
                if (ajD4 != null) {
                    ajD4.onResult(-1);
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
    static final class RunnableC0423a implements Runnable {
        public static final RunnableC0423a cFW = new RunnableC0423a();

        RunnableC0423a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.baidu.swan.apps.d.a.e.apO();
        }
    }
}
