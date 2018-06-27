package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a yN;
    private boolean yQ;
    private List<b> yR = new ArrayList();
    private Configuration yI = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d X(int i) {
        if (this.yQ) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.yI.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.yQ) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.yI.mTargetView = view;
        return this;
    }

    public d Y(int i) {
        if (this.yQ) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.yI.yB = i;
        return this;
    }

    public d E(boolean z) {
        if (this.yQ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yI.yD = z;
        return this;
    }

    public d F(boolean z) {
        if (this.yQ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yI.yE = z;
        return this;
    }

    public d a(b bVar) {
        if (this.yQ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yR.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.yQ) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yN = aVar;
        return this;
    }

    public d G(boolean z) {
        this.yI.yz = z;
        return this;
    }

    public c hy() {
        c cVar = new c();
        cVar.a((b[]) this.yR.toArray(new b[this.yR.size()]));
        cVar.a(this.yI);
        cVar.a(this.yN);
        this.yR = null;
        this.yI = null;
        this.yN = null;
        this.yQ = true;
        return cVar;
    }
}
