package com.baidu.ar.anime;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.d.j;
import com.baidu.ar.d.l;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes14.dex */
public class a extends j {
    private static final String TAG = a.class.getSimpleName();
    private int cf = 720;
    private int cg = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private boolean ch = true;
    private InterfaceC0071a ci = null;

    /* renamed from: com.baidu.ar.anime.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0071a {
        void b(FramePixels framePixels);
    }

    public a() {
        this.mU = new PixelReadParams(PixelType.RGBA);
        this.mU.setOutputWidth(this.cf);
        this.mU.setOutputHeight(this.cg);
    }

    public void a(InterfaceC0071a interfaceC0071a) {
        this.ci = interfaceC0071a;
    }

    public void al() {
        this.mU.setOutputWidth(this.cg);
        this.mU.setOutputHeight(this.cf);
        this.mU.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
    }

    @Override // com.baidu.ar.d.j
    protected void am() {
        if (this.mg != null) {
            this.mg.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.d.j
    public boolean an() {
        return this.ch;
    }

    @Override // com.baidu.ar.d.j
    protected void ao() {
        if (this.mg != null) {
            this.mg.b(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.d.j
    protected final boolean c(FramePixels framePixels) {
        if (this.ch) {
            this.ch = false;
            if (this.ci != null) {
                this.ci.b(framePixels);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return TAG;
    }

    public void t(String str) {
        this.mU.setPreFilterID(str);
    }
}
