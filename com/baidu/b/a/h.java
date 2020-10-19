package com.baidu.b.a;

import com.baidu.b.a.e;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
final class h extends g {
    private a acQ;

    /* loaded from: classes7.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<?> f1245a;
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
                throw new e.a("");
            }
        }

        private void a() {
            try {
                this.f1245a = Class.forName(e.a(d.a()), true, Object.class.getClassLoader());
                this.b = e.a(this.f1245a, e.a(d.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.c = e.a(this.f1245a, e.a(d.c()), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                throw new e.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f1245a.newInstance();
        }
    }

    public h(int i, int i2) {
        this.f1244a = 1099511627775L;
        this.b = 4;
        this.c = 32;
        this.d = i;
        this.e = i2;
        this.acQ = new a();
    }

    @Override // com.baidu.b.a.g
    public b i(byte[] bArr, int i, int i2) {
        long j = 4294967295L;
        try {
            Object b = this.acQ.b();
            this.acQ.a(b, bArr, i, i2);
            j = this.acQ.G(b);
        } catch (Exception e) {
        }
        return b.a(new long[]{j});
    }
}
