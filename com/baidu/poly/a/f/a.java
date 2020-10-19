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
/* loaded from: classes6.dex */
public final class a implements Closeable {
    static final Pattern bNY = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream bNZ = new b();
    private int ad;
    private final File bOa;
    private final File bOb;
    private final File bOc;
    private final File bOd;
    private final int bOe;
    private long bOf;
    private final int bOg;
    private Writer bOh;
    private long size = 0;
    private final LinkedHashMap<String, d> bOi = new LinkedHashMap<>(0, 0.75f, true);
    private long aox = 0;
    final ThreadPoolExecutor bOj = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> bOk = new CallableC0278a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class CallableC0278a implements Callable<Void> {
        CallableC0278a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.bOh != null) {
                    a.this.trimToSize();
                    if (a.this.WJ()) {
                        a.this.WI();
                        a.this.ad = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes6.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes6.dex */
    public final class c {
        private final d bOl;
        private boolean bOm;
        private boolean bOn;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private class C0279a extends FilterOutputStream {
            /* synthetic */ C0279a(c cVar, OutputStream outputStream, CallableC0278a callableC0278a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.bOm = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.bOm = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.bOm = true;
                }
            }

            private C0279a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.bOm = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0278a callableC0278a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.bOm) {
                a.this.a(this, false);
                a.this.remove(this.bOl.key);
            } else {
                a.this.a(this, true);
            }
            this.bOn = true;
        }

        public OutputStream gr(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.bOg) {
                synchronized (a.this) {
                    if (this.bOl.bOr == this) {
                        if (!this.bOl.bOq) {
                            this.written[i] = true;
                        }
                        File gt = this.bOl.gt(i);
                        try {
                            fileOutputStream = new FileOutputStream(gt);
                        } catch (FileNotFoundException e) {
                            a.this.bOa.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(gt);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.bNZ;
                            }
                        }
                        outputStream = new C0279a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.bOg);
        }

        private c(d dVar) {
            this.bOl = dVar;
            this.written = dVar.bOq ? null : new boolean[a.this.bOg];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class d {
        private final long[] bOp;
        private boolean bOq;
        private c bOr;
        private long bOs;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0278a callableC0278a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bOp) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.bOp = new long[a.this.bOg];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.bOg) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.bOp[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException e) {
                        o(strArr);
                        throw null;
                    }
                }
                return;
            }
            o(strArr);
            throw null;
        }

        public File gs(int i) {
            return new File(a.this.bOa, this.key + "." + i);
        }

        public File gt(int i) {
            return new File(a.this.bOa, this.key + "." + i + ".tmp");
        }

        private IOException o(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes6.dex */
    public final class e implements Closeable {
        private final long[] bOp;
        private final long bOs;
        private final InputStream[] bOt;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0278a callableC0278a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.bOt) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream gu(int i) {
            return this.bOt[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bOs = j;
            this.bOt = inputStreamArr;
            this.bOp = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.bOa = file;
        this.bOe = i;
        this.bOb = new File(file, "journal");
        this.bOc = new File(file, "journal.tmp");
        this.bOd = new File(file, "journal.bkp");
        this.bOg = i2;
        this.bOf = j;
    }

    private void WG() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.bOb), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.bOe).equals(readLine3) || !Integer.toString(this.bOg).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.bOi.size();
                    if (bVar.WN()) {
                        WI();
                    } else {
                        this.bOh = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bOb, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void WH() {
        c(this.bOc);
        Iterator<d> it = this.bOi.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.bOr != null) {
                next.bOr = null;
                for (int i = 0; i < this.bOg; i++) {
                    c(next.gs(i));
                    c(next.gt(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.bOg; i2++) {
                    this.size += next.bOp[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void WI() {
        Writer writer = this.bOh;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bOc), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bOe));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bOg));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.bOi.values()) {
            if (dVar.bOr != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.bOb.exists()) {
            a(this.bOb, this.bOd, true);
        }
        a(this.bOc, this.bOb, false);
        this.bOd.delete();
        this.bOh = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bOb, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WJ() {
        int i = this.ad;
        return i >= 2000 && i >= this.bOi.size();
    }

    private void WK() {
        if (this.bOh == null) {
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
                    this.bOi.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.bOi.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.bOi.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.bOq = true;
                dVar.bOr = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.bOr = new c(this, dVar, null);
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
        if (!bNY.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.bOf) {
            remove(this.bOi.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.bOh != null) {
            Iterator it = new ArrayList(this.bOi.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bOr != null) {
                    dVar.bOr.abort();
                }
            }
            trimToSize();
            this.bOh.close();
            this.bOh = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.bOa);
    }

    public synchronized void flush() {
        WK();
        trimToSize();
        this.bOh.flush();
    }

    public synchronized e iS(String str) {
        e eVar = null;
        synchronized (this) {
            WK();
            r(str);
            d dVar = this.bOi.get(str);
            if (dVar != null && dVar.bOq) {
                InputStream[] inputStreamArr = new InputStream[this.bOg];
                for (int i = 0; i < this.bOg; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.gs(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.bOg && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.bOh.append((CharSequence) ("READ " + str + '\n'));
                if (WJ()) {
                    this.bOj.submit(this.bOk);
                }
                eVar = new e(this, str, dVar.bOs, inputStreamArr, dVar.bOp, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            WK();
            r(str);
            d dVar = this.bOi.get(str);
            if (dVar == null || dVar.bOr != null) {
                z = false;
            } else {
                for (int i = 0; i < this.bOg; i++) {
                    File gs = dVar.gs(i);
                    if (!gs.exists() || gs.delete()) {
                        this.size -= dVar.bOp[i];
                        dVar.bOp[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + gs);
                    }
                }
                this.ad++;
                this.bOh.append((CharSequence) ("REMOVE " + str + '\n'));
                this.bOi.remove(str);
                if (WJ()) {
                    this.bOj.submit(this.bOk);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.bOl;
            if (dVar.bOr == cVar) {
                if (z && !dVar.bOq) {
                    for (int i = 0; i < this.bOg; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.gt(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.bOg; i2++) {
                    File gt = dVar.gt(i2);
                    if (!z) {
                        c(gt);
                    } else if (gt.exists()) {
                        File gs = dVar.gs(i2);
                        gt.renameTo(gs);
                        long j = dVar.bOp[i2];
                        long length = gs.length();
                        dVar.bOp[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.bOr = null;
                if (!dVar.bOq && !z) {
                    this.bOi.remove(dVar.key);
                    this.bOh.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.bOq = true;
                    this.bOh.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.aox;
                        this.aox = 1 + j2;
                        dVar.bOs = j2;
                    }
                }
                this.bOh.flush();
                if (this.size > this.bOf || WJ()) {
                    this.bOj.submit(this.bOk);
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

    public c iT(String str) {
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
                if (aVar.bOb.exists()) {
                    try {
                        aVar.WG();
                        aVar.WH();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.WI();
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
        WK();
        r(str);
        d dVar2 = this.bOi.get(str);
        if (j == -1 || (dVar2 != null && dVar2.bOs == j)) {
            if (dVar2 != null) {
                if (dVar2.bOr != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.bOi.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.bOr = cVar;
            this.bOh.write("DIRTY " + str + '\n');
            this.bOh.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
