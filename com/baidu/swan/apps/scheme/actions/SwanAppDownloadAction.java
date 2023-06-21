package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.ch3;
import com.baidu.tieba.eh3;
import com.baidu.tieba.gv2;
import com.baidu.tieba.sq3;
import com.baidu.tieba.wc3;
import com.baidu.tieba.wd3;
import com.baidu.tieba.xg3;
import com.baidu.tieba.z82;
import com.baidu.tieba.zb3;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppDownloadAction extends wd3 {
    public boolean l(@NonNull UnitedSchemeEntity unitedSchemeEntity, @Nullable zb3 zb3Var) {
        return true;
    }

    /* loaded from: classes4.dex */
    public class a implements sq3<ch3<eh3.e>> {
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
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(ch3<eh3.e> ch3Var) {
            if (!xg3.h(ch3Var)) {
                xg3.p(ch3Var, this.a, this.b);
            } else if (!SwanAppDownloadAction.this.k(this.c, this.b, this.a, this.d, this.e)) {
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1001));
            }
        }
    }

    public SwanAppDownloadAction(wc3 wc3Var) {
        this(wc3Var, "/swanAPI/installApp");
    }

    /* loaded from: classes4.dex */
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

    public SwanAppDownloadAction(wc3 wc3Var, String str) {
        super(wc3Var, str);
    }

    @Override // com.baidu.tieba.wd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zb3 zb3Var) {
        JSONObject a2 = wd3.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            z82.i("SwanAppDownloadAction", "params parse error");
            return false;
        }
        String optString = a2.optString("type");
        SwanAppDownloadType find = SwanAppDownloadType.find(optString);
        if (find == SwanAppDownloadType.TYPE_OTHER) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters empty");
            z82.i("SwanAppDownloadAction", "type error:" + optString);
            return true;
        } else if (!l(unitedSchemeEntity, zb3Var)) {
            k(context, unitedSchemeEntity, callbackHandler, a2, find);
            return true;
        } else {
            if (zb3Var != null) {
                zb3Var.e0().g(context, "mapp_i_app_download", new a(callbackHandler, unitedSchemeEntity, context, a2, find));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "SwanApp is Null");
            }
            return true;
        }
    }

    public final boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
        boolean e = gv2.d().e(context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler);
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
