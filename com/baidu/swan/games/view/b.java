package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes25.dex */
public class b {
    private ArrayList<a> efH = new ArrayList<>();

    /* loaded from: classes25.dex */
    public interface a {
        void ame();

        void hR(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.efH.contains(aVar)) {
            this.efH.add(aVar);
        }
    }

    public synchronized void mG(int i) {
        Iterator<a> it = this.efH.iterator();
        while (it.hasNext()) {
            it.next().hR(i);
        }
    }

    public synchronized void ame() {
        Iterator<a> it = this.efH.iterator();
        while (it.hasNext()) {
            it.next().ame();
        }
        this.efH.clear();
    }

    @Nullable
    public static b bax() {
        j jVar;
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null && (jVar = (j) aim.q(j.class)) != null) {
            return jVar.arZ();
        }
        return null;
    }
}
