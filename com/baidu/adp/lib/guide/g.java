package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a uE;
    private boolean uH;
    private List<b> uI = new ArrayList();
    private Configuration uA = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void fd();

        void onDismiss();
    }

    public g ad(int i) {
        if (this.uH) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.uA.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.uH) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.uA.jv = view;
        return this;
    }

    public g ae(int i) {
        if (this.uH) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.uA.ut = i;
        return this;
    }

    public g y(boolean z) {
        if (this.uH) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uA.uv = z;
        return this;
    }

    public g z(boolean z) {
        if (this.uH) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uA.uw = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uH) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uI.add(bVar);
        return this;
    }

    public g A(boolean z) {
        this.uA.ur = z;
        return this;
    }

    public d fc() {
        d dVar = new d();
        dVar.a((b[]) this.uI.toArray(new b[this.uI.size()]));
        dVar.a(this.uA);
        dVar.a(this.uE);
        this.uI = null;
        this.uA = null;
        this.uE = null;
        this.uH = true;
        return dVar;
    }
}
