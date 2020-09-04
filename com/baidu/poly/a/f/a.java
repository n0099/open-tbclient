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
    static final Pattern bFo = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream bFp = new b();
    private int ad;
    private final File bFq;
    private final File bFr;
    private final File bFs;
    private final File bFt;
    private final int bFu;
    private long bFv;
    private final int bFw;
    private Writer bFx;
    private long size = 0;
    private final LinkedHashMap<String, d> bFy = new LinkedHashMap<>(0, 0.75f, true);
    private long anm = 0;
    final ThreadPoolExecutor bFz = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> bFA = new CallableC0265a();

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
                if (a.this.bFx != null) {
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
        private final d bFB;
        private boolean bFC;
        private boolean bFD;
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
                    c.this.bFC = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.bFC = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.bFC = true;
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
                    c.this.bFC = true;
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
            if (this.bFC) {
                a.this.a(this, false);
                a.this.remove(this.bFB.key);
            } else {
                a.this.a(this, true);
            }
            this.bFD = true;
        }

        public OutputStream fO(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.bFw) {
                synchronized (a.this) {
                    if (this.bFB.bFH == this) {
                        if (!this.bFB.bFG) {
                            this.written[i] = true;
                        }
                        File fQ = this.bFB.fQ(i);
                        try {
                            fileOutputStream = new FileOutputStream(fQ);
                        } catch (FileNotFoundException e) {
                            a.this.bFq.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(fQ);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.bFp;
                            }
                        }
                        outputStream = new C0266a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.bFw);
        }

        private c(d dVar) {
            this.bFB = dVar;
            this.written = dVar.bFG ? null : new boolean[a.this.bFw];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class d {
        private final long[] bFF;
        private boolean bFG;
        private c bFH;
        private long bFI;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0265a callableC0265a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bFF) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.bFF = new long[a.this.bFw];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.bFw) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.bFF[i] = Long.parseLong(strArr[i]);
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
            return new File(a.this.bFq, this.key + "." + i);
        }

        public File fQ(int i) {
            return new File(a.this.bFq, this.key + "." + i + ".tmp");
        }

        private IOException n(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes6.dex */
    public final class e implements Closeable {
        private final long[] bFF;
        private final long bFI;
        private final InputStream[] bFJ;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0265a callableC0265a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.bFJ) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream fR(int i) {
            return this.bFJ[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bFI = j;
            this.bFJ = inputStreamArr;
            this.bFF = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.bFq = file;
        this.bFu = i;
        this.bFr = new File(file, "journal");
        this.bFs = new File(file, "journal.tmp");
        this.bFt = new File(file, "journal.bkp");
        this.bFw = i2;
        this.bFv = j;
    }

    private void Ua() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.bFr), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.bFu).equals(readLine3) || !Integer.toString(this.bFw).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.bFy.size();
                    if (bVar.Uh()) {
                        Uc();
                    } else {
                        this.bFx = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bFr, true), com.baidu.poly.a.f.c.US_ASCII));
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
        c(this.bFs);
        Iterator<d> it = this.bFy.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.bFH != null) {
                next.bFH = null;
                for (int i = 0; i < this.bFw; i++) {
                    c(next.fP(i));
                    c(next.fQ(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.bFw; i2++) {
                    this.size += next.bFF[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Uc() {
        Writer writer = this.bFx;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bFs), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bFu));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bFw));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.bFy.values()) {
            if (dVar.bFH != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.bFr.exists()) {
            a(this.bFr, this.bFt, true);
        }
        a(this.bFs, this.bFr, false);
        this.bFt.delete();
        this.bFx = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bFr, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ud() {
        int i = this.ad;
        return i >= 2000 && i >= this.bFy.size();
    }

    private void Ue() {
        if (this.bFx == null) {
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
                    this.bFy.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.bFy.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.bFy.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.bFG = true;
                dVar.bFH = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.bFH = new c(this, dVar, null);
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
        if (!bFo.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.bFv) {
            remove(this.bFy.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.bFx != null) {
            Iterator it = new ArrayList(this.bFy.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bFH != null) {
                    dVar.bFH.abort();
                }
            }
            trimToSize();
            this.bFx.close();
            this.bFx = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.bFq);
    }

    public synchronized void flush() {
        Ue();
        trimToSize();
        this.bFx.flush();
    }

    public synchronized e hX(String str) {
        e eVar = null;
        synchronized (this) {
            Ue();
            r(str);
            d dVar = this.bFy.get(str);
            if (dVar != null && dVar.bFG) {
                InputStream[] inputStreamArr = new InputStream[this.bFw];
                for (int i = 0; i < this.bFw; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.fP(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.bFw && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.bFx.append((CharSequence) ("READ " + str + '\n'));
                if (Ud()) {
                    this.bFz.submit(this.bFA);
                }
                eVar = new e(this, str, dVar.bFI, inputStreamArr, dVar.bFF, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            Ue();
            r(str);
            d dVar = this.bFy.get(str);
            if (dVar == null || dVar.bFH != null) {
                z = false;
            } else {
                for (int i = 0; i < this.bFw; i++) {
                    File fP = dVar.fP(i);
                    if (!fP.exists() || fP.delete()) {
                        this.size -= dVar.bFF[i];
                        dVar.bFF[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + fP);
                    }
                }
                this.ad++;
                this.bFx.append((CharSequence) ("REMOVE " + str + '\n'));
                this.bFy.remove(str);
                if (Ud()) {
                    this.bFz.submit(this.bFA);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.bFB;
            if (dVar.bFH == cVar) {
                if (z && !dVar.bFG) {
                    for (int i = 0; i < this.bFw; i++) {
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
                for (int i2 = 0; i2 < this.bFw; i2++) {
                    File fQ = dVar.fQ(i2);
                    if (!z) {
                        c(fQ);
                    } else if (fQ.exists()) {
                        File fP = dVar.fP(i2);
                        fQ.renameTo(fP);
                        long j = dVar.bFF[i2];
                        long length = fP.length();
                        dVar.bFF[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.bFH = null;
                if (!dVar.bFG && !z) {
                    this.bFy.remove(dVar.key);
                    this.bFx.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.bFG = true;
                    this.bFx.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.anm;
                        this.anm = 1 + j2;
                        dVar.bFI = j2;
                    }
                }
                this.bFx.flush();
                if (this.size > this.bFv || Ud()) {
                    this.bFz.submit(this.bFA);
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

    public c hY(String str) {
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
                if (aVar.bFr.exists()) {
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
        d dVar2 = this.bFy.get(str);
        if (j == -1 || (dVar2 != null && dVar2.bFI == j)) {
            if (dVar2 != null) {
                if (dVar2.bFH != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.bFy.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.bFH = cVar;
            this.bFx.write("DIRTY " + str + '\n');
            this.bFx.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
