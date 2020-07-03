package com.baidu.ar.anime;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
import com.baidu.ar.c.l;
/* loaded from: classes3.dex */
public class a extends j {
    private static final String TAG = a.class.getSimpleName();
    private int co = 720;
    private int cp = 1280;
    private boolean cq = true;
    private InterfaceC0072a cr = null;

    /* renamed from: com.baidu.ar.anime.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0072a {
        void b(FramePixels framePixels);
    }

    public a() {
        this.mm = new PixelReadParams(PixelType.RGBA);
        this.mm.setOutputWidth(this.co);
        this.mm.setOutputHeight(this.cp);
    }

    public void a(InterfaceC0072a interfaceC0072a) {
        this.cr = interfaceC0072a;
    }

    @Override // com.baidu.ar.c.j
    protected void al() {
        if (this.ly != null) {
            this.ly.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.c.j
    public boolean am() {
        return this.cq;
    }

    @Override // com.baidu.ar.c.j
    protected void an() {
        if (this.ly != null) {
            this.ly.b(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.c.j
    protected final boolean c(FramePixels framePixels) {
        if (this.cq) {
            this.cq = false;
            if (this.cr != null) {
                this.cr.b(framePixels);
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
        this.mm.setPreFilterID(str);
    }
}
