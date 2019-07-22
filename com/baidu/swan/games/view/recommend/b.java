package com.baidu.swan.games.view.recommend;

import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<RecommendButtonApiProxy> bmB = new ArrayList();

    public synchronized void a(RecommendButtonApiProxy recommendButtonApiProxy) {
        this.bmB.add(recommendButtonApiProxy);
    }

    public synchronized void b(RecommendButtonApiProxy recommendButtonApiProxy) {
        this.bmB.remove(recommendButtonApiProxy);
    }

    public synchronized void by(boolean z) {
        for (RecommendButtonApiProxy recommendButtonApiProxy : this.bmB) {
            recommendButtonApiProxy.by(z);
        }
    }

    public synchronized void destroy() {
        for (RecommendButtonApiProxy recommendButtonApiProxy : this.bmB) {
            recommendButtonApiProxy.Um();
        }
        this.bmB.clear();
    }
}
