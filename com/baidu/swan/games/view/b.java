package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private ArrayList<a> ctj = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void JM();

        void dZ(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.ctj.contains(aVar)) {
            this.ctj.add(aVar);
        }
    }

    public synchronized void hY(int i) {
        Iterator<a> it = this.ctj.iterator();
        while (it.hasNext()) {
            it.next().dZ(i);
        }
    }

    public synchronized void JM() {
        Iterator<a> it = this.ctj.iterator();
        while (it.hasNext()) {
            it.next().JM();
        }
        this.ctj.clear();
    }

    @Nullable
    public static b aqt() {
        i iVar;
        e GH = f.WV().GH();
        if (GH != null && (iVar = (i) GH.p(i.class)) != null) {
            return iVar.OQ();
        }
        return null;
    }
}
