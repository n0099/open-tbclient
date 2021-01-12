package com.baidu.swan.apps.core.pms.b;

import android.os.Bundle;
import com.baidu.swan.apps.runtime.m;
import com.baidu.swan.pms.c.f;
import com.baidu.swan.pms.c.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class a extends m implements d {
    public a(com.baidu.swan.apps.runtime.d dVar) {
        super(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final Bundle A(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final Map<String, String> p(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null && !bundle.isEmpty()) {
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.getString(str));
            }
        }
        return hashMap;
    }

    @Override // com.baidu.swan.pms.c.f
    public void a(String str, Map<String, String> map, Map<String, String> map2, f.a aVar) {
        com.baidu.swan.pms.c.a.a(str, map, map2, new g(aVar));
    }

    @Override // com.baidu.swan.pms.c.f
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
        com.baidu.swan.pms.c.a.a(str, map, map2, jSONObject, new g(aVar));
    }
}
