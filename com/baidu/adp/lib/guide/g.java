package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a ng;
    private boolean nj;
    private List<b> nk = new ArrayList();
    private Configuration nc = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void dP();

        void onDismiss();
    }

    public g ae(int i) {
        if (this.nj) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.nc.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.nj) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.nc.bK = view;
        return this;
    }

    public g af(int i) {
        if (this.nj) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.nc.mT = i;
        return this;
    }

    public g x(boolean z) {
        if (this.nj) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.nc.mV = z;
        return this;
    }

    public g y(boolean z) {
        if (this.nj) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.nc.mW = z;
        return this;
    }

    public g a(b bVar) {
        if (this.nj) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.nk.add(bVar);
        return this;
    }

    public g z(boolean z) {
        this.nc.mQ = z;
        return this;
    }

    public d dO() {
        d dVar = new d();
        dVar.a((b[]) this.nk.toArray(new b[this.nk.size()]));
        dVar.a(this.nc);
        dVar.a(this.ng);
        this.nk = null;
        this.nc = null;
        this.ng = null;
        this.nj = true;
        return dVar;
    }
}
