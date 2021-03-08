package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b eIe = null;
    private SparseArray<e> eId = new SparseArray<>();

    private b() {
    }

    public static b bjS() {
        if (eIe == null) {
            synchronized (b.class) {
                if (eIe == null) {
                    eIe = new b();
                }
            }
        }
        return eIe;
    }

    public View A(Context context, int i) {
        if (this.eId.get(i) == null) {
            return null;
        }
        return this.eId.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.eId.put(i, eVar);
    }
}
