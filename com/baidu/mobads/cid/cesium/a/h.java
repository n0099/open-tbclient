package com.baidu.mobads.cid.cesium.a;

import com.baidu.mobads.cid.cesium.a.e;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class h extends g {

    /* renamed from: f  reason: collision with root package name */
    public a f8109f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f8110a;

        /* renamed from: b  reason: collision with root package name */
        public Method f8111b;

        /* renamed from: c  reason: collision with root package name */
        public Method f8112c;

        public a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(Object obj) {
            try {
                return ((Long) this.f8112c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new e.a("");
            }
        }

        private void a() {
            try {
                this.f8110a = Class.forName(e.a(d.a()), true, Object.class.getClassLoader());
                this.f8111b = e.a(this.f8110a, e.a(d.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f8112c = e.a(this.f8110a, e.a(d.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f8111b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
                throw new e.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f8110a.newInstance();
        }
    }

    public h(int i2, int i3) {
        this.f8104a = 1099511627775L;
        this.f8105b = 4;
        this.f8106c = 32;
        this.f8107d = i2;
        this.f8108e = i3;
        this.f8109f = new a();
    }

    @Override // com.baidu.mobads.cid.cesium.a.g
    public b a(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object b2 = this.f8109f.b();
            this.f8109f.a(b2, bArr, i2, i3);
            j = this.f8109f.a(b2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return b.a(new long[]{j});
    }
}
