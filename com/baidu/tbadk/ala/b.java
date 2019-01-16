package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b amf = null;
    private SparseArray<e> ame = new SparseArray<>();

    private b() {
    }

    public static b wg() {
        if (amf == null) {
            synchronized (b.class) {
                if (amf == null) {
                    amf = new b();
                }
            }
        }
        return amf;
    }

    public View j(Context context, int i) {
        if (this.ame.get(i) == null) {
            return null;
        }
        return this.ame.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.ame.put(i, eVar);
    }
}
