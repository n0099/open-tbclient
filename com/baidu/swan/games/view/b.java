package com.baidu.swan.games.view;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class b {
    private ArrayList<a> ejU = new ArrayList<>();

    /* loaded from: classes8.dex */
    public interface a {
        void ajv();

        void ge(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.ejU.contains(aVar)) {
            this.ejU.add(aVar);
        }
    }

    public synchronized void li(int i) {
        Iterator<a> it = this.ejU.iterator();
        while (it.hasNext()) {
            it.next().ge(i);
        }
    }

    public synchronized void ajv() {
        Iterator<a> it = this.ejU.iterator();
        while (it.hasNext()) {
            it.next().ajv();
        }
        this.ejU.clear();
    }

    @Nullable
    public static b aYY() {
        j jVar;
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null && (jVar = (j) afz.j(j.class)) != null) {
            return jVar.apx();
        }
        return null;
    }
}
