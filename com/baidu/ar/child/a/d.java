package com.baidu.ar.child.a;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes11.dex */
public class d extends j {
    private boolean lc = true;

    public d() {
        this.mm = new PixelReadParams(PixelType.RGBA);
        this.mm.setOutputWidth(720);
        this.mm.setOutputHeight(PlatformPlugin.DEFAULT_SYSTEM_UI);
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
            c cVar = new c();
            cVar.setTimestamp(framePixels.getTimestamp());
            cVar.g(framePixels.getPixelData());
            this.lc = framePixels.isFrontCamera();
            this.ly.a(cVar);
            return false;
        }
        return false;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return "ChildFilterDetector";
    }

    public void s(String str) {
        if (str.equals(PixelReadParams.DEFAULT_FILTER_ID)) {
            this.mm.setIsPortrait(true);
            if (!this.lc) {
                this.mm.setPixelRotate(PixelRotation.RotateRight);
            }
        }
        this.mm.setPreFilterID(str);
    }
}
