package com.baidu.swan.apps.camera.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.webkit.sdk.PermissionRequest;
import rx.j;
/* loaded from: classes9.dex */
public class b extends a {
    @Nullable
    private j cIQ;

    public b(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/camera/insert");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        final com.baidu.swan.apps.camera.d.a aVar = (com.baidu.swan.apps.camera.d.a) b(unitedSchemeEntity);
        this.cIQ = new com.baidu.swan.apps.component.components.c.a(context, aVar).alc();
        if (this.cIQ == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "camera component insert delayed fail");
            return false;
        }
        eVar.aIW().b(context, PermissionProxy.SCOPE_ID_CAMERA, new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.camera.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    b.this.a(context, unitedSchemeEntity, callbackHandler, aVar);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                if (b.this.cIQ != null) {
                    b.this.cIQ.onError(new Throwable());
                } else {
                    com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
                }
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "camera authorize failure");
            }
        });
        return true;
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.component.b.b b(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.a(a(unitedSchemeEntity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.camera.d.a aVar) {
        com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "handleAuthorized start");
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.camera.a.b.2
            @Override // com.baidu.swan.apps.ab.b
            public void jU(String str) {
                b.this.a(unitedSchemeEntity, callbackHandler, b.this.a(context, aVar));
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", str + "");
            }

            @Override // com.baidu.swan.apps.ab.b
            public void am(int i, String str) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 10005);
                if (b.this.cIQ != null) {
                    b.this.cIQ.onError(new Throwable());
                } else {
                    com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
                }
                com.baidu.swan.apps.console.c.e("SwanAppCameraManager", str + "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, com.baidu.swan.apps.camera.d.a aVar) {
        com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "handle insert camera instruction start");
        if (context == null || aVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "Context is null ? = " + (context == null) + " ; model is null ? = " + (aVar == null));
            return false;
        }
        String str = aVar.cameraId;
        com.baidu.swan.apps.model.a.a.a aVar2 = aVar.cLu;
        if (TextUtils.isEmpty(str) || aVar2 == null || !aVar2.isValid()) {
            com.baidu.swan.apps.console.c.e("SwanAppCameraManager", "cameraId = " + str + " ; position = " + (aVar2 == null));
            return false;
        } else if (this.cIQ == null) {
            com.baidu.swan.apps.component.e.a.bk("SwanAppCameraManager", "executionInstruction with a null subscriber");
            return false;
        } else {
            this.cIQ.onCompleted();
            com.baidu.swan.apps.console.c.i("SwanAppCameraManager", "handle insert camera instruction end");
            return true;
        }
    }
}
