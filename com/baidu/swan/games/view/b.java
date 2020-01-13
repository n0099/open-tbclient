package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class b {
    private ArrayList<a> coV = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface a {
        void Hs();

        void dJ(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.coV.contains(aVar)) {
            this.coV.add(aVar);
        }
    }

    public synchronized void hH(int i) {
        Iterator<a> it = this.coV.iterator();
        while (it.hasNext()) {
            it.next().dJ(i);
        }
    }

    public synchronized void Hs() {
        Iterator<a> it = this.coV.iterator();
        while (it.hasNext()) {
            it.next().Hs();
        }
        this.coV.clear();
    }

    @Nullable
    public static b aoa() {
        i iVar;
        e El = f.UC().El();
        if (El != null && (iVar = (i) El.p(i.class)) != null) {
            return iVar.Mx();
        }
        return null;
    }
}
