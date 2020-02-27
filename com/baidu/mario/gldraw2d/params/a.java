package com.baidu.mario.gldraw2d.params;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType aJl = MirrorType.NO_MIRROR;
    private int aJm = 0;
    private ScaleType aJn = ScaleType.FIT_XY;
    private float aJo = 1.0f;
    private int aJp = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Ch() {
        return this.aJl;
    }

    public void a(MirrorType mirrorType) {
        this.aJl = mirrorType;
    }

    public ScaleType Ci() {
        return this.aJn;
    }

    public float Cj() {
        return this.aJo;
    }

    public int Ck() {
        return this.aJm;
    }

    public void dc(int i) {
        this.aJm = i;
    }

    public int Cl() {
        return this.aJp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Cm */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
