package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class g {
    private boolean b;
    private h d;
    private List<b> c = new ArrayList();
    private Configuration a = new Configuration();

    public final g a(int i) {
        if (this.b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.a.b = i;
        return this;
    }

    public final g a(View view) {
        if (this.b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.a.a = view;
        return this;
    }

    public final g b(int i) {
        if (this.b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.a.d = i;
        return this;
    }

    public final g a(boolean z) {
        if (this.b) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.a.f = false;
        return this;
    }

    public final g b(boolean z) {
        if (this.b) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.a.g = z;
        return this;
    }

    public final g a(b bVar) {
        if (this.b) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.c.add(bVar);
        return this;
    }

    public final d a() {
        d dVar = new d();
        dVar.a((b[]) this.c.toArray(new b[this.c.size()]));
        dVar.a(this.a);
        dVar.a(this.d);
        this.c = null;
        this.a = null;
        this.d = null;
        this.b = true;
        return dVar;
    }
}
