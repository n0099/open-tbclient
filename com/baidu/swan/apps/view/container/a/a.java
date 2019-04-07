package com.baidu.swan.apps.view.container.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<View> aYI = new ArrayList();

    public synchronized void ak(View view) {
        if (view != null) {
            this.aYI.add(view);
        }
    }

    public synchronized boolean al(View view) {
        return view == null ? false : this.aYI.remove(view);
    }

    public List<View> MK() {
        return this.aYI;
    }

    public void clear() {
        this.aYI.clear();
    }
}
