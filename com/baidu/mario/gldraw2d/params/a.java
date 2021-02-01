package com.baidu.mario.gldraw2d.params;
/* loaded from: classes15.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType cfY = MirrorType.NO_MIRROR;
    private int cfZ = 0;
    private ScaleType cga = ScaleType.FIT_XY;
    private float cgb = 1.0f;
    private int cgc = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType aam() {
        return this.cfY;
    }

    public void a(MirrorType mirrorType) {
        this.cfY = mirrorType;
    }

    public ScaleType aan() {
        return this.cga;
    }

    public float aao() {
        return this.cgb;
    }

    public int aap() {
        return this.cfZ;
    }

    public void fw(int i) {
        this.cfZ = i;
    }

    public int aaq() {
        return this.cgc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aar */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
