package com.baidu.helios.common.cc;

import com.baidu.helios.common.cc.n;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f extends e {
    private a axC;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<?> f2491a;

        /* renamed from: b  reason: collision with root package name */
        private Method f2492b;
        private Method c;

        private a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long C(Object obj) {
            try {
                return ((Long) this.c.invoke(obj, new Object[0])).longValue();
            } catch (Exception e) {
                throw new n.a("");
            }
        }

        private void a() {
            try {
                this.f2491a = Class.forName(n.a(i.a()), true, Object.class.getClassLoader());
                this.f2492b = n.a(this.f2491a, n.a(i.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.c = n.a(this.f2491a, n.a(i.c()), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.f2492b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                throw new n.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f2491a.newInstance();
        }
    }

    public f(int i, int i2) {
        this.f2490b = 4294967295L;
        this.c = 4;
        this.d = 32;
        this.e = i;
        this.f = i2;
        this.axC = new a();
    }

    @Override // com.baidu.helios.common.cc.e
    public com.baidu.helios.common.cc.a n(byte[] bArr, int i, int i2) {
        long j = 4294967295L;
        try {
            Object b2 = this.axC.b();
            this.axC.a(b2, bArr, i, i2);
            j = this.axC.C(b2);
        } catch (Exception e) {
        }
        return com.baidu.helios.common.cc.a.a(new long[]{j});
    }
}
