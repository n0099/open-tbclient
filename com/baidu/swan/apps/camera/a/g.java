package com.baidu.swan.apps.camera.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
/* loaded from: classes2.dex */
public class g extends a {
    public g(j jVar) {
        super(jVar, "/swan/camera/update");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "handle action, but context is not Activity");
            return false;
        }
        bVar.Jb().a((Activity) context, "mapp_camera", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.camera.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: b */
            public void D(Boolean bool) {
                com.baidu.swan.apps.camera.d.a aVar = (com.baidu.swan.apps.camera.d.a) g.this.b(unitedSchemeEntity);
                if (bool.booleanValue()) {
                    g.this.a(context, unitedSchemeEntity, callbackHandler, aVar);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200101);
                com.baidu.swan.apps.console.c.e("SwanAppCamera", "camera authorize failure");
            }
        });
        return true;
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.model.a.a.a b(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.a(a(unitedSchemeEntity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.camera.d.a aVar) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handleAuthorized start");
        if (com.baidu.swan.apps.camera.a.wn().bt(context)) {
            a(unitedSchemeEntity, callbackHandler, a(aVar));
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "has authorize");
            return;
        }
        com.baidu.swan.apps.w.e.Ec().a(1, new String[]{"android.permission.CAMERA"}, new a.InterfaceC0078a() { // from class: com.baidu.swan.apps.camera.a.g.2
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0078a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200102);
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
                    g.this.a(unitedSchemeEntity, callbackHandler, g.this.a(aVar));
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200102);
                com.baidu.swan.apps.console.c.e("SwanAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.swan.apps.camera.d.a aVar) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handle update camera instruction start");
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "Model is null");
            return false;
        }
        String str = aVar.akG;
        com.baidu.swan.apps.model.a.a.b bVar = aVar.aBE;
        if (TextUtils.isEmpty(str) || bVar == null || !bVar.isValid()) {
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "cameraId = " + str + " ; position = " + (bVar == null));
            return false;
        }
        CameraPreview dp = com.baidu.swan.apps.camera.a.wn().dp(aVar.aBC);
        if (dp != null) {
            dp.b(aVar);
        }
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handle update camera instruction end");
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a == null || !a.a(aVar)) {
            r0 = false;
        }
        return r0;
    }
}
