package com.baidu.ar.track2d;

import android.graphics.Bitmap;
import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a extends d implements ITrack2D {
    private WeakReference<ITrack2D> mj;
    private ITrack2DStateChangedListener xR;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ITrack2D) {
            this.mj = new WeakReference<>((ITrack2D) cVar);
            if (this.xR != null) {
                ((ITrack2D) cVar).setStateChangedListener(this.xR);
            }
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public Bitmap getTargetBitmap() {
        if (this.mj == null || this.mj.get() == null) {
            return null;
        }
        return this.mj.get().getTargetBitmap();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void haltTrack() {
        if (this.mj == null || this.mj.get() == null) {
            return;
        }
        this.mj.get().haltTrack();
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.mj != null) {
            this.mj.clear();
            this.mj = null;
        }
        this.xR = null;
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void resumeTrack() {
        if (this.mj == null || this.mj.get() == null) {
            return;
        }
        this.mj.get().resumeTrack();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener) {
        this.xR = iTrack2DStateChangedListener;
        if (this.xR == null || this.mj == null || this.mj.get() == null) {
            return;
        }
        this.mj.get().setStateChangedListener(this.xR);
    }
}
