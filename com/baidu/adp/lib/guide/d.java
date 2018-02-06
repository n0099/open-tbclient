package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a aiq;
    private boolean ait;
    private List<b> aiu = new ArrayList();
    private Configuration ail = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void bL();

        void onDismiss();
    }

    public d cW(int i) {
        if (this.ait) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.ail.mAlpha = i;
        return this;
    }

    public d aG(View view) {
        if (this.ait) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.ail.yG = view;
        return this;
    }

    public d cX(int i) {
        if (this.ait) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.ail.aie = i;
        return this;
    }

    public d aj(boolean z) {
        if (this.ait) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ail.aig = z;
        return this;
    }

    public d ak(boolean z) {
        if (this.ait) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ail.aih = z;
        return this;
    }

    public d a(b bVar) {
        if (this.ait) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aiu.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.ait) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.aiq = aVar;
        return this;
    }

    public d al(boolean z) {
        this.ail.aic = z;
        return this;
    }

    public c mD() {
        c cVar = new c();
        cVar.a((b[]) this.aiu.toArray(new b[this.aiu.size()]));
        cVar.a(this.ail);
        cVar.a(this.aiq);
        this.aiu = null;
        this.ail = null;
        this.aiq = null;
        this.ait = true;
        return cVar;
    }
}
