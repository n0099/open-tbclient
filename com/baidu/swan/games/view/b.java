package com.baidu.swan.games.view;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.d.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class b {
    private ArrayList<a> emb = new ArrayList<>();

    /* loaded from: classes9.dex */
    public interface a {
        void ajT();

        void gh(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.emb.contains(aVar)) {
            this.emb.add(aVar);
        }
    }

    public synchronized void ll(int i) {
        Iterator<a> it = this.emb.iterator();
        while (it.hasNext()) {
            it.next().gh(i);
        }
    }

    public synchronized void ajT() {
        Iterator<a> it = this.emb.iterator();
        while (it.hasNext()) {
            it.next().ajT();
        }
        this.emb.clear();
    }

    @Nullable
    public static b aZk() {
        j jVar;
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null && (jVar = (j) afX.j(j.class)) != null) {
            return jVar.apV();
        }
        return null;
    }
}
