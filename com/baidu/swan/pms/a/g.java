package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.pms.c.c.a;
import java.util.Map;
import java.util.Set;
import okhttp3.Response;
/* loaded from: classes10.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> Na() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> Nb() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> Nc() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> Nd() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> XN() {
        return null;
    }

    public a<a.C0354a> MX() {
        return null;
    }

    public f Ne() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            am(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void KK() {
    }

    public void MW() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void MS() {
    }

    public void a(com.baidu.swan.pms.f.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void MR() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void am(@Nullable String str, @Nullable String str2) {
    }

    public void a(Response response, int i, NetworkStatRecord networkStatRecord) {
    }

    public Map<String, String> arc() {
        return null;
    }

    public Map<String, String> ard() {
        return null;
    }

    public Map<String, String> are() {
        return null;
    }
}
