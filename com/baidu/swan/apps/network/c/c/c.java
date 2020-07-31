package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes7.dex */
public class c implements com.baidu.swan.apps.aq.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c() {
        b.ann().reset();
        if (DEBUG) {
            Log.d("MaUpdateReporter", "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.b
    /* renamed from: b */
    public void H(HybridUbcFlow hybridUbcFlow) {
        if (DEBUG) {
            Log.i("MaUpdateReporter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null) {
            final UbcFlowEvent nf = hybridUbcFlow.nf("naStart");
            final UbcFlowEvent nf2 = hybridUbcFlow.nf("na_first_meaningful_paint");
            if (nf == null || nf2 == null) {
                if (DEBUG) {
                    if (nf == null) {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_start = null !!!");
                    } else {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_first_meaningful_paint = null !!!");
                    }
                }
                b.ann().done();
                return;
            }
            b.ann().a(new a() { // from class: com.baidu.swan.apps.network.c.c.c.1
                @Override // com.baidu.swan.apps.network.c.c.a
                public boolean a(d dVar) {
                    if (dVar != null) {
                        return c.this.a(dVar, nf, nf2);
                    }
                    return false;
                }
            });
            b.ann().a(hybridUbcFlow);
            if (DEBUG) {
                Log.d("MaUpdateReporter", "na_start ts - " + nf.aob());
                Log.d("MaUpdateReporter", "fmp_end ts - " + nf2.aob());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(@NonNull d dVar, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        long anp = dVar.anp();
        return anp >= ubcFlowEvent.aob() && anp <= ubcFlowEvent2.aob();
    }
}
