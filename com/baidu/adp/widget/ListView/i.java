package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class i {
    private View mView = null;

    public abstract View jx();

    public abstract void onClick();

    public final View getView() {
        if (this.mView == null) {
            this.mView = jx();
        }
        return this.mView;
    }
}
