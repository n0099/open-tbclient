package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a tZ;
    private boolean uc;
    private List<b> ud = new ArrayList();
    private Configuration tV = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void gz();

        void onDismiss();
    }

    public g O(int i) {
        if (this.uc) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.tV.mAlpha = i;
        return this;
    }

    public g c(View view) {
        if (this.uc) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.tV.lJ = view;
        return this;
    }

    public g P(int i) {
        if (this.uc) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.tV.tO = i;
        return this;
    }

    public g u(boolean z) {
        if (this.uc) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tV.tQ = z;
        return this;
    }

    public g v(boolean z) {
        if (this.uc) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tV.tR = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uc) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ud.add(bVar);
        return this;
    }

    public g w(boolean z) {
        this.tV.tM = z;
        return this;
    }

    public d gy() {
        d dVar = new d();
        dVar.a((b[]) this.ud.toArray(new b[this.ud.size()]));
        dVar.a(this.tV);
        dVar.a(this.tZ);
        this.ud = null;
        this.tV = null;
        this.tZ = null;
        this.uc = true;
        return dVar;
    }
}
