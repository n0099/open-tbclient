package com.baidu.swan.games.view;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class b {
    private ArrayList<a> eoJ = new ArrayList<>();

    /* loaded from: classes9.dex */
    public interface a {
        void ano();

        void hL(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.eoJ.contains(aVar)) {
            this.eoJ.add(aVar);
        }
    }

    public synchronized void mO(int i) {
        Iterator<a> it = this.eoJ.iterator();
        while (it.hasNext()) {
            it.next().hL(i);
        }
    }

    public synchronized void ano() {
        Iterator<a> it = this.eoJ.iterator();
        while (it.hasNext()) {
            it.next().ano();
        }
        this.eoJ.clear();
    }

    @Nullable
    public static b bcR() {
        j jVar;
        f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
        if (ajs != null && (jVar = (j) ajs.j(j.class)) != null) {
            return jVar.atr();
        }
        return null;
    }
}
