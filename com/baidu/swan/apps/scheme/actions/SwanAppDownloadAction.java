package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.d;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.v2.e1.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppDownloadAction extends a0 {

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

    /* loaded from: classes3.dex */
    public class a implements b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f11444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f11445f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f11446g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f11447h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanAppDownloadType f11448i;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
            this.f11444e = callbackHandler;
            this.f11445f = unitedSchemeEntity;
            this.f11446g = context;
            this.f11447h = jSONObject;
            this.f11448i = swanAppDownloadType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.h(iVar)) {
                if (SwanAppDownloadAction.this.k(this.f11446g, this.f11445f, this.f11444e, this.f11447h, this.f11448i)) {
                    return;
                }
                UnitedSchemeUtility.callCallback(this.f11444e, this.f11445f, UnitedSchemeUtility.wrapCallbackParams(1001));
                return;
            }
            d.o(iVar, this.f11444e, this.f11445f);
        }
    }

    public SwanAppDownloadAction(e eVar) {
        this(eVar, "/swanAPI/installApp");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            d.a.m0.a.e0.d.g("SwanAppDownloadAction", "params parse error");
            return false;
        }
        String optString = a2.optString("type");
        SwanAppDownloadType find = SwanAppDownloadType.find(optString);
        if (find == SwanAppDownloadType.TYPE_OTHER) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters empty");
            d.a.m0.a.e0.d.g("SwanAppDownloadAction", "type error:" + optString);
            return true;
        } else if (!l(unitedSchemeEntity, eVar)) {
            k(context, unitedSchemeEntity, callbackHandler, a2, find);
            return true;
        } else {
            if (eVar != null) {
                eVar.T().g(context, "mapp_i_app_download", new a(callbackHandler, unitedSchemeEntity, context, a2, find));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "SwanApp is Null");
            }
            return true;
        }
    }

    public final boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
        boolean c2 = d.a.m0.a.c1.a.c().c(context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler);
        if (c2) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0, "success");
            unitedSchemeEntity.result = wrapCallbackParams;
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters error");
        }
        return c2;
    }

    public boolean l(@NonNull UnitedSchemeEntity unitedSchemeEntity, @Nullable d.a.m0.a.a2.e eVar) {
        return true;
    }

    public SwanAppDownloadAction(e eVar, String str) {
        super(eVar, str);
    }
}
