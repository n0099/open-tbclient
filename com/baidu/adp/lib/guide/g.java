package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private h uc;
    private boolean uf;
    private List<b> ug = new ArrayList();
    private Configuration tY = new Configuration();

    public g M(int i) {
        if (this.uf) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.tY.mAlpha = i;
        return this;
    }

    public g b(View view) {
        if (this.uf) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.tY.lI = view;
        return this;
    }

    public g N(int i) {
        if (this.uf) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.tY.tR = i;
        return this;
    }

    public g u(boolean z) {
        if (this.uf) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tY.tT = z;
        return this;
    }

    public g v(boolean z) {
        if (this.uf) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tY.tU = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uf) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ug.add(bVar);
        return this;
    }

    public g w(boolean z) {
        this.tY.tP = z;
        return this;
    }

    public d gG() {
        d dVar = new d();
        dVar.a((b[]) this.ug.toArray(new b[this.ug.size()]));
        dVar.a(this.tY);
        dVar.a(this.uc);
        this.ug = null;
        this.tY = null;
        this.uc = null;
        this.uf = true;
        return dVar;
    }
}
