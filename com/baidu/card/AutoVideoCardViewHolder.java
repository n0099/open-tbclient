package com.baidu.card;

import android.view.View;
import d.b.h0.r.q.a;
import d.b.i.k0;
import d.b.i.s0;
import d.b.i0.i2.e;
import d.b.i0.i2.o;
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

    @Override // d.b.i0.i2.e
    public boolean D() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return false;
        }
        return s0Var.D();
    }

    @Override // d.b.i0.i2.e
    public int getCurrentPosition() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return 0;
        }
        return s0Var.getCurrentPosition();
    }

    @Override // d.b.i0.i2.e
    public String getPlayUrl() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return null;
        }
        return s0Var.getPlayUrl();
    }

    @Override // d.b.i0.i2.e
    public View getVideoContainer() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return null;
        }
        return s0Var.getVideoContainer();
    }

    @Override // d.b.i0.i2.e
    public boolean isPlayStarted() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return false;
        }
        return s0Var.isPlayStarted();
    }

    @Override // d.b.i0.i2.e
    public boolean isPlaying() {
        s0 s0Var = this.n;
        if (s0Var == null) {
            return false;
        }
        return s0Var.isPlaying();
    }

    @Override // d.b.i0.i2.e
    public void startPlay() {
        s0 s0Var = this.n;
        if (s0Var != null) {
            s0Var.startPlay();
        }
    }

    @Override // d.b.i0.i2.e
    public void stopPlay() {
        s0 s0Var = this.n;
        if (s0Var != null) {
            s0Var.stopPlay();
        }
    }

    public s0 v() {
        return this.n;
    }

    public void w(o oVar) {
        s0 s0Var = this.n;
        if (s0Var != null) {
            s0Var.z(oVar);
        }
    }
}
