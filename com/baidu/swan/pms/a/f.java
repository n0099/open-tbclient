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
    public a<com.baidu.swan.pms.model.f> Go() {
        return null;
    }

    public a<h> Gp() {
        return null;
    }

    public a<com.baidu.swan.pms.model.d> Gq() {
        return null;
    }

    public a<com.baidu.swan.pms.model.b> Gr() {
        return null;
    }

    public a<i> Ws() {
        return null;
    }

    public e Gs() {
        return null;
    }

    @Override // com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            af(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void Ej() {
    }

    public void Gn() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void Gj() {
    }

    public void a(com.baidu.swan.pms.e.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.b
    public void aaS() {
    }

    @Override // com.baidu.swan.pms.a.b
    public void af(@Nullable String str, @Nullable String str2) {
    }

    public Map<String, String> aaT() {
        return null;
    }

    public Map<String, String> aaU() {
        return null;
    }
}
