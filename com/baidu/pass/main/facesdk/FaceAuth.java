package com.baidu.pass.main.facesdk;

import android.util.Log;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
/* loaded from: classes3.dex */
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

    private native void nativeSetActiveLog(int i, int i2);

    private native void nativeSetCoreConfigure(int i, int i2);

    public void initLicense(final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.pass.main.facesdk.FaceAuth.1
            @Override // java.lang.Runnable
            public void run() {
                int i = -1;
                try {
                    i = FaceAuth.this.nativeCreatInstance();
                } catch (Throwable th) {
                    th.printStackTrace();
                    Log.e(FaceAuth.TAG, "bdface_create_instance status -1");
                }
                callback.onResponse(i, "OK");
            }
        });
    }

    public boolean isLoadSucess() {
        return this.isLoadSucess;
    }

    public void setActiveLog(BDFaceSDKCommon.BDFaceLogInfo bDFaceLogInfo, int i) {
        try {
            nativeSetActiveLog(bDFaceLogInfo.ordinal(), i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode bDFaceCoreRunMode, int i) {
        try {
            nativeSetCoreConfigure(bDFaceCoreRunMode.ordinal(), i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
