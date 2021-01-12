package com.baidu.live.alablmsdk.config.a;
/* loaded from: classes10.dex */
public class b {
    private int mHeight;
    private int mWidth;

    public b(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.mWidth != bVar.mWidth || this.mHeight != bVar.mHeight) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public boolean xO() {
        return this.mWidth == 0 || this.mHeight == 0;
    }
}
