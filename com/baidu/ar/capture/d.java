package com.baidu.ar.capture;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
/* loaded from: classes11.dex */
class d extends j {
    private static final String TAG = d.class.getSimpleName();
    private volatile boolean kf = false;

    public d(String str, int i, int i2) {
        this.mm = new PixelReadParams(PixelType.RGBA);
        this.mm.setPreFilterID(str);
        this.mm.setOutputWidth(i);
        this.mm.setOutputHeight(i2);
        if (PixelReadParams.DEFAULT_FILTER_ID.equals(str)) {
            this.mm.setIsPortrait(true);
        }
    }

    @Override // com.baidu.ar.c.j
    protected void al() {
    }

    @Override // com.baidu.ar.c.j
    protected void an() {
        this.kf = false;
    }

    @Override // com.baidu.ar.c.j
    protected boolean c(FramePixels framePixels) {
        if (!this.kf || this.ly == null) {
            return true;
        }
        c cVar = new c();
        cVar.S(TAG);
        cVar.setTimestamp(framePixels.getTimestamp());
        cVar.setData(framePixels.getPixelData());
        this.ly.a(cVar);
        return true;
    }

    public String cm() {
        return this.mm.getPreFilterID();
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }

    public void t(boolean z) {
        this.kf = z;
    }
}
