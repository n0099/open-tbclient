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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public FaceStatusNewEnum f28074b;

    /* renamed from: c  reason: collision with root package name */
    public long f28075c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28076d;

    /* renamed from: e  reason: collision with root package name */
    public float f28077e;

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
        this.f28075c = 0L;
        this.f28076d = false;
    }

    private void a(FaceStatusNewEnum faceStatusNewEnum, FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, faceStatusNewEnum, faceConfig) == null) || faceConfig == null) {
            return;
        }
        FaceStatusNewEnum faceStatusNewEnum2 = this.f28074b;
        if (faceStatusNewEnum2 == null || faceStatusNewEnum2 != faceStatusNewEnum) {
            this.f28074b = faceStatusNewEnum;
            this.f28075c = System.currentTimeMillis();
            this.f28076d = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f28074b != faceStatusNewEnum || currentTimeMillis - this.f28075c <= faceConfig.getTimeDetectModule()) {
            return;
        }
        this.f28076d = true;
    }

    private FaceStatusNewEnum b(FaceExtInfo[] faceExtInfoArr, Rect rect, boolean z, FaceConfig faceConfig) {
        InterceptResult invokeCommon;
        FaceStatusNewEnum faceStatusNewEnum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{faceExtInfoArr, rect, Boolean.valueOf(z), faceConfig})) == null) {
            FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.OK;
            FaceExtInfo faceExtInfo = faceExtInfoArr[0];
            this.f28077e = 0.0f;
            if (!z) {
                if (faceExtInfo.getOcclusion().leftEye > faceConfig.getOcclusionLeftEyeValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye;
                }
                this.f28077e += 1.0f - faceExtInfo.getOcclusion().leftEye;
                if (faceExtInfo.getOcclusion().rightEye > faceConfig.getOcclusionRightEyeValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye;
                }
                this.f28077e += 1.0f - faceExtInfo.getOcclusion().rightEye;
                if (faceExtInfo.getOcclusion().nose > faceConfig.getOcclusionNoseValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionNose;
                }
                this.f28077e += 1.0f - faceExtInfo.getOcclusion().nose;
                if (faceExtInfo.getOcclusion().mouth > faceConfig.getOcclusionMouthValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionMouth;
                }
                this.f28077e += 1.0f - faceExtInfo.getOcclusion().mouth;
                if (faceExtInfo.getOcclusion().leftCheek > faceConfig.getOcclusionLeftContourValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour;
                }
                this.f28077e += 1.0f - faceExtInfo.getOcclusion().leftCheek;
                if (faceExtInfo.getOcclusion().rightCheek > faceConfig.getOcclusionRightContourValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour;
                }
                this.f28077e += 1.0f - faceExtInfo.getOcclusion().rightCheek;
                if (faceExtInfo.getOcclusion().chin > faceConfig.getOcclusionChinValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour;
                }
                this.f28077e += 1.0f - faceExtInfo.getOcclusion().chin;
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
                this.f28077e += (45.0f - Math.abs(faceExtInfo.getPitch())) / 45.0f;
                if (faceExtInfo.getYaw() > faceConfig.getHeadYawValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
                }
                if (faceExtInfo.getYaw() < (-faceConfig.getHeadYawValue())) {
                    return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
                }
                this.f28077e += (45.0f - Math.abs(faceExtInfo.getYaw())) / 45.0f;
                if (faceExtInfo.getRoll() > faceConfig.getHeadRollValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
                }
                if (faceExtInfo.getRoll() < (-faceConfig.getHeadRollValue())) {
                    return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
                }
                this.f28077e += (45.0f - Math.abs(faceExtInfo.getRoll())) / 45.0f;
                if (faceExtInfo.getBluriness() > faceConfig.getBlurnessValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeImageBlured;
                }
                this.f28077e += 1.0f - faceExtInfo.getBluriness();
                if (faceExtInfo.getIllum() < faceConfig.getBrightnessValue()) {
                    return FaceStatusNewEnum.DetectRemindCodePoorIllumination;
                }
                if (faceExtInfo.getIllum() > faceConfig.getBrightnessMaxValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeMuchIllumination;
                }
                if (faceExtInfo.getLeftEyeClose() > faceConfig.getEyeClosedValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed;
                }
                this.f28077e += 1.0f - faceExtInfo.getLeftEyeClose();
                if (faceExtInfo.getRightEyeClose() > faceConfig.getEyeClosedValue()) {
                    return FaceStatusNewEnum.DetectRemindCodeRightEyeClosed;
                }
                this.f28077e += 1.0f - faceExtInfo.getRightEyeClose();
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
            this.f28077e = 0.0f;
            if (faceExtInfo.getOcclusion().leftEye > faceConfig.getOcclusionLeftEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye;
            }
            this.f28077e += 1.0f - faceExtInfo.getOcclusion().leftEye;
            if (faceExtInfo.getOcclusion().rightEye > faceConfig.getOcclusionRightEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye;
            }
            this.f28077e += 1.0f - faceExtInfo.getOcclusion().rightEye;
            if (faceExtInfo.getOcclusion().nose > faceConfig.getOcclusionNoseValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionNose;
            }
            this.f28077e += 1.0f - faceExtInfo.getOcclusion().nose;
            if (faceExtInfo.getOcclusion().mouth > faceConfig.getOcclusionMouthValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionMouth;
            }
            this.f28077e += 1.0f - faceExtInfo.getOcclusion().mouth;
            if (faceExtInfo.getOcclusion().leftCheek > faceConfig.getOcclusionLeftContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour;
            }
            this.f28077e += 1.0f - faceExtInfo.getOcclusion().leftCheek;
            if (faceExtInfo.getOcclusion().rightCheek > faceConfig.getOcclusionRightContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour;
            }
            this.f28077e += 1.0f - faceExtInfo.getOcclusion().rightCheek;
            if (faceExtInfo.getOcclusion().chin > faceConfig.getOcclusionChinValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour;
            }
            this.f28077e += 1.0f - faceExtInfo.getOcclusion().chin;
            if (faceExtInfo.getPitch() < (-faceConfig.getHeadPitchValue()) - 2) {
                return FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange;
            }
            if (faceExtInfo.getPitch() > faceConfig.getHeadPitchValue() - 2) {
                return FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange;
            }
            this.f28077e += (45.0f - Math.abs(faceExtInfo.getPitch())) / 45.0f;
            if (faceExtInfo.getYaw() < (-faceConfig.getHeadYawValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            if (faceExtInfo.getYaw() > faceConfig.getHeadYawValue()) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            this.f28077e += (45.0f - Math.abs(faceExtInfo.getYaw())) / 45.0f;
            if (faceExtInfo.getRoll() > faceConfig.getHeadRollValue()) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            if (faceExtInfo.getRoll() < (-faceConfig.getHeadRollValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            this.f28077e += (45.0f - Math.abs(faceExtInfo.getRoll())) / 45.0f;
            if (faceExtInfo.getBluriness() > faceConfig.getBlurnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodeImageBlured;
            }
            this.f28077e += 1.0f - faceExtInfo.getBluriness();
            if (faceExtInfo.getIllum() < faceConfig.getBrightnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodePoorIllumination;
            }
            if (faceExtInfo.getIllum() > faceConfig.getBrightnessMaxValue()) {
                return FaceStatusNewEnum.DetectRemindCodeMuchIllumination;
            }
            if (faceExtInfo.getLeftEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed;
            }
            this.f28077e += 1.0f - faceExtInfo.getLeftEyeClose();
            if (faceExtInfo.getRightEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeRightEyeClosed;
            }
            this.f28077e += 1.0f - faceExtInfo.getRightEyeClose();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28076d : invokeV.booleanValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28077e : invokeV.floatValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28075c = 0L;
            this.f28076d = false;
            this.f28074b = null;
            this.f28077e = 0.0f;
        }
    }
}
