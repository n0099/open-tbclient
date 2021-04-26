package com.baidu.card;

import android.view.View;
import d.a.i.k0;
import d.a.i.s0;
import d.a.i0.r.q.a;
import d.a.j0.j2.e;
import d.a.j0.j2.o;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends a> extends ThreadCardViewHolder<T> implements e {
    public s0 n;

    public AutoVideoCardViewHolder(k0<T> k0Var) {
        super(k0Var);
        this.n = null;
        if (k0Var.f() instanceof s0) {
            this.n = (s0) k0Var.f();
        }
    }

    @Override // d.a.j0.j2.e
    public boolean C() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return false;
        }
        return s0Var.C();
    }

    @Override // d.a.j0.j2.e
    public int getCurrentPosition() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return 0;
        }
        return s0Var.getCurrentPosition();
    }

    @Override // d.a.j0.j2.e
    public String getPlayUrl() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return null;
        }
        return s0Var.getPlayUrl();
    }

    @Override // d.a.j0.j2.e
    public View getVideoContainer() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return null;
        }
        return s0Var.getVideoContainer();
    }

    @Override // d.a.j0.j2.e
    public boolean isPlayStarted() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return false;
        }
        return s0Var.isPlayStarted();
    }

    @Override // d.a.j0.j2.e
    public boolean isPlaying() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return false;
        }
        return s0Var.isPlaying();
    }

    @Override // d.a.j0.j2.e
    public void startPlay() {
        s0 s0Var = this.n;
        if (s0Var != null) {
            s0Var.startPlay();
        }
    }

    @Override // d.a.j0.j2.e
    public void stopPlay() {
        s0 s0Var = this.n;
        if (s0Var != null) {
            s0Var.stopPlay();
        }
    }

    public s0 t() {
        return this.n;
    }

    public void u(o oVar) {
        s0 s0Var = this.n;
        if (s0Var != null) {
            s0Var.z(oVar);
        }
    }
}
