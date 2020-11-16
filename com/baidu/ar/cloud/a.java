package com.baidu.ar.cloud;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes12.dex */
public class a extends d implements ICloudIR {
    private WeakReference<ICloudIR> lU;
    private ICloudIRStateChangedListener lV;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ICloudIR) {
            this.lU = new WeakReference<>((ICloudIR) cVar);
            if (this.lV != null) {
                ((ICloudIR) cVar).setStateChangedListener(this.lV);
            }
        }
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void pause() {
        if (this.lU == null || this.lU.get() == null) {
            return;
        }
        this.lU.get().pause();
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.lU != null) {
            this.lU.clear();
            this.lU = null;
        }
        this.lV = null;
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void resume() {
        if (this.lU == null || this.lU.get() == null) {
            return;
        }
        this.lU.get().resume();
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void setStateChangedListener(ICloudIRStateChangedListener iCloudIRStateChangedListener) {
        this.lV = iCloudIRStateChangedListener;
        if (this.lV == null || this.lU == null || this.lU.get() == null) {
            return;
        }
        this.lU.get().setStateChangedListener(this.lV);
    }
}
