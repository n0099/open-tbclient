package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class b {
    private ArrayList<a> dYI = new ArrayList<>();

    /* loaded from: classes7.dex */
    public interface a {
        void aiW();

        void ht(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.dYI.contains(aVar)) {
            this.dYI.add(aVar);
        }
    }

    public synchronized void mi(int i) {
        Iterator<a> it = this.dYI.iterator();
        while (it.hasNext()) {
            it.next().ht(i);
        }
    }

    public synchronized void aiW() {
        Iterator<a> it = this.dYI.iterator();
        while (it.hasNext()) {
            it.next().aiW();
        }
        this.dYI.clear();
    }

    @Nullable
    public static b aXs() {
        j jVar;
        f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null && (jVar = (j) afe.q(j.class)) != null) {
            return jVar.aoR();
        }
        return null;
    }
}
