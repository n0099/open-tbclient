package com.baidu.swan.apps.al.h;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.n;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends aa {
    private static final boolean DEBUG = b.DEBUG;

    public a(j jVar) {
        super(jVar, "/swanAPI/getSystemRiskInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        com.baidu.swan.apps.adaptation.a.e ask = com.baidu.swan.apps.t.a.ask();
        JSONObject jSONObject = new JSONObject();
        if (context == null) {
            try {
                context = com.baidu.swan.apps.t.a.asf();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put(DpStatConstants.KEY_USER_ID, ask == null ? "" : ask.bp(context));
        jSONObject.put("zid", ask == null ? "" : com.baidu.swan.apps.t.a.asY().cg(context));
        jSONObject.put("idfa", "");
        jSONObject.put("imei", ak.aIF());
        jSONObject.put("appkey", eVar == null ? "" : eVar.getAppKey());
        jSONObject.put("os", "android");
        jSONObject.put("osVersion", Build.VERSION.RELEASE);
        jSONObject.put("hostName", context.getPackageName());
        jSONObject.put("hostVersion", ak.getVersionName());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("uuid", com.baidu.swan.uuid.b.dO(context).getUUID());
        jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        jSONObject.put("cuid", ask == null ? "" : ask.bq(context));
        if (DEBUG) {
            Log.d("GetSystemRiskInfoAction", jSONObject.toString());
        }
        String md5 = com.baidu.swan.uuid.b.b.toMd5(UUID.randomUUID().toString().getBytes(), false);
        String s = n.s(md5, jSONObject.toString(), "AES/CTR/NoPadding", "4c6579b50ff05adb");
        String Q = n.Q("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjP7b5s3ozPgXpS7d9k2dGaie8KLNmCbhybWPxVjLTmN4Jj3c7GnwdzyIQOix7t95Kipd75AXcnP2c4vUnmXPpZwh6ejNAmiGLkLE7fobPCZKfI3aTweSKxIav3QPHMaZrra1aiGtnZ+rTHXD3chBpNCGbuAEUqN+psHjvnHO72QIDAQAB", md5, "RSA/ECB/PKCS1Padding");
        if (DEBUG) {
            Log.d("GetSystemRiskInfoAction", "aesKey=" + md5 + ", aesValue=" + s + ", rsaKey=" + Q);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("key", Q);
            jSONObject3.put("value", s);
            jSONObject2.put("content", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
        return true;
    }
}
