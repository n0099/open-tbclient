package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a MX;
    private boolean mBuilt;
    private List<b> mComponents = new ArrayList();
    private Configuration MU = new Configuration();

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
        this.MU.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.MU.mTargetView = view;
        return this;
    }

    public d ao(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.MU.mTargetViewId = i;
        return this;
    }

    public d ab(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.MU.mAutoDismiss = z;
        return this;
    }

    public d ac(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.MU.mOverlayTarget = z;
        return this;
    }

    public d ap(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal animation resource id.");
        }
        this.MU.mEnterAnimationId = i;
        return this;
    }

    public d aq(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal animation resource id.");
        }
        this.MU.mExitAnimationId = i;
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
        this.MX = aVar;
        return this;
    }

    public d ad(boolean z) {
        this.MU.mOutsideTouchable = z;
        return this;
    }

    public c lF() {
        c cVar = new c();
        cVar.a((b[]) this.mComponents.toArray(new b[this.mComponents.size()]));
        cVar.a(this.MU);
        cVar.a(this.MX);
        this.mComponents = null;
        this.MU = null;
        this.MX = null;
        this.mBuilt = true;
        return cVar;
    }
}
