package com.baidu.swan.apps.media.c.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/recorder");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        if (DEBUG) {
            Log.d("AudioRecordAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str, final b bVar) {
        if (DEBUG) {
            Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
        }
        if (bVar == null) {
            c.e("record", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("AudioRecordAction", "record --- illegal swanApp");
            }
            return false;
        } else if (TextUtils.isEmpty(bVar.id)) {
            c.e("record", "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            if (DEBUG) {
                Log.d("AudioRecordAction", "record --- none swanApp id");
            }
            return false;
        } else {
            JSONObject fT = fT(unitedSchemeEntity.getParam("params"));
            if (TextUtils.equals(str, "/swan/recorder/start") && fT == null) {
                c.e("record", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            }
            final com.baidu.swan.apps.media.c.a a = com.baidu.swan.apps.media.c.a.a(fT, com.baidu.swan.apps.media.c.c.a.Mh().Mj());
            if (a == null) {
                c.e("record", "error params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                return false;
            }
            JSONObject Mg = a.Mg();
            if (Mg != null) {
                c.e("record", "error params");
                unitedSchemeEntity.result = Mg;
                return false;
            }
            final com.baidu.swan.apps.media.c.b a2 = com.baidu.swan.apps.media.c.b.a(callbackHandler, unitedSchemeEntity, a.aVU, com.baidu.swan.apps.media.c.c.a.Mh().Mk());
            if (a2 == null) {
                c.e("record", "error cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                return false;
            }
            final String ik = com.baidu.swan.apps.storage.b.ik(bVar.id);
            if (TextUtils.isEmpty(ik)) {
                c.e("record", "none tmp path");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.e("record", "handle action, but context is not Activity");
                return false;
            } else {
                bVar.Rf().a((Activity) context, "mapp_record", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.media.c.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: b */
                    public void B(Boolean bool) {
                        if (bool.booleanValue()) {
                            a.this.a(context, unitedSchemeEntity, callbackHandler, str, a, a2, ik, bVar.id);
                            return;
                        }
                        c.e("record", "record authorize failure");
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
                        if (a2 != null) {
                            a2.r(2004, "error user deny");
                        }
                    }
                });
                if (DEBUG) {
                    Log.d("AudioRecordAction", "subAction is : " + str);
                }
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str, final com.baidu.swan.apps.media.c.a aVar, final com.baidu.swan.apps.media.c.b bVar, final String str2, final String str3) {
        if (com.baidu.swan.apps.media.c.c.a.Mh().aP(context)) {
            if (DEBUG) {
                Log.d("AudioRecordAction", "record --- had system permission");
            }
            a(callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3);
            return;
        }
        e.LE().a(2, new String[]{"android.permission.RECORD_AUDIO"}, new a.InterfaceC0147a() { // from class: com.baidu.swan.apps.media.c.a.a.2
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0147a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i != 2 || iArr.length <= 0) {
                    if (a.DEBUG) {
                        Log.d("AudioRecordAction", "record --- wrong requestCode");
                    }
                    c.e("record", "none permission");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (bVar != null) {
                        bVar.r(2002, "error execute");
                        return;
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
                        Log.d("AudioRecordAction", "record --- permission is not granted");
                    }
                    c.e("record", "none permission");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (bVar != null) {
                        bVar.r(2002, "error execute");
                        return;
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d("AudioRecordAction", "record --- permission is granted ~");
                }
                a.this.a(callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.b bVar, String str2, String str3) {
        char c = 65535;
        switch (str.hashCode()) {
            case 302900500:
                if (str.equals("/swan/recorder/pause")) {
                    c = 1;
                    break;
                }
                break;
            case 306217856:
                if (str.equals("/swan/recorder/start")) {
                    c = 0;
                    break;
                }
                break;
            case 425520420:
                if (str.equals("/swan/recorder/stop")) {
                    c = 3;
                    break;
                }
                break;
            case 860875983:
                if (str.equals("/swan/recorder/resume")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                a(context, aVar, bVar, str2, str3);
                break;
            case 1:
                c.i("record", "pause");
                pauseRecord();
                break;
            case 2:
                c.i("record", "resume");
                resumeRecord();
                break;
            case 3:
                c.i("record", "stop");
                stopRecord();
                break;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void a(Context context, com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.b bVar, String str, String str2) {
        c.i("record", "init");
        com.baidu.swan.apps.media.c.c.a.Mh().a(str, aVar, context, bVar, str2);
        c.i("record", "start");
        com.baidu.swan.apps.media.c.c.a.Mh().aY(true);
    }

    private void pauseRecord() {
        com.baidu.swan.apps.media.c.c.a.Mh().pauseRecord();
    }

    private void resumeRecord() {
        com.baidu.swan.apps.media.c.c.a.Mh().resumeRecord();
    }

    private void stopRecord() {
        com.baidu.swan.apps.media.c.c.a.Mh().stopRecord();
        com.baidu.swan.apps.media.c.c.a.release();
    }

    private JSONObject fT(String str) {
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
}
