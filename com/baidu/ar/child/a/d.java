package com.baidu.ar.child.a;

import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.d.j;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes6.dex */
public class d extends j {
    private boolean ma = true;

    public d() {
        this.nk = new PixelReadParams(PixelType.RGBA);
        this.nk.setOutputWidth(720);
        this.nk.setOutputHeight(PlatformPlugin.DEFAULT_SYSTEM_UI);
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
        if (str.equals(PixelReadParams.DEFAULT_FILTER_ID)) {
            this.nk.setIsPortrait(true);
            if (!this.ma) {
                this.nk.setPixelRotate(PixelRotation.RotateRight);
            }
        }
        this.nk.setPreFilterID(str);
    }
}
