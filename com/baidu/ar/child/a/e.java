package com.baidu.ar.child.a;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
/* loaded from: classes3.dex */
public class e extends j {
    public e() {
        this.lP = new PixelReadParams(PixelType.RGBA);
        this.lP.setOutputWidth(720);
        this.lP.setOutputHeight(1280);
    }

    @Override // com.baidu.ar.c.j
    protected void X() {
    }

    @Override // com.baidu.ar.c.j
    protected void Z() {
    }

    @Override // com.baidu.ar.c.j
    protected boolean c(FramePixels framePixels) {
        if (this.lb != null) {
            d dVar = new d();
            dVar.setTimestamp(framePixels.getTimestamp());
            dVar.e(framePixels.getPixelData());
            this.lb.a(dVar);
            return false;
        }
        return false;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return "ChildFilterDetector";
    }

    public void s(String str) {
        this.lP.setPreFilterID(str);
    }
}
