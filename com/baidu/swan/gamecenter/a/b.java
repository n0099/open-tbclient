package com.baidu.swan.gamecenter.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.aw;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b implements aw {
    private HashMap<String, Boolean> edl = new HashMap<>();
    private a edm = new a();

    @Override // com.baidu.swan.apps.adaptation.a.aw
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (aTF()) {
            bVar.aH(null);
            return null;
        }
        return this.edm.b(jSONObject, a(bVar));
    }

    public boolean vX(String str) {
        return TextUtils.equals(this.edm.name, str);
    }

    public boolean aTF() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.edl.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.o.b a(@NonNull final com.baidu.swan.apps.o.b bVar) {
        return new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.o.b
            public void aH(@Nullable JSONObject jSONObject) {
                b.this.hW(true);
                bVar.aH(jSONObject);
            }

            @Override // com.baidu.swan.apps.o.b
            public void onFail(int i, @Nullable String str) {
                b.this.hW(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.edl.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aIO = e.aIO();
        if (aIO != null) {
            return aIO.getAppKey();
        }
        return null;
    }
}
