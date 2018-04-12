package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b Sh = null;
    private SparseArray<d> Sg = new SparseArray<>();

    private b() {
    }

    public static b os() {
        if (Sh == null) {
            synchronized (b.class) {
                if (Sh == null) {
                    Sh = new b();
                }
            }
        }
        return Sh;
    }

    public View f(Context context, int i) {
        if (this.Sg.get(i) == null) {
            return null;
        }
        return this.Sg.get(i).aq(context);
    }

    public void a(int i, d dVar) {
        this.Sg.put(i, dVar);
    }
}
