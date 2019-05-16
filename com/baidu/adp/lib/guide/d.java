package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private boolean zA;
    private List<b> zB = new ArrayList();
    private Configuration zs = new Configuration();
    private a zx;

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d X(int i) {
        if (this.zA) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.zs.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.zA) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.zs.mTargetView = view;
        return this;
    }

    public d Y(int i) {
        if (this.zA) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.zs.zl = i;
        return this;
    }

    public d T(boolean z) {
        if (this.zA) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zs.zn = z;
        return this;
    }

    public d U(boolean z) {
        if (this.zA) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zs.zo = z;
        return this;
    }

    public d a(b bVar) {
        if (this.zA) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zB.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.zA) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zx = aVar;
        return this;
    }

    public d V(boolean z) {
        this.zs.zj = z;
        return this;
    }

    public c hL() {
        c cVar = new c();
        cVar.a((b[]) this.zB.toArray(new b[this.zB.size()]));
        cVar.a(this.zs);
        cVar.a(this.zx);
        this.zB = null;
        this.zs = null;
        this.zx = null;
        this.zA = true;
        return cVar;
    }
}
