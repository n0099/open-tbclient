package com.baidu.swan.apps.view.container.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<View> bbx = new ArrayList();

    public synchronized void an(View view) {
        if (view != null) {
            this.bbx.add(view);
        }
    }

    public synchronized boolean ao(View view) {
        return view == null ? false : this.bbx.remove(view);
    }

    public List<View> Pt() {
        return this.bbx;
    }

    public void clear() {
        this.bbx.clear();
    }
}
