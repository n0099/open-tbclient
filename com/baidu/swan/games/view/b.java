package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private ArrayList<a> csX = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void JJ();

        void dZ(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.csX.contains(aVar)) {
            this.csX.add(aVar);
        }
    }

    public synchronized void hY(int i) {
        Iterator<a> it = this.csX.iterator();
        while (it.hasNext()) {
            it.next().dZ(i);
        }
    }

    public synchronized void JJ() {
        Iterator<a> it = this.csX.iterator();
        while (it.hasNext()) {
            it.next().JJ();
        }
        this.csX.clear();
    }

    @Nullable
    public static b aqq() {
        i iVar;
        e GC = f.WS().GC();
        if (GC != null && (iVar = (i) GC.p(i.class)) != null) {
            return iVar.ON();
        }
        return null;
    }
}
