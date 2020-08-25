package com.baidu.swan.apps.o;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b mH(String str) {
        if (DEBUG) {
            Log.d("Api-GameCenterApi", "postGameCenterMessage: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-GameCenterApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            c.e("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aX.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("Api-GameCenterApi", "empty cb");
            return new com.baidu.swan.apps.api.c.b(202, "empty cb");
        }
        return a(jSONObject, new C0419a(optString));
    }

    public com.baidu.swan.apps.api.c.b mI(String str) {
        if (DEBUG) {
            Log.d("Api-GameCenterApi", "postGameCenterMessageSync: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-GameCenterApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            c.e("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        return a((JSONObject) aX.second, new b());
    }

    private com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        String optString = jSONObject.optString("api");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(202, "empty api name");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        com.baidu.swan.apps.api.c.b a = com.baidu.swan.apps.t.a.apH().a(optString, optJSONObject, bVar);
        if (a == null) {
            return new com.baidu.swan.apps.api.c.b(0);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0419a implements com.baidu.swan.apps.o.b {
        private String bSt;

        private C0419a(String str) {
            this.bSt = str;
        }

        @Override // com.baidu.swan.apps.o.b
        public void al(@Nullable JSONObject jSONObject) {
            a.this.a(this.bSt, jSONObject == null ? new com.baidu.swan.apps.api.c.b(0) : new com.baidu.swan.apps.api.c.b(0, jSONObject));
        }

        @Override // com.baidu.swan.apps.o.b
        public void onFail(int i, @Nullable String str) {
            if (d.DEBUG && i == 0) {
                Log.e("Api-GameCenterApi", "GameCenterCallback:onFail errCode cannot be ERR_OK.");
            }
            a.this.a(this.bSt, str == null ? new com.baidu.swan.apps.api.c.b(i) : new com.baidu.swan.apps.api.c.b(i, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements com.baidu.swan.apps.o.b {
        private b() {
        }

        @Override // com.baidu.swan.apps.o.b
        public void al(@Nullable JSONObject jSONObject) {
            if (d.DEBUG) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onSuccess could not be invoked.");
            }
        }

        @Override // com.baidu.swan.apps.o.b
        public void onFail(int i, @Nullable String str) {
            if (d.DEBUG) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onFail could not be invoked.");
            }
        }
    }
}
