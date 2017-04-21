package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class c {
    private View mView = null;

    public abstract View lf();

    public abstract void onClick();

    public final View getView() {
        if (this.mView == null) {
            this.mView = lf();
        }
        return this.mView;
    }
}
