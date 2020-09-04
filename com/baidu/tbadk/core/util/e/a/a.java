package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable dEE;
    protected Drawable emW;
    protected Drawable emX;
    protected Drawable emY;
    protected Drawable emZ;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean ena = false;
    protected boolean enb = false;
    protected boolean enc = false;
    protected boolean ene = false;
    protected boolean enf = false;

    public void e(Drawable drawable) {
        if (this.enf && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
