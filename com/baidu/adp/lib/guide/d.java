package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private boolean mBuilt;
    private List<b> mComponents = new ArrayList();
    private Configuration qo = new Configuration();
    private a qr;

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d M(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.qo.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.qo.mTargetView = view;
        return this;
    }

    public d N(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.qo.mTargetViewId = i;
        return this;
    }

    public d E(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.qo.mAutoDismiss = z;
        return this;
    }

    public d F(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.qo.mOverlayTarget = z;
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
        this.qr = aVar;
        return this;
    }

    public d G(boolean z) {
        this.qo.mOutsideTouchable = z;
        return this;
    }

    public c fI() {
        c cVar = new c();
        cVar.a((b[]) this.mComponents.toArray(new b[this.mComponents.size()]));
        cVar.a(this.qo);
        cVar.a(this.qr);
        this.mComponents = null;
        this.qo = null;
        this.qr = null;
        this.mBuilt = true;
        return cVar;
    }
}
