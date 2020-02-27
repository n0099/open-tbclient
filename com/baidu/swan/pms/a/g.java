package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.pms.c.c.a;
import java.util.Map;
import java.util.Set;
import okhttp3.Response;
/* loaded from: classes11.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> Po() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> Pp() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> Pq() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> Pr() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aab() {
        return null;
    }

    public a<a.C0364a> Pl() {
        return null;
    }

    public f Ps() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            aw(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void MZ() {
    }

    public void Pk() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void Pg() {
    }

    public void a(com.baidu.swan.pms.f.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void Pf() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aw(@Nullable String str, @Nullable String str2) {
    }

    public void a(Response response, int i, NetworkStatRecord networkStatRecord) {
    }

    public Map<String, String> atq() {
        return null;
    }

    public Map<String, String> atr() {
        return null;
    }

    public Map<String, String> ats() {
        return null;
    }
}
