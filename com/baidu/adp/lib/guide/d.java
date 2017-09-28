package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a ub;
    private boolean ue;
    private List<b> uf = new ArrayList();
    private Configuration tW = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void eZ();

        void onDismiss();
    }

    public d ad(int i) {
        if (this.ue) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.tW.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.ue) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.tW.ju = view;
        return this;
    }

    public d ae(int i) {
        if (this.ue) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.tW.tP = i;
        return this;
    }

    public d z(boolean z) {
        if (this.ue) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tW.tR = z;
        return this;
    }

    public d A(boolean z) {
        if (this.ue) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tW.tS = z;
        return this;
    }

    public d a(b bVar) {
        if (this.ue) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uf.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.ue) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ub = aVar;
        return this;
    }

    public d B(boolean z) {
        this.tW.tN = z;
        return this;
    }

    public c eY() {
        c cVar = new c();
        cVar.a((b[]) this.uf.toArray(new b[this.uf.size()]));
        cVar.a(this.tW);
        cVar.a(this.ub);
        this.uf = null;
        this.tW = null;
        this.ub = null;
        this.ue = true;
        return cVar;
    }
}
