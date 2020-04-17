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
/* loaded from: classes11.dex */
public class d extends a {
    public d(j jVar) {
        super(jVar, "/swanAPI/camera/startRecord");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final com.baidu.swan.apps.camera.d.b bVar = (com.baidu.swan.apps.camera.d.b) c(unitedSchemeEntity);
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "parse json model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.c.a aVar = (com.baidu.swan.apps.component.components.c.a) com.baidu.swan.apps.component.container.a.d(bVar);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera component is null");
            return false;
        }
        final CameraPreview view = aVar.getView();
        if (view == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera view is null");
            return false;
        }
        final String nk = com.baidu.swan.apps.storage.b.nk(eVar.id);
        if (TextUtils.isEmpty(nk)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera start record cache path is empty");
            return false;
        }
        eVar.akX().b(context, PermissionProxy.SCOPE_ID_RECORD, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.camera.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(h<b.d> hVar) {
                int errorCode;
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    d.this.a(context, unitedSchemeEntity, callbackHandler, eVar, bVar, view, nk);
                } else if (hVar == null || hVar.amF() == null) {
                    com.baidu.swan.apps.console.c.e("SwanAppAction", "authorize recorder failed : result is invalid");
                } else {
                    String str = "authorize recorder failed : " + com.baidu.swan.apps.setting.oauth.c.gv(errorCode);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(hVar.getErrorCode(), str));
                    com.baidu.swan.apps.console.c.w("SwanAppAction", str);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar, final com.baidu.swan.apps.camera.d.b bVar, final CameraPreview cameraPreview, final String str) {
        eVar.akX().b(context, PermissionProxy.SCOPE_ID_CAMERA, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.camera.a.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    d.this.b(context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str);
                } else if (hVar != null && hVar.amF() != null) {
                    d.this.a(hVar.getErrorCode(), unitedSchemeEntity, callbackHandler);
                } else {
                    com.baidu.swan.apps.console.c.e("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar, final com.baidu.swan.apps.camera.d.b bVar, final CameraPreview cameraPreview, final String str) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handleAuthorized start");
        if (com.baidu.swan.apps.camera.a.RW().bu(context) && com.baidu.swan.apps.camera.a.RW().bv(context)) {
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "has authorize");
            a(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            return;
        }
        com.baidu.swan.apps.af.a.a(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.camera.a.d.3
            @Override // com.baidu.swan.apps.af.b
            public void gQ(String str2) {
                d.this.a(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            }

            @Override // com.baidu.swan.apps.af.b
            public void M(int i, String str2) {
                d.this.a(10005, unitedSchemeEntity, callbackHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str = "authorize camera failed : " + com.baidu.swan.apps.setting.oauth.c.gv(i);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i, str));
        com.baidu.swan.apps.console.c.w("SwanAppAction", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar, final CameraPreview cameraPreview, com.baidu.swan.apps.camera.d.b bVar, String str) {
        boolean z;
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "start record start");
        boolean z2 = false;
        final HashMap<String, String> hashMap = new HashMap<>();
        try {
            z = cameraPreview.hz(str);
        } catch (Exception e) {
            e = e;
        }
        try {
            hashMap.put("tempVideoPath", com.baidu.swan.apps.storage.b.bA(cameraPreview.getVideoPath(), eVar.id));
            hashMap.put("tempThumbPath", com.baidu.swan.apps.storage.b.bA(cameraPreview.getThumbPath(), eVar.id));
            com.baidu.swan.apps.camera.a.RW().a(31000, new com.baidu.swan.apps.camera.b.b() { // from class: com.baidu.swan.apps.camera.a.d.4
                @Override // com.baidu.swan.apps.camera.b.b
                public void RZ() {
                    cameraPreview.Sb();
                    cameraPreview.Se();
                    d.this.a(unitedSchemeEntity, callbackHandler, hashMap);
                    com.baidu.swan.apps.console.c.e("SwanAppCamera", "start record timeout");
                }

                @Override // com.baidu.swan.apps.camera.b.b
                public void cancel() {
                    cameraPreview.Sb();
                    cameraPreview.Se();
                    d.this.a(unitedSchemeEntity, callbackHandler, hashMap);
                    com.baidu.swan.apps.console.c.e("SwanAppCamera", "start record cancel");
                }
            });
        } catch (Exception e2) {
            e = e2;
            z2 = z;
            com.baidu.swan.apps.camera.a.RW().g(bVar.bGJ, bVar.bEy, false);
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "start recording api occur exception");
            z = z2;
            if (!z) {
            }
        }
        if (!z) {
            a(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            a(unitedSchemeEntity, callbackHandler, false);
        }
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
    protected com.baidu.swan.apps.component.b.b c(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.b(b(unitedSchemeEntity));
    }
}
