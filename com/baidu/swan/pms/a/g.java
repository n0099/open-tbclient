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
    public c<com.baidu.swan.pms.model.f> ZT() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> ZU() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> ZV() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> ZW() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> alR() {
        return null;
    }

    public a<a.C0456a> ZQ() {
        return null;
    }

    public f ZX() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            aU(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void Xw() {
    }

    public void ZP() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void ZL() {
    }

    public void a(com.baidu.swan.pms.f.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void ZK() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aU(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> aFS() {
        return null;
    }

    public Map<String, String> aFT() {
        return null;
    }

    public Map<String, String> aFU() {
        return null;
    }
}
