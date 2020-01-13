package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private boolean mBuilt;
    private List<b> mComponents = new ArrayList();
    private Configuration qn = new Configuration();
    private a qq;

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d J(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.qn.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.qn.mTargetView = view;
        return this;
    }

    public d K(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.qn.mTargetViewId = i;
        return this;
    }

    public d E(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.qn.mAutoDismiss = z;
        return this;
    }

    public d F(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.qn.mOverlayTarget = z;
        return this;
    }

    public d a(b bVar) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.mComponents.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.qq = aVar;
        return this;
    }

    public d G(boolean z) {
        this.qn.mOutsideTouchable = z;
        return this;
    }

    public c fI() {
        c cVar = new c();
        cVar.a((b[]) this.mComponents.toArray(new b[this.mComponents.size()]));
        cVar.a(this.qn);
        cVar.a(this.qq);
        this.mComponents = null;
        this.qn = null;
        this.qq = null;
        this.mBuilt = true;
        return cVar;
    }
}
