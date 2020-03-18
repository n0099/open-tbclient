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
    public c<com.baidu.swan.pms.model.f> Pt() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> Pu() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> Pv() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> Pw() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aag() {
        return null;
    }

    public a<a.C0364a> Pq() {
        return null;
    }

    public f Px() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            av(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void Ne() {
    }

    public void Pp() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void Pl() {
    }

    public void a(com.baidu.swan.pms.f.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void Pk() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void av(@Nullable String str, @Nullable String str2) {
    }

    public void a(Response response, int i, NetworkStatRecord networkStatRecord) {
    }

    public Map<String, String> atv() {
        return null;
    }

    public Map<String, String> atw() {
        return null;
    }

    public Map<String, String> atx() {
        return null;
    }
}
