package com.baidu.swan.apps.performance.a;

import android.os.Bundle;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes11.dex */
public class c implements com.baidu.swan.apps.as.d.b<HybridUbcFlow> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: a */
    public void D(HybridUbcFlow hybridUbcFlow) {
        hybridUbcFlow.jS("670").bb("preload_scene", "1").k("from", "swan").c("component_reporter", new com.baidu.swan.apps.performance.a()).c("component_reporter", new com.baidu.swan.apps.performance.d()).c("callback_on_submit", new d()).c("callback_on_submit", new com.baidu.swan.apps.as.d.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(HybridUbcFlow hybridUbcFlow2) {
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
                com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(20, bundle).ds(true));
            }
        });
    }
}
