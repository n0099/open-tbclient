package com.baidu.swan.apps.performance.c;

import android.os.Bundle;
import com.baidu.swan.apps.inlinewidget.f.b.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.a.f;
import com.baidu.swan.apps.performance.g;
/* loaded from: classes25.dex */
public class c implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void M(HybridUbcFlow hybridUbcFlow) {
        hybridUbcFlow.ro("670").co("preload_scene", "1").q("from", "swan").d("component_reporter", new com.baidu.swan.apps.performance.d()).d("component_reporter", new com.baidu.swan.apps.network.c.c.c()).d("component_reporter", new com.baidu.swan.apps.performance.a()).d("component_reporter", new g()).d("callback_on_submit", new b.a()).d("fmp_callback", new e("fmp_callback")).d("callback_on_submit", new e("callback_on_submit")).d("callback_on_submit", new com.baidu.swan.apps.ap.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(HybridUbcFlow hybridUbcFlow2) {
                if (!c.this.g(hybridUbcFlow2)) {
                    long u = hybridUbcFlow2.u("na_first_meaningful_paint", "naStart");
                    if (u <= 0) {
                        u = hybridUbcFlow2.u("na_first_paint", "naStart");
                    }
                    if (u <= 0) {
                        u = hybridUbcFlow2.u("slave_first_rendered", "naStart");
                    }
                    if (u <= 0) {
                        u = hybridUbcFlow2.u("fe_page_show", "naStart");
                    }
                    if (u <= 0) {
                        u = hybridUbcFlow2.u("na_page_show", "naStart");
                    }
                    if (u <= 0) {
                        u = hybridUbcFlow2.u("na_receive_intent", "naStart");
                    }
                    if (u <= 0) {
                        u = System.currentTimeMillis();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putLong("property_launch_cost", u);
                    com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(20, bundle).gy(true));
                    f.aGp().cw(u);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(HybridUbcFlow hybridUbcFlow) {
        return hybridUbcFlow.pq("performanceEnd") && !hybridUbcFlow.pq("na_first_meaningful_paint");
    }
}
