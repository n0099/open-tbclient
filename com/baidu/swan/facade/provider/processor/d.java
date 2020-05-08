package com.baidu.swan.facade.provider.processor;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.fsg.base.statistics.j;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.facade.provider.processor.a
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String arH = arH();
        if (DEBUG) {
            Log.i("ParamsProcessor", "params: " + arH);
        }
        String encryptParams = encryptParams(arH);
        if (DEBUG) {
            Log.i("ParamsProcessor", "encryption params: " + encryptParams);
        }
        return oM(encryptParams);
    }

    private String arH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swan_sdk_version", com.baidu.swan.apps.c.getVersion());
            jSONObject.put("swan_core_version", com.baidu.swan.apps.swancore.b.gF(0));
            jSONObject.put("game_core_version", com.baidu.swan.apps.swancore.b.gF(1));
            jSONObject.put("uid", com.baidu.swan.apps.w.a.abS().aS(AppRuntime.getAppContext()));
            jSONObject.put("puid", com.baidu.swan.apps.w.a.abS().aR(AppRuntime.getAppContext()));
            jSONObject.put(j.c, com.baidu.swan.apps.h.c.sr());
            jSONObject.put("ut", com.baidu.swan.apps.h.c.getDeviceInfo());
            jSONObject.put("timestamp", System.currentTimeMillis());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String encryptParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Base64.encodeToString(com.baidu.swan.facade.provider.a.b.a(str.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDI4nl5QCs/mwaPjm2H4cHaxTBya7F1S1f2IXBwfEB6QD16esL+37EX+SeGR3NQ+0Xxs32Bpl/E70xlII24e/E6GJnU1vks/d1+h4rBjv987X2eppIBrT8f6COjczYcUm0OBa7IGmAMnqMCnOt/U1Wx3Mn7zniQKueT5DjQBOuxyQIDAQAB", 117), 10);
    }

    private Cursor oM(String str) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"params"}, 1);
        matrixCursor.newRow().add("params", str);
        return matrixCursor;
    }
}
