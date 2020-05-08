package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private ArrayList<a> cSj = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Rx();

        void ee(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.cSj.contains(aVar)) {
            this.cSj.add(aVar);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized void m28if(int i) {
        Iterator<a> it = this.cSj.iterator();
        while (it.hasNext()) {
            it.next().ee(i);
        }
    }

    public synchronized void Rx() {
        Iterator<a> it = this.cSj.iterator();
        while (it.hasNext()) {
            it.next().Rx();
        }
        this.cSj.clear();
    }

    @Nullable
    public static b ayF() {
        i iVar;
        e Ot = f.aeJ().Ot();
        if (Ot != null && (iVar = (i) Ot.q(i.class)) != null) {
            return iVar.WE();
        }
        return null;
    }
}
