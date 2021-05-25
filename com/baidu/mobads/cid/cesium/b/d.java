package com.baidu.mobads.cid.cesium.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
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
    public Context f8094d;

    /* renamed from: e  reason: collision with root package name */
    public f f8095e;

    /* renamed from: f  reason: collision with root package name */
    public a.C0106a f8096f;

    /* loaded from: classes2.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f8097a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        /* renamed from: b  reason: collision with root package name */
        public final int f8098b;

        public a(int i2) {
            this.f8098b = i2;
        }

        public static a a(byte b2, boolean z) {
            int i2 = b2 & 255;
            return a(z ? i2 >> 4 : i2 & 15);
        }

        public static a a(int i2) {
            if (i2 < 0 || i2 >= 16) {
                throw new IllegalArgumentException("invalid idx " + i2);
            }
            return new a(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.f8098b - aVar.f8098b;
        }

        public String a() {
            return f8097a[this.f8098b];
        }

        public byte b() {
            return (byte) this.f8098b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && this.f8098b == ((a) obj).f8098b;
        }

        public int hashCode() {
            return this.f8098b;
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public int f8100b = 33;

        /* renamed from: c  reason: collision with root package name */
        public a[] f8101c = new a[33];

        /* renamed from: d  reason: collision with root package name */
        public int f8102d;

        public b() {
        }

        private void b(int i2) {
            a[] aVarArr = this.f8101c;
            if (i2 - aVarArr.length > 0) {
                int length = aVarArr.length;
                int i3 = length + (length >> 1);
                if (i3 - i2 >= 0) {
                    i2 = i3;
                }
                this.f8101c = (a[]) Arrays.copyOf(this.f8101c, i2);
            }
        }

        public int a() {
            return this.f8102d;
        }

        public a a(int i2) {
            if (i2 < this.f8102d) {
                return this.f8101c[i2];
            }
            throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f8102d);
        }

        public void a(a aVar) {
            b(this.f8102d + 1);
            a[] aVarArr = this.f8101c;
            int i2 = this.f8102d;
            this.f8102d = i2 + 1;
            aVarArr[i2] = aVar;
        }

        public byte[] b() {
            int i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            while (true) {
                i2 = this.f8102d;
                if (i3 >= i2 / 2) {
                    break;
                }
                int i4 = i3 * 2;
                byteArrayOutputStream.write((byte) (((a(i4 + 1).b() & 255) << 4) | (a(i4).b() & 255)));
                i3++;
            }
            if (i2 % 2 != 0) {
                byteArrayOutputStream.write((byte) (a(i2 - 1).b() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<a> f8103a = new ArrayList();

        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f8105a;

            /* renamed from: b  reason: collision with root package name */
            public a f8106b;

            public a(a aVar) {
                this.f8106b = aVar;
            }

            public void a() {
                this.f8105a++;
            }
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.f8103a);
            Collections.sort(arrayList, new Comparator<a>() { // from class: com.baidu.mobads.cid.cesium.b.d.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(a aVar, a aVar2) {
                    return aVar.f8105a - aVar2.f8105a;
                }
            });
            return arrayList;
        }

        public void a(a aVar) {
            this.f8103a.add(new a(aVar));
        }
    }

    /* renamed from: com.baidu.mobads.cid.cesium.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0105d {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f8107a;

        /* renamed from: b  reason: collision with root package name */
        public byte f8108b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f8109c;

        public C0105d(byte[] bArr, byte b2, byte[] bArr2) {
            this.f8107a = bArr;
            this.f8108b = b2;
            this.f8109c = bArr2;
        }

        public g.a a() {
            try {
                return com.baidu.mobads.cid.cesium.g.a(com.baidu.mobads.cid.cesium.d.b.a(this.f8107a, "", true), new String(new byte[]{this.f8108b}, "UTF-8"), this.f8109c != null ? new String(this.f8109c, "UTF-8") : null);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f8110a;

        /* renamed from: b  reason: collision with root package name */
        public int f8111b;

        /* renamed from: c  reason: collision with root package name */
        public int f8112c = 16;

        public String toString() {
            return "";
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Method f8113a;

        /* renamed from: b  reason: collision with root package name */
        public Method f8114b;

        /* renamed from: c  reason: collision with root package name */
        public Method f8115c;

        /* renamed from: d  reason: collision with root package name */
        public Method f8116d;

        /* renamed from: e  reason: collision with root package name */
        public Method f8117e;

        public int a(Context context, Uri uri, int i2, int i3, int i4) {
            try {
                return ((Integer) this.f8113a.invoke(context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))).intValue();
            } catch (Exception e2) {
                throw new e.a(e2);
            }
        }

        public void a() {
            try {
                this.f8113a = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.d()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.f8114b = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.e()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.f8115c = com.baidu.mobads.cid.cesium.a.e.a(ContentResolver.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.f()), new Class[]{Uri.class, Integer.TYPE});
                this.f8116d = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.g()), new Class[]{Uri.class, Integer.TYPE});
                this.f8117e = com.baidu.mobads.cid.cesium.a.e.a(ContentResolver.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.h()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends a.b {

        /* renamed from: b  reason: collision with root package name */
        public int f8119b;

        /* renamed from: c  reason: collision with root package name */
        public String f8120c;

        /* renamed from: d  reason: collision with root package name */
        public long f8121d;

        /* renamed from: e  reason: collision with root package name */
        public long f8122e;

        /* renamed from: f  reason: collision with root package name */
        public g.a f8123f;

        public g(String str) {
            super(d.this.f8096f, str);
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            this.f8120c = jSONObject.getString("pkg");
            this.f8121d = jSONObject.getLong("last_fe_ts");
            this.f8123f = com.baidu.mobads.cid.cesium.g.a(jSONObject.getString("info"));
            this.f8122e = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.f8119b = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.f8121d != j) {
                this.f8121d = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean a(g.a aVar) {
            if (aVar.equals(this.f8123f)) {
                return false;
            }
            this.f8123f = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.f8120c)) {
                return false;
            }
            this.f8120c = str;
            a(true);
            return true;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void b(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f8120c);
            jSONObject.put("last_fe_ts", this.f8121d);
            jSONObject.put("info", this.f8123f.b());
            jSONObject.put("tar_pkg_lst_up_ts", this.f8122e);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.f8122e != j) {
                this.f8122e = j;
                a(true);
                return true;
            }
            return false;
        }

        public String c() {
            return this.f8120c;
        }

        public g.a d() {
            return this.f8123f;
        }

        public long e() {
            return this.f8122e;
        }
    }

    public d() {
        super("upc", 9000000L);
        f fVar = new f();
        this.f8095e = fVar;
        fVar.a();
    }

    private a a(String str, int i2, List<c.a> list, int i3, e eVar) {
        for (c.a aVar : list) {
            if (a(str, i2, aVar.f8106b, i3, eVar)) {
                aVar.a();
                return aVar.f8106b;
            }
        }
        return null;
    }

    private String a(String str) {
        return str + ".cesium";
    }

    private String a(String str, int i2, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", a(str), Integer.valueOf(i2), aVar.a());
    }

    private String a(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", a(str), aVar.a());
    }

    private boolean a(String str, int i2, a aVar, int i3, e eVar) {
        int i4;
        Uri parse = Uri.parse(a(str, i2, aVar));
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                i4 = -1;
                break;
            }
            if (eVar != null) {
                try {
                    eVar.f8110a++;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i5++;
                }
            }
            i4 = this.f8095e.a(this.f8094d, parse, 0, i3, 1);
            break;
        }
        if (i4 == 0) {
            return true;
        }
        if (eVar != null) {
            eVar.f8111b++;
        }
        return false;
    }

    private boolean a(String str, a aVar, int i2) {
        int i3;
        Uri parse = Uri.parse(a(str, aVar));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            try {
                i3 = this.f8095e.a(this.f8094d, parse, 0, i2, 1);
                break;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5L);
                } catch (Exception unused2) {
                }
                i4++;
            }
        }
        return i3 == 0;
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
            packageInfo = this.f8094d.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.e.b();
        }
        if (dVar.f8072a) {
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
        int i2 = packageInfo.applicationInfo.uid;
        for (int i3 = 0; i3 < 16; i3++) {
            a a3 = a.a(i3);
            if (a(str, a3, i2)) {
                cVar.a(a3);
            } else {
                cVar2.a(a3);
            }
        }
        int i4 = 0;
        while (i4 < 32) {
            int i5 = i4;
            int i6 = i2;
            c cVar3 = cVar2;
            a a4 = a(str, i4, cVar.a(), i2, eVar);
            if (a4 == null) {
                a4 = a(str, i5, cVar3.a(), i6, eVar);
            }
            if (a4 == null) {
                return a.e.b();
            }
            bVar2.a(a4);
            i4 = i5 + 1;
            i2 = i6;
            cVar2 = cVar3;
        }
        int i7 = i2;
        c cVar4 = cVar2;
        byte[] b4 = bVar2.b();
        int i8 = 3;
        byte[] bArr2 = {"0".getBytes()[0], "O".getBytes()[0], "V".getBytes()[0]};
        int i9 = 0;
        while (true) {
            if (i9 >= i8) {
                b2 = null;
                break;
            }
            byte b5 = bArr2[i9];
            a a5 = a.a(b5, z2);
            int i10 = i9;
            byte[] bArr3 = bArr2;
            if (a(str, 32, a5, i7, eVar)) {
                a a6 = a.a(b5, true);
                if (a(str, 33, a6, i7, eVar)) {
                    b bVar3 = new b();
                    bVar3.a(a5);
                    bVar3.a(a6);
                    b2 = Byte.valueOf(bVar3.b()[0]);
                    break;
                }
            }
            i9 = i10 + 1;
            bArr2 = bArr3;
            i8 = 3;
            z2 = false;
        }
        int i11 = 34;
        if (b2 == null) {
            b bVar4 = new b();
            int i12 = 32;
            while (i12 < 34) {
                int i13 = i12;
                a a7 = a(str, i12, cVar.a(), i7, eVar);
                if (a7 == null) {
                    a7 = a(str, i13, cVar4.a(), i7, eVar);
                }
                if (a7 == null) {
                    return a.e.b();
                }
                bVar4.a(a7);
                i12 = i13 + 1;
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
                if (i11 >= 94) {
                    bVar = bVar5;
                    break;
                }
                bVar = bVar5;
                a a8 = a(str, i11, cVar.a(), i7, eVar);
                if (a8 == null) {
                    a8 = a(str, i11, cVar4.a(), i7, eVar);
                }
                if (a8 == null) {
                    break;
                }
                bVar.a(a8);
                i11++;
                bVar5 = bVar;
            }
            if (bVar.a() > 0) {
                bArr = bVar.b();
                a2 = new C0105d(b4, b3.byteValue(), bArr).a();
                if (dVar.f8072a && gVar != null) {
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
        a2 = new C0105d(b4, b3.byteValue(), bArr).a();
        if (dVar.f8072a) {
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
        this.f8094d = this.f8062a.f8066a;
        this.f8096f = this.f8063b.a("upc");
    }
}
