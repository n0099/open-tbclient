package com.baidu.tbadk.c;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private Drawable anJ;
    private int anK;
    private View.OnClickListener mClickListener;
    private String mTitle;

    public void setPosition(int i) {
        this.anK = i;
    }

    public void setIcon(Drawable drawable) {
        this.anJ = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
