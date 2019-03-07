package com.baidu.swan.apps.scheme.actions.e;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.u.b.n;
import com.baidu.swan.apps.w.e;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/getLocation");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (bVar == null) {
            c.e(Headers.LOCATION, "aiapp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final C0137a gF = C0137a.gF(unitedSchemeEntity.getParam(LegoListActivityConfig.PARAMS));
        if (gF == null || !gF.isValid()) {
            c.e(Headers.LOCATION, "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (TextUtils.isEmpty(gF.aPX)) {
            c.e(Headers.LOCATION, "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else if (!(context instanceof Activity)) {
            c.e(Headers.LOCATION, "the context is not an activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            bVar.Jb().a((Activity) context, "mapp_location", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.e.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    c.i("GetLocationAction", "authorized result is " + bool);
                    if (bool.booleanValue()) {
                        a.this.a(context, callbackHandler, gF);
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(gF.aPX, UnitedSchemeUtility.wrapCallbackParams(1001, "the location is not authorized").toString());
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final CallbackHandler callbackHandler, final C0137a c0137a) {
        if (aa.Mo()) {
            b(context, callbackHandler, c0137a);
        } else {
            e.Ec().a(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new a.InterfaceC0078a() { // from class: com.baidu.swan.apps.scheme.actions.e.a.2
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0078a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    if (i != 0) {
                        callbackHandler.handleSchemeDispatchCallback(c0137a.aPX, UnitedSchemeUtility.wrapCallbackParams(1001, "RequestCode error").toString());
                        if (a.DEBUG) {
                            Log.e("GetLocationAction", "onRequestPermissionsResult requestCode error.");
                        }
                        c.e(Headers.LOCATION, "requestCode error");
                        return;
                    }
                    for (int i2 : iArr) {
                        if (i2 == -1) {
                            callbackHandler.handleSchemeDispatchCallback(c0137a.aPX, UnitedSchemeUtility.wrapCallbackParams(401, "User reject").toString());
                            if (a.DEBUG) {
                                Log.d("GetLocationAction", "onRequestPermissionsResult user reject.");
                            }
                            c.d(Headers.LOCATION, "user reject");
                            return;
                        }
                    }
                    a.this.b(context, callbackHandler, c0137a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, final CallbackHandler callbackHandler, final C0137a c0137a) {
        String str;
        if (TextUtils.equals(c0137a.mType, "gcj02")) {
            str = "gcj02";
        } else {
            str = "wgs84";
        }
        com.baidu.swan.apps.u.a.CR().a(str, false, c0137a.aPW, new n.a() { // from class: com.baidu.swan.apps.scheme.actions.e.a.3
            @Override // com.baidu.swan.apps.u.b.n.a
            public void a(b bVar) {
                if (a.DEBUG) {
                    Log.d("GetLocationAction", "convert info : " + bVar.toJSON());
                }
                callbackHandler.handleSchemeDispatchCallback(c0137a.aPX, UnitedSchemeUtility.wrapCallbackParams(bVar.toJSON(), 0).toString());
            }

            @Override // com.baidu.swan.apps.u.b.n.a
            public void onFailed(int i) {
                c.e(Headers.LOCATION, "request location error code : " + i);
                callbackHandler.handleSchemeDispatchCallback(c0137a.aPX, UnitedSchemeUtility.wrapCallbackParams(i).toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0137a {
        public boolean aPW;
        public String aPX;
        public String mType;

        private C0137a() {
        }

        public static C0137a gF(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0137a c0137a = new C0137a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0137a.mType = jSONObject.optString("type");
                if (TextUtils.isEmpty(c0137a.mType)) {
                    c0137a.mType = "wgs84";
                }
                c0137a.aPW = jSONObject.optBoolean("altitude");
                c0137a.aPX = jSONObject.optString("cb");
                if (TextUtils.isEmpty(c0137a.aPX)) {
                    return null;
                }
                return c0137a;
            } catch (JSONException e) {
                if (a.DEBUG) {
                    Log.e("GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                }
                c.e(Headers.LOCATION, "parse failed: " + Log.getStackTraceString(e));
                return null;
            }
        }

        public boolean isValid() {
            return (TextUtils.equals(this.mType, "wgs84") || TextUtils.equals(this.mType, "gcj02")) && !TextUtils.isEmpty(this.aPX);
        }
    }
}
