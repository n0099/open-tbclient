package com.baidu.pass.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceDetectListConf;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.model.BDFaceSDKConfig;
import com.baidu.pass.main.facesdk.utils.FileUitls;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class FaceDetect {
    public static final String TAG = "FaceDetect";
    public BDFaceInstance bdFaceInstance;
    public ReentrantLock lock;

    public FaceDetect(BDFaceInstance bDFaceInstance) {
        this.lock = null;
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
        this.lock = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAlignModelInit(long j, int i2, int i3, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAttributeModelInit(long j, byte[] bArr);

    private native BDFaceImageInstance nativeCropFace(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    private native FaceInfo[] nativeDetect(long j, int i2, int i3, BDFaceImageInstance bDFaceImageInstance);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeDetectModelInit(long j, byte[] bArr, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeEmotionsModelInit(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFaceCloseModelInit(long j, byte[] bArr, int i2);

    private native FaceInfo[] nativeFastTrack(long j, int i2, int i3, BDFaceImageInstance bDFaceImageInstance);

    private native FaceInfo[] nativeFlexibleDetect(long j, int i2, int i3, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf);

    private native void nativeLoadConfig(long j, BDFaceSDKConfig bDFaceSDKConfig);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeLoadTrack(long j, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeQualityModelInit(long j, byte[] bArr, int i2);

    private native FaceInfo[] nativeTrack(long j, int i2, BDFaceImageInstance bDFaceImageInstance);

    private native int nativeUninitModel(long j);

    public BDFaceImageInstance cropFace(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (bDFaceImageInstance != null && fArr != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFace(index, bDFaceImageInstance, fArr);
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType != null && bDFaceImageInstance != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index != 0 && this.lock.tryLock()) {
                FaceInfo[] nativeDetect = nativeDetect(index, detectType.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), bDFaceImageInstance);
                this.lock.unlock();
                return nativeDetect;
            }
            return null;
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public void initAttrEmo(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.4
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (context != null) {
                    long index = FaceDetect.this.bdFaceInstance.getIndex();
                    if (index == 0) {
                        return;
                    }
                    byte[] modelContent = FileUitls.getModelContent(context, str);
                    int i3 = -1;
                    if (modelContent.length != 0) {
                        i2 = FaceDetect.this.nativeAttributeModelInit(index, modelContent);
                        if (i2 != 0) {
                            callback.onResponse(i2, "属性模型加载失败");
                            return;
                        }
                    } else {
                        i2 = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                    if (modelContent2.length != 0 && (i3 = FaceDetect.this.nativeEmotionsModelInit(index, modelContent2)) != 0) {
                        callback.onResponse(i3, "情绪模型加载失败");
                        return;
                    }
                    if (i2 != 0 && i3 != 0) {
                        callback.onResponse(1, "属性模型加载失败");
                    } else {
                        callback.onResponse(0, "属性模型加载成功");
                    }
                    Log.e("bdface", "FaceAttributes initModel");
                    return;
                }
                callback.onResponse(1, "没有初始化上下文");
            }
        });
    }

    public void initFaceClose(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.5
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (context != null) {
                    long index = FaceDetect.this.bdFaceInstance.getIndex();
                    if (index == 0) {
                        return;
                    }
                    byte[] modelContent = FileUitls.getModelContent(context, str);
                    int i3 = -1;
                    if (modelContent.length != 0) {
                        i2 = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent, 0);
                        if (i2 != 0) {
                            callback.onResponse(i2, "眼睛闭合模型加载失败");
                            return;
                        }
                    } else {
                        i2 = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                    if (modelContent2.length != 0 && (i3 = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent2, 1)) != 0) {
                        callback.onResponse(i3, "嘴巴闭合模型加载失败");
                        return;
                    }
                    if (i2 != 0 && i3 != 0) {
                        callback.onResponse(1, "闭眼闭嘴模型加载失败");
                    } else {
                        callback.onResponse(0, "闭眼闭嘴模型加载成功");
                    }
                    Log.e("bdface", "FaceClose initModel");
                    return;
                }
                callback.onResponse(1, "没有初始化上下文");
            }
        });
    }

    public void initModel(final Context context, final String str, final String str2, final String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int i3;
                if (context != null) {
                    long index = FaceDetect.this.bdFaceInstance.getIndex();
                    if (index == 0) {
                        return;
                    }
                    byte[] modelContent = FileUitls.getModelContent(context, str);
                    int i4 = -1;
                    if (modelContent.length != 0) {
                        i2 = FaceDetect.this.nativeDetectModelInit(index, modelContent, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal());
                        if (i2 != 0) {
                            callback.onResponse(i2, "Vis检测模型加载失败");
                            return;
                        }
                    } else {
                        i2 = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                    if (modelContent2.length != 0) {
                        int nativeDetectModelInit = FaceDetect.this.nativeDetectModelInit(index, modelContent2, BDFaceSDKCommon.DetectType.DETECT_NIR.ordinal());
                        if (nativeDetectModelInit != 0) {
                            callback.onResponse(nativeDetectModelInit, "Nir检测模型加载失败");
                            return;
                        }
                        i3 = nativeDetectModelInit;
                    } else {
                        i3 = -1;
                    }
                    byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                    if (modelContent3.length == 0 || (i4 = FaceDetect.this.nativeAlignModelInit(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), modelContent3)) == 0) {
                        int nativeLoadTrack = FaceDetect.this.nativeLoadTrack(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal());
                        if (nativeLoadTrack == 0) {
                            if ((i2 == 0 || i3 == 0) && i4 == 0) {
                                callback.onResponse(0, "检测对齐模型加载成功");
                            } else {
                                callback.onResponse(1, "检测对齐模型加载失败");
                            }
                            Log.e(FaceDetect.TAG, "FaceDetect initModel");
                            return;
                        }
                        callback.onResponse(nativeLoadTrack, "跟踪能力加载失败");
                        return;
                    }
                    callback.onResponse(i4, "对齐模型加载失败");
                    return;
                }
                callback.onResponse(1, "没有初始化上下文");
            }
        });
    }

    public void initQuality(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.3
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (context != null) {
                    long index = FaceDetect.this.bdFaceInstance.getIndex();
                    if (index == 0) {
                        return;
                    }
                    byte[] modelContent = FileUitls.getModelContent(context, str);
                    int i3 = -1;
                    if (modelContent.length != 0) {
                        i2 = FaceDetect.this.nativeQualityModelInit(index, modelContent, BDFaceSDKCommon.FaceQualityType.BLUR.ordinal());
                        if (i2 != 0) {
                            callback.onResponse(i2, "模糊模型加载失败");
                            return;
                        }
                    } else {
                        i2 = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                    if (modelContent2.length == 0 || (i3 = FaceDetect.this.nativeQualityModelInit(index, modelContent2, BDFaceSDKCommon.FaceQualityType.OCCLUSION.ordinal())) == 0) {
                        if (i2 != 0 && i3 != 0) {
                            callback.onResponse(1, "质量模型加载失败");
                        } else {
                            callback.onResponse(0, "质量模型加载成功");
                        }
                        Log.e(FaceDetect.TAG, "FaceDetect initQuality");
                        return;
                    }
                    callback.onResponse(i3, "遮挡模型加载失败");
                    return;
                }
                callback.onResponse(1, "没有初始化上下文");
            }
        });
    }

    public void loadConfig(BDFaceSDKConfig bDFaceSDKConfig) {
        BDFaceInstance bDFaceInstance = this.bdFaceInstance;
        if (bDFaceInstance == null) {
            return;
        }
        long index = bDFaceInstance.getIndex();
        if (index == 0) {
            return;
        }
        nativeLoadConfig(index, bDFaceSDKConfig);
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType != null && bDFaceImageInstance != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index != 0 && this.lock.tryLock()) {
                FaceInfo[] nativeTrack = nativeTrack(index, detectType.ordinal(), bDFaceImageInstance);
                this.lock.unlock();
                return nativeTrack;
            }
            return null;
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public int uninitModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitModel(index);
    }

    public void initModel(final Context context, final String str, final String str2, final BDFaceSDKCommon.DetectType detectType, final BDFaceSDKCommon.AlignType alignType, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.2
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (context != null) {
                    long index = FaceDetect.this.bdFaceInstance.getIndex();
                    if (index == 0) {
                        return;
                    }
                    byte[] modelContent = FileUitls.getModelContent(context, str);
                    int i3 = -1;
                    if (modelContent.length != 0) {
                        i2 = FaceDetect.this.nativeDetectModelInit(index, modelContent, detectType.ordinal());
                        if (i2 != 0) {
                            callback.onResponse(i2, "检测模型加载失败");
                            return;
                        }
                    } else {
                        i2 = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                    if (modelContent2.length == 0 || (i3 = FaceDetect.this.nativeAlignModelInit(index, detectType.ordinal(), alignType.ordinal(), modelContent2)) == 0) {
                        int nativeLoadTrack = FaceDetect.this.nativeLoadTrack(index, detectType.ordinal(), alignType.ordinal());
                        if (nativeLoadTrack == 0) {
                            if (i2 == 0 && i3 == 0) {
                                callback.onResponse(0, "检测对齐模型加载成功");
                            } else {
                                callback.onResponse(1, "检测对齐模型加载失败");
                            }
                            Log.e(FaceDetect.TAG, "FaceDetect initModel");
                            return;
                        }
                        callback.onResponse(nativeLoadTrack, "跟踪能力加载失败");
                        return;
                    }
                    callback.onResponse(i3, "对齐模型加载失败");
                    return;
                }
                callback.onResponse(1, "没有初始化上下文");
            }
        });
    }

    public FaceDetect() {
        this.lock = null;
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
        this.lock = new ReentrantLock();
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType != null && bDFaceImageInstance != null && alignType != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeFastTrack(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance);
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf) {
        if (detectType != null && bDFaceImageInstance != null && alignType != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index != 0 && this.lock.tryLock()) {
                FaceInfo[] nativeFlexibleDetect = nativeFlexibleDetect(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance, faceInfoArr, bDFaceDetectListConf);
                this.lock.unlock();
                return nativeFlexibleDetect;
            }
            return null;
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }
}
