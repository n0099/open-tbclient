package com.baidu.ar.external;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.baidu.ar.external.ARCallback;
/* loaded from: classes3.dex */
public abstract class BaseFragment extends Fragment {
    protected a a;
    private ARCallback b;
    private ARCallbackClient c;
    private ARCaptureResultCallback d;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.b.release();
        this.b = null;
        this.c = null;
    }

    public void callbackQuitAR() {
        callbackQuitAR(ARCallback.ARAction.BACK);
    }

    public void callbackQuitAR(ARCallback.ARAction aRAction) {
        if (this.b != null) {
            this.b.quitAR(this, aRAction);
        }
    }

    public ARCallback getARCallback() {
        return this.b;
    }

    public ARCaptureResultCallback getARCaptureResultCallback() {
        return this.d;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.b == null) {
            this.b = new ARCallback();
        }
    }

    public void setARCallbackClient(ARCallbackClient aRCallbackClient) {
        this.c = aRCallbackClient;
        if (this.b == null) {
            this.b = new ARCallback();
        }
        this.b.setARCallbackClient(aRCallbackClient);
    }

    public void setARCaptureResultCallback(ARCaptureResultCallback aRCaptureResultCallback) {
        this.d = aRCaptureResultCallback;
    }

    public void setARPluginCallback(a aVar) {
        this.a = aVar;
        if (this.b == null) {
            this.b = new ARCallback();
        }
        this.b.setARPluginCallback(aVar);
    }
}
