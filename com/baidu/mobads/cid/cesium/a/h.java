package com.baidu.mobads.cid.cesium.a;

import com.baidu.mobads.cid.cesium.a.e;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class h extends g {

    /* renamed from: f  reason: collision with root package name */
    public a f8335f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f8336a;

        /* renamed from: b  reason: collision with root package name */
        public Method f8337b;

        /* renamed from: c  reason: collision with root package name */
        public Method f8338c;

        public a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(Object obj) {
            try {
                return ((Long) this.f8338c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new e.a("");
            }
        }

        private void a() {
            try {
                this.f8336a = Class.forName(e.a(d.a()), true, Object.class.getClassLoader());
                this.f8337b = e.a(this.f8336a, e.a(d.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f8338c = e.a(this.f8336a, e.a(d.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f8337b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
                throw new e.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f8336a.newInstance();
        }
    }

    public h(int i2, int i3) {
        this.f8330a = 1099511627775L;
        this.f8331b = 4;
        this.f8332c = 32;
        this.f8333d = i2;
        this.f8334e = i3;
        this.f8335f = new a();
    }

    @Override // com.baidu.mobads.cid.cesium.a.g
    public b a(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object b2 = this.f8335f.b();
            this.f8335f.a(b2, bArr, i2, i3);
            j = this.f8335f.a(b2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return b.a(new long[]{j});
    }
}
