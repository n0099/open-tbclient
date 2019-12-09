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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e extends a {
    public e(j jVar) {
        super(jVar, "/swan/camera/stopRecord");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        final com.baidu.swan.apps.camera.d.b bVar2 = (com.baidu.swan.apps.camera.d.b) b(unitedSchemeEntity);
        if (bVar2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "parse json model is null");
            return false;
        }
        final CameraPreview dT = com.baidu.swan.apps.camera.a.CE().dT(bVar2.aXp);
        if (dT == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera view is null");
            return false;
        } else if (TextUtils.isEmpty(com.baidu.swan.apps.storage.b.ik(bVar.id))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera stop record cache path is empty");
            return false;
        } else {
            bVar.Rf().a((Activity) context, "mapp_record", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.camera.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void B(Boolean bool) {
                    if (bool.booleanValue()) {
                        e.this.a(context, unitedSchemeEntity, callbackHandler, bVar, bVar2, dT);
                        return;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200201);
                    com.baidu.swan.apps.console.c.e("SwanAppCamera", "camera authorize failure");
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar, final com.baidu.swan.apps.camera.d.b bVar2, final CameraPreview cameraPreview) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handleAuthorized start");
        if (com.baidu.swan.apps.camera.a.CE().aO(context) && com.baidu.swan.apps.camera.a.CE().aP(context)) {
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "has authorize");
            a(unitedSchemeEntity, callbackHandler, bVar, cameraPreview, bVar2);
            return;
        }
        com.baidu.swan.apps.w.e.LE().a(1, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, new a.InterfaceC0147a() { // from class: com.baidu.swan.apps.camera.a.e.2
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0147a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = false;
                if (i != 1) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200202);
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
                    e.this.a(unitedSchemeEntity, callbackHandler, bVar, cameraPreview, bVar2);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200202);
                com.baidu.swan.apps.console.c.e("SwanAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, CameraPreview cameraPreview, com.baidu.swan.apps.camera.d.b bVar2) {
        Exception e;
        boolean z;
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "stop record start");
        try {
            z = cameraPreview.CL();
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            com.baidu.swan.apps.camera.a.CE().CF();
        } catch (Exception e3) {
            e = e3;
            cameraPreview.CO();
            com.baidu.swan.apps.camera.a.CE().f(bVar2.aXp, bVar2.aFc, false);
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "stop recording api occur exception");
            String videoPath = cameraPreview.getVideoPath();
            String thumbPath = cameraPreview.getThumbPath();
            if (!z) {
            }
            a(unitedSchemeEntity, callbackHandler, false);
            cameraPreview.CO();
            com.baidu.swan.apps.console.c.i("SwanAppCamera", "stop record end");
        }
        String videoPath2 = cameraPreview.getVideoPath();
        String thumbPath2 = cameraPreview.getThumbPath();
        if (!z && dV(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tempVideoPath", com.baidu.swan.apps.storage.b.aN(videoPath2, bVar.id));
            hashMap.put("tempThumbPath", com.baidu.swan.apps.storage.b.aN(thumbPath2, bVar.id));
            a(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            a(unitedSchemeEntity, callbackHandler, false);
        }
        cameraPreview.CO();
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "stop record end");
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.model.a.a.a b(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.b(a(unitedSchemeEntity));
    }

    private boolean dV(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.exists() && file.length() > 0;
        }
        return false;
    }
}
