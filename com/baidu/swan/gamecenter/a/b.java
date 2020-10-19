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
    private HashMap<String, Boolean> dBN = new HashMap<>();
    private a dBO = new a();

    @Override // com.baidu.swan.apps.adaptation.a.aw
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (aNY()) {
            bVar.av(null);
            return null;
        }
        return this.dBO.b(jSONObject, a(bVar));
    }

    public boolean vA(String str) {
        return TextUtils.equals(this.dBO.name, str);
    }

    public boolean aNY() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.dBN.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.o.b a(@NonNull final com.baidu.swan.apps.o.b bVar) {
        return new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.o.b
            public void av(@Nullable JSONObject jSONObject) {
                b.this.gS(true);
                bVar.av(jSONObject);
            }

            @Override // com.baidu.swan.apps.o.b
            public void onFail(int i, @Nullable String str) {
                b.this.gS(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gS(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.dBN.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aDb = e.aDb();
        if (aDb != null) {
            return aDb.getAppKey();
        }
        return null;
    }
}
