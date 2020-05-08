package com.baidu.mario.gldraw2d.params;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bfy = MirrorType.NO_MIRROR;
    private int bfz = 0;
    private ScaleType bfA = ScaleType.FIT_XY;
    private float bfB = 1.0f;
    private int bfC = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Iu() {
        return this.bfy;
    }

    public void a(MirrorType mirrorType) {
        this.bfy = mirrorType;
    }

    public ScaleType Iv() {
        return this.bfA;
    }

    public float Iw() {
        return this.bfB;
    }

    public int Ix() {
        return this.bfz;
    }

    public void ds(int i) {
        this.bfz = i;
    }

    public int Iy() {
        return this.bfC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Iz */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
