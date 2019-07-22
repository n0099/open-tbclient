package com.baidu.swan.apps.media.audio.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.media.audio.d;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/backgroundAudio");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("AudioBGPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.media.audio.a a;
        JSONObject jSONObject;
        boolean z;
        if (DEBUG) {
            Log.d("AudioBGPlayerAction", "handleSubAction subAction: " + str);
        }
        JSONObject fl = fl(unitedSchemeEntity.getParam("params"));
        if (fl == null) {
            c.e("backgroundAudio", "param is null!");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d Mm = bVar.Mm();
        if (TextUtils.equals(str, "/swan/backgroundAudio/open")) {
            a = com.baidu.swan.apps.media.audio.a.a(fl, new com.baidu.swan.apps.media.audio.a());
        } else {
            a = com.baidu.swan.apps.media.audio.a.a(fl, Mm.Hc());
        }
        if (DEBUG) {
            Log.d("AudioBGPlayerAction", "subAction is : " + str);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2055590369:
                if (str.equals("/swan/backgroundAudio/update")) {
                    c = 1;
                    break;
                }
                break;
            case -71356960:
                if (str.equals("/swan/backgroundAudio/pause")) {
                    c = 3;
                    break;
                }
                break;
            case 239897377:
                if (str.equals("/swan/backgroundAudio/getParamsSync")) {
                    c = 6;
                    break;
                }
                break;
            case 1798797600:
                if (str.equals("/swan/backgroundAudio/open")) {
                    c = 0;
                    break;
                }
                break;
            case 1798823434:
                if (str.equals("/swan/backgroundAudio/play")) {
                    c = 2;
                    break;
                }
                break;
            case 1798906190:
                if (str.equals("/swan/backgroundAudio/seek")) {
                    c = 4;
                    break;
                }
                break;
            case 1798920920:
                if (str.equals("/swan/backgroundAudio/stop")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                c.i("backgroundAudio", "open, audioId " + a.aBc);
                Mm.a(a, callbackHandler);
                jSONObject = null;
                z = true;
                break;
            case 1:
                c.i("backgroundAudio", "update, audioId " + a.aBc);
                Mm.a(a);
                jSONObject = null;
                z = true;
                break;
            case 2:
                c.i("backgroundAudio", "play, audioId " + a.aBc);
                Mm.resume();
                jSONObject = null;
                z = true;
                break;
            case 3:
                c.i("backgroundAudio", "pause, audioId " + a.aBc);
                Mm.pause();
                jSONObject = null;
                z = true;
                break;
            case 4:
                c.i("backgroundAudio", "seek, audioId " + a.aBc + " position " + a.mPos);
                Mm.seekTo(a.mPos);
                jSONObject = null;
                z = true;
                break;
            case 5:
                c.i("backgroundAudio", "stop, audioId " + a.aBc);
                Mm.stop();
                jSONObject = null;
                z = true;
                break;
            case 6:
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt(a.aBh, Mm.fk(a.aBh));
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
        return super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
    }

    private JSONObject fl(String str) {
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
