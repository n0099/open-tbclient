package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a air;
    private boolean aiu;
    private List<b> aiv = new ArrayList();
    private Configuration ain = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void bL();

        void onDismiss();
    }

    public d cW(int i) {
        if (this.aiu) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.ain.mAlpha = i;
        return this;
    }

    public d aG(View view) {
        if (this.aiu) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.ain.yH = view;
        return this;
    }

    public d cX(int i) {
        if (this.aiu) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.ain.aig = i;
        return this;
    }

    public d ag(boolean z) {
        if (this.aiu) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ain.aii = z;
        return this;
    }

    public d ah(boolean z) {
        if (this.aiu) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ain.aij = z;
        return this;
    }

    public d a(b bVar) {
        if (this.aiu) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aiv.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.aiu) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.air = aVar;
        return this;
    }

    public d ai(boolean z) {
        this.ain.aie = z;
        return this;
    }

    public c mD() {
        c cVar = new c();
        cVar.a((b[]) this.aiv.toArray(new b[this.aiv.size()]));
        cVar.a(this.ain);
        cVar.a(this.air);
        this.aiv = null;
        this.ain = null;
        this.air = null;
        this.aiu = true;
        return cVar;
    }
}
