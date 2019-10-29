package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private boolean mBuilt;
    private a oA;
    private List<b> mComponents = new ArrayList();
    private Configuration ox = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d I(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.ox.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.ox.mTargetView = view;
        return this;
    }

    public d J(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.ox.mTargetViewId = i;
        return this;
    }

    public d A(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ox.mAutoDismiss = z;
        return this;
    }

    public d B(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ox.mOverlayTarget = z;
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
        this.oA = aVar;
        return this;
    }

    public d C(boolean z) {
        this.ox.mOutsideTouchable = z;
        return this;
    }

    public c fu() {
        c cVar = new c();
        cVar.a((b[]) this.mComponents.toArray(new b[this.mComponents.size()]));
        cVar.a(this.ox);
        cVar.a(this.oA);
        this.mComponents = null;
        this.ox = null;
        this.oA = null;
        this.mBuilt = true;
        return cVar;
    }
}
