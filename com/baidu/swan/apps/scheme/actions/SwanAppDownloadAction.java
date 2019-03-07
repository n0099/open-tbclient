package com.baidu.swan.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppDownloadAction extends y {

    /* loaded from: classes2.dex */
    public enum SwanAppDownloadType {
        TYPE_QUERY_STATUS("queryStatus"),
        TYPE_START_DOWNLOAD("startDownload"),
        TYPE_PAUSE_DOWNLOAD("pauseDownload"),
        TYPE_CANCEL_DOWNLOAD("cancelDownload"),
        TYPE_RESUME_DOWNLOAD("resumeDownload"),
        TYPE_INSTALL_APP("installApp"),
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
        this(jVar, "/swan/installApp");
    }

    protected SwanAppDownloadAction(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        final JSONObject c = c(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            com.baidu.swan.apps.console.c.i("SwanAppDownloadAction", "params parse error");
            return false;
        }
        String optString = c.optString("type");
        final SwanAppDownloadType find = SwanAppDownloadType.find(optString);
        if (find == SwanAppDownloadType.TYPE_OTHER) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters empty");
            com.baidu.swan.apps.console.c.i("SwanAppDownloadAction", "type error:" + optString);
            return true;
        } else if (!a(unitedSchemeEntity, bVar)) {
            a(context, unitedSchemeEntity, callbackHandler, c, find);
            return true;
        } else {
            if (bVar != null) {
                bVar.Jb().a((Activity) context, "mapp_i_app_download", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.c.a
                    /* renamed from: b */
                    public void D(Boolean bool) {
                        com.baidu.swan.apps.console.c.w("SwanAppDownloadAction", "checkOrAuthorize:" + bool);
                        if (bool.booleanValue()) {
                            if (!SwanAppDownloadAction.this.a(context, unitedSchemeEntity, callbackHandler, c, find)) {
                                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
                                return;
                            }
                            return;
                        }
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(402, "No authority"));
                    }
                });
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "aiApp Null");
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
        boolean a = com.baidu.swan.apps.u.a.CI().a(context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler);
        if (a) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0, "success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, unitedSchemeEntity.result);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters error");
        }
        return a;
    }

    protected boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @Nullable com.baidu.swan.apps.ae.b bVar) {
        return true;
    }
}
