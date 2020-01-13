package com.baidu.swan.apps.performance.a;

import android.os.Bundle;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.apps.as.d.b<HybridUbcFlow> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: a */
    public void B(HybridUbcFlow hybridUbcFlow) {
        hybridUbcFlow.jD("670").aS("preload_scene", "1").k("from", "swan").c("component_reporter", new com.baidu.swan.apps.performance.a()).c("component_reporter", new com.baidu.swan.apps.performance.d()).c("callback_on_submit", new d()).c("callback_on_submit", new com.baidu.swan.apps.as.d.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(HybridUbcFlow hybridUbcFlow2) {
                long o = hybridUbcFlow2.o("na_first_meaningful_paint", "naStart");
                if (o <= 0) {
                    o = hybridUbcFlow2.o("na_first_paint", "naStart");
                }
                if (o <= 0) {
                    o = hybridUbcFlow2.o("slave_first_rendered", "naStart");
                }
                if (o <= 0) {
                    o = hybridUbcFlow2.o("fe_page_show", "naStart");
                }
                if (o <= 0) {
                    o = hybridUbcFlow2.o("na_page_show", "naStart");
                }
                if (o <= 0) {
                    o = hybridUbcFlow2.o("na_receive_intent", "naStart");
                }
                if (o <= 0) {
                    o = System.currentTimeMillis();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("property_launch_cost", o);
                com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(20, bundle).dl(true));
            }
        });
    }
}
