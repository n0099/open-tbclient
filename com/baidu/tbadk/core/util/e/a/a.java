package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable czV;
    protected Drawable dcw;
    protected Drawable dcx;
    protected Drawable dcy;
    protected Drawable dcz;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean dcA = false;
    protected boolean dcB = false;
    protected boolean dcC = false;
    protected boolean dcD = false;
    protected boolean dcE = false;

    public void e(Drawable drawable) {
        if (this.dcE && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
