package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class b {
    private ArrayList<a> dxZ = new ArrayList<>();

    /* loaded from: classes8.dex */
    public interface a {
        void abP();

        void gw(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.dxZ.contains(aVar)) {
            this.dxZ.add(aVar);
        }
    }

    public synchronized void lj(int i) {
        Iterator<a> it = this.dxZ.iterator();
        while (it.hasNext()) {
            it.next().gw(i);
        }
    }

    public synchronized void abP() {
        Iterator<a> it = this.dxZ.iterator();
        while (it.hasNext()) {
            it.next().abP();
        }
        this.dxZ.clear();
    }

    @Nullable
    public static b aQl() {
        j jVar;
        f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null && (jVar = (j) XX.q(j.class)) != null) {
            return jVar.ahK();
        }
        return null;
    }
}
