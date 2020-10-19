package com.baidu.helios.common.cc;

import com.baidu.helios.common.cc.n;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class f extends e {
    private a axV;

    /* loaded from: classes11.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<?> f1806a;
        private Method b;
        private Method c;

        private a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long G(Object obj) {
            try {
                return ((Long) this.c.invoke(obj, new Object[0])).longValue();
            } catch (Exception e) {
                throw new n.a("");
            }
        }

        private void a() {
            try {
                this.f1806a = Class.forName(n.a(i.a()), true, Object.class.getClassLoader());
                this.b = n.a(this.f1806a, n.a(i.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.c = n.a(this.f1806a, n.a(i.c()), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                throw new n.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f1806a.newInstance();
        }
    }

    public f(int i, int i2) {
        this.b = 4294967295L;
        this.c = 4;
        this.d = 32;
        this.e = i;
        this.f = i2;
        this.axV = new a();
    }

    @Override // com.baidu.helios.common.cc.e
    public com.baidu.helios.common.cc.a n(byte[] bArr, int i, int i2) {
        long j = 4294967295L;
        try {
            Object b = this.axV.b();
            this.axV.a(b, bArr, i, i2);
            j = this.axV.G(b);
        } catch (Exception e) {
        }
        return com.baidu.helios.common.cc.a.a(new long[]{j});
    }
}
