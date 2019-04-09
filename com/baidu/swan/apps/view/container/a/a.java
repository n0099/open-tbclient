package com.baidu.swan.apps.view.container.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<View> aYJ = new ArrayList();

    public synchronized void ak(View view) {
        if (view != null) {
            this.aYJ.add(view);
        }
    }

    public synchronized boolean al(View view) {
        return view == null ? false : this.aYJ.remove(view);
    }

    public List<View> MK() {
        return this.aYJ;
    }

    public void clear() {
        this.aYJ.clear();
    }
}
