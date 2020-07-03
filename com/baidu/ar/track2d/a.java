package com.baidu.ar.track2d;

import android.graphics.Bitmap;
import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements ITrack2D {
    private WeakReference<ITrack2D> ll;
    private ITrack2DStateChangedListener wF;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof ITrack2D) {
            this.ll = new WeakReference<>((ITrack2D) cVar);
            if (this.wF != null) {
                ((ITrack2D) cVar).setStateChangedListener(this.wF);
            }
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public Bitmap getTargetBitmap() {
        if (this.ll == null || this.ll.get() == null) {
            return null;
        }
        return this.ll.get().getTargetBitmap();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void haltTrack() {
        if (this.ll == null || this.ll.get() == null) {
            return;
        }
        this.ll.get().haltTrack();
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.ll != null) {
            this.ll.clear();
            this.ll = null;
        }
        this.wF = null;
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void resumeTrack() {
        if (this.ll == null || this.ll.get() == null) {
            return;
        }
        this.ll.get().resumeTrack();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener) {
        this.wF = iTrack2DStateChangedListener;
        if (this.wF == null || this.ll == null || this.ll.get() == null) {
            return;
        }
        this.ll.get().setStateChangedListener(this.wF);
    }
}
