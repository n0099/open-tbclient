package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private boolean jB;
    private List<b> jC = new ArrayList();
    private Configuration ju = new Configuration();
    private h jy;

    public g I(int i) {
        if (this.jB) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.ju.mAlpha = i;
        return this;
    }

    public g b(View view) {
        if (this.jB) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.ju.aD = view;
        return this;
    }

    public g J(int i) {
        if (this.jB) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.ju.jn = i;
        return this;
    }

    public g u(boolean z) {
        if (this.jB) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ju.jp = z;
        return this;
    }

    public g v(boolean z) {
        if (this.jB) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ju.jq = z;
        return this;
    }

    public g a(b bVar) {
        if (this.jB) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.jC.add(bVar);
        return this;
    }

    public g w(boolean z) {
        this.ju.jl = z;
        return this;
    }

    public d dz() {
        d dVar = new d();
        dVar.a((b[]) this.jC.toArray(new b[this.jC.size()]));
        dVar.a(this.ju);
        dVar.a(this.jy);
        this.jC = null;
        this.ju = null;
        this.jy = null;
        this.jB = true;
        return dVar;
    }
}
