package com.baidu.tbadk.c;

import com.baidu.adp.framework.task.HttpMessageTask;
/* loaded from: classes.dex */
public final class b extends HttpMessageTask {
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;

    public b(int i, String str) {
        super(i, str);
        this.g = false;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
    }

    public final boolean m() {
        return this.e;
    }

    public final boolean n() {
        return this.f;
    }

    public final boolean o() {
        return this.g;
    }

    public final boolean p() {
        return this.h;
    }

    public final void b(boolean z) {
        this.h = false;
    }

    public final boolean q() {
        return this.i;
    }

    public final void c(boolean z) {
        this.i = false;
    }

    public final boolean r() {
        return this.j;
    }

    public final boolean s() {
        return this.k;
    }

    public final void d(boolean z) {
        this.k = z;
    }
}
