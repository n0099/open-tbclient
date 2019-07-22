package com.baidu.mario.gldraw2d.params;
/* loaded from: classes2.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType adD = MirrorType.NO_MIRROR;
    private int adE = 0;
    private ScaleType adF = ScaleType.FIT_XY;
    private float adG = 1.0f;
    private int adH = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType sK() {
        return this.adD;
    }

    public void a(MirrorType mirrorType) {
        this.adD = mirrorType;
    }

    public ScaleType sL() {
        return this.adF;
    }

    public float sM() {
        return this.adG;
    }

    public int sN() {
        return this.adE;
    }

    public void bA(int i) {
        this.adE = i;
    }

    public int sO() {
        return this.adH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: sP */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
