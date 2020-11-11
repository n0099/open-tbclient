package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class b {
    private ArrayList<a> eaq = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface a {
        void ajE();

        void hx(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.eaq.contains(aVar)) {
            this.eaq.add(aVar);
        }
    }

    public synchronized void mm(int i) {
        Iterator<a> it = this.eaq.iterator();
        while (it.hasNext()) {
            it.next().hx(i);
        }
    }

    public synchronized void ajE() {
        Iterator<a> it = this.eaq.iterator();
        while (it.hasNext()) {
            it.next().ajE();
        }
        this.eaq.clear();
    }

    @Nullable
    public static b aYa() {
        j jVar;
        f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null && (jVar = (j) afM.q(j.class)) != null) {
            return jVar.apA();
        }
        return null;
    }
}
