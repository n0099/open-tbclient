package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private h jt;
    private boolean jx;
    private List<b> jy = new ArrayList();
    private Configuration jq = new Configuration();

    public g A(int i) {
        if (this.jx) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.jq.jh = i;
        return this;
    }

    public g b(View view) {
        if (this.jx) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.jq.jf = view;
        return this;
    }

    public g B(int i) {
        if (this.jx) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.jq.jj = i;
        return this;
    }

    public g q(boolean z) {
        if (this.jx) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.jq.jl = z;
        return this;
    }

    public g r(boolean z) {
        if (this.jx) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.jq.jm = z;
        return this;
    }

    public g a(b bVar) {
        if (this.jx) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.jy.add(bVar);
        return this;
    }

    public g s(boolean z) {
        this.jq.jg = z;
        return this;
    }

    public d dA() {
        d dVar = new d();
        dVar.a((b[]) this.jy.toArray(new b[this.jy.size()]));
        dVar.a(this.jq);
        dVar.a(this.jt);
        this.jy = null;
        this.jq = null;
        this.jt = null;
        this.jx = true;
        return dVar;
    }
}
