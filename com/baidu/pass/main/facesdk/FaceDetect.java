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

    public FaceDetect() {
        this.lock = null;
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
        this.lock = new ReentrantLock();
    }

    public FaceDetect(BDFaceInstance bDFaceInstance) {
        this.lock = null;
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
        this.lock = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAlignModelInit(long j, int i, int i2, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAttributeModelInit(long j, byte[] bArr);

    private native BDFaceImageInstance nativeCropFace(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    private native FaceInfo[] nativeDetect(long j, int i, int i2, BDFaceImageInstance bDFaceImageInstance);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeDetectModelInit(long j, byte[] bArr, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeEmotionsModelInit(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFaceCloseModelInit(long j, byte[] bArr, int i);

    private native FaceInfo[] nativeFastTrack(long j, int i, int i2, BDFaceImageInstance bDFaceImageInstance);

    private native FaceInfo[] nativeFlexibleDetect(long j, int i, int i2, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf);

    private native void nativeLoadConfig(long j, BDFaceSDKConfig bDFaceSDKConfig);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeLoadTrack(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeQualityModelInit(long j, byte[] bArr, int i);

    private native FaceInfo[] nativeTrack(long j, int i, BDFaceImageInstance bDFaceImageInstance);

    private native int nativeUninitModel(long j);

    public BDFaceImageInstance cropFace(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (bDFaceImageInstance == null || fArr == null) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFace(index, bDFaceImageInstance, fArr);
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType == null || bDFaceImageInstance == null) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index != 0 && this.lock.tryLock()) {
            FaceInfo[] nativeDetect = nativeDetect(index, detectType.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), bDFaceImageInstance);
            this.lock.unlock();
            return nativeDetect;
        }
        return null;
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf) {
        if (detectType == null || bDFaceImageInstance == null || alignType == null) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index != 0 && this.lock.tryLock()) {
            FaceInfo[] nativeFlexibleDetect = nativeFlexibleDetect(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance, faceInfoArr, bDFaceDetectListConf);
            this.lock.unlock();
            return nativeFlexibleDetect;
        }
        return null;
    }

    public void initAttrEmo(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.4
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i2 = -1;
                if (modelContent.length != 0) {
                    i = FaceDetect.this.nativeAttributeModelInit(index, modelContent);
                    if (i != 0) {
                        callback.onResponse(i, "属性模型加载失败");
                        return;
                    }
                } else {
                    i = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i2 = FaceDetect.this.nativeEmotionsModelInit(index, modelContent2)) != 0) {
                    callback.onResponse(i2, "情绪模型加载失败");
                    return;
                }
                if (i == 0 || i2 == 0) {
                    callback.onResponse(0, "属性模型加载成功");
                } else {
                    callback.onResponse(1, "属性模型加载失败");
                }
                Log.e("bdface", "FaceAttributes initModel");
            }
        });
    }

    public void initFaceClose(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.5
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i2 = -1;
                if (modelContent.length != 0) {
                    i = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent, 0);
                    if (i != 0) {
                        callback.onResponse(i, "眼睛闭合模型加载失败");
                        return;
                    }
                } else {
                    i = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i2 = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent2, 1)) != 0) {
                    callback.onResponse(i2, "嘴巴闭合模型加载失败");
                    return;
                }
                if (i == 0 || i2 == 0) {
                    callback.onResponse(0, "闭眼闭嘴模型加载成功");
                } else {
                    callback.onResponse(1, "闭眼闭嘴模型加载失败");
                }
                Log.e("bdface", "FaceClose initModel");
            }
        });
    }

    public void initModel(final Context context, final String str, final String str2, final BDFaceSDKCommon.DetectType detectType, final BDFaceSDKCommon.AlignType alignType, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.2
            @Override // java.lang.Runnable
            public void run() {
                int i;
                Callback callback2;
                String str3;
                int i2 = 1;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i3 = -1;
                if (modelContent.length != 0) {
                    i = FaceDetect.this.nativeDetectModelInit(index, modelContent, detectType.ordinal());
                    if (i != 0) {
                        callback.onResponse(i, "检测模型加载失败");
                        return;
                    }
                } else {
                    i = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i3 = FaceDetect.this.nativeAlignModelInit(index, detectType.ordinal(), alignType.ordinal(), modelContent2)) != 0) {
                    callback.onResponse(i3, "对齐模型加载失败");
                    return;
                }
                int nativeLoadTrack = FaceDetect.this.nativeLoadTrack(index, detectType.ordinal(), alignType.ordinal());
                if (nativeLoadTrack != 0) {
                    callback.onResponse(nativeLoadTrack, "跟踪能力加载失败");
                    return;
                }
                if (i == 0 && i3 == 0) {
                    callback2 = callback;
                    i2 = 0;
                    str3 = "检测对齐模型加载成功";
                } else {
                    callback2 = callback;
                    str3 = "检测对齐模型加载失败";
                }
                callback2.onResponse(i2, str3);
                Log.e(FaceDetect.TAG, "FaceDetect initModel");
            }
        });
    }

    public void initModel(final Context context, final String str, final String str2, final String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2;
                Callback callback2;
                String str4;
                int i3 = 1;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i4 = -1;
                if (modelContent.length != 0) {
                    i = FaceDetect.this.nativeDetectModelInit(index, modelContent, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal());
                    if (i != 0) {
                        callback.onResponse(i, "Vis检测模型加载失败");
                        return;
                    }
                } else {
                    i = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0) {
                    int nativeDetectModelInit = FaceDetect.this.nativeDetectModelInit(index, modelContent2, BDFaceSDKCommon.DetectType.DETECT_NIR.ordinal());
                    if (nativeDetectModelInit != 0) {
                        callback.onResponse(nativeDetectModelInit, "Nir检测模型加载失败");
                        return;
                    }
                    i2 = nativeDetectModelInit;
                } else {
                    i2 = -1;
                }
                byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                if (modelContent3.length != 0 && (i4 = FaceDetect.this.nativeAlignModelInit(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), modelContent3)) != 0) {
                    callback.onResponse(i4, "对齐模型加载失败");
                    return;
                }
                int nativeLoadTrack = FaceDetect.this.nativeLoadTrack(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal());
                if (nativeLoadTrack != 0) {
                    callback.onResponse(nativeLoadTrack, "跟踪能力加载失败");
                    return;
                }
                if ((i == 0 || i2 == 0) && i4 == 0) {
                    callback2 = callback;
                    i3 = 0;
                    str4 = "检测对齐模型加载成功";
                } else {
                    callback2 = callback;
                    str4 = "检测对齐模型加载失败";
                }
                callback2.onResponse(i3, str4);
                Log.e(FaceDetect.TAG, "FaceDetect initModel");
            }
        });
    }

    public void initQuality(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceDetect.3
            @Override // java.lang.Runnable
            public void run() {
                int i;
                Callback callback2;
                String str3;
                int i2 = 1;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i3 = -1;
                if (modelContent.length != 0) {
                    i = FaceDetect.this.nativeQualityModelInit(index, modelContent, BDFaceSDKCommon.FaceQualityType.BLUR.ordinal());
                    if (i != 0) {
                        callback.onResponse(i, "模糊模型加载失败");
                        return;
                    }
                } else {
                    i = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i3 = FaceDetect.this.nativeQualityModelInit(index, modelContent2, BDFaceSDKCommon.FaceQualityType.OCCLUSION.ordinal())) != 0) {
                    callback.onResponse(i3, "遮挡模型加载失败");
                    return;
                }
                if (i == 0 || i3 == 0) {
                    callback2 = callback;
                    i2 = 0;
                    str3 = "质量模型加载成功";
                } else {
                    callback2 = callback;
                    str3 = "质量模型加载失败";
                }
                callback2.onResponse(i2, str3);
                Log.e(FaceDetect.TAG, "FaceDetect initQuality");
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
        if (detectType == null || bDFaceImageInstance == null) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index != 0 && this.lock.tryLock()) {
            FaceInfo[] nativeTrack = nativeTrack(index, detectType.ordinal(), bDFaceImageInstance);
            this.lock.unlock();
            return nativeTrack;
        }
        return null;
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType == null || bDFaceImageInstance == null || alignType == null) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeFastTrack(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance);
    }

    public int uninitModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitModel(index);
    }
}
