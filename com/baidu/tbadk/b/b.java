package com.baidu.tbadk.b;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private Drawable any;
    private int anz;
    private View.OnClickListener mClickListener;
    private String mTitle;

    public void setPosition(int i) {
        this.anz = i;
    }

    public void setIcon(Drawable drawable) {
        this.any = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
