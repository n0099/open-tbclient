package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public abstract class a {
    protected Drawable dEA;
    protected Drawable emS;
    protected Drawable emT;
    protected Drawable emU;
    protected Drawable emV;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean emW = false;
    protected boolean emX = false;
    protected boolean emY = false;
    protected boolean emZ = false;
    protected boolean ena = false;

    public void e(Drawable drawable) {
        if (this.ena && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
