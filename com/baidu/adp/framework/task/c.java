package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class c extends b {
    private boolean e;
    private boolean f;
    private boolean g;
    private Class<? extends SocketResponsedMessage> h;

    public c(int i) {
        super(i);
        this.e = false;
        this.f = false;
        this.g = false;
    }

    @Override // com.baidu.adp.framework.task.b
    public final boolean b() {
        return FrameHelper.c(this.a) || FrameHelper.b(this.a);
    }

    public final void a(boolean z) {
        this.e = true;
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean c() {
        return this.f;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final Class<? extends SocketResponsedMessage> d() {
        return this.h;
    }

    public final void a(Class<? extends SocketResponsedMessage> cls) {
        this.h = cls;
    }

    public final boolean e() {
        return this.g;
    }

    public final void c(boolean z) {
        this.g = true;
    }
}
