package com.baidu.mario.gldraw2d.params;
/* loaded from: classes2.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType axb = MirrorType.NO_MIRROR;
    private int axc = 0;
    private ScaleType axd = ScaleType.FIT_XY;
    private float axe = 1.0f;
    private int axf = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType xF() {
        return this.axb;
    }

    public void a(MirrorType mirrorType) {
        this.axb = mirrorType;
    }

    public ScaleType xG() {
        return this.axd;
    }

    public float xH() {
        return this.axe;
    }

    public int xI() {
        return this.axc;
    }

    public void cw(int i) {
        this.axc = i;
    }

    public int xJ() {
        return this.axf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xK */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
