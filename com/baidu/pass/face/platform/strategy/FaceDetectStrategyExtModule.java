package com.baidu.pass.face.platform.strategy;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.a;
import com.baidu.pass.face.platform.b;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.pass.face.platform.common.LogHelper;
import com.baidu.pass.face.platform.common.SoundPoolHelper;
import com.baidu.pass.face.platform.decode.FaceModuleNew;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.FaceModel;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class FaceDetectStrategyExtModule implements a {
    public static final String TAG = "com.baidu.pass.face.platform.strategy.FaceDetectStrategyExtModule";
    public static volatile int mProcessCount;
    public Context mContext;
    public int mDegree;
    public Rect mDetectRect;
    public final DetectStrategy mDetectStrategy;
    public FaceConfig mFaceConfig;
    public final FaceModuleNew mFaceModule;
    public b mIDetectStrategyCallback;
    public ISecurityCallback mISecurityCallback;
    public volatile boolean mIsProcessing;
    public Rect mPreviewRect;
    public final SoundPoolHelper mSoundPlayHelper;
    public boolean mIsFirstTipsed = false;
    public volatile boolean mIsCompletion = false;
    public volatile boolean mIsEnableSound = true;
    public int mDetectCount = 0;
    public long mNoFaceTime = 0;
    public Map<FaceStatusNewEnum, String> mTipsMap = new HashMap();
    public HashMap<String, ImageInfo> mBase64ImageCropMap = new HashMap<>();
    public HashMap<String, ImageInfo> mBase64ImageSrcMap = new HashMap<>();

    /* loaded from: classes2.dex */
    public class FaceProcessRunnable implements Runnable {
        public byte[] imageData;

        public FaceProcessRunnable(byte[] bArr) {
            this.imageData = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            FaceDetectStrategyExtModule.this.processStrategy(this.imageData);
            FaceDetectStrategyExtModule.access$106();
        }
    }

    public FaceDetectStrategyExtModule(Context context) {
        LogHelper.clear();
        LogHelper.addLog(ConstantHelper.LOG_CATE, "Baidu-IDL-FaceSDK4.1.1");
        LogHelper.addLog(ConstantHelper.LOG_OS, Integer.valueOf(Build.VERSION.SDK_INT));
        LogHelper.addLog("version", FaceEnvironment.SDK_VERSION);
        LogHelper.addLog("device", Build.MODEL + " " + Build.MANUFACTURER);
        LogHelper.addLog(ConstantHelper.LOG_STM, Long.valueOf(System.currentTimeMillis()));
        this.mContext = context;
        this.mDetectStrategy = new DetectStrategy();
        this.mSoundPlayHelper = new SoundPoolHelper(context);
        this.mFaceModule = new FaceModuleNew();
    }

    public static /* synthetic */ int access$106() {
        int i2 = mProcessCount - 1;
        mProcessCount = i2;
        return i2;
    }

    private boolean cropStrategy(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, int i2) {
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

    private void process(byte[] bArr) {
        if (mProcessCount > 0) {
            return;
        }
        mProcessCount++;
        new FaceProcessRunnable(bArr).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processStrategy(byte[] bArr) {
        BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.mPreviewRect.width(), this.mPreviewRect.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.mDegree, 1);
        FaceInfo[] detect = FaceSDKManager.getInstance().detect(bDFaceImageInstance);
        FaceModel faceModel = setFaceModel(detect, bDFaceImageInstance);
        ISecurityCallback iSecurityCallback = this.mISecurityCallback;
        if (iSecurityCallback != null) {
            iSecurityCallback.getFaceInfoForSecurity(detect);
        }
        processUIResult(faceModel, bDFaceImageInstance);
    }

    private void processUICallback(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
            LogHelper.addLogWithKey(ConstantHelper.LOG_ETM, Long.valueOf(System.currentTimeMillis()));
            LogHelper.sendLog();
        }
        b bVar = this.mIDetectStrategyCallback;
        if (bVar != null) {
            if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                this.mIsProcessing = true;
                this.mIsCompletion = true;
                LogHelper.addLogWithKey(ConstantHelper.LOG_ETM, Long.valueOf(System.currentTimeMillis()));
                LogHelper.addLogWithKey(ConstantHelper.LOG_FINISH, 1);
                LogHelper.sendLog();
                this.mIDetectStrategyCallback.a(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap);
                return;
            }
            bVar.a(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), null, null);
        }
    }

    private void processUIResult(FaceModel faceModel, BDFaceImageInstance bDFaceImageInstance) {
        FaceExtInfo faceExtInfo;
        if (bDFaceImageInstance == null) {
            return;
        }
        if (this.mIsProcessing) {
            bDFaceImageInstance.destory();
            return;
        }
        if (faceModel != null && faceModel.getFaceInfos() != null && faceModel.getFaceInfos().length > 0) {
            faceExtInfo = faceModel.getFaceInfos()[0];
            LogHelper.addLogWithKey(ConstantHelper.LOG_FTM, Long.valueOf(System.currentTimeMillis()));
        } else {
            DetectStrategy detectStrategy = this.mDetectStrategy;
            if (detectStrategy != null) {
                detectStrategy.reset();
            }
            faceExtInfo = null;
        }
        if (faceExtInfo != null) {
            if (this.mDetectStrategy == null) {
                bDFaceImageInstance.destory();
            } else if (this.mIsCompletion) {
                processUITips(FaceStatusNewEnum.OK, faceExtInfo);
                bDFaceImageInstance.destory();
            } else if (faceModel == null) {
            } else {
                FaceStatusNewEnum faceModuleStateNew = faceModel.getFaceModuleStateNew();
                if (faceModuleStateNew == FaceStatusNewEnum.OK) {
                    LogHelper.addLogWithKey(ConstantHelper.LOG_BTM, Long.valueOf(System.currentTimeMillis()));
                    if (this.mDetectCount < this.mFaceConfig.getCacheImageNum()) {
                        if (cropStrategy(bDFaceImageInstance, faceExtInfo, this.mDetectCount)) {
                            this.mDetectCount++;
                        }
                    } else {
                        this.mIsCompletion = true;
                        processUITips(FaceStatusNewEnum.OK, faceExtInfo);
                    }
                    bDFaceImageInstance.destory();
                } else if (this.mDetectStrategy.isTimeout()) {
                    this.mIsProcessing = true;
                    bDFaceImageInstance.destory();
                    processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                } else {
                    processUITips(faceModuleStateNew, faceExtInfo);
                    bDFaceImageInstance.destory();
                }
            }
        } else if (this.mDetectStrategy == null) {
            bDFaceImageInstance.destory();
        } else {
            if (faceModel != null && (faceModel.getFaceModuleStateNew() == FaceStatusNewEnum.DetectRemindCodeNoFaceDetected || faceModel.getFaceModuleStateNew() == FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame)) {
                this.mDetectStrategy.reset();
                if (this.mNoFaceTime == 0) {
                    this.mNoFaceTime = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.mNoFaceTime > this.mFaceConfig.getTimeDetectModule()) {
                    this.mIsProcessing = true;
                    bDFaceImageInstance.destory();
                    processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                    return;
                }
            } else {
                this.mNoFaceTime = 0L;
            }
            if (this.mDetectStrategy.isTimeout()) {
                bDFaceImageInstance.destory();
                this.mIsProcessing = true;
                processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                return;
            }
            processUITips(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, null);
            bDFaceImageInstance.destory();
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
        hashMap.put("bestCropDetectImage_" + i2 + "_" + f2 + "_" + System.currentTimeMillis(), detectBestCropImageList.get(0));
    }

    private void saveSrcImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i2, float f2) {
        ArrayList<ImageInfo> detectBestSrcImageList = this.mFaceModule.getDetectBestSrcImageList(faceExtInfo, bDFaceImageInstance);
        if (detectBestSrcImageList == null || detectBestSrcImageList.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageSrcMap;
        hashMap.put("bestSrcDetectImage_" + i2 + "_" + f2 + "_" + System.currentTimeMillis(), detectBestSrcImageList.get(0));
    }

    private FaceModel setFaceModel(FaceInfo[] faceInfoArr, BDFaceImageInstance bDFaceImageInstance) {
        if (bDFaceImageInstance == null) {
            return null;
        }
        FaceModel faceModel = new FaceModel();
        FaceExtInfo[] faceExtInfo = this.mFaceModule.getFaceExtInfo(faceInfoArr);
        faceModel.setFaceModuleStateNew(this.mDetectStrategy.getDetectState(faceExtInfo, this.mDetectRect, false, this.mFaceConfig));
        faceModel.setFaceInfos(faceExtInfo);
        faceModel.setFrameTime(System.currentTimeMillis());
        return faceModel;
    }

    @Override // com.baidu.pass.face.platform.a
    public void detectStrategy(byte[] bArr) {
        if (!this.mIsFirstTipsed) {
            this.mIsFirstTipsed = true;
            processUITips(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, null);
        } else if (this.mIsProcessing) {
        } else {
            process(bArr);
        }
    }

    @Override // com.baidu.pass.face.platform.a
    public void reset() {
        this.mDetectCount = 0;
        SoundPoolHelper soundPoolHelper = this.mSoundPlayHelper;
        if (soundPoolHelper != null) {
            soundPoolHelper.release();
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, ImageInfo> hashMap2 = this.mBase64ImageSrcMap;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        this.mIsFirstTipsed = false;
        this.mIsProcessing = false;
    }

    public void setConfigValue(FaceConfig faceConfig) {
        this.mFaceConfig = faceConfig;
    }

    @Override // com.baidu.pass.face.platform.a
    public void setDetectStrategyConfig(Rect rect, Rect rect2, b bVar) {
        this.mPreviewRect = rect;
        this.mDetectRect = rect2;
        this.mIDetectStrategyCallback = bVar;
    }

    @Override // com.baidu.pass.face.platform.a
    public void setDetectStrategySoundEnable(boolean z) {
        this.mIsEnableSound = z;
    }

    @Override // com.baidu.pass.face.platform.a
    public void setISecurityCallback(ISecurityCallback iSecurityCallback) {
        this.mISecurityCallback = iSecurityCallback;
    }

    @Override // com.baidu.pass.face.platform.a
    public void setPreviewDegree(int i2) {
        this.mDegree = i2;
    }
}
