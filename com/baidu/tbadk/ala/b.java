package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b ezE = null;
    private SparseArray<e> ezD = new SparseArray<>();

    private b() {
    }

    public static b bkP() {
        if (ezE == null) {
            synchronized (b.class) {
                if (ezE == null) {
                    ezE = new b();
                }
            }
        }
        return ezE;
    }

    public View z(Context context, int i) {
        if (this.ezD.get(i) == null) {
            return null;
        }
        return this.ezD.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.ezD.put(i, eVar);
    }
}
