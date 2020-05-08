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
    private HashMap<String, Boolean> cIM = new HashMap<>();
    private a cIN = new a();

    @Override // com.baidu.swan.apps.adaptation.a.ak
    @Nullable
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (atx()) {
            bVar.V(null);
            return null;
        }
        return this.cIN.b(jSONObject, a(bVar));
    }

    public boolean pw(String str) {
        return TextUtils.equals(this.cIN.name, str);
    }

    public boolean atx() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.cIM.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.p.b a(@NonNull final com.baidu.swan.apps.p.b bVar) {
        return new com.baidu.swan.apps.p.b() { // from class: com.baidu.swan.b.b.b.1
            @Override // com.baidu.swan.apps.p.b
            public void V(@Nullable JSONObject jSONObject) {
                b.this.fv(true);
                bVar.V(jSONObject);
            }

            @Override // com.baidu.swan.apps.p.b
            public void onFail(int i, @Nullable String str) {
                b.this.fv(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.cIM.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e akN = e.akN();
        if (akN != null) {
            return akN.getAppKey();
        }
        return null;
    }
}
