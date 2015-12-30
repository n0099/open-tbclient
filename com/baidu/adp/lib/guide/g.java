package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a uh;
    private boolean uk;
    private List<b> ul = new ArrayList();
    private Configuration ud = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void gA();

        void onDismiss();
    }

    public g P(int i) {
        if (this.uk) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.ud.mAlpha = i;
        return this;
    }

    public g c(View view) {
        if (this.uk) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.ud.lJ = view;
        return this;
    }

    public g Q(int i) {
        if (this.uk) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.ud.tW = i;
        return this;
    }

    public g u(boolean z) {
        if (this.uk) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ud.tY = z;
        return this;
    }

    public g v(boolean z) {
        if (this.uk) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ud.tZ = z;
        return this;
    }

    public g a(b bVar) {
        if (this.uk) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ul.add(bVar);
        return this;
    }

    public g w(boolean z) {
        this.ud.tU = z;
        return this;
    }

    public d gz() {
        d dVar = new d();
        dVar.a((b[]) this.ul.toArray(new b[this.ul.size()]));
        dVar.a(this.ud);
        dVar.a(this.uh);
        this.ul = null;
        this.ud = null;
        this.uh = null;
        this.uk = true;
        return dVar;
    }
}
