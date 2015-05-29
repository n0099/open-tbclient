package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class e {
    private View mView = null;

    public abstract View ng();

    public abstract void onClick();

    public final View getView() {
        if (this.mView == null) {
            this.mView = ng();
        }
        return this.mView;
    }
}
