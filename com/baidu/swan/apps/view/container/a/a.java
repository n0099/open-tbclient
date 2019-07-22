package com.baidu.swan.apps.view.container.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<View> bci = new ArrayList();

    public synchronized void ap(View view) {
        if (view != null) {
            this.bci.add(view);
        }
    }

    public synchronized boolean aq(View view) {
        return view == null ? false : this.bci.remove(view);
    }

    public List<View> Qk() {
        return this.bci;
    }

    public void clear() {
        this.bci.clear();
    }
}
