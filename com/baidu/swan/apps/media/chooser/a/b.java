package com.baidu.swan.apps.media.chooser.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.media.chooser.c.d;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b extends aa {
    private String dgY;
    private String mCallback;
    private int mCount;

    public b(j jVar) {
        super(jVar, "/swanAPI/chooseImage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        if (eVar == null || eVar.aJO() == null) {
            com.baidu.swan.apps.console.c.e("chooseImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.ama()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject parseString = v.parseString(unitedSchemeEntity.getParam("params"));
            this.mCallback = parseString.optString("cb");
            if (TextUtils.isEmpty(this.mCallback)) {
                com.baidu.swan.apps.console.c.e("chooseImage", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                this.mCount = Integer.parseInt(parseString.optString("count"));
                if (this.mCount < 1 || this.mCount > 9) {
                    this.mCount = 9;
                }
            } catch (NumberFormatException e) {
                com.baidu.swan.apps.console.c.e("chooseImage", "count format error");
                this.mCount = 9;
            }
            this.dgY = C(parseString.optJSONArray("sizeType"));
            JSONArray optJSONArray = parseString.optJSONArray("sourceType");
            String D = D(optJSONArray);
            com.baidu.swan.apps.console.c.i("chooseImage", "sizeType: " + this.dgY + ",sourceType: " + D);
            if (TextUtils.equals(D, "album")) {
                a(context, unitedSchemeEntity, callbackHandler, eVar, E(optJSONArray));
            } else {
                eVar.aKg().b(eVar.aJO(), PermissionProxy.SCOPE_ID_CAMERA, new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.media.chooser.a.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            b.this.e(context, unitedSchemeEntity, callbackHandler, eVar);
                            return;
                        }
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                        com.baidu.swan.apps.console.c.e("chooseImage", "camera authorize failure");
                    }
                });
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.a.b.2
            @Override // com.baidu.swan.apps.ab.b
            public void kU(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppAction", str + "");
                }
                b.this.b(unitedSchemeEntity, callbackHandler, eVar);
            }

            @Override // com.baidu.swan.apps.ab.b
            public void af(int i, String str) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.mCallback);
            }
        });
    }

    private void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar, final boolean z) {
        com.baidu.swan.apps.ab.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.a.b.3
            @Override // com.baidu.swan.apps.ab.b
            public void kU(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppAction", str + "");
                }
                b.this.b(context, unitedSchemeEntity, callbackHandler, eVar, z);
            }

            @Override // com.baidu.swan.apps.ab.b
            public void af(int i, String str) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.mCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        final d dVar = new d() { // from class: com.baidu.swan.apps.media.chooser.a.b.4
            @Override // com.baidu.swan.apps.media.chooser.c.d
            public void a(boolean z, String str, Object obj) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (b.DEBUG) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).aDB());
                        }
                    }
                    com.baidu.swan.apps.console.c.i("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(com.baidu.swan.apps.media.chooser.b.d.a(arrayList, eVar, "Image"), 0).toString(), b.this.mCallback);
                }
                com.baidu.swan.apps.media.chooser.b.e.clear();
            }
        };
        com.baidu.swan.apps.media.chooser.b.b.a(eVar.aJO(), eVar.id, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.a.b.5
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void D(File file) {
                com.baidu.swan.apps.console.c.i("chooseImage", "capture success");
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", f.aCp().aBV().aNl());
                bundle.putBoolean("compressed", TextUtils.equals(b.this.dgY, "compressed"));
                bundle.putString("swanAppId", eVar.id);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aDw());
                com.baidu.swan.apps.media.chooser.b.d.b(eVar.aJO(), bundle, dVar);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void qz(String str) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), b.this.mCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "Image");
        bundle.putBoolean("isShowCamera", z);
        bundle.putInt("count", this.mCount);
        bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, "single");
        bundle.putBoolean("compressed", TextUtils.equals(this.dgY, "compressed"));
        bundle.putString("swanAppId", eVar.id);
        bundle.putString("swanTmpPath", f.aCp().aBV().aNl());
        com.baidu.swan.apps.media.chooser.b.d.a(context, bundle, new com.baidu.swan.apps.media.chooser.c.c() { // from class: com.baidu.swan.apps.media.chooser.a.b.6
            @Override // com.baidu.swan.apps.media.chooser.c.c
            public void aK(List list) {
                if (list == null || list.size() <= 0) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), b.this.mCallback);
                    return;
                }
                com.baidu.swan.apps.console.c.i("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(com.baidu.swan.apps.media.chooser.b.d.a(list, eVar, "Image"), 0).toString(), b.this.mCallback);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.c
            public void qy(String str) {
                com.baidu.swan.apps.console.c.i("chooseImage", str);
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), b.this.mCallback);
            }
        });
    }

    private String C(JSONArray jSONArray) {
        boolean z = true;
        if (jSONArray == null || jSONArray.length() != 1 || !TextUtils.equals("original", jSONArray.optString(0))) {
            z = false;
        }
        return z ? "original" : "compressed";
    }

    private String D(JSONArray jSONArray) {
        boolean z = true;
        if (jSONArray == null || jSONArray.length() != 1 || !TextUtils.equals(PixelReadParams.DEFAULT_FILTER_ID, jSONArray.optString(0))) {
            z = false;
        }
        return z ? PixelReadParams.DEFAULT_FILTER_ID : "album";
    }

    private boolean E(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return true;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (TextUtils.equals(PixelReadParams.DEFAULT_FILTER_ID, jSONArray.optString(i))) {
                return true;
            }
        }
        return false;
    }
}
