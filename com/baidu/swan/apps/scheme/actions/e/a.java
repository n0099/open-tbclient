package com.baidu.swan.apps.scheme.actions.e;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.u.b.n;
import com.baidu.swan.apps.w.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/getLocation");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (bVar == null) {
            c.e(Headers.LOCATION, "aiapp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final C0183a hi = C0183a.hi(unitedSchemeEntity.getParam("params"));
        if (hi == null || !hi.isValid()) {
            c.e(Headers.LOCATION, "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (TextUtils.isEmpty(hi.aTT)) {
            c.e(Headers.LOCATION, "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else if (!(context instanceof Activity)) {
            c.e(Headers.LOCATION, "the context is not an activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            bVar.Ml().a((Activity) context, "mapp_location", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.e.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    c.i("GetLocationAction", "authorized result is " + bool);
                    if (bool.booleanValue()) {
                        a.this.a(context, callbackHandler, hi);
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(hi.aTT, UnitedSchemeUtility.wrapCallbackParams(1001, "the location is not authorized").toString());
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final CallbackHandler callbackHandler, final C0183a c0183a) {
        if (ac.PO()) {
            b(context, callbackHandler, c0183a);
        } else {
            e.GJ().a(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new a.InterfaceC0120a() { // from class: com.baidu.swan.apps.scheme.actions.e.a.2
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0120a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    if (i != 0) {
                        callbackHandler.handleSchemeDispatchCallback(c0183a.aTT, UnitedSchemeUtility.wrapCallbackParams(1001, "RequestCode error").toString());
                        if (a.DEBUG) {
                            Log.e("GetLocationAction", "onRequestPermissionsResult requestCode error.");
                        }
                        c.e(Headers.LOCATION, "requestCode error");
                        return;
                    }
                    for (int i2 : iArr) {
                        if (i2 == -1) {
                            callbackHandler.handleSchemeDispatchCallback(c0183a.aTT, UnitedSchemeUtility.wrapCallbackParams(401, "User reject").toString());
                            if (a.DEBUG) {
                                Log.d("GetLocationAction", "onRequestPermissionsResult user reject.");
                            }
                            c.d(Headers.LOCATION, "user reject");
                            return;
                        }
                    }
                    a.this.b(context, callbackHandler, c0183a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, final CallbackHandler callbackHandler, final C0183a c0183a) {
        String str;
        if (TextUtils.equals(c0183a.mType, CoordinateType.GCJ02)) {
            str = CoordinateType.GCJ02;
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.u.a.EH().a(str, false, c0183a.aTS, new n.a() { // from class: com.baidu.swan.apps.scheme.actions.e.a.3
            @Override // com.baidu.swan.apps.u.b.n.a
            public void a(b bVar) {
                if (a.DEBUG) {
                    Log.d("GetLocationAction", "convert info : " + bVar.toJSON());
                }
                callbackHandler.handleSchemeDispatchCallback(c0183a.aTT, UnitedSchemeUtility.wrapCallbackParams(bVar.toJSON(), 0).toString());
            }

            @Override // com.baidu.swan.apps.u.b.n.a
            public void cD(int i) {
                c.e(Headers.LOCATION, "request location error code : " + i);
                callbackHandler.handleSchemeDispatchCallback(c0183a.aTT, UnitedSchemeUtility.wrapCallbackParams(i).toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0183a {
        public boolean aTS;
        public String aTT;
        public String mType;

        private C0183a() {
        }

        public static C0183a hi(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0183a c0183a = new C0183a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0183a.mType = jSONObject.optString("type");
                if (TextUtils.isEmpty(c0183a.mType)) {
                    c0183a.mType = CoordinateType.WGS84;
                }
                c0183a.aTS = jSONObject.optBoolean("altitude");
                c0183a.aTT = jSONObject.optString("cb");
                if (TextUtils.isEmpty(c0183a.aTT)) {
                    return null;
                }
                return c0183a;
            } catch (JSONException e) {
                if (a.DEBUG) {
                    Log.e("GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                }
                c.e(Headers.LOCATION, "parse failed: " + Log.getStackTraceString(e));
                return null;
            }
        }

        public boolean isValid() {
            return (TextUtils.equals(this.mType, CoordinateType.WGS84) || TextUtils.equals(this.mType, CoordinateType.GCJ02)) && !TextUtils.isEmpty(this.aTT);
        }
    }
}
