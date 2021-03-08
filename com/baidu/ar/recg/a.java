package com.baidu.ar.recg;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements IOnDeviceIR {
    private WeakReference<IOnDeviceIR> mj;
    private IOnDeviceIRStateChangedListener tT;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof IOnDeviceIR) {
            this.mj = new WeakReference<>((IOnDeviceIR) cVar);
            if (this.tT != null) {
                ((IOnDeviceIR) cVar).setStateChangedListener(this.tT);
            }
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.mj != null) {
            this.mj.clear();
            this.mj = null;
        }
        this.tT = null;
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void retry() {
        if (this.mj == null || this.mj.get() == null) {
            return;
        }
        this.mj.get().retry();
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void setStateChangedListener(IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener) {
        this.tT = iOnDeviceIRStateChangedListener;
        if (this.tT == null || this.mj == null || this.mj.get() == null) {
            return;
        }
        this.mj.get().setStateChangedListener(this.tT);
    }
}
