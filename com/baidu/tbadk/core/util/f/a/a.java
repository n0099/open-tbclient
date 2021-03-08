package com.baidu.tbadk.core.util.f.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable euP;
    protected Drawable feM;
    protected Drawable feN;
    protected Drawable feO;
    protected Drawable feP;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean feQ = false;
    protected boolean feR = false;
    protected boolean feS = false;
    protected boolean feT = false;
    protected boolean feU = false;

    public void k(Drawable drawable) {
        if (this.feU && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
