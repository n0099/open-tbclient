package com.baidu.ar.child.a;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
/* loaded from: classes3.dex */
public class b extends j {
    public b() {
        this.lP = new PixelReadParams(PixelType.BGR);
        this.lP.setOutputWidth(1280);
        this.lP.setOutputHeight(720);
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
            a aVar = new a();
            aVar.setTimestamp(framePixels.getTimestamp());
            aVar.e(framePixels.getPixelData());
            aVar.setDegree(framePixels.getOrientation().getDegree());
            aVar.w(framePixels.isFrontCamera());
            this.lb.a(aVar);
            return false;
        }
        return false;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return "ChildCameraDetector";
    }
}
