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
    public c<com.baidu.swan.pms.model.f> aqM() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> aqJ() {
        return null;
    }

    public c<i> aug() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> aqN() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> aqO() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aEM() {
        return null;
    }

    public a<a.C0539a> aqI() {
        return null;
    }

    public f aqP() {
        return null;
    }

    public com.baidu.swan.pms.node.d.c nG(String str) {
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

    public void anI() {
    }

    public void T(String str, int i) {
    }

    public void aqH() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void anG() {
    }

    public void a(com.baidu.swan.pms.utils.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void aqC() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void bp(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> bcs() {
        return null;
    }

    public Map<String, String> bct() {
        return null;
    }

    public Map<String, String> bcu() {
        return null;
    }
}
