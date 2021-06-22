package com.baidu.pass.face.platform.model;

import android.graphics.Point;
import android.graphics.Rect;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceOcclusion;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class FaceExtInfo {
    public static int nComponents = 9;
    public HashMap<String, Point[]> facePointMap;
    public float mAngle;
    public float mBluriness;
    public float mCenterX;
    public float mCenterY;
    public int mFaceID;
    public float mHeight;
    public int mIllum;
    public float[] mLandmarks;
    public float mLeftEyeClose;
    public BDFaceOcclusion mOcclusion;
    public float mPitch;
    public float mRightEyeClose;
    public float mRoll;
    public float mScore;
    public float mWidth;
    public float mYaw;
    public static int[] comp1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    public static int[] comp2 = {13, 14, 15, 16, 17, 18, 19, 20, 13, 21};
    public static int[] comp3 = {22, 23, 24, 25, 26, 27, 28, 29, 22};
    public static int[] comp4 = {30, 31, 32, 33, 34, 35, 36, 37, 30, 38};
    public static int[] comp5 = {39, 40, 41, 42, 43, 44, 45, 46, 39};
    public static int[] comp6 = {47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 47};
    public static int[] comp7 = {51, 57, 52};
    public static int[] comp8 = {58, 59, 60, 61, 62, 63, 64, 65, 58};
    public static int[] comp9 = {58, 66, 67, 68, 62, 69, 70, 71, 58};
    public static int[] nPoints = {13, 10, 9, 10, 9, 11, 3, 9, 9};

    public FaceExtInfo() {
    }

    public void addFaceInfo(FaceInfo faceInfo) {
        this.mFaceID = faceInfo.faceID;
        this.mCenterX = faceInfo.centerX;
        this.mCenterY = faceInfo.centerY;
        this.mWidth = faceInfo.width;
        this.mHeight = faceInfo.height;
        this.mAngle = faceInfo.angle;
        this.mScore = faceInfo.score;
        this.mLandmarks = faceInfo.landmarks;
        this.mPitch = faceInfo.pitch;
        this.mRoll = faceInfo.roll;
        this.mYaw = faceInfo.yaw;
        this.mBluriness = faceInfo.bluriness;
        this.mIllum = faceInfo.illum;
        BDFaceOcclusion bDFaceOcclusion = faceInfo.occlusion;
        this.mOcclusion = bDFaceOcclusion;
        bDFaceOcclusion.leftEye = bDFaceOcclusion.leftEye;
        bDFaceOcclusion.rightEye = bDFaceOcclusion.rightEye;
        bDFaceOcclusion.nose = bDFaceOcclusion.nose;
        bDFaceOcclusion.mouth = bDFaceOcclusion.mouth;
        bDFaceOcclusion.leftCheek = bDFaceOcclusion.leftCheek;
        bDFaceOcclusion.rightCheek = bDFaceOcclusion.rightCheek;
        bDFaceOcclusion.chin = bDFaceOcclusion.chin;
        this.mLeftEyeClose = faceInfo.leftEyeclose;
        this.mRightEyeClose = faceInfo.rightEyeclose;
    }

    public float getBluriness() {
        return this.mBluriness;
    }

    public float getConfidence() {
        return this.mScore;
    }

    public int getFaceId() {
        return this.mFaceID;
    }

    public Rect getFaceRect() {
        float f2 = this.mCenterX;
        float f3 = this.mWidth;
        return new Rect((int) (f2 - (f3 / 2.0f)), (int) (this.mCenterY - (f3 / 2.0f)), (int) f3, (int) f3);
    }

    public int getFaceWidth() {
        return (int) this.mWidth;
    }

    public int getIllum() {
        return this.mIllum;
    }

    public int getLandmarksOutOfDetectCount(Rect rect) {
        if (this.mLandmarks.length == 144) {
            int[][] iArr = {comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9};
            float[] fArr = new float[4];
            int i2 = 0;
            for (int i3 = 0; i3 < nComponents; i3++) {
                int i4 = 0;
                while (i4 < nPoints[i3] - 1) {
                    float[] fArr2 = this.mLandmarks;
                    fArr[0] = fArr2[iArr[i3][i4] << 1];
                    fArr[1] = fArr2[(iArr[i3][i4] << 1) + 1];
                    i4++;
                    fArr[2] = fArr2[iArr[i3][i4] << 1];
                    fArr[3] = fArr2[(iArr[i3][i4] << 1) + 1];
                    if (!rect.contains((int) (fArr[0] * 1.0f), (int) (fArr[1] * 1.0f))) {
                        i2++;
                    }
                    if (!rect.contains((int) (fArr[2] * 1.0f), (int) (fArr[3] * 1.0f))) {
                        i2++;
                    }
                }
            }
            return i2;
        }
        return 0;
    }

    public float getLeftEyeClose() {
        return this.mLeftEyeClose;
    }

    public BDFaceOcclusion getOcclusion() {
        return this.mOcclusion;
    }

    public float getPitch() {
        return this.mPitch;
    }

    public void getRectPoints(int[] iArr) {
        int[] iArr2 = iArr;
        double d2 = (this.mAngle * 3.14159d) / 180.0d;
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        float f2 = this.mWidth;
        int i2 = (int) ((this.mCenterX + ((f2 * cos) / 2.0d)) - ((f2 * sin) / 2.0d));
        int i3 = (int) (this.mCenterY + ((sin * f2) / 2.0d) + ((cos * f2) / 2.0d));
        double d3 = (this.mAngle * 3.14159d) / 180.0d;
        double cos2 = Math.cos(d3) * 0.5d;
        double sin2 = Math.sin(d3) * 0.5d;
        if (iArr2 == null || iArr2.length == 0) {
            iArr2 = new int[8];
        }
        double d4 = i2;
        float f3 = this.mWidth;
        iArr2[0] = (int) ((d4 - (f3 * sin2)) - (f3 * cos2));
        double d5 = i3;
        iArr2[1] = (int) (((f3 * cos2) + d5) - (f3 * sin2));
        iArr2[2] = (int) ((d4 + (f3 * sin2)) - (f3 * cos2));
        iArr2[3] = (int) ((d5 - (cos2 * f3)) - (sin2 * f3));
        int i4 = i2 * 2;
        iArr2[4] = i4 - iArr2[0];
        int i5 = i3 * 2;
        iArr2[5] = i5 - iArr2[1];
        iArr2[6] = i4 - iArr2[2];
        iArr2[7] = i5 - iArr2[3];
    }

    public float getRightEyeClose() {
        return this.mRightEyeClose;
    }

    public float getRoll() {
        return this.mRoll;
    }

    public float getYaw() {
        return this.mYaw;
    }

    public float[] getmLandmarks() {
        return this.mLandmarks;
    }

    public boolean isOutofDetectRect(Rect rect) {
        return rect.contains(getFaceRect());
    }

    public void setLeftEyeClose(float f2) {
        this.mLeftEyeClose = f2;
    }

    public void setRightEyeClose(float f2) {
        this.mRightEyeClose = f2;
    }

    public FaceExtInfo(FaceInfo faceInfo) {
        this.mFaceID = faceInfo.faceID;
        this.mCenterX = faceInfo.centerX;
        this.mCenterY = faceInfo.centerY;
        this.mWidth = faceInfo.width;
        this.mHeight = faceInfo.height;
        this.mAngle = faceInfo.angle;
        this.mScore = faceInfo.score;
        this.mLandmarks = faceInfo.landmarks;
        this.mPitch = faceInfo.pitch;
        this.mRoll = faceInfo.roll;
        this.mYaw = faceInfo.yaw;
        this.mBluriness = faceInfo.bluriness;
        this.mIllum = faceInfo.illum;
        BDFaceOcclusion bDFaceOcclusion = faceInfo.occlusion;
        this.mOcclusion = bDFaceOcclusion;
        bDFaceOcclusion.leftEye = bDFaceOcclusion.leftEye;
        bDFaceOcclusion.rightEye = bDFaceOcclusion.rightEye;
        bDFaceOcclusion.nose = bDFaceOcclusion.nose;
        bDFaceOcclusion.mouth = bDFaceOcclusion.mouth;
        bDFaceOcclusion.leftCheek = bDFaceOcclusion.leftCheek;
        bDFaceOcclusion.rightCheek = bDFaceOcclusion.rightCheek;
        bDFaceOcclusion.chin = bDFaceOcclusion.chin;
        this.mLeftEyeClose = faceInfo.leftEyeclose;
        this.mRightEyeClose = faceInfo.rightEyeclose;
    }

    public Rect getFaceRect(float f2, float f3, float f4) {
        float f5 = this.mCenterX * f2;
        float f6 = this.mCenterY * f3;
        float f7 = this.mWidth;
        return new Rect((int) (f5 - (((f7 / 2.0f) * f2) * f4)), (int) (f6 - (((f7 / 2.0f) * f3) * f4)), (int) (f5 + ((f7 / 2.0f) * f2 * f4)), (int) (f6 + ((f7 / 2.0f) * f3 * f4)));
    }
}
