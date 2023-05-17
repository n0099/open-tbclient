package com.baidu.ar.anime;

import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.d.e;
import com.baidu.ar.d.j;
import com.baidu.ar.d.l;
/* loaded from: classes.dex */
public class a extends j {
    public static final String TAG = "a";
    public int cj = 720;
    public int ck = 1280;
    public boolean cl = true;
    public InterfaceC0047a cm = null;

    /* renamed from: com.baidu.ar.anime.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a {
        void b(FramePixels framePixels);
    }

    public a() {
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.RGBA);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(this.cj);
        this.nk.setOutputHeight(this.ck);
    }

    public void a(InterfaceC0047a interfaceC0047a) {
        this.cm = interfaceC0047a;
    }

    public void an() {
        this.nk.setOutputWidth(this.ck);
        this.nk.setOutputHeight(this.cj);
        this.nk.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
    }

    @Override // com.baidu.ar.d.j
    public void ao() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.d.j
    public boolean ap() {
        return this.cl;
    }

    @Override // com.baidu.ar.d.j
    public void aq() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.b(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.d.j
    public final boolean c(FramePixels framePixels) {
        if (this.cl) {
            this.cl = false;
            InterfaceC0047a interfaceC0047a = this.cm;
            if (interfaceC0047a != null) {
                interfaceC0047a.b(framePixels);
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
