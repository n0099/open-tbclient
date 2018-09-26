package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b acx = null;
    private SparseArray<d> acw = new SparseArray<>();

    private b() {
    }

    public static b sB() {
        if (acx == null) {
            synchronized (b.class) {
                if (acx == null) {
                    acx = new b();
                }
            }
        }
        return acx;
    }

    public View i(Context context, int i) {
        if (this.acw.get(i) == null) {
            return null;
        }
        return this.acw.get(i).createView(context);
    }

    public void a(int i, d dVar) {
        this.acw.put(i, dVar);
    }
}
