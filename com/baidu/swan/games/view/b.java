package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {
    private ArrayList<a> dAa = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface a {
        void acy();

        void gF(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.dAa.contains(aVar)) {
            this.dAa.add(aVar);
        }
    }

    public synchronized void lu(int i) {
        Iterator<a> it = this.dAa.iterator();
        while (it.hasNext()) {
            it.next().gF(i);
        }
    }

    public synchronized void acy() {
        Iterator<a> it = this.dAa.iterator();
        while (it.hasNext()) {
            it.next().acy();
        }
        this.dAa.clear();
    }

    @Nullable
    public static b aQX() {
        j jVar;
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null && (jVar = (j) YG.q(j.class)) != null) {
            return jVar.aiu();
        }
        return null;
    }
}
