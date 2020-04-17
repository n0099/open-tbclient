package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private ArrayList<a> cSe = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Ry();

        void ee(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.cSe.contains(aVar)) {
            this.cSe.add(aVar);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized void m28if(int i) {
        Iterator<a> it = this.cSe.iterator();
        while (it.hasNext()) {
            it.next().ee(i);
        }
    }

    public synchronized void Ry() {
        Iterator<a> it = this.cSe.iterator();
        while (it.hasNext()) {
            it.next().Ry();
        }
        this.cSe.clear();
    }

    @Nullable
    public static b ayF() {
        i iVar;
        e Ou = f.aeK().Ou();
        if (Ou != null && (iVar = (i) Ou.q(i.class)) != null) {
            return iVar.WF();
        }
        return null;
    }
}
