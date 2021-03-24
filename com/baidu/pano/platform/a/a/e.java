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
    public final Map<String, a> f9324a;

    /* renamed from: b  reason: collision with root package name */
    public long f9325b;

    /* renamed from: c  reason: collision with root package name */
    public final File f9326c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9327d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f9328a;

        /* renamed from: b  reason: collision with root package name */
        public String f9329b;

        /* renamed from: c  reason: collision with root package name */
        public String f9330c;

        /* renamed from: d  reason: collision with root package name */
        public long f9331d;

        /* renamed from: e  reason: collision with root package name */
        public long f9332e;

        /* renamed from: f  reason: collision with root package name */
        public long f9333f;

        /* renamed from: g  reason: collision with root package name */
        public long f9334g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f9335h;

        public a() {
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (e.a(inputStream) == 538247942) {
                aVar.f9329b = e.c(inputStream);
                String c2 = e.c(inputStream);
                aVar.f9330c = c2;
                if (c2.equals("")) {
                    aVar.f9330c = null;
                }
                aVar.f9331d = e.b(inputStream);
                aVar.f9332e = e.b(inputStream);
                aVar.f9333f = e.b(inputStream);
                aVar.f9334g = e.b(inputStream);
                aVar.f9335h = e.d(inputStream);
                return aVar;
            }
            throw new IOException();
        }

        public a(String str, b.a aVar) {
            this.f9329b = str;
            this.f9328a = aVar.f9346a.length;
            this.f9330c = aVar.f9347b;
            this.f9331d = aVar.f9348c;
            this.f9332e = aVar.f9349d;
            this.f9333f = aVar.f9350e;
            this.f9334g = aVar.f9351f;
            this.f9335h = aVar.f9352g;
        }

        public b.a a(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f9346a = bArr;
            aVar.f9347b = this.f9330c;
            aVar.f9348c = this.f9331d;
            aVar.f9349d = this.f9332e;
            aVar.f9350e = this.f9333f;
            aVar.f9351f = this.f9334g;
            aVar.f9352g = this.f9335h;
            return aVar;
        }

        public boolean a(OutputStream outputStream) {
            try {
                e.a(outputStream, 538247942);
                e.a(outputStream, this.f9329b);
                e.a(outputStream, this.f9330c == null ? "" : this.f9330c);
                e.a(outputStream, this.f9331d);
                e.a(outputStream, this.f9332e);
                e.a(outputStream, this.f9333f);
                e.a(outputStream, this.f9334g);
                e.a(this.f9335h, outputStream);
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
        public int f9336a;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f9336a++;
            }
            return read;
        }

        public b(InputStream inputStream) {
            super(inputStream);
            this.f9336a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f9336a += read;
            }
            return read;
        }
    }

    public e(File file, int i) {
        this.f9324a = new LinkedHashMap(16, 0.75f, true);
        this.f9325b = 0L;
        this.f9326c = file;
        this.f9327d = i;
    }

    private String d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    private void e(String str) {
        a aVar = this.f9324a.get(str);
        if (aVar != null) {
            this.f9325b -= aVar.f9328a;
            this.f9324a.remove(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.pano.platform.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized b.a a(String str) {
        b bVar;
        a aVar = this.f9324a.get(str);
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
            b.a a2 = aVar.a(a(bVar, (int) (c2.length() - bVar.f9336a)));
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
        return new File(this.f9326c, d(str));
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
        if (!this.f9326c.exists()) {
            if (!this.f9326c.mkdirs()) {
                w.c("Unable to create cache dir %s", this.f9326c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f9326c.listFiles();
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
                a2.f9328a = file.length();
                a(a2.f9329b, a2);
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
        a(aVar.f9346a.length);
        File c2 = c(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(c2);
            a aVar2 = new a(str, aVar);
            if (aVar2.a(fileOutputStream)) {
                fileOutputStream.write(aVar.f9346a);
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
        if (this.f9325b + j2 < this.f9327d) {
            return;
        }
        if (w.f9414b) {
            w.a("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f9325b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f9324a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (c(value.f9329b).delete()) {
                j = j2;
                this.f9325b -= value.f9328a;
            } else {
                j = j2;
                String str = value.f9329b;
                w.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
            }
            it.remove();
            i2++;
            if (((float) (this.f9325b + j)) < this.f9327d * 0.9f) {
                break;
            }
            j2 = j;
        }
        if (w.f9414b) {
            w.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f9325b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void a(String str, a aVar) {
        if (!this.f9324a.containsKey(str)) {
            this.f9325b += aVar.f9328a;
        } else {
            this.f9325b += aVar.f9328a - this.f9324a.get(str).f9328a;
        }
        this.f9324a.put(str, aVar);
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
