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
    private HashMap<String, Boolean> dQc = new HashMap<>();
    private a dQd = new a();

    @Override // com.baidu.swan.apps.adaptation.a.aw
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (aSs()) {
            bVar.aE(null);
            return null;
        }
        return this.dQd.b(jSONObject, a(bVar));
    }

    public boolean wh(String str) {
        return TextUtils.equals(this.dQd.name, str);
    }

    public boolean aSs() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.dQc.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.o.b a(@NonNull final com.baidu.swan.apps.o.b bVar) {
        return new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.o.b
            public void aE(@Nullable JSONObject jSONObject) {
                b.this.ho(true);
                bVar.aE(jSONObject);
            }

            @Override // com.baidu.swan.apps.o.b
            public void onFail(int i, @Nullable String str) {
                b.this.ho(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.dQc.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aHv = e.aHv();
        if (aHv != null) {
            return aHv.getAppKey();
        }
        return null;
    }
}
