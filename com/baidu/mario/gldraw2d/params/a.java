package com.baidu.mario.gldraw2d.params;
/* loaded from: classes14.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType cbN = MirrorType.NO_MIRROR;
    private int cbO = 0;
    private ScaleType cbP = ScaleType.FIT_XY;
    private float cbQ = 1.0f;
    private int cbR = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Yt() {
        return this.cbN;
    }

    public void a(MirrorType mirrorType) {
        this.cbN = mirrorType;
    }

    public ScaleType Yu() {
        return this.cbP;
    }

    public float Yv() {
        return this.cbQ;
    }

    public int Yw() {
        return this.cbO;
    }

    public void fq(int i) {
        this.cbO = i;
    }

    public int Yx() {
        return this.cbR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Yy */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
