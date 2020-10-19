package com.baidu.cesium.a;

import com.baidu.cesium.a.i;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
final class g extends f {
    private a alZ;

    /* loaded from: classes6.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<?> f1294a;
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
                throw new i.a("");
            }
        }

        private void a() {
            try {
                this.f1294a = Class.forName(i.a(d.a()), true, Object.class.getClassLoader());
                this.b = i.a(this.f1294a, i.a(d.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.c = i.a(this.f1294a, i.a(d.c()), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                throw new i.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f1294a.newInstance();
        }
    }

    public g(int i, int i2) {
        this.c = 1099511627775L;
        this.d = 4;
        this.e = 32;
        this.f = i;
        this.g = i2;
        this.alZ = new a();
    }

    @Override // com.baidu.cesium.a.f
    public b l(byte[] bArr, int i, int i2) {
        long j = 4294967295L;
        try {
            Object b = this.alZ.b();
            this.alZ.a(b, bArr, i, i2);
            j = this.alZ.G(b);
        } catch (Exception e) {
        }
        return b.a(new long[]{j});
    }
}
