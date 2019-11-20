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
    private static b aQs;
    public String aQn;

    @NonNull
    public static b fg(@NonNull String str) {
        if (aQs == null) {
            aQs = U(fh(str));
        }
        return aQs;
    }

    @NonNull
    private static b U(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            bVar.aQn = jSONObject.optString("extension-core-version");
        }
        return bVar;
    }

    private static JSONObject fh(@NonNull String str) {
        if (DEBUG) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String ac = com.baidu.swan.c.a.ac(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(ac)) {
            if (DEBUG) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
                return null;
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(ac);
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
