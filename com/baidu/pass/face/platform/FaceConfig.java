package com.baidu.pass.face.platform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/* loaded from: classes2.dex */
public class FaceConfig implements Serializable {
    public static final String TAG = FaceConfig.class.getSimpleName();
    public int minFaceSize = 200;
    public float notFaceValue = 0.6f;
    public float brightnessValue = 82.0f;
    public float brightnessMaxValue = 200.0f;
    public float blurnessValue = 0.7f;
    public float occlusionValue = 0.5f;
    public float occlusionLeftEyeValue = 0.5f;
    public float occlusionRightEyeValue = 0.5f;
    public float occlusionNoseValue = 0.5f;
    public float occlusionMouthValue = 0.5f;
    public float occlusionLeftContourValue = 0.5f;
    public float occlusionRightContourValue = 0.5f;
    public float occlusionChinValue = 0.5f;
    public int headPitchValue = 8;
    public int headYawValue = 8;
    public int headRollValue = 8;
    public float eyeClosedValue = 0.7f;
    public boolean isSound = true;
    public boolean isLivenessRandom = false;
    public int cacheImageNum = 3;
    public int livenessRandomCount = 3;
    public List<LivenessTypeEnum> livenessTypeList = FaceEnvironment.livenessTypeDefaultList;
    public boolean isOpenOnline = true;
    public int outputImageType = 1;
    public int cropHeight = 640;
    public int cropWidth = 480;
    public float enlargeRatio = 1.5f;
    public float scale = 1.0f;
    public int secType = 1;
    public float maskValue = 0.7f;
    public boolean isOpenMask = true;
    public long timeDetectModule = 15000;
    public long timeLivenessCourse = 5000;
    public int qualityLevel = 0;
    public float faceFarRatio = 0.4f;
    public float faceClosedRatio = 1.0f;

    public static List<LivenessTypeEnum> getRandomList(List<LivenessTypeEnum> list, int i2) {
        if (list.size() < i2) {
            return list;
        }
        Random random = new Random();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < i2) {
            int nextInt = random.nextInt(list.size());
            if (arrayList.contains(Integer.valueOf(nextInt))) {
                i3--;
            } else {
                arrayList.add(Integer.valueOf(nextInt));
                arrayList2.add(list.get(nextInt));
            }
            i3++;
        }
        return arrayList2;
    }

    public float getBlurnessValue() {
        return this.blurnessValue;
    }

    public float getBrightnessMaxValue() {
        return this.brightnessMaxValue;
    }

    public float getBrightnessValue() {
        return this.brightnessValue;
    }

    public int getCacheImageNum() {
        return this.cacheImageNum;
    }

    public int getCropHeight() {
        return this.cropHeight;
    }

    public int getCropWidth() {
        return this.cropWidth;
    }

    public float getEnlargeRatio() {
        return this.enlargeRatio;
    }

    public float getEyeClosedValue() {
        return this.eyeClosedValue;
    }

    public float getFaceClosedRatio() {
        return this.faceClosedRatio;
    }

    public float getFaceFarRatio() {
        return this.faceFarRatio;
    }

    public int getHeadPitchValue() {
        return this.headPitchValue;
    }

    public int getHeadRollValue() {
        return this.headRollValue;
    }

    public int getHeadYawValue() {
        return this.headYawValue;
    }

    public int getLivenessRandomCount() {
        return this.livenessRandomCount;
    }

    public List<LivenessTypeEnum> getLivenessTypeList() {
        List<LivenessTypeEnum> list = this.livenessTypeList;
        if (list != null && list.size() != 0) {
            if (this.isLivenessRandom) {
                List<LivenessTypeEnum> list2 = this.livenessTypeList;
                return getRandomList(list2, list2.size());
            }
        } else {
            ArrayList arrayList = new ArrayList();
            this.livenessTypeList = arrayList;
            arrayList.addAll(FaceEnvironment.livenessTypeDefaultList);
            Collections.shuffle(this.livenessTypeList);
            this.livenessTypeList = this.livenessTypeList.subList(0, getLivenessRandomCount());
        }
        return this.livenessTypeList;
    }

    public float getMaskValue() {
        return this.maskValue;
    }

    public int getMinFaceSize() {
        return this.minFaceSize;
    }

    public float getNotFaceValue() {
        return this.notFaceValue;
    }

    public float getOcclusionChinValue() {
        return this.occlusionChinValue;
    }

    public float getOcclusionLeftContourValue() {
        return this.occlusionLeftContourValue;
    }

    public float getOcclusionLeftEyeValue() {
        return this.occlusionLeftEyeValue;
    }

    public float getOcclusionMouthValue() {
        return this.occlusionMouthValue;
    }

    public float getOcclusionNoseValue() {
        return this.occlusionNoseValue;
    }

    public float getOcclusionRightContourValue() {
        return this.occlusionRightContourValue;
    }

    public float getOcclusionRightEyeValue() {
        return this.occlusionRightEyeValue;
    }

    public float getOcclusionValue() {
        return this.occlusionValue;
    }

    public int getOutputImageType() {
        return this.outputImageType;
    }

    public int getQualityLevel() {
        return this.qualityLevel;
    }

    public float getScale() {
        return this.scale;
    }

    public int getSecType() {
        return this.secType;
    }

    public long getTimeDetectModule() {
        return this.timeDetectModule;
    }

    public long getTimeLivenessCourse() {
        return this.timeLivenessCourse;
    }

    public boolean isLivenessRandom() {
        return this.isLivenessRandom;
    }

    public boolean isOpenMask() {
        return this.isOpenMask;
    }

    public boolean isOpenOnline() {
        return this.isOpenOnline;
    }

    public boolean isSound() {
        return this.isSound;
    }

    public void setBlurnessValue(float f2) {
        this.blurnessValue = f2;
    }

    public void setBrightnessMaxValue(float f2) {
        this.brightnessMaxValue = f2;
    }

    public void setBrightnessValue(float f2) {
        this.brightnessValue = f2;
    }

    public void setCacheImageNum(int i2) {
        this.cacheImageNum = i2;
    }

    public void setCropHeight(int i2) {
        this.cropHeight = i2;
    }

    public void setCropWidth(int i2) {
        this.cropWidth = i2;
    }

    public void setEnlargeRatio(float f2) {
        this.enlargeRatio = f2;
    }

    public void setEyeClosedValue(float f2) {
        this.eyeClosedValue = f2;
    }

    public void setFaceClosedRatio(float f2) {
        this.faceClosedRatio = f2;
    }

    public void setFaceFarRatio(float f2) {
        this.faceFarRatio = f2;
    }

    public void setHeadPitchValue(int i2) {
        this.headPitchValue = i2;
    }

    public void setHeadRollValue(int i2) {
        this.headRollValue = i2;
    }

    public void setHeadYawValue(int i2) {
        this.headYawValue = i2;
    }

    public void setLivenessRandom(boolean z) {
        this.isLivenessRandom = z;
    }

    public void setLivenessRandomCount(int i2) {
        int size = FaceEnvironment.livenessTypeDefaultList.size();
        if (i2 > size) {
            i2 = size;
        }
        this.livenessRandomCount = i2;
    }

    public void setLivenessTypeList(List<LivenessTypeEnum> list) {
        this.livenessTypeList = list;
    }

    public void setMaskValue(float f2) {
        this.maskValue = f2;
    }

    public void setMinFaceSize(int i2) {
        this.minFaceSize = i2;
    }

    public void setNotFaceValue(float f2) {
        this.notFaceValue = f2;
    }

    public void setOcclusionChinValue(float f2) {
        this.occlusionChinValue = f2;
    }

    public void setOcclusionLeftContourValue(float f2) {
        this.occlusionLeftContourValue = f2;
    }

    public void setOcclusionLeftEyeValue(float f2) {
        this.occlusionLeftEyeValue = f2;
    }

    public void setOcclusionMouthValue(float f2) {
        this.occlusionMouthValue = f2;
    }

    public void setOcclusionNoseValue(float f2) {
        this.occlusionNoseValue = f2;
    }

    public void setOcclusionRightContourValue(float f2) {
        this.occlusionRightContourValue = f2;
    }

    public void setOcclusionRightEyeValue(float f2) {
        this.occlusionRightEyeValue = f2;
    }

    public void setOcclusionValue(float f2) {
        this.occlusionValue = f2;
    }

    public void setOpenMask(boolean z) {
        this.isOpenMask = z;
    }

    public void setOpenOnline(boolean z) {
        this.isOpenOnline = z;
    }

    public void setOutputImageType(int i2) {
        this.outputImageType = i2;
    }

    public void setQualityLevel(int i2) {
        this.qualityLevel = i2;
    }

    public void setScale(float f2) {
        this.scale = f2;
    }

    public void setSecType(int i2) {
        this.secType = i2;
    }

    public void setSound(boolean z) {
        this.isSound = z;
    }

    public void setTimeDetectModule(long j) {
        this.timeDetectModule = j;
    }

    public void setTimeLivenessCourse(long j) {
        this.timeLivenessCourse = j;
    }
}
