package com.baidu.o.e;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import rx.j;
/* loaded from: classes19.dex */
public class b extends UnitedSchemeBaseDispatcher {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private j cBj;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "RTC";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
        if (r3.equals(com.baidu.android.imsdk.upload.action.IMTrack.DbBuilder.ACTION_UPDATE) != false) goto L22;
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
        c.d(TAG, "start SwanAppUnitedSchemeRTCDispatcher");
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            if (DEBUG) {
                Log.w(TAG, "Uri action is null");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            switch (path.hashCode()) {
                case -1183792455:
                    if (path.equals("insert")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -934610812:
                    if (path.equals("remove")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -841359278:
                    if (path.equals("unMute")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -838846263:
                    break;
                case 3363353:
                    if (path.equals("mute")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3540994:
                    if (path.equals("stop")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (path.equals("start")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 767111033:
                    if (path.equals("switchCamera")) {
                        c = 7;
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
                    return b(context, unitedSchemeEntity, callbackHandler);
                case 1:
                    return c(context, unitedSchemeEntity, callbackHandler);
                case 2:
                    return d(context, unitedSchemeEntity, callbackHandler);
                case 3:
                    return z(context, unitedSchemeEntity, callbackHandler);
                case 4:
                    return A(context, unitedSchemeEntity, callbackHandler);
                case 5:
                    return B(context, unitedSchemeEntity, callbackHandler);
                case 6:
                    return C(context, unitedSchemeEntity, callbackHandler);
                case 7:
                    return D(context, unitedSchemeEntity, callbackHandler);
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

    private boolean b(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        final e aHu = e.aHu();
        if (aHu == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aHu.id)) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(2001, "无rtcId");
                return false;
            }
            final RtcConfig m = com.baidu.o.a.a.m(context, optParamsAsJo);
            if (m == null) {
                c.e(TAG, "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            final String optString2 = optParamsAsJo.optString("slaveId");
            com.baidu.o.b.b s = s(unitedSchemeEntity);
            if (s == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.e(TAG, "model is null");
                return false;
            } else if (!s.isValid()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.e(TAG, "parse insert params, but invalid");
                return false;
            } else {
                this.cBj = new com.baidu.o.b.a(context, s).akO();
                if (this.cBj == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.e(TAG, "RTC component insert delayed fail");
                    return false;
                }
                aHu.aHG().b((Activity) context, PermissionProxy.SCOPE_ID_RECORD, new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.o.e.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            b.this.a(context, unitedSchemeEntity, callbackHandler, aHu, m, optString, optString2);
                            return;
                        }
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200201);
                        c.e(b.TAG, "RTC authorize failure");
                    }
                });
                return true;
            }
        }
    }

    private boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aHu = e.aHu();
        if (aHu == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aHu.id)) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(2001, "无rtcId");
                return false;
            } else if (!com.baidu.o.d.b.bfz().zs(optString)) {
                c.e(TAG, "rtcId is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                RtcConfig m = com.baidu.o.a.a.m(context, optParamsAsJo);
                if (m == null) {
                    c.e(TAG, "params is invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                boolean updateRTCConfig = com.baidu.o.d.b.bfz().updateRTCConfig(m);
                com.baidu.o.b.b s = s(unitedSchemeEntity);
                if (s == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    c.e(TAG, "model is null");
                    return false;
                } else if (!s.isValid()) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    c.e(TAG, "parse update params, but invalid");
                    return false;
                } else {
                    com.baidu.o.b.a aVar = (com.baidu.o.b.a) com.baidu.swan.apps.component.container.a.d(s);
                    if (aVar == null) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        c.e(TAG, "get component is null");
                        return false;
                    }
                    boolean isSuccess = aVar.a((com.baidu.o.b.a) s).isSuccess();
                    c.i(TAG, "update rtc view success = " + isSuccess);
                    if (updateRTCConfig && isSuccess) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    c.e(TAG, "RTC already start");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(2002, "rtc已经开始");
                    return false;
                }
            }
        }
    }

    private boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aHu = e.aHu();
        if (aHu == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aHu.id)) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(2001, "无rtcId");
                return false;
            } else if (!com.baidu.o.d.b.bfz().zs(optString)) {
                c.e(TAG, "rtcId is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                com.baidu.o.d.b.bfz().stop();
                com.baidu.o.d.b.bfz().zr(optString);
                com.baidu.o.b.b s = s(unitedSchemeEntity);
                if (s == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    c.e(TAG, "model is null");
                    return false;
                } else if (!s.isValid()) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    c.e(TAG, "parse remove params, but invalid");
                    return false;
                } else {
                    com.baidu.o.b.a aVar = (com.baidu.o.b.a) com.baidu.swan.apps.component.container.a.d(s);
                    if (aVar == null) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        c.e(TAG, "get component is null");
                        return false;
                    }
                    return aVar.akP().isSuccess();
                }
            }
        }
    }

    private boolean z(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aHu = e.aHu();
        if (aHu == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aHu.id)) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(2001, "无rtcId");
                return false;
            } else if (!com.baidu.o.d.b.bfz().zs(optString)) {
                c.e(TAG, "rtcId is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                com.baidu.o.d.b.bfz().bs(optParamsAsJo.optString("pushUrl"));
                com.baidu.o.b.b s = s(unitedSchemeEntity);
                if (s == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    c.e(TAG, "model is null");
                    return false;
                }
                com.baidu.o.b.a aVar = (com.baidu.o.b.a) com.baidu.swan.apps.component.container.a.d(s);
                if (aVar == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    c.e(TAG, "get component is null");
                    return false;
                }
                aVar.bfw();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }

    private boolean A(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aHu = e.aHu();
        if (aHu == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aHu.id)) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(2001, "无rtcId");
                return false;
            } else if (!com.baidu.o.d.b.bfz().zs(optString)) {
                c.e(TAG, "rtcId is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                com.baidu.o.d.b.bfz().stop();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }

    private boolean D(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aHu = e.aHu();
        if (aHu == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aHu.id)) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(2001, "无rtcId");
                return false;
            } else if (!com.baidu.o.d.b.bfz().zs(optString)) {
                c.e(TAG, "rtcId is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                com.baidu.o.d.b.bfz().switchCamera();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }

    private boolean B(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aHu = e.aHu();
        if (aHu == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aHu.id)) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(2001, "无rtcId");
                return false;
            } else if (!com.baidu.o.d.b.bfz().zs(optString)) {
                c.e(TAG, "rtcId is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                com.baidu.o.d.b.bfz().mute();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }

    private boolean C(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        e aHu = e.aHu();
        if (aHu == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aHu.id)) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(2001, "无rtcId");
                return false;
            } else if (!com.baidu.o.d.b.bfz().zs(optString)) {
                c.e(TAG, "rtcId is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                com.baidu.o.d.b.bfz().unMute();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }

    private com.baidu.o.b.b s(UnitedSchemeEntity unitedSchemeEntity) {
        com.baidu.o.b.b bVar = null;
        if (unitedSchemeEntity != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.e(TAG, "params is null");
            } else {
                bVar = new com.baidu.o.b.b();
                try {
                    bVar.parseFromJson(optParamsAsJo);
                } catch (JSONException e) {
                    e.printStackTrace();
                    c.e(TAG, "model parse exception:", e);
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar, final RtcConfig rtcConfig, final String str, final String str2) {
        if (com.baidu.o.d.b.bI(context) && com.baidu.o.d.b.bJ(context)) {
            if (DEBUG) {
                Log.d(TAG, "RTC --- had system permission");
            }
            a(context, unitedSchemeEntity, callbackHandler, rtcConfig, str, str2);
            return;
        }
        eVar.aHo().a(1, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, new c.a() { // from class: com.baidu.o.e.b.2
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200202);
                    com.baidu.swan.apps.console.c.e(b.TAG, "handleAuthorized end, failure");
                    return;
                }
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (iArr[i2] == -1) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    b.this.a(context, unitedSchemeEntity, callbackHandler, rtcConfig, str, str2);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200202);
                com.baidu.swan.apps.console.c.e(b.TAG, "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, RtcConfig rtcConfig, String str, String str2) {
        com.baidu.o.d.b.bfz().a(context, rtcConfig, str, str2);
        if (this.cBj == null) {
            com.baidu.swan.apps.component.e.a.bm(TAG, "doInsert with a null subscriber");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
        }
        this.cBj.onCompleted();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
