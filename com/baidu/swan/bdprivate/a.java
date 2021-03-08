package com.baidu.swan.bdprivate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.bdprivate.api.SwanApi$$ModulesProvider;
import com.baidu.swan.bdprivate.extensions.a.d;
import com.baidu.swan.bdprivate.extensions.a.e;
import com.baidu.swan.bdprivate.extensions.a.f;
import com.baidu.swan.bdprivate.extensions.a.g;
import com.baidu.swan.bdprivate.extensions.a.h;
import com.baidu.swan.bdprivate.extensions.a.i;
import com.baidu.swan.facade.a.c;
import java.util.Map;
/* loaded from: classes8.dex */
public class a implements c {
    @Override // com.baidu.swan.facade.a.d
    public void a(j jVar) {
        jVar.a(new com.baidu.swan.bdprivate.extensions.a.c(jVar));
        jVar.a(new g(jVar));
        jVar.a(new com.baidu.swan.bdprivate.extensions.g.a.c(jVar));
        jVar.a(new com.baidu.swan.bdprivate.extensions.g.a.b(jVar));
        jVar.a(new com.baidu.swan.bdprivate.extensions.c.b(jVar));
        jVar.a(new com.baidu.swan.apps.adlanding.a(jVar));
        jVar.a(new com.baidu.swan.bdprivate.extensions.e.c(jVar));
        jVar.a(new i(jVar));
        jVar.a(new e(jVar));
        jVar.a(new h(jVar));
        jVar.a(new com.baidu.swan.bdprivate.extensions.d.a(jVar));
        jVar.a(new com.baidu.swan.bdprivate.extensions.e.a(jVar));
        jVar.a(new com.baidu.swan.bdprivate.extensions.b.a(jVar));
        jVar.a(new d(jVar));
        jVar.a(new com.baidu.swan.bdprivate.extensions.a.b(jVar));
        jVar.a(new com.baidu.swan.bdprivate.extensions.a.a(jVar));
        jVar.a(new f(jVar));
    }

    @Override // com.baidu.swan.facade.a.d
    @Nullable
    public Map<String, Object> getWebviewApiModules(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        return SwanApi$$ModulesProvider.getWebviewApiModules(bVar);
    }

    @Override // com.baidu.swan.facade.a.d
    @Nullable
    public Map<String, Object> getV8ApiModules(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        return SwanApi$$ModulesProvider.getV8ApiModules(bVar);
    }
}
