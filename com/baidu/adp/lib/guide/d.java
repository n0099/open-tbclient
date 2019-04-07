package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a BO;
    private boolean BR;
    private List<b> BS = new ArrayList();
    private Configuration BJ = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d ae(int i) {
        if (this.BR) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.BJ.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.BR) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.BJ.mTargetView = view;
        return this;
    }

    public d af(int i) {
        if (this.BR) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.BJ.BC = i;
        return this;
    }

    public d ab(boolean z) {
        if (this.BR) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BJ.BE = z;
        return this;
    }

    public d ac(boolean z) {
        if (this.BR) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BJ.BF = z;
        return this;
    }

    public d a(b bVar) {
        if (this.BR) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BS.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.BR) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BO = aVar;
        return this;
    }

    public d ad(boolean z) {
        this.BJ.BA = z;
        return this;
    }

    public c iT() {
        c cVar = new c();
        cVar.a((b[]) this.BS.toArray(new b[this.BS.size()]));
        cVar.a(this.BJ);
        cVar.a(this.BO);
        this.BS = null;
        this.BJ = null;
        this.BO = null;
        this.BR = true;
        return cVar;
    }
}
