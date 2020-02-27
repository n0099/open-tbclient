package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.api.module.f.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c implements b.a {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fB(String str) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e acE = e.acE();
        if (acE == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-GetLocationAction", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ar.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final C0218a fC = C0218a.fC(((JSONObject) ar.second).toString());
        if (fC == null || !fC.isValid()) {
            com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "params is invalid");
            return new com.baidu.swan.apps.api.b.b(201, "params is invalid");
        } else if (TextUtils.isEmpty(fC.bew)) {
            com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "empty cb");
            return new com.baidu.swan.apps.api.b.b(201, "empty cb");
        } else {
            acE.acN().b(getContext(), "mapp_location", new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.api.module.f.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(h<b.d> hVar) {
                    a.this.a(hVar, fC, false);
                }
            });
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, C0218a c0218a, boolean z) {
        com.baidu.swan.apps.console.c.i("Api-GetLocationAction", "authorized result is " + hVar);
        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            b.JP().a(c0218a, this, z);
            return;
        }
        int errorCode = hVar.getErrorCode();
        a(c0218a.bew, new com.baidu.swan.apps.api.b.b(errorCode, com.baidu.swan.apps.setting.oauth.c.gn(errorCode)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0218a c0218a, com.baidu.swan.apps.scheme.actions.f.b bVar) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "convert info : " + bVar.toJSON());
        }
        a(c0218a.bew, new com.baidu.swan.apps.api.b.b(0, "success", bVar.toJSON()));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0218a c0218a, int i) {
        com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "request location error code : " + i);
        a(c0218a.bew, new com.baidu.swan.apps.api.b.b(1001, String.valueOf(i)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0218a c0218a, String str) {
        a(c0218a.bew, new com.baidu.swan.apps.api.b.b(10005, "system deny"));
    }

    /* renamed from: com.baidu.swan.apps.api.module.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0218a {
        boolean bev;
        public String bew;
        public String mType;

        public static C0218a fC(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0218a c0218a = new C0218a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0218a.mType = jSONObject.optString("type");
                if (TextUtils.isEmpty(c0218a.mType)) {
                    c0218a.mType = CoordinateType.WGS84;
                }
                c0218a.bev = jSONObject.optBoolean("altitude");
                c0218a.bew = jSONObject.optString("cb");
                if (TextUtils.isEmpty(c0218a.bew)) {
                    return null;
                }
                return c0218a;
            } catch (JSONException e) {
                if (c.DEBUG) {
                    Log.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                }
                com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                return null;
            }
        }

        public boolean isValid() {
            return (TextUtils.equals(this.mType, CoordinateType.WGS84) || TextUtils.equals(this.mType, "gcj02") || TextUtils.equals(this.mType, "bd09ll")) && !TextUtils.isEmpty(this.bew);
        }
    }
}
