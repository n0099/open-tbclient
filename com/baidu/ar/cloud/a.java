package com.baidu.ar.cloud;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements ICloudIR {
    private WeakReference<ICloudIR> ll;
    private ICloudIRStateChangedListener lm;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ICloudIR) {
            this.ll = new WeakReference<>((ICloudIR) cVar);
            if (this.lm != null) {
                ((ICloudIR) cVar).setStateChangedListener(this.lm);
            }
        }
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void pause() {
        if (this.ll == null || this.ll.get() == null) {
            return;
        }
        this.ll.get().pause();
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.ll != null) {
            this.ll.clear();
            this.ll = null;
        }
        this.lm = null;
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void resume() {
        if (this.ll == null || this.ll.get() == null) {
            return;
        }
        this.ll.get().resume();
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void setStateChangedListener(ICloudIRStateChangedListener iCloudIRStateChangedListener) {
        this.lm = iCloudIRStateChangedListener;
        if (this.lm == null || this.ll == null || this.ll.get() == null) {
            return;
        }
        this.ll.get().setStateChangedListener(this.lm);
    }
}
