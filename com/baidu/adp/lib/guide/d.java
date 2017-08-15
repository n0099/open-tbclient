package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a wj;
    private boolean wn;
    private List<b> wo = new ArrayList();
    private Configuration wf = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void fl();

        void onDismiss();
    }

    public d ag(int i) {
        if (this.wn) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.wf.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.wn) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.wf.jv = view;
        return this;
    }

    public d ah(int i) {
        if (this.wn) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.wf.vY = i;
        return this;
    }

    public d y(boolean z) {
        if (this.wn) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.wf.wa = z;
        return this;
    }

    public d z(boolean z) {
        if (this.wn) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.wf.wb = z;
        return this;
    }

    public d a(b bVar) {
        if (this.wn) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.wo.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.wn) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.wj = aVar;
        return this;
    }

    public d A(boolean z) {
        this.wf.vW = z;
        return this;
    }

    public c fk() {
        c cVar = new c();
        cVar.a((b[]) this.wo.toArray(new b[this.wo.size()]));
        cVar.a(this.wf);
        cVar.a(this.wj);
        this.wo = null;
        this.wf = null;
        this.wj = null;
        this.wn = true;
        return cVar;
    }
}
