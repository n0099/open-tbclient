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
    public c<com.baidu.swan.pms.model.f> aui() {
        return null;
    }

    public c<com.baidu.swan.pms.model.g> auf() {
        return null;
    }

    public c<i> axB() {
        return null;
    }

    public c<com.baidu.swan.pms.model.d> auj() {
        return null;
    }

    public c<com.baidu.swan.pms.model.b> auk() {
        return null;
    }

    public c<com.baidu.swan.pms.model.h> aIk() {
        return null;
    }

    public a<a.C0559a> aue() {
        return null;
    }

    public f aul() {
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

    public void are() {
    }

    public void R(String str, int i) {
    }

    public void aud() {
    }

    public void b(com.baidu.swan.pms.model.a aVar) {
    }

    public void arc() {
    }

    public void a(com.baidu.swan.pms.utils.f fVar) {
    }

    @Override // com.baidu.swan.pms.a.d
    public void atY() {
    }

    @Override // com.baidu.swan.pms.a.d
    public void bw(@Nullable String str, @Nullable String str2) {
    }

    public void b(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, String> bfY() {
        return null;
    }

    public Map<String, String> bfZ() {
        return null;
    }

    public Map<String, String> bga() {
        return null;
    }
}
