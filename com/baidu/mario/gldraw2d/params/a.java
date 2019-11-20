package com.baidu.mario.gldraw2d.params;
/* loaded from: classes2.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType awJ = MirrorType.NO_MIRROR;
    private int awK = 0;
    private ScaleType awL = ScaleType.FIT_XY;
    private float awM = 1.0f;
    private int awN = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType xG() {
        return this.awJ;
    }

    public void a(MirrorType mirrorType) {
        this.awJ = mirrorType;
    }

    public ScaleType xH() {
        return this.awL;
    }

    public float xI() {
        return this.awM;
    }

    public int xJ() {
        return this.awK;
    }

    public void cw(int i) {
        this.awK = i;
    }

    public int xK() {
        return this.awN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xL */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
