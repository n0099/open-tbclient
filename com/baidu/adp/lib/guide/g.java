package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a kp;
    private boolean ks;
    private List<b> kt = new ArrayList();
    private Configuration kl = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void cW();

        void onDismiss();
    }

    public g N(int i) {
        if (this.ks) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.kl.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.ks) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.kl.bL = view;
        return this;
    }

    public g O(int i) {
        if (this.ks) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.kl.ke = i;
        return this;
    }

    public g t(boolean z) {
        if (this.ks) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.kl.kg = z;
        return this;
    }

    public g u(boolean z) {
        if (this.ks) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.kl.kh = z;
        return this;
    }

    public g a(b bVar) {
        if (this.ks) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.kt.add(bVar);
        return this;
    }

    public g v(boolean z) {
        this.kl.kc = z;
        return this;
    }

    public d cV() {
        d dVar = new d();
        dVar.a((b[]) this.kt.toArray(new b[this.kt.size()]));
        dVar.a(this.kl);
        dVar.a(this.kp);
        this.kt = null;
        this.kl = null;
        this.kp = null;
        this.ks = true;
        return dVar;
    }
}
