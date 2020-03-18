package com.baidu.mario.gldraw2d.params;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType aJB = MirrorType.NO_MIRROR;
    private int aJC = 0;
    private ScaleType aJD = ScaleType.FIT_XY;
    private float aJE = 1.0f;
    private int aJF = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Cq() {
        return this.aJB;
    }

    public void a(MirrorType mirrorType) {
        this.aJB = mirrorType;
    }

    public ScaleType Cr() {
        return this.aJD;
    }

    public float Cs() {
        return this.aJE;
    }

    public int Ct() {
        return this.aJC;
    }

    public void dc(int i) {
        this.aJC = i;
    }

    public int Cu() {
        return this.aJF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Cv */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
