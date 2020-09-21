package com.baidu.mario.gldraw2d.params;
/* loaded from: classes4.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bBG = MirrorType.NO_MIRROR;
    private int bBH = 0;
    private ScaleType bBI = ScaleType.FIT_XY;
    private float bBJ = 1.0f;
    private int bBK = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType St() {
        return this.bBG;
    }

    public void a(MirrorType mirrorType) {
        this.bBG = mirrorType;
    }

    public ScaleType Su() {
        return this.bBI;
    }

    public float Sv() {
        return this.bBJ;
    }

    public int Sw() {
        return this.bBH;
    }

    public void fN(int i) {
        this.bBH = i;
    }

    public int Sx() {
        return this.bBK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Sy */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
