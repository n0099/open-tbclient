package com.baidu.swan.apps.view.container.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<View> aYF = new ArrayList();

    public synchronized void ak(View view) {
        if (view != null) {
            this.aYF.add(view);
        }
    }

    public synchronized boolean al(View view) {
        return view == null ? false : this.aYF.remove(view);
    }

    public List<View> MM() {
        return this.aYF;
    }

    public void clear() {
        this.aYF.clear();
    }
}
