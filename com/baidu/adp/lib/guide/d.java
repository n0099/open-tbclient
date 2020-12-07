package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a Mf;
    private boolean mBuilt;
    private List<b> mComponents = new ArrayList();
    private Configuration Mc = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d an(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.Mc.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.Mc.mTargetView = view;
        return this;
    }

    public d ao(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.Mc.mTargetViewId = i;
        return this;
    }

    public d ac(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.Mc.mAutoDismiss = z;
        return this;
    }

    public d ad(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.Mc.mOverlayTarget = z;
        return this;
    }

    public d ap(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal animation resource id.");
        }
        this.Mc.mEnterAnimationId = i;
        return this;
    }

    public d aq(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal animation resource id.");
        }
        this.Mc.mExitAnimationId = i;
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
        this.Mf = aVar;
        return this;
    }

    public d ae(boolean z) {
        this.Mc.mOutsideTouchable = z;
        return this;
    }

    public c mi() {
        c cVar = new c();
        cVar.a((b[]) this.mComponents.toArray(new b[this.mComponents.size()]));
        cVar.a(this.Mc);
        cVar.a(this.Mf);
        this.mComponents = null;
        this.Mc = null;
        this.Mf = null;
        this.mBuilt = true;
        return cVar;
    }
}
