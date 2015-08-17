package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a ub;
    private boolean ue;
    private List<b> uf = new ArrayList();
    private Configuration tX = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void gC();

        void onDismiss();
    }

    public g O(int i) {
        if (this.ue) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.tX.mAlpha = i;
        return this;
    }

    public g c(View view) {
        if (this.ue) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.tX.lJ = view;
        return this;
    }

    public g P(int i) {
        if (this.ue) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.tX.tQ = i;
        return this;
    }

    public g u(boolean z) {
        if (this.ue) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tX.tS = z;
        return this;
    }

    public g v(boolean z) {
        if (this.ue) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tX.tT = z;
        return this;
    }

    public g a(b bVar) {
        if (this.ue) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uf.add(bVar);
        return this;
    }

    public g w(boolean z) {
        this.tX.tO = z;
        return this;
    }

    public d gB() {
        d dVar = new d();
        dVar.a((b[]) this.uf.toArray(new b[this.uf.size()]));
        dVar.a(this.tX);
        dVar.a(this.ub);
        this.uf = null;
        this.tX = null;
        this.ub = null;
        this.ue = true;
        return dVar;
    }
}
