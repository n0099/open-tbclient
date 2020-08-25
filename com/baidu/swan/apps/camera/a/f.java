package com.baidu.swan.apps.camera.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends a {
    public f(j jVar) {
        super(jVar, "/swanAPI/camera/takePhoto");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final com.baidu.swan.apps.camera.d.c cVar = (com.baidu.swan.apps.camera.d.c) c(unitedSchemeEntity);
        if (cVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.c.a aVar = (com.baidu.swan.apps.component.components.c.a) com.baidu.swan.apps.component.container.a.d(cVar);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "get camera component is null");
            return false;
        }
        final CameraPreview view = aVar.getView();
        if (view == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "get camera view is null");
            return false;
        }
        final String rH = com.baidu.swan.apps.storage.b.rH(eVar.id);
        if (TextUtils.isEmpty(rH)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "get camera take photo cache path is empty");
            return false;
        }
        eVar.azU().b(context, PermissionProxy.SCOPE_ID_CAMERA, new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.camera.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    f.this.a(context, unitedSchemeEntity, callbackHandler, eVar, cVar, view, rH);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "camera authorize failure");
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar, final com.baidu.swan.apps.camera.d.c cVar, final CameraPreview cameraPreview, final String str) {
        com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "handleAuthorized start");
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.camera.a.f.2
            @Override // com.baidu.swan.apps.ab.b
            public void iF(String str2) {
                f.this.a(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str);
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", str2 + "");
            }

            @Override // com.baidu.swan.apps.ab.b
            public void N(int i, String str2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 10005);
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", str2 + "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar, CameraPreview cameraPreview, final com.baidu.swan.apps.camera.d.c cVar, String str) {
        com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "take photo start");
        cameraPreview.setQuality(cVar.bYJ);
        final String ks = cameraPreview.ks(str);
        try {
            cameraPreview.a(ks, new com.baidu.swan.apps.camera.b.a() { // from class: com.baidu.swan.apps.camera.a.f.3
                @Override // com.baidu.swan.apps.camera.b.a
                public void onSuccess(String str2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tempImagePath", com.baidu.swan.apps.storage.b.cq(ks, eVar.id));
                    } catch (JSONException e) {
                        com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                        com.baidu.swan.apps.camera.a.acA().i(cVar.caU, cVar.bYI, false);
                        if (f.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                }

                @Override // com.baidu.swan.apps.camera.b.a
                public void onFailure() {
                    f.this.a(unitedSchemeEntity, callbackHandler, false);
                    com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "take picture onFailure");
                }
            });
        } catch (Exception e) {
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "take picture api occur exception");
            com.baidu.swan.apps.camera.a.acA().i(cVar.caU, cVar.bYI, false);
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "take photo end");
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.component.b.b c(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.c(b(unitedSchemeEntity));
    }
}
