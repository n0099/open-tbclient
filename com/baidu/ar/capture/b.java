package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b extends com.baidu.ar.d implements ICapture {
    private WeakReference<ICapture> la;
    private ICaptureAbilityListener lb;

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        if (cVar == null) {
            if (this.la != null) {
                this.la.clear();
                this.la = null;
            }
        } else if (cVar instanceof ICapture) {
            this.la = new WeakReference<>((ICapture) cVar);
            if (this.lb != null) {
                this.la.get().setAbilityListener(this.lb);
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.la == null || this.la.get() == null || iCallbackWith == null) {
            return;
        }
        this.la.get().capture(iCallbackWith);
    }

    @Override // com.baidu.ar.d
    public void release() {
        this.lb = null;
        if (this.la != null) {
            this.la.clear();
            this.la = null;
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        if (this.la == null || this.la.get() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        this.la.get().sendBase64ImageToLua(strArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        if (this.la == null || this.la.get() == null || bitmapArr == null || bitmapArr.length <= 0) {
            return;
        }
        this.la.get().sendImageToLua(bitmapArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.la == null || this.la.get() == null) {
            this.lb = iCaptureAbilityListener;
        } else {
            this.la.get().setAbilityListener(iCaptureAbilityListener);
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.la == null || this.la.get() == null || iCallbackWith == null) {
            return;
        }
        this.la.get().setCaptureCallback(iCallbackWith);
    }
}
