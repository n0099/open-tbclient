package com.baidu.tbadk.core.util.f.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable evU;
    protected Drawable ffG;
    protected Drawable ffH;
    protected Drawable ffI;
    protected Drawable ffJ;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean ffK = false;
    protected boolean ffL = false;
    protected boolean ffM = false;
    protected boolean ffN = false;
    protected boolean ffO = false;

    public void k(Drawable drawable) {
        if (this.ffO && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
