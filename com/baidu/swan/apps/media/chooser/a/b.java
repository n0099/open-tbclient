package com.baidu.swan.apps.media.chooser.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.media.chooser.c.d;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.y.f;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends ab {
    private String bBw;
    private String mCallback;
    private int mCount;

    public b(j jVar) {
        super(jVar, "/swanAPI/chooseImage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        if (eVar == null || eVar.acB() == null) {
            com.baidu.swan.apps.console.c.e("chooseImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.JF()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject parseString = s.parseString(unitedSchemeEntity.getParam("params"));
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
            this.bBw = w(parseString.optJSONArray("sizeType"));
            JSONArray optJSONArray = parseString.optJSONArray("sourceType");
            String x = x(optJSONArray);
            com.baidu.swan.apps.console.c.i("chooseImage", "sizeType: " + this.bBw + ",sourceType: " + x);
            if (TextUtils.equals(x, "album")) {
                a(context, unitedSchemeEntity, callbackHandler, eVar, y(optJSONArray));
            } else {
                eVar.acP().b(eVar.acB(), PermissionProxy.SCOPE_ID_CAMERA, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.media.chooser.a.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void D(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            b.this.n(context, unitedSchemeEntity, callbackHandler, eVar);
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
    public void n(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.a.b.2
            @Override // com.baidu.swan.apps.af.b
            public void fD(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppAction", str + "");
                }
                b.this.b(unitedSchemeEntity, callbackHandler, eVar);
            }

            @Override // com.baidu.swan.apps.af.b
            public void v(int i, String str) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.mCallback);
            }
        });
    }

    private void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar, final boolean z) {
        com.baidu.swan.apps.af.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.a.b.3
            @Override // com.baidu.swan.apps.af.b
            public void fD(String str) {
                if (b.DEBUG) {
                    Log.d("SwanAppAction", str + "");
                }
                b.this.b(context, unitedSchemeEntity, callbackHandler, eVar, z);
            }

            @Override // com.baidu.swan.apps.af.b
            public void v(int i, String str) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.mCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        final d dVar = new d() { // from class: com.baidu.swan.apps.media.chooser.a.b.4
            @Override // com.baidu.swan.apps.media.chooser.c.d
            public void onResult(boolean z, String str, Object obj) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (b.DEBUG) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d(getClass().getSimpleName(), "tempPath = " + ((MediaModel) it.next()).XM());
                        }
                    }
                    com.baidu.swan.apps.console.c.i("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(com.baidu.swan.apps.media.chooser.b.d.a(arrayList, eVar, "Image"), 0).toString(), b.this.mCallback);
                }
                com.baidu.swan.apps.media.chooser.b.e.clear();
            }
        };
        com.baidu.swan.apps.media.chooser.b.b.a(eVar.acB(), eVar.id, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.a.b.5
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void s(File file) {
                com.baidu.swan.apps.console.c.i("chooseImage", "capture success");
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", f.WS().Wz().afp());
                bundle.putBoolean("compressed", TextUtils.equals(b.this.bBw, "compressed"));
                bundle.putString("swanAppId", eVar.id);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.XJ());
                com.baidu.swan.apps.media.chooser.b.d.b(eVar.acB(), bundle, dVar);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void je(String str) {
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
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", TextUtils.equals(this.bBw, "compressed"));
        bundle.putString("swanAppId", eVar.id);
        bundle.putString("swanTmpPath", f.WS().Wz().afp());
        com.baidu.swan.apps.media.chooser.b.d.a(context, bundle, new com.baidu.swan.apps.media.chooser.c.c() { // from class: com.baidu.swan.apps.media.chooser.a.b.6
            @Override // com.baidu.swan.apps.media.chooser.c.c
            public void U(List list) {
                if (list == null || list.size() <= 0) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), b.this.mCallback);
                    return;
                }
                com.baidu.swan.apps.console.c.i("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(com.baidu.swan.apps.media.chooser.b.d.a(list, eVar, "Image"), 0).toString(), b.this.mCallback);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.c
            public void jd(String str) {
                com.baidu.swan.apps.console.c.i("chooseImage", str);
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), b.this.mCallback);
            }
        });
    }

    private String w(JSONArray jSONArray) {
        boolean z = true;
        if (jSONArray == null || jSONArray.length() != 1 || !TextUtils.equals("original", jSONArray.optString(0))) {
            z = false;
        }
        return z ? "original" : "compressed";
    }

    private String x(JSONArray jSONArray) {
        boolean z = true;
        if (jSONArray == null || jSONArray.length() != 1 || !TextUtils.equals("camera", jSONArray.optString(0))) {
            z = false;
        }
        return z ? "camera" : "album";
    }

    private boolean y(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return true;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (TextUtils.equals("camera", jSONArray.optString(i))) {
                return true;
            }
        }
        return false;
    }
}
