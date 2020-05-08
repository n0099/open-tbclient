package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable cYY;
    protected Drawable dBP;
    protected Drawable dBQ;
    protected Drawable dBR;
    protected Drawable dBS;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean dBT = false;
    protected boolean dBU = false;
    protected boolean dBV = false;
    protected boolean dBW = false;
    protected boolean dBX = false;

    public void e(Drawable drawable) {
        if (this.dBX && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
