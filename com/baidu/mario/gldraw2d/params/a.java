package com.baidu.mario.gldraw2d.params;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType brX = MirrorType.NO_MIRROR;
    private int brY = 0;
    private ScaleType brZ = ScaleType.FIT_XY;
    private float bsa = 1.0f;
    private int bsb = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Lw() {
        return this.brX;
    }

    public void a(MirrorType mirrorType) {
        this.brX = mirrorType;
    }

    public ScaleType Lx() {
        return this.brZ;
    }

    public float Ly() {
        return this.bsa;
    }

    public int Lz() {
        return this.brY;
    }

    public void dJ(int i) {
        this.brY = i;
    }

    public int LA() {
        return this.bsb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: LB */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
