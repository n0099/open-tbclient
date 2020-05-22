package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a JF;
    private boolean mBuilt;
    private List<b> mComponents = new ArrayList();
    private Configuration JC = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d Z(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.JC.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.JC.mTargetView = view;
        return this;
    }

    public d aa(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.JC.mTargetViewId = i;
        return this;
    }

    public d ad(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.JC.mAutoDismiss = z;
        return this;
    }

    public d ae(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.JC.mOverlayTarget = z;
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
        this.JF = aVar;
        return this;
    }

    public d af(boolean z) {
        this.JC.mOutsideTouchable = z;
        return this;
    }

    public c ko() {
        c cVar = new c();
        cVar.a((b[]) this.mComponents.toArray(new b[this.mComponents.size()]));
        cVar.a(this.JC);
        cVar.a(this.JF);
        this.mComponents = null;
        this.JC = null;
        this.JF = null;
        this.mBuilt = true;
        return cVar;
    }
}
