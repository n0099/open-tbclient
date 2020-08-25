package com.baidu.ar.track2d;

import android.graphics.Bitmap;
import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class a extends d implements ITrack2D {
    private WeakReference<ITrack2D> lU;
    private ITrack2DStateChangedListener xd;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ITrack2D) {
            this.lU = new WeakReference<>((ITrack2D) cVar);
            if (this.xd != null) {
                ((ITrack2D) cVar).setStateChangedListener(this.xd);
            }
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public Bitmap getTargetBitmap() {
        if (this.lU == null || this.lU.get() == null) {
            return null;
        }
        return this.lU.get().getTargetBitmap();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void haltTrack() {
        if (this.lU == null || this.lU.get() == null) {
            return;
        }
        this.lU.get().haltTrack();
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.lU != null) {
            this.lU.clear();
            this.lU = null;
        }
        this.xd = null;
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void resumeTrack() {
        if (this.lU == null || this.lU.get() == null) {
            return;
        }
        this.lU.get().resumeTrack();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener) {
        this.xd = iTrack2DStateChangedListener;
        if (this.xd == null || this.lU == null || this.lU.get() == null) {
            return;
        }
        this.lU.get().setStateChangedListener(this.xd);
    }
}
