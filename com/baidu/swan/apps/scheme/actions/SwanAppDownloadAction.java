package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.ad3;
import com.baidu.tieba.cd3;
import com.baidu.tieba.er2;
import com.baidu.tieba.qm3;
import com.baidu.tieba.u83;
import com.baidu.tieba.u93;
import com.baidu.tieba.vc3;
import com.baidu.tieba.x42;
import com.baidu.tieba.x73;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppDownloadAction extends u93 {
    public boolean l(@NonNull UnitedSchemeEntity unitedSchemeEntity, @Nullable x73 x73Var) {
        return true;
    }

    /* loaded from: classes3.dex */
    public class a implements qm3<ad3<cd3.e>> {
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ SwanAppDownloadType e;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = jSONObject;
            this.e = swanAppDownloadType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(ad3<cd3.e> ad3Var) {
            if (!vc3.h(ad3Var)) {
                vc3.p(ad3Var, this.a, this.b);
            } else if (!SwanAppDownloadAction.this.k(this.c, this.b, this.a, this.d, this.e)) {
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1001));
            }
        }
    }

    public SwanAppDownloadAction(u83 u83Var) {
        this(u83Var, "/swanAPI/installApp");
    }

    /* loaded from: classes3.dex */
    public enum SwanAppDownloadType {
        TYPE_QUERY_STATUS("queryStatus"),
        TYPE_START_DOWNLOAD("startDownload"),
        TYPE_PAUSE_DOWNLOAD("pauseDownload"),
        TYPE_CANCEL_DOWNLOAD("cancelDownload"),
        TYPE_RESUME_DOWNLOAD("resumeDownload"),
        TYPE_INSTALL_APP("installApp"),
        TYPE_STOP_SERVICE("stopService"),
        TYPE_OTHER("#");
        
        public String typeName;

        SwanAppDownloadType(String str) {
            this.typeName = str;
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

        public String getTypeName() {
            return this.typeName;
        }
    }

    public SwanAppDownloadAction(u83 u83Var, String str) {
        super(u83Var, str);
    }

    @Override // com.baidu.tieba.u93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, x73 x73Var) {
        JSONObject a2 = u93.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            x42.i("SwanAppDownloadAction", "params parse error");
            return false;
        }
        String optString = a2.optString("type");
        SwanAppDownloadType find = SwanAppDownloadType.find(optString);
        if (find == SwanAppDownloadType.TYPE_OTHER) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters empty");
            x42.i("SwanAppDownloadAction", "type error:" + optString);
            return true;
        } else if (!l(unitedSchemeEntity, x73Var)) {
            k(context, unitedSchemeEntity, callbackHandler, a2, find);
            return true;
        } else {
            if (x73Var != null) {
                x73Var.e0().g(context, "mapp_i_app_download", new a(callbackHandler, unitedSchemeEntity, context, a2, find));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "SwanApp is Null");
            }
            return true;
        }
    }

    public final boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
        boolean e = er2.d().e(context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler);
        if (e) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0, "success");
            unitedSchemeEntity.result = wrapCallbackParams;
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters error");
        }
        return e;
    }
}
