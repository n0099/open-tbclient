package com.baidu.pass.biometrics.face.liveness.c;

import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, R.string.obfuscated_res_0x7f0f04cd);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame, R.string.obfuscated_res_0x7f0f04cd);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodePoorIllumination, R.string.obfuscated_res_0x7f0f04d4);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeImageBlured, R.string.obfuscated_res_0x7f0f04d2);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye, R.string.obfuscated_res_0x7f0f04d9);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye, R.string.obfuscated_res_0x7f0f04dd);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionNose, R.string.obfuscated_res_0x7f0f04db);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionMouth, R.string.obfuscated_res_0x7f0f04da);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour, R.string.obfuscated_res_0x7f0f04d8);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour, R.string.obfuscated_res_0x7f0f04dc);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour, R.string.obfuscated_res_0x7f0f04d6);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange, R.string.obfuscated_res_0x7f0f04ce);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange, R.string.obfuscated_res_0x7f0f04d1);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange, R.string.obfuscated_res_0x7f0f04d0);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange, R.string.obfuscated_res_0x7f0f04cf);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeTooFar, R.string.obfuscated_res_0x7f0f04e1);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeTooClose, R.string.obfuscated_res_0x7f0f04e2);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed, R.string.obfuscated_res_0x7f0f04d3);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeRightEyeClosed, R.string.obfuscated_res_0x7f0f04de);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.FaceLivenessActionTypeLiveEye, R.string.obfuscated_res_0x7f0f0a24);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth, R.string.obfuscated_res_0x7f0f0a2a);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp, R.string.obfuscated_res_0x7f0f0a29);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown, R.string.obfuscated_res_0x7f0f0a26);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft, R.string.obfuscated_res_0x7f0f0a27);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight, R.string.obfuscated_res_0x7f0f0a28);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.FaceLivenessActionComplete, R.string.obfuscated_res_0x7f0f0a25);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.OK, R.string.obfuscated_res_0x7f0f0a25);
            FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeTimeout, R.string.obfuscated_res_0x7f0f04e0);
        }
    }
}
