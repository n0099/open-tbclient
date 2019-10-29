package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b bTW = null;
    private SparseArray<e> bTV = new SparseArray<>();

    private b() {
    }

    public static b afc() {
        if (bTW == null) {
            synchronized (b.class) {
                if (bTW == null) {
                    bTW = new b();
                }
            }
        }
        return bTW;
    }

    public View l(Context context, int i) {
        if (this.bTV.get(i) == null) {
            return null;
        }
        return this.bTV.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.bTV.put(i, eVar);
    }
}
