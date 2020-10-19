package com.baidu.tbadk.core.util.e.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class a {
    protected Drawable dSG;
    protected Drawable eBB;
    protected Drawable eBC;
    protected Drawable eBD;
    protected Drawable eBE;
    protected int mAlpha;
    protected int mType = 1;
    protected boolean eBF = false;
    protected boolean eBG = false;
    protected boolean eBH = false;
    protected boolean eBI = false;
    protected boolean eBJ = false;

    public void e(Drawable drawable) {
        if (this.eBJ && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
