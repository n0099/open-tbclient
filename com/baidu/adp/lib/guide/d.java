package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a uF;
    private boolean uI;
    private List<b> uJ = new ArrayList();
    private Configuration uB = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void fa();

        void onDismiss();
    }

    public d ad(int i) {
        if (this.uI) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.uB.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.uI) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.uB.jv = view;
        return this;
    }

    public d ae(int i) {
        if (this.uI) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.uB.uu = i;
        return this;
    }

    public d y(boolean z) {
        if (this.uI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uB.uw = z;
        return this;
    }

    public d z(boolean z) {
        if (this.uI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uB.ux = z;
        return this;
    }

    public d a(b bVar) {
        if (this.uI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uJ.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.uI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uF = aVar;
        return this;
    }

    public d A(boolean z) {
        this.uB.us = z;
        return this;
    }

    public c eZ() {
        c cVar = new c();
        cVar.a((b[]) this.uJ.toArray(new b[this.uJ.size()]));
        cVar.a(this.uB);
        cVar.a(this.uF);
        this.uJ = null;
        this.uB = null;
        this.uF = null;
        this.uI = true;
        return cVar;
    }
}
