package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b extends com.baidu.ar.d implements ICapture {
    private WeakReference<ICapture> jK;
    private ICaptureAbilityListener jL;

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        if (cVar == null) {
            if (this.jK != null) {
                this.jK.clear();
                this.jK = null;
            }
        } else if (cVar instanceof ICapture) {
            this.jK = new WeakReference<>((ICapture) cVar);
            if (this.jL != null) {
                this.jK.get().setAbilityListener(this.jL);
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.jK == null || this.jK.get() == null || iCallbackWith == null) {
            return;
        }
        this.jK.get().capture(iCallbackWith);
    }

    @Override // com.baidu.ar.d
    public void release() {
        this.jL = null;
        if (this.jK != null) {
            this.jK.clear();
            this.jK = null;
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        if (this.jK == null || this.jK.get() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        this.jK.get().sendBase64ImageToLua(strArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        if (this.jK == null || this.jK.get() == null || bitmapArr == null || bitmapArr.length <= 0) {
            return;
        }
        this.jK.get().sendImageToLua(bitmapArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.jK == null || this.jK.get() == null) {
            this.jL = iCaptureAbilityListener;
        } else {
            this.jK.get().setAbilityListener(iCaptureAbilityListener);
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.jK == null || this.jK.get() == null || iCallbackWith == null) {
            return;
        }
        this.jK.get().setCaptureCallback(iCallbackWith);
    }
}
