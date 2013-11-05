package com.baidu.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private boolean b;
    private h d;
    private List<b> c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private Configuration f498a = new Configuration();

    public g a(int i) {
        if (this.b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.f498a.b = i;
        return this;
    }

    public g a(View view) {
        if (this.b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.f498a.f494a = view;
        return this;
    }

    public g b(int i) {
        if (this.b) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.f498a.d = i;
        return this;
    }

    public g a(boolean z) {
        if (this.b) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.f498a.g = z;
        return this;
    }

    public g a(b bVar) {
        if (this.b) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.c.add(bVar);
        return this;
    }

    public d a() {
        d dVar = new d();
        dVar.a((b[]) this.c.toArray(new b[this.c.size()]));
        dVar.a(this.f498a);
        dVar.a(this.d);
        this.c = null;
        this.f498a = null;
        this.d = null;
        this.b = true;
        return dVar;
    }
}
