package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.pms.c.c.a;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> aaZ() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> aba() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> abb() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> abc() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> amX() {
        return null;
    }

    public a<a.C0462a> aaW() {
        return null;
    }

    public f abd() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            aW(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void YC() {
    }

    public void aaV() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void aaR() {
    }

    public void a(com.baidu.swan.pms.f.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aaQ() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aW(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> aGY() {
        return null;
    }

    public Map<String, String> aGZ() {
        return null;
    }

    public Map<String, String> aHa() {
        return null;
    }
}
