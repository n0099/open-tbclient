package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b extends com.baidu.ar.d implements ICapture {
    public WeakReference<ICapture> la;
    public ICaptureAbilityListener lb;

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        if (cVar == null) {
            WeakReference<ICapture> weakReference = this.la;
            if (weakReference != null) {
                weakReference.clear();
                this.la = null;
            }
        } else if (cVar instanceof ICapture) {
            WeakReference<ICapture> weakReference2 = new WeakReference<>((ICapture) cVar);
            this.la = weakReference2;
            if (this.lb != null) {
                weakReference2.get().setAbilityListener(this.lb);
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        WeakReference<ICapture> weakReference = this.la;
        if (weakReference == null || weakReference.get() == null || iCallbackWith == null) {
            return;
        }
        this.la.get().capture(iCallbackWith);
    }

    @Override // com.baidu.ar.d
    public void release() {
        this.lb = null;
        WeakReference<ICapture> weakReference = this.la;
        if (weakReference != null) {
            weakReference.clear();
            this.la = null;
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        WeakReference<ICapture> weakReference = this.la;
        if (weakReference == null || weakReference.get() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        this.la.get().sendBase64ImageToLua(strArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        WeakReference<ICapture> weakReference = this.la;
        if (weakReference == null || weakReference.get() == null || bitmapArr == null || bitmapArr.length <= 0) {
            return;
        }
        this.la.get().sendImageToLua(bitmapArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        WeakReference<ICapture> weakReference = this.la;
        if (weakReference == null || weakReference.get() == null) {
            this.lb = iCaptureAbilityListener;
        } else {
            this.la.get().setAbilityListener(iCaptureAbilityListener);
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        WeakReference<ICapture> weakReference = this.la;
        if (weakReference == null || weakReference.get() == null || iCallbackWith == null) {
            return;
        }
        this.la.get().setCaptureCallback(iCallbackWith);
    }
}
