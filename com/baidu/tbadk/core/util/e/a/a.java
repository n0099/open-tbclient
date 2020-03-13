package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable czK;
    protected Drawable dci;
    protected Drawable dcj;
    protected Drawable dck;
    protected Drawable dcl;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean dcm = false;
    protected boolean dcn = false;
    protected boolean dco = false;
    protected boolean dcp = false;
    protected boolean dcq = false;

    public void e(Drawable drawable) {
        if (this.dcq && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
