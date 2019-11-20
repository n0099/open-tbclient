package com.baidu.swan.apps.view.container.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<View> buO = new ArrayList();

    public synchronized void av(View view) {
        if (view != null) {
            this.buO.add(view);
        }
    }

    public synchronized boolean aw(View view) {
        return view == null ? false : this.buO.remove(view);
    }

    public List<View> Vc() {
        return this.buO;
    }

    public void clear() {
        this.buO.clear();
    }
}
