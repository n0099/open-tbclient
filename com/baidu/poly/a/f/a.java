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
    static final Pattern bFk = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream bFl = new b();
    private int ad;
    private final File bFm;
    private final File bFn;
    private final File bFo;
    private final File bFp;
    private final int bFq;
    private long bFr;
    private final int bFs;
    private Writer bFt;
    private long size = 0;
    private final LinkedHashMap<String, d> bFu = new LinkedHashMap<>(0, 0.75f, true);
    private long ank = 0;
    final ThreadPoolExecutor bFv = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> bFw = new CallableC0265a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class CallableC0265a implements Callable<Void> {
        CallableC0265a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.bFt != null) {
                    a.this.trimToSize();
                    if (a.this.Ud()) {
                        a.this.Uc();
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
        private final d bFx;
        private boolean bFy;
        private boolean bFz;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private class C0266a extends FilterOutputStream {
            /* synthetic */ C0266a(c cVar, OutputStream outputStream, CallableC0265a callableC0265a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.bFy = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.bFy = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.bFy = true;
                }
            }

            private C0266a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.bFy = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0265a callableC0265a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.bFy) {
                a.this.a(this, false);
                a.this.remove(this.bFx.key);
            } else {
                a.this.a(this, true);
            }
            this.bFz = true;
        }

        public OutputStream fO(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.bFs) {
                synchronized (a.this) {
                    if (this.bFx.bFD == this) {
                        if (!this.bFx.bFC) {
                            this.written[i] = true;
                        }
                        File fQ = this.bFx.fQ(i);
                        try {
                            fileOutputStream = new FileOutputStream(fQ);
                        } catch (FileNotFoundException e) {
                            a.this.bFm.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(fQ);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.bFl;
                            }
                        }
                        outputStream = new C0266a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.bFs);
        }

        private c(d dVar) {
            this.bFx = dVar;
            this.written = dVar.bFC ? null : new boolean[a.this.bFs];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class d {
        private final long[] bFB;
        private boolean bFC;
        private c bFD;
        private long bFE;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0265a callableC0265a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bFB) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.bFB = new long[a.this.bFs];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.bFs) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.bFB[i] = Long.parseLong(strArr[i]);
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

        public File fP(int i) {
            return new File(a.this.bFm, this.key + "." + i);
        }

        public File fQ(int i) {
            return new File(a.this.bFm, this.key + "." + i + ".tmp");
        }

        private IOException n(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes6.dex */
    public final class e implements Closeable {
        private final long[] bFB;
        private final long bFE;
        private final InputStream[] bFF;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0265a callableC0265a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.bFF) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream fR(int i) {
            return this.bFF[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bFE = j;
            this.bFF = inputStreamArr;
            this.bFB = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.bFm = file;
        this.bFq = i;
        this.bFn = new File(file, "journal");
        this.bFo = new File(file, "journal.tmp");
        this.bFp = new File(file, "journal.bkp");
        this.bFs = i2;
        this.bFr = j;
    }

    private void Ua() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.bFn), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.bFq).equals(readLine3) || !Integer.toString(this.bFs).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.bFu.size();
                    if (bVar.Uh()) {
                        Uc();
                    } else {
                        this.bFt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bFn, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void Ub() {
        c(this.bFo);
        Iterator<d> it = this.bFu.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.bFD != null) {
                next.bFD = null;
                for (int i = 0; i < this.bFs; i++) {
                    c(next.fP(i));
                    c(next.fQ(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.bFs; i2++) {
                    this.size += next.bFB[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Uc() {
        Writer writer = this.bFt;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bFo), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bFq));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bFs));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.bFu.values()) {
            if (dVar.bFD != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.bFn.exists()) {
            a(this.bFn, this.bFp, true);
        }
        a(this.bFo, this.bFn, false);
        this.bFp.delete();
        this.bFt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bFn, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ud() {
        int i = this.ad;
        return i >= 2000 && i >= this.bFu.size();
    }

    private void Ue() {
        if (this.bFt == null) {
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
                    this.bFu.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.bFu.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.bFu.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.bFC = true;
                dVar.bFD = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.bFD = new c(this, dVar, null);
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
        if (!bFk.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.bFr) {
            remove(this.bFu.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.bFt != null) {
            Iterator it = new ArrayList(this.bFu.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bFD != null) {
                    dVar.bFD.abort();
                }
            }
            trimToSize();
            this.bFt.close();
            this.bFt = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.bFm);
    }

    public synchronized void flush() {
        Ue();
        trimToSize();
        this.bFt.flush();
    }

    public synchronized e hW(String str) {
        e eVar = null;
        synchronized (this) {
            Ue();
            r(str);
            d dVar = this.bFu.get(str);
            if (dVar != null && dVar.bFC) {
                InputStream[] inputStreamArr = new InputStream[this.bFs];
                for (int i = 0; i < this.bFs; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.fP(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.bFs && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.bFt.append((CharSequence) ("READ " + str + '\n'));
                if (Ud()) {
                    this.bFv.submit(this.bFw);
                }
                eVar = new e(this, str, dVar.bFE, inputStreamArr, dVar.bFB, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            Ue();
            r(str);
            d dVar = this.bFu.get(str);
            if (dVar == null || dVar.bFD != null) {
                z = false;
            } else {
                for (int i = 0; i < this.bFs; i++) {
                    File fP = dVar.fP(i);
                    if (!fP.exists() || fP.delete()) {
                        this.size -= dVar.bFB[i];
                        dVar.bFB[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + fP);
                    }
                }
                this.ad++;
                this.bFt.append((CharSequence) ("REMOVE " + str + '\n'));
                this.bFu.remove(str);
                if (Ud()) {
                    this.bFv.submit(this.bFw);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.bFx;
            if (dVar.bFD == cVar) {
                if (z && !dVar.bFC) {
                    for (int i = 0; i < this.bFs; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.fQ(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.bFs; i2++) {
                    File fQ = dVar.fQ(i2);
                    if (!z) {
                        c(fQ);
                    } else if (fQ.exists()) {
                        File fP = dVar.fP(i2);
                        fQ.renameTo(fP);
                        long j = dVar.bFB[i2];
                        long length = fP.length();
                        dVar.bFB[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.bFD = null;
                if (!dVar.bFC && !z) {
                    this.bFu.remove(dVar.key);
                    this.bFt.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.bFC = true;
                    this.bFt.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.ank;
                        this.ank = 1 + j2;
                        dVar.bFE = j2;
                    }
                }
                this.bFt.flush();
                if (this.size > this.bFr || Ud()) {
                    this.bFv.submit(this.bFw);
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

    public c hX(String str) {
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
                if (aVar.bFn.exists()) {
                    try {
                        aVar.Ua();
                        aVar.Ub();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.Uc();
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
        Ue();
        r(str);
        d dVar2 = this.bFu.get(str);
        if (j == -1 || (dVar2 != null && dVar2.bFE == j)) {
            if (dVar2 != null) {
                if (dVar2.bFD != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.bFu.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.bFD = cVar;
            this.bFt.write("DIRTY " + str + '\n');
            this.bFt.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
