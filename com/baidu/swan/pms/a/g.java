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
    public c<com.baidu.swan.pms.model.f> Xi() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> Xj() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> Xk() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> Xl() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> ail() {
        return null;
    }

    public a<a.C0394a> Xf() {
        return null;
    }

    public f Xm() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            aE(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void UR() {
    }

    public void Xe() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void Xa() {
    }

    public void a(com.baidu.swan.pms.f.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void WZ() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aE(@Nullable String str, @Nullable String str2) {
    }

    public void a(Response response, int i, NetworkStatRecord networkStatRecord) {
    }

    public Map<String, String> aBF() {
        return null;
    }

    public Map<String, String> aBG() {
        return null;
    }

    public Map<String, String> aBH() {
        return null;
    }
}
