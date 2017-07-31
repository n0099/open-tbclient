package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a wh;
    private boolean wk;
    private List<b> wl = new ArrayList();
    private Configuration wd = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void fl();

        void onDismiss();
    }

    public d ag(int i) {
        if (this.wk) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.wd.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.wk) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.wd.jv = view;
        return this;
    }

    public d ah(int i) {
        if (this.wk) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.wd.vW = i;
        return this;
    }

    public d y(boolean z) {
        if (this.wk) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.wd.vY = z;
        return this;
    }

    public d z(boolean z) {
        if (this.wk) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.wd.vZ = z;
        return this;
    }

    public d a(b bVar) {
        if (this.wk) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.wl.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.wk) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.wh = aVar;
        return this;
    }

    public d A(boolean z) {
        this.wd.vU = z;
        return this;
    }

    public c fk() {
        c cVar = new c();
        cVar.a((b[]) this.wl.toArray(new b[this.wl.size()]));
        cVar.a(this.wd);
        cVar.a(this.wh);
        this.wl = null;
        this.wd = null;
        this.wh = null;
        this.wk = true;
        return cVar;
    }
}
