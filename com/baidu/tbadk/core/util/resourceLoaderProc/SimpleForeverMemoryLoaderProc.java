package com.baidu.tbadk.core.util.resourceLoaderProc;

import d.b.c.j.d.a;
import d.b.h0.a0.c;
/* loaded from: classes3.dex */
public class SimpleForeverMemoryLoaderProc extends SimpleLoaderProc {
    public SimpleForeverMemoryLoaderProc(boolean z, boolean z2, boolean z3, int i) {
        super(z, z2, z3, i);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.c.e.l.e
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.u()) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.A(i);
                aVar.z(i2);
                c.k().f(str, aVar);
                d.b.c.e.l.a.l(true, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.c.e.l.e
    public a getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        a o = c.k().o(str);
        if (z) {
            d.b.c.e.l.a.i(o != null, System.currentTimeMillis() - currentTimeMillis);
        }
        return o;
    }
}
