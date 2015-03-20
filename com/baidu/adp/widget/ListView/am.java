package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public class am {
    private View view;

    public am(View view) {
        this.view = null;
        this.view = view;
        if (this.view == null) {
            throw new RuntimeException("view cannt be null");
        }
        this.view.setTag(this);
    }

    public View getView() {
        return this.view;
    }
}
