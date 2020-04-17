package com.baidu.mario.gldraw2d.params;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;
    private MirrorType bft = MirrorType.NO_MIRROR;
    private int bfu = 0;
    private ScaleType bfv = ScaleType.FIT_XY;
    private float bfw = 1.0f;
    private int bfx = -90;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public MirrorType Iv() {
        return this.bft;
    }

    public void a(MirrorType mirrorType) {
        this.bft = mirrorType;
    }

    public ScaleType Iw() {
        return this.bfv;
    }

    public float Ix() {
        return this.bfw;
    }

    public int Iy() {
        return this.bfu;
    }

    public void ds(int i) {
        this.bfu = i;
    }

    public int Iz() {
        return this.bfx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: IA */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
