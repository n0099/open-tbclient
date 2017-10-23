package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a uc;
    private boolean uf;
    private List<b> ug = new ArrayList();
    private Configuration tX = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void eZ();

        void onDismiss();
    }

    public d ad(int i) {
        if (this.uf) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.tX.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.uf) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.tX.ju = view;
        return this;
    }

    public d ae(int i) {
        if (this.uf) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.tX.tQ = i;
        return this;
    }

    public d z(boolean z) {
        if (this.uf) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tX.tS = z;
        return this;
    }

    public d A(boolean z) {
        if (this.uf) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tX.tT = z;
        return this;
    }

    public d a(b bVar) {
        if (this.uf) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ug.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.uf) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.uc = aVar;
        return this;
    }

    public d B(boolean z) {
        this.tX.tO = z;
        return this;
    }

    public c eY() {
        c cVar = new c();
        cVar.a((b[]) this.ug.toArray(new b[this.ug.size()]));
        cVar.a(this.tX);
        cVar.a(this.uc);
        this.ug = null;
        this.tX = null;
        this.uc = null;
        this.uf = true;
        return cVar;
    }
}
