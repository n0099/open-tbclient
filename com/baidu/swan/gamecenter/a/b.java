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
    private HashMap<String, Boolean> dOu = new HashMap<>();
    private a dOv = new a();

    @Override // com.baidu.swan.apps.adaptation.a.aw
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (aRK()) {
            bVar.ay(null);
            return null;
        }
        return this.dOv.b(jSONObject, a(bVar));
    }

    public boolean wc(String str) {
        return TextUtils.equals(this.dOv.name, str);
    }

    public boolean aRK() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.dOu.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.o.b a(@NonNull final com.baidu.swan.apps.o.b bVar) {
        return new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.o.b
            public void ay(@Nullable JSONObject jSONObject) {
                b.this.hr(true);
                bVar.ay(jSONObject);
            }

            @Override // com.baidu.swan.apps.o.b
            public void onFail(int i, @Nullable String str) {
                b.this.hr(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.dOu.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aGN = e.aGN();
        if (aGN != null) {
            return aGN.getAppKey();
        }
        return null;
    }
}
