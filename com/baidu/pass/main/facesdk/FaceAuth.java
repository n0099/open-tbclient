package com.baidu.pass.main.facesdk;

import android.util.Log;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
/* loaded from: classes2.dex */
public class FaceAuth {
    public static final String TAG = "FaceSDK";
    public boolean isLoadSucess;

    public FaceAuth() {
        this.isLoadSucess = false;
        try {
            System.loadLibrary("bd_pass_face_sdk");
            this.isLoadSucess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCreatInstance();

    private native void nativeSetActiveLog(int i2, int i3);

    private native void nativeSetCoreConfigure(int i2, int i3);

    public void initLicense(final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceAuth.1
            @Override // java.lang.Runnable
            public void run() {
                int nativeCreatInstance = FaceAuth.this.nativeCreatInstance();
                Log.v(FaceAuth.TAG, "bdface_create_instance status " + nativeCreatInstance);
                callback.onResponse(nativeCreatInstance, "OK");
            }
        });
    }

    public boolean isLoadSucess() {
        return this.isLoadSucess;
    }

    public void setActiveLog(BDFaceSDKCommon.BDFaceLogInfo bDFaceLogInfo, int i2) {
        nativeSetActiveLog(bDFaceLogInfo.ordinal(), i2);
    }

    public void setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode bDFaceCoreRunMode, int i2) {
        nativeSetCoreConfigure(bDFaceCoreRunMode.ordinal(), i2);
    }
}
