package com.baidu.mario.gldraw2d.params;
/* loaded from: classes6.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bUD = MirrorType.NO_MIRROR;
    private int bUE = 0;
    private ScaleType bUF = ScaleType.FIT_XY;
    private float bUG = 1.0f;
    private int bUH = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType XW() {
        return this.bUD;
    }

    public void a(MirrorType mirrorType) {
        this.bUD = mirrorType;
    }

    public ScaleType XX() {
        return this.bUF;
    }

    public float XY() {
        return this.bUG;
    }

    public int XZ() {
        return this.bUE;
    }

    public void gy(int i) {
        this.bUE = i;
    }

    public int Ya() {
        return this.bUH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Yb */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
