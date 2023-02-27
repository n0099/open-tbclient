package com.baidu.ar.cloud;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a extends d implements ICloudIR {
    public WeakReference<ICloudIR> mj;
    public ICloudIRStateChangedListener mk;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ICloudIR) {
            ICloudIR iCloudIR = (ICloudIR) cVar;
            this.mj = new WeakReference<>(iCloudIR);
            ICloudIRStateChangedListener iCloudIRStateChangedListener = this.mk;
            if (iCloudIRStateChangedListener != null) {
                iCloudIR.setStateChangedListener(iCloudIRStateChangedListener);
            }
        }
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void pause() {
        WeakReference<ICloudIR> weakReference = this.mj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().pause();
    }

    @Override // com.baidu.ar.d
    public void release() {
        WeakReference<ICloudIR> weakReference = this.mj;
        if (weakReference != null) {
            weakReference.clear();
            this.mj = null;
        }
        this.mk = null;
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void resume() {
        WeakReference<ICloudIR> weakReference = this.mj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().resume();
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void setStateChangedListener(ICloudIRStateChangedListener iCloudIRStateChangedListener) {
        WeakReference<ICloudIR> weakReference;
        this.mk = iCloudIRStateChangedListener;
        if (iCloudIRStateChangedListener == null || (weakReference = this.mj) == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().setStateChangedListener(this.mk);
    }
}
