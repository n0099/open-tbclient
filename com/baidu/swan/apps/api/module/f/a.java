package com.baidu.swan.apps.api.module.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ao.ak;
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
/* loaded from: classes8.dex */
public class a extends d implements b.a {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kq(String str) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e aIs = e.aIs();
        if (aIs == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-GetLocationAction", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-GetLocationAction", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final C0376a ks = C0376a.ks(((JSONObject) bn.second).toString());
        if (ks == null || !ks.isValid()) {
            c.e("Api-GetLocationAction", "params is invalid");
            return new com.baidu.swan.apps.api.c.b(201, "params is invalid");
        } else if (TextUtils.isEmpty(ks.cEI)) {
            c.e("Api-GetLocationAction", "empty cb");
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        } else {
            aIs.aID().b(getContext(), "mapp_location", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.api.module.f.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<b.d> hVar) {
                    a.this.a(hVar, ks, false);
                }
            });
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, C0376a c0376a, boolean z) {
        c.i("Api-GetLocationAction", "authorized result is " + hVar);
        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            b.ajF().a(c0376a, this, z);
            return;
        }
        int errorCode = hVar.getErrorCode();
        a(c0376a.cEI, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.gk(errorCode)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0376a c0376a, com.baidu.swan.apps.scheme.actions.f.b bVar) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "convert info : " + bVar.toJSON());
        }
        a(c0376a.cEI, new com.baidu.swan.apps.api.c.b(0, "success", bVar.toJSON()));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0376a c0376a, int i) {
        c.e("Api-GetLocationAction", "request location error code : " + i);
        a(c0376a.cEI, new com.baidu.swan.apps.api.c.b(1001, String.valueOf(i)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0376a c0376a, String str) {
        a(c0376a.cEI, new com.baidu.swan.apps.api.c.b(10005, "system deny"));
    }

    public com.baidu.swan.apps.api.c.b kr(String str) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e aIs = e.aIs();
        if (aIs == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-GetLocationAction", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-GetLocationAction", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) bn.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        }
        aIs.aID().b(getContext(), "mapp_location", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.api.module.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    int errorCode = hVar.getErrorCode();
                    a.this.a(optString, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.gk(errorCode)));
                } else if (!ak.aNS()) {
                    a.this.a(optString, new com.baidu.swan.apps.api.c.b(10005, com.baidu.swan.apps.setting.oauth.c.gk(10005)));
                } else {
                    a.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
                    com.baidu.swan.apps.t.a.awQ().a(new d.a() { // from class: com.baidu.swan.apps.api.module.f.a.2.1
                        @Override // com.baidu.swan.apps.t.b.d.a
                        public void a(com.baidu.swan.apps.scheme.actions.f.b bVar2) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("data", bVar2.toJSON().toString());
                            f.azN().b(new com.baidu.swan.apps.event.a.b("locationChange", hashMap));
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

    public com.baidu.swan.apps.api.c.b ajE() {
        com.baidu.swan.apps.t.a.awQ().aya();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* renamed from: com.baidu.swan.apps.api.module.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0376a {
        boolean cEH;
        public String cEI;
        public String mType;

        public static C0376a ks(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0376a c0376a = new C0376a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0376a.mType = jSONObject.optString("type");
                if (TextUtils.isEmpty(c0376a.mType)) {
                    c0376a.mType = CoordinateType.WGS84;
                }
                c0376a.cEH = jSONObject.optBoolean("altitude");
                c0376a.cEI = jSONObject.optString("cb");
                if (TextUtils.isEmpty(c0376a.cEI)) {
                    return null;
                }
                return c0376a;
            } catch (JSONException e) {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                }
                c.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                return null;
            }
        }

        public boolean isValid() {
            return (TextUtils.equals(this.mType, CoordinateType.WGS84) || TextUtils.equals(this.mType, "gcj02") || TextUtils.equals(this.mType, "bd09ll")) && !TextUtils.isEmpty(this.cEI);
        }
    }
}
