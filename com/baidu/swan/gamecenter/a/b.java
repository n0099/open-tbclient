package com.baidu.swan.gamecenter.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.aw;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class b implements aw {
    private HashMap<String, Boolean> dVs = new HashMap<>();
    private a dVt = new a();

    @Override // com.baidu.swan.apps.adaptation.a.aw
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (aUP()) {
            bVar.aA(null);
            return null;
        }
        return this.dVt.b(jSONObject, a(bVar));
    }

    public boolean wJ(String str) {
        return TextUtils.equals(this.dVt.name, str);
    }

    public boolean aUP() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.dVs.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.o.b a(@NonNull final com.baidu.swan.apps.o.b bVar) {
        return new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.o.b
            public void aA(@Nullable JSONObject jSONObject) {
                b.this.hG(true);
                bVar.aA(jSONObject);
            }

            @Override // com.baidu.swan.apps.o.b
            public void onFail(int i, @Nullable String str) {
                b.this.hG(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hG(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.dVs.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aJV = e.aJV();
        if (aJV != null) {
            return aJV.getAppKey();
        }
        return null;
    }
}
