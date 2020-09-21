package com.baidu.ar.recg;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class a extends d implements IOnDeviceIR {
    private WeakReference<IOnDeviceIR> lU;
    private IOnDeviceIRStateChangedListener tg;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof IOnDeviceIR) {
            this.lU = new WeakReference<>((IOnDeviceIR) cVar);
            if (this.tg != null) {
                ((IOnDeviceIR) cVar).setStateChangedListener(this.tg);
            }
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.lU != null) {
            this.lU.clear();
            this.lU = null;
        }
        this.tg = null;
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void retry() {
        if (this.lU == null || this.lU.get() == null) {
            return;
        }
        this.lU.get().retry();
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void setStateChangedListener(IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener) {
        this.tg = iOnDeviceIRStateChangedListener;
        if (this.tg == null || this.lU == null || this.lU.get() == null) {
            return;
        }
        this.lU.get().setStateChangedListener(this.tg);
    }
}
