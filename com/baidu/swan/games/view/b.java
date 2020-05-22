package com.baidu.swan.games.view;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.w.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private ArrayList<a> ddk = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void TY();

        void ek(int i);
    }

    public synchronized void a(a aVar) {
        if (!this.ddk.contains(aVar)) {
            this.ddk.add(aVar);
        }
    }

    public synchronized void iw(int i) {
        Iterator<a> it = this.ddk.iterator();
        while (it.hasNext()) {
            it.next().ek(i);
        }
    }

    public synchronized void TY() {
        Iterator<a> it = this.ddk.iterator();
        while (it.hasNext()) {
            it.next().TY();
        }
        this.ddk.clear();
    }

    @Nullable
    public static b aCx() {
        i iVar;
        e QH = f.ahV().QH();
        if (QH != null && (iVar = (i) QH.q(i.class)) != null) {
            return iVar.Zq();
        }
        return null;
    }
}
