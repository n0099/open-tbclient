package com.baidu.mario.gldraw2d.params;
/* loaded from: classes2.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType adg = MirrorType.NO_MIRROR;
    private int adh = 0;
    private ScaleType adi = ScaleType.FIT_XY;
    private float adj = 1.0f;
    private int adk = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType sm() {
        return this.adg;
    }

    public void a(MirrorType mirrorType) {
        this.adg = mirrorType;
    }

    public ScaleType sn() {
        return this.adi;
    }

    public float so() {
        return this.adj;
    }

    public int sp() {
        return this.adh;
    }

    public void bA(int i) {
        this.adh = i;
    }

    public int sq() {
        return this.adk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: sr */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
