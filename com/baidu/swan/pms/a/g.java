package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.pms.c.c.a;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> acc() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> abZ() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> acd() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> ace() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aoG() {
        return null;
    }

    public a<a.C0474a> abY() {
        return null;
    }

    public f acf() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            aY(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void Zu() {
    }

    public void abX() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void Zs() {
    }

    public void a(com.baidu.swan.pms.f.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void abS() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aY(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> aKP() {
        return null;
    }

    public Map<String, String> aKQ() {
        return null;
    }

    public Map<String, String> aKR() {
        return null;
    }
}
