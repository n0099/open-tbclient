package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a yI;
    private boolean yL;
    private List<b> yM = new ArrayList();
    private Configuration yD = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d X(int i) {
        if (this.yL) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.yD.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.yL) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.yD.mTargetView = view;
        return this;
    }

    public d Y(int i) {
        if (this.yL) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.yD.yw = i;
        return this;
    }

    public d D(boolean z) {
        if (this.yL) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yD.yy = z;
        return this;
    }

    public d E(boolean z) {
        if (this.yL) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yD.yz = z;
        return this;
    }

    public d a(b bVar) {
        if (this.yL) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yM.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.yL) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yI = aVar;
        return this;
    }

    public d F(boolean z) {
        this.yD.yu = z;
        return this;
    }

    public c hy() {
        c cVar = new c();
        cVar.a((b[]) this.yM.toArray(new b[this.yM.size()]));
        cVar.a(this.yD);
        cVar.a(this.yI);
        this.yM = null;
        this.yD = null;
        this.yI = null;
        this.yL = true;
        return cVar;
    }
}
