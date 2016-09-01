package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a nm;
    private boolean nq;
    private List<b> nr = new ArrayList();
    private Configuration ni = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void dR();

        void onDismiss();
    }

    public g ad(int i) {
        if (this.nq) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.ni.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.nq) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.ni.bL = view;
        return this;
    }

    public g ae(int i) {
        if (this.nq) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.ni.nb = i;
        return this;
    }

    public g x(boolean z) {
        if (this.nq) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ni.nd = z;
        return this;
    }

    public g y(boolean z) {
        if (this.nq) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ni.ne = z;
        return this;
    }

    public g a(b bVar) {
        if (this.nq) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.nr.add(bVar);
        return this;
    }

    public g z(boolean z) {
        this.ni.mZ = z;
        return this;
    }

    public d dQ() {
        d dVar = new d();
        dVar.a((b[]) this.nr.toArray(new b[this.nr.size()]));
        dVar.a(this.ni);
        dVar.a(this.nm);
        this.nr = null;
        this.ni = null;
        this.nm = null;
        this.nq = true;
        return dVar;
    }
}
