package com.baidu.swan.gamecenter.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.aw;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements aw {
    private HashMap<String, Boolean> dKk = new HashMap<>();
    private a dKl = new a();

    @Override // com.baidu.swan.apps.adaptation.a.aw
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (aPS()) {
            bVar.ay(null);
            return null;
        }
        return this.dKl.b(jSONObject, a(bVar));
    }

    public boolean vT(String str) {
        return TextUtils.equals(this.dKl.name, str);
    }

    public boolean aPS() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.dKk.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.o.b a(@NonNull final com.baidu.swan.apps.o.b bVar) {
        return new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.o.b
            public void ay(@Nullable JSONObject jSONObject) {
                b.this.hf(true);
                bVar.ay(jSONObject);
            }

            @Override // com.baidu.swan.apps.o.b
            public void onFail(int i, @Nullable String str) {
                b.this.hf(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.dKk.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aEV = e.aEV();
        if (aEV != null) {
            return aEV.getAppKey();
        }
        return null;
    }
}
