package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a BM;
    private boolean BP;
    private List<b> BQ = new ArrayList();
    private Configuration BH = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d af(int i) {
        if (this.BP) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.BH.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.BP) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.BH.mTargetView = view;
        return this;
    }

    public d ag(int i) {
        if (this.BP) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.BH.BA = i;
        return this;
    }

    public d N(boolean z) {
        if (this.BP) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BH.BC = z;
        return this;
    }

    public d O(boolean z) {
        if (this.BP) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BH.BD = z;
        return this;
    }

    public d a(b bVar) {
        if (this.BP) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BQ.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.BP) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BM = aVar;
        return this;
    }

    public d P(boolean z) {
        this.BH.mOutsideTouchable = z;
        return this;
    }

    public c iU() {
        c cVar = new c();
        cVar.a((b[]) this.BQ.toArray(new b[this.BQ.size()]));
        cVar.a(this.BH);
        cVar.a(this.BM);
        this.BQ = null;
        this.BH = null;
        this.BM = null;
        this.BP = true;
        return cVar;
    }
}
