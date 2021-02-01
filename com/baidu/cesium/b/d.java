package com.baidu.cesium.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.baidu.cesium.a.i;
import com.baidu.cesium.b.a;
import com.baidu.cesium.g;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class d extends com.baidu.cesium.b.a {
    private g amX;
    private Context g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f1623a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        /* renamed from: b  reason: collision with root package name */
        private final int f1624b;

        private a(int i) {
            this.f1624b = i;
        }

        public static a a(byte b2, boolean z) {
            int i = b2 & 255;
            return z ? bH(i >> 4) : bH(i & 15);
        }

        public static a bH(int i) {
            if (i < 0 || i >= 16) {
                throw new IllegalArgumentException("invalid idx " + i);
            }
            return new a(i);
        }

        public String a() {
            return f1623a[this.f1624b];
        }

        public byte b() {
            return (byte) this.f1624b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: b */
        public int compareTo(a aVar) {
            return this.f1624b - aVar.f1624b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f1624b == ((a) obj).f1624b;
        }

        public int hashCode() {
            return this.f1624b;
        }
    }

    /* loaded from: classes5.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        private Map<a, Integer> f1625a = new HashMap();

        b() {
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.f1625a.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<a, Integer>>() { // from class: com.baidu.cesium.b.d.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(Map.Entry<a, Integer> entry, Map.Entry<a, Integer> entry2) {
                    int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                    return intValue != 0 ? intValue : entry.getKey().compareTo(entry2.getKey());
                }
            });
            ArrayList arrayList2 = new ArrayList(6);
            int min = Math.min(6, arrayList.size());
            for (int i = 0; i < min; i++) {
                Map.Entry entry = (Map.Entry) arrayList.get(i);
                if (((Integer) entry.getValue()).intValue() > 1) {
                    arrayList2.add(entry.getKey());
                }
            }
            return arrayList2;
        }

        public void c(a aVar) {
            Integer num = this.f1625a.get(aVar);
            this.f1625a.put(aVar, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c {
        private a[] amZ;

        /* renamed from: b  reason: collision with root package name */
        private int f1626b;
        private int d;

        public c() {
            this.f1626b = 33;
            this.amZ = new a[this.f1626b];
        }

        public c(byte[] bArr) {
            this.f1626b = 33;
            this.amZ = new a[this.f1626b];
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            for (int i = 0; i < bArr.length; i++) {
                a a2 = a.a(bArr[i], false);
                a a3 = a.a(bArr[i], true);
                c(a2);
                c(a3);
            }
        }

        private void b(int i) {
            if (i - this.amZ.length > 0) {
                int length = this.amZ.length;
                int i2 = length + (length >> 1);
                if (i2 - i >= 0) {
                    i = i2;
                }
                this.amZ = (a[]) Arrays.copyOf(this.amZ, i);
            }
        }

        public int a() {
            return this.d;
        }

        public byte[] b() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < this.d / 2; i++) {
                byteArrayOutputStream.write((byte) ((bH(i * 2).b() & 255) | ((bH((i * 2) + 1).b() & 255) << 4)));
            }
            if (this.d % 2 != 0) {
                byteArrayOutputStream.write((byte) (bH(this.d - 1).b() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }

        public a bH(int i) {
            if (i >= this.d) {
                throw new IndexOutOfBoundsException("idx " + i + " size " + this.d);
            }
            return this.amZ[i];
        }

        public void c(a aVar) {
            b(this.d + 1);
            a[] aVarArr = this.amZ;
            int i = this.d;
            this.d = i + 1;
            aVarArr[i] = aVar;
        }
    }

    /* renamed from: com.baidu.cesium.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static class C0092d {

        /* renamed from: a  reason: collision with root package name */
        private List<a> f1627a = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.cesium.b.d$d$a */
        /* loaded from: classes5.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f1628a;
            private a anc;

            public a(a aVar) {
                this.anc = aVar;
            }

            public void a() {
                this.f1628a++;
            }
        }

        C0092d() {
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.f1627a);
            Collections.sort(arrayList, new Comparator<a>() { // from class: com.baidu.cesium.b.d.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(a aVar, a aVar2) {
                    return aVar.f1628a - aVar2.f1628a;
                }
            });
            return arrayList;
        }

        public void c(a aVar) {
            this.f1627a.add(new a(aVar));
        }
    }

    /* loaded from: classes5.dex */
    static class e {

        /* renamed from: a  reason: collision with root package name */
        byte[] f1629a;

        /* renamed from: b  reason: collision with root package name */
        byte f1630b;
        byte[] c;

        public e(byte[] bArr, byte b2, byte[] bArr2) {
            this.f1629a = bArr;
            this.f1630b = b2;
            this.c = bArr2;
        }

        public static e f(g.a aVar) {
            try {
                byte[] b2 = d.b(aVar.b());
                if (b2.length > 16) {
                    return null;
                }
                return new e(b2, aVar.d().getBytes("UTF-8")[0], aVar.c() != null ? aVar.c().getBytes("UTF-8") : null);
            } catch (Exception e) {
                return null;
            }
        }

        public g.a tJ() {
            try {
                return com.baidu.cesium.g.k(com.baidu.cesium.d.b.a(this.f1629a, "", true), new String(new byte[]{this.f1630b}, "UTF-8"), this.c != null ? new String(this.c, "UTF-8") : null);
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f1631a;

        /* renamed from: b  reason: collision with root package name */
        public int f1632b;
        public int c = 16;

        f() {
        }

        public String toString() {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        private Method f1633a;

        /* renamed from: b  reason: collision with root package name */
        private Method f1634b;
        private Method c;
        private Method d;
        private Method e;

        g() {
        }

        public int a(Context context, Uri uri, int i, int i2, int i3) {
            try {
                return ((Integer) this.f1633a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
            } catch (Exception e) {
                throw new i.a(e);
            }
        }

        void a() {
            try {
                this.f1633a = i.a(Context.class, i.a(com.baidu.cesium.a.d.tE()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.f1634b = i.a(Context.class, i.a(com.baidu.cesium.a.d.tF()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.c = i.a(ContentResolver.class, i.a(com.baidu.cesium.a.d.f()), new Class[]{Uri.class, Integer.TYPE});
                this.d = i.a(Context.class, i.a(com.baidu.cesium.a.d.g()), new Class[]{Uri.class, Integer.TYPE});
                this.e = i.a(ContentResolver.class, i.a(com.baidu.cesium.a.d.h()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception e) {
            }
        }

        public void a(ContentResolver contentResolver, Uri uri, int i) {
            try {
                this.c.invoke(contentResolver, uri, Integer.valueOf(i));
            } catch (Exception e) {
                throw new i.a(e);
            }
        }

        public void a(Context context, Uri uri, int i) {
            try {
                this.d.invoke(context, uri, Integer.valueOf(i));
            } catch (Exception e) {
                throw new i.a(e);
            }
        }

        public void a(Context context, String str, Uri uri, int i) {
            try {
                this.f1634b.invoke(context, str, uri, Integer.valueOf(i));
            } catch (Exception e) {
                throw new i.a(e);
            }
        }

        public void b(ContentResolver contentResolver, Uri uri, int i) {
            try {
                this.e.invoke(contentResolver, uri, Integer.valueOf(i));
            } catch (Exception e) {
                throw new i.a(e);
            }
        }
    }

    public d() {
        super("upc", 9000000L);
        this.amX = new g();
        this.amX.a();
    }

    private a a(String str, int i, List<C0092d.a> list, int i2, f fVar) {
        for (C0092d.a aVar : list) {
            if (a(str, i, aVar.anc, i2, fVar)) {
                aVar.a();
                return aVar.anc;
            }
        }
        return null;
    }

    private String a(String str, int i, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", c(str), Integer.valueOf(i), aVar.a());
    }

    private String a(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", c(str), aVar.a());
    }

    private void a(UriMatcher uriMatcher) {
        uriMatcher.addURI(c(this.g.getPackageName()), "dat/v1/*/*", 1);
        uriMatcher.addURI(c(this.g.getPackageName()), "dic/v1/*", 2);
    }

    private boolean a(int i, a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return a(Uri.parse(a(this.g.getPackageName(), i, aVar)));
    }

    private boolean a(Uri uri) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.g;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.amX.a(context, context.getPackageName(), uri, 65);
            this.amX.a(contentResolver, uri, 1);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean a(Uri uri, int i) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.g;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.amX.a(context, uri, i);
            this.amX.b(contentResolver, uri, i);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean a(a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return a(Uri.parse(a(this.g.getPackageName(), aVar)));
    }

    private boolean a(c cVar, List<a> list) {
        int i;
        boolean z;
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        ContentResolver contentResolver = this.g.getContentResolver();
        UriMatcher uriMatcher = new UriMatcher(-1);
        a(uriMatcher);
        List<UriPermission> persistedUriPermissions = contentResolver.getPersistedUriPermissions();
        if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
            persistedUriPermissions = contentResolver.getOutgoingPersistedUriPermissions();
        }
        if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
            return true;
        }
        for (UriPermission uriPermission : persistedUriPermissions) {
            Uri uri = uriPermission.getUri();
            int match = uriMatcher.match(uri);
            List<String> pathSegments = uri.getPathSegments();
            if ((match == 1 || match == 2) && uriPermission.isWritePermission()) {
                a(uri, uriPermission.isReadPermission() ? 3 : 2);
            } else if (match == 1) {
                try {
                    i = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                } catch (Exception e2) {
                    i = -1;
                }
                if (i < 0 || i >= cVar.a()) {
                    a(uri, 1);
                } else if (!cVar.bH(i).a().equals(pathSegments.get(3))) {
                    a(uri, 1);
                }
            } else if (match == 2) {
                String str = pathSegments.get(2);
                Iterator<a> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().a().equals(str)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    a(uri, 1);
                }
            }
        }
        int a2 = cVar.a();
        for (int i2 = 0; i2 < a2; i2++) {
            if (!a(this.g.getPackageName(), i2, cVar.bH(i2), Process.myUid(), (f) null)) {
                return true;
            }
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!a(this.g.getPackageName(), list.get(i3), Process.myUid())) {
                return true;
            }
        }
        return false;
    }

    private boolean a(String str, int i, a aVar, int i2, f fVar) {
        int i3;
        Uri parse = Uri.parse(a(str, i, aVar));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            if (fVar != null) {
                try {
                    fVar.f1631a++;
                } catch (Throwable th) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception e2) {
                    }
                    i4++;
                }
            }
            i3 = this.amX.a(this.g, parse, 0, i2, 1);
            break;
        }
        if (i3 == 0) {
            return true;
        }
        if (fVar != null) {
            fVar.f1632b++;
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
                i2 = this.amX.a(this.g, parse, 0, i, 1);
                break;
            } catch (Throwable th) {
                try {
                    Thread.sleep(5L);
                } catch (Exception e2) {
                }
                i3++;
            }
        }
        return i2 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int digit = Character.digit(str.charAt(i * 2), 16);
            int digit2 = Character.digit(str.charAt((i * 2) + 1), 16);
            if (digit == -1 || digit2 == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            bArr[i] = (byte) ((digit * 16) + digit2);
        }
        return bArr;
    }

    private String c(String str) {
        return str + ".cesium";
    }

    @Override // com.baidu.cesium.b.a
    public a.e a(a.d dVar, g.a aVar) {
        e f2;
        if (Build.VERSION.SDK_INT >= 26 && (f2 = e.f(aVar)) != null) {
            c cVar = new c(f2.f1629a);
            cVar.c(a.a(f2.f1630b, false));
            cVar.c(a.a(f2.f1630b, true));
            if (f2.c != null) {
                byte[] bArr = f2.c;
                for (byte b2 : bArr) {
                    cVar.c(a.a(b2, false));
                    cVar.c(a.a(b2, true));
                }
            }
            b bVar = new b();
            for (int i = 0; i < cVar.a(); i++) {
                bVar.c(cVar.bH(i));
            }
            List<a> a2 = bVar.a();
            if (a(cVar, a2)) {
                for (int a3 = cVar.a() - 1; a3 >= 0; a3--) {
                    a(a3, cVar.bH(a3));
                }
                for (a aVar2 : a2) {
                    a(aVar2);
                }
                return a.e.tG();
            }
            return a.e.tG();
        }
        return a.e.tH();
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019c  */
    @Override // com.baidu.cesium.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a.g a(String str, a.f fVar) {
        Byte b2;
        boolean z;
        Byte b3;
        byte[] bArr;
        if (Build.VERSION.SDK_INT < 26) {
            return a.g.tI();
        }
        int i = -1;
        try {
            i = this.g.getPackageManager().getPackageUid(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (i < 0) {
            return a.g.tI();
        }
        f fVar2 = new f();
        c cVar = new c();
        C0092d c0092d = new C0092d();
        C0092d c0092d2 = new C0092d();
        for (int i2 = 0; i2 < 16; i2++) {
            a bH = a.bH(i2);
            if (a(str, bH, i)) {
                c0092d.c(bH);
            } else {
                c0092d2.c(bH);
            }
        }
        for (int i3 = 0; i3 < 32; i3++) {
            a a2 = a(str, i3, c0092d.a(), i, fVar2);
            if (a2 == null) {
                a2 = a(str, i3, c0092d2.a(), i, fVar2);
            }
            if (a2 == null) {
                return a.g.tI();
            }
            cVar.c(a2);
        }
        byte[] b4 = cVar.b();
        byte[] bArr2 = {"0".getBytes()[0], "O".getBytes()[0], "V".getBytes()[0]};
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
            if (a(str, 32, a3, i, fVar2)) {
                a a4 = a.a(b5, true);
                if (a(str, 33, a4, i, fVar2)) {
                    c cVar2 = new c();
                    cVar2.c(a3);
                    cVar2.c(a4);
                    b2 = Byte.valueOf(cVar2.b()[0]);
                    break;
                }
            }
            i4 = i5 + 1;
        }
        if (b2 == null) {
            c cVar3 = new c();
            for (int i6 = 32; i6 < 34; i6++) {
                a a5 = a(str, i6, c0092d.a(), i, fVar2);
                if (a5 == null) {
                    a5 = a(str, i6, c0092d2.a(), i, fVar2);
                }
                if (a5 == null) {
                    return a.g.tI();
                }
                cVar3.c(a5);
            }
            z = true;
            b3 = Byte.valueOf(cVar3.b()[0]);
        } else {
            z = false;
            b3 = b2;
        }
        if (z) {
            c cVar4 = new c();
            for (int i7 = 34; i7 < 94; i7++) {
                a a6 = a(str, i7, c0092d.a(), i, fVar2);
                if (a6 == null) {
                    a6 = a(str, i7, c0092d2.a(), i, fVar2);
                }
                if (a6 == null) {
                    break;
                }
                cVar4.c(a6);
            }
            if (cVar4.a() > 0) {
                bArr = cVar4.b();
                e eVar = new e(b4, b3.byteValue(), bArr);
                return eVar != null ? a.g.tI() : a.g.d(eVar.tJ());
            }
        }
        bArr = null;
        e eVar2 = new e(b4, b3.byteValue(), bArr);
        if (eVar2 != null) {
        }
    }

    @Override // com.baidu.cesium.b.a
    public void a(a.c cVar) {
        this.g = this.amK.f1618a;
    }
}
