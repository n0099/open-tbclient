package com.baidu.swan.apps.view.container.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<View> bcG = new ArrayList();

    public synchronized void ap(View view) {
        if (view != null) {
            this.bcG.add(view);
        }
    }

    public synchronized boolean aq(View view) {
        return view == null ? false : this.bcG.remove(view);
    }

    public List<View> Qo() {
        return this.bcG;
    }

    public void clear() {
        this.bcG.clear();
    }
}
