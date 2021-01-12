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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends a {
    public d(j jVar) {
        super(jVar, "/swanAPI/camera/startRecord");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final com.baidu.swan.apps.camera.d.b bVar = (com.baidu.swan.apps.camera.d.b) b(unitedSchemeEntity);
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.c.a aVar = (com.baidu.swan.apps.component.components.c.a) com.baidu.swan.apps.component.container.a.d(bVar);
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
        final String sJ = com.baidu.swan.apps.storage.b.sJ(eVar.id);
        if (TextUtils.isEmpty(sJ)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "get camera start record cache path is empty");
            return false;
        }
        eVar.aID().b(context, PermissionProxy.SCOPE_ID_RECORD, new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.camera.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<b.d> hVar) {
                int errorCode;
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    d.this.a(context, unitedSchemeEntity, callbackHandler, eVar, bVar, view, sJ);
                } else if (hVar == null || hVar.aKA() == null) {
                    com.baidu.swan.apps.console.c.e("SwanAppAction", "authorize recorder failed : result is invalid");
                } else {
                    String str = "authorize recorder failed : " + com.baidu.swan.apps.setting.oauth.c.gk(errorCode);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(hVar.getErrorCode(), str));
                    com.baidu.swan.apps.console.c.w("SwanAppAction", str);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar, final com.baidu.swan.apps.camera.d.b bVar, final CameraPreview cameraPreview, final String str) {
        eVar.aID().b(context, PermissionProxy.SCOPE_ID_CAMERA, new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.camera.a.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    d.this.b(context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str);
                } else if (hVar != null && hVar.aKA() != null) {
                    d.this.a(hVar.getErrorCode(), unitedSchemeEntity, callbackHandler);
                } else {
                    com.baidu.swan.apps.console.c.e("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar, final com.baidu.swan.apps.camera.d.b bVar, final CameraPreview cameraPreview, final String str) {
        com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "handleAuthorized start");
        if (com.baidu.swan.apps.camera.a.akg().cu(context) && com.baidu.swan.apps.camera.a.akg().cv(context)) {
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "has authorize");
            a(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            return;
        }
        com.baidu.swan.apps.ab.a.a(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.camera.a.d.3
            @Override // com.baidu.swan.apps.ab.b
            public void jC(String str2) {
                d.this.a(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ai(int i, String str2) {
                d.this.a(10005, unitedSchemeEntity, callbackHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str = "authorize camera failed : " + com.baidu.swan.apps.setting.oauth.c.gk(i);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i, str));
        com.baidu.swan.apps.console.c.w("SwanAppAction", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar, final CameraPreview cameraPreview, com.baidu.swan.apps.camera.d.b bVar, String str) {
        boolean z;
        boolean lo;
        com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "start record start");
        final HashMap hashMap = new HashMap();
        try {
            lo = cameraPreview.lo(str);
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            hashMap.put("tempVideoPath", com.baidu.swan.apps.storage.b.cG(cameraPreview.getVideoPath(), eVar.id));
            hashMap.put("tempThumbPath", com.baidu.swan.apps.storage.b.cG(cameraPreview.getThumbPath(), eVar.id));
            com.baidu.swan.apps.camera.a.akg().a(31000, new com.baidu.swan.apps.camera.b.b() { // from class: com.baidu.swan.apps.camera.a.d.4
                @Override // com.baidu.swan.apps.camera.b.b
                public void akj() {
                    cameraPreview.stopRecording();
                    cameraPreview.akn();
                    d.this.a(unitedSchemeEntity, callbackHandler, hashMap);
                    com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "start record timeout");
                }

                @Override // com.baidu.swan.apps.camera.b.b
                public void cancel() {
                    cameraPreview.stopRecording();
                    cameraPreview.akn();
                    d.this.a(unitedSchemeEntity, callbackHandler, hashMap);
                    com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "start record cancel");
                }
            });
            z = lo;
        } catch (Exception e2) {
            e = e2;
            z = lo;
            com.baidu.swan.apps.camera.a.akg().m(bVar.cJd, bVar.cameraId, false);
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "start recording api occur exception");
            a(unitedSchemeEntity, callbackHandler, z);
        }
        a(unitedSchemeEntity, callbackHandler, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap) {
        HashMap<String, String> params;
        String optString;
        if (unitedSchemeEntity != null && callbackHandler != null && hashMap != null && (params = unitedSchemeEntity.getParams()) != null && !params.isEmpty()) {
            String str = params.get("params");
            if (str != null) {
                try {
                    optString = new JSONObject(str).optString("timeoutCallback");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(optString)) {
                    a(unitedSchemeEntity, callbackHandler, hashMap, optString);
                    return;
                }
                return;
            }
            optString = null;
            if (TextUtils.isEmpty(optString)) {
            }
        }
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.component.b.b b(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.b(a(unitedSchemeEntity));
    }
}
