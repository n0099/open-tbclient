package com.baidu.ar.capture;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
/* loaded from: classes3.dex */
class d extends j {
    private static final String TAG = d.class.getSimpleName();
    private volatile boolean jN = false;

    public d(String str, int i, int i2) {
        this.lP = new PixelReadParams(PixelType.RGBA);
        this.lP.setPreFilterID(str);
        this.lP.setOutputWidth(i);
        this.lP.setOutputHeight(i2);
        if (PixelReadParams.DEFAULT_FILTER_ID.equals(str)) {
            this.lP.setIsPortrait(true);
        }
    }

    @Override // com.baidu.ar.c.j
    protected void X() {
    }

    @Override // com.baidu.ar.c.j
    protected void Z() {
        this.jN = false;
    }

    public String bW() {
        return this.lP.getPreFilterID();
    }

    @Override // com.baidu.ar.c.j
    protected boolean c(FramePixels framePixels) {
        if (!this.jN || this.lb == null) {
            return true;
        }
        c cVar = new c();
        cVar.S(TAG);
        cVar.setTimestamp(framePixels.getTimestamp());
        cVar.setData(framePixels.getPixelData());
        this.lb.a(cVar);
        return true;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }

    public void u(boolean z) {
        this.jN = z;
    }
}
