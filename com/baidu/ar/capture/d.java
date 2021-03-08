package com.baidu.ar.capture;

import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.d.j;
/* loaded from: classes3.dex */
class d extends j {
    private static final String TAG = d.class.getSimpleName();
    private volatile boolean ld = false;

    public d(String str, int i, int i2) {
        this.nk = new PixelReadParams(PixelType.RGBA);
        this.nk.setPreFilterID(str);
        this.nk.setOutputWidth(i);
        this.nk.setOutputHeight(i2);
        if (PixelReadParams.DEFAULT_FILTER_ID.equals(str)) {
            this.nk.setIsPortrait(true);
        }
    }

    @Override // com.baidu.ar.d.j
    protected void ao() {
    }

    @Override // com.baidu.ar.d.j
    protected void aq() {
        this.ld = false;
    }

    @Override // com.baidu.ar.d.j
    protected boolean c(FramePixels framePixels) {
        if (!this.ld || this.mv == null) {
            return true;
        }
        c cVar = new c();
        cVar.W(TAG);
        cVar.setTimestamp(framePixels.getTimestamp());
        cVar.setData(framePixels.getPixelData());
        this.mv.a(cVar);
        return true;
    }

    public String cL() {
        return this.nk.getPreFilterID();
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return TAG;
    }

    public void s(boolean z) {
        this.ld = z;
    }
}
