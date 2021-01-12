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
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/backgroundAudio");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("AudioBGPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        com.baidu.swan.apps.media.audio.a a2;
        JSONObject jSONObject;
        boolean z;
        if (DEBUG) {
            Log.d("AudioBGPlayerAction", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject pc = pc(unitedSchemeEntity.getParam("params"));
        if (pc == null) {
            c.e("backgroundAudio", "param is null!");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d aII = eVar.aII();
        if (TextUtils.equals(str, "/swanAPI/backgroundAudio/open")) {
            a2 = com.baidu.swan.apps.media.audio.a.a(pc, new com.baidu.swan.apps.media.audio.a());
        } else {
            a2 = com.baidu.swan.apps.media.audio.a.a(pc, aII.aAq());
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
                c.i("backgroundAudio", "open, audioId " + a2.dge);
                aII.a(a2, callbackHandler);
                jSONObject = null;
                z = true;
                break;
            case 1:
                c.i("backgroundAudio", "update, audioId " + a2.dge);
                aII.a(a2);
                jSONObject = null;
                z = true;
                break;
            case 2:
                c.i("backgroundAudio", "play, audioId " + a2.dge);
                aII.resume();
                jSONObject = null;
                z = true;
                break;
            case 3:
                c.i("backgroundAudio", "pause, audioId " + a2.dge);
                aII.pause();
                jSONObject = null;
                z = true;
                break;
            case 4:
                c.i("backgroundAudio", "seek, audioId " + a2.dge + " position " + a2.mPos);
                aII.seekTo(a2.mPos);
                jSONObject = null;
                z = true;
                break;
            case 5:
                c.i("backgroundAudio", "stop, audioId " + a2.dge);
                aII.stop();
                jSONObject = null;
                z = true;
                break;
            case 6:
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt(a2.dgj, aII.pb(a2.dgj));
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
        return super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }

    private JSONObject pc(String str) {
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
