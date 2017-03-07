package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a uW;
    private boolean uZ;
    private List<b> va = new ArrayList();
    private Configuration uS = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void eX();

        void onDismiss();
    }

    public g ae(int i) {
        if (this.uZ) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.uS.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.uZ) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.uS.jv = view;
        return this;
    }

    public g af(int i) {
        if (this.uZ) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.uS.uL = i;
        return this;
    }

    public g y(boolean z) {
        if (this.uZ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uS.uN = z;
        return this;
    }

    public g z(boolean z) {
        if (this.uZ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uS.uO = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uZ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.va.add(bVar);
        return this;
    }

    public g A(boolean z) {
        this.uS.uJ = z;
        return this;
    }

    public d eW() {
        d dVar = new d();
        dVar.a((b[]) this.va.toArray(new b[this.va.size()]));
        dVar.a(this.uS);
        dVar.a(this.uW);
        this.va = null;
        this.uS = null;
        this.uW = null;
        this.uZ = true;
        return dVar;
    }
}
