package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a Be;
    private boolean Bh;
    private List<b> Bi = new ArrayList();
    private Configuration AZ = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d af(int i) {
        if (this.Bh) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.AZ.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.Bh) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.AZ.mTargetView = view;
        return this;
    }

    public d ag(int i) {
        if (this.Bh) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.AZ.AR = i;
        return this;
    }

    public d N(boolean z) {
        if (this.Bh) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.AZ.AU = z;
        return this;
    }

    public d O(boolean z) {
        if (this.Bh) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.AZ.AV = z;
        return this;
    }

    public d a(b bVar) {
        if (this.Bh) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.Bi.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.Bh) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.Be = aVar;
        return this;
    }

    public d P(boolean z) {
        this.AZ.AP = z;
        return this;
    }

    public c iE() {
        c cVar = new c();
        cVar.a((b[]) this.Bi.toArray(new b[this.Bi.size()]));
        cVar.a(this.AZ);
        cVar.a(this.Be);
        this.Bi = null;
        this.AZ = null;
        this.Be = null;
        this.Bh = true;
        return cVar;
    }
}
