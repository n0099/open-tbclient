package com.baidu.swan.gamecenter.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.aw;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements aw {
    private HashMap<String, Boolean> dnD = new HashMap<>();
    private a dnE = new a();

    @Override // com.baidu.swan.apps.adaptation.a.aw
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (aKE()) {
            bVar.al(null);
            return null;
        }
        return this.dnE.b(jSONObject, a(bVar));
    }

    public boolean uu(String str) {
        return TextUtils.equals(this.dnE.name, str);
    }

    public boolean aKE() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.dnD.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.o.b a(@NonNull final com.baidu.swan.apps.o.b bVar) {
        return new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.o.b
            public void al(@Nullable JSONObject jSONObject) {
                b.this.gx(true);
                bVar.al(jSONObject);
            }

            @Override // com.baidu.swan.apps.o.b
            public void onFail(int i, @Nullable String str) {
                b.this.gx(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.dnD.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e azJ = e.azJ();
        if (azJ != null) {
            return azJ.getAppKey();
        }
        return null;
    }
}
