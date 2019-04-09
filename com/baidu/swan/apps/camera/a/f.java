package com.baidu.swan.apps.camera.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a {
    public f(j jVar) {
        super(jVar, "/swan/camera/takePhoto");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        final com.baidu.swan.apps.camera.d.c cVar = (com.baidu.swan.apps.camera.d.c) b(unitedSchemeEntity);
        if (cVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "parse json model is null");
            return false;
        }
        final CameraPreview dr = com.baidu.swan.apps.camera.a.wm().dr(cVar.aBH);
        if (dr == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera view is null");
            return false;
        }
        final String gY = com.baidu.swan.apps.storage.b.gY(bVar.id);
        if (TextUtils.isEmpty(gY)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera take photo cache path is empty");
            return false;
        }
        bVar.IZ().a((Activity) context, "mapp_camera", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.camera.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: b */
            public void D(Boolean bool) {
                if (bool.booleanValue()) {
                    f.this.a(context, unitedSchemeEntity, callbackHandler, bVar, cVar, dr, gY);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_ACTION);
                com.baidu.swan.apps.console.c.e("SwanAppCamera", "camera authorize failure");
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar, final com.baidu.swan.apps.camera.d.c cVar, final CameraPreview cameraPreview, final String str) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handleAuthorized start");
        if (com.baidu.swan.apps.camera.a.wm().bt(context)) {
            a(unitedSchemeEntity, callbackHandler, bVar, cameraPreview, cVar, str);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "has authorize");
            return;
        }
        com.baidu.swan.apps.w.e.Ea().a(1, new String[]{"android.permission.CAMERA"}, new a.InterfaceC0108a() { // from class: com.baidu.swan.apps.camera.a.f.2
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0108a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION);
                    com.baidu.swan.apps.console.c.e("SwanAppCamera", "handleAuthorized end, failure");
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
                    f.this.a(unitedSchemeEntity, callbackHandler, bVar, cameraPreview, cVar, str);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION);
                com.baidu.swan.apps.console.c.e("SwanAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar, CameraPreview cameraPreview, final com.baidu.swan.apps.camera.d.c cVar, String str) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "take photo start");
        cameraPreview.setQuality(cVar.akN);
        final String dw = cameraPreview.dw(str);
        try {
            cameraPreview.a(dw, new com.baidu.swan.apps.camera.b.a() { // from class: com.baidu.swan.apps.camera.a.f.3
                @Override // com.baidu.swan.apps.camera.b.a
                public void onSuccess(String str2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tempImagePath", com.baidu.swan.apps.storage.b.aD(dw, bVar.id));
                    } catch (JSONException e) {
                        com.baidu.swan.apps.console.c.e("SwanAppCamera", "take picture onSuccess but json object occur exception");
                        com.baidu.swan.apps.camera.a.wm().c(cVar.aBH, cVar.akM, false);
                        if (f.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                }

                @Override // com.baidu.swan.apps.camera.b.a
                public void onFailure() {
                    f.this.a(unitedSchemeEntity, callbackHandler, false);
                    com.baidu.swan.apps.console.c.e("SwanAppCamera", "take picture onFailure");
                }
            });
        } catch (Exception e) {
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "take picture api occur exception");
            com.baidu.swan.apps.camera.a.wm().c(cVar.aBH, cVar.akM, false);
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "take photo end");
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.model.a.a.a b(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.c(a(unitedSchemeEntity));
    }
}
