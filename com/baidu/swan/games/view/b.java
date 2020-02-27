package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private ArrayList<a> csW = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void JH();

        void dZ(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.csW.contains(aVar)) {
            this.csW.add(aVar);
        }
    }

    public synchronized void hY(int i) {
        Iterator<a> it = this.csW.iterator();
        while (it.hasNext()) {
            it.next().dZ(i);
        }
    }

    public synchronized void JH() {
        Iterator<a> it = this.csW.iterator();
        while (it.hasNext()) {
            it.next().JH();
        }
        this.csW.clear();
    }

    @Nullable
    public static b aqo() {
        i iVar;
        e GA = f.WQ().GA();
        if (GA != null && (iVar = (i) GA.p(i.class)) != null) {
            return iVar.OL();
        }
        return null;
    }
}
