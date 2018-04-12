package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a sG;
    private boolean sJ;
    private List<b> sK = new ArrayList();
    private Configuration sB = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d W(int i) {
        if (this.sJ) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.sB.mAlpha = i;
        return this;
    }

    public d o(View view2) {
        if (this.sJ) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view2 == null) {
            throw new BuildException("Illegal view.");
        }
        this.sB.mTargetView = view2;
        return this;
    }

    public d X(int i) {
        if (this.sJ) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.sB.su = i;
        return this;
    }

    public d C(boolean z) {
        if (this.sJ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.sB.sw = z;
        return this;
    }

    public d D(boolean z) {
        if (this.sJ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.sB.sx = z;
        return this;
    }

    public d a(b bVar) {
        if (this.sJ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.sK.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.sJ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.sG = aVar;
        return this;
    }

    public d E(boolean z) {
        this.sB.sr = z;
        return this;
    }

    public c eH() {
        c cVar = new c();
        cVar.a((b[]) this.sK.toArray(new b[this.sK.size()]));
        cVar.a(this.sB);
        cVar.a(this.sG);
        this.sK = null;
        this.sB = null;
        this.sG = null;
        this.sJ = true;
        return cVar;
    }
}
