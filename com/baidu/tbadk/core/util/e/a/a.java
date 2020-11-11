package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable ePM;
    protected Drawable ePN;
    protected Drawable ePO;
    protected Drawable ePP;
    protected Drawable egU;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean ePQ = false;
    protected boolean ePR = false;
    protected boolean ePS = false;
    protected boolean ePT = false;
    protected boolean ePU = false;

    public void e(Drawable drawable) {
        if (this.ePU && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
