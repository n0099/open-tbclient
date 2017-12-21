package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a tZ;
    private boolean ud;
    private List<b> ue = new ArrayList();
    private Configuration tV = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void eZ();

        void onDismiss();
    }

    public d ac(int i) {
        if (this.ud) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.tV.mAlpha = i;
        return this;
    }

    public d o(View view) {
        if (this.ud) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.tV.ju = view;
        return this;
    }

    public d ad(int i) {
        if (this.ud) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.tV.tO = i;
        return this;
    }

    public d z(boolean z) {
        if (this.ud) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tV.tQ = z;
        return this;
    }

    public d A(boolean z) {
        if (this.ud) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tV.tR = z;
        return this;
    }

    public d a(b bVar) {
        if (this.ud) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.ue.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.ud) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.tZ = aVar;
        return this;
    }

    public d B(boolean z) {
        this.tV.tM = z;
        return this;
    }

    public c eY() {
        c cVar = new c();
        cVar.a((b[]) this.ue.toArray(new b[this.ue.size()]));
        cVar.a(this.tV);
        cVar.a(this.tZ);
        this.ue = null;
        this.tV = null;
        this.tZ = null;
        this.ud = true;
        return cVar;
    }
}
