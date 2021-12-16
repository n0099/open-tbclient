package com.baidu.pass.face.platform.strategy;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.c;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.pass.face.platform.common.LogHelper;
import com.baidu.pass.face.platform.common.SoundPoolHelper;
import com.baidu.pass.face.platform.d;
import com.baidu.pass.face.platform.decode.FaceModuleNew;
import com.baidu.pass.face.platform.e;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.FaceModel;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class FaceLivenessStrategyExtModule implements c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceLivenessStrategyExtModule";
    public static volatile int mProcessCount;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ImageInfo> mBase64ImageCropMap;
    public HashMap<String, ImageInfo> mBase64ImageSrcMap;
    public Context mContext;
    public int mCropCount;
    public Rect mDetectRect;
    public DetectStrategy mDetectStrategy;
    public FaceConfig mFaceConfig;
    public long mFaceID;
    public FaceModuleNew mFaceModule;
    public d mILivenessStrategyCallback;
    public e mILivenessViewCallback;
    public ISecurityCallback mISecurityCallback;
    public volatile boolean mIsCompletion;
    public volatile boolean mIsEnableSound;
    public boolean mIsFirstLivenessSuccessTipsed;
    public boolean mIsFirstTipsed;
    public volatile boolean mIsProcessing;
    public volatile LivenessStatus mLivenessStatus;
    public LivenessStatusStrategy mLivenessStrategy;
    public long mNoFaceTime;
    public int mPreviewDegree;
    public Rect mPreviewRect;
    public SoundPoolHelper mSoundPlayHelper;
    public boolean mTipLiveTimeout;
    public Map<FaceStatusNewEnum, String> mTipsMap;

    /* renamed from: com.baidu.pass.face.platform.strategy.FaceLivenessStrategyExtModule$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$face$platform$FaceStatusNewEnum;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(777162710, "Lcom/baidu/pass/face/platform/strategy/FaceLivenessStrategyExtModule$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(777162710, "Lcom/baidu/pass/face/platform/strategy/FaceLivenessStrategyExtModule$1;");
                    return;
                }
            }
            int[] iArr = new int[LivenessStatus.values().length];
            $SwitchMap$com$baidu$pass$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus = iArr;
            try {
                iArr[LivenessStatus.LivenessReady.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$pass$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus[LivenessStatus.LivenessTips.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$pass$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus[LivenessStatus.LivenessOK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[FaceStatusNewEnum.values().length];
            $SwitchMap$com$baidu$pass$face$platform$FaceStatusNewEnum = iArr2;
            try {
                iArr2[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class FaceProcessRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] imageData;
        public final /* synthetic */ FaceLivenessStrategyExtModule this$0;

        public FaceProcessRunnable(FaceLivenessStrategyExtModule faceLivenessStrategyExtModule, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceLivenessStrategyExtModule, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = faceLivenessStrategyExtModule;
            this.imageData = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.processStrategy(this.imageData);
                FaceLivenessStrategyExtModule.access$106();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class LivenessStatus {
        public static final /* synthetic */ LivenessStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LivenessStatus LivenessCourse;
        public static final LivenessStatus LivenessCrop;
        public static final LivenessStatus LivenessOK;
        public static final LivenessStatus LivenessReady;
        public static final LivenessStatus LivenessTips;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1974879610, "Lcom/baidu/pass/face/platform/strategy/FaceLivenessStrategyExtModule$LivenessStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1974879610, "Lcom/baidu/pass/face/platform/strategy/FaceLivenessStrategyExtModule$LivenessStatus;");
                    return;
                }
            }
            LivenessReady = new LivenessStatus("LivenessReady", 0);
            LivenessTips = new LivenessStatus("LivenessTips", 1);
            LivenessOK = new LivenessStatus("LivenessOK", 2);
            LivenessCourse = new LivenessStatus("LivenessCourse", 3);
            LivenessStatus livenessStatus = new LivenessStatus("LivenessCrop", 4);
            LivenessCrop = livenessStatus;
            $VALUES = new LivenessStatus[]{LivenessReady, LivenessTips, LivenessOK, LivenessCourse, livenessStatus};
        }

        public LivenessStatus(String str, int i2) {
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

        public static LivenessStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LivenessStatus) Enum.valueOf(LivenessStatus.class, str) : (LivenessStatus) invokeL.objValue;
        }

        public static LivenessStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LivenessStatus[]) $VALUES.clone() : (LivenessStatus[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-897514301, "Lcom/baidu/pass/face/platform/strategy/FaceLivenessStrategyExtModule;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-897514301, "Lcom/baidu/pass/face/platform/strategy/FaceLivenessStrategyExtModule;");
        }
    }

    public FaceLivenessStrategyExtModule(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsEnableSound = true;
        this.mSoundPlayHelper = null;
        this.mTipsMap = new HashMap();
        this.mBase64ImageCropMap = new HashMap<>();
        this.mBase64ImageSrcMap = new HashMap<>();
        this.mNoFaceTime = 0L;
        this.mLivenessStatus = LivenessStatus.LivenessCrop;
        this.mFaceID = -1L;
        LogHelper.clear();
        LogHelper.addLog(ConstantHelper.LOG_CATE, "Baidu-IDL-FaceSDK4.1.1");
        LogHelper.addLog(ConstantHelper.LOG_OS, Integer.valueOf(Build.VERSION.SDK_INT));
        LogHelper.addLog("version", FaceEnvironment.SDK_VERSION);
        LogHelper.addLog("device", Build.MODEL + " " + Build.MANUFACTURER);
        LogHelper.addLog(ConstantHelper.LOG_STM, Long.valueOf(System.currentTimeMillis()));
        this.mContext = context;
        this.mDetectStrategy = new DetectStrategy();
        this.mLivenessStrategy = new LivenessStatusStrategy();
        this.mFaceModule = new FaceModuleNew();
        this.mSoundPlayHelper = new SoundPoolHelper(context);
    }

    public static /* synthetic */ int access$106() {
        int i2 = mProcessCount - 1;
        mProcessCount = i2;
        return i2;
    }

    private boolean cropStrategy(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, LivenessTypeEnum livenessTypeEnum, int i2) {
        InterceptResult invokeLLLI;
        FaceStatusNewEnum cropIsOutofBoundary;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, bDFaceImageInstance, faceExtInfo, livenessTypeEnum, i2)) == null) {
            FaceStatusNewEnum cropStatus = this.mDetectStrategy.getCropStatus(faceExtInfo, this.mFaceConfig);
            if (cropStatus != FaceStatusNewEnum.OK) {
                this.mILivenessStrategyCallback.a(cropStatus, getStatusTextResId(cropStatus), null, null, 0);
                return false;
            } else if (this.mFaceConfig.isNoBlackCropImage() && (cropIsOutofBoundary = FaceSDKManager.getInstance().cropIsOutofBoundary(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.mFaceConfig.getCropHeight(), this.mFaceConfig.getCropWidth())) != FaceStatusNewEnum.OK) {
                this.mILivenessStrategyCallback.a(cropIsOutofBoundary, getStatusTextResId(cropIsOutofBoundary), null, null, 0);
                return false;
            } else {
                float totalCropScore = this.mDetectStrategy.getTotalCropScore();
                this.mFaceModule.setFaceConfig(this.mFaceConfig);
                BDFaceImageInstance cropFace = FaceSDKManager.getInstance().cropFace(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.mFaceConfig.getCropHeight(), this.mFaceConfig.getCropWidth());
                if (cropFace == null) {
                    return false;
                }
                saveCropImageInstance(faceExtInfo, cropFace, i2, totalCropScore);
                cropFace.destory();
                saveSrcImageInstance(faceExtInfo, bDFaceImageInstance, i2, totalCropScore);
                return true;
            }
        }
        return invokeLLLI.booleanValue;
    }

    private String getStatusTextResId(FaceStatusNewEnum faceStatusNewEnum) {
        InterceptResult invokeL;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, faceStatusNewEnum)) == null) {
            if (this.mTipsMap.containsKey(faceStatusNewEnum)) {
                return this.mTipsMap.get(faceStatusNewEnum);
            }
            int tipsId = FaceEnvironment.getTipsId(faceStatusNewEnum);
            if (tipsId <= 0 || (context = this.mContext) == null) {
                return "";
            }
            String string = context.getResources().getString(tipsId);
            this.mTipsMap.put(faceStatusNewEnum, string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    private void judgeLivenessTimeout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && this.mLivenessStrategy.isCourseTimeout(this.mFaceConfig) && !this.mTipLiveTimeout) {
            e eVar = this.mILivenessViewCallback;
            if (eVar != null) {
                eVar.a(this.mLivenessStrategy.getCurrentLivenessType());
            }
            processUICallback(FaceStatusNewEnum.FaceLivenessActionCodeTimeout, null);
            this.mTipLiveTimeout = true;
        }
    }

    private void process(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, bArr) == null) || mProcessCount > 0) {
            return;
        }
        mProcessCount++;
        new FaceProcessRunnable(this, bArr).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processStrategy(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, bArr) == null) {
            try {
                BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.mPreviewRect.width(), this.mPreviewRect.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.mPreviewDegree, 1);
                FaceInfo[] detect = FaceSDKManager.getInstance().detect(bDFaceImageInstance);
                if (this.mISecurityCallback != null) {
                    this.mISecurityCallback.getFaceInfoForSecurity(detect);
                }
                processUIResult(setFaceModel(detect), bDFaceImageInstance);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void processUICallback(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, faceStatusNewEnum, faceExtInfo) == null) {
            if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                LogHelper.addLogWithKey(ConstantHelper.LOG_ETM, Long.valueOf(System.currentTimeMillis()));
                LogHelper.sendLog();
            }
            if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                this.mIsProcessing = true;
                this.mIsCompletion = true;
                LogHelper.addLogWithKey(ConstantHelper.LOG_ETM, Long.valueOf(System.currentTimeMillis()));
                LogHelper.addLogWithKey(ConstantHelper.LOG_FINISH, 1);
                LogHelper.sendLog();
                d dVar = this.mILivenessStrategyCallback;
                if (dVar != null) {
                    dVar.a(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap, this.mLivenessStrategy.getCurrentLivenessCount());
                }
            } else if (faceStatusNewEnum == FaceStatusNewEnum.FaceLivenessActionComplete) {
                d dVar2 = this.mILivenessStrategyCallback;
                if (dVar2 != null) {
                    dVar2.a(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap, this.mLivenessStrategy.getCurrentLivenessCount());
                }
            } else {
                d dVar3 = this.mILivenessStrategyCallback;
                if (dVar3 != null) {
                    dVar3.a(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap, this.mLivenessStrategy.getCurrentLivenessCount() - 1);
                }
            }
        }
    }

    private void processUIResult(FaceModel faceModel, BDFaceImageInstance bDFaceImageInstance) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, this, faceModel, bDFaceImageInstance) == null) || bDFaceImageInstance == null) {
            return;
        }
        if (this.mIsProcessing) {
            bDFaceImageInstance.destory();
        } else if (faceModel != null && faceModel.getFaceInfos() != null && faceModel.getFaceInfos().length != 0) {
            FaceStatusNewEnum faceModuleStateNew = faceModel.getFaceModuleStateNew();
            FaceExtInfo faceExtInfo = faceModel.getFaceInfos()[0];
            if (faceModuleStateNew != FaceStatusNewEnum.OK) {
                if (this.mDetectStrategy.isTimeout()) {
                    bDFaceImageInstance.destory();
                    this.mIsProcessing = true;
                    processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                } else if (AnonymousClass1.$SwitchMap$com$baidu$pass$face$platform$FaceStatusNewEnum[faceModuleStateNew.ordinal()] != 1) {
                    bDFaceImageInstance.destory();
                    processUITips(faceModuleStateNew, faceExtInfo);
                    this.mDetectStrategy.reset();
                    this.mLivenessStrategy.resetState();
                } else {
                    if (this.mNoFaceTime == 0) {
                        this.mNoFaceTime = System.currentTimeMillis();
                    }
                    if (System.currentTimeMillis() - this.mNoFaceTime > this.mFaceConfig.getTimeDetectModule()) {
                        bDFaceImageInstance.destory();
                        this.mIsProcessing = true;
                        processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                    } else if (this.mIsFirstLivenessSuccessTipsed && this.mNoFaceTime != 0 && System.currentTimeMillis() - this.mNoFaceTime < FaceEnvironment.TIME_DETECT_NO_FACE_CONTINUOUS) {
                        bDFaceImageInstance.destory();
                    } else {
                        this.mIsFirstLivenessSuccessTipsed = false;
                        bDFaceImageInstance.destory();
                        this.mDetectStrategy.reset();
                        this.mLivenessStrategy.resetState();
                        processUITips(faceModuleStateNew, null);
                    }
                }
            } else if (faceExtInfo == null) {
            } else {
                this.mILivenessViewCallback.a(faceExtInfo);
                if (this.mLivenessStatus == LivenessStatus.LivenessCrop) {
                    if (this.mCropCount < this.mFaceConfig.getCacheImageNum()) {
                        if (cropStrategy(bDFaceImageInstance, faceExtInfo, this.mLivenessStrategy.getCurrentLivenessType(), this.mCropCount)) {
                            this.mCropCount++;
                        }
                    } else {
                        this.mLivenessStatus = LivenessStatus.LivenessReady;
                    }
                }
                if (this.mLivenessStatus == LivenessStatus.LivenessReady || this.mLivenessStatus == LivenessStatus.LivenessTips) {
                    if (faceExtInfo.getFaceId() != this.mFaceID) {
                        this.mLivenessStrategy.reset();
                        FaceSDKManager.getInstance().clearActionHistory();
                        if (this.mFaceID != -1) {
                            this.mLivenessStatus = LivenessStatus.LivenessCrop;
                            this.mCropCount = 0;
                            HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
                            if (hashMap != null) {
                                hashMap.clear();
                            }
                            HashMap<String, ImageInfo> hashMap2 = this.mBase64ImageSrcMap;
                            if (hashMap2 != null) {
                                hashMap2.clear();
                            }
                        }
                        this.mILivenessViewCallback.a();
                        this.mFaceID = faceExtInfo.getFaceId();
                    }
                    this.mLivenessStrategy.processLiveness(faceExtInfo, bDFaceImageInstance, this.mPreviewRect);
                }
                this.mNoFaceTime = 0L;
                LogHelper.addLogWithKey(ConstantHelper.LOG_BTM, Long.valueOf(System.currentTimeMillis()));
                int i2 = AnonymousClass1.$SwitchMap$com$baidu$pass$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus[this.mLivenessStatus.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3 && processUITips(FaceStatusNewEnum.FaceLivenessActionComplete, faceExtInfo)) {
                            if (!this.mIsFirstLivenessSuccessTipsed) {
                                this.mIsFirstLivenessSuccessTipsed = true;
                            }
                            if (this.mLivenessStrategy.isExistNextLiveness()) {
                                this.mLivenessStrategy.startNextLiveness();
                                this.mLivenessStatus = LivenessStatus.LivenessReady;
                            } else if (this.mLivenessStrategy.isLivenessSuccess()) {
                                processUICallback(FaceStatusNewEnum.OK, faceExtInfo);
                            }
                        }
                    } else if (this.mLivenessStrategy.isCurrentLivenessSuccess()) {
                        this.mLivenessStatus = LivenessStatus.LivenessOK;
                    } else {
                        processUITips(this.mLivenessStrategy.getCurrentLivenessNewStatus(), faceExtInfo);
                        judgeLivenessTimeout();
                        if (this.mLivenessStrategy.isTimeout()) {
                            bDFaceImageInstance.destory();
                            this.mIsProcessing = true;
                            processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                            return;
                        }
                    }
                } else if (processUITips(this.mLivenessStrategy.getCurrentLivenessNewStatus(), faceExtInfo)) {
                    this.mLivenessStatus = LivenessStatus.LivenessTips;
                }
                bDFaceImageInstance.destory();
            }
        } else {
            bDFaceImageInstance.destory();
            DetectStrategy detectStrategy = this.mDetectStrategy;
            if (detectStrategy != null) {
                detectStrategy.reset();
            }
        }
    }

    private boolean processUITips(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, faceStatusNewEnum, faceExtInfo)) == null) {
            if (faceStatusNewEnum != null) {
                this.mSoundPlayHelper.setEnableSound(this.mIsEnableSound);
                boolean playSound = this.mSoundPlayHelper.playSound(faceStatusNewEnum);
                if (playSound) {
                    LogHelper.addTipsLogWithKey(faceStatusNewEnum.name());
                    processUICallback(faceStatusNewEnum, faceExtInfo);
                    return playSound;
                }
                return playSound;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void saveCropImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i2, float f2) {
        ArrayList<ImageInfo> detectBestCropImageList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (detectBestCropImageList = this.mFaceModule.getDetectBestCropImageList(faceExtInfo, bDFaceImageInstance)) == null || detectBestCropImageList.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
        hashMap.put("bestCropImage_" + i2 + "_" + f2 + "_" + System.currentTimeMillis(), detectBestCropImageList.get(0));
    }

    private void saveSrcImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i2, float f2) {
        ArrayList<ImageInfo> detectBestSrcImageList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (detectBestSrcImageList = this.mFaceModule.getDetectBestSrcImageList(faceExtInfo, bDFaceImageInstance)) == null || detectBestSrcImageList.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageSrcMap;
        hashMap.put("bestSrcImage_" + i2 + "_" + f2 + "_" + System.currentTimeMillis(), detectBestSrcImageList.get(0));
    }

    private FaceModel setFaceModel(FaceInfo[] faceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, faceInfoArr)) == null) {
            FaceExtInfo[] faceExtInfo = this.mFaceModule.getFaceExtInfo(faceInfoArr);
            FaceModel faceModel = new FaceModel();
            faceModel.setFaceInfos(faceExtInfo);
            faceModel.setFaceModuleStateNew(this.mDetectStrategy.checkDetect(this.mDetectRect, faceExtInfo, this.mFaceConfig));
            faceModel.setFrameTime(System.currentTimeMillis());
            return faceModel;
        }
        return (FaceModel) invokeL.objValue;
    }

    @Override // com.baidu.pass.face.platform.c
    public void livenessStrategy(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            if (!this.mIsFirstTipsed) {
                this.mIsFirstTipsed = true;
                processUITips(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, null);
            } else if (this.mIsProcessing) {
            } else {
                process(bArr);
            }
        }
    }

    @Override // com.baidu.pass.face.platform.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FaceSDKManager.getInstance().clearActionHistory();
            LivenessStatusStrategy livenessStatusStrategy = this.mLivenessStrategy;
            if (livenessStatusStrategy != null) {
                livenessStatusStrategy.reset();
            }
            HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<String, ImageInfo> hashMap2 = this.mBase64ImageSrcMap;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            SoundPoolHelper soundPoolHelper = this.mSoundPlayHelper;
            if (soundPoolHelper != null) {
                soundPoolHelper.release();
            }
            this.mIsFirstTipsed = false;
            this.mIsProcessing = false;
        }
    }

    public void setConfig(FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceConfig) == null) {
            this.mFaceConfig = faceConfig;
        }
    }

    public void setILivenessViewCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.mILivenessViewCallback = eVar;
        }
    }

    @Override // com.baidu.pass.face.platform.c
    public void setISecurityCallback(ISecurityCallback iSecurityCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iSecurityCallback) == null) {
            this.mISecurityCallback = iSecurityCallback;
        }
    }

    @Override // com.baidu.pass.face.platform.c
    public void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, list, rect, rect2, dVar) == null) {
            this.mLivenessStrategy.setLivenessList(list);
            this.mPreviewRect = rect;
            this.mDetectRect = rect2;
            this.mILivenessStrategyCallback = dVar;
        }
    }

    @Override // com.baidu.pass.face.platform.c
    public void setLivenessStrategySoundEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mIsEnableSound = z;
        }
    }

    @Override // com.baidu.pass.face.platform.c
    public void setPreviewDegree(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mPreviewDegree = i2;
        }
    }
}
