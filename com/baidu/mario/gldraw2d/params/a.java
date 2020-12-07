package com.baidu.mario.gldraw2d.params;
/* loaded from: classes14.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bZS = MirrorType.NO_MIRROR;
    private int bZT = 0;
    private ScaleType bZU = ScaleType.FIT_XY;
    private float bZV = 1.0f;
    private int bZW = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType aaz() {
        return this.bZS;
    }

    public void a(MirrorType mirrorType) {
        this.bZS = mirrorType;
    }

    public ScaleType aaA() {
        return this.bZU;
    }

    public float aaB() {
        return this.bZV;
    }

    public int aaC() {
        return this.bZT;
    }

    public void gW(int i) {
        this.bZT = i;
    }

    public int aaD() {
        return this.bZW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aaE */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
