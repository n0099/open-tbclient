package com.baidu.tbadk.core.util.f.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable cXR;
    protected Drawable cXS;
    protected Drawable cXT;
    protected Drawable cXU;
    protected Drawable cvK;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean cXV = false;
    protected boolean cXW = false;
    protected boolean cXX = false;
    protected boolean cXY = false;
    protected boolean cXZ = false;

    public void e(Drawable drawable) {
        if (this.cXZ && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
