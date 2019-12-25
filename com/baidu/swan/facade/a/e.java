package com.baidu.swan.facade.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.swan.apps.scheme.j;
import java.util.Map;
/* loaded from: classes9.dex */
public class e implements com.baidu.swan.apps.w.b.d {
    @Override // com.baidu.swan.apps.w.b.d
    public void a(j jVar) {
        a.agE().a(jVar);
        a.agF().a(jVar);
    }

    @Override // com.baidu.swan.apps.w.b.d
    public Map<String, Object> a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        return new SwanApi$$ModulesProvider(bVar).getApiModules();
    }
}
