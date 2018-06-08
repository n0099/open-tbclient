package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a yP;
    private boolean yS;
    private List<b> yT = new ArrayList();
    private Configuration yK = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d X(int i) {
        if (this.yS) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.yK.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.yS) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.yK.mTargetView = view;
        return this;
    }

    public d Y(int i) {
        if (this.yS) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.yK.yD = i;
        return this;
    }

    public d E(boolean z) {
        if (this.yS) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yK.yF = z;
        return this;
    }

    public d F(boolean z) {
        if (this.yS) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yK.yG = z;
        return this;
    }

    public d a(b bVar) {
        if (this.yS) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yT.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.yS) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.yP = aVar;
        return this;
    }

    public d G(boolean z) {
        this.yK.yB = z;
        return this;
    }

    public c hy() {
        c cVar = new c();
        cVar.a((b[]) this.yT.toArray(new b[this.yT.size()]));
        cVar.a(this.yK);
        cVar.a(this.yP);
        this.yT = null;
        this.yK = null;
        this.yP = null;
        this.yS = true;
        return cVar;
    }
}
