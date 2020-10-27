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
    static final Pattern bWv = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream bWw = new b();
    private int ad;
    private final File bWA;
    private final int bWB;
    private long bWC;
    private final int bWD;
    private Writer bWE;
    private final File bWx;
    private final File bWy;
    private final File bWz;
    private long size = 0;
    private final LinkedHashMap<String, d> bWF = new LinkedHashMap<>(0, 0.75f, true);
    private long aoy = 0;
    final ThreadPoolExecutor bWG = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> bWH = new CallableC0292a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class CallableC0292a implements Callable<Void> {
        CallableC0292a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.bWE != null) {
                    a.this.trimToSize();
                    if (a.this.YD()) {
                        a.this.YC();
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
        private final d bWI;
        private boolean bWJ;
        private boolean bWK;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private class C0293a extends FilterOutputStream {
            /* synthetic */ C0293a(c cVar, OutputStream outputStream, CallableC0292a callableC0292a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.bWJ = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.bWJ = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.bWJ = true;
                }
            }

            private C0293a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.bWJ = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0292a callableC0292a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.bWJ) {
                a.this.a(this, false);
                a.this.remove(this.bWI.key);
            } else {
                a.this.a(this, true);
            }
            this.bWK = true;
        }

        public OutputStream gC(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.bWD) {
                synchronized (a.this) {
                    if (this.bWI.bWO == this) {
                        if (!this.bWI.bWN) {
                            this.written[i] = true;
                        }
                        File gE = this.bWI.gE(i);
                        try {
                            fileOutputStream = new FileOutputStream(gE);
                        } catch (FileNotFoundException e) {
                            a.this.bWx.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(gE);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.bWw;
                            }
                        }
                        outputStream = new C0293a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.bWD);
        }

        private c(d dVar) {
            this.bWI = dVar;
            this.written = dVar.bWN ? null : new boolean[a.this.bWD];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class d {
        private final long[] bWM;
        private boolean bWN;
        private c bWO;
        private long bWP;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0292a callableC0292a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bWM) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.bWM = new long[a.this.bWD];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.bWD) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.bWM[i] = Long.parseLong(strArr[i]);
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

        public File gD(int i) {
            return new File(a.this.bWx, this.key + "." + i);
        }

        public File gE(int i) {
            return new File(a.this.bWx, this.key + "." + i + ".tmp");
        }

        private IOException p(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes6.dex */
    public final class e implements Closeable {
        private final long[] bWM;
        private final long bWP;
        private final InputStream[] bWQ;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0292a callableC0292a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.bWQ) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream gF(int i) {
            return this.bWQ[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bWP = j;
            this.bWQ = inputStreamArr;
            this.bWM = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.bWx = file;
        this.bWB = i;
        this.bWy = new File(file, "journal");
        this.bWz = new File(file, "journal.tmp");
        this.bWA = new File(file, "journal.bkp");
        this.bWD = i2;
        this.bWC = j;
    }

    private void YA() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.bWy), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.bWB).equals(readLine3) || !Integer.toString(this.bWD).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.bWF.size();
                    if (bVar.YH()) {
                        YC();
                    } else {
                        this.bWE = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bWy, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void YB() {
        c(this.bWz);
        Iterator<d> it = this.bWF.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.bWO != null) {
                next.bWO = null;
                for (int i = 0; i < this.bWD; i++) {
                    c(next.gD(i));
                    c(next.gE(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.bWD; i2++) {
                    this.size += next.bWM[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void YC() {
        Writer writer = this.bWE;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bWz), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bWB));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bWD));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.bWF.values()) {
            if (dVar.bWO != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.bWy.exists()) {
            a(this.bWy, this.bWA, true);
        }
        a(this.bWz, this.bWy, false);
        this.bWA.delete();
        this.bWE = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bWy, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YD() {
        int i = this.ad;
        return i >= 2000 && i >= this.bWF.size();
    }

    private void YE() {
        if (this.bWE == null) {
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
                    this.bWF.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.bWF.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.bWF.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.bWN = true;
                dVar.bWO = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.bWO = new c(this, dVar, null);
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
        if (!bWv.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.bWC) {
            remove(this.bWF.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.bWE != null) {
            Iterator it = new ArrayList(this.bWF.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bWO != null) {
                    dVar.bWO.abort();
                }
            }
            trimToSize();
            this.bWE.close();
            this.bWE = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.bWx);
    }

    public synchronized void flush() {
        YE();
        trimToSize();
        this.bWE.flush();
    }

    public synchronized e jl(String str) {
        e eVar = null;
        synchronized (this) {
            YE();
            r(str);
            d dVar = this.bWF.get(str);
            if (dVar != null && dVar.bWN) {
                InputStream[] inputStreamArr = new InputStream[this.bWD];
                for (int i = 0; i < this.bWD; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.gD(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.bWD && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.bWE.append((CharSequence) ("READ " + str + '\n'));
                if (YD()) {
                    this.bWG.submit(this.bWH);
                }
                eVar = new e(this, str, dVar.bWP, inputStreamArr, dVar.bWM, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            YE();
            r(str);
            d dVar = this.bWF.get(str);
            if (dVar == null || dVar.bWO != null) {
                z = false;
            } else {
                for (int i = 0; i < this.bWD; i++) {
                    File gD = dVar.gD(i);
                    if (!gD.exists() || gD.delete()) {
                        this.size -= dVar.bWM[i];
                        dVar.bWM[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + gD);
                    }
                }
                this.ad++;
                this.bWE.append((CharSequence) ("REMOVE " + str + '\n'));
                this.bWF.remove(str);
                if (YD()) {
                    this.bWG.submit(this.bWH);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.bWI;
            if (dVar.bWO == cVar) {
                if (z && !dVar.bWN) {
                    for (int i = 0; i < this.bWD; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.gE(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.bWD; i2++) {
                    File gE = dVar.gE(i2);
                    if (!z) {
                        c(gE);
                    } else if (gE.exists()) {
                        File gD = dVar.gD(i2);
                        gE.renameTo(gD);
                        long j = dVar.bWM[i2];
                        long length = gD.length();
                        dVar.bWM[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.bWO = null;
                if (!dVar.bWN && !z) {
                    this.bWF.remove(dVar.key);
                    this.bWE.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.bWN = true;
                    this.bWE.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.aoy;
                        this.aoy = 1 + j2;
                        dVar.bWP = j2;
                    }
                }
                this.bWE.flush();
                if (this.size > this.bWC || YD()) {
                    this.bWG.submit(this.bWH);
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

    public c jm(String str) {
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
                if (aVar.bWy.exists()) {
                    try {
                        aVar.YA();
                        aVar.YB();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.YC();
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
        YE();
        r(str);
        d dVar2 = this.bWF.get(str);
        if (j == -1 || (dVar2 != null && dVar2.bWP == j)) {
            if (dVar2 != null) {
                if (dVar2.bWO != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.bWF.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.bWO = cVar;
            this.bWE.write("DIRTY " + str + '\n');
            this.bWE.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
