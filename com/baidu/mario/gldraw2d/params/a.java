package com.baidu.mario.gldraw2d.params;
/* loaded from: classes3.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType cgC = MirrorType.NO_MIRROR;
    private int cgD = 0;
    private ScaleType cgE = ScaleType.FIT_XY;
    private float cgF = 1.0f;
    private int cgG = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType acm() {
        return this.cgC;
    }

    public void a(MirrorType mirrorType) {
        this.cgC = mirrorType;
    }

    public ScaleType acn() {
        return this.cgE;
    }

    public float aco() {
        return this.cgF;
    }

    public int acp() {
        return this.cgD;
    }

    public void gX(int i) {
        this.cgD = i;
    }

    public int acq() {
        return this.cgG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: acr */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
