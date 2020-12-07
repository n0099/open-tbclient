package com.baidu.ar.child.a;

import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.d.j;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes10.dex */
public class b extends j {
    public b() {
        this.nk = new PixelReadParams(PixelType.BGR);
        this.nk.setOutputWidth(PlatformPlugin.DEFAULT_SYSTEM_UI);
        this.nk.setOutputHeight(720);
    }

    @Override // com.baidu.ar.d.j
    protected void ao() {
    }

    @Override // com.baidu.ar.d.j
    protected void aq() {
    }

    @Override // com.baidu.ar.d.j
    protected boolean c(FramePixels framePixels) {
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
