package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable dPW;
    protected Drawable dPX;
    protected Drawable dPY;
    protected Drawable dPZ;
    protected Drawable dkc;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean dQa = false;
    protected boolean dQb = false;
    protected boolean dQc = false;
    protected boolean dQd = false;
    protected boolean dQe = false;

    public void e(Drawable drawable) {
        if (this.dQe && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
