package com.baidu.cesium.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.support.media.ExifInterface;
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
/* loaded from: classes9.dex */
public class d extends com.baidu.cesium.b.a {
    private g alw;
    private Context g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class a implements Comparable<a> {
        private static final String[] a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
        private final int b;

        private a(int i) {
            this.b = i;
        }

        public static a b(byte b, boolean z) {
            int i = b & 255;
            return z ? bD(i >> 4) : bD(i & 15);
        }

        public static a bD(int i) {
            if (i < 0 || i >= 16) {
                throw new IllegalArgumentException("invalid idx " + i);
            }
            return new a(i);
        }

        public String a() {
            return a[this.b];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: b */
        public int compareTo(a aVar) {
            return this.b - aVar.b;
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

        public byte sF() {
            return (byte) this.b;
        }
    }

    /* loaded from: classes9.dex */
    static class b {
        private Map<a, Integer> a = new HashMap();

        b() {
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.a.entrySet());
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
            Integer num = this.a.get(aVar);
            this.a.put(aVar, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c {
        private a[] aly;
        private int b;
        private int d;

        public c() {
            this.b = 33;
            this.aly = new a[this.b];
        }

        public c(byte[] bArr) {
            this.b = 33;
            this.aly = new a[this.b];
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            for (int i = 0; i < bArr.length; i++) {
                a b = a.b(bArr[i], false);
                a b2 = a.b(bArr[i], true);
                c(b);
                c(b2);
            }
        }

        private void b(int i) {
            if (i - this.aly.length > 0) {
                int length = this.aly.length;
                int i2 = length + (length >> 1);
                if (i2 - i >= 0) {
                    i = i2;
                }
                this.aly = (a[]) Arrays.copyOf(this.aly, i);
            }
        }

        public int a() {
            return this.d;
        }

        public byte[] b() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < this.d / 2; i++) {
                byteArrayOutputStream.write((byte) ((bD(i * 2).sF() & 255) | ((bD((i * 2) + 1).sF() & 255) << 4)));
            }
            if (this.d % 2 != 0) {
                byteArrayOutputStream.write((byte) (bD(this.d - 1).sF() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }

        public a bD(int i) {
            if (i >= this.d) {
                throw new IndexOutOfBoundsException("idx " + i + " size " + this.d);
            }
            return this.aly[i];
        }

        public void c(a aVar) {
            b(this.d + 1);
            a[] aVarArr = this.aly;
            int i = this.d;
            this.d = i + 1;
            aVarArr[i] = aVar;
        }
    }

    /* renamed from: com.baidu.cesium.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0099d {
        private List<a> a = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.cesium.b.d$d$a */
        /* loaded from: classes9.dex */
        public static class a {
            private int a;
            private a alB;

            public a(a aVar) {
                this.alB = aVar;
            }

            public void a() {
                this.a++;
            }
        }

        C0099d() {
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.a);
            Collections.sort(arrayList, new Comparator<a>() { // from class: com.baidu.cesium.b.d.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(a aVar, a aVar2) {
                    return aVar.a - aVar2.a;
                }
            });
            return arrayList;
        }

        public void c(a aVar) {
            this.a.add(new a(aVar));
        }
    }

    /* loaded from: classes9.dex */
    static class e {
        byte[] a;
        byte b;
        byte[] c;

        public e(byte[] bArr, byte b, byte[] bArr2) {
            this.a = bArr;
            this.b = b;
            this.c = bArr2;
        }

        public static e f(g.a aVar) {
            try {
                byte[] b = d.b(aVar.b());
                if (b.length > 16) {
                    return null;
                }
                return new e(b, aVar.d().getBytes("UTF-8")[0], aVar.c() != null ? aVar.c().getBytes("UTF-8") : null);
            } catch (Exception e) {
                return null;
            }
        }

        public g.a uo() {
            try {
                return com.baidu.cesium.g.l(com.baidu.cesium.d.b.a(this.a, "", true), new String(new byte[]{this.b}, "UTF-8"), this.c != null ? new String(this.c, "UTF-8") : null);
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class f {
        public int a;
        public int b;
        public int c = 16;

        f() {
        }

        public String toString() {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class g {
        private Method a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;

        g() {
        }

        public int a(Context context, Uri uri, int i, int i2, int i3) {
            try {
                return ((Integer) this.a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
            } catch (Exception e) {
                throw new i.a(e);
            }
        }

        void a() {
            try {
                this.a = i.a(Context.class, i.a(com.baidu.cesium.a.d.sA()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.b = i.a(Context.class, i.a(com.baidu.cesium.a.d.sB()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.c = i.a(ContentResolver.class, i.a(com.baidu.cesium.a.d.sC()), new Class[]{Uri.class, Integer.TYPE});
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
                this.b.invoke(context, str, uri, Integer.valueOf(i));
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
        this.alw = new g();
        this.alw.a();
    }

    private a a(String str, int i, List<C0099d.a> list, int i2, f fVar) {
        for (C0099d.a aVar : list) {
            if (a(str, i, aVar.alB, i2, fVar)) {
                aVar.a();
                return aVar.alB;
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
        return b(Uri.parse(a(this.g.getPackageName(), i, aVar)));
    }

    private boolean a(Uri uri, int i) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.g;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.alw.a(context, uri, i);
            this.alw.b(contentResolver, uri, i);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean a(a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return b(Uri.parse(a(this.g.getPackageName(), aVar)));
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
                } else if (!cVar.bD(i).a().equals(pathSegments.get(3))) {
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
            if (!a(this.g.getPackageName(), i2, cVar.bD(i2), Process.myUid(), (f) null)) {
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
                    fVar.a++;
                } catch (Throwable th) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception e2) {
                    }
                    i4++;
                }
            }
            i3 = this.alw.a(this.g, parse, 0, i2, 1);
            break;
        }
        if (i3 == 0) {
            return true;
        }
        if (fVar != null) {
            fVar.b++;
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
                i2 = this.alw.a(this.g, parse, 0, i, 1);
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

    private boolean b(Uri uri) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.g;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.alw.a(context, context.getPackageName(), uri, 65);
            this.alw.a(contentResolver, uri, 1);
            return true;
        } catch (Exception e2) {
            return false;
        }
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
            c cVar = new c(f2.a);
            cVar.c(a.b(f2.b, false));
            cVar.c(a.b(f2.b, true));
            if (f2.c != null) {
                byte[] bArr = f2.c;
                for (byte b2 : bArr) {
                    cVar.c(a.b(b2, false));
                    cVar.c(a.b(b2, true));
                }
            }
            b bVar = new b();
            for (int i = 0; i < cVar.a(); i++) {
                bVar.c(cVar.bD(i));
            }
            List<a> a2 = bVar.a();
            if (a(cVar, a2)) {
                for (int a3 = cVar.a() - 1; a3 >= 0; a3--) {
                    a(a3, cVar.bD(a3));
                }
                for (a aVar2 : a2) {
                    a(aVar2);
                }
                return a.e.ul();
            }
            return a.e.ul();
        }
        return a.e.um();
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019c  */
    @Override // com.baidu.cesium.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a.g a(String str, a.f fVar) {
        Byte b2;
        Byte b3;
        boolean z;
        byte[] bArr;
        if (Build.VERSION.SDK_INT < 26) {
            return a.g.un();
        }
        int i = -1;
        try {
            i = this.g.getPackageManager().getPackageUid(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (i < 0) {
            return a.g.un();
        }
        f fVar2 = new f();
        c cVar = new c();
        C0099d c0099d = new C0099d();
        C0099d c0099d2 = new C0099d();
        for (int i2 = 0; i2 < 16; i2++) {
            a bD = a.bD(i2);
            if (a(str, bD, i)) {
                c0099d.c(bD);
            } else {
                c0099d2.c(bD);
            }
        }
        for (int i3 = 0; i3 < 32; i3++) {
            a a2 = a(str, i3, c0099d.a(), i, fVar2);
            if (a2 == null) {
                a2 = a(str, i3, c0099d2.a(), i, fVar2);
            }
            if (a2 == null) {
                return a.g.un();
            }
            cVar.c(a2);
        }
        byte[] b4 = cVar.b();
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
            a b6 = a.b(b5, false);
            if (a(str, 32, b6, i, fVar2)) {
                a b7 = a.b(b5, true);
                if (a(str, 33, b7, i, fVar2)) {
                    c cVar2 = new c();
                    cVar2.c(b6);
                    cVar2.c(b7);
                    b2 = Byte.valueOf(cVar2.b()[0]);
                    break;
                }
            }
            i4 = i5 + 1;
        }
        if (b2 == null) {
            c cVar3 = new c();
            for (int i6 = 32; i6 < 34; i6++) {
                a a3 = a(str, i6, c0099d.a(), i, fVar2);
                if (a3 == null) {
                    a3 = a(str, i6, c0099d2.a(), i, fVar2);
                }
                if (a3 == null) {
                    return a.g.un();
                }
                cVar3.c(a3);
            }
            b3 = Byte.valueOf(cVar3.b()[0]);
            z = true;
        } else {
            b3 = b2;
            z = false;
        }
        if (z) {
            c cVar4 = new c();
            for (int i7 = 34; i7 < 94; i7++) {
                a a4 = a(str, i7, c0099d.a(), i, fVar2);
                if (a4 == null) {
                    a4 = a(str, i7, c0099d2.a(), i, fVar2);
                }
                if (a4 == null) {
                    break;
                }
                cVar4.c(a4);
            }
            if (cVar4.a() > 0) {
                bArr = cVar4.b();
                e eVar = new e(b4, b3.byteValue(), bArr);
                return eVar != null ? a.g.un() : a.g.d(eVar.uo());
            }
        }
        bArr = null;
        e eVar2 = new e(b4, b3.byteValue(), bArr);
        if (eVar2 != null) {
        }
    }

    @Override // com.baidu.cesium.b.a
    public void a(a.c cVar) {
        this.g = this.ali.a;
    }
}
