package com.baidu.swan.apps.p;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.api.a.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b jh(String str) {
        if (DEBUG) {
            Log.d("Api-GameCenterApi", "postGameCenterMessage: " + str);
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-GameCenterApi", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) az.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-GameCenterApi", "empty cb");
            return new com.baidu.swan.apps.api.b.b(202, "empty cb");
        }
        return a(jSONObject, new C0300a(optString));
    }

    public com.baidu.swan.apps.api.b.b ji(String str) {
        if (DEBUG) {
            Log.d("Api-GameCenterApi", "postGameCenterMessageSync: " + str);
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-GameCenterApi", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        return a((JSONObject) az.second, new b());
    }

    private com.baidu.swan.apps.api.b.b a(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        String optString = jSONObject.optString("api");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.b.b(202, "empty api name");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        com.baidu.swan.apps.api.b.b a = com.baidu.swan.apps.w.a.acI().a(optString, optJSONObject, bVar);
        if (a == null) {
            return new com.baidu.swan.apps.api.b.b(0);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0300a implements com.baidu.swan.apps.p.b {
        private String bTu;

        private C0300a(String str) {
            this.bTu = str;
        }

        @Override // com.baidu.swan.apps.p.b
        public void V(@Nullable JSONObject jSONObject) {
            a.this.a(this.bTu, jSONObject == null ? new com.baidu.swan.apps.api.b.b(0) : new com.baidu.swan.apps.api.b.b(0, jSONObject));
        }

        @Override // com.baidu.swan.apps.p.b
        public void onFail(int i, @Nullable String str) {
            if (c.DEBUG && i == 0) {
                Log.e("Api-GameCenterApi", "GameCenterCallback:onFail errCode cannot be ERR_OK.");
            }
            a.this.a(this.bTu, str == null ? new com.baidu.swan.apps.api.b.b(i) : new com.baidu.swan.apps.api.b.b(i, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements com.baidu.swan.apps.p.b {
        private b() {
        }

        @Override // com.baidu.swan.apps.p.b
        public void V(@Nullable JSONObject jSONObject) {
            if (c.DEBUG) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onSuccess could not be invoked.");
            }
        }

        @Override // com.baidu.swan.apps.p.b
        public void onFail(int i, @Nullable String str) {
            if (c.DEBUG) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onFail could not be invoked.");
            }
        }
    }
}
