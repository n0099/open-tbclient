package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a kS;
    private boolean kV;
    private List<b> kW = new ArrayList();
    private Configuration kO = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void cW();

        void onDismiss();
    }

    public g Q(int i) {
        if (this.kV) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.kO.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.kV) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.kO.bL = view;
        return this;
    }

    public g R(int i) {
        if (this.kV) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.kO.kH = i;
        return this;
    }

    public g v(boolean z) {
        if (this.kV) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.kO.kJ = z;
        return this;
    }

    public g w(boolean z) {
        if (this.kV) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.kO.kK = z;
        return this;
    }

    public g a(b bVar) {
        if (this.kV) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.kW.add(bVar);
        return this;
    }

    public g x(boolean z) {
        this.kO.kF = z;
        return this;
    }

    public d cV() {
        d dVar = new d();
        dVar.a((b[]) this.kW.toArray(new b[this.kW.size()]));
        dVar.a(this.kO);
        dVar.a(this.kS);
        this.kW = null;
        this.kO = null;
        this.kS = null;
        this.kV = true;
        return dVar;
    }
}
