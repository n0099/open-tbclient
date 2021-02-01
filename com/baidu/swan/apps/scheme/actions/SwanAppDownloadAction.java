package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SwanAppDownloadAction extends aa {

    /* loaded from: classes9.dex */
    public enum SwanAppDownloadType {
        TYPE_QUERY_STATUS("queryStatus"),
        TYPE_START_DOWNLOAD("startDownload"),
        TYPE_PAUSE_DOWNLOAD("pauseDownload"),
        TYPE_CANCEL_DOWNLOAD("cancelDownload"),
        TYPE_RESUME_DOWNLOAD("resumeDownload"),
        TYPE_INSTALL_APP("installApp"),
        TYPE_STOP_SERVICE("stopService"),
        TYPE_OTHER("#");
        
        private String typeName;

        SwanAppDownloadType(String str) {
            this.typeName = str;
        }

        public String getTypeName() {
            return this.typeName;
        }

        public static SwanAppDownloadType find(@Nullable String str) {
            SwanAppDownloadType[] values;
            for (SwanAppDownloadType swanAppDownloadType : values()) {
                if (swanAppDownloadType.typeName.equals(str)) {
                    return swanAppDownloadType;
                }
            }
            return TYPE_OTHER;
        }
    }

    public SwanAppDownloadAction(com.baidu.swan.apps.scheme.j jVar) {
        this(jVar, "/swanAPI/installApp");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SwanAppDownloadAction(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            com.baidu.swan.apps.console.c.i("SwanAppDownloadAction", "params parse error");
            return false;
        }
        String optString = b2.optString("type");
        final SwanAppDownloadType find = SwanAppDownloadType.find(optString);
        if (find == SwanAppDownloadType.TYPE_OTHER) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters empty");
            com.baidu.swan.apps.console.c.i("SwanAppDownloadAction", "type error:" + optString);
            return true;
        } else if (!a(unitedSchemeEntity, eVar)) {
            a(context, unitedSchemeEntity, callbackHandler, b2, find);
            return true;
        } else {
            if (eVar != null) {
                eVar.aIW().b(context, "mapp_i_app_download", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            if (!SwanAppDownloadAction.this.a(context, unitedSchemeEntity, callbackHandler, b2, find)) {
                                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
                                return;
                            }
                            return;
                        }
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                    }
                });
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "SwanApp is Null");
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
        boolean a2 = com.baidu.swan.apps.t.a.axg().a(context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler);
        if (a2) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0, "success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, unitedSchemeEntity.result);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters error");
        }
        return a2;
    }

    protected boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @Nullable com.baidu.swan.apps.runtime.e eVar) {
        return true;
    }
}
