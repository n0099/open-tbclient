package com.baidu.ar.child.a;

import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.d.j;
/* loaded from: classes.dex */
public class d extends j {
    public boolean ma = true;

    public d() {
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.RGBA);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(720);
        this.nk.setOutputHeight(1280);
    }

    @Override // com.baidu.ar.d.j
    public void ao() {
    }

    @Override // com.baidu.ar.d.j
    public void aq() {
    }

    @Override // com.baidu.ar.d.j
    public boolean c(FramePixels framePixels) {
        if (this.mv != null) {
            c cVar = new c();
            cVar.setTimestamp(framePixels.getTimestamp());
            cVar.g(framePixels.getPixelData());
            this.ma = framePixels.isFrontCamera();
            this.mv.a(cVar);
            return false;
        }
        return false;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return "ChildFilterDetector";
    }

    public void v(String str) {
        if (str.equals("camera")) {
            this.nk.setIsPortrait(true);
            if (!this.ma) {
                this.nk.setPixelRotate(PixelRotation.RotateRight);
            }
        }
        this.nk.setPreFilterID(str);
    }
}
