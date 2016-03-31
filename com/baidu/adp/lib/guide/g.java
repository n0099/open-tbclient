package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a uA;
    private boolean uD;
    private List<b> uE = new ArrayList();
    private Configuration uw = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void gI();

        void onDismiss();
    }

    public g Z(int i) {
        if (this.uD) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.uw.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.uD) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.uw.lK = view;
        return this;
    }

    public g aa(int i) {
        if (this.uD) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.uw.up = i;
        return this;
    }

    public g t(boolean z) {
        if (this.uD) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uw.ur = z;
        return this;
    }

    public g u(boolean z) {
        if (this.uD) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uw.us = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uD) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uE.add(bVar);
        return this;
    }

    public g v(boolean z) {
        this.uw.um = z;
        return this;
    }

    public d gH() {
        d dVar = new d();
        dVar.a((b[]) this.uE.toArray(new b[this.uE.size()]));
        dVar.a(this.uw);
        dVar.a(this.uA);
        this.uE = null;
        this.uw = null;
        this.uA = null;
        this.uD = true;
        return dVar;
    }
}
