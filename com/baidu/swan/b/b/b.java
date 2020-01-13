package com.baidu.swan.b.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ak;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements ak {
    private HashMap<String, Boolean> cfu = new HashMap<>();
    private a cfv = new a();

    @Override // com.baidu.swan.apps.adaptation.a.ak
    @Nullable
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (aiQ()) {
            bVar.K(null);
            return null;
        }
        return this.cfv.b(jSONObject, a(bVar));
    }

    public boolean nT(String str) {
        return TextUtils.equals(this.cfv.name, str);
    }

    public boolean aiQ() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.cfu.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.p.b a(@NonNull final com.baidu.swan.apps.p.b bVar) {
        return new com.baidu.swan.apps.p.b() { // from class: com.baidu.swan.b.b.b.1
            @Override // com.baidu.swan.apps.p.b
            public void K(@Nullable JSONObject jSONObject) {
                b.this.eq(true);
                bVar.K(jSONObject);
            }

            @Override // com.baidu.swan.apps.p.b
            public void onFail(int i, @Nullable String str) {
                b.this.eq(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eq(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.cfu.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aaq = e.aaq();
        if (aaq != null) {
            return aaq.getAppKey();
        }
        return null;
    }
}
