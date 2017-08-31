package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b Qu = null;
    private SparseArray<d> Qt = new SparseArray<>();

    private b() {
    }

    public static b nw() {
        if (Qu == null) {
            synchronized (b.class) {
                if (Qu == null) {
                    Qu = new b();
                }
            }
        }
        return Qu;
    }

    public View i(Context context, int i) {
        if (this.Qt.get(i) == null) {
            return null;
        }
        return this.Qt.get(i).aw(context);
    }

    public void a(int i, d dVar) {
        this.Qt.put(i, dVar);
    }
}
