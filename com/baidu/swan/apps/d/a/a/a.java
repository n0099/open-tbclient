package com.baidu.swan.apps.d.a.a;

import android.content.Context;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.d.a.f;
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
        q.n(unitedSchemeEntity, "entity");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f.cva.eu(true);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.a.a aiD = f.cva.aiD();
            if (aiD != null) {
                aiD.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        int optInt = optParamsAsJo.optInt(BaseJsonData.TAG_ERRNO);
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
        ak.m(RunnableC0433a.cve);
        if (optInt != 0) {
            com.baidu.swan.apps.a.a aiD2 = f.cva.aiD();
            if (aiD2 != null) {
                aiD2.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
            return false;
        } else if (optJSONObject != null) {
            String str = com.baidu.swan.c.h.xQ(CookieManager.getInstance().getCookie(".baidu.com")).get("OPENBDUSS");
            String str2 = str;
            if (!(str2 == null || l.isBlank(str2))) {
                com.baidu.swan.apps.d.a.h.cvd.d(optInt, optJSONObject);
                com.baidu.swan.apps.d.a.a.U(context, str);
                f.cva.el(true);
                com.baidu.swan.apps.a.a aiD3 = f.cva.aiD();
                if (aiD3 != null) {
                    aiD3.onResult(0);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                z = true;
            } else {
                com.baidu.swan.apps.a.a aiD4 = f.cva.aiD();
                if (aiD4 != null) {
                    aiD4.onResult(-1);
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
    /* renamed from: com.baidu.swan.apps.d.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static final class RunnableC0433a implements Runnable {
        public static final RunnableC0433a cve = new RunnableC0433a();

        RunnableC0433a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.baidu.swan.apps.d.a.e.aoH();
        }
    }
}
