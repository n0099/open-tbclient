package com.baidu.pass.main.facesdk;

import com.baidu.pass.main.facesdk.model.BDFaceOcclusion;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class FaceInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int age;
    public float angle;
    public float bluriness;
    public float centerX;
    public float centerY;
    public BDFaceSDKCommon.BDFaceEmotionEnum emotionSeven;
    public BDFaceSDKCommon.BDFaceEmotion emotionThree;
    public int faceID;
    public BDFaceSDKCommon.BDFaceGender gender;
    public BDFaceSDKCommon.BDFaceGlasses glasses;
    public float height;
    public int illum;
    public float[] landmarks;
    public float leftEyeclose;
    public float mouthclose;
    public BDFaceOcclusion occlusion;
    public float pitch;
    public BDFaceSDKCommon.BDFaceRace race;
    public float rightEyeclose;
    public float roll;
    public float score;
    public float width;
    public float yaw;

    public FaceInfo(int i2, float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), fArr, fArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.faceID = i2;
        if (fArr != null && fArr.length == 6) {
            this.centerX = fArr[0];
            this.centerY = fArr[1];
            this.width = fArr[2];
            this.height = fArr[3];
            this.angle = fArr[4];
            this.score = fArr[5];
        }
        this.landmarks = fArr2;
    }

    public FaceInfo(int i2, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int[] iArr, float[] fArr5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), fArr, fArr2, fArr3, fArr4, iArr, fArr5};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.faceID = i2;
        if (fArr != null && fArr.length == 6) {
            this.centerX = fArr[0];
            this.centerY = fArr[1];
            this.width = fArr[2];
            this.height = fArr[3];
            this.angle = fArr[4];
            this.score = fArr[5];
        }
        this.landmarks = fArr2;
        if (fArr3 != null && fArr3.length == 3) {
            this.yaw = fArr3[0];
            this.roll = fArr3[1];
            this.pitch = fArr3[2];
        }
        if (fArr4 != null && fArr4.length == 9) {
            this.occlusion = new BDFaceOcclusion(fArr4[0], fArr4[1], fArr4[2], fArr4[3], fArr4[4], fArr4[5], fArr4[6]);
            this.illum = (int) fArr4[7];
            this.bluriness = fArr4[8];
        }
        if (iArr != null && iArr.length == 6) {
            this.age = iArr[0];
            this.race = BDFaceSDKCommon.BDFaceRace.values()[iArr[1]];
            this.emotionThree = BDFaceSDKCommon.BDFaceEmotion.values()[iArr[2]];
            this.glasses = BDFaceSDKCommon.BDFaceGlasses.values()[iArr[3]];
            this.gender = BDFaceSDKCommon.BDFaceGender.values()[iArr[4]];
            this.emotionSeven = BDFaceSDKCommon.BDFaceEmotionEnum.values()[iArr[5]];
        }
        if (fArr5 == null || fArr5.length != 3) {
            return;
        }
        this.leftEyeclose = fArr5[0];
        this.rightEyeclose = fArr5[1];
        this.mouthclose = fArr5[2];
    }

    public FaceInfo(int i2, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), fArr, fArr2, fArr3, fArr4, fArr5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.faceID = i2;
        if (fArr != null && fArr.length == 6) {
            this.centerX = fArr[0];
            this.centerY = fArr[1];
            this.width = fArr[2];
            this.height = fArr[3];
            this.angle = fArr[4];
            this.score = fArr[5];
        }
        this.landmarks = fArr2;
        if (fArr3 != null && fArr3.length == 3) {
            this.yaw = fArr3[0];
            this.roll = fArr3[1];
            this.pitch = fArr3[2];
        }
        if (fArr4 != null && fArr4.length == 9) {
            this.occlusion = new BDFaceOcclusion(fArr4[0], fArr4[1], fArr4[2], fArr4[3], fArr4[4], fArr4[5], fArr4[6]);
            this.illum = (int) fArr4[7];
            this.bluriness = fArr4[8];
        }
        if (fArr5 == null || fArr5.length != 3) {
            return;
        }
        this.leftEyeclose = fArr5[0];
        this.rightEyeclose = fArr5[1];
        this.mouthclose = fArr5[2];
    }
}
