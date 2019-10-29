package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {
    private View mView = null;

    public abstract View createView();

    public abstract void onClick();

    public final View getView() {
        if (this.mView == null) {
            this.mView = createView();
        }
        return this.mView;
    }
}
