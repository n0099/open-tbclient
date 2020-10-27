package com.baidu.mario.gldraw2d.params;
/* loaded from: classes5.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bQD = MirrorType.NO_MIRROR;
    private int bQE = 0;
    private ScaleType bQF = ScaleType.FIT_XY;
    private float bQG = 1.0f;
    private int bQH = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Wg() {
        return this.bQD;
    }

    public void a(MirrorType mirrorType) {
        this.bQD = mirrorType;
    }

    public ScaleType Wh() {
        return this.bQF;
    }

    public float Wi() {
        return this.bQG;
    }

    public int Wj() {
        return this.bQE;
    }

    public void gs(int i) {
        this.bQE = i;
    }

    public int Wk() {
        return this.bQH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Wl */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
