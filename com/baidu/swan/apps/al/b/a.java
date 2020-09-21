package com.baidu.swan.apps.al.b;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/getMediaVolumeSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("getMediaVolumeSync", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "getMediaVolumeSync --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            com.baidu.swan.apps.console.c.e("getMediaVolumeSync", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (DEBUG) {
                Log.d("SwanAppAction", "getMediaVolumeSync --- illegal context");
            }
            return false;
        } else {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "get AudioManager error");
                if (DEBUG) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- get AudioManager error");
                }
                return false;
            }
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            if (streamMaxVolume <= 0) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "max volume get 0");
                if (DEBUG) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- max volume get 0");
                }
                return false;
            }
            double d = streamVolume / streamMaxVolume;
            if (d < 0.0d) {
                d = 0.0d;
            } else if (d > 1.0d) {
                d = 1.0d;
            }
            if (DEBUG) {
                Log.d("SwanAppAction", "getMediaVolumeSync: " + d);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                return true;
            } catch (JSONException e) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                if (DEBUG) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- json exception");
                }
                return false;
            }
        }
    }
}
