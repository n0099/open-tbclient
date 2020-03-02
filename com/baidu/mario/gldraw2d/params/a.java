package com.baidu.mario.gldraw2d.params;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType aJm = MirrorType.NO_MIRROR;
    private int aJn = 0;
    private ScaleType aJo = ScaleType.FIT_XY;
    private float aJp = 1.0f;
    private int aJq = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Cj() {
        return this.aJm;
    }

    public void a(MirrorType mirrorType) {
        this.aJm = mirrorType;
    }

    public ScaleType Ck() {
        return this.aJo;
    }

    public float Cl() {
        return this.aJp;
    }

    public int Cm() {
        return this.aJn;
    }

    public void dc(int i) {
        this.aJn = i;
    }

    public int Cn() {
        return this.aJq;
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
