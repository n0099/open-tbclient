package com.baidu.cesium.a;

import com.baidu.cesium.a.i;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
final class g extends f {
    private a anK;

    /* loaded from: classes4.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<?> f1666a;

        /* renamed from: b  reason: collision with root package name */
        private Method f1667b;
        private Method c;

        private a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long C(Object obj) {
            try {
                return ((Long) this.c.invoke(obj, new Object[0])).longValue();
            } catch (Exception e) {
                throw new i.a("");
            }
        }

        private void a() {
            try {
                this.f1666a = Class.forName(i.a(d.a()), true, Object.class.getClassLoader());
                this.f1667b = i.a(this.f1666a, i.a(d.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.c = i.a(this.f1666a, i.a(d.c()), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.f1667b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                throw new i.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f1666a.newInstance();
        }
    }

    public g(int i, int i2) {
        this.c = 1099511627775L;
        this.d = 4;
        this.e = 32;
        this.f = i;
        this.g = i2;
        this.anK = new a();
    }

    @Override // com.baidu.cesium.a.f
    public b l(byte[] bArr, int i, int i2) {
        long j = 4294967295L;
        try {
            Object b2 = this.anK.b();
            this.anK.a(b2, bArr, i, i2);
            j = this.anK.C(b2);
        } catch (Exception e) {
        }
        return b.a(new long[]{j});
    }
}
