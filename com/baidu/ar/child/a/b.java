package com.baidu.ar.child.a;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.d.j;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes10.dex */
public class b extends j {
    public b() {
        this.mU = new PixelReadParams(PixelType.BGR);
        this.mU.setOutputWidth(PlatformPlugin.DEFAULT_SYSTEM_UI);
        this.mU.setOutputHeight(720);
    }

    @Override // com.baidu.ar.d.j
    protected void am() {
    }

    @Override // com.baidu.ar.d.j
    protected void ao() {
    }

    @Override // com.baidu.ar.d.j
    protected boolean c(FramePixels framePixels) {
        if (this.mg != null) {
            a aVar = new a();
            aVar.setTimestamp(framePixels.getTimestamp());
            aVar.g(framePixels.getPixelData());
            aVar.setDegree(framePixels.getOrientation().getDegree());
            aVar.w(framePixels.isFrontCamera());
            this.mg.a(aVar);
            return false;
        }
        return false;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return "ChildCameraDetector";
    }
}
