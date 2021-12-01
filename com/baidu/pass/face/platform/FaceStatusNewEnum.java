package com.baidu.pass.face.platform;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class FaceStatusNewEnum {
    public static final /* synthetic */ FaceStatusNewEnum[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FaceStatusNewEnum DetectRemindCodeBeyondPreviewFrame;
    public static final FaceStatusNewEnum DetectRemindCodeImageBlured;
    public static final FaceStatusNewEnum DetectRemindCodeLeftEyeClosed;
    public static final FaceStatusNewEnum DetectRemindCodeMuchIllumination;
    public static final FaceStatusNewEnum DetectRemindCodeNoFaceDetected;
    public static final FaceStatusNewEnum DetectRemindCodeNoPreviewFrameCenter;
    public static final FaceStatusNewEnum DetectRemindCodeOcclusionChinContour;
    public static final FaceStatusNewEnum DetectRemindCodeOcclusionLeftContour;
    public static final FaceStatusNewEnum DetectRemindCodeOcclusionLeftEye;
    public static final FaceStatusNewEnum DetectRemindCodeOcclusionMouth;
    public static final FaceStatusNewEnum DetectRemindCodeOcclusionNose;
    public static final FaceStatusNewEnum DetectRemindCodeOcclusionRightContour;
    public static final FaceStatusNewEnum DetectRemindCodeOcclusionRightEye;
    public static final FaceStatusNewEnum DetectRemindCodePitchOutofDownRange;
    public static final FaceStatusNewEnum DetectRemindCodePitchOutofUpRange;
    public static final FaceStatusNewEnum DetectRemindCodePoorIllumination;
    public static final FaceStatusNewEnum DetectRemindCodeRightEyeClosed;
    public static final FaceStatusNewEnum DetectRemindCodeTimeout;
    public static final FaceStatusNewEnum DetectRemindCodeTooClose;
    public static final FaceStatusNewEnum DetectRemindCodeTooFar;
    public static final FaceStatusNewEnum DetectRemindCodeYawOutofLeftRange;
    public static final FaceStatusNewEnum DetectRemindCodeYawOutofRightRange;
    public static final FaceStatusNewEnum FaceLivenessActionCodeTimeout;
    public static final FaceStatusNewEnum FaceLivenessActionComplete;
    public static final FaceStatusNewEnum FaceLivenessActionTypeLiveEye;
    public static final FaceStatusNewEnum FaceLivenessActionTypeLiveMouth;
    public static final FaceStatusNewEnum FaceLivenessActionTypeLivePitchDown;
    public static final FaceStatusNewEnum FaceLivenessActionTypeLivePitchUp;
    public static final FaceStatusNewEnum FaceLivenessActionTypeLiveYaw;
    public static final FaceStatusNewEnum FaceLivenessActionTypeLiveYawLeft;
    public static final FaceStatusNewEnum FaceLivenessActionTypeLiveYawRight;
    public static final FaceStatusNewEnum OK;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1219177955, "Lcom/baidu/pass/face/platform/FaceStatusNewEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1219177955, "Lcom/baidu/pass/face/platform/FaceStatusNewEnum;");
                return;
            }
        }
        OK = new FaceStatusNewEnum(StatHelper.SENSOR_OK, 0);
        DetectRemindCodeBeyondPreviewFrame = new FaceStatusNewEnum("DetectRemindCodeBeyondPreviewFrame", 1);
        DetectRemindCodeNoFaceDetected = new FaceStatusNewEnum("DetectRemindCodeNoFaceDetected", 2);
        DetectRemindCodeMuchIllumination = new FaceStatusNewEnum("DetectRemindCodeMuchIllumination", 3);
        DetectRemindCodePoorIllumination = new FaceStatusNewEnum("DetectRemindCodePoorIllumination", 4);
        DetectRemindCodeImageBlured = new FaceStatusNewEnum("DetectRemindCodeImageBlured", 5);
        DetectRemindCodeTooFar = new FaceStatusNewEnum("DetectRemindCodeTooFar", 6);
        DetectRemindCodeTooClose = new FaceStatusNewEnum("DetectRemindCodeTooClose", 7);
        DetectRemindCodePitchOutofDownRange = new FaceStatusNewEnum("DetectRemindCodePitchOutofDownRange", 8);
        DetectRemindCodePitchOutofUpRange = new FaceStatusNewEnum("DetectRemindCodePitchOutofUpRange", 9);
        DetectRemindCodeYawOutofLeftRange = new FaceStatusNewEnum("DetectRemindCodeYawOutofLeftRange", 10);
        DetectRemindCodeYawOutofRightRange = new FaceStatusNewEnum("DetectRemindCodeYawOutofRightRange", 11);
        DetectRemindCodeOcclusionLeftEye = new FaceStatusNewEnum("DetectRemindCodeOcclusionLeftEye", 12);
        DetectRemindCodeOcclusionRightEye = new FaceStatusNewEnum("DetectRemindCodeOcclusionRightEye", 13);
        DetectRemindCodeOcclusionNose = new FaceStatusNewEnum("DetectRemindCodeOcclusionNose", 14);
        DetectRemindCodeOcclusionMouth = new FaceStatusNewEnum("DetectRemindCodeOcclusionMouth", 15);
        DetectRemindCodeOcclusionLeftContour = new FaceStatusNewEnum("DetectRemindCodeOcclusionLeftContour", 16);
        DetectRemindCodeOcclusionRightContour = new FaceStatusNewEnum("DetectRemindCodeOcclusionRightContour", 17);
        DetectRemindCodeOcclusionChinContour = new FaceStatusNewEnum("DetectRemindCodeOcclusionChinContour", 18);
        DetectRemindCodeTimeout = new FaceStatusNewEnum("DetectRemindCodeTimeout", 19);
        FaceLivenessActionTypeLiveEye = new FaceStatusNewEnum("FaceLivenessActionTypeLiveEye", 20);
        FaceLivenessActionTypeLiveMouth = new FaceStatusNewEnum("FaceLivenessActionTypeLiveMouth", 21);
        FaceLivenessActionTypeLiveYawRight = new FaceStatusNewEnum("FaceLivenessActionTypeLiveYawRight", 22);
        FaceLivenessActionTypeLiveYawLeft = new FaceStatusNewEnum("FaceLivenessActionTypeLiveYawLeft", 23);
        FaceLivenessActionTypeLivePitchUp = new FaceStatusNewEnum("FaceLivenessActionTypeLivePitchUp", 24);
        FaceLivenessActionTypeLivePitchDown = new FaceStatusNewEnum("FaceLivenessActionTypeLivePitchDown", 25);
        FaceLivenessActionTypeLiveYaw = new FaceStatusNewEnum("FaceLivenessActionTypeLiveYaw", 26);
        FaceLivenessActionComplete = new FaceStatusNewEnum("FaceLivenessActionComplete", 27);
        FaceLivenessActionCodeTimeout = new FaceStatusNewEnum("FaceLivenessActionCodeTimeout", 28);
        DetectRemindCodeLeftEyeClosed = new FaceStatusNewEnum("DetectRemindCodeLeftEyeClosed", 29);
        DetectRemindCodeRightEyeClosed = new FaceStatusNewEnum("DetectRemindCodeRightEyeClosed", 30);
        FaceStatusNewEnum faceStatusNewEnum = new FaceStatusNewEnum("DetectRemindCodeNoPreviewFrameCenter", 31);
        DetectRemindCodeNoPreviewFrameCenter = faceStatusNewEnum;
        $VALUES = new FaceStatusNewEnum[]{OK, DetectRemindCodeBeyondPreviewFrame, DetectRemindCodeNoFaceDetected, DetectRemindCodeMuchIllumination, DetectRemindCodePoorIllumination, DetectRemindCodeImageBlured, DetectRemindCodeTooFar, DetectRemindCodeTooClose, DetectRemindCodePitchOutofDownRange, DetectRemindCodePitchOutofUpRange, DetectRemindCodeYawOutofLeftRange, DetectRemindCodeYawOutofRightRange, DetectRemindCodeOcclusionLeftEye, DetectRemindCodeOcclusionRightEye, DetectRemindCodeOcclusionNose, DetectRemindCodeOcclusionMouth, DetectRemindCodeOcclusionLeftContour, DetectRemindCodeOcclusionRightContour, DetectRemindCodeOcclusionChinContour, DetectRemindCodeTimeout, FaceLivenessActionTypeLiveEye, FaceLivenessActionTypeLiveMouth, FaceLivenessActionTypeLiveYawRight, FaceLivenessActionTypeLiveYawLeft, FaceLivenessActionTypeLivePitchUp, FaceLivenessActionTypeLivePitchDown, FaceLivenessActionTypeLiveYaw, FaceLivenessActionComplete, FaceLivenessActionCodeTimeout, DetectRemindCodeLeftEyeClosed, DetectRemindCodeRightEyeClosed, faceStatusNewEnum};
    }

    public FaceStatusNewEnum(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static FaceStatusNewEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FaceStatusNewEnum) Enum.valueOf(FaceStatusNewEnum.class, str) : (FaceStatusNewEnum) invokeL.objValue;
    }

    public static FaceStatusNewEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FaceStatusNewEnum[]) $VALUES.clone() : (FaceStatusNewEnum[]) invokeV.objValue;
    }
}
