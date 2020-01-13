package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b cFP = null;
    private SparseArray<e> cFO = new SparseArray<>();

    private b() {
    }

    public static b awm() {
        if (cFP == null) {
            synchronized (b.class) {
                if (cFP == null) {
                    cFP = new b();
                }
            }
        }
        return cFP;
    }

    public View u(Context context, int i) {
        if (this.cFO.get(i) == null) {
            return null;
        }
        return this.cFO.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.cFO.put(i, eVar);
    }
}
