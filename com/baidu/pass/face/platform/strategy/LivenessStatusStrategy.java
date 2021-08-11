package com.baidu.pass.face.platform.strategy;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class LivenessStatusStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LivenessStatusStrategy";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile LivenessTypeEnum mCurrentLivenessTypeEnum;
    public long mFaceID;
    public long mLivenessDuration;
    public volatile int mLivenessIndex;
    public List<LivenessTypeEnum> mLivenessList;
    public HashMap<LivenessTypeEnum, Boolean> mLivenessStatusMap;
    public long mLivenessTimeDuration;
    public boolean mLivenessTimeoutFlag;
    public long mQualityDuration;

    /* renamed from: com.baidu.pass.face.platform.strategy.LivenessStatusStrategy$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$face$platform$LivenessTypeEnum;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(225672516, "Lcom/baidu/pass/face/platform/strategy/LivenessStatusStrategy$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(225672516, "Lcom/baidu/pass/face/platform/strategy/LivenessStatusStrategy$1;");
                    return;
                }
            }
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1304791631, "Lcom/baidu/pass/face/platform/strategy/LivenessStatusStrategy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1304791631, "Lcom/baidu/pass/face/platform/strategy/LivenessStatusStrategy;");
        }
    }

    public LivenessStatusStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLivenessIndex = 0;
        this.mLivenessTimeoutFlag = false;
        this.mCurrentLivenessTypeEnum = null;
        this.mFaceID = -1L;
        this.mLivenessStatusMap = new HashMap<>();
        this.mQualityDuration = 0L;
        this.mLivenessTimeDuration = 0L;
        this.mLivenessIndex = 0;
        this.mLivenessDuration = 0L;
    }

    private void clearLivenessStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mLivenessStatusMap.clear();
            for (int i2 = 0; i2 < this.mLivenessList.size(); i2++) {
                this.mLivenessStatusMap.put(this.mLivenessList.get(i2), Boolean.FALSE);
            }
        }
    }

    public int getCurrentLivenessCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mLivenessIndex + 1 : invokeV.intValue;
    }

    public FaceStatusNewEnum getCurrentLivenessNewStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return (FaceStatusNewEnum) invokeV.objValue;
    }

    public LivenessTypeEnum getCurrentLivenessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrentLivenessTypeEnum : (LivenessTypeEnum) invokeV.objValue;
    }

    public boolean isCourseTimeout(FaceConfig faceConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, faceConfig)) == null) {
            if (this.mLivenessDuration == 0) {
                this.mLivenessDuration = System.currentTimeMillis();
            }
            return System.currentTimeMillis() - this.mLivenessDuration > faceConfig.getTimeLivenessCourse();
        }
        return invokeL.booleanValue;
    }

    public boolean isCurrentLivenessSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean booleanValue = this.mLivenessStatusMap.containsKey(this.mCurrentLivenessTypeEnum) ? this.mLivenessStatusMap.get(this.mCurrentLivenessTypeEnum).booleanValue() : false;
            if (booleanValue) {
                this.mLivenessTimeDuration = 0L;
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public boolean isExistNextLiveness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLivenessIndex + 1 < this.mLivenessList.size() : invokeV.booleanValue;
    }

    public boolean isLivenessSuccess() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLivenessTimeoutFlag : invokeV.booleanValue;
    }

    public boolean nextLiveness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mLivenessIndex + 1 < this.mLivenessList.size()) {
                this.mLivenessIndex++;
                this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
                this.mLivenessDuration = 0L;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void processLiveness(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, faceExtInfo, bDFaceImageInstance, rect) == null) {
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
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mLivenessIndex = 0;
            clearLivenessStatus();
            if (this.mLivenessList != null && this.mLivenessIndex < this.mLivenessList.size()) {
                this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
            }
            this.mLivenessDuration = 0L;
            this.mLivenessTimeoutFlag = false;
            this.mLivenessTimeDuration = 0L;
        }
    }

    public void resetQualityTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mQualityDuration = System.currentTimeMillis();
        }
    }

    public void resetState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mLivenessDuration = 0L;
        }
    }

    public void setLivenessList(List<LivenessTypeEnum> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        this.mLivenessList = list;
        this.mCurrentLivenessTypeEnum = list.get(0);
        clearLivenessStatus();
    }

    public boolean showQualityTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? System.currentTimeMillis() - this.mQualityDuration > 0 : invokeV.booleanValue;
    }

    public void startNextLiveness() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mLivenessIndex++;
            this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
            this.mLivenessDuration = 0L;
        }
    }
}
