package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.model.i;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class f implements b {
    public a<com.baidu.swan.pms.model.f> Bs() {
        return null;
    }

    public a<h> Bt() {
        return null;
    }

    public a<com.baidu.swan.pms.model.d> Bu() {
        return null;
    }

    public a<com.baidu.swan.pms.model.b> Bv() {
        return null;
    }

    public a<i> RD() {
        return null;
    }

    public e Bw() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            X(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void zn() {
    }

    public void Br() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void Bn() {
    }

    public void a(com.baidu.swan.pms.e.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.b
    public void Wf() {
    }

    @Override // com.baidu.swan.pms.a.b
    public void X(@Nullable String str, @Nullable String str2) {
    }

    public Map<String, String> Wg() {
        return null;
    }

    public Map<String, String> Wh() {
        return null;
    }
}
