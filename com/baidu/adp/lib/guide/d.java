package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a aik;
    private boolean ain;
    private List<b> aio = new ArrayList();
    private Configuration aif = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void bL();

        void onDismiss();
    }

    public d cW(int i) {
        if (this.ain) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.aif.mAlpha = i;
        return this;
    }

    public d aG(View view) {
        if (this.ain) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.aif.yB = view;
        return this;
    }

    public d cX(int i) {
        if (this.ain) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.aif.ahY = i;
        return this;
    }

    public d aj(boolean z) {
        if (this.ain) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aif.aia = z;
        return this;
    }

    public d ak(boolean z) {
        if (this.ain) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aif.aib = z;
        return this;
    }

    public d a(b bVar) {
        if (this.ain) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aio.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.ain) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aik = aVar;
        return this;
    }

    public d al(boolean z) {
        this.aif.ahW = z;
        return this;
    }

    public c mD() {
        c cVar = new c();
        cVar.a((b[]) this.aio.toArray(new b[this.aio.size()]));
        cVar.a(this.aif);
        cVar.a(this.aik);
        this.aio = null;
        this.aif = null;
        this.aik = null;
        this.ain = true;
        return cVar;
    }
}
