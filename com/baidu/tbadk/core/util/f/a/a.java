package com.baidu.tbadk.core.util.f.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable czI;
    protected Drawable dbU;
    protected Drawable dbV;
    protected Drawable dbW;
    protected Drawable dbX;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean dbY = false;
    protected boolean dbZ = false;
    protected boolean dca = false;
    protected boolean dcb = false;
    protected boolean dcc = false;

    public void e(Drawable drawable) {
        if (this.dcc && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
