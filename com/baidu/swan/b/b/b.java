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
    private HashMap<String, Boolean> cTb = new HashMap<>();
    private a cTc = new a();

    @Override // com.baidu.swan.apps.adaptation.a.ap
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        if (axe()) {
            bVar.aa(null);
            return null;
        }
        return this.cTc.b(jSONObject, a(bVar));
    }

    public boolean qW(String str) {
        return TextUtils.equals(this.cTc.name, str);
    }

    public boolean axe() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.cTb.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.n.b a(@NonNull final com.baidu.swan.apps.n.b bVar) {
        return new com.baidu.swan.apps.n.b() { // from class: com.baidu.swan.b.b.b.1
            @Override // com.baidu.swan.apps.n.b
            public void aa(@Nullable JSONObject jSONObject) {
                b.this.fF(true);
                bVar.aa(jSONObject);
            }

            @Override // com.baidu.swan.apps.n.b
            public void onFail(int i, @Nullable String str) {
                b.this.fF(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.cTb.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aoG = e.aoG();
        if (aoG != null) {
            return aoG.getAppKey();
        }
        return null;
    }
}
