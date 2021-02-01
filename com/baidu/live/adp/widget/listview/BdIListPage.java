package com.baidu.live.adp.widget.listview;

import android.view.View;
/* loaded from: classes11.dex */
public abstract class BdIListPage {
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
