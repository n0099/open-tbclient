package com.baidu.tbadk.core.util.resourceLoaderProc;

import d.a.c.k.d.a;
import d.a.n0.a0.c;
/* loaded from: classes3.dex */
public class SimpleForeverMemoryLoaderProc extends SimpleLoaderProc {
    public SimpleForeverMemoryLoaderProc(boolean z, boolean z2, boolean z3, int i2) {
        super(z, z2, z3, i2);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.a.c.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.u()) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.A(i2);
                aVar.z(i3);
                c.k().f(str, aVar);
                d.a.c.e.l.a.l(true, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.a.c.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        a o = c.k().o(str);
        if (z) {
            d.a.c.e.l.a.i(o != null, System.currentTimeMillis() - currentTimeMillis);
        }
        return o;
    }
}
