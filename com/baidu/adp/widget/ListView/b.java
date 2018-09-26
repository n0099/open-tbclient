package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {
    private View mView = null;

    public abstract void onClick();

    public abstract View ov();

    public final View getView() {
        if (this.mView == null) {
            this.mView = ov();
        }
        return this.mView;
    }
}
