package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a ur;
    private boolean uu;
    private List<b> uv = new ArrayList();
    private Configuration um = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void gI();

        void onDismiss();
    }

    public g aa(int i) {
        if (this.uu) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.um.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.uu) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.um.lJ = view;
        return this;
    }

    public g ab(int i) {
        if (this.uu) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.um.uf = i;
        return this;
    }

    public g u(boolean z) {
        if (this.uu) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.um.uh = z;
        return this;
    }

    public g v(boolean z) {
        if (this.uu) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.um.ui = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uu) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uv.add(bVar);
        return this;
    }

    public g w(boolean z) {
        this.um.ud = z;
        return this;
    }

    public d gH() {
        d dVar = new d();
        dVar.a((b[]) this.uv.toArray(new b[this.uv.size()]));
        dVar.a(this.um);
        dVar.a(this.ur);
        this.uv = null;
        this.um = null;
        this.ur = null;
        this.uu = true;
        return dVar;
    }
}
