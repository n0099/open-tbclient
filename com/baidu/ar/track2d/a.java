package com.baidu.ar.track2d;

import android.graphics.Bitmap;
import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a extends d implements ITrack2D {
    public WeakReference<ITrack2D> mj;
    public ITrack2DStateChangedListener xR;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ITrack2D) {
            ITrack2D iTrack2D = (ITrack2D) cVar;
            this.mj = new WeakReference<>(iTrack2D);
            ITrack2DStateChangedListener iTrack2DStateChangedListener = this.xR;
            if (iTrack2DStateChangedListener != null) {
                iTrack2D.setStateChangedListener(iTrack2DStateChangedListener);
            }
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public Bitmap getTargetBitmap() {
        WeakReference<ITrack2D> weakReference = this.mj;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.mj.get().getTargetBitmap();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void haltTrack() {
        WeakReference<ITrack2D> weakReference = this.mj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().haltTrack();
    }

    @Override // com.baidu.ar.d
    public void release() {
        WeakReference<ITrack2D> weakReference = this.mj;
        if (weakReference != null) {
            weakReference.clear();
            this.mj = null;
        }
        this.xR = null;
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void resumeTrack() {
        WeakReference<ITrack2D> weakReference = this.mj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().resumeTrack();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener) {
        WeakReference<ITrack2D> weakReference;
        this.xR = iTrack2DStateChangedListener;
        if (iTrack2DStateChangedListener == null || (weakReference = this.mj) == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().setStateChangedListener(this.xR);
    }
}
