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
    public c<com.baidu.swan.pms.model.f> asR() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> asO() {
        return null;
    }

    public c<i> awj() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> asS() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> asT() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aGR() {
        return null;
    }

    public a<a.C0568a> asN() {
        return null;
    }

    public f asU() {
        return null;
    }

    public com.baidu.swan.pms.node.d.c oI(String str) {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            bx(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void apS() {
    }

    public void Q(String str, int i) {
    }

    public void asM() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void apQ() {
    }

    public void a(com.baidu.swan.pms.utils.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void asH() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void bx(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> bdC() {
        return null;
    }

    public Map<String, String> bdD() {
        return null;
    }

    public Map<String, String> bdE() {
        return null;
    }
}
