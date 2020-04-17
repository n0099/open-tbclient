package com.baidu.ar.cloud;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements ICloudIR {
    private WeakReference<ICloudIR> kO;
    private ICloudIRStateChangedListener kP;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ICloudIR) {
            this.kO = new WeakReference<>((ICloudIR) cVar);
            if (this.kP != null) {
                ((ICloudIR) cVar).setStateChangedListener(this.kP);
            }
        }
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void pause() {
        if (this.kO == null || this.kO.get() == null) {
            return;
        }
        this.kO.get().pause();
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.kO != null) {
            this.kO.clear();
            this.kO = null;
        }
        this.kP = null;
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void resume() {
        if (this.kO == null || this.kO.get() == null) {
            return;
        }
        this.kO.get().resume();
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void setStateChangedListener(ICloudIRStateChangedListener iCloudIRStateChangedListener) {
        this.kP = iCloudIRStateChangedListener;
        if (this.kP == null || this.kO == null || this.kO.get() == null) {
            return;
        }
        this.kO.get().setStateChangedListener(this.kP);
    }
}
