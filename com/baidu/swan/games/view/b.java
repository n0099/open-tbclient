package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class b {
    private ArrayList<a> dMb = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface a {
        void afk();

        void hc(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.dMb.contains(aVar)) {
            this.dMb.add(aVar);
        }
    }

    public synchronized void lR(int i) {
        Iterator<a> it = this.dMb.iterator();
        while (it.hasNext()) {
            it.next().hc(i);
        }
    }

    public synchronized void afk() {
        Iterator<a> it = this.dMb.iterator();
        while (it.hasNext()) {
            it.next().afk();
        }
        this.dMb.clear();
    }

    @Nullable
    public static b aTG() {
        j jVar;
        f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null && (jVar = (j) abs.q(j.class)) != null) {
            return jVar.alf();
        }
        return null;
    }
}
