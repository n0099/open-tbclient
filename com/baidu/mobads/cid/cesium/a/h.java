package com.baidu.mobads.cid.cesium.a;

import com.baidu.mobads.cid.cesium.a.e;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class h extends g {

    /* renamed from: f  reason: collision with root package name */
    public a f8044f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f8045a;

        /* renamed from: b  reason: collision with root package name */
        public Method f8046b;

        /* renamed from: c  reason: collision with root package name */
        public Method f8047c;

        public a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(Object obj) {
            try {
                return ((Long) this.f8047c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new e.a("");
            }
        }

        private void a() {
            try {
                this.f8045a = Class.forName(e.a(d.a()), true, Object.class.getClassLoader());
                this.f8046b = e.a(this.f8045a, e.a(d.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f8047c = e.a(this.f8045a, e.a(d.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.f8046b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception unused) {
                throw new e.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f8045a.newInstance();
        }
    }

    public h(int i, int i2) {
        this.f8039a = 1099511627775L;
        this.f8040b = 4;
        this.f8041c = 32;
        this.f8042d = i;
        this.f8043e = i2;
        this.f8044f = new a();
    }

    @Override // com.baidu.mobads.cid.cesium.a.g
    public b a(byte[] bArr, int i, int i2) {
        long j;
        try {
            Object b2 = this.f8044f.b();
            this.f8044f.a(b2, bArr, i, i2);
            j = this.f8044f.a(b2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return b.a(new long[]{j});
    }
}
