package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable dWO;
    protected Drawable dWP;
    protected Drawable dWQ;
    protected Drawable dWR;
    protected Drawable doN;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean dWS = false;
    protected boolean dWT = false;
    protected boolean dWU = false;
    protected boolean dWV = false;
    protected boolean dWW = false;

    public void e(Drawable drawable) {
        if (this.dWW && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
