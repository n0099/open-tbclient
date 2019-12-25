package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.pms.c.c.a;
import java.util.Map;
import java.util.Set;
import okhttp3.Response;
/* loaded from: classes9.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> ME() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> MF() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> MG() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> MH() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> Xq() {
        return null;
    }

    public a<a.C0352a> MB() {
        return null;
    }

    public f MI() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            al(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void Ko() {
    }

    public void MA() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void Mw() {
    }

    public void a(com.baidu.swan.pms.f.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void Mv() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void al(@Nullable String str, @Nullable String str2) {
    }

    public void a(Response response, int i, NetworkStatRecord networkStatRecord) {
    }

    public Map<String, String> aqJ() {
        return null;
    }

    public Map<String, String> aqK() {
        return null;
    }

    public Map<String, String> aqL() {
        return null;
    }
}
