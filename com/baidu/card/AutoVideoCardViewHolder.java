package com.baidu.card;

import android.view.View;
import d.a.i.l0;
import d.a.i.t0;
import d.a.n0.r.q.a;
import d.a.o0.k2.e;
import d.a.o0.k2.o;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends a> extends ThreadCardViewHolder<T> implements e {
    public t0 n;

    public AutoVideoCardViewHolder(l0<T> l0Var) {
        super(l0Var);
        this.n = null;
        if (l0Var.f() instanceof t0) {
            this.n = (t0) l0Var.f();
        }
    }

    @Override // d.a.o0.k2.e
    public boolean C() {
        t0 t0Var = this.n;
        if (t0Var == null) {
            return false;
        }
        return t0Var.C();
    }

    @Override // d.a.o0.k2.e
    public int getCurrentPosition() {
        t0 t0Var = this.n;
        if (t0Var == null) {
            return 0;
        }
        return t0Var.getCurrentPosition();
    }

    @Override // d.a.o0.k2.e
    public String getPlayUrl() {
        t0 t0Var = this.n;
        if (t0Var == null) {
            return null;
        }
        return t0Var.getPlayUrl();
    }

    @Override // d.a.o0.k2.e
    public View getVideoContainer() {
        t0 t0Var = this.n;
        if (t0Var == null) {
            return null;
        }
        return t0Var.getVideoContainer();
    }

    @Override // d.a.o0.k2.e
    public boolean isPlayStarted() {
        t0 t0Var = this.n;
        if (t0Var == null) {
            return false;
        }
        return t0Var.isPlayStarted();
    }

    @Override // d.a.o0.k2.e
    public boolean isPlaying() {
        t0 t0Var = this.n;
        if (t0Var == null) {
            return false;
        }
        return t0Var.isPlaying();
    }

    @Override // d.a.o0.k2.e
    public void startPlay() {
        t0 t0Var = this.n;
        if (t0Var != null) {
            t0Var.startPlay();
        }
    }

    @Override // d.a.o0.k2.e
    public void stopPlay() {
        t0 t0Var = this.n;
        if (t0Var != null) {
            t0Var.stopPlay();
        }
    }

    public t0 u() {
        return this.n;
    }

    public void v(o oVar) {
        t0 t0Var = this.n;
        if (t0Var != null) {
            t0Var.z(oVar);
        }
    }
}
