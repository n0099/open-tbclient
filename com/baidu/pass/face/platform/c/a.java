package com.baidu.pass.face.platform.c;

import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public FaceStatusNewEnum b;
    public long c;
    public boolean d;
    public float e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-360275712, "Lcom/baidu/pass/face/platform/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-360275712, "Lcom/baidu/pass/face/platform/c/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0L;
        this.d = false;
    }

    private void a(FaceStatusNewEnum faceStatusNewEnum, FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, faceStatusNewEnum, faceConfig) == null) || faceConfig == null) {
            return;
        }
        FaceStatusNewEnum faceStatusNewEnum2 = this.b;
        if (faceStatusNewEnum2 == null || faceStatusNewEnum2 != faceStatusNewEnum) {
            this.b = faceStatusNewEnum;
            this.c = System.currentTimeMillis();
            this.d = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.b != faceStatusNewEnum || currentTimeMillis - this.c <= faceConfig.getTimeDetectModule()) {
            return;
        }
        this.d = true;
    }

    private FaceStatusNewEnum b(FaceExtInfo[] faceExtInfoArr, Rect rect, boolean z, FaceConfig faceConfig) {
        InterceptResult invokeCommon;
        FaceStatusNewEnum faceStatusNewEnum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{faceExtInfoArr, rect, Boolean.valueOf(z), faceConfig})) == null) {
            FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.OK;
            FaceExtInfo faceExtInfo = faceExtInfoArr[0];
            this.e = 0.0f;
            if (!z) {
                if (faceExtInfo.getOcclusion().leftEye > faceConfig.getOcclusionLeftEyeValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye;
                }
                this.e += 1.0f - faceExtInfo.getOcclusion().leftEye;
                if (faceExtInfo.getOcclusion().rightEye > faceConfig.getOcclusionRightEyeValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye;
                }
                this.e += 1.0f - faceExtInfo.getOcclusion().rightEye;
                if (faceExtInfo.getOcclusion().nose > faceConfig.getOcclusionNoseValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionNose;
                }
                this.e += 1.0f - faceExtInfo.getOcclusion().nose;
                if (faceExtInfo.getOcclusion().mouth > faceConfig.getOcclusionMouthValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionMouth;
                }
                this.e += 1.0f - faceExtInfo.getOcclusion().mouth;
                if (faceExtInfo.getOcclusion().leftCheek > faceConfig.getOcclusionLeftContourValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour;
                }
                this.e += 1.0f - faceExtInfo.getOcclusion().leftCheek;
                if (faceExtInfo.getOcclusion().rightCheek > faceConfig.getOcclusionRightContourValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour;
                }
                this.e += 1.0f - faceExtInfo.getOcclusion().rightCheek;
                if (faceExtInfo.getOcclusion().chin > faceConfig.getOcclusionChinValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour;
                }
                this.e += 1.0f - faceExtInfo.getOcclusion().chin;
            }
            if (faceExtInfoArr[0].getFaceWidth() < rect.width() * faceConfig.getFaceFarRatio()) {
                faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeTooFar;
            } else if (faceExtInfoArr[0].getFaceWidth() <= rect.width() * faceConfig.getFaceClosedRatio()) {
                if (faceExtInfo.getPitch() < (-faceConfig.getHeadPitchValue()) - 2) {
                    return FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange;
                }
                if (faceExtInfo.getPitch() > faceConfig.getHeadPitchValue() - 2) {
                    return FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange;
                }
                this.e += (45.0f - Math.abs(faceExtInfo.getPitch())) / 45.0f;
                if (faceExtInfo.getYaw() > faceConfig.getHeadYawValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
                }
                if (faceExtInfo.getYaw() < (-faceConfig.getHeadYawValue())) {
                    return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
                }
                this.e += (45.0f - Math.abs(faceExtInfo.getYaw())) / 45.0f;
                if (faceExtInfo.getRoll() > faceConfig.getHeadRollValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
                }
                if (faceExtInfo.getRoll() < (-faceConfig.getHeadRollValue())) {
                    return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
                }
                this.e += (45.0f - Math.abs(faceExtInfo.getRoll())) / 45.0f;
                if (faceExtInfo.getBluriness() > faceConfig.getBlurnessValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeImageBlured;
                }
                this.e += 1.0f - faceExtInfo.getBluriness();
                if (faceExtInfo.getIllum() < faceConfig.getBrightnessValue()) {
                    return FaceStatusNewEnum.DetectRemindCodePoorIllumination;
                }
                if (faceExtInfo.getIllum() > faceConfig.getBrightnessMaxValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeMuchIllumination;
                }
                if (faceExtInfo.getLeftEyeClose() > faceConfig.getEyeClosedValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed;
                }
                this.e += 1.0f - faceExtInfo.getLeftEyeClose();
                if (faceExtInfo.getRightEyeClose() > faceConfig.getEyeClosedValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeRightEyeClosed;
                }
                this.e += 1.0f - faceExtInfo.getRightEyeClose();
                return faceStatusNewEnum2;
            } else {
                faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeTooClose;
            }
            a(faceStatusNewEnum, faceConfig);
            return faceStatusNewEnum;
        }
        return (FaceStatusNewEnum) invokeCommon.objValue;
    }

    public FaceStatusNewEnum a(Rect rect, FaceExtInfo[] faceExtInfoArr, FaceConfig faceConfig) {
        InterceptResult invokeLLL;
        FaceStatusNewEnum faceStatusNewEnum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, rect, faceExtInfoArr, faceConfig)) == null) {
            FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.OK;
            if (faceExtInfoArr == null || faceExtInfoArr.length <= 0 || faceExtInfoArr[0] == null || faceConfig == null) {
                faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
            } else if (faceExtInfoArr[0].getFaceWidth() > rect.width() * faceConfig.getFaceClosedRatio()) {
                faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeTooClose;
            } else if (faceExtInfoArr[0].getFaceWidth() < rect.width() * faceConfig.getFaceFarRatio()) {
                faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeTooFar;
            } else if (faceExtInfoArr[0].getLandmarksOutOfDetectCount(rect) <= 10) {
                return faceStatusNewEnum2;
            } else {
                faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame;
            }
            a(faceStatusNewEnum, faceConfig);
            return faceStatusNewEnum;
        }
        return (FaceStatusNewEnum) invokeLLL.objValue;
    }

    public FaceStatusNewEnum a(FaceExtInfo faceExtInfo, FaceConfig faceConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, faceExtInfo, faceConfig)) == null) {
            if (faceExtInfo == null || faceConfig == null) {
                return FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
            }
            this.e = 0.0f;
            if (faceExtInfo.getOcclusion().leftEye > faceConfig.getOcclusionLeftEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye;
            }
            this.e += 1.0f - faceExtInfo.getOcclusion().leftEye;
            if (faceExtInfo.getOcclusion().rightEye > faceConfig.getOcclusionRightEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye;
            }
            this.e += 1.0f - faceExtInfo.getOcclusion().rightEye;
            if (faceExtInfo.getOcclusion().nose > faceConfig.getOcclusionNoseValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionNose;
            }
            this.e += 1.0f - faceExtInfo.getOcclusion().nose;
            if (faceExtInfo.getOcclusion().mouth > faceConfig.getOcclusionMouthValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionMouth;
            }
            this.e += 1.0f - faceExtInfo.getOcclusion().mouth;
            if (faceExtInfo.getOcclusion().leftCheek > faceConfig.getOcclusionLeftContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour;
            }
            this.e += 1.0f - faceExtInfo.getOcclusion().leftCheek;
            if (faceExtInfo.getOcclusion().rightCheek > faceConfig.getOcclusionRightContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour;
            }
            this.e += 1.0f - faceExtInfo.getOcclusion().rightCheek;
            if (faceExtInfo.getOcclusion().chin > faceConfig.getOcclusionChinValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour;
            }
            this.e += 1.0f - faceExtInfo.getOcclusion().chin;
            if (faceExtInfo.getPitch() < (-faceConfig.getHeadPitchValue()) - 2) {
                return FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange;
            }
            if (faceExtInfo.getPitch() > faceConfig.getHeadPitchValue() - 2) {
                return FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange;
            }
            this.e += (45.0f - Math.abs(faceExtInfo.getPitch())) / 45.0f;
            if (faceExtInfo.getYaw() < (-faceConfig.getHeadYawValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            if (faceExtInfo.getYaw() > faceConfig.getHeadYawValue()) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            this.e += (45.0f - Math.abs(faceExtInfo.getYaw())) / 45.0f;
            if (faceExtInfo.getRoll() > faceConfig.getHeadRollValue()) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            if (faceExtInfo.getRoll() < (-faceConfig.getHeadRollValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            this.e += (45.0f - Math.abs(faceExtInfo.getRoll())) / 45.0f;
            if (faceExtInfo.getBluriness() > faceConfig.getBlurnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodeImageBlured;
            }
            this.e += 1.0f - faceExtInfo.getBluriness();
            if (faceExtInfo.getIllum() < faceConfig.getBrightnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodePoorIllumination;
            }
            if (faceExtInfo.getIllum() > faceConfig.getBrightnessMaxValue()) {
                return FaceStatusNewEnum.DetectRemindCodeMuchIllumination;
            }
            if (faceExtInfo.getLeftEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed;
            }
            this.e += 1.0f - faceExtInfo.getLeftEyeClose();
            if (faceExtInfo.getRightEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeRightEyeClosed;
            }
            this.e += 1.0f - faceExtInfo.getRightEyeClose();
            return FaceStatusNewEnum.OK;
        }
        return (FaceStatusNewEnum) invokeLL.objValue;
    }

    public FaceStatusNewEnum a(FaceExtInfo[] faceExtInfoArr, Rect rect, boolean z, FaceConfig faceConfig) {
        InterceptResult invokeCommon;
        FaceStatusNewEnum faceStatusNewEnum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{faceExtInfoArr, rect, Boolean.valueOf(z), faceConfig})) == null) {
            FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.OK;
            if (faceExtInfoArr == null || faceExtInfoArr.length <= 0 || faceExtInfoArr[0] == null || faceConfig == null) {
                faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
            } else if (faceExtInfoArr[0].getLandmarksOutOfDetectCount(rect) <= 10) {
                return b(faceExtInfoArr, rect, z, faceConfig);
            } else {
                faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame;
            }
            a(faceStatusNewEnum, faceConfig);
            return faceStatusNewEnum;
        }
        return (FaceStatusNewEnum) invokeCommon.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : invokeV.floatValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = 0L;
            this.d = false;
            this.b = null;
            this.e = 0.0f;
        }
    }
}
