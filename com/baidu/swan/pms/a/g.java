package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.i;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public abstract class g implements d {
    public c<com.baidu.swan.pms.model.f> alW() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> alT() {
        return null;
    }

    public c<i> apo() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> alX() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> alY() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> azX() {
        return null;
    }

    public a<a.C0532a> alS() {
        return null;
    }

    public f alZ() {
        return null;
    }

    public com.baidu.swan.pms.node.d.c ny(String str) {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            bk(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void aiY() {
    }

    public void N(String str, int i) {
    }

    public void alR() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void aiW() {
    }

    public void a(com.baidu.swan.pms.utils.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void alM() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void bk(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> aWL() {
        return null;
    }

    public Map<String, String> aWM() {
        return null;
    }

    public Map<String, String> aWN() {
        return null;
    }
}
