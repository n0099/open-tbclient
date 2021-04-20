package com.baidu.mobads.cid.cesium.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.cid.cesium.a.e;
import com.baidu.mobads.cid.cesium.b.a;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.cid.cesium.g;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.mobads.cid.cesium.b.a {

    /* renamed from: d  reason: collision with root package name */
    public Context f8091d;

    /* renamed from: e  reason: collision with root package name */
    public f f8092e;

    /* renamed from: f  reason: collision with root package name */
    public a.C0105a f8093f;

    /* loaded from: classes2.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f8094a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        /* renamed from: b  reason: collision with root package name */
        public final int f8095b;

        public a(int i) {
            this.f8095b = i;
        }

        public static a a(byte b2, boolean z) {
            int i = b2 & 255;
            return a(z ? i >> 4 : i & 15);
        }

        public static a a(int i) {
            if (i < 0 || i >= 16) {
                throw new IllegalArgumentException("invalid idx " + i);
            }
            return new a(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.f8095b - aVar.f8095b;
        }

        public String a() {
            return f8094a[this.f8095b];
        }

        public byte b() {
            return (byte) this.f8095b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && this.f8095b == ((a) obj).f8095b;
        }

        public int hashCode() {
            return this.f8095b;
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public int f8097b = 33;

        /* renamed from: c  reason: collision with root package name */
        public a[] f8098c = new a[33];

        /* renamed from: d  reason: collision with root package name */
        public int f8099d;

        public b() {
        }

        private void b(int i) {
            a[] aVarArr = this.f8098c;
            if (i - aVarArr.length > 0) {
                int length = aVarArr.length;
                int i2 = length + (length >> 1);
                if (i2 - i >= 0) {
                    i = i2;
                }
                this.f8098c = (a[]) Arrays.copyOf(this.f8098c, i);
            }
        }

        public int a() {
            return this.f8099d;
        }

        public a a(int i) {
            if (i < this.f8099d) {
                return this.f8098c[i];
            }
            throw new IndexOutOfBoundsException("idx " + i + " size " + this.f8099d);
        }

        public void a(a aVar) {
            b(this.f8099d + 1);
            a[] aVarArr = this.f8098c;
            int i = this.f8099d;
            this.f8099d = i + 1;
            aVarArr[i] = aVar;
        }

        public byte[] b() {
            int i;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (true) {
                i = this.f8099d;
                if (i2 >= i / 2) {
                    break;
                }
                int i3 = i2 * 2;
                byteArrayOutputStream.write((byte) (((a(i3 + 1).b() & 255) << 4) | (a(i3).b() & 255)));
                i2++;
            }
            if (i % 2 != 0) {
                byteArrayOutputStream.write((byte) (a(i - 1).b() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<a> f8100a = new ArrayList();

        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f8102a;

            /* renamed from: b  reason: collision with root package name */
            public a f8103b;

            public a(a aVar) {
                this.f8103b = aVar;
            }

            public void a() {
                this.f8102a++;
            }
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.f8100a);
            Collections.sort(arrayList, new Comparator<a>() { // from class: com.baidu.mobads.cid.cesium.b.d.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(a aVar, a aVar2) {
                    return aVar.f8102a - aVar2.f8102a;
                }
            });
            return arrayList;
        }

        public void a(a aVar) {
            this.f8100a.add(new a(aVar));
        }
    }

    /* renamed from: com.baidu.mobads.cid.cesium.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0104d {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f8104a;

        /* renamed from: b  reason: collision with root package name */
        public byte f8105b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f8106c;

        public C0104d(byte[] bArr, byte b2, byte[] bArr2) {
            this.f8104a = bArr;
            this.f8105b = b2;
            this.f8106c = bArr2;
        }

        public g.a a() {
            try {
                return com.baidu.mobads.cid.cesium.g.a(com.baidu.mobads.cid.cesium.d.b.a(this.f8104a, "", true), new String(new byte[]{this.f8105b}, "UTF-8"), this.f8106c != null ? new String(this.f8106c, "UTF-8") : null);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f8107a;

        /* renamed from: b  reason: collision with root package name */
        public int f8108b;

        /* renamed from: c  reason: collision with root package name */
        public int f8109c = 16;

        public String toString() {
            return "";
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Method f8110a;

        /* renamed from: b  reason: collision with root package name */
        public Method f8111b;

        /* renamed from: c  reason: collision with root package name */
        public Method f8112c;

        /* renamed from: d  reason: collision with root package name */
        public Method f8113d;

        /* renamed from: e  reason: collision with root package name */
        public Method f8114e;

        public int a(Context context, Uri uri, int i, int i2, int i3) {
            try {
                return ((Integer) this.f8110a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
            } catch (Exception e2) {
                throw new e.a(e2);
            }
        }

        public void a() {
            try {
                this.f8110a = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.d()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.f8111b = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.e()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.f8112c = com.baidu.mobads.cid.cesium.a.e.a(ContentResolver.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.f()), new Class[]{Uri.class, Integer.TYPE});
                this.f8113d = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.g()), new Class[]{Uri.class, Integer.TYPE});
                this.f8114e = com.baidu.mobads.cid.cesium.a.e.a(ContentResolver.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.h()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends a.b {

        /* renamed from: b  reason: collision with root package name */
        public int f8116b;

        /* renamed from: c  reason: collision with root package name */
        public String f8117c;

        /* renamed from: d  reason: collision with root package name */
        public long f8118d;

        /* renamed from: e  reason: collision with root package name */
        public long f8119e;

        /* renamed from: f  reason: collision with root package name */
        public g.a f8120f;

        public g(String str) {
            super(d.this.f8093f, str);
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            this.f8117c = jSONObject.getString("pkg");
            this.f8118d = jSONObject.getLong("last_fe_ts");
            this.f8120f = com.baidu.mobads.cid.cesium.g.a(jSONObject.getString("info"));
            this.f8119e = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.f8116b = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.f8118d != j) {
                this.f8118d = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean a(g.a aVar) {
            if (aVar.equals(this.f8120f)) {
                return false;
            }
            this.f8120f = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.f8117c)) {
                return false;
            }
            this.f8117c = str;
            a(true);
            return true;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void b(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f8117c);
            jSONObject.put("last_fe_ts", this.f8118d);
            jSONObject.put("info", this.f8120f.b());
            jSONObject.put("tar_pkg_lst_up_ts", this.f8119e);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.f8119e != j) {
                this.f8119e = j;
                a(true);
                return true;
            }
            return false;
        }

        public String c() {
            return this.f8117c;
        }

        public g.a d() {
            return this.f8120f;
        }

        public long e() {
            return this.f8119e;
        }
    }

    public d() {
        super("upc", 9000000L);
        f fVar = new f();
        this.f8092e = fVar;
        fVar.a();
    }

    private a a(String str, int i, List<c.a> list, int i2, e eVar) {
        for (c.a aVar : list) {
            if (a(str, i, aVar.f8103b, i2, eVar)) {
                aVar.a();
                return aVar.f8103b;
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

    private boolean a(String str, int i, a aVar, int i2, e eVar) {
        int i3;
        Uri parse = Uri.parse(a(str, i, aVar));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            if (eVar != null) {
                try {
                    eVar.f8107a++;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i4++;
                }
            }
            i3 = this.f8092e.a(this.f8091d, parse, 0, i2, 1);
            break;
        }
        if (i3 == 0) {
            return true;
        }
        if (eVar != null) {
            eVar.f8108b++;
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
                i2 = this.f8092e.a(this.f8091d, parse, 0, i, 1);
                break;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5L);
                } catch (Exception unused2) {
                }
                i3++;
            }
        }
        return i2 == 0;
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public a.e a(String str, a.d dVar) {
        PackageInfo packageInfo;
        g gVar;
        Byte b2;
        boolean z;
        Byte b3;
        byte[] bArr;
        g.a a2;
        b bVar;
        g.a d2;
        if (Build.VERSION.SDK_INT < 26) {
            return a.e.b();
        }
        boolean z2 = false;
        try {
            packageInfo = this.f8091d.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.e.b();
        }
        if (dVar.f8069a) {
            g gVar2 = new g(str);
            gVar2.a();
            if (str.equals(gVar2.c()) && packageInfo.lastUpdateTime == gVar2.e() && (d2 = gVar2.d()) != null) {
                return a.e.a(d2);
            }
            gVar = gVar2;
        } else {
            gVar = null;
        }
        e eVar = new e();
        b bVar2 = new b();
        c cVar = new c();
        c cVar2 = new c();
        int i = packageInfo.applicationInfo.uid;
        for (int i2 = 0; i2 < 16; i2++) {
            a a3 = a.a(i2);
            if (a(str, a3, i)) {
                cVar.a(a3);
            } else {
                cVar2.a(a3);
            }
        }
        int i3 = 0;
        while (i3 < 32) {
            int i4 = i3;
            int i5 = i;
            c cVar3 = cVar2;
            a a4 = a(str, i3, cVar.a(), i, eVar);
            if (a4 == null) {
                a4 = a(str, i4, cVar3.a(), i5, eVar);
            }
            if (a4 == null) {
                return a.e.b();
            }
            bVar2.a(a4);
            i3 = i4 + 1;
            i = i5;
            cVar2 = cVar3;
        }
        int i6 = i;
        c cVar4 = cVar2;
        byte[] b4 = bVar2.b();
        int i7 = 3;
        byte[] bArr2 = {"0".getBytes()[0], "O".getBytes()[0], ExifInterface.GPS_MEASUREMENT_INTERRUPTED.getBytes()[0]};
        int i8 = 0;
        while (true) {
            if (i8 >= i7) {
                b2 = null;
                break;
            }
            byte b5 = bArr2[i8];
            a a5 = a.a(b5, z2);
            int i9 = i8;
            byte[] bArr3 = bArr2;
            if (a(str, 32, a5, i6, eVar)) {
                a a6 = a.a(b5, true);
                if (a(str, 33, a6, i6, eVar)) {
                    b bVar3 = new b();
                    bVar3.a(a5);
                    bVar3.a(a6);
                    b2 = Byte.valueOf(bVar3.b()[0]);
                    break;
                }
            }
            i8 = i9 + 1;
            bArr2 = bArr3;
            i7 = 3;
            z2 = false;
        }
        int i10 = 34;
        if (b2 == null) {
            b bVar4 = new b();
            int i11 = 32;
            while (i11 < 34) {
                int i12 = i11;
                a a7 = a(str, i11, cVar.a(), i6, eVar);
                if (a7 == null) {
                    a7 = a(str, i12, cVar4.a(), i6, eVar);
                }
                if (a7 == null) {
                    return a.e.b();
                }
                bVar4.a(a7);
                i11 = i12 + 1;
            }
            b3 = Byte.valueOf(bVar4.b()[0]);
            z = true;
        } else {
            z = false;
            b3 = b2;
        }
        if (z) {
            b bVar5 = new b();
            while (true) {
                if (i10 >= 94) {
                    bVar = bVar5;
                    break;
                }
                bVar = bVar5;
                a a8 = a(str, i10, cVar.a(), i6, eVar);
                if (a8 == null) {
                    a8 = a(str, i10, cVar4.a(), i6, eVar);
                }
                if (a8 == null) {
                    break;
                }
                bVar.a(a8);
                i10++;
                bVar5 = bVar;
            }
            if (bVar.a() > 0) {
                bArr = bVar.b();
                a2 = new C0104d(b4, b3.byteValue(), bArr).a();
                if (dVar.f8069a && gVar != null) {
                    gVar.a(System.currentTimeMillis());
                    gVar.b(packageInfo.lastUpdateTime);
                    gVar.a(str);
                    gVar.a(a2);
                    gVar.b();
                }
                return a.e.a(a2);
            }
        }
        bArr = null;
        a2 = new C0104d(b4, b3.byteValue(), bArr).a();
        if (dVar.f8069a) {
            gVar.a(System.currentTimeMillis());
            gVar.b(packageInfo.lastUpdateTime);
            gVar.a(str);
            gVar.a(a2);
            gVar.b();
        }
        return a.e.a(a2);
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public void a(a.c cVar) {
        this.f8091d = this.f8059a.f8063a;
        this.f8093f = this.f8060b.a("upc");
    }
}
