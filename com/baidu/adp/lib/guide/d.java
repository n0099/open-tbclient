package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a tY;
    private boolean uc;
    private List<b> ud = new ArrayList();
    private Configuration tU = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void fa();

        void onDismiss();
    }

    public d ad(int i) {
        if (this.uc) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.tU.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.uc) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.tU.ju = view;
        return this;
    }

    public d ae(int i) {
        if (this.uc) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.tU.tN = i;
        return this;
    }

    public d z(boolean z) {
        if (this.uc) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tU.tP = z;
        return this;
    }

    public d A(boolean z) {
        if (this.uc) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tU.tQ = z;
        return this;
    }

    public d a(b bVar) {
        if (this.uc) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ud.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.uc) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tY = aVar;
        return this;
    }

    public d B(boolean z) {
        this.tU.tL = z;
        return this;
    }

    public c eZ() {
        c cVar = new c();
        cVar.a((b[]) this.ud.toArray(new b[this.ud.size()]));
        cVar.a(this.tU);
        cVar.a(this.tY);
        this.ud = null;
        this.tU = null;
        this.tY = null;
        this.uc = true;
        return cVar;
    }
}
