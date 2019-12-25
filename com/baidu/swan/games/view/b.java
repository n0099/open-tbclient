package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class b {
    private ArrayList<a> coI = new ArrayList<>();

    /* loaded from: classes9.dex */
    public interface a {
        void GW();

        void dI(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.coI.contains(aVar)) {
            this.coI.add(aVar);
        }
    }

    public synchronized void hH(int i) {
        Iterator<a> it = this.coI.iterator();
        while (it.hasNext()) {
            it.next().dI(i);
        }
    }

    public synchronized void GW() {
        Iterator<a> it = this.coI.iterator();
        while (it.hasNext()) {
            it.next().GW();
        }
        this.coI.clear();
    }

    @Nullable
    public static b anH() {
        i iVar;
        e DP = f.Uf().DP();
        if (DP != null && (iVar = (i) DP.p(i.class)) != null) {
            return iVar.Mb();
        }
        return null;
    }
}
