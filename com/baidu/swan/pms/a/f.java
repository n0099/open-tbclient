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
    public a<com.baidu.swan.pms.model.f> Gn() {
        return null;
    }

    public a<h> Go() {
        return null;
    }

    public a<com.baidu.swan.pms.model.d> Gp() {
        return null;
    }

    public a<com.baidu.swan.pms.model.b> Gq() {
        return null;
    }

    public a<i> Wu() {
        return null;
    }

    public e Gr() {
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

    public void Ei() {
    }

    public void Gm() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void Gi() {
    }

    public void a(com.baidu.swan.pms.e.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.b
    public void aaU() {
    }

    @Override // com.baidu.swan.pms.a.b
    public void af(@Nullable String str, @Nullable String str2) {
    }

    public Map<String, String> aaV() {
        return null;
    }

    public Map<String, String> aaW() {
        return null;
    }
}
