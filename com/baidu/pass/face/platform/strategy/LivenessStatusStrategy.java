package com.baidu.pass.face.platform.strategy;

import android.graphics.Rect;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class LivenessStatusStrategy {
    public static final String TAG = "LivenessStatusStrategy";
    public volatile int mLivenessIndex;
    public List<LivenessTypeEnum> mLivenessList;
    public boolean mLivenessTimeoutFlag = false;
    public volatile LivenessTypeEnum mCurrentLivenessTypeEnum = null;
    public long mFaceID = -1;
    public HashMap<LivenessTypeEnum, Boolean> mLivenessStatusMap = new HashMap<>();
    public long mQualityDuration = 0;
    public long mLivenessTimeDuration = 0;
    public long mLivenessDuration = 0;

    /* renamed from: com.baidu.pass.face.platform.strategy.LivenessStatusStrategy$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum;

        static {
            int[] iArr = new int[LivenessTypeEnum.values().length];
            $SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum = iArr;
            try {
                iArr[LivenessTypeEnum.Eye.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum[LivenessTypeEnum.Mouth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadUp.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadDown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadLeft.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadRight.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public LivenessStatusStrategy() {
        this.mLivenessIndex = 0;
        this.mLivenessIndex = 0;
    }

    private void clearLivenessStatus() {
        this.mLivenessStatusMap.clear();
        for (int i2 = 0; i2 < this.mLivenessList.size(); i2++) {
            this.mLivenessStatusMap.put(this.mLivenessList.get(i2), Boolean.FALSE);
        }
    }

    public int getCurrentLivenessCount() {
        return this.mLivenessIndex + 1;
    }

    public FaceStatusNewEnum getCurrentLivenessNewStatus() {
        if (this.mCurrentLivenessTypeEnum != null) {
            switch (AnonymousClass1.$SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum[this.mCurrentLivenessTypeEnum.ordinal()]) {
                case 1:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveEye;
                case 2:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth;
                case 3:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp;
                case 4:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown;
                case 5:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft;
                case 6:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight;
            }
        }
        return null;
    }

    public LivenessTypeEnum getCurrentLivenessType() {
        return this.mCurrentLivenessTypeEnum;
    }

    public boolean isCourseTimeout(FaceConfig faceConfig) {
        if (this.mLivenessDuration == 0) {
            this.mLivenessDuration = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.mLivenessDuration > faceConfig.getTimeLivenessCourse();
    }

    public boolean isCurrentLivenessSuccess() {
        boolean booleanValue = this.mLivenessStatusMap.containsKey(this.mCurrentLivenessTypeEnum) ? this.mLivenessStatusMap.get(this.mCurrentLivenessTypeEnum).booleanValue() : false;
        if (booleanValue) {
            this.mLivenessTimeDuration = 0L;
        }
        return booleanValue;
    }

    public boolean isExistNextLiveness() {
        return this.mLivenessIndex + 1 < this.mLivenessList.size();
    }

    public boolean isLivenessSuccess() {
        boolean z;
        Iterator<Map.Entry<LivenessTypeEnum, Boolean>> it = this.mLivenessStatusMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Map.Entry<LivenessTypeEnum, Boolean> next = it.next();
            if (!next.getValue().booleanValue()) {
                z = false;
                next.getKey().name();
                break;
            }
        }
        if (z) {
            this.mLivenessTimeDuration = 0L;
        }
        return z;
    }

    public boolean isTimeout() {
        return this.mLivenessTimeoutFlag;
    }

    public boolean nextLiveness() {
        if (this.mLivenessIndex + 1 < this.mLivenessList.size()) {
            this.mLivenessIndex++;
            this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
            this.mLivenessDuration = 0L;
            return true;
        }
        return false;
    }

    public void processLiveness(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, Rect rect) {
        if (this.mLivenessTimeDuration == 0) {
            this.mLivenessTimeDuration = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - this.mLivenessTimeDuration > FaceSDKManager.getInstance().getFaceConfig().getTimeDetectModule()) {
            this.mLivenessTimeoutFlag = true;
        } else if (faceExtInfo != null) {
            if (faceExtInfo.getFaceId() != this.mFaceID) {
                this.mFaceID = faceExtInfo.getFaceId();
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            switch (AnonymousClass1.$SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum[this.mCurrentLivenessTypeEnum.ordinal()]) {
                case 1:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFace_ACTION_LIVE_BLINK, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    break;
                case 2:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_OPEN_MOUTH, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    break;
                case 3:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_LOOK_UP, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    break;
                case 4:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_NOD, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    break;
                case 5:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_LEFT, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    break;
                case 6:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_RIGHT, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    break;
            }
            if (this.mLivenessList.contains(LivenessTypeEnum.Eye) && !this.mLivenessStatusMap.containsKey(LivenessTypeEnum.Eye)) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.Eye, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == LivenessTypeEnum.Eye && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.Eye, Boolean.valueOf(atomicInteger.get() == 1));
            }
            if (this.mLivenessList.contains(LivenessTypeEnum.Mouth) && !this.mLivenessStatusMap.containsKey(LivenessTypeEnum.Mouth)) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.Mouth, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == LivenessTypeEnum.Mouth && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.Mouth, Boolean.valueOf(atomicInteger.get() == 1));
            }
            if (this.mLivenessList.contains(LivenessTypeEnum.HeadUp) && !this.mLivenessStatusMap.containsKey(LivenessTypeEnum.HeadUp)) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.HeadUp, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == LivenessTypeEnum.HeadUp && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.HeadUp, Boolean.valueOf(atomicInteger.get() == 1));
            }
            if (this.mLivenessList.contains(LivenessTypeEnum.HeadDown) && !this.mLivenessStatusMap.containsKey(LivenessTypeEnum.HeadDown)) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.HeadDown, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == LivenessTypeEnum.HeadDown && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.HeadDown, Boolean.valueOf(atomicInteger.get() == 1));
            }
            if (this.mLivenessList.contains(LivenessTypeEnum.HeadLeft) && !this.mLivenessStatusMap.containsKey(LivenessTypeEnum.HeadLeft)) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.HeadLeft, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == LivenessTypeEnum.HeadLeft && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.HeadLeft, Boolean.valueOf(atomicInteger.get() == 1));
            }
            if (this.mLivenessList.contains(LivenessTypeEnum.HeadRight) && !this.mLivenessStatusMap.containsKey(LivenessTypeEnum.HeadRight)) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.HeadRight, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == LivenessTypeEnum.HeadRight && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(LivenessTypeEnum.HeadRight, Boolean.valueOf(atomicInteger.get() == 1));
            }
        }
    }

    public void reset() {
        this.mLivenessIndex = 0;
        clearLivenessStatus();
        if (this.mLivenessList != null && this.mLivenessIndex < this.mLivenessList.size()) {
            this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        }
        this.mLivenessDuration = 0L;
        this.mLivenessTimeoutFlag = false;
        this.mLivenessTimeDuration = 0L;
    }

    public void resetQualityTime() {
        this.mQualityDuration = System.currentTimeMillis();
    }

    public void resetState() {
        this.mLivenessDuration = 0L;
    }

    public void setLivenessList(List<LivenessTypeEnum> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mLivenessList = list;
        this.mCurrentLivenessTypeEnum = list.get(0);
        clearLivenessStatus();
    }

    public boolean showQualityTips() {
        return System.currentTimeMillis() - this.mQualityDuration > 0;
    }

    public void startNextLiveness() {
        this.mLivenessIndex++;
        this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        this.mLivenessDuration = 0L;
    }
}
