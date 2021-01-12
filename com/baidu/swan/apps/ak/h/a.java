package com.baidu.swan.apps.ak.h;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.n;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends aa {
    private static final boolean DEBUG = b.DEBUG;

    public a(j jVar) {
        super(jVar, "/swanAPI/getSystemRiskInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        com.baidu.swan.apps.adaptation.a.e awD = com.baidu.swan.apps.t.a.awD();
        JSONObject jSONObject = new JSONObject();
        if (context == null) {
            try {
                context = com.baidu.swan.apps.t.a.awy();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put(DpStatConstants.KEY_USER_ID, awD == null ? "" : awD.cb(context));
        jSONObject.put("zid", awD == null ? "" : com.baidu.swan.apps.t.a.axq().cT(context));
        jSONObject.put("idfa", "");
        jSONObject.put("imei", ak.aNV());
        jSONObject.put("appkey", eVar == null ? "" : eVar.getAppKey());
        jSONObject.put("os", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("osVersion", Build.VERSION.RELEASE);
        jSONObject.put("hostName", context.getPackageName());
        jSONObject.put("hostVersion", ak.getVersionName());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("uuid", com.baidu.swan.uuid.b.eL(context).getUUID());
        jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        jSONObject.put("cuid", awD == null ? "" : awD.cc(context));
        if (DEBUG) {
            Log.d("GetSystemRiskInfoAction", jSONObject.toString());
        }
        String md5 = com.baidu.swan.uuid.b.b.toMd5(UUID.randomUUID().toString().getBytes(), false);
        String t = n.t(md5, jSONObject.toString(), "AES/CTR/NoPadding", "4c6579b50ff05adb");
        String ac = n.ac("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjP7b5s3ozPgXpS7d9k2dGaie8KLNmCbhybWPxVjLTmN4Jj3c7GnwdzyIQOix7t95Kipd75AXcnP2c4vUnmXPpZwh6ejNAmiGLkLE7fobPCZKfI3aTweSKxIav3QPHMaZrra1aiGtnZ+rTHXD3chBpNCGbuAEUqN+psHjvnHO72QIDAQAB", md5, "RSA/ECB/PKCS1Padding");
        if (DEBUG) {
            Log.d("GetSystemRiskInfoAction", "aesKey=" + md5 + ", aesValue=" + t + ", rsaKey=" + ac);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("key", ac);
            jSONObject3.put("value", t);
            jSONObject2.put("content", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
        return true;
    }
}
