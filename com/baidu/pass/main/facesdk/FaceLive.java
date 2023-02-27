package com.baidu.pass.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.utils.FileUitls;
/* loaded from: classes2.dex */
public class FaceLive {
    public static final String TAG = "FaceLive";
    public BDFaceInstance bdFaceInstance;

    public FaceLive() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }

    public FaceLive(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native float nativeSilentLive(long j, int i, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSilentLiveModelInit(long j, byte[] bArr, int i);

    private native int nativeUninitModel(long j);

    public void initModel(final Context context, final String str, final String str2, final String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceLive.1
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
                long index = FaceLive.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i4 = -1;
                if (modelContent.length != 0) {
                    i = FaceLive.this.nativeSilentLiveModelInit(index, modelContent, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_RGB.ordinal());
                    if (i != 0) {
                        callback.onResponse(i, "Vis 活体模型加载失败");
                        return;
                    }
                } else {
                    i = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0) {
                    i2 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent2, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_NIR.ordinal());
                    if (i2 != 0) {
                        callback.onResponse(i2, "Nir 活体模型加载失败");
                        return;
                    }
                } else {
                    i2 = -1;
                }
                byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                if (modelContent3.length != 0 && (i4 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent3, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_DEPTH.ordinal())) != 0) {
                    callback.onResponse(i4, "Deep 活体模型加载失败");
                    return;
                }
                if (i == 0 || i2 == 0 || i4 == 0) {
                    callback2 = callback;
                    i3 = 0;
                    str4 = "活体模型加载成功";
                } else {
                    callback2 = callback;
                    str4 = "活体模型加载失败";
                }
                callback2.onResponse(i3, str4);
                Log.e("bdface", "FaceLive initModel");
            }
        });
    }

    public float silentLive(BDFaceSDKCommon.LiveType liveType, BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (liveType == null || bDFaceImageInstance == null || fArr == null) {
            Log.v(TAG, "Parameter is null");
            return -1.0f;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1.0f;
        }
        return nativeSilentLive(index, liveType.ordinal(), bDFaceImageInstance, fArr);
    }

    public int uninitModel() {
        if (this.bdFaceInstance.getIndex() == 0) {
            return -1;
        }
        return nativeUninitModel(this.bdFaceInstance.getIndex());
    }
}
