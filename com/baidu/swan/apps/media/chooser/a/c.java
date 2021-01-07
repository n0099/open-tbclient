package com.baidu.swan.apps.media.chooser.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.chooser.b.f;
import com.baidu.swan.apps.media.chooser.listener.d;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends aa {
    public c(j jVar) {
        super(jVar, "/swanAPI/chooseVideo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.anl()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        f bp = f.bp(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (bp.sourceType == 2) {
            a(context, unitedSchemeEntity, callbackHandler, eVar, bp);
        } else {
            b(context, unitedSchemeEntity, callbackHandler, eVar, bp);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar, final f fVar) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.a.c.1
            @Override // com.baidu.swan.apps.ab.b
            public void kN(String str) {
                if (c.DEBUG) {
                    Log.d("SwanAppAction", str + "");
                }
                c.this.a(unitedSchemeEntity, callbackHandler, eVar, fVar);
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ah(int i, String str) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), fVar.callback);
            }
        });
    }

    private void b(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar, final f fVar) {
        com.baidu.swan.apps.ab.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.a.c.2
            @Override // com.baidu.swan.apps.ab.b
            public void kN(String str) {
                if (c.DEBUG) {
                    Log.d("SwanAppAction", str + "");
                }
                c.this.c(context, unitedSchemeEntity, callbackHandler, eVar, fVar);
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ah(int i, String str) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), fVar.callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar, final f fVar) {
        final d dVar = new d() { // from class: com.baidu.swan.apps.media.chooser.a.c.3
            @Override // com.baidu.swan.apps.media.chooser.listener.d
            public void a(boolean z, String str, Object obj) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (c.DEBUG) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).aEV());
                        }
                    }
                    com.baidu.swan.apps.console.c.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(com.baidu.swan.apps.media.chooser.b.d.a(arrayList, eVar), 0).toString(), fVar.callback);
                }
                com.baidu.swan.apps.media.chooser.b.e.clear();
            }
        };
        com.baidu.swan.apps.media.chooser.listener.b bVar = new com.baidu.swan.apps.media.chooser.listener.b() { // from class: com.baidu.swan.apps.media.chooser.a.c.4
            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void G(File file) {
                com.baidu.swan.apps.console.c.i("chooseVideo", "capture success");
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.H(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", com.baidu.swan.apps.v.f.aDH().aDn().aPC());
                bundle.putBoolean("compressed", fVar.dnM);
                bundle.putString("swanAppId", eVar.id);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aEP());
                com.baidu.swan.apps.media.chooser.b.d.b(eVar.aMf(), bundle, dVar);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void qs(String str) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), fVar.callback);
            }
        };
        com.baidu.swan.apps.media.chooser.b.b.a(eVar.aMf(), eVar.id, fVar.dnO, TextUtils.equals(fVar.dnN, "front"), bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar, final f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.sourceType == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.dnN, "front"));
        bundle.putInt("maxDuration", fVar.dnO);
        bundle.putInt("count", 1);
        bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, "single");
        bundle.putBoolean("compressed", fVar.dnM);
        bundle.putString("swanAppId", eVar.id);
        bundle.putString("swanTmpPath", com.baidu.swan.apps.v.f.aDH().aDn().aPC());
        com.baidu.swan.apps.media.chooser.b.d.a(context, bundle, new com.baidu.swan.apps.media.chooser.listener.c() { // from class: com.baidu.swan.apps.media.chooser.a.c.5
            @Override // com.baidu.swan.apps.media.chooser.listener.c
            public void aN(List list) {
                if (list == null || list.size() <= 0) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), fVar.callback);
                    return;
                }
                com.baidu.swan.apps.console.c.i("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(com.baidu.swan.apps.media.chooser.b.d.a(list, eVar), 0).toString(), fVar.callback);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.c
            public void qr(String str) {
                com.baidu.swan.apps.console.c.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), fVar.callback);
            }
        });
    }
}
