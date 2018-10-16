package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b ahw = null;
    private SparseArray<e> ahv = new SparseArray<>();

    private b() {
    }

    public static b uL() {
        if (ahw == null) {
            synchronized (b.class) {
                if (ahw == null) {
                    ahw = new b();
                }
            }
        }
        return ahw;
    }

    public View j(Context context, int i) {
        if (this.ahv.get(i) == null) {
            return null;
        }
        return this.ahv.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.ahv.put(i, eVar);
    }
}
