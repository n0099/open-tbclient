package com.baidu.tbadk.c;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private Drawable anK;
    private int anL;
    private View.OnClickListener mClickListener;
    private String mTitle;

    public void setPosition(int i) {
        this.anL = i;
    }

    public void setIcon(Drawable drawable) {
        this.anK = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
