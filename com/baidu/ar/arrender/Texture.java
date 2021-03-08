package com.baidu.ar.arrender;
/* loaded from: classes3.dex */
public class Texture {
    public static final long NOT_CREATE_INSIDE = -1;
    public static final int NO_TEXTURE = -1;
    private long iq;
    private int ir;
    private int mId;

    public Texture() {
        this.iq = -1L;
        this.mId = -1;
        this.ir = 3553;
    }

    public Texture(int i, int i2) {
        this.iq = -1L;
        this.mId = -1;
        this.ir = 3553;
        this.mId = i;
        this.ir = i2;
    }

    public long getHandle() {
        return this.iq;
    }

    public int getId() {
        return this.mId;
    }

    public int getType() {
        return this.ir;
    }

    public void setHandle(long j) {
        this.iq = j;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setType(int i) {
        this.ir = i;
    }
}
