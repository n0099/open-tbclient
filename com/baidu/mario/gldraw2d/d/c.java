package com.baidu.mario.gldraw2d.d;
/* loaded from: classes11.dex */
public class c implements Cloneable {
    private int mHeight;
    private int mWidth;

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Lt */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
