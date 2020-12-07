package com.baidu.b.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.media.ExifInterface;
import com.baidu.b.a.e;
import com.baidu.b.b.a;
import com.baidu.b.h;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes26.dex */
public class e extends com.baidu.b.b.a {
    private f aei;
    private Context d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f1250a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
        private final int b;

        private a(int i) {
            this.b = i;
        }

        public static a a(byte b, boolean z) {
            int i = b & 255;
            return z ? bo(i >> 4) : bo(i & 15);
        }

        public static a bo(int i) {
            if (i < 0 || i >= 16) {
                throw new IllegalArgumentException("invalid idx " + i);
            }
            return new a(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.b - aVar.b;
        }

        public String a() {
            return f1250a[this.b];
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.b == ((a) obj).b;
        }

        public int hashCode() {
            return this.b;
        }

        public byte sN() {
            return (byte) this.b;
        }
    }

    /* loaded from: classes26.dex */
    class b {
        private int d;
        private int b = 33;
        private a[] aej = new a[this.b];

        public b() {
        }

        private void b(int i) {
            if (i - this.aej.length > 0) {
                int length = this.aej.length;
                int i2 = length + (length >> 1);
                if (i2 - i >= 0) {
                    i = i2;
                }
                this.aej = (a[]) Arrays.copyOf(this.aej, i);
            }
        }

        public int a() {
            return this.d;
        }

        public void b(a aVar) {
            b(this.d + 1);
            a[] aVarArr = this.aej;
            int i = this.d;
            this.d = i + 1;
            aVarArr[i] = aVar;
        }

        public byte[] b() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < this.d / 2; i++) {
                byteArrayOutputStream.write((byte) ((bo(i * 2).sN() & 255) | ((bo((i * 2) + 1).sN() & 255) << 4)));
            }
            if (this.d % 2 != 0) {
                byteArrayOutputStream.write((byte) (bo(this.d - 1).sN() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }

        public a bo(int i) {
            if (i >= this.d) {
                throw new IndexOutOfBoundsException("idx " + i + " size " + this.d);
            }
            return this.aej[i];
        }
    }

    /* loaded from: classes26.dex */
    static class c {

        /* renamed from: a  reason: collision with root package name */
        private List<a> f1251a = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes26.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f1252a;
            private a ael;

            public a(a aVar) {
                this.ael = aVar;
            }

            public void a() {
                this.f1252a++;
            }
        }

        c() {
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.f1251a);
            Collections.sort(arrayList, new com.baidu.b.b.f(this));
            return arrayList;
        }

        public void b(a aVar) {
            this.f1251a.add(new a(aVar));
        }
    }

    /* loaded from: classes26.dex */
    static class d {

        /* renamed from: a  reason: collision with root package name */
        byte[] f1253a;
        byte b;
        byte[] c;

        public d(byte[] bArr, byte b, byte[] bArr2) {
            this.f1253a = bArr;
            this.b = b;
            this.c = bArr2;
        }

        public h.a a() {
            try {
                return h.k(com.baidu.b.d.b.a(this.f1253a, "", true), new String(new byte[]{this.b}, "UTF-8"), this.c != null ? new String(this.c, "UTF-8") : null);
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.b.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0092e {

        /* renamed from: a  reason: collision with root package name */
        public int f1254a;
        public int b;
        public int c = 16;

        C0092e() {
        }

        public String toString() {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private Method f1255a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;

        f() {
        }

        public int a(Context context, Uri uri, int i, int i2, int i3) {
            try {
                return ((Integer) this.f1255a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
            } catch (Exception e) {
                throw new e.a(e);
            }
        }

        void a() {
            try {
                this.f1255a = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(com.baidu.b.a.d.sI()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.b = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(com.baidu.b.a.d.sJ()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.c = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(com.baidu.b.a.d.sK()), new Class[]{Uri.class, Integer.TYPE});
                this.d = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(com.baidu.b.a.d.g()), new Class[]{Uri.class, Integer.TYPE});
                this.e = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(com.baidu.b.a.d.h()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception e) {
            }
        }
    }

    public e() {
        super("upc", 9000000L);
        this.aei = new f();
        this.aei.a();
    }

    private a a(String str, int i, List<c.a> list, int i2, C0092e c0092e) {
        for (c.a aVar : list) {
            if (a(str, i, aVar.ael, i2, c0092e)) {
                aVar.a();
                return aVar.ael;
            }
        }
        return null;
    }

    private String a(String str) {
        return str + ".cesium";
    }

    private String a(String str, int i, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", a(str), Integer.valueOf(i), aVar.a());
    }

    private String a(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", a(str), aVar.a());
    }

    private boolean a(String str, int i, a aVar, int i2, C0092e c0092e) {
        int i3;
        Uri parse = Uri.parse(a(str, i, aVar));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            if (c0092e != null) {
                try {
                    c0092e.f1254a++;
                } catch (Throwable th) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception e) {
                    }
                    i4++;
                }
            }
            i3 = this.aei.a(this.d, parse, 0, i2, 1);
            break;
        }
        if (i3 == 0) {
            return true;
        }
        if (c0092e != null) {
            c0092e.b++;
        }
        return false;
    }

    private boolean a(String str, a aVar, int i) {
        int i2;
        Uri parse = Uri.parse(a(str, aVar));
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                i2 = -1;
                break;
            }
            try {
                i2 = this.aei.a(this.d, parse, 0, i, 1);
                break;
            } catch (Throwable th) {
                try {
                    Thread.sleep(5L);
                } catch (Exception e) {
                }
                i3++;
            }
        }
        return i2 == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019c  */
    @Override // com.baidu.b.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a.e a(String str, a.d dVar) {
        Byte b2;
        Byte b3;
        boolean z;
        byte[] bArr;
        if (Build.VERSION.SDK_INT < 26) {
            return a.e.sL();
        }
        int i = -1;
        try {
            i = this.d.getPackageManager().getPackageUid(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (i < 0) {
            return a.e.sL();
        }
        C0092e c0092e = new C0092e();
        b bVar = new b();
        c cVar = new c();
        c cVar2 = new c();
        for (int i2 = 0; i2 < 16; i2++) {
            a bo = a.bo(i2);
            if (a(str, bo, i)) {
                cVar.b(bo);
            } else {
                cVar2.b(bo);
            }
        }
        for (int i3 = 0; i3 < 32; i3++) {
            a a2 = a(str, i3, cVar.a(), i, c0092e);
            if (a2 == null) {
                a2 = a(str, i3, cVar2.a(), i, c0092e);
            }
            if (a2 == null) {
                return a.e.sL();
            }
            bVar.b(a2);
        }
        byte[] b4 = bVar.b();
        byte[] bArr2 = {"0".getBytes()[0], "O".getBytes()[0], ExifInterface.GPS_MEASUREMENT_INTERRUPTED.getBytes()[0]};
        int length = bArr2.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                b2 = null;
                break;
            }
            byte b5 = bArr2[i5];
            a a3 = a.a(b5, false);
            if (a(str, 32, a3, i, c0092e)) {
                a a4 = a.a(b5, true);
                if (a(str, 33, a4, i, c0092e)) {
                    b bVar2 = new b();
                    bVar2.b(a3);
                    bVar2.b(a4);
                    b2 = Byte.valueOf(bVar2.b()[0]);
                    break;
                }
            }
            i4 = i5 + 1;
        }
        if (b2 == null) {
            b bVar3 = new b();
            for (int i6 = 32; i6 < 34; i6++) {
                a a5 = a(str, i6, cVar.a(), i, c0092e);
                if (a5 == null) {
                    a5 = a(str, i6, cVar2.a(), i, c0092e);
                }
                if (a5 == null) {
                    return a.e.sL();
                }
                bVar3.b(a5);
            }
            b3 = Byte.valueOf(bVar3.b()[0]);
            z = true;
        } else {
            b3 = b2;
            z = false;
        }
        if (z) {
            b bVar4 = new b();
            for (int i7 = 34; i7 < 94; i7++) {
                a a6 = a(str, i7, cVar.a(), i, c0092e);
                if (a6 == null) {
                    a6 = a(str, i7, cVar2.a(), i, c0092e);
                }
                if (a6 == null) {
                    break;
                }
                bVar4.b(a6);
            }
            if (bVar4.a() > 0) {
                bArr = bVar4.b();
                d dVar2 = new d(b4, b3.byteValue(), bArr);
                return dVar2 != null ? a.e.sL() : a.e.a(dVar2.a());
            }
        }
        bArr = null;
        d dVar22 = new d(b4, b3.byteValue(), bArr);
        if (dVar22 != null) {
        }
    }

    @Override // com.baidu.b.b.a
    public void a(a.c cVar) {
        this.d = this.adU.f1248a;
    }
}
