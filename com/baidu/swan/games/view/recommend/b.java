package com.baidu.swan.games.view.recommend;

import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<RecommendButtonApiProxy> bEU = new ArrayList();

    public synchronized void a(RecommendButtonApiProxy recommendButtonApiProxy) {
        this.bEU.add(recommendButtonApiProxy);
    }

    public synchronized void b(RecommendButtonApiProxy recommendButtonApiProxy) {
        this.bEU.remove(recommendButtonApiProxy);
    }

    public synchronized void bQ(boolean z) {
        for (RecommendButtonApiProxy recommendButtonApiProxy : this.bEU) {
            recommendButtonApiProxy.bQ(z);
        }
    }

    public synchronized void destroy() {
        for (RecommendButtonApiProxy recommendButtonApiProxy : this.bEU) {
            recommendButtonApiProxy.Zd();
        }
        this.bEU.clear();
    }
}
