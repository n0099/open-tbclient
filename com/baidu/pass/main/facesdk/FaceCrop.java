package com.baidu.pass.main.facesdk;

import android.util.Log;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceCropParam;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.model.BDFaceIsOutBoundary;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class FaceCrop {
    public static final String TAG = "FaceCrop";
    public BDFaceInstance bdFaceInstance;

    public FaceCrop() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }

    public FaceCrop(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native BDFaceImageInstance nativeCropFaceByBox(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByBoxIsOutofBoundary(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByBoxParam(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmark(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f, boolean z, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByLandmarkIsOutofBoundary(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmarkParam(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    private native long nativeCropFaceByLandmarkParamInstance(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCropImageInit(long j);

    private native BDFaceImageInstance nativeResizeImage(BDFaceImageInstance bDFaceImageInstance, int i, BDFaceSDKCommon.BDFaceImageType bDFaceImageType);

    private native int nativeUnInitCropImage(long j);

    public BDFaceImageInstance cropFaceByBox(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance == null || faceInfo == null || atomicInteger == null) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        int[] iArr = new int[1];
        BDFaceImageInstance nativeCropFaceByBox = nativeCropFaceByBox(index, bDFaceImageInstance, faceInfo, f, iArr);
        atomicInteger.set(iArr[0]);
        return nativeCropFaceByBox;
    }

    public BDFaceIsOutBoundary cropFaceByBoxIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || faceInfo == null || bDFaceCropParam == null) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByBoxIsOutofBoundary(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
    }

    public BDFaceImageInstance cropFaceByBoxParam(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        String str;
        String str2;
        if (bDFaceImageInstance == null || faceInfo == null || bDFaceCropParam == null) {
            str = TAG;
            str2 = "Parameter is null";
        } else {
            long index = this.bdFaceInstance.getIndex();
            if (index != 0) {
                return nativeCropFaceByBoxParam(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
            }
            str = TAG;
            str2 = "instanceIndex == 0";
        }
        Log.v(str, str2);
        return null;
    }

    public BDFaceImageInstance cropFaceByLandmark(BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f, boolean z, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance == null || atomicInteger == null || fArr.length < 0) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        int[] iArr = new int[1];
        BDFaceImageInstance nativeCropFaceByLandmark = nativeCropFaceByLandmark(index, bDFaceImageInstance, fArr, f, z, iArr);
        atomicInteger.set(iArr[0]);
        return nativeCropFaceByLandmark;
    }

    public BDFaceIsOutBoundary cropFaceByLandmarkIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByLandmarkIsOutofBoundary(index, bDFaceImageInstance, fArr, bDFaceCropParam);
    }

    public BDFaceImageInstance cropFaceByLandmarkParam(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByLandmarkParam(index, bDFaceImageInstance, fArr, bDFaceCropParam);
    }

    public BDFaceImageInstance cropFaceByLandmarkParamInstance(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
            Log.v(TAG, "Parameter is null");
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return new BDFaceImageInstance(nativeCropFaceByLandmarkParamInstance(index, bDFaceImageInstance, fArr, bDFaceCropParam));
    }

    public void initFaceCrop(final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceCrop.1
            @Override // java.lang.Runnable
            public void run() {
                long index = FaceCrop.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    callback.onResponse(-1, "抠图能力加载失败 instanceIndex=0");
                    return;
                }
                int nativeCropImageInit = FaceCrop.this.nativeCropImageInit(index);
                Callback callback2 = callback;
                if (nativeCropImageInit == 0) {
                    callback2.onResponse(nativeCropImageInit, "抠图能力加载成功");
                    return;
                }
                callback2.onResponse(nativeCropImageInit, "抠图能力加载失败: " + nativeCropImageInit);
            }
        });
    }

    public BDFaceImageInstance resizeImage(BDFaceImageInstance bDFaceImageInstance, int i) {
        if (bDFaceImageInstance == null) {
            return null;
        }
        return nativeResizeImage(bDFaceImageInstance, i, bDFaceImageInstance.imageType);
    }

    public int uninitFaceCrop() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUnInitCropImage(index);
    }
}
