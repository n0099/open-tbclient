package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class b {
    private ArrayList<a> dnR = new ArrayList<>();

    /* loaded from: classes7.dex */
    public interface a {
        void VJ();

        void ey(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.dnR.contains(aVar)) {
            this.dnR.add(aVar);
        }
    }

    public synchronized void ja(int i) {
        Iterator<a> it = this.dnR.iterator();
        while (it.hasNext()) {
            it.next().ey(i);
        }
    }

    public synchronized void VJ() {
        Iterator<a> it = this.dnR.iterator();
        while (it.hasNext()) {
            it.next().VJ();
        }
        this.dnR.clear();
    }

    @Nullable
    public static b aHt() {
        j jVar;
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null && (jVar = (j) Sc.q(j.class)) != null) {
            return jVar.aby();
        }
        return null;
    }
}
