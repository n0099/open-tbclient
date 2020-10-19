package com.baidu.swan.apps.media.a.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.media.a.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/recorder");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("AudioRecordAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str, final e eVar) {
        if (DEBUG) {
            Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            c.e("record", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("AudioRecordAction", "record --- illegal swanApp");
            }
            return false;
        }
        if (eVar.afg()) {
            if (DEBUG) {
                Log.d("AudioRecordAction", "AudioRecordAction does not supported when app is invisible.");
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -944894266:
                    if (str.equals("/swanAPI/recorder/start")) {
                        c = 0;
                        break;
                    }
                    break;
                case 731105865:
                    if (str.equals("/swanAPI/recorder/resume")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                case 1:
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
            }
        }
        if (TextUtils.isEmpty(eVar.id)) {
            c.e("record", "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            if (DEBUG) {
                Log.d("AudioRecordAction", "record --- none swanApp id");
            }
            return false;
        } else if (!com.baidu.swan.apps.media.a.c.a.awS().pD(str)) {
            return false;
        } else {
            JSONObject pm = pm(unitedSchemeEntity.getParam("params"));
            if (TextUtils.equals(str, "/swanAPI/recorder/start") && pm == null) {
                c.e("record", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            }
            final com.baidu.swan.apps.media.a.a a2 = com.baidu.swan.apps.media.a.a.a(pm, com.baidu.swan.apps.media.a.c.a.awS().awX());
            if (a2 == null) {
                c.e("record", "error params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                return false;
            }
            JSONObject awR = a2.awR();
            if (awR != null) {
                c.e("record", "error params");
                unitedSchemeEntity.result = awR;
                return false;
            }
            final b a3 = b.a(callbackHandler, unitedSchemeEntity, a2.cPK, com.baidu.swan.apps.media.a.c.a.awS().awY());
            final String sO = com.baidu.swan.apps.storage.b.sO(eVar.id);
            if (TextUtils.isEmpty(sO)) {
                c.e("record", "none tmp path");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e("record", "handle action, but context is not Activity");
                return false;
            } else {
                eVar.aDm().b(context, PermissionProxy.SCOPE_ID_RECORD, new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.media.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<b.d> hVar) {
                        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                            int errorCode = hVar == null ? 10001 : hVar.getErrorCode();
                            a.this.a(a3, errorCode, com.baidu.swan.apps.setting.oauth.c.hi(errorCode));
                        } else if (com.baidu.swan.apps.media.a.c.a.awS().pE(str)) {
                            a.this.a(a3, 2001, "error execute time");
                            c.e("record", "error execute time");
                        } else {
                            a.this.a(context, unitedSchemeEntity, callbackHandler, str, a2, a3, sO, eVar.id);
                        }
                    }
                });
                if (DEBUG) {
                    Log.d("AudioRecordAction", "subAction is : " + str);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str, final com.baidu.swan.apps.media.a.a aVar, final com.baidu.swan.apps.media.a.b bVar, final String str2, final String str3) {
        com.baidu.swan.apps.ab.a.a(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.a.a.a.2
            @Override // com.baidu.swan.apps.ab.b
            public void jL(String str4) {
                if (a.DEBUG) {
                    Log.d("AudioRecordAction", str4 + "");
                }
                a.this.a(callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3);
            }

            @Override // com.baidu.swan.apps.ab.b
            public void Z(int i, String str4) {
                if (a.DEBUG) {
                    Log.d("AudioRecordAction", str4 + "");
                }
                c.e("record", str4);
                a.this.a(bVar, 10005, "system deny");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, com.baidu.swan.apps.media.a.a aVar, com.baidu.swan.apps.media.a.b bVar, String str2, String str3) {
        char c = 65535;
        switch (str.hashCode()) {
            case -948211622:
                if (str.equals("/swanAPI/recorder/pause")) {
                    c = 1;
                    break;
                }
                break;
            case -944894266:
                if (str.equals("/swanAPI/recorder/start")) {
                    c = 0;
                    break;
                }
                break;
            case 731105865:
                if (str.equals("/swanAPI/recorder/resume")) {
                    c = 2;
                    break;
                }
                break;
            case 2047729950:
                if (str.equals("/swanAPI/recorder/stop")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                a(context, aVar, bVar, str2, str3);
                return;
            case 1:
                c.i("record", "pause");
                pauseRecord();
                return;
            case 2:
                c.i("record", "resume");
                resumeRecord();
                return;
            case 3:
                c.i("record", "stop");
                stopRecord();
                return;
            default:
                return;
        }
    }

    private void a(Context context, com.baidu.swan.apps.media.a.a aVar, com.baidu.swan.apps.media.a.b bVar, String str, String str2) {
        c.i("record", OneKeyLoginSdkCall.l);
        com.baidu.swan.apps.media.a.c.a.awS().a(str, aVar, context, bVar, str2);
        c.i("record", "start");
        com.baidu.swan.apps.media.a.c.a.awS().fj(true);
    }

    private void pauseRecord() {
        com.baidu.swan.apps.media.a.c.a.awS().pauseRecord();
    }

    private void resumeRecord() {
        com.baidu.swan.apps.media.a.c.a.awS().resumeRecord();
    }

    private void stopRecord() {
        com.baidu.swan.apps.media.a.c.a.awS().stopRecord();
        com.baidu.swan.apps.media.a.c.a.release();
    }

    private JSONObject pm(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("AudioRecordAction", Log.getStackTraceString(e));
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.media.a.b bVar, int i, String str) {
        if (bVar == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.cPP)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                f.avu().b(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("record", "json error", e);
                return;
            }
        }
        bVar.ae(i, str);
    }
}
