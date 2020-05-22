package com.baidu.swan.apps.camera.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes11.dex */
public class g extends a {
    public g(j jVar) {
        super(jVar, "/swanAPI/camera/update");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        eVar.aoR().b(context, PermissionProxy.SCOPE_ID_CAMERA, new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.camera.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<b.d> hVar) {
                com.baidu.swan.apps.camera.d.a aVar = (com.baidu.swan.apps.camera.d.a) g.this.c(unitedSchemeEntity);
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    g.this.a(context, unitedSchemeEntity, callbackHandler, aVar);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "camera authorize failure");
            }
        });
        return true;
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.component.b.b c(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.a(b(unitedSchemeEntity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.camera.d.a aVar) {
        com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "handleAuthorized start");
        com.baidu.swan.apps.ad.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 100, context, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.camera.a.g.2
            @Override // com.baidu.swan.apps.ad.b
            public void gY(String str) {
                g.this.a(unitedSchemeEntity, callbackHandler, g.this.a(aVar));
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", str + "");
            }

            @Override // com.baidu.swan.apps.ad.b
            public void M(int i, String str) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 10005);
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", str + "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.swan.apps.camera.d.a aVar) {
        boolean z = false;
        com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "handle update camera instruction start");
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "Model is null");
        } else {
            String str = aVar.bNu;
            com.baidu.swan.apps.model.a.a.a aVar2 = aVar.bPJ;
            if (TextUtils.isEmpty(str) || aVar2 == null || !aVar2.isValid()) {
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "cameraId = " + str + " ; position = " + (aVar2 == null));
            } else {
                com.baidu.swan.apps.component.components.c.a aVar3 = (com.baidu.swan.apps.component.components.c.a) com.baidu.swan.apps.component.container.a.d(aVar);
                if (aVar3 == null) {
                    com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "update camera with a null component");
                } else {
                    com.baidu.swan.apps.component.b.c a = aVar3.a((com.baidu.swan.apps.component.components.c.a) aVar);
                    z = a.isSuccess();
                    if (!z) {
                        com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "update camera fail: " + a.msg);
                    }
                }
            }
        }
        return z;
    }
}
