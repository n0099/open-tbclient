package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b PY = null;
    private SparseArray<e> PX = new SparseArray<>();

    private b() {
    }

    public static b nz() {
        if (PY == null) {
            synchronized (b.class) {
                if (PY == null) {
                    PY = new b();
                }
            }
        }
        return PY;
    }

    public View h(Context context, int i) {
        if (this.PX.get(i) == null) {
            return null;
        }
        return this.PX.get(i).aq(context);
    }

    public void a(int i, e eVar) {
        this.PX.put(i, eVar);
    }
}
