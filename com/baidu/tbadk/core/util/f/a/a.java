package com.baidu.tbadk.core.util.f.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable cXH;
    protected Drawable cXI;
    protected Drawable cXJ;
    protected Drawable cXK;
    protected Drawable cvz;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean cXL = false;
    protected boolean cXM = false;
    protected boolean cXN = false;
    protected boolean cXO = false;
    protected boolean cXP = false;

    public void e(Drawable drawable) {
        if (this.cXP && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
