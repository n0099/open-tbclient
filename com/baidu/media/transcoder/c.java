package com.baidu.media.transcoder;

import com.baidu.media.transcoder.a;
/* loaded from: classes4.dex */
public abstract class c implements a {
    private a.d a;
    private a.InterfaceC0116a b;
    private a.e c;
    private a.b d;
    private a.c e;

    public void a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(int i, int i2) {
        return this.d != null && this.d.a(this, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(int i, int i2, Object obj) {
        return this.e != null && this.e.a(this, i, i2, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        if (this.a != null) {
            this.a.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (this.b != null) {
            this.b.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        if (this.c != null) {
            this.c.c(this);
        }
    }

    public final void setOnCompletionListener(a.InterfaceC0116a interfaceC0116a) {
        this.b = interfaceC0116a;
    }

    public final void setOnErrorListener(a.b bVar) {
        this.d = bVar;
    }

    public final void setOnInfoListener(a.c cVar) {
        this.e = cVar;
    }

    public final void setOnPreparedListener(a.d dVar) {
        this.a = dVar;
    }

    public final void setOnTerminalListener(a.e eVar) {
        this.c = eVar;
    }
}
