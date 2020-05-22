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

    public com.baidu.swan.apps.api.c.b hF(String str) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e aoG = e.aoG();
        if (aoG == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-GetLocationAction", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-GetLocationAction", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final C0303a hG = C0303a.hG(((JSONObject) aP.second).toString());
        if (hG == null || !hG.isValid()) {
            c.e("Api-GetLocationAction", "params is invalid");
            return new com.baidu.swan.apps.api.c.b(201, "params is invalid");
        } else if (TextUtils.isEmpty(hG.bLz)) {
            c.e("Api-GetLocationAction", "empty cb");
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        } else {
            aoG.aoR().b(getContext(), "mapp_location", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.api.module.f.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<b.d> hVar) {
                    a.this.a(hVar, hG, false);
                }
            });
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, C0303a c0303a, boolean z) {
        c.i("Api-GetLocationAction", "authorized result is " + hVar);
        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            b.Uh().a(c0303a, this, z);
            return;
        }
        int errorCode = hVar.getErrorCode();
        a(c0303a.bLz, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.gM(errorCode)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0303a c0303a, com.baidu.swan.apps.scheme.actions.f.b bVar) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "convert info : " + bVar.toJSON());
        }
        a(c0303a.bLz, new com.baidu.swan.apps.api.c.b(0, "success", bVar.toJSON()));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0303a c0303a, int i) {
        c.e("Api-GetLocationAction", "request location error code : " + i);
        a(c0303a.bLz, new com.baidu.swan.apps.api.c.b(1001, String.valueOf(i)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0303a c0303a, String str) {
        a(c0303a.bLz, new com.baidu.swan.apps.api.c.b(10005, "system deny"));
    }

    /* renamed from: com.baidu.swan.apps.api.module.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0303a {
        boolean bLy;
        public String bLz;
        public String mType;

        public static C0303a hG(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0303a c0303a = new C0303a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0303a.mType = jSONObject.optString("type");
                if (TextUtils.isEmpty(c0303a.mType)) {
                    c0303a.mType = CoordinateType.WGS84;
                }
                c0303a.bLy = jSONObject.optBoolean("altitude");
                c0303a.bLz = jSONObject.optString("cb");
                if (TextUtils.isEmpty(c0303a.bLz)) {
                    return null;
                }
                return c0303a;
            } catch (JSONException e) {
                if (d.DEBUG) {
                    Log.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                }
                c.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                return null;
            }
        }

        public boolean isValid() {
            return (TextUtils.equals(this.mType, CoordinateType.WGS84) || TextUtils.equals(this.mType, "gcj02") || TextUtils.equals(this.mType, "bd09ll")) && !TextUtils.isEmpty(this.bLz);
        }
    }
}
