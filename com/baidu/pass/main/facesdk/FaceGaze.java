package com.baidu.pass.main.facesdk;

import android.content.Context;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceGazeInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.utils.FileUitls;
/* loaded from: classes2.dex */
public class FaceGaze {
    public static final String TAG = "FaceGaze";
    public BDFaceInstance bdFaceInstance;

    public FaceGaze(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native BDFaceGazeInfo nativeGaze(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGazeModelInit(long j, byte[] bArr);

    private native int nativeUninitGazeModel(long j);

    public BDFaceGazeInfo gaze(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (bDFaceImageInstance == null || fArr == null || fArr.length < 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeGaze(index, bDFaceImageInstance, fArr);
    }

    public void initModel(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceGaze.1
            @Override // java.lang.Runnable
            public void run() {
                if (context != null) {
                    long index = FaceGaze.this.bdFaceInstance.getIndex();
                    if (index == 0) {
                        return;
                    }
                    int i2 = -1;
                    byte[] modelContent = FileUitls.getModelContent(context, str);
                    if (modelContent.length != 0 && (i2 = FaceGaze.this.nativeGazeModelInit(index, modelContent)) != 0) {
                        callback.onResponse(i2, "注意力检测模型加载失败");
                        return;
                    } else if (i2 == 0) {
                        callback.onResponse(0, "注意力检测模型加载成功");
                        return;
                    } else {
                        callback.onResponse(1, "注意力检测模型加载失败");
                        return;
                    }
                }
                callback.onResponse(1, "没有初始化上下文");
            }
        });
    }

    public int uninitGazeModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitGazeModel(index);
    }

    public FaceGaze() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
