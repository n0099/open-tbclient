package com.baidu.mario.gldraw2d.params;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType aJn = MirrorType.NO_MIRROR;
    private int aJo = 0;
    private ScaleType aJp = ScaleType.FIT_XY;
    private float aJq = 1.0f;
    private int aJr = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Cj() {
        return this.aJn;
    }

    public void a(MirrorType mirrorType) {
        this.aJn = mirrorType;
    }

    public ScaleType Ck() {
        return this.aJp;
    }

    public float Cl() {
        return this.aJq;
    }

    public int Cm() {
        return this.aJo;
    }

    public void dc(int i) {
        this.aJo = i;
    }

    public int Cn() {
        return this.aJr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Co */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
