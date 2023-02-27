package com.baidu.ar.recg;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a extends d implements IOnDeviceIR {
    public WeakReference<IOnDeviceIR> mj;
    public IOnDeviceIRStateChangedListener tT;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof IOnDeviceIR) {
            IOnDeviceIR iOnDeviceIR = (IOnDeviceIR) cVar;
            this.mj = new WeakReference<>(iOnDeviceIR);
            IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener = this.tT;
            if (iOnDeviceIRStateChangedListener != null) {
                iOnDeviceIR.setStateChangedListener(iOnDeviceIRStateChangedListener);
            }
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        WeakReference<IOnDeviceIR> weakReference = this.mj;
        if (weakReference != null) {
            weakReference.clear();
            this.mj = null;
        }
        this.tT = null;
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void retry() {
        WeakReference<IOnDeviceIR> weakReference = this.mj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().retry();
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void setStateChangedListener(IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener) {
        WeakReference<IOnDeviceIR> weakReference;
        this.tT = iOnDeviceIRStateChangedListener;
        if (iOnDeviceIRStateChangedListener == null || (weakReference = this.mj) == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().setStateChangedListener(this.tT);
    }
}
