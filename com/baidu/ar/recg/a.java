package com.baidu.ar.recg;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements IOnDeviceIR {
    private WeakReference<IOnDeviceIR> kO;
    private IOnDeviceIRStateChangedListener sb;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof IOnDeviceIR) {
            this.kO = new WeakReference<>((IOnDeviceIR) cVar);
            if (this.sb != null) {
                ((IOnDeviceIR) cVar).setStateChangedListener(this.sb);
            }
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.kO != null) {
            this.kO.clear();
            this.kO = null;
        }
        this.sb = null;
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void retry() {
        if (this.kO == null || this.kO.get() == null) {
            return;
        }
        this.kO.get().retry();
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void setStateChangedListener(IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener) {
        this.sb = iOnDeviceIRStateChangedListener;
        if (this.sb == null || this.kO == null || this.kO.get() == null) {
            return;
        }
        this.kO.get().setStateChangedListener(this.sb);
    }
}
