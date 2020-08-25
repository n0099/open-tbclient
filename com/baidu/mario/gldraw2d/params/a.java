package com.baidu.mario.gldraw2d.params;
/* loaded from: classes20.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType byg = MirrorType.NO_MIRROR;
    private int byh = 0;
    private ScaleType byi = ScaleType.FIT_XY;
    private float byj = 1.0f;
    private int byk = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType RC() {
        return this.byg;
    }

    public void a(MirrorType mirrorType) {
        this.byg = mirrorType;
    }

    public ScaleType RD() {
        return this.byi;
    }

    public float RE() {
        return this.byj;
    }

    public int RF() {
        return this.byh;
    }

    public void fE(int i) {
        this.byh = i;
    }

    public int RG() {
        return this.byk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: RH */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
