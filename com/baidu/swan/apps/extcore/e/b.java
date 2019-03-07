package com.baidu.swan.apps.extcore.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = c.DEBUG;
    private static b avQ;
    public String avL;

    @NonNull
    public static b eD(@NonNull String str) {
        if (avQ == null) {
            avQ = A(eE(str));
        }
        return avQ;
    }

    @NonNull
    private static b A(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.avL = jSONObject.optString("extension-core-version");
        }
        return bVar;
    }

    private static JSONObject eE(@NonNull String str) {
        if (DEBUG) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String aq = com.baidu.swan.c.b.aq(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(aq)) {
            if (DEBUG) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
                return null;
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(aq);
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
