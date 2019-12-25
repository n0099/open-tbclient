package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b cFD = null;
    private SparseArray<e> cFC = new SparseArray<>();

    private b() {
    }

    public static b avT() {
        if (cFD == null) {
            synchronized (b.class) {
                if (cFD == null) {
                    cFD = new b();
                }
            }
        }
        return cFD;
    }

    public View u(Context context, int i) {
        if (this.cFC.get(i) == null) {
            return null;
        }
        return this.cFC.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.cFC.put(i, eVar);
    }
}
