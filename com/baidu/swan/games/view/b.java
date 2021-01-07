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
        void anp();

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

    public synchronized void anp() {
        Iterator<a> it = this.eoJ.iterator();
        while (it.hasNext()) {
            it.next().anp();
        }
        this.eoJ.clear();
    }

    @Nullable
    public static b bcS() {
        j jVar;
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null && (jVar = (j) ajt.j(j.class)) != null) {
            return jVar.ats();
        }
        return null;
    }
}
