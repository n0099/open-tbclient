package com.baidu.mario.gldraw2d.params;
/* loaded from: classes20.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType byj = MirrorType.NO_MIRROR;
    private int byk = 0;
    private ScaleType byl = ScaleType.FIT_XY;
    private float bym = 1.0f;
    private int byn = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType RC() {
        return this.byj;
    }

    public void a(MirrorType mirrorType) {
        this.byj = mirrorType;
    }

    public ScaleType RD() {
        return this.byl;
    }

    public float RE() {
        return this.bym;
    }

    public int RF() {
        return this.byk;
    }

    public void fE(int i) {
        this.byk = i;
    }

    public int RG() {
        return this.byn;
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
