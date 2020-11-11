package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b euh = null;
    private SparseArray<e> eug = new SparseArray<>();

    private b() {
    }

    public static b bim() {
        if (euh == null) {
            synchronized (b.class) {
                if (euh == null) {
                    euh = new b();
                }
            }
        }
        return euh;
    }

    public View q(Context context, int i) {
        if (this.eug.get(i) == null) {
            return null;
        }
        return this.eug.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.eug.put(i, eVar);
    }
}
