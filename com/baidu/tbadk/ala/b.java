package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b cJV = null;
    private SparseArray<e> cJU = new SparseArray<>();

    private b() {
    }

    public static b ayB() {
        if (cJV == null) {
            synchronized (b.class) {
                if (cJV == null) {
                    cJV = new b();
                }
            }
        }
        return cJV;
    }

    public View u(Context context, int i) {
        if (this.cJU.get(i) == null) {
            return null;
        }
        return this.cJU.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.cJU.put(i, eVar);
    }
}
