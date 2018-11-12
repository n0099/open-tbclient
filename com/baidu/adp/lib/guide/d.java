package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private a BP;
    private boolean BS;
    private List<b> BT = new ArrayList();
    private Configuration BK = new Configuration();

    /* loaded from: classes.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d aw(int i) {
        if (this.BS) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.BK.mAlpha = i;
        return this;
    }

    public d y(View view) {
        if (this.BS) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.BK.mTargetView = view;
        return this;
    }

    public d ax(int i) {
        if (this.BS) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.BK.BD = i;
        return this;
    }

    public d ab(boolean z) {
        if (this.BS) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BK.BF = z;
        return this;
    }

    public d ac(boolean z) {
        if (this.BS) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BK.BG = z;
        return this;
    }

    public d a(b bVar) {
        if (this.BS) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BT.add(bVar);
        return this;
    }

    public d b(a aVar) {
        if (this.BS) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.BP = aVar;
        return this;
    }

    public d ad(boolean z) {
        this.BK.mOutsideTouchable = z;
        return this;
    }

    public c iT() {
        c cVar = new c();
        cVar.a((b[]) this.BT.toArray(new b[this.BT.size()]));
        cVar.a(this.BK);
        cVar.a(this.BP);
        this.BT = null;
        this.BK = null;
        this.BP = null;
        this.BS = true;
        return cVar;
    }
}
