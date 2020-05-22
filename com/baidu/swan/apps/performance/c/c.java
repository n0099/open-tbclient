package com.baidu.swan.apps.performance.c;

import android.os.Bundle;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.a.f;
import com.baidu.swan.apps.performance.e;
/* loaded from: classes11.dex */
public class c implements com.baidu.swan.apps.aq.e.b<HybridUbcFlow> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.b
    /* renamed from: a */
    public void H(HybridUbcFlow hybridUbcFlow) {
        hybridUbcFlow.mt("670").bD("preload_scene", "1").r("from", "swan").c("component_reporter", new com.baidu.swan.apps.performance.a()).c("component_reporter", new e()).c("callback_on_submit", new d()).c("callback_on_submit", new com.baidu.swan.apps.aq.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(HybridUbcFlow hybridUbcFlow2) {
                long s = hybridUbcFlow2.s("na_first_meaningful_paint", "naStart");
                if (s <= 0) {
                    s = hybridUbcFlow2.s("na_first_paint", "naStart");
                }
                if (s <= 0) {
                    s = hybridUbcFlow2.s("slave_first_rendered", "naStart");
                }
                if (s <= 0) {
                    s = hybridUbcFlow2.s("fe_page_show", "naStart");
                }
                if (s <= 0) {
                    s = hybridUbcFlow2.s("na_page_show", "naStart");
                }
                if (s <= 0) {
                    s = hybridUbcFlow2.s("na_receive_intent", "naStart");
                }
                if (s <= 0) {
                    s = System.currentTimeMillis();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("property_launch_cost", s);
                com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(20, bundle).eI(true));
                f.alH().bh(s);
            }
        });
    }
}
