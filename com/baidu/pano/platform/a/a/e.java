package com.baidu.pano.platform.a.a;

import android.os.SystemClock;
import com.baidu.pano.platform.a.b;
import com.baidu.pano.platform.a.w;
import com.baidubce.services.bos.BosClientConfiguration;
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
/* loaded from: classes7.dex */
public class e implements com.baidu.pano.platform.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f2640a;
    private long b;
    private final File c;
    private final int d;

    public e(File file, int i) {
        this.f2640a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0L;
        this.c = file;
        this.d = i;
    }

    public e(File file) {
        this(file, BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [129=5, 131=4, 132=4, 133=6] */
    @Override // com.baidu.pano.platform.a.b
    public synchronized b.a a(String str) {
        b bVar;
        b.a aVar;
        File c;
        a aVar2 = this.f2640a.get(str);
        if (aVar2 == null) {
            aVar = null;
        } else {
            try {
                c = c(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                bVar = new b(new FileInputStream(c));
                try {
                    a.a(bVar);
                    aVar = aVar2.a(a(bVar, (int) (c.length() - bVar.f2642a)));
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e) {
                            aVar = null;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    w.b("%s: %s", c.getAbsolutePath(), e.toString());
                    b(str);
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e3) {
                            aVar = null;
                        }
                    }
                    aVar = null;
                    return aVar;
                } catch (NegativeArraySizeException e4) {
                    e = e4;
                    w.b("%s: %s", c.getAbsolutePath(), e.toString());
                    b(str);
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e5) {
                            aVar = null;
                        }
                    }
                    aVar = null;
                    return aVar;
                }
            } catch (IOException e6) {
                e = e6;
                bVar = null;
            } catch (NegativeArraySizeException e7) {
                e = e7;
                bVar = null;
            } catch (Throwable th2) {
                th = th2;
                bVar = null;
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (IOException e8) {
                        aVar = null;
                    }
                }
                throw th;
            }
        }
        return aVar;
    }

    @Override // com.baidu.pano.platform.a.b
    public synchronized void a() {
        BufferedInputStream bufferedInputStream;
        if (!this.c.exists()) {
            if (!this.c.mkdirs()) {
                w.c("Unable to create cache dir %s", this.c.getAbsolutePath());
            }
        } else {
            File[] listFiles = this.c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            try {
                                a a2 = a.a(bufferedInputStream);
                                a2.f2641a = file.length();
                                a(a2.b, a2);
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e) {
                                    }
                                }
                            } catch (IOException e2) {
                                if (file != null) {
                                    file.delete();
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            bufferedInputStream2 = bufferedInputStream;
                            th = th;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
    }

    @Override // com.baidu.pano.platform.a.b
    public synchronized void a(String str, b.a aVar) {
        FileOutputStream fileOutputStream;
        a aVar2;
        a(aVar.f2648a.length);
        File c = c(str);
        try {
            fileOutputStream = new FileOutputStream(c);
            aVar2 = new a(str, aVar);
        } catch (IOException e) {
            if (!c.delete()) {
                w.b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
        if (!aVar2.a(fileOutputStream)) {
            fileOutputStream.close();
            w.b("Failed to write header for %s", c.getAbsolutePath());
            throw new IOException();
        }
        fileOutputStream.write(aVar.f2648a);
        fileOutputStream.close();
        a(str, aVar2);
    }

    public synchronized void b(String str) {
        boolean delete = c(str).delete();
        e(str);
        if (!delete) {
            w.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    private String d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public File c(String str) {
        return new File(this.c, d(str));
    }

    private void a(int i) {
        int i2;
        if (this.b + i >= this.d) {
            if (w.b) {
                w.a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it = this.f2640a.entrySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = i3;
                    break;
                }
                a value = it.next().getValue();
                if (c(value.b).delete()) {
                    this.b -= value.f2641a;
                } else {
                    w.b("Could not delete cache entry for key=%s, filename=%s", value.b, d(value.b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.b + i)) < this.d * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            if (w.b) {
                w.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void a(String str, a aVar) {
        if (!this.f2640a.containsKey(str)) {
            this.b += aVar.f2641a;
        } else {
            this.b = (aVar.f2641a - this.f2640a.get(str).f2641a) + this.b;
        }
        this.f2640a.put(str, aVar);
    }

    private void e(String str) {
        a aVar = this.f2640a.get(str);
        if (aVar != null) {
            this.b -= aVar.f2641a;
            this.f2640a.remove(str);
        }
    }

    private static byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 != i) {
            throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f2641a;
        public String b;
        public String c;
        public long d;
        public long e;
        public long f;
        public long g;
        public Map<String, String> h;

        private a() {
        }

        public a(String str, b.a aVar) {
            this.b = str;
            this.f2641a = aVar.f2648a.length;
            this.c = aVar.b;
            this.d = aVar.c;
            this.e = aVar.d;
            this.f = aVar.e;
            this.g = aVar.f;
            this.h = aVar.g;
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (e.a(inputStream) != 538247942) {
                throw new IOException();
            }
            aVar.b = e.c(inputStream);
            aVar.c = e.c(inputStream);
            if (aVar.c.equals("")) {
                aVar.c = null;
            }
            aVar.d = e.b(inputStream);
            aVar.e = e.b(inputStream);
            aVar.f = e.b(inputStream);
            aVar.g = e.b(inputStream);
            aVar.h = e.d(inputStream);
            return aVar;
        }

        public b.a a(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f2648a = bArr;
            aVar.b = this.c;
            aVar.c = this.d;
            aVar.d = this.e;
            aVar.e = this.f;
            aVar.f = this.g;
            aVar.g = this.h;
            return aVar;
        }

        public boolean a(OutputStream outputStream) {
            try {
                e.a(outputStream, 538247942);
                e.a(outputStream, this.b);
                e.a(outputStream, this.c == null ? "" : this.c);
                e.a(outputStream, this.d);
                e.a(outputStream, this.e);
                e.a(outputStream, this.f);
                e.a(outputStream, this.g);
                e.a(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                w.b("%s", e.toString());
                return false;
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class b extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private int f2642a;

        private b(InputStream inputStream) {
            super(inputStream);
            this.f2642a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f2642a++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f2642a += read;
            }
            return read;
        }
    }

    private static int e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            throw new EOFException();
        }
        return read;
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int a(InputStream inputStream) throws IOException {
        return 0 | (e(inputStream) << 0) | (e(inputStream) << 8) | (e(inputStream) << 16) | (e(inputStream) << 24);
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static long b(InputStream inputStream) throws IOException {
        return 0 | ((e(inputStream) & 255) << 0) | ((e(inputStream) & 255) << 8) | ((e(inputStream) & 255) << 16) | ((e(inputStream) & 255) << 24) | ((e(inputStream) & 255) << 32) | ((e(inputStream) & 255) << 40) | ((e(inputStream) & 255) << 48) | ((e(inputStream) & 255) << 56);
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String c(InputStream inputStream) throws IOException {
        return new String(a(inputStream, (int) b(inputStream)), "UTF-8");
    }

    static void a(Map<String, String> map, OutputStream outputStream) throws IOException {
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

    static Map<String, String> d(InputStream inputStream) throws IOException {
        int a2 = a(inputStream);
        Map<String, String> emptyMap = a2 == 0 ? Collections.emptyMap() : new HashMap<>(a2);
        for (int i = 0; i < a2; i++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }
}
