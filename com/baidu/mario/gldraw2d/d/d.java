package com.baidu.mario.gldraw2d.d;
/* loaded from: classes11.dex */
public class d implements Cloneable {
    private int mHeight;
    private int mWidth;
    private int mType = 3553;
    private int mId = -1;
    private boolean mCameraFrame = false;
    private boolean mFrontCamera = false;
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

    public boolean Is() {
        return this.mId != -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: It */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "type = " + this.mType + " && id = " + this.mId + " && cameraFrame" + this.mCameraFrame + " && frontCamera = " + this.mFrontCamera + " && width * height = " + this.mWidth + " * " + this.mHeight + " && timestamp = " + this.mTimestamp;
    }
}
