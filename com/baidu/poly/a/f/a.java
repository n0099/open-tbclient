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
/* loaded from: classes14.dex */
public final class a implements Closeable {
    static final Pattern cpb = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream cpc = new b();
    private int ad;
    private final File cpd;
    private final File cpe;
    private final File cpf;
    private final File cpg;
    private final int cph;
    private long cpi;
    private final int cpj;
    private Writer cpk;
    private long size = 0;
    private final LinkedHashMap<String, d> cpl = new LinkedHashMap<>(0, 0.75f, true);
    private long aqu = 0;
    final ThreadPoolExecutor cpm = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> cpn = new CallableC0306a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class CallableC0306a implements Callable<Void> {
        CallableC0306a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.cpk != null) {
                    a.this.trimToSize();
                    if (a.this.adw()) {
                        a.this.adv();
                        a.this.ad = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes14.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes14.dex */
    public final class c {
        private final d cpo;
        private boolean cpp;
        private boolean cpq;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        private class C0307a extends FilterOutputStream {
            /* synthetic */ C0307a(c cVar, OutputStream outputStream, CallableC0306a callableC0306a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.cpp = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.cpp = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.cpp = true;
                }
            }

            private C0307a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.cpp = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0306a callableC0306a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.cpp) {
                a.this.a(this, false);
                a.this.remove(this.cpo.key);
            } else {
                a.this.a(this, true);
            }
            this.cpq = true;
        }

        public OutputStream fF(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.cpj) {
                synchronized (a.this) {
                    if (this.cpo.cpw == this) {
                        if (!this.cpo.cpv) {
                            this.written[i] = true;
                        }
                        File fH = this.cpo.fH(i);
                        try {
                            fileOutputStream = new FileOutputStream(fH);
                        } catch (FileNotFoundException e) {
                            a.this.cpd.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(fH);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.cpc;
                            }
                        }
                        outputStream = new C0307a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.cpj);
        }

        private c(d dVar) {
            this.cpo = dVar;
            this.written = dVar.cpv ? null : new boolean[a.this.cpj];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public final class d {
        private final long[] cps;
        private boolean cpv;
        private c cpw;
        private long cpx;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0306a callableC0306a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.cps) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.cps = new long[a.this.cpj];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.cpj) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.cps[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException e) {
                        w(strArr);
                        throw null;
                    }
                }
                return;
            }
            w(strArr);
            throw null;
        }

        public File fG(int i) {
            return new File(a.this.cpd, this.key + "." + i);
        }

        public File fH(int i) {
            return new File(a.this.cpd, this.key + "." + i + ".tmp");
        }

        private IOException w(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes14.dex */
    public final class e implements Closeable {
        private final long[] cps;
        private final long cpx;
        private final InputStream[] cpy;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0306a callableC0306a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.cpy) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream fI(int i) {
            return this.cpy[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.cpx = j;
            this.cpy = inputStreamArr;
            this.cps = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.cpd = file;
        this.cph = i;
        this.cpe = new File(file, "journal");
        this.cpf = new File(file, "journal.tmp");
        this.cpg = new File(file, "journal.bkp");
        this.cpj = i2;
        this.cpi = j;
    }

    private void adt() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.cpe), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.cph).equals(readLine3) || !Integer.toString(this.cpj).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.cpl.size();
                    if (bVar.D()) {
                        adv();
                    } else {
                        this.cpk = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cpe, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void adu() {
        c(this.cpf);
        Iterator<d> it = this.cpl.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.cpw != null) {
                next.cpw = null;
                for (int i = 0; i < this.cpj; i++) {
                    c(next.fG(i));
                    c(next.fH(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.cpj; i2++) {
                    this.size += next.cps[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void adv() {
        Writer writer = this.cpk;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cpf), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.cph));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.cpj));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.cpl.values()) {
            if (dVar.cpw != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.cpe.exists()) {
            a(this.cpe, this.cpg, true);
        }
        a(this.cpf, this.cpe, false);
        this.cpg.delete();
        this.cpk = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cpe, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adw() {
        int i = this.ad;
        return i >= 2000 && i >= this.cpl.size();
    }

    private void adx() {
        if (this.cpk == null) {
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
                    this.cpl.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.cpl.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.cpl.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.cpv = true;
                dVar.cpw = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.cpw = new c(this, dVar, null);
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
        if (!cpb.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.cpi) {
            remove(this.cpl.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.cpk != null) {
            Iterator it = new ArrayList(this.cpl.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.cpw != null) {
                    dVar.cpw.abort();
                }
            }
            trimToSize();
            this.cpk.close();
            this.cpk = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.cpd);
    }

    public synchronized void flush() {
        adx();
        trimToSize();
        this.cpk.flush();
    }

    public synchronized e jv(String str) {
        e eVar = null;
        synchronized (this) {
            adx();
            r(str);
            d dVar = this.cpl.get(str);
            if (dVar != null && dVar.cpv) {
                InputStream[] inputStreamArr = new InputStream[this.cpj];
                for (int i = 0; i < this.cpj; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.fG(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.cpj && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.cpk.append((CharSequence) ("READ " + str + '\n'));
                if (adw()) {
                    this.cpm.submit(this.cpn);
                }
                eVar = new e(this, str, dVar.cpx, inputStreamArr, dVar.cps, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            adx();
            r(str);
            d dVar = this.cpl.get(str);
            if (dVar == null || dVar.cpw != null) {
                z = false;
            } else {
                for (int i = 0; i < this.cpj; i++) {
                    File fG = dVar.fG(i);
                    if (!fG.exists() || fG.delete()) {
                        this.size -= dVar.cps[i];
                        dVar.cps[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + fG);
                    }
                }
                this.ad++;
                this.cpk.append((CharSequence) ("REMOVE " + str + '\n'));
                this.cpl.remove(str);
                if (adw()) {
                    this.cpm.submit(this.cpn);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.cpo;
            if (dVar.cpw == cVar) {
                if (z && !dVar.cpv) {
                    for (int i = 0; i < this.cpj; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.fH(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.cpj; i2++) {
                    File fH = dVar.fH(i2);
                    if (!z) {
                        c(fH);
                    } else if (fH.exists()) {
                        File fG = dVar.fG(i2);
                        fH.renameTo(fG);
                        long j = dVar.cps[i2];
                        long length = fG.length();
                        dVar.cps[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.cpw = null;
                if (!dVar.cpv && !z) {
                    this.cpl.remove(dVar.key);
                    this.cpk.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.cpv = true;
                    this.cpk.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.aqu;
                        this.aqu = 1 + j2;
                        dVar.cpx = j2;
                    }
                }
                this.cpk.flush();
                if (this.size > this.cpi || adw()) {
                    this.cpm.submit(this.cpn);
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

    public c jw(String str) {
        return g(str, -1L);
    }

    public static a b(File file, int i, int i2, long j) {
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
                if (aVar.cpe.exists()) {
                    try {
                        aVar.adt();
                        aVar.adu();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.adv();
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

    private synchronized c g(String str, long j) {
        d dVar;
        c cVar;
        adx();
        r(str);
        d dVar2 = this.cpl.get(str);
        if (j == -1 || (dVar2 != null && dVar2.cpx == j)) {
            if (dVar2 != null) {
                if (dVar2.cpw != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.cpl.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.cpw = cVar;
            this.cpk.write("DIRTY " + str + '\n');
            this.cpk.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
