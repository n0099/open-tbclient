package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a nn;
    private boolean nr;
    private List<b> ns = new ArrayList();
    private Configuration nj = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void dR();

        void onDismiss();
    }

    public g ad(int i) {
        if (this.nr) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.nj.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.nr) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.nj.bL = view;
        return this;
    }

    public g ae(int i) {
        if (this.nr) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.nj.nc = i;
        return this;
    }

    public g x(boolean z) {
        if (this.nr) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.nj.ne = z;
        return this;
    }

    public g y(boolean z) {
        if (this.nr) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.nj.nf = z;
        return this;
    }

    public g a(b bVar) {
        if (this.nr) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ns.add(bVar);
        return this;
    }

    public g z(boolean z) {
        this.nj.na = z;
        return this;
    }

    public d dQ() {
        d dVar = new d();
        dVar.a((b[]) this.ns.toArray(new b[this.ns.size()]));
        dVar.a(this.nj);
        dVar.a(this.nn);
        this.ns = null;
        this.nj = null;
        this.nn = null;
        this.nr = true;
        return dVar;
    }
}
