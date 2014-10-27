package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    private View mView = null;

    public abstract View hA();

    public abstract void onClick();

    public final View getView() {
        if (this.mView == null) {
            this.mView = hA();
        }
        return this.mView;
    }
}
