package com.baidu.swan.apps.media.audio.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.media.audio.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/backgroundAudio");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("AudioBGPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        com.baidu.swan.apps.media.audio.a a;
        JSONObject jSONObject;
        boolean z;
        if (DEBUG) {
            Log.d("AudioBGPlayerAction", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject kl = kl(unitedSchemeEntity.getParam("params"));
        if (kl == null) {
            c.e("backgroundAudio", "param is null!");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d alc = eVar.alc();
        if (TextUtils.equals(str, "/swanAPI/backgroundAudio/open")) {
            a = com.baidu.swan.apps.media.audio.a.a(kl, new com.baidu.swan.apps.media.audio.a());
        } else {
            a = com.baidu.swan.apps.media.audio.a.a(kl, alc.afe());
        }
        if (DEBUG) {
            Log.d("AudioBGPlayerAction", "subAction is : " + str);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 312101659:
                if (str.equals("/swanAPI/backgroundAudio/getParamsSync")) {
                    c = 6;
                    break;
                }
                break;
            case 335869926:
                if (str.equals("/swanAPI/backgroundAudio/open")) {
                    c = 0;
                    break;
                }
                break;
            case 335895760:
                if (str.equals("/swanAPI/backgroundAudio/play")) {
                    c = 2;
                    break;
                }
                break;
            case 335978516:
                if (str.equals("/swanAPI/backgroundAudio/seek")) {
                    c = 4;
                    break;
                }
                break;
            case 335993246:
                if (str.equals("/swanAPI/backgroundAudio/stop")) {
                    c = 5;
                    break;
                }
                break;
            case 820188005:
                if (str.equals("/swanAPI/backgroundAudio/update")) {
                    c = 1;
                    break;
                }
                break;
            case 1822525402:
                if (str.equals("/swanAPI/backgroundAudio/pause")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                c.i("backgroundAudio", "open, audioId " + a.bYS);
                alc.a(a, callbackHandler);
                jSONObject = null;
                z = true;
                break;
            case 1:
                c.i("backgroundAudio", "update, audioId " + a.bYS);
                alc.a(a);
                jSONObject = null;
                z = true;
                break;
            case 2:
                c.i("backgroundAudio", "play, audioId " + a.bYS);
                alc.resume();
                jSONObject = null;
                z = true;
                break;
            case 3:
                c.i("backgroundAudio", "pause, audioId " + a.bYS);
                alc.pause();
                jSONObject = null;
                z = true;
                break;
            case 4:
                c.i("backgroundAudio", "seek, audioId " + a.bYS + " position " + a.mPos);
                alc.seekTo(a.mPos);
                jSONObject = null;
                z = true;
                break;
            case 5:
                c.i("backgroundAudio", "stop, audioId " + a.bYS);
                alc.stop();
                jSONObject = null;
                z = true;
                break;
            case 6:
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt(a.bYW, alc.kk(a.bYW));
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0);
                    return true;
                } catch (JSONException e) {
                    c.e("backgroundAudio", "getParams error " + e.toString());
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    jSONObject = jSONObject2;
                    z = true;
                    break;
                }
            default:
                jSONObject = null;
                z = false;
                break;
        }
        if (z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
        return super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }

    private JSONObject kl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("AudioBGPlayerAction", Log.getStackTraceString(e));
                }
            }
        }
        return null;
    }
}
