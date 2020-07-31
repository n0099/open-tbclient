package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b dIt = null;
    private SparseArray<e> dIs = new SparseArray<>();

    private b() {
    }

    public static b aSa() {
        if (dIt == null) {
            synchronized (b.class) {
                if (dIt == null) {
                    dIt = new b();
                }
            }
        }
        return dIt;
    }

    public View p(Context context, int i) {
        if (this.dIs.get(i) == null) {
            return null;
        }
        return this.dIs.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.dIs.put(i, eVar);
    }
}
