package com.baidu.swan.b.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ap;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements ap {
    private HashMap<String, Boolean> cXL = new HashMap<>();
    private a cXM = new a();

    @Override // com.baidu.swan.apps.adaptation.a.ap
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        if (ayk()) {
            bVar.ah(null);
            return null;
        }
        return this.cXM.b(jSONObject, a(bVar));
    }

    public boolean re(String str) {
        return TextUtils.equals(this.cXM.name, str);
    }

    public boolean ayk() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.cXL.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.n.b a(@NonNull final com.baidu.swan.apps.n.b bVar) {
        return new com.baidu.swan.apps.n.b() { // from class: com.baidu.swan.b.b.b.1
            @Override // com.baidu.swan.apps.n.b
            public void ah(@Nullable JSONObject jSONObject) {
                b.this.fK(true);
                bVar.ah(jSONObject);
            }

            @Override // com.baidu.swan.apps.n.b
            public void onFail(int i, @Nullable String str) {
                b.this.fK(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.cXL.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e apN = e.apN();
        if (apN != null) {
            return apN.getAppKey();
        }
        return null;
    }
}
