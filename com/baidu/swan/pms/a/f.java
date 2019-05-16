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
    public a<com.baidu.swan.pms.model.f> AG() {
        return null;
    }

    public a<h> AH() {
        return null;
    }

    public a<com.baidu.swan.pms.model.d> AI() {
        return null;
    }

    public a<com.baidu.swan.pms.model.b> AJ() {
        return null;
    }

    public a<i> QG() {
        return null;
    }

    public e AK() {
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

    public void yD() {
    }

    public void AF() {
    }

    public void a(com.baidu.swan.pms.model.a aVar) {
    }

    public void AB() {
    }

    public void a(com.baidu.swan.pms.e.e eVar) {
    }

    @Override // com.baidu.swan.pms.a.b
    public void Vi() {
    }

    @Override // com.baidu.swan.pms.a.b
    public void X(@Nullable String str, @Nullable String str2) {
    }

    public Map<String, String> Vj() {
        return null;
    }

    public Map<String, String> Vk() {
        return null;
    }
}
