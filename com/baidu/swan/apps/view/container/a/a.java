package com.baidu.swan.apps.view.container.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<View> bvF = new ArrayList();

    public synchronized void av(View view) {
        if (view != null) {
            this.bvF.add(view);
        }
    }

    public synchronized boolean aw(View view) {
        return view == null ? false : this.bvF.remove(view);
    }

    public List<View> Ve() {
        return this.bvF;
    }

    public void clear() {
        this.bvF.clear();
    }
}
