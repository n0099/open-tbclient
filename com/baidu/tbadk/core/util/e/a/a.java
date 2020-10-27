package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable eJX;
    protected Drawable eJY;
    protected Drawable eJZ;
    protected Drawable eKa;
    protected Drawable ebc;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean eKb = false;
    protected boolean eKc = false;
    protected boolean eKd = false;
    protected boolean eKe = false;
    protected boolean eKf = false;

    public void e(Drawable drawable) {
        if (this.eKf && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
