package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b eJh = null;
    private SparseArray<e> eJg = new SparseArray<>();

    private b() {
    }

    public static b bnp() {
        if (eJh == null) {
            synchronized (b.class) {
                if (eJh == null) {
                    eJh = new b();
                }
            }
        }
        return eJh;
    }

    public View A(Context context, int i) {
        if (this.eJg.get(i) == null) {
            return null;
        }
        return this.eJg.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.eJg.put(i, eVar);
    }
}
