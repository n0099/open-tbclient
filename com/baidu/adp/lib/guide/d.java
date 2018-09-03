package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a yJ;
    private boolean yM;
    private List<b> yN = new ArrayList();
    private Configuration yE = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d X(int i) {
        if (this.yM) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.yE.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.yM) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.yE.mTargetView = view;
        return this;
    }

    public d Y(int i) {
        if (this.yM) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.yE.yx = i;
        return this;
    }

    public d D(boolean z) {
        if (this.yM) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yE.yz = z;
        return this;
    }

    public d E(boolean z) {
        if (this.yM) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yE.yA = z;
        return this;
    }

    public d a(b bVar) {
        if (this.yM) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yN.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.yM) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yJ = aVar;
        return this;
    }

    public d F(boolean z) {
        this.yE.yv = z;
        return this;
    }

    public c hy() {
        c cVar = new c();
        cVar.a((b[]) this.yN.toArray(new b[this.yN.size()]));
        cVar.a(this.yE);
        cVar.a(this.yJ);
        this.yN = null;
        this.yE = null;
        this.yJ = null;
        this.yM = true;
        return cVar;
    }
}
