package com.baidu.mario.gldraw2d.params;
/* loaded from: classes14.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType chy = MirrorType.NO_MIRROR;
    private int chz = 0;
    private ScaleType chA = ScaleType.FIT_XY;
    private float chB = 1.0f;
    private int chC = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType aap() {
        return this.chy;
    }

    public void a(MirrorType mirrorType) {
        this.chy = mirrorType;
    }

    public ScaleType aaq() {
        return this.chA;
    }

    public float aar() {
        return this.chB;
    }

    public int aas() {
        return this.chz;
    }

    public void fx(int i) {
        this.chz = i;
    }

    public int aat() {
        return this.chC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aau */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
