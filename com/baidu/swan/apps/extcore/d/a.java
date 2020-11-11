package com.baidu.swan.apps.extcore.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.c.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cUg;
    private static a cUh;
    public String extensionCoreVersionName;

    @NonNull
    public static a a(@NonNull com.baidu.swan.apps.extcore.model.b.a aVar) {
        return aVar.aum() == 1 ? oo(aVar.aul()) : om(aVar.aul());
    }

    @NonNull
    private static a om(@NonNull String str) {
        if (cUg == null) {
            cUg = bk(op(str));
        }
        return cUg;
    }

    @NonNull
    private static a oo(@NonNull String str) {
        if (cUh == null) {
            cUh = bk(op(str));
        }
        return cUh;
    }

    @NonNull
    private static a bk(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.extensionCoreVersionName = jSONObject.optString("extension-core-version");
        }
        return aVar;
    }

    private static JSONObject op(@NonNull String str) {
        if (DEBUG) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String readAssetData = d.readAssetData(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(readAssetData)) {
            if (DEBUG) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
                return null;
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(readAssetData);
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
