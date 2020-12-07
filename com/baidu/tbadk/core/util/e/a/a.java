package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable eWf;
    protected Drawable eWg;
    protected Drawable eWh;
    protected Drawable eWi;
    protected Drawable emn;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean eWj = false;
    protected boolean eWk = false;
    protected boolean eWl = false;
    protected boolean eWm = false;
    protected boolean eWn = false;

    public void f(Drawable drawable) {
        if (this.eWn && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
