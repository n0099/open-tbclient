package com.baidu.pass.face.platform.strategy;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
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
import com.baidu.pass.face.platform.manager.TimeManager;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.FaceModel;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class FaceLivenessStrategyExtModule implements c {
    public static final String TAG = "FaceLivenessStrategyExtModule";
    public static volatile int mProcessCount;
    public Handler mAnimHandler;
    public Context mContext;
    public int mCropCount;
    public Rect mDetectRect;
    public DetectStrategy mDetectStrategy;
    public FaceConfig mFaceConfig;
    public FaceModuleNew mFaceModule;
    public d mILivenessStrategyCallback;
    public e mILivenessViewCallback;
    public ISecurityCallback mISecurityCallback;
    public volatile boolean mIsCompletion;
    public boolean mIsFirstLivenessSuccessTipsed;
    public boolean mIsFirstTipsed;
    public volatile boolean mIsProcessing;
    public LivenessStatusStrategy mLivenessStrategy;
    public int mPreviewDegree;
    public Rect mPreviewRect;
    public SoundPoolHelper mSoundPlayHelper;
    public boolean mTipLiveTimeout;
    public volatile boolean mIsEnableSound = true;
    public Map<FaceStatusNewEnum, String> mTipsMap = new HashMap();
    public HashMap<String, ImageInfo> mBase64ImageCropMap = new HashMap<>();
    public HashMap<String, ImageInfo> mBase64ImageSrcMap = new HashMap<>();
    public long mNoFaceTime = 0;
    public volatile LivenessStatus mLivenessStatus = LivenessStatus.LivenessCrop;
    public long mFaceID = -1;

    /* renamed from: com.baidu.pass.face.platform.strategy.FaceLivenessStrategyExtModule$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$face$platform$FaceStatusNewEnum;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus;

        static {
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

    /* loaded from: classes2.dex */
    public class FaceProcessRunnable implements Runnable {
        public byte[] imageData;

        public FaceProcessRunnable(byte[] bArr) {
            this.imageData = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            FaceLivenessStrategyExtModule.this.processStrategy(this.imageData);
            FaceLivenessStrategyExtModule.access$106();
        }
    }

    /* loaded from: classes2.dex */
    public enum LivenessStatus {
        LivenessReady,
        LivenessTips,
        LivenessOK,
        LivenessCourse,
        LivenessCrop
    }

    public FaceLivenessStrategyExtModule(Context context) {
        this.mSoundPlayHelper = null;
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
        this.mAnimHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ int access$106() {
        int i2 = mProcessCount - 1;
        mProcessCount = i2;
        return i2;
    }

    private boolean cropStrategy(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, LivenessTypeEnum livenessTypeEnum, int i2) {
        FaceStatusNewEnum cropStatus = this.mDetectStrategy.getCropStatus(faceExtInfo, this.mFaceConfig);
        if (cropStatus != FaceStatusNewEnum.OK) {
            this.mILivenessStrategyCallback.a(cropStatus, getStatusTextResId(cropStatus), null, null, 0);
            return false;
        }
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

    private String getStatusTextResId(FaceStatusNewEnum faceStatusNewEnum) {
        Context context;
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

    private void judgeLivenessTimeout() {
        if (!this.mLivenessStrategy.isCourseTimeout(this.mFaceConfig) || this.mTipLiveTimeout) {
            return;
        }
        e eVar = this.mILivenessViewCallback;
        if (eVar != null) {
            eVar.a(this.mLivenessStrategy.getCurrentLivenessType());
        }
        processUICallback(FaceStatusNewEnum.FaceLivenessActionCodeTimeout, null);
        this.mAnimHandler.postDelayed(new Runnable() { // from class: com.baidu.pass.face.platform.strategy.FaceLivenessStrategyExtModule.1
            @Override // java.lang.Runnable
            public void run() {
                FaceLivenessStrategyExtModule.this.mLivenessStrategy.resetState();
                TimeManager.getInstance().setActiveAnimTime(0);
                FaceLivenessStrategyExtModule.this.mILivenessViewCallback.b();
                FaceLivenessStrategyExtModule.this.mTipLiveTimeout = false;
            }
        }, TimeManager.getInstance().getActiveAnimTime() + 1000);
        this.mTipLiveTimeout = true;
    }

    private void process(byte[] bArr) {
        if (mProcessCount > 0) {
            return;
        }
        mProcessCount++;
        new FaceProcessRunnable(bArr).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processStrategy(byte[] bArr) {
        BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.mPreviewRect.width(), this.mPreviewRect.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.mPreviewDegree, 1);
        FaceInfo[] detect = FaceSDKManager.getInstance().detect(bDFaceImageInstance);
        ISecurityCallback iSecurityCallback = this.mISecurityCallback;
        if (iSecurityCallback != null) {
            iSecurityCallback.getFaceInfoForSecurity(detect);
        }
        processUIResult(setFaceModel(detect), bDFaceImageInstance);
    }

    private void processUICallback(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
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

    private void processUIResult(FaceModel faceModel, BDFaceImageInstance bDFaceImageInstance) {
        if (bDFaceImageInstance == null) {
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
                } else if (AnonymousClass2.$SwitchMap$com$baidu$pass$face$platform$FaceStatusNewEnum[faceModuleStateNew.ordinal()] != 1) {
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
                int i2 = AnonymousClass2.$SwitchMap$com$baidu$pass$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus[this.mLivenessStatus.ordinal()];
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

    private void saveCropImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i2, float f2) {
        ArrayList<ImageInfo> detectBestCropImageList = this.mFaceModule.getDetectBestCropImageList(faceExtInfo, bDFaceImageInstance);
        if (detectBestCropImageList == null || detectBestCropImageList.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
        hashMap.put("bestCropImage_" + i2 + "_" + f2 + "_" + System.currentTimeMillis(), detectBestCropImageList.get(0));
    }

    private void saveSrcImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i2, float f2) {
        ArrayList<ImageInfo> detectBestSrcImageList = this.mFaceModule.getDetectBestSrcImageList(faceExtInfo, bDFaceImageInstance);
        if (detectBestSrcImageList == null || detectBestSrcImageList.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageSrcMap;
        hashMap.put("bestSrcImage_" + i2 + "_" + f2 + "_" + System.currentTimeMillis(), detectBestSrcImageList.get(0));
    }

    private FaceModel setFaceModel(FaceInfo[] faceInfoArr) {
        FaceExtInfo[] faceExtInfo = this.mFaceModule.getFaceExtInfo(faceInfoArr);
        FaceModel faceModel = new FaceModel();
        faceModel.setFaceInfos(faceExtInfo);
        faceModel.setFaceModuleStateNew(this.mDetectStrategy.checkDetect(this.mDetectRect, faceExtInfo, this.mFaceConfig));
        faceModel.setFrameTime(System.currentTimeMillis());
        return faceModel;
    }

    @Override // com.baidu.pass.face.platform.c
    public void livenessStrategy(byte[] bArr) {
        if (!this.mIsFirstTipsed) {
            this.mIsFirstTipsed = true;
            processUITips(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, null);
        } else if (this.mIsProcessing) {
        } else {
            process(bArr);
        }
    }

    @Override // com.baidu.pass.face.platform.c
    public void reset() {
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
        Handler handler = this.mAnimHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mAnimHandler = null;
        }
        this.mIsFirstTipsed = false;
        this.mIsProcessing = false;
    }

    public void setConfig(FaceConfig faceConfig) {
        this.mFaceConfig = faceConfig;
    }

    public void setILivenessViewCallback(e eVar) {
        this.mILivenessViewCallback = eVar;
    }

    @Override // com.baidu.pass.face.platform.c
    public void setISecurityCallback(ISecurityCallback iSecurityCallback) {
        this.mISecurityCallback = iSecurityCallback;
    }

    @Override // com.baidu.pass.face.platform.c
    public void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, d dVar) {
        this.mLivenessStrategy.setLivenessList(list);
        this.mPreviewRect = rect;
        this.mDetectRect = rect2;
        this.mILivenessStrategyCallback = dVar;
    }

    @Override // com.baidu.pass.face.platform.c
    public void setLivenessStrategySoundEnable(boolean z) {
        this.mIsEnableSound = z;
    }

    @Override // com.baidu.pass.face.platform.c
    public void setPreviewDegree(int i2) {
        this.mPreviewDegree = i2;
    }
}
