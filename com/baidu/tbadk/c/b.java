package com.baidu.tbadk.c;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private View.OnClickListener mClickListener;
    private Drawable mIcon;
    private int mPosition;
    private String mTitle;

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void e(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
