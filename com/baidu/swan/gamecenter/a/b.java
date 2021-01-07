package com.baidu.swan.gamecenter.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.aw;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements aw {
    private HashMap<String, Boolean> eep = new HashMap<>();
    private a eeq = new a();

    @Override // com.baidu.swan.apps.adaptation.a.aw
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (aXk()) {
            bVar.aI(null);
            return null;
        }
        return this.eeq.b(jSONObject, a(bVar));
    }

    public boolean wI(String str) {
        return TextUtils.equals(this.eeq.name, str);
    }

    public boolean aXk() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.eep.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.o.b a(@NonNull final com.baidu.swan.apps.o.b bVar) {
        return new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.o.b
            public void aI(@Nullable JSONObject jSONObject) {
                b.this.hY(true);
                bVar.aI(jSONObject);
            }

            @Override // com.baidu.swan.apps.o.b
            public void onFail(int i, @Nullable String str) {
                b.this.hY(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.eep.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aMm = e.aMm();
        if (aMm != null) {
            return aMm.getAppKey();
        }
        return null;
    }
}
