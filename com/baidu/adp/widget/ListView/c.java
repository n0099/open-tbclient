package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class c {
    private View mView = null;

    public abstract View kk();

    public abstract void onClick();

    public final View getView() {
        if (this.mView == null) {
            this.mView = kk();
        }
        return this.mView;
    }
}
