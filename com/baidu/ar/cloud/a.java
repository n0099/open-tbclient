package com.baidu.ar.cloud;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a extends d implements ICloudIR {
    private WeakReference<ICloudIR> mj;
    private ICloudIRStateChangedListener mk;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ICloudIR) {
            this.mj = new WeakReference<>((ICloudIR) cVar);
            if (this.mk != null) {
                ((ICloudIR) cVar).setStateChangedListener(this.mk);
            }
        }
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void pause() {
        if (this.mj == null || this.mj.get() == null) {
            return;
        }
        this.mj.get().pause();
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.mj != null) {
            this.mj.clear();
            this.mj = null;
        }
        this.mk = null;
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void resume() {
        if (this.mj == null || this.mj.get() == null) {
            return;
        }
        this.mj.get().resume();
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void setStateChangedListener(ICloudIRStateChangedListener iCloudIRStateChangedListener) {
        this.mk = iCloudIRStateChangedListener;
        if (this.mk == null || this.mj == null || this.mj.get() == null) {
            return;
        }
        this.mj.get().setStateChangedListener(this.mk);
    }
}
