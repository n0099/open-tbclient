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
    public c<com.baidu.swan.pms.model.f> Pq() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> Pr() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> Ps() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> Pt() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aad() {
        return null;
    }

    public a<a.C0364a> Pn() {
        return null;
    }

    public f Pu() {
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

    public void Nb() {
    }

    public void Pm() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void Pi() {
    }

    public void a(com.baidu.swan.pms.f.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void Ph() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aw(@Nullable String str, @Nullable String str2) {
    }

    public void a(Response response, int i, NetworkStatRecord networkStatRecord) {
    }

    public Map<String, String> ats() {
        return null;
    }

    public Map<String, String> att() {
        return null;
    }

    public Map<String, String> atu() {
        return null;
    }
}
