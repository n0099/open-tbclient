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
/* loaded from: classes19.dex */
public final class a implements Closeable {
    static final Pattern cgV = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream cgW = new b();
    private int ad;
    private final File cgX;
    private final File cgY;
    private final File cgZ;
    private final File cha;
    private final int chb;
    private long chc;
    private final int chd;
    private Writer che;
    private long size = 0;
    private final LinkedHashMap<String, d> chf = new LinkedHashMap<>(0, 0.75f, true);
    private long apw = 0;
    final ThreadPoolExecutor chg = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> chh = new CallableC0313a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class CallableC0313a implements Callable<Void> {
        CallableC0313a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.che != null) {
                    a.this.trimToSize();
                    if (a.this.adB()) {
                        a.this.adA();
                        a.this.ad = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes19.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes19.dex */
    public final class c {
        private final d chi;
        private boolean chj;
        private boolean chk;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        private class C0314a extends FilterOutputStream {
            /* synthetic */ C0314a(c cVar, OutputStream outputStream, CallableC0313a callableC0313a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.chj = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.chj = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.chj = true;
                }
            }

            private C0314a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.chj = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0313a callableC0313a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.chj) {
                a.this.a(this, false);
                a.this.remove(this.chi.key);
            } else {
                a.this.a(this, true);
            }
            this.chk = true;
        }

        public OutputStream hg(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.chd) {
                synchronized (a.this) {
                    if (this.chi.cho == this) {
                        if (!this.chi.chn) {
                            this.written[i] = true;
                        }
                        File hi = this.chi.hi(i);
                        try {
                            fileOutputStream = new FileOutputStream(hi);
                        } catch (FileNotFoundException e) {
                            a.this.cgX.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(hi);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.cgW;
                            }
                        }
                        outputStream = new C0314a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.chd);
        }

        private c(d dVar) {
            this.chi = dVar;
            this.written = dVar.chn ? null : new boolean[a.this.chd];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public final class d {
        private final long[] chm;
        private boolean chn;
        private c cho;
        private long chp;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0313a callableC0313a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.chm) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.chm = new long[a.this.chd];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.chd) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.chm[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException e) {
                        p(strArr);
                        throw null;
                    }
                }
                return;
            }
            p(strArr);
            throw null;
        }

        public File hh(int i) {
            return new File(a.this.cgX, this.key + "." + i);
        }

        public File hi(int i) {
            return new File(a.this.cgX, this.key + "." + i + ".tmp");
        }

        private IOException p(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes19.dex */
    public final class e implements Closeable {
        private final long[] chm;
        private final long chp;
        private final InputStream[] chq;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0313a callableC0313a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.chq) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream hj(int i) {
            return this.chq[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.chp = j;
            this.chq = inputStreamArr;
            this.chm = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.cgX = file;
        this.chb = i;
        this.cgY = new File(file, "journal");
        this.cgZ = new File(file, "journal.tmp");
        this.cha = new File(file, "journal.bkp");
        this.chd = i2;
        this.chc = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void adA() {
        Writer writer = this.che;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cgZ), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.chb));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.chd));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.chf.values()) {
            if (dVar.cho != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.cgY.exists()) {
            a(this.cgY, this.cha, true);
        }
        a(this.cgZ, this.cgY, false);
        this.cha.delete();
        this.che = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cgY, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adB() {
        int i = this.ad;
        return i >= 2000 && i >= this.chf.size();
    }

    private void adC() {
        if (this.che == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void ady() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.cgY), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.chb).equals(readLine3) || !Integer.toString(this.chd).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.chf.size();
                    if (bVar.adF()) {
                        adA();
                    } else {
                        this.che = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cgY, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void adz() {
        c(this.cgZ);
        Iterator<d> it = this.chf.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.cho != null) {
                next.cho = null;
                for (int i = 0; i < this.chd; i++) {
                    c(next.hh(i));
                    c(next.hi(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.chd; i2++) {
                    this.size += next.chm[i2];
                }
            }
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
                    this.chf.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.chf.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.chf.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.chn = true;
                dVar.cho = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.cho = new c(this, dVar, null);
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
        if (!cgV.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.chc) {
            remove(this.chf.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.che != null) {
            Iterator it = new ArrayList(this.chf.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.cho != null) {
                    dVar.cho.abort();
                }
            }
            trimToSize();
            this.che.close();
            this.che = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.cgX);
    }

    public synchronized void flush() {
        adC();
        trimToSize();
        this.che.flush();
    }

    public synchronized e jZ(String str) {
        e eVar = null;
        synchronized (this) {
            adC();
            r(str);
            d dVar = this.chf.get(str);
            if (dVar != null && dVar.chn) {
                InputStream[] inputStreamArr = new InputStream[this.chd];
                for (int i = 0; i < this.chd; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.hh(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.chd && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.che.append((CharSequence) ("READ " + str + '\n'));
                if (adB()) {
                    this.chg.submit(this.chh);
                }
                eVar = new e(this, str, dVar.chp, inputStreamArr, dVar.chm, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            adC();
            r(str);
            d dVar = this.chf.get(str);
            if (dVar == null || dVar.cho != null) {
                z = false;
            } else {
                for (int i = 0; i < this.chd; i++) {
                    File hh = dVar.hh(i);
                    if (!hh.exists() || hh.delete()) {
                        this.size -= dVar.chm[i];
                        dVar.chm[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + hh);
                    }
                }
                this.ad++;
                this.che.append((CharSequence) ("REMOVE " + str + '\n'));
                this.chf.remove(str);
                if (adB()) {
                    this.chg.submit(this.chh);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.chi;
            if (dVar.cho == cVar) {
                if (z && !dVar.chn) {
                    for (int i = 0; i < this.chd; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.hi(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.chd; i2++) {
                    File hi = dVar.hi(i2);
                    if (!z) {
                        c(hi);
                    } else if (hi.exists()) {
                        File hh = dVar.hh(i2);
                        hi.renameTo(hh);
                        long j = dVar.chm[i2];
                        long length = hh.length();
                        dVar.chm[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.cho = null;
                if (!dVar.chn && !z) {
                    this.chf.remove(dVar.key);
                    this.che.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.chn = true;
                    this.che.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.apw;
                        this.apw = 1 + j2;
                        dVar.chp = j2;
                    }
                }
                this.che.flush();
                if (this.size > this.chc || adB()) {
                    this.chg.submit(this.chh);
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

    public c ka(String str) {
        return h(str, -1L);
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
                if (aVar.cgY.exists()) {
                    try {
                        aVar.ady();
                        aVar.adz();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.adA();
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

    private synchronized c h(String str, long j) {
        d dVar;
        c cVar;
        adC();
        r(str);
        d dVar2 = this.chf.get(str);
        if (j == -1 || (dVar2 != null && dVar2.chp == j)) {
            if (dVar2 != null) {
                if (dVar2.cho != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.chf.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.cho = cVar;
            this.che.write("DIRTY " + str + '\n');
            this.che.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
