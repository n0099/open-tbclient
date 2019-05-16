package com.baidu.swan.games.view.recommend;

import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<RecommendButtonApiProxy> blN = new ArrayList();

    public synchronized void a(RecommendButtonApiProxy recommendButtonApiProxy) {
        this.blN.add(recommendButtonApiProxy);
    }

    public synchronized void b(RecommendButtonApiProxy recommendButtonApiProxy) {
        this.blN.remove(recommendButtonApiProxy);
    }

    public synchronized void bv(boolean z) {
        for (RecommendButtonApiProxy recommendButtonApiProxy : this.blN) {
            recommendButtonApiProxy.bv(z);
        }
    }

    public synchronized void destroy() {
        for (RecommendButtonApiProxy recommendButtonApiProxy : this.blN) {
            recommendButtonApiProxy.Tu();
        }
        this.blN.clear();
    }
}
