package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable cYT;
    protected Drawable dBL;
    protected Drawable dBM;
    protected Drawable dBN;
    protected Drawable dBO;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean dBP = false;
    protected boolean dBQ = false;
    protected boolean dBR = false;
    protected boolean dBS = false;
    protected boolean dBT = false;

    public void e(Drawable drawable) {
        if (this.dBT && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
