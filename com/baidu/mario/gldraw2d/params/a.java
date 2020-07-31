package com.baidu.mario.gldraw2d.params;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bss = MirrorType.NO_MIRROR;
    private int bst = 0;
    private ScaleType bsu = ScaleType.FIT_XY;
    private float bsv = 1.0f;
    private int bsw = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType LD() {
        return this.bss;
    }

    public void a(MirrorType mirrorType) {
        this.bss = mirrorType;
    }

    public ScaleType LE() {
        return this.bsu;
    }

    public float LF() {
        return this.bsv;
    }

    public int LG() {
        return this.bst;
    }

    public void dJ(int i) {
        this.bst = i;
    }

    public int LH() {
        return this.bsw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: LI */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
