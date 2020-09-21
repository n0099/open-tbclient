package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable dGF;
    protected Drawable epp;
    protected Drawable epq;
    protected Drawable epr;
    protected Drawable eps;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean ept = false;
    protected boolean epu = false;
    protected boolean epv = false;
    protected boolean epw = false;
    protected boolean epx = false;

    public void e(Drawable drawable) {
        if (this.epx && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
