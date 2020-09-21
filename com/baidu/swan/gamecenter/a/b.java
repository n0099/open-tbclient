package com.baidu.swan.gamecenter.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.adaptation.a.aw;
import com.baidu.swan.apps.runtime.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b implements aw {
    private HashMap<String, Boolean> dpJ = new HashMap<>();
    private a dpK = new a();

    @Override // com.baidu.swan.apps.adaptation.a.aw
    @Nullable
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (aLp()) {
            bVar.ao(null);
            return null;
        }
        return this.dpK.b(jSONObject, a(bVar));
    }

    public boolean uO(String str) {
        return TextUtils.equals(this.dpK.name, str);
    }

    public boolean aLp() {
        Boolean bool;
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey) && (bool = this.dpJ.get(appKey)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private com.baidu.swan.apps.o.b a(@NonNull final com.baidu.swan.apps.o.b bVar) {
        return new com.baidu.swan.apps.o.b() { // from class: com.baidu.swan.gamecenter.a.b.1
            @Override // com.baidu.swan.apps.o.b
            public void ao(@Nullable JSONObject jSONObject) {
                b.this.gw(true);
                bVar.ao(jSONObject);
            }

            @Override // com.baidu.swan.apps.o.b
            public void onFail(int i, @Nullable String str) {
                b.this.gw(false);
                bVar.onFail(i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(boolean z) {
        String appKey = getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            this.dpJ.put(appKey, Boolean.valueOf(z));
        }
    }

    private String getAppKey() {
        e aAs = e.aAs();
        if (aAs != null) {
            return aAs.getAppKey();
        }
        return null;
    }
}
