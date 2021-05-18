package com.baidu.mobads.cid.cesium.a;

import com.baidu.mobads.cid.cesium.a.e;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class h extends g {

    /* renamed from: f  reason: collision with root package name */
    public a f8147f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f8148a;

        /* renamed from: b  reason: collision with root package name */
        public Method f8149b;

        /* renamed from: c  reason: collision with root package name */
        public Method f8150c;

        public a() {
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(Object obj) {
            try {
                return ((Long) this.f8150c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new e.a("");
            }
        }

        private void a() {
            try {
                this.f8148a = Class.forName(e.a(d.a()), true, Object.class.getClassLoader());
                this.f8149b = e.a(this.f8148a, e.a(d.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f8150c = e.a(this.f8148a, e.a(d.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f8149b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
                throw new e.a("");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            return this.f8148a.newInstance();
        }
    }

    public h(int i2, int i3) {
        this.f8142a = 1099511627775L;
        this.f8143b = 4;
        this.f8144c = 32;
        this.f8145d = i2;
        this.f8146e = i3;
        this.f8147f = new a();
    }

    @Override // com.baidu.mobads.cid.cesium.a.g
    public b a(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object b2 = this.f8147f.b();
            this.f8147f.a(b2, bArr, i2, i3);
            j = this.f8147f.a(b2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return b.a(new long[]{j});
    }
}
