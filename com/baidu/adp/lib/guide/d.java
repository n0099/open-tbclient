package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a Lh;
    private boolean mBuilt;
    private List<b> mComponents = new ArrayList();
    private Configuration Le = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d ak(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.Le.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.Le.mTargetView = view;
        return this;
    }

    public d al(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.Le.mTargetViewId = i;
        return this;
    }

    public d ae(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.Le.mAutoDismiss = z;
        return this;
    }

    public d af(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.Le.mOverlayTarget = z;
        return this;
    }

    public d am(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal animation resource id.");
        }
        this.Le.mEnterAnimationId = i;
        return this;
    }

    public d an(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal animation resource id.");
        }
        this.Le.mExitAnimationId = i;
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
        this.Lh = aVar;
        return this;
    }

    public d ag(boolean z) {
        this.Le.mOutsideTouchable = z;
        return this;
    }

    public c mi() {
        c cVar = new c();
        cVar.a((b[]) this.mComponents.toArray(new b[this.mComponents.size()]));
        cVar.a(this.Le);
        cVar.a(this.Lh);
        this.mComponents = null;
        this.Le = null;
        this.Lh = null;
        this.mBuilt = true;
        return cVar;
    }
}
