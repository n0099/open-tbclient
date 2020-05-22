package com.baidu.swan.apps.n;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kp(String str) {
        if (DEBUG) {
            Log.d("Api-GameCenterApi", "postGameCenterMessage: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-GameCenterApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            c.e("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("Api-GameCenterApi", "empty cb");
            return new com.baidu.swan.apps.api.c.b(202, "empty cb");
        }
        return a(jSONObject, new C0359a(optString));
    }

    public com.baidu.swan.apps.api.c.b kq(String str) {
        if (DEBUG) {
            Log.d("Api-GameCenterApi", "postGameCenterMessageSync: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-GameCenterApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            c.e("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        return a((JSONObject) aP.second, new b());
    }

    private com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        String optString = jSONObject.optString("api");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(202, "empty api name");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        com.baidu.swan.apps.api.c.b a = com.baidu.swan.apps.u.a.afM().a(optString, optJSONObject, bVar);
        if (a == null) {
            return new com.baidu.swan.apps.api.c.b(0);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0359a implements com.baidu.swan.apps.n.b {
        private String cdu;

        private C0359a(String str) {
            this.cdu = str;
        }

        @Override // com.baidu.swan.apps.n.b
        public void aa(@Nullable JSONObject jSONObject) {
            a.this.a(this.cdu, jSONObject == null ? new com.baidu.swan.apps.api.c.b(0) : new com.baidu.swan.apps.api.c.b(0, jSONObject));
        }

        @Override // com.baidu.swan.apps.n.b
        public void onFail(int i, @Nullable String str) {
            if (d.DEBUG && i == 0) {
                Log.e("Api-GameCenterApi", "GameCenterCallback:onFail errCode cannot be ERR_OK.");
            }
            a.this.a(this.cdu, str == null ? new com.baidu.swan.apps.api.c.b(i) : new com.baidu.swan.apps.api.c.b(i, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements com.baidu.swan.apps.n.b {
        private b() {
        }

        @Override // com.baidu.swan.apps.n.b
        public void aa(@Nullable JSONObject jSONObject) {
            if (d.DEBUG) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onSuccess could not be invoked.");
            }
        }

        @Override // com.baidu.swan.apps.n.b
        public void onFail(int i, @Nullable String str) {
            if (d.DEBUG) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onFail could not be invoked.");
            }
        }
    }
}
