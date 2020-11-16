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
    static final Pattern cau = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream cav = new b();
    private int ad;
    private final int caA;
    private long caB;
    private final int caC;
    private Writer caD;
    private final File caw;
    private final File cax;
    private final File cay;
    private final File caz;
    private long size = 0;
    private final LinkedHashMap<String, d> caE = new LinkedHashMap<>(0, 0.75f, true);
    private long aoE = 0;
    final ThreadPoolExecutor caF = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> caG = new CallableC0302a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class CallableC0302a implements Callable<Void> {
        CallableC0302a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.caD != null) {
                    a.this.trimToSize();
                    if (a.this.aat()) {
                        a.this.aas();
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
        private final d caH;
        private boolean caI;
        private boolean caJ;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private class C0303a extends FilterOutputStream {
            /* synthetic */ C0303a(c cVar, OutputStream outputStream, CallableC0302a callableC0302a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.caI = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.caI = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.caI = true;
                }
            }

            private C0303a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.caI = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0302a callableC0302a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.caI) {
                a.this.a(this, false);
                a.this.remove(this.caH.key);
            } else {
                a.this.a(this, true);
            }
            this.caJ = true;
        }

        public OutputStream gI(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.caC) {
                synchronized (a.this) {
                    if (this.caH.caN == this) {
                        if (!this.caH.caM) {
                            this.written[i] = true;
                        }
                        File gK = this.caH.gK(i);
                        try {
                            fileOutputStream = new FileOutputStream(gK);
                        } catch (FileNotFoundException e) {
                            a.this.caw.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(gK);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.cav;
                            }
                        }
                        outputStream = new C0303a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.caC);
        }

        private c(d dVar) {
            this.caH = dVar;
            this.written = dVar.caM ? null : new boolean[a.this.caC];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class d {
        private final long[] caL;
        private boolean caM;
        private c caN;
        private long caO;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0302a callableC0302a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.caL) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.caL = new long[a.this.caC];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.caC) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.caL[i] = Long.parseLong(strArr[i]);
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

        public File gJ(int i) {
            return new File(a.this.caw, this.key + "." + i);
        }

        public File gK(int i) {
            return new File(a.this.caw, this.key + "." + i + ".tmp");
        }

        private IOException p(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes6.dex */
    public final class e implements Closeable {
        private final long[] caL;
        private final long caO;
        private final InputStream[] caP;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0302a callableC0302a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.caP) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream gL(int i) {
            return this.caP[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.caO = j;
            this.caP = inputStreamArr;
            this.caL = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.caw = file;
        this.caA = i;
        this.cax = new File(file, "journal");
        this.cay = new File(file, "journal.tmp");
        this.caz = new File(file, "journal.bkp");
        this.caC = i2;
        this.caB = j;
    }

    private void aaq() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.cax), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.caA).equals(readLine3) || !Integer.toString(this.caC).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.caE.size();
                    if (bVar.aax()) {
                        aas();
                    } else {
                        this.caD = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cax, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void aar() {
        c(this.cay);
        Iterator<d> it = this.caE.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.caN != null) {
                next.caN = null;
                for (int i = 0; i < this.caC; i++) {
                    c(next.gJ(i));
                    c(next.gK(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.caC; i2++) {
                    this.size += next.caL[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aas() {
        Writer writer = this.caD;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cay), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.caA));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.caC));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.caE.values()) {
            if (dVar.caN != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.cax.exists()) {
            a(this.cax, this.caz, true);
        }
        a(this.cay, this.cax, false);
        this.caz.delete();
        this.caD = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cax, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aat() {
        int i = this.ad;
        return i >= 2000 && i >= this.caE.size();
    }

    private void aau() {
        if (this.caD == null) {
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
                    this.caE.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.caE.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.caE.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.caM = true;
                dVar.caN = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.caN = new c(this, dVar, null);
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
        if (!cau.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.caB) {
            remove(this.caE.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.caD != null) {
            Iterator it = new ArrayList(this.caE.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.caN != null) {
                    dVar.caN.abort();
                }
            }
            trimToSize();
            this.caD.close();
            this.caD = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.caw);
    }

    public synchronized void flush() {
        aau();
        trimToSize();
        this.caD.flush();
    }

    public synchronized e js(String str) {
        e eVar = null;
        synchronized (this) {
            aau();
            r(str);
            d dVar = this.caE.get(str);
            if (dVar != null && dVar.caM) {
                InputStream[] inputStreamArr = new InputStream[this.caC];
                for (int i = 0; i < this.caC; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.gJ(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.caC && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.caD.append((CharSequence) ("READ " + str + '\n'));
                if (aat()) {
                    this.caF.submit(this.caG);
                }
                eVar = new e(this, str, dVar.caO, inputStreamArr, dVar.caL, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            aau();
            r(str);
            d dVar = this.caE.get(str);
            if (dVar == null || dVar.caN != null) {
                z = false;
            } else {
                for (int i = 0; i < this.caC; i++) {
                    File gJ = dVar.gJ(i);
                    if (!gJ.exists() || gJ.delete()) {
                        this.size -= dVar.caL[i];
                        dVar.caL[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + gJ);
                    }
                }
                this.ad++;
                this.caD.append((CharSequence) ("REMOVE " + str + '\n'));
                this.caE.remove(str);
                if (aat()) {
                    this.caF.submit(this.caG);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.caH;
            if (dVar.caN == cVar) {
                if (z && !dVar.caM) {
                    for (int i = 0; i < this.caC; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.gK(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.caC; i2++) {
                    File gK = dVar.gK(i2);
                    if (!z) {
                        c(gK);
                    } else if (gK.exists()) {
                        File gJ = dVar.gJ(i2);
                        gK.renameTo(gJ);
                        long j = dVar.caL[i2];
                        long length = gJ.length();
                        dVar.caL[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.caN = null;
                if (!dVar.caM && !z) {
                    this.caE.remove(dVar.key);
                    this.caD.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.caM = true;
                    this.caD.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.aoE;
                        this.aoE = 1 + j2;
                        dVar.caO = j2;
                    }
                }
                this.caD.flush();
                if (this.size > this.caB || aat()) {
                    this.caF.submit(this.caG);
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

    public c jt(String str) {
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
                if (aVar.cax.exists()) {
                    try {
                        aVar.aaq();
                        aVar.aar();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.aas();
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
        aau();
        r(str);
        d dVar2 = this.caE.get(str);
        if (j == -1 || (dVar2 != null && dVar2.caO == j)) {
            if (dVar2 != null) {
                if (dVar2.caN != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.caE.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.caN = cVar;
            this.caD.write("DIRTY " + str + '\n');
            this.caD.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
