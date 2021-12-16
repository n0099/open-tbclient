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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class FaceDetectStrategyExtModule implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.baidu.pass.face.platform.strategy.FaceDetectStrategyExtModule";
    public static volatile int mProcessCount;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ImageInfo> mBase64ImageCropMap;
    public HashMap<String, ImageInfo> mBase64ImageSrcMap;
    public Context mContext;
    public int mDegree;
    public int mDetectCount;
    public Rect mDetectRect;
    public final DetectStrategy mDetectStrategy;
    public FaceConfig mFaceConfig;
    public final FaceModuleNew mFaceModule;
    public b mIDetectStrategyCallback;
    public ISecurityCallback mISecurityCallback;
    public volatile boolean mIsCompletion;
    public volatile boolean mIsEnableSound;
    public boolean mIsFirstTipsed;
    public volatile boolean mIsProcessing;
    public long mNoFaceTime;
    public Rect mPreviewRect;
    public final SoundPoolHelper mSoundPlayHelper;
    public Map<FaceStatusNewEnum, String> mTipsMap;

    /* loaded from: classes10.dex */
    public class FaceProcessRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] imageData;
        public final /* synthetic */ FaceDetectStrategyExtModule this$0;

        public FaceProcessRunnable(FaceDetectStrategyExtModule faceDetectStrategyExtModule, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceDetectStrategyExtModule, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = faceDetectStrategyExtModule;
            this.imageData = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.processStrategy(this.imageData);
                FaceDetectStrategyExtModule.access$106();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1610008093, "Lcom/baidu/pass/face/platform/strategy/FaceDetectStrategyExtModule;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1610008093, "Lcom/baidu/pass/face/platform/strategy/FaceDetectStrategyExtModule;");
        }
    }

    public FaceDetectStrategyExtModule(Context context) {
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
        this.mIsFirstTipsed = false;
        this.mIsCompletion = false;
        this.mIsEnableSound = true;
        this.mDetectCount = 0;
        this.mNoFaceTime = 0L;
        this.mTipsMap = new HashMap();
        this.mBase64ImageCropMap = new HashMap<>();
        this.mBase64ImageSrcMap = new HashMap<>();
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
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, bDFaceImageInstance, faceExtInfo, i2)) == null) {
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
        return invokeLLI.booleanValue;
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

    private void process(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, bArr) == null) || mProcessCount > 0) {
            return;
        }
        mProcessCount++;
        new FaceProcessRunnable(this, bArr).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processStrategy(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bArr) == null) {
            try {
                BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.mPreviewRect.width(), this.mPreviewRect.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.mDegree, 1);
                FaceInfo[] detect = FaceSDKManager.getInstance().detect(bDFaceImageInstance);
                FaceModel faceModel = setFaceModel(detect, bDFaceImageInstance);
                if (this.mISecurityCallback != null) {
                    this.mISecurityCallback.getFaceInfoForSecurity(detect);
                }
                processUIResult(faceModel, bDFaceImageInstance);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void processUICallback(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, faceStatusNewEnum, faceExtInfo) == null) {
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
    }

    private void processUIResult(FaceModel faceModel, BDFaceImageInstance bDFaceImageInstance) {
        FaceExtInfo faceExtInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, faceModel, bDFaceImageInstance) == null) || bDFaceImageInstance == null) {
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, faceStatusNewEnum, faceExtInfo)) == null) {
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
        if (!(interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (detectBestCropImageList = this.mFaceModule.getDetectBestCropImageList(faceExtInfo, bDFaceImageInstance)) == null || detectBestCropImageList.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
        hashMap.put("bestCropDetectImage_" + i2 + "_" + f2 + "_" + System.currentTimeMillis(), detectBestCropImageList.get(0));
    }

    private void saveSrcImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i2, float f2) {
        ArrayList<ImageInfo> detectBestSrcImageList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (detectBestSrcImageList = this.mFaceModule.getDetectBestSrcImageList(faceExtInfo, bDFaceImageInstance)) == null || detectBestSrcImageList.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageSrcMap;
        hashMap.put("bestSrcDetectImage_" + i2 + "_" + f2 + "_" + System.currentTimeMillis(), detectBestSrcImageList.get(0));
    }

    private FaceModel setFaceModel(FaceInfo[] faceInfoArr, BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, faceInfoArr, bDFaceImageInstance)) == null) {
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
        return (FaceModel) invokeLL.objValue;
    }

    @Override // com.baidu.pass.face.platform.a
    public void detectStrategy(byte[] bArr) {
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

    @Override // com.baidu.pass.face.platform.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
    }

    public void setConfigValue(FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceConfig) == null) {
            this.mFaceConfig = faceConfig;
        }
    }

    @Override // com.baidu.pass.face.platform.a
    public void setDetectStrategyConfig(Rect rect, Rect rect2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, rect, rect2, bVar) == null) {
            this.mPreviewRect = rect;
            this.mDetectRect = rect2;
            this.mIDetectStrategyCallback = bVar;
        }
    }

    @Override // com.baidu.pass.face.platform.a
    public void setDetectStrategySoundEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mIsEnableSound = z;
        }
    }

    @Override // com.baidu.pass.face.platform.a
    public void setISecurityCallback(ISecurityCallback iSecurityCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iSecurityCallback) == null) {
            this.mISecurityCallback = iSecurityCallback;
        }
    }

    @Override // com.baidu.pass.face.platform.a
    public void setPreviewDegree(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mDegree = i2;
        }
    }
}
