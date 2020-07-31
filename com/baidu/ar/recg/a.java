package com.baidu.ar.recg;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class a extends d implements IOnDeviceIR {
    private WeakReference<IOnDeviceIR> ll;
    private IOnDeviceIRStateChangedListener sB;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof IOnDeviceIR) {
            this.ll = new WeakReference<>((IOnDeviceIR) cVar);
            if (this.sB != null) {
                ((IOnDeviceIR) cVar).setStateChangedListener(this.sB);
            }
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.ll != null) {
            this.ll.clear();
            this.ll = null;
        }
        this.sB = null;
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void retry() {
        if (this.ll == null || this.ll.get() == null) {
            return;
        }
        this.ll.get().retry();
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void setStateChangedListener(IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener) {
        this.sB = iOnDeviceIRStateChangedListener;
        if (this.sB == null || this.ll == null || this.ll.get() == null) {
            return;
        }
        this.ll.get().setStateChangedListener(this.sB);
    }
}
