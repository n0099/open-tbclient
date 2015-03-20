package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BX;
    public com.baidu.adp.widget.a.a BY;
    public volatile boolean isDefault = true;

    public boolean jZ() {
        return (this.BX == null || this.BX.getBitmap() == null) ? false : true;
    }

    public boolean ka() {
        return this.BY != null && this.BY.mA();
    }

    public boolean isAvailable() {
        return jZ() || ka();
    }

    public int getWidth() {
        if (jZ()) {
            return this.BX.getIntrinsicWidth();
        }
        if (ka()) {
            return this.BY.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (jZ()) {
            return this.BX.getIntrinsicHeight();
        }
        if (ka()) {
            return this.BY.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.BY = null;
        this.BX = null;
    }

    public boolean fI() {
        if (ka()) {
            return this.BY.fI();
        }
        return false;
    }
}
