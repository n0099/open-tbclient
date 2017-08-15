package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {
    private View mView = null;

    public abstract View lk();

    public abstract void onClick();

    public final View getView() {
        if (this.mView == null) {
            this.mView = lk();
        }
        return this.mView;
    }
}
