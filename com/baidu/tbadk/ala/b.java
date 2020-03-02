package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b cJU = null;
    private SparseArray<e> cJT = new SparseArray<>();

    private b() {
    }

    public static b ayB() {
        if (cJU == null) {
            synchronized (b.class) {
                if (cJU == null) {
                    cJU = new b();
                }
            }
        }
        return cJU;
    }

    public View u(Context context, int i) {
        if (this.cJT.get(i) == null) {
            return null;
        }
        return this.cJT.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.cJT.put(i, eVar);
    }
}
