package com.baidu.idl.facesdk;
/* loaded from: classes14.dex */
public class FaceInfo {
    public int face_id;
    public float[] headPose;
    public int[] is_live;
    public int[] landmarks;
    public int mAngle;
    public int mCenter_x;
    public int mCenter_y;
    public float mConf;
    public int mWidth;

    public FaceInfo(int i, int i2, int i3, int i4, float f) {
        this.mWidth = i;
        this.mAngle = i2;
        this.mCenter_y = i3;
        this.mCenter_x = i4;
        this.mConf = f;
        this.landmarks = null;
        this.face_id = 0;
    }

    public FaceInfo(int i, int i2, int i3, int i4, float f, int i5, int[] iArr) {
        this.mWidth = i;
        this.mAngle = i2;
        this.mCenter_y = i3;
        this.mCenter_x = i4;
        this.mConf = f;
        this.landmarks = iArr;
        this.face_id = i5;
    }

    public FaceInfo(int i, int i2, int i3, int i4, float f, int i5, int[] iArr, float[] fArr, int[] iArr2) {
        this.mWidth = i;
        this.mAngle = i2;
        this.mCenter_y = i3;
        this.mCenter_x = i4;
        this.mConf = f;
        this.landmarks = iArr;
        this.face_id = i5;
        this.headPose = fArr;
        this.is_live = iArr2;
    }

    public void getRectPoints(int[] iArr) {
        double d = (this.mAngle * 3.14159d) / 180.0d;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        int i = (int) ((this.mCenter_x + ((this.mWidth * cos) / 2.0d)) - ((this.mWidth * sin) / 2.0d));
        int i2 = (int) (((sin * this.mWidth) / 2.0d) + this.mCenter_y + ((cos * this.mWidth) / 2.0d));
        double d2 = (this.mAngle * 3.14159d) / 180.0d;
        double cos2 = Math.cos(d2) * 0.5d;
        double sin2 = Math.sin(d2) * 0.5d;
        if (iArr == null || iArr.length == 0) {
            iArr = new int[8];
        }
        iArr[0] = (int) ((i - (this.mWidth * sin2)) - (this.mWidth * cos2));
        iArr[1] = (int) ((i2 + (this.mWidth * cos2)) - (this.mWidth * sin2));
        iArr[2] = (int) ((i + (this.mWidth * sin2)) - (this.mWidth * cos2));
        iArr[3] = (int) ((i2 - (cos2 * this.mWidth)) - (sin2 * this.mWidth));
        iArr[4] = (i * 2) - iArr[0];
        iArr[5] = (i2 * 2) - iArr[1];
        iArr[6] = (i * 2) - iArr[2];
        iArr[7] = (i2 * 2) - iArr[3];
    }

    public boolean is_live() {
        if (this.is_live == null || this.is_live.length != 11) {
            return false;
        }
        return 1 == this.is_live[0];
    }

    public boolean is_live_mouth() {
        if (this.is_live == null || this.is_live.length != 11) {
            return false;
        }
        return 1 == this.is_live[3];
    }

    public boolean is_live_head_turn_left() {
        if (this.is_live == null || this.is_live.length != 11) {
            return false;
        }
        return 1 == this.is_live[5];
    }

    public boolean is_live_head_turn_right() {
        if (this.is_live == null || this.is_live.length != 11) {
            return false;
        }
        return 1 == this.is_live[6];
    }

    public boolean is_live_head_up() {
        if (this.is_live == null || this.is_live.length != 11) {
            return false;
        }
        return 1 == this.is_live[8];
    }

    public boolean is_live_head_down() {
        if (this.is_live == null || this.is_live.length != 11) {
            return false;
        }
        return 1 == this.is_live[9];
    }

    public int get_leftEyeState() {
        if (this.is_live == null || this.is_live.length != 11) {
            return 0;
        }
        return this.is_live[1];
    }

    public int get_rightEyeState() {
        if (this.is_live == null || this.is_live.length != 11) {
            return 0;
        }
        return this.is_live[2];
    }

    public int get_mouthState() {
        if (this.is_live == null || this.is_live.length != 11) {
            return 0;
        }
        return this.is_live[4];
    }
}
