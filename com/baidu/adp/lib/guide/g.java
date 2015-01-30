package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private h jA;
    private boolean jD;
    private List<b> jE = new ArrayList();
    private Configuration jw = new Configuration();

    public g N(int i) {
        if (this.jD) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.jw.mAlpha = i;
        return this;
    }

    public g b(View view) {
        if (this.jD) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.jw.aE = view;
        return this;
    }

    public g O(int i) {
        if (this.jD) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.jw.jp = i;
        return this;
    }

    public g u(boolean z) {
        if (this.jD) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.jw.jr = z;
        return this;
    }

    public g v(boolean z) {
        if (this.jD) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.jw.js = z;
        return this;
    }

    public g a(b bVar) {
        if (this.jD) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.jE.add(bVar);
        return this;
    }

    public g w(boolean z) {
        this.jw.jn = z;
        return this;
    }

    public d dx() {
        d dVar = new d();
        dVar.a((b[]) this.jE.toArray(new b[this.jE.size()]));
        dVar.a(this.jw);
        dVar.a(this.jA);
        this.jE = null;
        this.jw = null;
        this.jA = null;
        this.jD = true;
        return dVar;
    }
}
