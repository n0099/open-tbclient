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

    public FaceInfo(int i, int i2, int i3, int i4, float f2) {
        this.mWidth = i;
        this.mAngle = i2;
        this.mCenter_y = i3;
        this.mCenter_x = i4;
        this.mConf = f2;
        this.landmarks = null;
        this.face_id = 0;
    }

    public void getRectPoints(int[] iArr) {
        int[] iArr2 = iArr;
        double d2 = this.mAngle;
        Double.isNaN(d2);
        double d3 = (d2 * 3.14159d) / 180.0d;
        double cos = Math.cos(d3);
        double sin = Math.sin(d3);
        double d4 = this.mCenter_x;
        int i = this.mWidth;
        double d5 = i;
        Double.isNaN(d5);
        Double.isNaN(d4);
        double d6 = d4 + ((d5 * cos) / 2.0d);
        double d7 = i;
        Double.isNaN(d7);
        int i2 = (int) (d6 - ((d7 * sin) / 2.0d));
        double d8 = this.mCenter_y;
        double d9 = i;
        Double.isNaN(d9);
        Double.isNaN(d8);
        double d10 = d8 + ((sin * d9) / 2.0d);
        double d11 = i;
        Double.isNaN(d11);
        int i3 = (int) (d10 + ((cos * d11) / 2.0d));
        double d12 = this.mAngle;
        Double.isNaN(d12);
        double d13 = (d12 * 3.14159d) / 180.0d;
        double cos2 = Math.cos(d13) * 0.5d;
        double sin2 = Math.sin(d13) * 0.5d;
        if (iArr2 == null || iArr2.length == 0) {
            iArr2 = new int[8];
        }
        double d14 = i2;
        int i4 = this.mWidth;
        double d15 = i4;
        Double.isNaN(d15);
        Double.isNaN(d14);
        double d16 = i4;
        Double.isNaN(d16);
        iArr2[0] = (int) ((d14 - (d15 * sin2)) - (d16 * cos2));
        double d17 = i3;
        double d18 = i4;
        Double.isNaN(d18);
        Double.isNaN(d17);
        double d19 = i4;
        Double.isNaN(d19);
        iArr2[1] = (int) ((d17 + (d18 * cos2)) - (d19 * sin2));
        double d20 = i4;
        Double.isNaN(d20);
        Double.isNaN(d14);
        double d21 = d14 + (d20 * sin2);
        double d22 = i4;
        Double.isNaN(d22);
        iArr2[2] = (int) (d21 - (d22 * cos2));
        double d23 = i4;
        Double.isNaN(d23);
        Double.isNaN(d17);
        double d24 = d17 - (cos2 * d23);
        double d25 = i4;
        Double.isNaN(d25);
        iArr2[3] = (int) (d24 - (sin2 * d25));
        int i5 = i2 * 2;
        iArr2[4] = i5 - iArr2[0];
        int i6 = i3 * 2;
        iArr2[5] = i6 - iArr2[1];
        iArr2[6] = i5 - iArr2[2];
        iArr2[7] = i6 - iArr2[3];
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

    public FaceInfo(int i, int i2, int i3, int i4, float f2, int i5, int[] iArr) {
        this.mWidth = i;
        this.mAngle = i2;
        this.mCenter_y = i3;
        this.mCenter_x = i4;
        this.mConf = f2;
        this.landmarks = iArr;
        this.face_id = i5;
    }

    public FaceInfo(int i, int i2, int i3, int i4, float f2, int i5, int[] iArr, float[] fArr, int[] iArr2) {
        this.mWidth = i;
        this.mAngle = i2;
        this.mCenter_y = i3;
        this.mCenter_x = i4;
        this.mConf = f2;
        this.landmarks = iArr;
        this.face_id = i5;
        this.headPose = fArr;
        this.is_live = iArr2;
    }
}
