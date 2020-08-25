package com.baidu.swan.facade.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.scheme.j;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
public class e implements com.baidu.swan.apps.t.b.c {
    @Override // com.baidu.swan.apps.t.b.c
    public void a(j jVar) {
        a.aHf().a(jVar);
        a.aHg().a(jVar);
    }

    @Override // com.baidu.swan.apps.t.b.c
    public Map<String, Object> getWebviewApiModules(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        Map<String, Object> webviewApiModules = a.aHf().getWebviewApiModules(bVar);
        Map<String, Object> webviewApiModules2 = a.aHg().getWebviewApiModules(bVar);
        HashMap hashMap = new HashMap();
        if (webviewApiModules != null) {
            hashMap.putAll(webviewApiModules);
        }
        if (webviewApiModules2 != null) {
            hashMap.putAll(webviewApiModules2);
        }
        return hashMap;
    }

    @Override // com.baidu.swan.apps.t.b.c
    public Map<String, Object> getV8ApiModules(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        Map<String, Object> v8ApiModules = a.aHf().getV8ApiModules(bVar);
        Map<String, Object> v8ApiModules2 = a.aHg().getV8ApiModules(bVar);
        HashMap hashMap = new HashMap();
        if (v8ApiModules != null) {
            hashMap.putAll(v8ApiModules);
        }
        if (v8ApiModules2 != null) {
            hashMap.putAll(v8ApiModules2);
        }
        return hashMap;
    }
}
