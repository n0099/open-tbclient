package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private boolean uC;
    private List<b> uD = new ArrayList();
    private Configuration uv = new Configuration();
    private a uz;

    /* loaded from: classes.dex */
    public interface a {
        void fc();

        void onDismiss();
    }

    public g ad(int i) {
        if (this.uC) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.uv.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.uC) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.uv.jv = view;
        return this;
    }

    public g ae(int i) {
        if (this.uC) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.uv.uo = i;
        return this;
    }

    public g y(boolean z) {
        if (this.uC) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uv.uq = z;
        return this;
    }

    public g z(boolean z) {
        if (this.uC) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uv.ur = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uC) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uD.add(bVar);
        return this;
    }

    public g A(boolean z) {
        this.uv.ul = z;
        return this;
    }

    public d fb() {
        d dVar = new d();
        dVar.a((b[]) this.uD.toArray(new b[this.uD.size()]));
        dVar.a(this.uv);
        dVar.a(this.uz);
        this.uD = null;
        this.uv = null;
        this.uz = null;
        this.uC = true;
        return dVar;
    }
}
