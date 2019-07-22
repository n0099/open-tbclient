package com.baidu.swan.apps.extcore.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b awX;
    public String awS;

    @NonNull
    public static b ex(@NonNull String str) {
        if (awX == null) {
            awX = v(ey(str));
        }
        return awX;
    }

    @NonNull
    private static b v(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.awS = jSONObject.optString("extension-core-version");
        }
        return bVar;
    }

    private static JSONObject ey(@NonNull String str) {
        if (DEBUG) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String ad = com.baidu.swan.c.a.ad(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(ad)) {
            if (DEBUG) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
                return null;
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(ad);
            if (DEBUG) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }
}
