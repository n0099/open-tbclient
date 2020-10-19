package com.baidu.mario.gldraw2d.params;
/* loaded from: classes5.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bIi = MirrorType.NO_MIRROR;
    private int bIj = 0;
    private ScaleType bIk = ScaleType.FIT_XY;
    private float bIl = 1.0f;
    private int bIm = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Um() {
        return this.bIi;
    }

    public void a(MirrorType mirrorType) {
        this.bIi = mirrorType;
    }

    public ScaleType Un() {
        return this.bIk;
    }

    public float Uo() {
        return this.bIl;
    }

    public int Up() {
        return this.bIj;
    }

    public void gg(int i) {
        this.bIj = i;
    }

    public int Uq() {
        return this.bIm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Ur */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
