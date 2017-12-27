package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a aio;
    private boolean air;
    private List<b> ais = new ArrayList();
    private Configuration aik = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void bL();

        void onDismiss();
    }

    public d cW(int i) {
        if (this.air) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.aik.mAlpha = i;
        return this;
    }

    public d aG(View view) {
        if (this.air) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.aik.yH = view;
        return this;
    }

    public d cX(int i) {
        if (this.air) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.aik.aid = i;
        return this;
    }

    public d af(boolean z) {
        if (this.air) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aik.aif = z;
        return this;
    }

    public d ag(boolean z) {
        if (this.air) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aik.aig = z;
        return this;
    }

    public d a(b bVar) {
        if (this.air) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ais.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.air) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aio = aVar;
        return this;
    }

    public d ah(boolean z) {
        this.aik.aib = z;
        return this;
    }

    public c mC() {
        c cVar = new c();
        cVar.a((b[]) this.ais.toArray(new b[this.ais.size()]));
        cVar.a(this.aik);
        cVar.a(this.aio);
        this.ais = null;
        this.aik = null;
        this.aio = null;
        this.air = true;
        return cVar;
    }
}
