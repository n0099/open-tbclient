package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b cJT = null;
    private SparseArray<e> cJS = new SparseArray<>();

    private b() {
    }

    public static b ayz() {
        if (cJT == null) {
            synchronized (b.class) {
                if (cJT == null) {
                    cJT = new b();
                }
            }
        }
        return cJT;
    }

    public View u(Context context, int i) {
        if (this.cJS.get(i) == null) {
            return null;
        }
        return this.cJS.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.cJS.put(i, eVar);
    }
}
