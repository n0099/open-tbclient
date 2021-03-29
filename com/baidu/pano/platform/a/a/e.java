package com.baidu.pano.platform.a.a;

import android.os.SystemClock;
import com.baidu.pano.platform.a.b;
import com.baidu.pano.platform.a.w;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class e implements com.baidu.pano.platform.a.b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f9325a;

    /* renamed from: b  reason: collision with root package name */
    public long f9326b;

    /* renamed from: c  reason: collision with root package name */
    public final File f9327c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9328d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f9329a;

        /* renamed from: b  reason: collision with root package name */
        public String f9330b;

        /* renamed from: c  reason: collision with root package name */
        public String f9331c;

        /* renamed from: d  reason: collision with root package name */
        public long f9332d;

        /* renamed from: e  reason: collision with root package name */
        public long f9333e;

        /* renamed from: f  reason: collision with root package name */
        public long f9334f;

        /* renamed from: g  reason: collision with root package name */
        public long f9335g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f9336h;

        public a() {
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (e.a(inputStream) == 538247942) {
                aVar.f9330b = e.c(inputStream);
                String c2 = e.c(inputStream);
                aVar.f9331c = c2;
                if (c2.equals("")) {
                    aVar.f9331c = null;
                }
                aVar.f9332d = e.b(inputStream);
                aVar.f9333e = e.b(inputStream);
                aVar.f9334f = e.b(inputStream);
                aVar.f9335g = e.b(inputStream);
                aVar.f9336h = e.d(inputStream);
                return aVar;
            }
            throw new IOException();
        }

        public a(String str, b.a aVar) {
            this.f9330b = str;
            this.f9329a = aVar.f9347a.length;
            this.f9331c = aVar.f9348b;
            this.f9332d = aVar.f9349c;
            this.f9333e = aVar.f9350d;
            this.f9334f = aVar.f9351e;
            this.f9335g = aVar.f9352f;
            this.f9336h = aVar.f9353g;
        }

        public b.a a(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f9347a = bArr;
            aVar.f9348b = this.f9331c;
            aVar.f9349c = this.f9332d;
            aVar.f9350d = this.f9333e;
            aVar.f9351e = this.f9334f;
            aVar.f9352f = this.f9335g;
            aVar.f9353g = this.f9336h;
            return aVar;
        }

        public boolean a(OutputStream outputStream) {
            try {
                e.a(outputStream, 538247942);
                e.a(outputStream, this.f9330b);
                e.a(outputStream, this.f9331c == null ? "" : this.f9331c);
                e.a(outputStream, this.f9332d);
                e.a(outputStream, this.f9333e);
                e.a(outputStream, this.f9334f);
                e.a(outputStream, this.f9335g);
                e.a(this.f9336h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                w.b("%s", e2.toString());
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        public int f9337a;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f9337a++;
            }
            return read;
        }

        public b(InputStream inputStream) {
            super(inputStream);
            this.f9337a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f9337a += read;
            }
            return read;
        }
    }

    public e(File file, int i) {
        this.f9325a = new LinkedHashMap(16, 0.75f, true);
        this.f9326b = 0L;
        this.f9327c = file;
        this.f9328d = i;
    }

    private String d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    private void e(String str) {
        a aVar = this.f9325a.get(str);
        if (aVar != null) {
            this.f9326b -= aVar.f9329a;
            this.f9325a.remove(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.pano.platform.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized b.a a(String str) {
        b bVar;
        a aVar = this.f9325a.get(str);
        FilterInputStream filterInputStream = null;
        if (aVar == null) {
            return null;
        }
        File c2 = c(str);
        try {
            try {
                bVar = new b(new FileInputStream(c2));
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        filterInputStream.close();
                    } catch (IOException unused) {
                        return null;
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            bVar = null;
        } catch (NegativeArraySizeException e3) {
            e = e3;
            bVar = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        try {
            a.a(bVar);
            b.a a2 = aVar.a(a(bVar, (int) (c2.length() - bVar.f9337a)));
            try {
                bVar.close();
                return a2;
            } catch (IOException unused2) {
                return null;
            }
        } catch (IOException e4) {
            e = e4;
            w.b("%s: %s", c2.getAbsolutePath(), e.toString());
            b(str);
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (IOException unused3) {
                    return null;
                }
            }
            return null;
        } catch (NegativeArraySizeException e5) {
            e = e5;
            w.b("%s: %s", c2.getAbsolutePath(), e.toString());
            b(str);
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (IOException unused4) {
                    return null;
                }
            }
            return null;
        }
    }

    public synchronized void b(String str) {
        boolean delete = c(str).delete();
        e(str);
        if (!delete) {
            w.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    public File c(String str) {
        return new File(this.f9327c, d(str));
    }

    public static String c(InputStream inputStream) throws IOException {
        return new String(a(inputStream, (int) b(inputStream)), "UTF-8");
    }

    public static Map<String, String> d(InputStream inputStream) throws IOException {
        int a2 = a(inputStream);
        Map<String, String> emptyMap = a2 == 0 ? Collections.emptyMap() : new HashMap<>(a2);
        for (int i = 0; i < a2; i++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }

    public static int e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public e(File file) {
        this(file, 5242880);
    }

    public static long b(InputStream inputStream) throws IOException {
        return ((e(inputStream) & 255) << 0) | 0 | ((e(inputStream) & 255) << 8) | ((e(inputStream) & 255) << 16) | ((e(inputStream) & 255) << 24) | ((e(inputStream) & 255) << 32) | ((e(inputStream) & 255) << 40) | ((e(inputStream) & 255) << 48) | ((255 & e(inputStream)) << 56);
    }

    @Override // com.baidu.pano.platform.a.b
    public synchronized void a() {
        BufferedInputStream bufferedInputStream;
        if (!this.f9327c.exists()) {
            if (!this.f9327c.mkdirs()) {
                w.c("Unable to create cache dir %s", this.f9327c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f9327c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                a a2 = a.a(bufferedInputStream);
                a2.f9329a = file.length();
                a(a2.f9330b, a2);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
            } catch (IOException unused3) {
                bufferedInputStream2 = bufferedInputStream;
                if (file != null) {
                    file.delete();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.baidu.pano.platform.a.b
    public synchronized void a(String str, b.a aVar) {
        a(aVar.f9347a.length);
        File c2 = c(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(c2);
            a aVar2 = new a(str, aVar);
            if (aVar2.a(fileOutputStream)) {
                fileOutputStream.write(aVar.f9347a);
                fileOutputStream.close();
                a(str, aVar2);
            } else {
                fileOutputStream.close();
                w.b("Failed to write header for %s", c2.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException unused) {
            if (c2.delete()) {
                return;
            }
            w.b("Could not clean up file %s", c2.getAbsolutePath());
        }
    }

    private void a(int i) {
        long j;
        long j2 = i;
        if (this.f9326b + j2 < this.f9328d) {
            return;
        }
        if (w.f9415b) {
            w.a("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f9326b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f9325a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (c(value.f9330b).delete()) {
                j = j2;
                this.f9326b -= value.f9329a;
            } else {
                j = j2;
                String str = value.f9330b;
                w.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
            }
            it.remove();
            i2++;
            if (((float) (this.f9326b + j)) < this.f9328d * 0.9f) {
                break;
            }
            j2 = j;
        }
        if (w.f9415b) {
            w.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f9326b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void a(String str, a aVar) {
        if (!this.f9325a.containsKey(str)) {
            this.f9326b += aVar.f9329a;
        } else {
            this.f9326b += aVar.f9329a - this.f9325a.get(str).f9329a;
        }
        this.f9325a.put(str, aVar);
    }

    public static byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    public static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static int a(InputStream inputStream) throws IOException {
        return (e(inputStream) << 24) | (e(inputStream) << 0) | 0 | (e(inputStream) << 8) | (e(inputStream) << 16);
    }

    public static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public static void a(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            a(outputStream, map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(outputStream, entry.getKey());
                a(outputStream, entry.getValue());
            }
            return;
        }
        a(outputStream, 0);
    }
}
