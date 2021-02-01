package com.baidu.tbadk.core.util.f.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable eto;
    protected Drawable fdn;
    protected Drawable fdo;
    protected Drawable fdp;
    protected Drawable fdq;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean fdr = false;
    protected boolean fds = false;
    protected boolean fdt = false;
    protected boolean fdu = false;
    protected boolean fdv = false;

    public void k(Drawable drawable) {
        if (this.fdv && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
