package com.baidu.swan.games.view;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class b {
    private ArrayList<a> enE = new ArrayList<>();

    /* loaded from: classes8.dex */
    public interface a {
        void ajW();

        void gi(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.enE.contains(aVar)) {
            this.enE.add(aVar);
        }
    }

    public synchronized void lm(int i) {
        Iterator<a> it = this.enE.iterator();
        while (it.hasNext()) {
            it.next().gi(i);
        }
    }

    public synchronized void ajW() {
        Iterator<a> it = this.enE.iterator();
        while (it.hasNext()) {
            it.next().ajW();
        }
        this.enE.clear();
    }

    @Nullable
    public static b aZn() {
        j jVar;
        f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null && (jVar = (j) aga.j(j.class)) != null) {
            return jVar.apY();
        }
        return null;
    }
}
