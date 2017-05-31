package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a uF;
    private boolean uI;
    private List<b> uJ = new ArrayList();
    private Configuration uB = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void fd();

        void onDismiss();
    }

    public g ad(int i) {
        if (this.uI) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.uB.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.uI) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.uB.jv = view;
        return this;
    }

    public g ae(int i) {
        if (this.uI) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.uB.uu = i;
        return this;
    }

    public g y(boolean z) {
        if (this.uI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uB.uw = z;
        return this;
    }

    public g z(boolean z) {
        if (this.uI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uB.ux = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uJ.add(bVar);
        return this;
    }

    public g b(a aVar) {
        if (this.uI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uF = aVar;
        return this;
    }

    public g A(boolean z) {
        this.uB.us = z;
        return this;
    }

    public d fc() {
        d dVar = new d();
        dVar.a((b[]) this.uJ.toArray(new b[this.uJ.size()]));
        dVar.a(this.uB);
        dVar.a(this.uF);
        this.uJ = null;
        this.uB = null;
        this.uF = null;
        this.uI = true;
        return dVar;
    }
}
