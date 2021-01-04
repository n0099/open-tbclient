package com.baidu.ar.anime;

import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.d.j;
import com.baidu.ar.d.l;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes6.dex */
public class a extends j {
    private static final String TAG = a.class.getSimpleName();
    private int cj = 720;
    private int ck = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private boolean cl = true;
    private InterfaceC0065a cm = null;

    /* renamed from: com.baidu.ar.anime.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0065a {
        void b(FramePixels framePixels);
    }

    public a() {
        this.nk = new PixelReadParams(PixelType.RGBA);
        this.nk.setOutputWidth(this.cj);
        this.nk.setOutputHeight(this.ck);
    }

    public void a(InterfaceC0065a interfaceC0065a) {
        this.cm = interfaceC0065a;
    }

    public void an() {
        this.nk.setOutputWidth(this.ck);
        this.nk.setOutputHeight(this.cj);
        this.nk.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
    }

    @Override // com.baidu.ar.d.j
    protected void ao() {
        if (this.mv != null) {
            this.mv.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.d.j
    public boolean ap() {
        return this.cl;
    }

    @Override // com.baidu.ar.d.j
    protected void aq() {
        if (this.mv != null) {
            this.mv.b(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.d.j
    protected final boolean c(FramePixels framePixels) {
        if (this.cl) {
            this.cl = false;
            if (this.cm != null) {
                this.cm.b(framePixels);
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

    public void v(String str) {
        this.nk.setPreFilterID(str);
    }
}
