package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class b extends com.baidu.ar.d implements ICapture {
    private WeakReference<ICapture> kc;
    private ICaptureAbilityListener kd;

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        if (cVar == null) {
            if (this.kc != null) {
                this.kc.clear();
                this.kc = null;
            }
        } else if (cVar instanceof ICapture) {
            this.kc = new WeakReference<>((ICapture) cVar);
            if (this.kd != null) {
                this.kc.get().setAbilityListener(this.kd);
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.kc == null || this.kc.get() == null || iCallbackWith == null) {
            return;
        }
        this.kc.get().capture(iCallbackWith);
    }

    @Override // com.baidu.ar.d
    public void release() {
        this.kd = null;
        if (this.kc != null) {
            this.kc.clear();
            this.kc = null;
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        if (this.kc == null || this.kc.get() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        this.kc.get().sendBase64ImageToLua(strArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        if (this.kc == null || this.kc.get() == null || bitmapArr == null || bitmapArr.length <= 0) {
            return;
        }
        this.kc.get().sendImageToLua(bitmapArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.kc == null || this.kc.get() == null) {
            this.kd = iCaptureAbilityListener;
        } else {
            this.kc.get().setAbilityListener(iCaptureAbilityListener);
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.kc == null || this.kc.get() == null || iCallbackWith == null) {
            return;
        }
        this.kc.get().setCaptureCallback(iCallbackWith);
    }
}
