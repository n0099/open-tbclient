package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.api.module.f.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d implements b.a {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hN(String str) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e apN = e.apN();
        if (apN == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-GetLocationAction", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-GetLocationAction", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final C0309a hO = C0309a.hO(((JSONObject) aR.second).toString());
        if (hO == null || !hO.isValid()) {
            c.e("Api-GetLocationAction", "params is invalid");
            return new com.baidu.swan.apps.api.c.b(201, "params is invalid");
        } else if (TextUtils.isEmpty(hO.bQn)) {
            c.e("Api-GetLocationAction", "empty cb");
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        } else {
            apN.apY().b(getContext(), "mapp_location", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.api.module.f.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<b.d> hVar) {
                    a.this.a(hVar, hO, false);
                }
            });
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, C0309a c0309a, boolean z) {
        c.i("Api-GetLocationAction", "authorized result is " + hVar);
        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            b.Vn().a(c0309a, this, z);
            return;
        }
        int errorCode = hVar.getErrorCode();
        a(c0309a.bQn, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.gZ(errorCode)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0309a c0309a, com.baidu.swan.apps.scheme.actions.f.b bVar) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "convert info : " + bVar.toJSON());
        }
        a(c0309a.bQn, new com.baidu.swan.apps.api.c.b(0, "success", bVar.toJSON()));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0309a c0309a, int i) {
        c.e("Api-GetLocationAction", "request location error code : " + i);
        a(c0309a.bQn, new com.baidu.swan.apps.api.c.b(1001, String.valueOf(i)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0309a c0309a, String str) {
        a(c0309a.bQn, new com.baidu.swan.apps.api.c.b(10005, "system deny"));
    }

    /* renamed from: com.baidu.swan.apps.api.module.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0309a {
        boolean bQm;
        public String bQn;
        public String mType;

        public static C0309a hO(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0309a c0309a = new C0309a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0309a.mType = jSONObject.optString("type");
                if (TextUtils.isEmpty(c0309a.mType)) {
                    c0309a.mType = CoordinateType.WGS84;
                }
                c0309a.bQm = jSONObject.optBoolean("altitude");
                c0309a.bQn = jSONObject.optString("cb");
                if (TextUtils.isEmpty(c0309a.bQn)) {
                    return null;
                }
                return c0309a;
            } catch (JSONException e) {
                if (d.DEBUG) {
                    Log.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                }
                c.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                return null;
            }
        }

        public boolean isValid() {
            return (TextUtils.equals(this.mType, CoordinateType.WGS84) || TextUtils.equals(this.mType, "gcj02") || TextUtils.equals(this.mType, "bd09ll")) && !TextUtils.isEmpty(this.bQn);
        }
    }
}
