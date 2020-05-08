package com.baidu.swan.apps.extcore.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.d.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bTI;
    private static a bTJ;
    public String extensionCoreVersionName;

    @NonNull
    public static a a(@NonNull com.baidu.swan.apps.extcore.model.b.a aVar) {
        return aVar.ZR() == 1 ? iZ(aVar.ZQ()) : iY(aVar.ZQ());
    }

    @NonNull
    private static a iY(@NonNull String str) {
        if (bTI == null) {
            bTI = at(ja(str));
        }
        return bTI;
    }

    @NonNull
    private static a iZ(@NonNull String str) {
        if (bTJ == null) {
            bTJ = at(ja(str));
        }
        return bTJ;
    }

    @NonNull
    private static a at(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.extensionCoreVersionName = jSONObject.optString("extension-core-version");
        }
        return aVar;
    }

    private static JSONObject ja(@NonNull String str) {
        if (DEBUG) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String readAssetData = c.readAssetData(AppRuntime.getAppContext(), str);
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
