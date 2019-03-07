package com.baidu.swan.apps.view.container.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<View> aYE = new ArrayList();

    public synchronized void ak(View view) {
        if (view != null) {
            this.aYE.add(view);
        }
    }

    public synchronized boolean al(View view) {
        return view == null ? false : this.aYE.remove(view);
    }

    public List<View> MM() {
        return this.aYE;
    }

    public void clear() {
        this.aYE.clear();
    }
}
