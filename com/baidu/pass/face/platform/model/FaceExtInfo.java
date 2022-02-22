package com.baidu.pass.face.platform.model;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceOcclusion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class FaceExtInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static int[] comp1 = null;
    public static int[] comp2 = null;
    public static int[] comp3 = null;
    public static int[] comp4 = null;
    public static int[] comp5 = null;
    public static int[] comp6 = null;
    public static int[] comp7 = null;
    public static int[] comp8 = null;
    public static int[] comp9 = null;
    public static int nComponents = 9;
    public static int[] nPoints;
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1723876553, "Lcom/baidu/pass/face/platform/model/FaceExtInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1723876553, "Lcom/baidu/pass/face/platform/model/FaceExtInfo;");
                return;
            }
        }
        comp1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        comp2 = new int[]{13, 14, 15, 16, 17, 18, 19, 20, 13, 21};
        comp3 = new int[]{22, 23, 24, 25, 26, 27, 28, 29, 22};
        comp4 = new int[]{30, 31, 32, 33, 34, 35, 36, 37, 30, 38};
        comp5 = new int[]{39, 40, 41, 42, 43, 44, 45, 46, 39};
        comp6 = new int[]{47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 47};
        comp7 = new int[]{51, 57, 52};
        comp8 = new int[]{58, 59, 60, 61, 62, 63, 64, 65, 58};
        comp9 = new int[]{58, 66, 67, 68, 62, 69, 70, 71, 58};
        nPoints = new int[]{13, 10, 9, 10, 9, 11, 3, 9, 9};
    }

    public FaceExtInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void addFaceInfo(FaceInfo faceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, faceInfo) == null) {
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
    }

    public float getBluriness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBluriness : invokeV.floatValue;
    }

    public float getCenterX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCenterX : invokeV.floatValue;
    }

    public float getCenterY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCenterY : invokeV.floatValue;
    }

    public float getConfidence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mScore : invokeV.floatValue;
    }

    public int getFaceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFaceID : invokeV.intValue;
    }

    public Rect getFaceRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f2 = this.mCenterX;
            float f3 = this.mWidth;
            return new Rect((int) (f2 - (f3 / 2.0f)), (int) (this.mCenterY - (f3 / 2.0f)), (int) f3, (int) f3);
        }
        return (Rect) invokeV.objValue;
    }

    public int getFaceWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (int) this.mWidth : invokeV.intValue;
    }

    public float getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mHeight : invokeV.floatValue;
    }

    public int getIllum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mIllum : invokeV.intValue;
    }

    public int getLandmarksOutOfDetectCount(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, rect)) == null) {
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
        return invokeL.intValue;
    }

    public float getLeftEyeClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mLeftEyeClose : invokeV.floatValue;
    }

    public BDFaceOcclusion getOcclusion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mOcclusion : (BDFaceOcclusion) invokeV.objValue;
    }

    public float getPitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mPitch : invokeV.floatValue;
    }

    public void getRectPoints(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iArr) == null) {
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
    }

    public float getRightEyeClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mRightEyeClose : invokeV.floatValue;
    }

    public float getRoll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mRoll : invokeV.floatValue;
    }

    public float getYaw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mYaw : invokeV.floatValue;
    }

    public float[] getmLandmarks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mLandmarks : (float[]) invokeV.objValue;
    }

    public boolean isOutofDetectRect(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, rect)) == null) ? rect.contains(getFaceRect()) : invokeL.booleanValue;
    }

    public void setCenterX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.mCenterX = f2;
        }
    }

    public void setCenterY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            this.mCenterY = f2;
        }
    }

    public void setHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            this.mHeight = f2;
        }
    }

    public void setLeftEyeClose(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            this.mLeftEyeClose = f2;
        }
    }

    public void setRightEyeClose(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f2) == null) {
            this.mRightEyeClose = f2;
        }
    }

    public FaceExtInfo(FaceInfo faceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {faceInfo};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float f5 = this.mCenterX * f2;
            float f6 = this.mCenterY * f3;
            float f7 = this.mWidth;
            return new Rect((int) (f5 - (((f7 / 2.0f) * f2) * f4)), (int) (f6 - (((f7 / 2.0f) * f3) * f4)), (int) (f5 + ((f7 / 2.0f) * f2 * f4)), (int) (f6 + ((f7 / 2.0f) * f3 * f4)));
        }
        return (Rect) invokeCommon.objValue;
    }
}
