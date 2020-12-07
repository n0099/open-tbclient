package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.api.module.f.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.t.b.d;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends d implements b.a {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lI(String str) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e aJV = e.aJV();
        if (aJV == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-GetLocationAction", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-GetLocationAction", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final C0401a lK = C0401a.lK(((JSONObject) bp.second).toString());
        if (lK == null || !lK.isValid()) {
            c.e("Api-GetLocationAction", "params is invalid");
            return new com.baidu.swan.apps.api.c.b(201, "params is invalid");
        } else if (TextUtils.isEmpty(lK.cEE)) {
            c.e("Api-GetLocationAction", "empty cb");
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        } else {
            aJV.aKg().b(getContext(), "mapp_location", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.api.module.f.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    a.this.a(hVar, lK, false);
                }
            });
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, C0401a c0401a, boolean z) {
        c.i("Api-GetLocationAction", "authorized result is " + hVar);
        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            b.amo().a(c0401a, this, z);
            return;
        }
        int errorCode = hVar.getErrorCode();
        a(c0401a.cEE, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.hX(errorCode)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0401a c0401a, com.baidu.swan.apps.scheme.actions.f.b bVar) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "convert info : " + bVar.toJSON());
        }
        a(c0401a.cEE, new com.baidu.swan.apps.api.c.b(0, "success", bVar.toJSON()));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0401a c0401a, int i) {
        c.e("Api-GetLocationAction", "request location error code : " + i);
        a(c0401a.cEE, new com.baidu.swan.apps.api.c.b(1001, String.valueOf(i)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0401a c0401a, String str) {
        a(c0401a.cEE, new com.baidu.swan.apps.api.c.b(10005, "system deny"));
    }

    public com.baidu.swan.apps.api.c.b lJ(String str) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e aJV = e.aJV();
        if (aJV == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-GetLocationAction", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-GetLocationAction", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) bp.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        }
        aJV.aKg().b(getContext(), "mapp_location", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.api.module.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    int errorCode = hVar.getErrorCode();
                    a.this.a(optString, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.hX(errorCode)));
                } else if (!ak.aPu()) {
                    a.this.a(optString, new com.baidu.swan.apps.api.c.b(10005, com.baidu.swan.apps.setting.oauth.c.hX(10005)));
                } else {
                    a.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
                    com.baidu.swan.apps.t.a.azs().a(new d.a() { // from class: com.baidu.swan.apps.api.module.f.a.2.1
                        @Override // com.baidu.swan.apps.t.b.d.a
                        public void a(com.baidu.swan.apps.scheme.actions.f.b bVar2) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("data", bVar2.toJSON().toString());
                            f.aCp().b(new com.baidu.swan.apps.event.a.b("locationChange", hashMap));
                        }

                        @Override // com.baidu.swan.apps.t.b.d.a
                        public void onFailed(int i) {
                        }
                    });
                }
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b amn() {
        com.baidu.swan.apps.t.a.azs().aAC();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* renamed from: com.baidu.swan.apps.api.module.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0401a {
        boolean cED;
        public String cEE;
        public String mType;

        public static C0401a lK(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0401a c0401a = new C0401a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0401a.mType = jSONObject.optString("type");
                if (TextUtils.isEmpty(c0401a.mType)) {
                    c0401a.mType = CoordinateType.WGS84;
                }
                c0401a.cED = jSONObject.optBoolean("altitude");
                c0401a.cEE = jSONObject.optString("cb");
                if (TextUtils.isEmpty(c0401a.cEE)) {
                    return null;
                }
                return c0401a;
            } catch (JSONException e) {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                }
                c.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                return null;
            }
        }

        public boolean isValid() {
            return (TextUtils.equals(this.mType, CoordinateType.WGS84) || TextUtils.equals(this.mType, "gcj02") || TextUtils.equals(this.mType, "bd09ll")) && !TextUtils.isEmpty(this.cEE);
        }
    }
}
