package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a kn;
    private boolean kq;
    private List<b> kr = new ArrayList();
    private Configuration kj = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void cX();

        void onDismiss();
    }

    public g N(int i) {
        if (this.kq) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.kj.mAlpha = i;
        return this;
    }

    public g o(View view) {
        if (this.kq) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.kj.bL = view;
        return this;
    }

    public g O(int i) {
        if (this.kq) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.kj.kc = i;
        return this;
    }

    public g t(boolean z) {
        if (this.kq) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.kj.ke = z;
        return this;
    }

    public g u(boolean z) {
        if (this.kq) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.kj.kf = z;
        return this;
    }

    public g a(b bVar) {
        if (this.kq) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.kr.add(bVar);
        return this;
    }

    public g v(boolean z) {
        this.kj.jZ = z;
        return this;
    }

    public d cW() {
        d dVar = new d();
        dVar.a((b[]) this.kr.toArray(new b[this.kr.size()]));
        dVar.a(this.kj);
        dVar.a(this.kn);
        this.kr = null;
        this.kj = null;
        this.kn = null;
        this.kq = true;
        return dVar;
    }
}
