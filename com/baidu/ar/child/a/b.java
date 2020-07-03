package com.baidu.ar.child.a;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
/* loaded from: classes3.dex */
public class b extends j {
    public b() {
        this.mm = new PixelReadParams(PixelType.BGR);
        this.mm.setOutputWidth(1280);
        this.mm.setOutputHeight(720);
    }

    @Override // com.baidu.ar.c.j
    protected void al() {
    }

    @Override // com.baidu.ar.c.j
    protected void an() {
    }

    @Override // com.baidu.ar.c.j
    protected boolean c(FramePixels framePixels) {
        if (this.ly != null) {
            a aVar = new a();
            aVar.setTimestamp(framePixels.getTimestamp());
            aVar.g(framePixels.getPixelData());
            aVar.setDegree(framePixels.getOrientation().getDegree());
            aVar.v(framePixels.isFrontCamera());
            this.ly.a(aVar);
            return false;
        }
        return false;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return "ChildCameraDetector";
    }
}
