package com.baidu.mario.gldraw2d.params;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bmX = MirrorType.NO_MIRROR;
    private int bmY = 0;
    private ScaleType bmZ = ScaleType.FIT_XY;
    private float bna = 1.0f;
    private int bnb = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Kn() {
        return this.bmX;
    }

    public void a(MirrorType mirrorType) {
        this.bmX = mirrorType;
    }

    public ScaleType Ko() {
        return this.bmZ;
    }

    public float Kp() {
        return this.bna;
    }

    public int Kq() {
        return this.bmY;
    }

    public void dz(int i) {
        this.bmY = i;
    }

    public int Kr() {
        return this.bnb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Ks */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
