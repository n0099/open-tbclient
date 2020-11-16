package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.i;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> apJ() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> apG() {
        return null;
    }

    public c<i> atb() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> apK() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> apL() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aDJ() {
        return null;
    }

    public a<a.C0556a> apF() {
        return null;
    }

    public f apM() {
        return null;
    }

    public com.baidu.swan.pms.node.d.c nZ(String str) {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            bq(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void amK() {
    }

    public void P(String str, int i) {
    }

    public void apE() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void amI() {
    }

    public void a(com.baidu.swan.pms.utils.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void apz() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void bq(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> bax() {
        return null;
    }

    public Map<String, String> bay() {
        return null;
    }

    public Map<String, String> baz() {
        return null;
    }
}
