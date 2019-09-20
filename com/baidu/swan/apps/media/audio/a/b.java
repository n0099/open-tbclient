package com.baidu.swan.apps.media.audio.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.media.audio.SwanAppAudioPlayer;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends z {
    public b(j jVar) {
        super(jVar, "/swan/audio");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("AudioPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        SwanAppAudioPlayer fo;
        boolean z;
        if (DEBUG) {
            Log.d("AudioPlayerAction", "handleSubAction subAction: " + str);
        }
        JSONObject fn = fn(unitedSchemeEntity.getParam("params"));
        if (fn == null) {
            c.e("audio", "object is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (TextUtils.equals(str, "/swan/audio/setInnerAudioOption")) {
            return a(fn, bVar, unitedSchemeEntity, callbackHandler);
        } else {
            String optString = fn.optString("audioId");
            if (TextUtils.equals(str, "/swan/audio/open")) {
                fo = new SwanAppAudioPlayer(optString);
            } else {
                fo = fo(optString);
            }
            if (fo == null) {
                c.e("audio", "player is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            com.baidu.swan.apps.media.audio.b a = com.baidu.swan.apps.media.audio.b.a(fn, fo.Hb());
            if (!a.isValid()) {
                c.e("audio", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            if (DEBUG) {
                Log.d("AudioPlayerAction", "subAction is : " + str);
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -740157295:
                    if (str.equals("/swan/audio/update")) {
                        c = 1;
                        break;
                    }
                    break;
                case 588994578:
                    if (str.equals("/swan/audio/open")) {
                        c = 0;
                        break;
                    }
                    break;
                case 589020412:
                    if (str.equals("/swan/audio/play")) {
                        c = 2;
                        break;
                    }
                    break;
                case 589103168:
                    if (str.equals("/swan/audio/seek")) {
                        c = 4;
                        break;
                    }
                    break;
                case 589117898:
                    if (str.equals("/swan/audio/stop")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1067771184:
                    if (str.equals("/swan/audio/close")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1079455022:
                    if (str.equals("/swan/audio/pause")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    c.i("audio", "open, audio id:" + a.aBA);
                    fo.a(a, callbackHandler);
                    z = true;
                    break;
                case 1:
                    c.i("audio", "update, audio id:" + a.aBA);
                    fo.a(a);
                    z = true;
                    break;
                case 2:
                    c.i("audio", "play, audio id:" + a.aBA);
                    fo.play();
                    z = true;
                    break;
                case 3:
                    c.i("audio", "pause, audio id:" + a.aBA);
                    fo.pause();
                    z = true;
                    break;
                case 4:
                    c.i("audio", "seek, audio id:" + a.aBA);
                    fo.seekTo(a.mPos);
                    z = true;
                    break;
                case 5:
                    c.i("audio", "stop, audio id:" + a.aBA);
                    fo.stop();
                    z = true;
                    break;
                case 6:
                    c.i("audio", "release, audio id:" + a.aBA);
                    fo.release();
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            return super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
        }
    }

    private SwanAppAudioPlayer fo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.media.a fi = com.baidu.swan.apps.media.b.fi(str);
        if (!(fi instanceof SwanAppAudioPlayer)) {
            return null;
        }
        return (SwanAppAudioPlayer) fi.GS();
    }

    private JSONObject fn(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("AudioPlayerAction", Log.getStackTraceString(e));
                }
            }
        }
        return null;
    }

    private boolean a(JSONObject jSONObject, com.baidu.swan.apps.ae.b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (bVar == null) {
            c.e("AudioPlayerAction", "aiapp or entity is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            boolean optBoolean = jSONObject.optBoolean("mixWithOther", false);
            bVar.Mr().putBoolean("key_audio_is_mix_with_other", optBoolean);
            if (DEBUG) {
                Log.d("AudioPlayerAction", "Audio Mix Changed to " + optBoolean);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        } catch (Exception e) {
            c.e("AudioPlayerAction", "set aiapps global var error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
