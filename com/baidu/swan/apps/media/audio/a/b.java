package com.baidu.swan.apps.media.audio.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.a.q;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.media.audio.SwanAppAudioPlayer;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.PathType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/audio");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("AudioPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        SwanAppAudioPlayer og;
        boolean z;
        boolean z2;
        char c = 65535;
        if (DEBUG) {
            Log.d("AudioPlayerAction", "handleSubAction subAction: " + str);
        }
        if (eVar.abL()) {
            if (DEBUG) {
                Log.d("AudioPlayerAction", "AudioPlayerAction does not supported when app is invisible.");
            }
            switch (str.hashCode()) {
                case 1726838360:
                    if (str.equals("/swanAPI/audio/open")) {
                        z2 = false;
                        break;
                    }
                    z2 = true;
                    break;
                case 1726864194:
                    if (str.equals("/swanAPI/audio/play")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                default:
                    z2 = true;
                    break;
            }
            switch (z2) {
                case false:
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                case true:
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
            }
        }
        JSONObject oe = oe(unitedSchemeEntity.getParam("params"));
        if (oe == null) {
            c.e("audio", "object is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (TextUtils.equals(str, "/swanAPI/audio/setInnerAudioOption")) {
            return a(oe, eVar, unitedSchemeEntity, callbackHandler);
        } else {
            if (TextUtils.equals(str, "/swanAPI/audio/getAvailableAudioSources")) {
                return a(unitedSchemeEntity, callbackHandler, eVar);
            }
            String optString = oe.optString("audioId");
            if (TextUtils.equals(str, "/swanAPI/audio/open")) {
                og = new SwanAppAudioPlayer(optString);
            } else {
                og = og(optString);
            }
            if (og == null) {
                c.e("audio", "player is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            com.baidu.swan.apps.media.audio.b a = com.baidu.swan.apps.media.audio.b.a(oe, og.asy());
            if (!a.isValid()) {
                c.e("audio", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            if (DEBUG) {
                Log.d("AudioPlayerAction", "subAction is : " + str);
            }
            switch (str.hashCode()) {
                case 1726838360:
                    if (str.equals("/swanAPI/audio/open")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1726864194:
                    if (str.equals("/swanAPI/audio/play")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1726946950:
                    if (str.equals("/swanAPI/audio/seek")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1726961680:
                    if (str.equals("/swanAPI/audio/stop")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1806024023:
                    if (str.equals("/swanAPI/audio/update")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1981190058:
                    if (str.equals("/swanAPI/audio/close")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1992873896:
                    if (str.equals("/swanAPI/audio/pause")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    c.i("audio", "open, audio id:" + a.cyk);
                    a(context, callbackHandler, og, a);
                    z = true;
                    break;
                case 1:
                    c.i("audio", "update, audio id:" + a.cyk);
                    a(context, og, a);
                    z = true;
                    break;
                case 2:
                    c.i("audio", "play, audio id:" + a.cyk);
                    og.play();
                    z = true;
                    break;
                case 3:
                    c.i("audio", "pause, audio id:" + a.cyk);
                    og.pause();
                    z = true;
                    break;
                case 4:
                    c.i("audio", "seek, audio id:" + a.cyk);
                    og.seekTo(a.mPos);
                    z = true;
                    break;
                case 5:
                    c.i("audio", "stop, audio id:" + a.cyk);
                    og.stop();
                    z = true;
                    break;
                case 6:
                    c.i("audio", "release, audio id:" + a.cyk);
                    og.release();
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
            return super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
    }

    private void a(Context context, final SwanAppAudioPlayer swanAppAudioPlayer, final com.baidu.swan.apps.media.audio.b bVar) {
        if (TextUtils.isEmpty(bVar.mUrl) && com.baidu.swan.apps.storage.b.rJ(bVar.mUrl) == PathType.CLOUD) {
            com.baidu.swan.apps.t.a.apc().a(context, bVar.mUrl, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: onCallback */
                public void I(final String str) {
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.a.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.mUrl = str;
                            swanAppAudioPlayer.a(bVar);
                        }
                    });
                }
            });
        } else {
            swanAppAudioPlayer.a(bVar);
        }
    }

    private void a(Context context, final CallbackHandler callbackHandler, final SwanAppAudioPlayer swanAppAudioPlayer, final com.baidu.swan.apps.media.audio.b bVar) {
        q apc = com.baidu.swan.apps.t.a.apc();
        if (apc != null && com.baidu.swan.apps.storage.b.rJ(bVar.mUrl) == PathType.CLOUD) {
            apc.a(context, bVar.mUrl, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: onCallback */
                public void I(final String str) {
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.a.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.mUrl = str;
                            swanAppAudioPlayer.a(bVar, callbackHandler);
                        }
                    });
                }
            });
        } else {
            swanAppAudioPlayer.a(bVar, callbackHandler);
        }
    }

    private SwanAppAudioPlayer og(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.media.a nZ = com.baidu.swan.apps.media.b.nZ(str);
        if (!(nZ instanceof SwanAppAudioPlayer)) {
            return null;
        }
        return (SwanAppAudioPlayer) nZ.ast();
    }

    private JSONObject oe(String str) {
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

    private boolean a(JSONObject jSONObject, e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (eVar == null) {
            c.e("AudioPlayerAction", "aiapp or entity is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            boolean optBoolean = jSONObject.optBoolean("mixWithOther", false);
            eVar.aAa().a("key_audio_is_mix_with_other", Boolean.valueOf(optBoolean));
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

    public boolean a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.e("AudioPlayerAction", "aiapp or entity is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("auto");
        jSONArray.put("mic");
        jSONArray.put("camcorder");
        jSONArray.put("voice_communication");
        jSONArray.put("voice_recognition");
        try {
            jSONObject.put("audioSources", jSONArray.toString());
            if (DEBUG) {
                Log.d("AudioPlayerAction", "audioSource:" + jSONObject.toString());
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
