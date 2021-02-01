package com.baidu.helios.common.cc;

import com.baidu.helios.common.cc.n;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f extends e {
    private a asG;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<?> f2440a;

        /* renamed from: b  reason: collision with root package name */
        private Method f2441b;
        private Method c;

        private a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long D(Object obj) {
            try {
                return ((Long) this.c.invoke(obj, new Object[0])).longValue();
            } catch (Exception e) {
                throw new n.a("");
            }
        }

        private void a() {
            try {
                this.f2440a = Class.forName(n.a(i.a()), true, Object.class.getClassLoader());
                this.f2441b = n.a(this.f2440a, n.a(i.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.c = n.a(this.f2440a, n.a(i.c()), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.f2441b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                throw new n.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f2440a.newInstance();
        }
    }

    public f(int i, int i2) {
        this.f2439b = 4294967295L;
        this.c = 4;
        this.d = 32;
        this.e = i;
        this.f = i2;
        this.asG = new a();
    }

    @Override // com.baidu.helios.common.cc.e
    public com.baidu.helios.common.cc.a m(byte[] bArr, int i, int i2) {
        long j = 4294967295L;
        try {
            Object b2 = this.asG.b();
            this.asG.a(b2, bArr, i, i2);
            j = this.asG.D(b2);
        } catch (Exception e) {
        }
        return com.baidu.helios.common.cc.a.a(new long[]{j});
    }
}
