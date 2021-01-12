package com.baidu.swan.apps.o;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b nD(String str) {
        if (DEBUG) {
            Log.d("Api-GameCenterApi", "postGameCenterMessage: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-GameCenterApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            c.e("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bn.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("Api-GameCenterApi", "empty cb");
            return new com.baidu.swan.apps.api.c.b(202, "empty cb");
        }
        return a(jSONObject, new C0442a(optString));
    }

    public com.baidu.swan.apps.api.c.b nE(String str) {
        if (DEBUG) {
            Log.d("Api-GameCenterApi", "postGameCenterMessageSync: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-GameCenterApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            c.e("Api-GameCenterApi", "parse fail");
            return bVar;
        }
        return a((JSONObject) bn.second, new b());
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
        com.baidu.swan.apps.api.c.b a2 = com.baidu.swan.apps.t.a.axv().a(optString, optJSONObject, bVar);
        if (a2 == null) {
            return new com.baidu.swan.apps.api.c.b(0);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0442a implements com.baidu.swan.apps.o.b {
        private String cAw;

        private C0442a(String str) {
            this.cAw = str;
        }

        @Override // com.baidu.swan.apps.o.b
        public void aI(@Nullable JSONObject jSONObject) {
            a.this.a(this.cAw, jSONObject == null ? new com.baidu.swan.apps.api.c.b(0) : new com.baidu.swan.apps.api.c.b(0, jSONObject));
        }

        @Override // com.baidu.swan.apps.o.b
        public void onFail(int i, @Nullable String str) {
            if (d.DEBUG && i == 0) {
                Log.e("Api-GameCenterApi", "GameCenterCallback:onFail errCode cannot be ERR_OK.");
            }
            a.this.a(this.cAw, str == null ? new com.baidu.swan.apps.api.c.b(i) : new com.baidu.swan.apps.api.c.b(i, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements com.baidu.swan.apps.o.b {
        private b() {
        }

        @Override // com.baidu.swan.apps.o.b
        public void aI(@Nullable JSONObject jSONObject) {
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
