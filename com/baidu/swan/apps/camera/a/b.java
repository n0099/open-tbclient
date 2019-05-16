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
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
/* loaded from: classes2.dex */
public class b extends a {
    private SwanAppNAViewContainer akG;

    public b(j jVar) {
        super(jVar, "/swan/camera/insert");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "handle action, but context is not Activity");
            return false;
        }
        final com.baidu.swan.apps.camera.d.a aVar = (com.baidu.swan.apps.camera.d.a) b(unitedSchemeEntity);
        this.akG = new SwanAppNAViewContainer(context);
        this.akG.b(aVar);
        this.akG.Ps();
        bVar.Lu().a((Activity) context, "mapp_camera", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.camera.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void D(Boolean bool) {
                if (bool.booleanValue()) {
                    b.this.a(context, unitedSchemeEntity, callbackHandler, aVar);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_ACTION);
                b.this.akG.Pr();
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
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.camera.d.a aVar) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handleAuthorized start");
        if (com.baidu.swan.apps.camera.a.xe().aM(context)) {
            a(unitedSchemeEntity, callbackHandler, a(context, aVar));
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "has authorize");
            return;
        }
        com.baidu.swan.apps.w.e.FV().a(1, new String[]{"android.permission.CAMERA"}, new a.InterfaceC0109a() { // from class: com.baidu.swan.apps.camera.a.b.2
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0109a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION);
                    b.this.akG.Pr();
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
                    b.this.a(unitedSchemeEntity, callbackHandler, b.this.a(context, aVar));
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION);
                b.this.akG.Pr();
                com.baidu.swan.apps.console.c.e("SwanAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, com.baidu.swan.apps.camera.d.a aVar) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handle insert camera instruction start");
        if (context == null || aVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "Context is null ? = " + (context == null) + " ; model is null ? = " + (aVar == null));
            return false;
        }
        String str = aVar.akY;
        com.baidu.swan.apps.model.a.a.b bVar = aVar.aDo;
        if (TextUtils.isEmpty(str) || bVar == null || !bVar.isValid()) {
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "cameraId = " + str + " ; position = " + (bVar == null));
            return false;
        }
        CameraPreview cameraPreview = new CameraPreview(context, aVar);
        this.akG.addView(cameraPreview, 0);
        com.baidu.swan.apps.camera.a.xe().a(cameraPreview);
        com.baidu.swan.apps.console.c.e("SwanAppCamera", "handle insert camera instruction end");
        return true;
    }
}
