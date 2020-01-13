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
/* loaded from: classes10.dex */
public class a extends c implements b.a {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fm(String str) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e aaq = e.aaq();
        if (aaq == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ah = com.baidu.swan.apps.api.c.b.ah("Api-GetLocationAction", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ah.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final C0208a fn = C0208a.fn(((JSONObject) ah.second).toString());
        if (fn == null || !fn.isValid()) {
            com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "params is invalid");
            return new com.baidu.swan.apps.api.b.b(201, "params is invalid");
        } else if (TextUtils.isEmpty(fn.bak)) {
            com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "empty cb");
            return new com.baidu.swan.apps.api.b.b(201, "empty cb");
        } else {
            aaq.aaz().b(getContext(), "mapp_location", new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.api.module.f.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(h<b.d> hVar) {
                    a.this.a(hVar, fn, false);
                }
            });
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, C0208a c0208a, boolean z) {
        com.baidu.swan.apps.console.c.i("Api-GetLocationAction", "authorized result is " + hVar);
        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            b.HA().a(c0208a, this, z);
            return;
        }
        int errorCode = hVar.getErrorCode();
        a(c0208a.bak, new com.baidu.swan.apps.api.b.b(errorCode, com.baidu.swan.apps.setting.oauth.c.fX(errorCode)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0208a c0208a, com.baidu.swan.apps.scheme.actions.f.b bVar) {
        if (DEBUG) {
            Log.d("Api-GetLocationAction", "convert info : " + bVar.toJSON());
        }
        a(c0208a.bak, new com.baidu.swan.apps.api.b.b(0, "success", bVar.toJSON()));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0208a c0208a, int i) {
        com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "request location error code : " + i);
        a(c0208a.bak, new com.baidu.swan.apps.api.b.b(1001, String.valueOf(i)));
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(C0208a c0208a, String str) {
        a(c0208a.bak, new com.baidu.swan.apps.api.b.b(10005, "system deny"));
    }

    /* renamed from: com.baidu.swan.apps.api.module.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0208a {
        boolean baj;
        public String bak;
        public String mType;

        public static C0208a fn(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0208a c0208a = new C0208a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0208a.mType = jSONObject.optString("type");
                if (TextUtils.isEmpty(c0208a.mType)) {
                    c0208a.mType = CoordinateType.WGS84;
                }
                c0208a.baj = jSONObject.optBoolean("altitude");
                c0208a.bak = jSONObject.optString("cb");
                if (TextUtils.isEmpty(c0208a.bak)) {
                    return null;
                }
                return c0208a;
            } catch (JSONException e) {
                if (c.DEBUG) {
                    Log.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                }
                com.baidu.swan.apps.console.c.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e));
                return null;
            }
        }

        public boolean isValid() {
            return (TextUtils.equals(this.mType, CoordinateType.WGS84) || TextUtils.equals(this.mType, "gcj02") || TextUtils.equals(this.mType, "bd09ll")) && !TextUtils.isEmpty(this.bak);
        }
    }
}
