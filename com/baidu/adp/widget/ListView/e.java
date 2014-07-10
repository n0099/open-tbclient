package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class e {
    private View a = null;

    public abstract View a();

    public abstract void onClick();

    public final View b() {
        if (this.a == null) {
            this.a = a();
        }
        return this.a;
    }
}
