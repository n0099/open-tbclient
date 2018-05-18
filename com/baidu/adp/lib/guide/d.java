package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a sF;
    private boolean sI;
    private List<b> sJ = new ArrayList();
    private Configuration sA = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d W(int i) {
        if (this.sI) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.sA.mAlpha = i;
        return this;
    }

    public d o(View view2) {
        if (this.sI) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view2 == null) {
            throw new BuildException("Illegal view.");
        }
        this.sA.mTargetView = view2;
        return this;
    }

    public d X(int i) {
        if (this.sI) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.sA.ss = i;
        return this;
    }

    public d C(boolean z) {
        if (this.sI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.sA.sv = z;
        return this;
    }

    public d D(boolean z) {
        if (this.sI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.sA.sw = z;
        return this;
    }

    public d a(b bVar) {
        if (this.sI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.sJ.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.sI) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.sF = aVar;
        return this;
    }

    public d E(boolean z) {
        this.sA.sq = z;
        return this;
    }

    public c eH() {
        c cVar = new c();
        cVar.a((b[]) this.sJ.toArray(new b[this.sJ.size()]));
        cVar.a(this.sA);
        cVar.a(this.sF);
        this.sJ = null;
        this.sA = null;
        this.sF = null;
        this.sI = true;
        return cVar;
    }
}
