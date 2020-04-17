package com.baidu.ar.anime;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
import com.baidu.ar.c.l;
/* loaded from: classes3.dex */
public class a extends j {
    private static final String TAG = a.class.getSimpleName();
    private int cb = 720;
    private int cc = 1280;
    private boolean cd = true;
    private InterfaceC0048a ce = null;

    /* renamed from: com.baidu.ar.anime.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0048a {
        void b(FramePixels framePixels);
    }

    public a() {
        this.lP = new PixelReadParams(PixelType.RGBA);
        this.lP.setOutputWidth(this.cb);
        this.lP.setOutputHeight(this.cc);
    }

    @Override // com.baidu.ar.c.j
    protected void X() {
        if (this.lb != null) {
            this.lb.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.c.j
    public boolean Y() {
        return this.cd;
    }

    @Override // com.baidu.ar.c.j
    protected void Z() {
        if (this.lb != null) {
            this.lb.b(new l(getName(), true));
        }
    }

    public void a(InterfaceC0048a interfaceC0048a) {
        this.ce = interfaceC0048a;
    }

    @Override // com.baidu.ar.c.j
    protected final boolean c(FramePixels framePixels) {
        if (this.cd) {
            this.cd = false;
            if (this.ce != null) {
                this.ce.b(framePixels);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }

    public void s(String str) {
        this.lP.setPreFilterID(str);
    }
}
