package com.baidu.tbadk.core.util.f.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable erg;
    protected Drawable faX;
    protected Drawable faY;
    protected Drawable faZ;
    protected Drawable fba;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean fbb = false;
    protected boolean fbc = false;
    protected boolean fbd = false;
    protected boolean fbe = false;
    protected boolean fbf = false;

    public void k(Drawable drawable) {
        if (this.fbf && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
