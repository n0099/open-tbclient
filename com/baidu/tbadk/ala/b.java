package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b bAQ = null;
    private SparseArray<e> bAP = new SparseArray<>();

    private b() {
    }

    public static b aak() {
        if (bAQ == null) {
            synchronized (b.class) {
                if (bAQ == null) {
                    bAQ = new b();
                }
            }
        }
        return bAQ;
    }

    public View n(Context context, int i) {
        if (this.bAP.get(i) == null) {
            return null;
        }
        return this.bAP.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.bAP.put(i, eVar);
    }
}
