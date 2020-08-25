package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a KJ;
    private boolean mBuilt;
    private List<b> mComponents = new ArrayList();
    private Configuration KG = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d aj(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.KG.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.KG.mTargetView = view;
        return this;
    }

    public d ak(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.KG.mTargetViewId = i;
        return this;
    }

    public d af(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.KG.mAutoDismiss = z;
        return this;
    }

    public d ag(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.KG.mOverlayTarget = z;
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
        this.KJ = aVar;
        return this;
    }

    public d ah(boolean z) {
        this.KG.mOutsideTouchable = z;
        return this;
    }

    public c md() {
        c cVar = new c();
        cVar.a((b[]) this.mComponents.toArray(new b[this.mComponents.size()]));
        cVar.a(this.KG);
        cVar.a(this.KJ);
        this.mComponents = null;
        this.KG = null;
        this.KJ = null;
        this.mBuilt = true;
        return cVar;
    }
}
