package com.baidu.swan.apps.media.chooser.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.v.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends aa {
    private boolean dkQ;
    private String mCallback;
    private int mCount;
    private String mMode;

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseAlbum");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null || eVar.aIH() == null) {
            com.baidu.swan.apps.console.c.e("chooseAlbum", "runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        } else if (eVar.ajS()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject parseString = v.parseString(unitedSchemeEntity.getParam("params"));
            this.mCallback = parseString.optString("cb");
            if (TextUtils.isEmpty(this.mCallback)) {
                com.baidu.swan.apps.console.c.e("chooseAlbum", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                return false;
            }
            this.mCount = parseString.optInt("count");
            this.mMode = parseString.optString(UbcStatConstant.KEY_CONTENT_EXT_MODE);
            this.dkQ = parseString.optBoolean("compressed");
            c(context, unitedSchemeEntity, callbackHandler, eVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    private void c(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        com.baidu.swan.apps.ab.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.a.a.1
            @Override // com.baidu.swan.apps.ab.b
            public void kb(String str) {
                if (a.DEBUG) {
                    Log.d("SwanAppAction", str + "");
                }
                a.this.d(context, unitedSchemeEntity, callbackHandler, eVar);
            }

            @Override // com.baidu.swan.apps.ab.b
            public void am(int i, String str) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), a.this.mCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "album");
        bundle.putBoolean("isShowCamera", false);
        bundle.putInt("count", this.mCount);
        bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, this.mMode);
        bundle.putBoolean("compressed", this.dkQ);
        bundle.putString("swanAppId", eVar.id);
        bundle.putString("swanTmpPath", f.aAo().azU().aMe());
        d.a(context, bundle, new com.baidu.swan.apps.media.chooser.listener.c() { // from class: com.baidu.swan.apps.media.chooser.a.a.2
            @Override // com.baidu.swan.apps.media.chooser.listener.c
            public void aI(List list) {
                if (list == null || list.size() <= 0) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), a.this.mCallback);
                    return;
                }
                com.baidu.swan.apps.console.c.i("chooseAlbum", "choose success");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a(list, eVar, "album"), 0).toString(), a.this.mCallback);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.c
            public void pF(String str) {
                com.baidu.swan.apps.console.c.e("chooseAlbum", str);
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), a.this.mCallback);
            }
        });
    }
}
