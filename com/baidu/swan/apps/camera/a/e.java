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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class e extends a {
    public e(j jVar) {
        super(jVar, "/swanAPI/camera/stopRecord");
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
        } else if (TextUtils.isEmpty(com.baidu.swan.apps.storage.b.lG(eVar.id))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera stop record cache path is empty");
            return false;
        } else {
            eVar.aac().b(context, PermissionProxy.SCOPE_ID_RECORD, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.camera.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        e.this.a(context, unitedSchemeEntity, callbackHandler, eVar, bVar, view);
                        return;
                    }
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                    com.baidu.swan.apps.console.c.e("SwanAppCamera", "camera authorize failure");
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar, final com.baidu.swan.apps.camera.d.b bVar, final CameraPreview cameraPreview) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handleAuthorized start");
        if (com.baidu.swan.apps.camera.a.Ht().bD(context) && com.baidu.swan.apps.camera.a.Ht().bE(context)) {
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "has authorize");
            a(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar);
            return;
        }
        com.baidu.swan.apps.af.a.a(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.camera.a.e.2
            @Override // com.baidu.swan.apps.af.b
            public void fl(String str) {
                e.this.a(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar);
            }

            @Override // com.baidu.swan.apps.af.b
            public void q(int i, String str) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 10005);
                com.baidu.swan.apps.console.c.e("SwanAppCamera", str + "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar, CameraPreview cameraPreview, com.baidu.swan.apps.camera.d.b bVar) {
        Exception e;
        boolean z;
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "stop record start");
        try {
            z = cameraPreview.Hx();
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            com.baidu.swan.apps.camera.a.Ht().stopTimer();
        } catch (Exception e3) {
            e = e3;
            cameraPreview.HA();
            com.baidu.swan.apps.camera.a.Ht().g(bVar.bdi, bVar.baS, false);
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "stop recording api occur exception");
            String videoPath = cameraPreview.getVideoPath();
            String thumbPath = cameraPreview.getThumbPath();
            if (!z) {
            }
            a(unitedSchemeEntity, callbackHandler, false);
            cameraPreview.HA();
            com.baidu.swan.apps.console.c.i("SwanAppCamera", "stop record end");
        }
        String videoPath2 = cameraPreview.getVideoPath();
        String thumbPath2 = cameraPreview.getThumbPath();
        if (!z && fS(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tempVideoPath", com.baidu.swan.apps.storage.b.bh(videoPath2, eVar.id));
            hashMap.put("tempThumbPath", com.baidu.swan.apps.storage.b.bh(thumbPath2, eVar.id));
            a(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            a(unitedSchemeEntity, callbackHandler, false);
        }
        cameraPreview.HA();
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "stop record end");
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.component.b.b c(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.b(b(unitedSchemeEntity));
    }

    private boolean fS(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.exists() && file.length() > 0;
        }
        return false;
    }
}
