package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.h;
/* loaded from: classes.dex */
public final class c extends b {
    private boolean e;
    private boolean f;
    private Class<? extends h> g;

    @Override // com.baidu.adp.framework.task.b
    public final boolean b() {
        return FrameHelper.c(this.a);
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean c() {
        return this.f;
    }

    public final Class<? extends h> d() {
        return this.g;
    }
}
