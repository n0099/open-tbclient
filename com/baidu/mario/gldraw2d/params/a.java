package com.baidu.mario.gldraw2d.params;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType aFf = MirrorType.NO_MIRROR;
    private int aFg = 0;
    private ScaleType aFh = ScaleType.FIT_XY;
    private float aFi = 1.0f;
    private int aFj = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType zR() {
        return this.aFf;
    }

    public void a(MirrorType mirrorType) {
        this.aFf = mirrorType;
    }

    public ScaleType zS() {
        return this.aFh;
    }

    public float zT() {
        return this.aFi;
    }

    public int zU() {
        return this.aFg;
    }

    public void cM(int i) {
        this.aFg = i;
    }

    public int zV() {
        return this.aFj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: zW */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
