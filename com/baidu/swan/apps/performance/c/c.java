package com.baidu.swan.apps.performance.c;

import android.os.Bundle;
import com.baidu.swan.apps.inlinewidget.f.b.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.a.f;
import com.baidu.swan.apps.performance.g;
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void M(HybridUbcFlow hybridUbcFlow) {
        hybridUbcFlow.qg("670").cb("preload_scene", "1").r("from", "swan").d("component_reporter", new com.baidu.swan.apps.performance.d()).d("component_reporter", new com.baidu.swan.apps.network.c.c.c()).d("component_reporter", new com.baidu.swan.apps.performance.a()).d("component_reporter", new g()).d("callback_on_submit", new b.a()).d("fmp_callback", new e("fmp_callback")).d("callback_on_submit", new e("callback_on_submit")).d("callback_on_submit", new com.baidu.swan.apps.ap.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(HybridUbcFlow hybridUbcFlow2) {
                if (!c.this.g(hybridUbcFlow2)) {
                    long t = hybridUbcFlow2.t("na_first_meaningful_paint", "naStart");
                    if (t <= 0) {
                        t = hybridUbcFlow2.t("na_first_paint", "naStart");
                    }
                    if (t <= 0) {
                        t = hybridUbcFlow2.t("slave_first_rendered", "naStart");
                    }
                    if (t <= 0) {
                        t = hybridUbcFlow2.t("fe_page_show", "naStart");
                    }
                    if (t <= 0) {
                        t = hybridUbcFlow2.t("na_page_show", "naStart");
                    }
                    if (t <= 0) {
                        t = hybridUbcFlow2.t("na_receive_intent", "naStart");
                    }
                    if (t <= 0) {
                        t = System.currentTimeMillis();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putLong("property_launch_cost", t);
                    com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(20, bundle).fK(true));
                    f.azv().bz(t);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(HybridUbcFlow hybridUbcFlow) {
        return hybridUbcFlow.oh("performanceEnd") && !hybridUbcFlow.oh("na_first_meaningful_paint");
    }
}
