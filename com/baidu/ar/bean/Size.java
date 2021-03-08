package com.baidu.ar.bean;

import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class Size {
    private int mHeight;
    private int mWidth;

    public Size() {
    }

    public Size(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public static Size parseSize(String str) {
        int indexOf = str.indexOf(42);
        int indexOf2 = indexOf < 0 ? str.indexOf(120) : indexOf;
        if (indexOf2 < 0) {
            return null;
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf2)), Integer.parseInt(str.substring(indexOf2 + 1)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.mWidth != size.mWidth || this.mHeight != size.mHeight) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return this.mHeight ^ ((this.mWidth << 16) | (this.mWidth >>> 16));
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public String toString() {
        return this.mWidth + Config.EVENT_HEAT_X + this.mHeight;
    }
}
