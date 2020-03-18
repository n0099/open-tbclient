package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b cKg = null;
    private SparseArray<e> cKf = new SparseArray<>();

    private b() {
    }

    public static b ayE() {
        if (cKg == null) {
            synchronized (b.class) {
                if (cKg == null) {
                    cKg = new b();
                }
            }
        }
        return cKg;
    }

    public View u(Context context, int i) {
        if (this.cKf.get(i) == null) {
            return null;
        }
        return this.cKf.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.cKf.put(i, eVar);
    }
}
