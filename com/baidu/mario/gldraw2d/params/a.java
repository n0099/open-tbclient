package com.baidu.mario.gldraw2d.params;
/* loaded from: classes9.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType aEn = MirrorType.NO_MIRROR;
    private int aEo = 0;
    private ScaleType aEp = ScaleType.FIT_XY;
    private float aEq = 1.0f;
    private int aEr = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType zv() {
        return this.aEn;
    }

    public void a(MirrorType mirrorType) {
        this.aEn = mirrorType;
    }

    public ScaleType zw() {
        return this.aEp;
    }

    public float zx() {
        return this.aEq;
    }

    public int zy() {
        return this.aEo;
    }

    public void cL(int i) {
        this.aEo = i;
    }

    public int zz() {
        return this.aEr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: zA */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
