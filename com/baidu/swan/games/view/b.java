package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.w.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private ArrayList<a> dhW = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Ve();

        void ex(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.dhW.contains(aVar)) {
            this.dhW.add(aVar);
        }
    }

    public synchronized void iJ(int i) {
        Iterator<a> it = this.dhW.iterator();
        while (it.hasNext()) {
            it.next().ex(i);
        }
    }

    public synchronized void Ve() {
        Iterator<a> it = this.dhW.iterator();
        while (it.hasNext()) {
            it.next().Ve();
        }
        this.dhW.clear();
    }

    @Nullable
    public static b aDD() {
        i iVar;
        e RN = f.ajb().RN();
        if (RN != null && (iVar = (i) RN.q(i.class)) != null) {
            return iVar.aaw();
        }
        return null;
    }
}
