package com.baidu.poly.a.f;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public final class a implements Closeable {
    static final Pattern bHp = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream bHq = new b();
    private int ad;
    private final File bHr;
    private final File bHs;
    private final File bHt;
    private final File bHu;
    private final int bHv;
    private long bHw;
    private final int bHx;
    private Writer bHy;
    private long size = 0;
    private final LinkedHashMap<String, d> bHz = new LinkedHashMap<>(0, 0.75f, true);
    private long anO = 0;
    final ThreadPoolExecutor bHA = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> bHB = new CallableC0263a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class CallableC0263a implements Callable<Void> {
        CallableC0263a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.bHy != null) {
                    a.this.trimToSize();
                    if (a.this.UM()) {
                        a.this.UL();
                        a.this.ad = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes9.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes9.dex */
    public final class c {
        private final d bHC;
        private boolean bHD;
        private boolean bHE;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        private class C0264a extends FilterOutputStream {
            /* synthetic */ C0264a(c cVar, OutputStream outputStream, CallableC0263a callableC0263a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.bHD = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.bHD = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.bHD = true;
                }
            }

            private C0264a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.bHD = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0263a callableC0263a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.bHD) {
                a.this.a(this, false);
                a.this.remove(this.bHC.key);
            } else {
                a.this.a(this, true);
            }
            this.bHE = true;
        }

        public OutputStream fX(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.bHx) {
                synchronized (a.this) {
                    if (this.bHC.bHI == this) {
                        if (!this.bHC.bHH) {
                            this.written[i] = true;
                        }
                        File fZ = this.bHC.fZ(i);
                        try {
                            fileOutputStream = new FileOutputStream(fZ);
                        } catch (FileNotFoundException e) {
                            a.this.bHr.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(fZ);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.bHq;
                            }
                        }
                        outputStream = new C0264a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.bHx);
        }

        private c(d dVar) {
            this.bHC = dVar;
            this.written = dVar.bHH ? null : new boolean[a.this.bHx];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class d {
        private final long[] bHG;
        private boolean bHH;
        private c bHI;
        private long bHJ;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0263a callableC0263a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bHG) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.bHG = new long[a.this.bHx];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.bHx) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.bHG[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException e) {
                        n(strArr);
                        throw null;
                    }
                }
                return;
            }
            n(strArr);
            throw null;
        }

        public File fY(int i) {
            return new File(a.this.bHr, this.key + "." + i);
        }

        public File fZ(int i) {
            return new File(a.this.bHr, this.key + "." + i + ".tmp");
        }

        private IOException n(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes9.dex */
    public final class e implements Closeable {
        private final long[] bHG;
        private final long bHJ;
        private final InputStream[] bHK;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0263a callableC0263a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.bHK) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream ga(int i) {
            return this.bHK[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bHJ = j;
            this.bHK = inputStreamArr;
            this.bHG = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.bHr = file;
        this.bHv = i;
        this.bHs = new File(file, "journal");
        this.bHt = new File(file, "journal.tmp");
        this.bHu = new File(file, "journal.bkp");
        this.bHx = i2;
        this.bHw = j;
    }

    private void UJ() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.bHs), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.bHv).equals(readLine3) || !Integer.toString(this.bHx).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.bHz.size();
                    if (bVar.UQ()) {
                        UL();
                    } else {
                        this.bHy = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bHs, true), com.baidu.poly.a.f.c.US_ASCII));
                    }
                    com.baidu.poly.a.f.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.baidu.poly.a.f.c.a(bVar);
            throw th;
        }
    }

    private void UK() {
        c(this.bHt);
        Iterator<d> it = this.bHz.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.bHI != null) {
                next.bHI = null;
                for (int i = 0; i < this.bHx; i++) {
                    c(next.fY(i));
                    c(next.fZ(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.bHx; i2++) {
                    this.size += next.bHG[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void UL() {
        Writer writer = this.bHy;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bHt), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bHv));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bHx));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.bHz.values()) {
            if (dVar.bHI != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.bHs.exists()) {
            a(this.bHs, this.bHu, true);
        }
        a(this.bHt, this.bHs, false);
        this.bHu.delete();
        this.bHy = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bHs, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean UM() {
        int i = this.ad;
        return i >= 2000 && i >= this.bHz.size();
    }

    private void UN() {
        if (this.bHy == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void q(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                String substring2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.bHz.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.bHz.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.bHz.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.bHH = true;
                dVar.bHI = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.bHI = new c(this, dVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void r(String str) {
        if (!bHp.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.bHw) {
            remove(this.bHz.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.bHy != null) {
            Iterator it = new ArrayList(this.bHz.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bHI != null) {
                    dVar.bHI.abort();
                }
            }
            trimToSize();
            this.bHy.close();
            this.bHy = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.bHr);
    }

    public synchronized void flush() {
        UN();
        trimToSize();
        this.bHy.flush();
    }

    public synchronized e iq(String str) {
        e eVar = null;
        synchronized (this) {
            UN();
            r(str);
            d dVar = this.bHz.get(str);
            if (dVar != null && dVar.bHH) {
                InputStream[] inputStreamArr = new InputStream[this.bHx];
                for (int i = 0; i < this.bHx; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.fY(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.bHx && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.bHy.append((CharSequence) ("READ " + str + '\n'));
                if (UM()) {
                    this.bHA.submit(this.bHB);
                }
                eVar = new e(this, str, dVar.bHJ, inputStreamArr, dVar.bHG, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            UN();
            r(str);
            d dVar = this.bHz.get(str);
            if (dVar == null || dVar.bHI != null) {
                z = false;
            } else {
                for (int i = 0; i < this.bHx; i++) {
                    File fY = dVar.fY(i);
                    if (!fY.exists() || fY.delete()) {
                        this.size -= dVar.bHG[i];
                        dVar.bHG[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + fY);
                    }
                }
                this.ad++;
                this.bHy.append((CharSequence) ("REMOVE " + str + '\n'));
                this.bHz.remove(str);
                if (UM()) {
                    this.bHA.submit(this.bHB);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.bHC;
            if (dVar.bHI == cVar) {
                if (z && !dVar.bHH) {
                    for (int i = 0; i < this.bHx; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.fZ(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.bHx; i2++) {
                    File fZ = dVar.fZ(i2);
                    if (!z) {
                        c(fZ);
                    } else if (fZ.exists()) {
                        File fY = dVar.fY(i2);
                        fZ.renameTo(fY);
                        long j = dVar.bHG[i2];
                        long length = fY.length();
                        dVar.bHG[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.bHI = null;
                if (!dVar.bHH && !z) {
                    this.bHz.remove(dVar.key);
                    this.bHy.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.bHH = true;
                    this.bHy.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.anO;
                        this.anO = 1 + j2;
                        dVar.bHJ = j2;
                    }
                }
                this.bHy.flush();
                if (this.size > this.bHw || UM()) {
                    this.bHA.submit(this.bHB);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private static void c(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public c ir(String str) {
        return f(str, -1L);
    }

    public static a a(File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        a(file2, file3, false);
                    }
                }
                a aVar = new a(file, i, i2, j);
                if (aVar.bHs.exists()) {
                    try {
                        aVar.UJ();
                        aVar.UK();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.UL();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            c(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private synchronized c f(String str, long j) {
        d dVar;
        c cVar;
        UN();
        r(str);
        d dVar2 = this.bHz.get(str);
        if (j == -1 || (dVar2 != null && dVar2.bHJ == j)) {
            if (dVar2 != null) {
                if (dVar2.bHI != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.bHz.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.bHI = cVar;
            this.bHy.write("DIRTY " + str + '\n');
            this.bHy.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
