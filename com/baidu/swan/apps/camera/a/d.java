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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {
    public d(j jVar) {
        super(jVar, "/swan/camera/startRecord");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        final com.baidu.swan.apps.camera.d.b bVar2 = (com.baidu.swan.apps.camera.d.b) b(unitedSchemeEntity);
        if (bVar2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "parse json model is null");
            return false;
        }
        final CameraPreview dr = com.baidu.swan.apps.camera.a.wm().dr(bVar2.aBG);
        if (dr == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera view is null");
            return false;
        }
        final String gY = com.baidu.swan.apps.storage.b.gY(bVar.id);
        if (TextUtils.isEmpty(gY)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "get camera start record cache path is empty");
            return false;
        }
        bVar.IZ().a((Activity) context, "mapp_record", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.camera.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: b */
            public void D(Boolean bool) {
                if (bool.booleanValue()) {
                    d.this.a(context, unitedSchemeEntity, callbackHandler, bVar, bVar2, dr, gY);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200201);
                com.baidu.swan.apps.console.c.e("SwanAppCamera", "camera authorize failure");
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar, final com.baidu.swan.apps.camera.d.b bVar2, final CameraPreview cameraPreview, final String str) {
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "handleAuthorized start");
        if (com.baidu.swan.apps.camera.a.wm().bt(context) && com.baidu.swan.apps.camera.a.wm().bu(context)) {
            com.baidu.swan.apps.console.c.e("SwanAppCamera", "has authorize");
            a(unitedSchemeEntity, callbackHandler, bVar, cameraPreview, bVar2, str);
            return;
        }
        com.baidu.swan.apps.w.e.Ea().a(1, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, new a.InterfaceC0108a() { // from class: com.baidu.swan.apps.camera.a.d.2
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0108a
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
                    d.this.a(unitedSchemeEntity, callbackHandler, bVar, cameraPreview, bVar2, str);
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 200202);
                com.baidu.swan.apps.console.c.e("SwanAppCamera", "user want not authorize");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, final CameraPreview cameraPreview, com.baidu.swan.apps.camera.d.b bVar2, String str) {
        boolean z;
        com.baidu.swan.apps.console.c.i("SwanAppCamera", "start record start");
        boolean z2 = false;
        final HashMap<String, String> hashMap = new HashMap<>();
        try {
            z = cameraPreview.dv(str);
        } catch (Exception e) {
            e = e;
        }
        try {
            hashMap.put("tempVideoPath", com.baidu.swan.apps.storage.b.aD(cameraPreview.getVideoPath(), bVar.id));
            hashMap.put("tempThumbPath", com.baidu.swan.apps.storage.b.aD(cameraPreview.getThumbPath(), bVar.id));
            com.baidu.swan.apps.camera.a.wm().a(31000, new com.baidu.swan.apps.camera.b.b() { // from class: com.baidu.swan.apps.camera.a.d.3
                @Override // com.baidu.swan.apps.camera.b.b
                public void wp() {
                    cameraPreview.wr();
                    cameraPreview.wu();
                    d.this.a(unitedSchemeEntity, callbackHandler, hashMap);
                    com.baidu.swan.apps.console.c.e("SwanAppCamera", "start record timeout");
                }

                @Override // com.baidu.swan.apps.camera.b.b
                public void cancel() {
                    cameraPreview.wu();
                    d.this.a(unitedSchemeEntity, callbackHandler, hashMap);
                    com.baidu.swan.apps.console.c.e("SwanAppCamera", "start record cancel");
                }
            });
        } catch (Exception e2) {
            e = e2;
            z2 = z;
            com.baidu.swan.apps.camera.a.wm().c(bVar2.aBG, bVar2.akL, false);
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
    protected com.baidu.swan.apps.model.a.a.a b(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.camera.d.b(a(unitedSchemeEntity));
    }
}
