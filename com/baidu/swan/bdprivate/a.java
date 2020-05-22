package com.baidu.swan.bdprivate;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.bdprivate.api.SwanApi$$ModulesProvider;
import com.baidu.swan.bdprivate.d.a.d;
import com.baidu.swan.bdprivate.d.a.e;
import com.baidu.swan.bdprivate.d.a.f;
import com.baidu.swan.bdprivate.d.a.g;
import com.baidu.swan.bdprivate.d.a.h;
import com.baidu.swan.facade.a.c;
import java.util.Map;
/* loaded from: classes11.dex */
public class a implements c {
    @Override // com.baidu.swan.facade.a.d
    public void a(j jVar) {
        jVar.a(new com.baidu.swan.bdprivate.d.a.c(jVar));
        jVar.a(new f(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.f.a.c(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.f.a.b(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.c.a(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.c.b(jVar));
        jVar.a(new com.baidu.swan.apps.adlanding.a(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.e.c(jVar));
        jVar.a(new h(jVar));
        jVar.a(new e(jVar));
        jVar.a(new g(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.d.a(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.e.a(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.b.a(jVar));
        jVar.a(new d(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.a.b(jVar));
        jVar.a(new com.baidu.swan.bdprivate.d.a.a(jVar));
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
