package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a zC;
    private boolean zF;
    private List<b> zG = new ArrayList();
    private Configuration zx = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d X(int i) {
        if (this.zF) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.zx.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.zF) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.zx.mTargetView = view;
        return this;
    }

    public d Y(int i) {
        if (this.zF) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.zx.zq = i;
        return this;
    }

    public d T(boolean z) {
        if (this.zF) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zx.zs = z;
        return this;
    }

    public d U(boolean z) {
        if (this.zF) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zx.zt = z;
        return this;
    }

    public d a(b bVar) {
        if (this.zF) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zG.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.zF) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.zC = aVar;
        return this;
    }

    public d V(boolean z) {
        this.zx.zo = z;
        return this;
    }

    public c hV() {
        c cVar = new c();
        cVar.a((b[]) this.zG.toArray(new b[this.zG.size()]));
        cVar.a(this.zx);
        cVar.a(this.zC);
        this.zG = null;
        this.zx = null;
        this.zC = null;
        this.zF = true;
        return cVar;
    }
}
