package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.i;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> ajl() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> aji() {
        return null;
    }

    public c<i> amC() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> ajm() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> ajn() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> axm() {
        return null;
    }

    public a<a.C0515a> ajh() {
        return null;
    }

    public f ajo() {
        return null;
    }

    public com.baidu.swan.pms.node.d.c mM(String str) {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            bf(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void agn() {
    }

    public void M(String str, int i) {
    }

    public void ajg() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void agl() {
    }

    public void a(com.baidu.swan.pms.utils.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void ajb() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void bf(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> aUc() {
        return null;
    }

    public Map<String, String> aUd() {
        return null;
    }

    public Map<String, String> aUe() {
        return null;
    }
}
