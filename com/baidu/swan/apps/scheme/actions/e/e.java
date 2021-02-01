package com.baidu.swan.apps.scheme.actions.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.api.module.e.h;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends aa {
    public e(j jVar) {
        super(jVar, "/swanAPI/showToast");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar != null && eVar.ajP()) {
            if (DEBUG) {
                Log.d("ShowToastAction", "ShowToastAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.size() == 0) {
            com.baidu.swan.apps.console.c.e("ShowToastAction", "hasMmap for params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = params.get("params");
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("ShowToastAction", "the key params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type", "1");
            final int aN = h.aN(jSONObject);
            final String optString2 = jSONObject.optString("message");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.console.c.e("ShowToastAction", "message is null");
                return false;
            }
            final boolean optBoolean = jSONObject.optBoolean("mask");
            String optString3 = jSONObject.optString("image", "-1");
            final Drawable a2 = h.a(context, optString3, eVar);
            if (DEBUG) {
                Log.e("ShowToastAction", "imagepath = " + optString3);
            }
            String str2 = (!TextUtils.equals(optString3, "-1") && a2 == null && TextUtils.equals(optString, "2")) ? "1" : optString;
            final String optString4 = jSONObject.optString("cb");
            final String optString5 = jSONObject.optString("buttonText");
            char c = 65535;
            switch (str2.hashCode()) {
                case 49:
                    if (str2.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str2.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str2.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
                case 52:
                    if (str2.equals("4")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.e.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(context, callbackHandler, unitedSchemeEntity, optString2, aN, optBoolean);
                        }
                    });
                    break;
                case 1:
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.e.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(context, callbackHandler, unitedSchemeEntity, optString2, aN, a2, optBoolean);
                        }
                    });
                    break;
                case 2:
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.e.e.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.b(context, callbackHandler, unitedSchemeEntity, optString2, aN, optBoolean);
                        }
                    });
                    break;
                case 3:
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.e.e.4
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(context, callbackHandler, unitedSchemeEntity, optString2, aN, optString5, optString4);
                        }
                    });
                    break;
                default:
                    n(unitedSchemeEntity);
                    return false;
            }
            return true;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.e("ShowToastAction", "json exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, @NonNull String str2, final String str3) {
        com.baidu.swan.apps.res.widget.b.d.dm(context).h(str).i(str2).jj(i).b(new d.a() { // from class: com.baidu.swan.apps.scheme.actions.e.e.5
            @Override // com.baidu.swan.apps.res.widget.b.d.a
            public void agr() {
                if (!TextUtils.isEmpty(str3)) {
                    callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
        }).aIx();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, str).jj(i).hc(z).jf(2).aIs();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, Drawable drawable, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, h.P(str, 14)).i(drawable).jj(i).hc(z).aIv();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, h.P(str, 14)).jj(i).hc(z).aIw();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void n(UnitedSchemeEntity unitedSchemeEntity) {
        if (DEBUG) {
            Log.w("ShowToastAction", "the toast type is unknown");
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
    }
}
