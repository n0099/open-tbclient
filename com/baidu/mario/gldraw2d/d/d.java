package com.baidu.mario.gldraw2d.d;
/* loaded from: classes2.dex */
public class d implements Cloneable {
    private int mHeight;
    private int mWidth;
    private int mType = 3553;
    private int mId = -1;
    private boolean awZ = false;
    private boolean axa = false;
    private long mTimestamp = 0;

    public int getType() {
        return this.mType;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean xD() {
        return this.mId != -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xE */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "type = " + this.mType + " && id = " + this.mId + " && cameraFrame" + this.awZ + " && frontCamera = " + this.axa + " && width * height = " + this.mWidth + " * " + this.mHeight + " && timestamp = " + this.mTimestamp;
    }
}
