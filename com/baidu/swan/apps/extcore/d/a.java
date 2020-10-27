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
    private static a cOn;
    private static a cOo;
    public String extensionCoreVersionName;

    @NonNull
    public static a a(@NonNull com.baidu.swan.apps.extcore.model.b.a aVar) {
        return aVar.arL() == 1 ? nY(aVar.arK()) : nX(aVar.arK());
    }

    @NonNull
    private static a nX(@NonNull String str) {
        if (cOn == null) {
            cOn = be(nZ(str));
        }
        return cOn;
    }

    @NonNull
    private static a nY(@NonNull String str) {
        if (cOo == null) {
            cOo = be(nZ(str));
        }
        return cOo;
    }

    @NonNull
    private static a be(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.extensionCoreVersionName = jSONObject.optString("extension-core-version");
        }
        return aVar;
    }

    private static JSONObject nZ(@NonNull String str) {
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
