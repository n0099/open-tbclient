package com.baidu.ar.track2d;

import android.graphics.Bitmap;
import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements ITrack2D {
    private WeakReference<ITrack2D> kO;
    private ITrack2DStateChangedListener wf;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ITrack2D) {
            this.kO = new WeakReference<>((ITrack2D) cVar);
            if (this.wf != null) {
                ((ITrack2D) cVar).setStateChangedListener(this.wf);
            }
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public Bitmap getTargetBitmap() {
        if (this.kO == null || this.kO.get() == null) {
            return null;
        }
        return this.kO.get().getTargetBitmap();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void haltTrack() {
        if (this.kO == null || this.kO.get() == null) {
            return;
        }
        this.kO.get().haltTrack();
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.kO != null) {
            this.kO.clear();
            this.kO = null;
        }
        this.wf = null;
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void resumeTrack() {
        if (this.kO == null || this.kO.get() == null) {
            return;
        }
        this.kO.get().resumeTrack();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener) {
        this.wf = iTrack2DStateChangedListener;
        if (this.wf == null || this.kO == null || this.kO.get() == null) {
            return;
        }
        this.kO.get().setStateChangedListener(this.wf);
    }
}
