package com.baidu.b.a;

import com.baidu.b.a.e;
import java.lang.reflect.Method;
/* loaded from: classes15.dex */
final class h extends g {
    private a aeI;

    /* loaded from: classes15.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<?> f1569a;

        /* renamed from: b  reason: collision with root package name */
        private Method f1570b;
        private Method c;

        private a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long C(Object obj) {
            try {
                return ((Long) this.c.invoke(obj, new Object[0])).longValue();
            } catch (Exception e) {
                throw new e.a("");
            }
        }

        private void a() {
            try {
                this.f1569a = Class.forName(e.a(d.a()), true, Object.class.getClassLoader());
                this.f1570b = e.a(this.f1569a, e.a(d.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.c = e.a(this.f1569a, e.a(d.c()), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.f1570b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                throw new e.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f1569a.newInstance();
        }
    }

    public h(int i, int i2) {
        this.f1567a = 1099511627775L;
        this.f1568b = 4;
        this.c = 32;
        this.d = i;
        this.e = i2;
        this.aeI = new a();
    }

    @Override // com.baidu.b.a.g
    public b i(byte[] bArr, int i, int i2) {
        long j = 4294967295L;
        try {
            Object b2 = this.aeI.b();
            this.aeI.a(b2, bArr, i, i2);
            j = this.aeI.C(b2);
        } catch (Exception e) {
        }
        return b.a(new long[]{j});
    }
}
