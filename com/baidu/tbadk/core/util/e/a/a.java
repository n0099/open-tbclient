package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable duE;
    protected Drawable edj;
    protected Drawable edk;
    protected Drawable edl;
    protected Drawable edm;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean edn = false;
    protected boolean edo = false;
    protected boolean edp = false;
    protected boolean edq = false;
    protected boolean edr = false;

    public void e(Drawable drawable) {
        if (this.edr && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
