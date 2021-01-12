package com.baidu.swan.pms.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.i;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> aqo() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> aql() {
        return null;
    }

    public c<i> atI() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> aqp() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> aqq() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aEr() {
        return null;
    }

    public a<a.C0542a> aqk() {
        return null;
    }

    public f aqr() {
        return null;
    }

    public com.baidu.swan.pms.node.d.c no(String str) {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            bv(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void ank() {
    }

    public void R(String str, int i) {
    }

    public void aqj() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void ani() {
    }

    public void a(com.baidu.swan.pms.utils.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aqe() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void bv(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> bcf() {
        return null;
    }

    public Map<String, String> bcg() {
        return null;
    }

    public Map<String, String> bch() {
        return null;
    }
}
