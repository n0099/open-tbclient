package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<b> zA = new ArrayList();
    private Configuration zr = new Configuration();
    private a zw;
    private boolean zz;

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d X(int i) {
        if (this.zz) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.zr.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.zz) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.zr.mTargetView = view;
        return this;
    }

    public d Y(int i) {
        if (this.zz) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.zr.zk = i;
        return this;
    }

    public d T(boolean z) {
        if (this.zz) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zr.zm = z;
        return this;
    }

    public d U(boolean z) {
        if (this.zz) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zr.zn = z;
        return this;
    }

    public d a(b bVar) {
        if (this.zz) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zA.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.zz) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zw = aVar;
        return this;
    }

    public d V(boolean z) {
        this.zr.zi = z;
        return this;
    }

    public c hL() {
        c cVar = new c();
        cVar.a((b[]) this.zA.toArray(new b[this.zA.size()]));
        cVar.a(this.zr);
        cVar.a(this.zw);
        this.zA = null;
        this.zr = null;
        this.zw = null;
        this.zz = true;
        return cVar;
    }
}
