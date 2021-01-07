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
    public c<com.baidu.swan.pms.model.f> auj() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> aug() {
        return null;
    }

    public c<i> axC() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> auk() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> aul() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aIl() {
        return null;
    }

    public a<a.C0559a> auf() {
        return null;
    }

    public f aum() {
        return null;
    }

    public com.baidu.swan.pms.node.d.c oB(String str) {
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            bw(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    public void arf() {
    }

    public void R(String str, int i) {
    }

    public void aue() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void ard() {
    }

    public void a(com.baidu.swan.pms.utils.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void atZ() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void bw(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> bfZ() {
        return null;
    }

    public Map<String, String> bga() {
        return null;
    }

    public Map<String, String> bgb() {
        return null;
    }
}
