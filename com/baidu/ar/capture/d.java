package com.baidu.ar.capture;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.d.j;
/* loaded from: classes14.dex */
class d extends j {
    private static final String TAG = d.class.getSimpleName();
    private volatile boolean kO = false;

    public d(String str, int i, int i2) {
        this.mU = new PixelReadParams(PixelType.RGBA);
        this.mU.setPreFilterID(str);
        this.mU.setOutputWidth(i);
        this.mU.setOutputHeight(i2);
        if (PixelReadParams.DEFAULT_FILTER_ID.equals(str)) {
            this.mU.setIsPortrait(true);
        }
    }

    @Override // com.baidu.ar.d.j
    protected void am() {
    }

    @Override // com.baidu.ar.d.j
    protected void ao() {
        this.kO = false;
    }

    @Override // com.baidu.ar.d.j
    protected boolean c(FramePixels framePixels) {
        if (!this.kO || this.mg == null) {
            return true;
        }
        c cVar = new c();
        cVar.T(TAG);
        cVar.setTimestamp(framePixels.getTimestamp());
        cVar.setData(framePixels.getPixelData());
        this.mg.a(cVar);
        return true;
    }

    public String cM() {
        return this.mU.getPreFilterID();
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return TAG;
    }

    public void u(boolean z) {
        this.kO = z;
    }
}
