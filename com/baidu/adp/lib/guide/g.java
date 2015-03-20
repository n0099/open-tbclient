package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private h uR;
    private boolean uU;
    private List<b> uV = new ArrayList();
    private Configuration uN = new Configuration();

    public g O(int i) {
        if (this.uU) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.uN.mAlpha = i;
        return this;
    }

    public g b(View view) {
        if (this.uU) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.uN.lI = view;
        return this;
    }

    public g P(int i) {
        if (this.uU) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.uN.uG = i;
        return this;
    }

    public g u(boolean z) {
        if (this.uU) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uN.uI = z;
        return this;
    }

    public g v(boolean z) {
        if (this.uU) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uN.uJ = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uU) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uV.add(bVar);
        return this;
    }

    public g b(h hVar) {
        if (this.uU) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uR = hVar;
        return this;
    }

    public g w(boolean z) {
        this.uN.uE = z;
        return this;
    }

    public d gV() {
        d dVar = new d();
        dVar.a((b[]) this.uV.toArray(new b[this.uV.size()]));
        dVar.a(this.uN);
        dVar.a(this.uR);
        this.uV = null;
        this.uN = null;
        this.uR = null;
        this.uU = true;
        return dVar;
    }
}
