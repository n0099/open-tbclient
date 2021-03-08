package com.baidu.swan.pms.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.i;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> aqP() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> aqM() {
        return null;
    }

    public c<i> auj() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> aqQ() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> aqR() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aEP() {
        return null;
    }

    public a<a.C0545a> aqL() {
        return null;
    }

    public f aqS() {
        return null;
    }

    public com.baidu.swan.pms.node.d.c nN(String str) {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            bp(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void anL() {
    }

    public void U(String str, int i) {
    }

    public void aqK() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void anJ() {
    }

    public void a(com.baidu.swan.pms.utils.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aqF() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void bp(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> bcu() {
        return null;
    }

    public Map<String, String> bcv() {
        return null;
    }

    public Map<String, String> bcw() {
        return null;
    }
}
