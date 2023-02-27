package com.baidu.ar.child.a;

import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.d.j;
/* loaded from: classes.dex */
public class b extends j {
    public b() {
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.BGR);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(1280);
        this.nk.setOutputHeight(720);
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
            a aVar = new a();
            aVar.setTimestamp(framePixels.getTimestamp());
            aVar.g(framePixels.getPixelData());
            aVar.setDegree(framePixels.getOrientation().getDegree());
            aVar.u(framePixels.isFrontCamera());
            this.mv.a(aVar);
            return false;
        }
        return false;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return "ChildCameraDetector";
    }
}
