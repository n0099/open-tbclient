package com.baidu.swan.b.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ak;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements ak {
    private HashMap<String, Boolean> cjy = new HashMap<>();
    private a cjz = new a();

    @Override // com.baidu.swan.apps.adaptation.a.ak
    @Nullable
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (ale()) {
            bVar.K(null);
            return null;
        }
        return this.cjz.b(jSONObject, a(bVar));
    }

    public boolean oj(String str) {
        return TextUtils.equals(this.cjz.name, str);
    }

    public boolean ale() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.cjy.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.p.b a(@NonNull final com.baidu.swan.apps.p.b bVar) {
        return new com.baidu.swan.apps.p.b() { // from class: com.baidu.swan.b.b.b.1
            @Override // com.baidu.swan.apps.p.b
            public void K(@Nullable JSONObject jSONObject) {
                b.this.ex(true);
                bVar.K(jSONObject);
            }

            @Override // com.baidu.swan.apps.p.b
            public void onFail(int i, @Nullable String str) {
                b.this.ex(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.cjy.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e acE = e.acE();
        if (acE != null) {
            return acE.getAppKey();
        }
        return null;
    }
}
