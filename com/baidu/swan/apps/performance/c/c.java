package com.baidu.swan.apps.performance.c;

import android.os.Bundle;
import com.baidu.swan.apps.inlinewidget.f.b.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.a.f;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
/* loaded from: classes9.dex */
public class c implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public void L(HybridUbcFlow hybridUbcFlow) {
        hybridUbcFlow.rh("670").cn("preload_scene", "1").q("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME).d("component_reporter", new com.baidu.swan.apps.performance.d()).d("component_reporter", new com.baidu.swan.apps.network.c.c.c()).d("component_reporter", new com.baidu.swan.apps.performance.a()).d("component_reporter", new g()).d("callback_on_submit", new b.a()).d("fmp_callback", new e("fmp_callback")).d("callback_on_submit", new e("callback_on_submit")).d("callback_on_submit", new com.baidu.swan.apps.ao.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(HybridUbcFlow hybridUbcFlow2) {
                if (!c.this.g(hybridUbcFlow2)) {
                    long B = hybridUbcFlow2.B("na_first_meaningful_paint", "naStart");
                    if (B <= 0) {
                        B = hybridUbcFlow2.B("na_first_paint", "naStart");
                    }
                    if (B <= 0) {
                        B = hybridUbcFlow2.B("slave_first_rendered", "naStart");
                    }
                    if (B <= 0) {
                        B = hybridUbcFlow2.B("fe_page_show", "naStart");
                    }
                    if (B <= 0) {
                        B = hybridUbcFlow2.B("na_page_show", "naStart");
                    }
                    if (B <= 0) {
                        B = hybridUbcFlow2.B("na_receive_intent", "naStart");
                    }
                    if (B <= 0) {
                        B = System.currentTimeMillis();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putLong("property_launch_cost", B);
                    com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(20, bundle).gH(true));
                    f.aHI().cx(B);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(HybridUbcFlow hybridUbcFlow) {
        return hybridUbcFlow.pj("performanceEnd") && !hybridUbcFlow.pj("na_first_meaningful_paint");
    }
}
