package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable eOQ;
    protected Drawable eOR;
    protected Drawable eOS;
    protected Drawable eOT;
    protected Drawable efm;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean eOU = false;
    protected boolean eOV = false;
    protected boolean eOW = false;
    protected boolean eOX = false;
    protected boolean eOY = false;

    public void f(Drawable drawable) {
        if (this.eOY && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
