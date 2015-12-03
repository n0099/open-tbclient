package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a uf;
    private boolean ui;
    private List<b> uj = new ArrayList();
    private Configuration ub = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void gA();

        void onDismiss();
    }

    public g P(int i) {
        if (this.ui) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.ub.mAlpha = i;
        return this;
    }

    public g c(View view) {
        if (this.ui) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.ub.lJ = view;
        return this;
    }

    public g Q(int i) {
        if (this.ui) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.ub.tU = i;
        return this;
    }

    public g u(boolean z) {
        if (this.ui) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ub.tW = z;
        return this;
    }

    public g v(boolean z) {
        if (this.ui) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ub.tX = z;
        return this;
    }

    public g a(b bVar) {
        if (this.ui) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uj.add(bVar);
        return this;
    }

    public g w(boolean z) {
        this.ub.tS = z;
        return this;
    }

    public d gz() {
        d dVar = new d();
        dVar.a((b[]) this.uj.toArray(new b[this.uj.size()]));
        dVar.a(this.ub);
        dVar.a(this.uf);
        this.uj = null;
        this.ub = null;
        this.uf = null;
        this.ui = true;
        return dVar;
    }
}
