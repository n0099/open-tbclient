package com.baidu.idl.facesdk;
/* loaded from: classes2.dex */
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

    public FaceInfo(int i2, int i3, int i4, int i5, float f2) {
        this.mWidth = i2;
        this.mAngle = i3;
        this.mCenter_y = i4;
        this.mCenter_x = i5;
        this.mConf = f2;
        this.landmarks = null;
        this.face_id = 0;
    }

    public void getRectPoints(int[] iArr) {
        int[] iArr2 = iArr;
        double d2 = (this.mAngle * 3.14159d) / 180.0d;
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        int i2 = this.mWidth;
        int i3 = (int) ((this.mCenter_x + ((i2 * cos) / 2.0d)) - ((i2 * sin) / 2.0d));
        int i4 = (int) (this.mCenter_y + ((sin * i2) / 2.0d) + ((cos * i2) / 2.0d));
        double d3 = (this.mAngle * 3.14159d) / 180.0d;
        double cos2 = Math.cos(d3) * 0.5d;
        double sin2 = Math.sin(d3) * 0.5d;
        if (iArr2 == null || iArr2.length == 0) {
            iArr2 = new int[8];
        }
        double d4 = i3;
        int i5 = this.mWidth;
        iArr2[0] = (int) ((d4 - (i5 * sin2)) - (i5 * cos2));
        double d5 = i4;
        iArr2[1] = (int) (((i5 * cos2) + d5) - (i5 * sin2));
        iArr2[2] = (int) ((d4 + (i5 * sin2)) - (i5 * cos2));
        iArr2[3] = (int) ((d5 - (cos2 * i5)) - (sin2 * i5));
        int i6 = i3 * 2;
        iArr2[4] = i6 - iArr2[0];
        int i7 = i4 * 2;
        iArr2[5] = i7 - iArr2[1];
        iArr2[6] = i6 - iArr2[2];
        iArr2[7] = i7 - iArr2[3];
    }

    public int get_leftEyeState() {
        int[] iArr = this.is_live;
        if (iArr == null || iArr.length != 11) {
            return 0;
        }
        return iArr[1];
    }

    public int get_mouthState() {
        int[] iArr = this.is_live;
        if (iArr == null || iArr.length != 11) {
            return 0;
        }
        return iArr[4];
    }

    public int get_rightEyeState() {
        int[] iArr = this.is_live;
        if (iArr == null || iArr.length != 11) {
            return 0;
        }
        return iArr[2];
    }

    public boolean is_live() {
        int[] iArr = this.is_live;
        return iArr != null && iArr.length == 11 && 1 == iArr[0];
    }

    public boolean is_live_head_down() {
        int[] iArr = this.is_live;
        return iArr != null && iArr.length == 11 && 1 == iArr[9];
    }

    public boolean is_live_head_turn_left() {
        int[] iArr = this.is_live;
        return iArr != null && iArr.length == 11 && 1 == iArr[5];
    }

    public boolean is_live_head_turn_right() {
        int[] iArr = this.is_live;
        return iArr != null && iArr.length == 11 && 1 == iArr[6];
    }

    public boolean is_live_head_up() {
        int[] iArr = this.is_live;
        return iArr != null && iArr.length == 11 && 1 == iArr[8];
    }

    public boolean is_live_mouth() {
        int[] iArr = this.is_live;
        return iArr != null && iArr.length == 11 && 1 == iArr[3];
    }

    public FaceInfo(int i2, int i3, int i4, int i5, float f2, int i6, int[] iArr) {
        this.mWidth = i2;
        this.mAngle = i3;
        this.mCenter_y = i4;
        this.mCenter_x = i5;
        this.mConf = f2;
        this.landmarks = iArr;
        this.face_id = i6;
    }

    public FaceInfo(int i2, int i3, int i4, int i5, float f2, int i6, int[] iArr, float[] fArr, int[] iArr2) {
        this.mWidth = i2;
        this.mAngle = i3;
        this.mCenter_y = i4;
        this.mCenter_x = i5;
        this.mConf = f2;
        this.landmarks = iArr;
        this.face_id = i6;
        this.headPose = fArr;
        this.is_live = iArr2;
    }
}
