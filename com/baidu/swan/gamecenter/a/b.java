package com.baidu.swan.gamecenter.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class b implements ar {
    private HashMap<String, Boolean> ddv = new HashMap<>();
    private a ddw = new a();

    @Override // com.baidu.swan.apps.adaptation.a.ar
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        if (aBP()) {
            bVar.aj(null);
            return null;
        }
        return this.ddw.b(jSONObject, a(bVar));
    }

    public boolean sc(String str) {
        return TextUtils.equals(this.ddw.name, str);
    }

    public boolean aBP() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.ddv.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.n.b a(@NonNull final com.baidu.swan.apps.n.b bVar) {
        return new com.baidu.swan.apps.n.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.n.b
            public void aj(@Nullable JSONObject jSONObject) {
                b.this.gb(true);
                bVar.aj(jSONObject);
            }

            @Override // com.baidu.swan.apps.n.b
            public void onFail(int i, @Nullable String str) {
                b.this.gb(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.ddv.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e arw = e.arw();
        if (arw != null) {
            return arw.getAppKey();
        }
        return null;
    }
}
