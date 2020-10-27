package com.baidu.o.e;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.rtc.RtcConfig;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.ab.c;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a extends UnitedSchemeBaseDispatcher {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "audioRtc";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00aa, code lost:
        if (r3.equals("stop") != false) goto L22;
     */
    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        char c = 1;
        if (DEBUG) {
            Log.i(TAG, String.format(Locale.getDefault(), "entity(%s)", unitedSchemeEntity.getUri()));
        }
        c.d(TAG, "start UnitedSchemeAudioRTCDispatcher");
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            if (DEBUG) {
                Log.w(TAG, "Uri action is null");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            switch (path.hashCode()) {
                case -841359278:
                    if (path.equals("unMute")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3363353:
                    if (path.equals("mute")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3540994:
                    break;
                case 109757538:
                    if (path.equals("start")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return z(context, unitedSchemeEntity, callbackHandler);
                case 1:
                    return A(context, unitedSchemeEntity, callbackHandler);
                case 2:
                    return B(context, unitedSchemeEntity, callbackHandler);
                case 3:
                    return C(context, unitedSchemeEntity, callbackHandler);
                default:
                    if (DEBUG) {
                        Log.w(TAG, "action " + path + " not support");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
            }
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean z(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        JSONObject jSONObject;
        final e aEU = e.aEU();
        if (aEU == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aEU.id)) {
            c.e(TAG, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.e(TAG, "object is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            final String optString = optParamsAsJo.optString("rtcId");
            if (optString == null) {
                c.e(TAG, "rtcId is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            com.baidu.o.a zc = com.baidu.o.d.a.bcX().zc(optString);
            if (zc != null) {
                c.e(TAG, "AudioRTC is already created");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt(TiebaInitialize.LogFields.ERROR_CODE, "2005");
                    jSONObject2.putOpt("errMsg", "err duplicate start");
                    zc.e("onError", jSONObject2);
                    return false;
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.d(TAG, Log.getStackTraceString(e));
                        return false;
                    }
                    return false;
                }
            }
            String optString2 = optParamsAsJo.optString("cb");
            if (!TextUtils.isEmpty(optString2)) {
                try {
                    jSONObject = new JSONObject(optString2);
                } catch (JSONException e2) {
                    if (DEBUG) {
                        Log.d(TAG, Log.getStackTraceString(e2));
                    }
                }
                if (jSONObject != null) {
                    c.e(TAG, "params is invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                final com.baidu.o.c.a aVar = new com.baidu.o.c.a(callbackHandler, jSONObject);
                if (aVar == null) {
                    c.e(TAG, "params is invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                final RtcConfig m = com.baidu.o.a.a.m(context, optParamsAsJo);
                if (m == null) {
                    c.e(TAG, "params is invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                aEU.aFg().b((Activity) context, PermissionProxy.SCOPE_ID_RECORD, new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.o.e.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<b.d> hVar) {
                        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            c.e(a.TAG, "AudioRTC authorize failure");
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
                            if (aVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                try {
                                    jSONObject3.putOpt(TiebaInitialize.LogFields.ERROR_CODE, "2004");
                                    jSONObject3.putOpt("errMsg", "err user deny");
                                    aVar.e("onError", jSONObject3);
                                    return;
                                } catch (JSONException e3) {
                                    if (a.DEBUG) {
                                        Log.d(a.TAG, Log.getStackTraceString(e3));
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        a.this.a(context, unitedSchemeEntity, callbackHandler, m, aVar, aEU, optString);
                    }
                });
                return true;
            }
            jSONObject = null;
            if (jSONObject != null) {
            }
        }
    }

    private boolean A(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aEU = e.aEU();
        if (aEU == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aEU.id)) {
            c.e(TAG, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.e(TAG, "object is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("rtcId");
            if (optString == null) {
                c.e(TAG, "rtcId is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            com.baidu.o.a zc = com.baidu.o.d.a.bcX().zc(optString);
            if (zc == null) {
                c.e(TAG, "AudioRTC is not created");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            zc.stop();
            com.baidu.o.d.a.bcX().zb(optString);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    private boolean B(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aEU = e.aEU();
        if (aEU == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aEU.id)) {
            c.e(TAG, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.e(TAG, "object is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("rtcId");
            if (optString == null) {
                c.e(TAG, "rtcId is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            com.baidu.o.a zc = com.baidu.o.d.a.bcX().zc(optString);
            if (zc == null) {
                c.e(TAG, "AudioRTC is not created");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            zc.mute();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    private boolean C(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aEU = e.aEU();
        if (aEU == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aEU.id)) {
            c.e(TAG, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.e(TAG, "object is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("rtcId");
            if (optString == null) {
                c.e(TAG, "rtcId is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            com.baidu.o.a zc = com.baidu.o.d.a.bcX().zc(optString);
            if (zc == null) {
                c.e(TAG, "AudioRTC is not created");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            zc.unMute();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final RtcConfig rtcConfig, final com.baidu.o.c.a aVar, e eVar, final String str) {
        if (com.baidu.o.d.a.bJ(context)) {
            if (DEBUG) {
                Log.d(TAG, "AudioRTC --- had system permission");
            }
            a(context, unitedSchemeEntity, callbackHandler, rtcConfig, aVar, str);
            return;
        }
        f.axo();
        eVar.aEO().a(2, new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, new c.a() { // from class: com.baidu.o.e.a.2
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i != 2 || iArr.length <= 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, "AudioRTC --- wrong requestCode");
                    }
                    com.baidu.swan.apps.console.c.e(a.TAG, "none permission");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (aVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt(TiebaInitialize.LogFields.ERROR_CODE, "2002");
                            jSONObject.putOpt("errMsg", "err execute");
                            aVar.e("onError", jSONObject);
                            return;
                        } catch (JSONException e) {
                            if (a.DEBUG) {
                                Log.d(a.TAG, Log.getStackTraceString(e));
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                boolean z = true;
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (iArr[i2] == -1) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, "AudioRTC --- permission is not granted");
                    }
                    com.baidu.swan.apps.console.c.e(a.TAG, "none permission");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (aVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.putOpt(TiebaInitialize.LogFields.ERROR_CODE, "2002");
                            jSONObject2.putOpt("errMsg", "err execute");
                            aVar.e("onError", jSONObject2);
                            return;
                        } catch (JSONException e2) {
                            if (a.DEBUG) {
                                Log.d(a.TAG, Log.getStackTraceString(e2));
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d(a.TAG, "AudioRTC --- permission is granted ~");
                }
                a.this.a(context, unitedSchemeEntity, callbackHandler, rtcConfig, aVar, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, RtcConfig rtcConfig, com.baidu.o.c.a aVar, String str) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        com.baidu.o.a aVar2 = new com.baidu.o.a(context, rtcConfig, str);
        aVar2.a(aVar);
        com.baidu.o.d.a.bcX().a(aVar2, str);
        aVar2.start();
    }
}
