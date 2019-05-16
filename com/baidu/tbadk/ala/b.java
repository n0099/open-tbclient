package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b bzT = null;
    private SparseArray<e> bzS = new SparseArray<>();

    private b() {
    }

    public static b Zl() {
        if (bzT == null) {
            synchronized (b.class) {
                if (bzT == null) {
                    bzT = new b();
                }
            }
        }
        return bzT;
    }

    public View n(Context context, int i) {
        if (this.bzS.get(i) == null) {
            return null;
        }
        return this.bzS.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.bzS.put(i, eVar);
    }
}
