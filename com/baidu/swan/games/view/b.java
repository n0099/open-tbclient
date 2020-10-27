package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class b {
    private ArrayList<a> dUy = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface a {
        void ahe();

        void hn(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.dUy.contains(aVar)) {
            this.dUy.add(aVar);
        }
    }

    public synchronized void mc(int i) {
        Iterator<a> it = this.dUy.iterator();
        while (it.hasNext()) {
            it.next().hn(i);
        }
    }

    public synchronized void ahe() {
        Iterator<a> it = this.dUy.iterator();
        while (it.hasNext()) {
            it.next().ahe();
        }
        this.dUy.clear();
    }

    @Nullable
    public static b aVA() {
        j jVar;
        f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null && (jVar = (j) adm.q(j.class)) != null) {
            return jVar.amZ();
        }
        return null;
    }
}
