package com.baidu.pass.face.platform.c;

import android.graphics.Rect;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
/* loaded from: classes3.dex */
public class a {
    public static final String a = "a";
    public FaceStatusNewEnum b;
    public long c = 0;
    public boolean d = false;
    public float e;

    private void a(FaceStatusNewEnum faceStatusNewEnum, FaceConfig faceConfig) {
        if (faceConfig == null) {
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
        FaceStatusNewEnum faceStatusNewEnum;
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

    public FaceStatusNewEnum a(Rect rect, FaceExtInfo[] faceExtInfoArr, FaceConfig faceConfig) {
        FaceStatusNewEnum faceStatusNewEnum;
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

    public FaceStatusNewEnum a(FaceExtInfo faceExtInfo, FaceConfig faceConfig) {
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

    public FaceStatusNewEnum a(FaceExtInfo[] faceExtInfoArr, Rect rect, boolean z, FaceConfig faceConfig) {
        FaceStatusNewEnum faceStatusNewEnum;
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

    public boolean a() {
        return this.d;
    }

    public float b() {
        return this.e;
    }

    public void c() {
        this.c = 0L;
        this.d = false;
        this.b = null;
        this.e = 0.0f;
    }
}
