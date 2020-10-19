package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.lang.ref.WeakReference;
/* loaded from: classes14.dex */
public class b extends com.baidu.ar.d implements ICapture {
    private WeakReference<ICapture> kL;
    private ICaptureAbilityListener kM;

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        if (cVar == null) {
            if (this.kL != null) {
                this.kL.clear();
                this.kL = null;
            }
        } else if (cVar instanceof ICapture) {
            this.kL = new WeakReference<>((ICapture) cVar);
            if (this.kM != null) {
                this.kL.get().setAbilityListener(this.kM);
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.kL == null || this.kL.get() == null || iCallbackWith == null) {
            return;
        }
        this.kL.get().capture(iCallbackWith);
    }

    @Override // com.baidu.ar.d
    public void release() {
        this.kM = null;
        if (this.kL != null) {
            this.kL.clear();
            this.kL = null;
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        if (this.kL == null || this.kL.get() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        this.kL.get().sendBase64ImageToLua(strArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        if (this.kL == null || this.kL.get() == null || bitmapArr == null || bitmapArr.length <= 0) {
            return;
        }
        this.kL.get().sendImageToLua(bitmapArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.kL == null || this.kL.get() == null) {
            this.kM = iCaptureAbilityListener;
        } else {
            this.kL.get().setAbilityListener(iCaptureAbilityListener);
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.kL == null || this.kL.get() == null || iCallbackWith == null) {
            return;
        }
        this.kL.get().setCaptureCallback(iCallbackWith);
    }
}
