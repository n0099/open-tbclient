package com.baidu.swan.apps.v.a;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.b.e;
/* loaded from: classes8.dex */
class b implements a {
    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        a(new com.baidu.swan.config.e.a<e>() { // from class: com.baidu.swan.apps.v.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.config.e.a
            /* renamed from: e */
            public void run(@NonNull e eVar) {
                eVar.ajd();
            }
        });
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        a(new com.baidu.swan.config.e.a<e>() { // from class: com.baidu.swan.apps.v.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.config.e.a
            /* renamed from: e */
            public void run(@NonNull e eVar) {
                eVar.aje();
            }
        });
    }

    private void a(@NonNull com.baidu.swan.config.e.a<e> aVar) {
        for (e eVar : com.baidu.swan.apps.core.turbo.d.ash().asf().values()) {
            if (eVar != null) {
                aVar.run(eVar);
            }
        }
    }
}
