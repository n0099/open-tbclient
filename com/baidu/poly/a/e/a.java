package com.baidu.poly.a.e;

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
/* loaded from: classes11.dex */
public final class a implements Closeable {
    static final Pattern buy = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream buz = new b();
    private final File buA;
    private final File buB;
    private final File buC;
    private final File buD;
    private final int buE;
    private long buF;
    private final int buG;
    private Writer buH;
    private int buJ;
    private long size = 0;
    private final LinkedHashMap<String, d> buI = new LinkedHashMap<>(0, 0.75f, true);
    private long buK = 0;
    final ThreadPoolExecutor buL = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> buM = new CallableC0235a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class CallableC0235a implements Callable<Void> {
        CallableC0235a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.buH != null) {
                    a.this.trimToSize();
                    if (a.this.MT()) {
                        a.this.MS();
                        a.this.buJ = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes11.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes11.dex */
    public final class c {
        private final d buN;
        private boolean buO;
        private boolean buP;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        private class C0236a extends FilterOutputStream {
            /* synthetic */ C0236a(c cVar, OutputStream outputStream, CallableC0235a callableC0235a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.buO = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.buO = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.buO = true;
                }
            }

            private C0236a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.buO = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0235a callableC0235a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.buO) {
                a.this.a(this, false);
                a.this.remove(this.buN.key);
            } else {
                a.this.a(this, true);
            }
            this.buP = true;
        }

        private c(d dVar) {
            this.buN = dVar;
            this.written = dVar.buS ? null : new boolean[a.this.buG];
        }

        public OutputStream dG(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.buG) {
                synchronized (a.this) {
                    if (this.buN.buT == this) {
                        if (!this.buN.buS) {
                            this.written[i] = true;
                        }
                        File dI = this.buN.dI(i);
                        try {
                            fileOutputStream = new FileOutputStream(dI);
                        } catch (FileNotFoundException e) {
                            a.this.buA.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(dI);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.buz;
                            }
                        }
                        outputStream = new C0236a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.buG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class d {
        private final long[] buR;
        private boolean buS;
        private c buT;
        private long buU;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0235a callableC0235a) {
            this(str);
        }

        public String q() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.buR) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.buR = new long[a.this.buG];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.buG) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.buR[i] = Long.parseLong(strArr[i]);
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

        public File dH(int i) {
            return new File(a.this.buA, this.key + "." + i);
        }

        public File dI(int i) {
            return new File(a.this.buA, this.key + "." + i + ".tmp");
        }

        private IOException o(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes11.dex */
    public final class e implements Closeable {
        private final long[] buR;
        private final long buU;
        private final InputStream[] buV;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0235a callableC0235a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.buV) {
                com.baidu.poly.a.e.c.a(inputStream);
            }
        }

        public InputStream dJ(int i) {
            return this.buV[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.buU = j;
            this.buV = inputStreamArr;
            this.buR = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.buA = file;
        this.buE = i;
        this.buB = new File(file, "journal");
        this.buC = new File(file, "journal.tmp");
        this.buD = new File(file, "journal.bkp");
        this.buG = i2;
        this.buF = j;
    }

    private void MQ() {
        com.baidu.poly.a.e.b bVar = new com.baidu.poly.a.e.b(new FileInputStream(this.buB), com.baidu.poly.a.e.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.buE).equals(readLine3) || !Integer.toString(this.buG).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    p(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.buJ = i - this.buI.size();
                    if (bVar.t()) {
                        MS();
                    } else {
                        this.buH = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.buB, true), com.baidu.poly.a.e.c.US_ASCII));
                    }
                    com.baidu.poly.a.e.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.baidu.poly.a.e.c.a(bVar);
            throw th;
        }
    }

    private void MR() {
        c(this.buC);
        Iterator<d> it = this.buI.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.buT != null) {
                next.buT = null;
                for (int i = 0; i < this.buG; i++) {
                    c(next.dH(i));
                    c(next.dI(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.buG; i2++) {
                    this.size += next.buR[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void MS() {
        Writer writer = this.buH;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.buC), com.baidu.poly.a.e.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.buE));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.buG));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.buI.values()) {
            if (dVar.buT != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.q() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.buB.exists()) {
            a(this.buB, this.buD, true);
        }
        a(this.buC, this.buB, false);
        this.buD.delete();
        this.buH = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.buB, true), com.baidu.poly.a.e.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MT() {
        int i = this.buJ;
        return i >= 2000 && i >= this.buI.size();
    }

    private void MU() {
        if (this.buH == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void p(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                String substring2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.buI.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.buI.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.buI.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.buS = true;
                dVar.buT = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.buT = new c(this, dVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void q(String str) {
        if (!buy.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.buF) {
            remove(this.buI.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.buH != null) {
            Iterator it = new ArrayList(this.buI.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.buT != null) {
                    dVar.buT.abort();
                }
            }
            trimToSize();
            this.buH.close();
            this.buH = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.e.c.a(this.buA);
    }

    public synchronized void flush() {
        MU();
        trimToSize();
        this.buH.flush();
    }

    public synchronized e gv(String str) {
        e eVar = null;
        synchronized (this) {
            MU();
            q(str);
            d dVar = this.buI.get(str);
            if (dVar != null && dVar.buS) {
                InputStream[] inputStreamArr = new InputStream[this.buG];
                for (int i = 0; i < this.buG; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.dH(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.buG && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.e.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.buJ++;
                this.buH.append((CharSequence) ("READ " + str + '\n'));
                if (MT()) {
                    this.buL.submit(this.buM);
                }
                eVar = new e(this, str, dVar.buU, inputStreamArr, dVar.buR, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            MU();
            q(str);
            d dVar = this.buI.get(str);
            if (dVar == null || dVar.buT != null) {
                z = false;
            } else {
                for (int i = 0; i < this.buG; i++) {
                    File dH = dVar.dH(i);
                    if (!dH.exists() || dH.delete()) {
                        this.size -= dVar.buR[i];
                        dVar.buR[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + dH);
                    }
                }
                this.buJ++;
                this.buH.append((CharSequence) ("REMOVE " + str + '\n'));
                this.buI.remove(str);
                if (MT()) {
                    this.buL.submit(this.buM);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.buN;
            if (dVar.buT == cVar) {
                if (z && !dVar.buS) {
                    for (int i = 0; i < this.buG; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.dI(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.buG; i2++) {
                    File dI = dVar.dI(i2);
                    if (!z) {
                        c(dI);
                    } else if (dI.exists()) {
                        File dH = dVar.dH(i2);
                        dI.renameTo(dH);
                        long j = dVar.buR[i2];
                        long length = dH.length();
                        dVar.buR[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.buJ++;
                dVar.buT = null;
                if (!dVar.buS && !z) {
                    this.buI.remove(dVar.key);
                    this.buH.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.buS = true;
                    this.buH.write("CLEAN " + dVar.key + dVar.q() + '\n');
                    if (z) {
                        long j2 = this.buK;
                        this.buK = 1 + j2;
                        dVar.buU = j2;
                    }
                }
                this.buH.flush();
                if (this.size > this.buF || MT()) {
                    this.buL.submit(this.buM);
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

    public c gw(String str) {
        return g(str, -1L);
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
                if (aVar.buB.exists()) {
                    try {
                        aVar.MQ();
                        aVar.MR();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.l("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.MS();
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
        MU();
        q(str);
        d dVar2 = this.buI.get(str);
        if (j == -1 || (dVar2 != null && dVar2.buU == j)) {
            if (dVar2 != null) {
                if (dVar2.buT != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.buI.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.buT = cVar;
            this.buH.write("DIRTY " + str + '\n');
            this.buH.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
