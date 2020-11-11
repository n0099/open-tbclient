package com.baidu.mario.gldraw2d.params;
/* loaded from: classes5.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bWn = MirrorType.NO_MIRROR;
    private int bWo = 0;
    private ScaleType bWp = ScaleType.FIT_XY;
    private float bWq = 1.0f;
    private int bWr = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType YF() {
        return this.bWn;
    }

    public void a(MirrorType mirrorType) {
        this.bWn = mirrorType;
    }

    public ScaleType YG() {
        return this.bWp;
    }

    public float YH() {
        return this.bWq;
    }

    public int YI() {
        return this.bWo;
    }

    public void gC(int i) {
        this.bWo = i;
    }

    public int YJ() {
        return this.bWr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: YK */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
