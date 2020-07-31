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
    static final Pattern bzE = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream bzF = new b();
    private int ad;
    private final File bzG;
    private final File bzH;
    private final File bzI;
    private final File bzJ;
    private final int bzK;
    private long bzL;
    private final int bzM;
    private Writer bzN;
    private long size = 0;
    private final LinkedHashMap<String, d> bzO = new LinkedHashMap<>(0, 0.75f, true);
    private long ami = 0;
    final ThreadPoolExecutor bzP = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> bzQ = new CallableC0244a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class CallableC0244a implements Callable<Void> {
        CallableC0244a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.bzN != null) {
                    a.this.trimToSize();
                    if (a.this.Ok()) {
                        a.this.Oj();
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
        private final d bzR;
        private boolean bzS;
        private boolean bzT;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        private class C0245a extends FilterOutputStream {
            /* synthetic */ C0245a(c cVar, OutputStream outputStream, CallableC0244a callableC0244a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.bzS = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.bzS = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.bzS = true;
                }
            }

            private C0245a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.bzS = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0244a callableC0244a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.bzS) {
                a.this.a(this, false);
                a.this.remove(this.bzR.key);
            } else {
                a.this.a(this, true);
            }
            this.bzT = true;
        }

        public OutputStream dS(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.bzM) {
                synchronized (a.this) {
                    if (this.bzR.bzX == this) {
                        if (!this.bzR.bzW) {
                            this.written[i] = true;
                        }
                        File dU = this.bzR.dU(i);
                        try {
                            fileOutputStream = new FileOutputStream(dU);
                        } catch (FileNotFoundException e) {
                            a.this.bzG.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(dU);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.bzF;
                            }
                        }
                        outputStream = new C0245a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.bzM);
        }

        private c(d dVar) {
            this.bzR = dVar;
            this.written = dVar.bzW ? null : new boolean[a.this.bzM];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class d {
        private final long[] bzV;
        private boolean bzW;
        private c bzX;
        private long bzY;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0244a callableC0244a) {
            this(str);
        }

        public String A() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bzV) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.bzV = new long[a.this.bzM];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.bzM) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.bzV[i] = Long.parseLong(strArr[i]);
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

        public File dT(int i) {
            return new File(a.this.bzG, this.key + "." + i);
        }

        public File dU(int i) {
            return new File(a.this.bzG, this.key + "." + i + ".tmp");
        }

        private IOException n(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes9.dex */
    public final class e implements Closeable {
        private final long[] bzV;
        private final long bzY;
        private final InputStream[] bzZ;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0244a callableC0244a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.bzZ) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream dV(int i) {
            return this.bzZ[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bzY = j;
            this.bzZ = inputStreamArr;
            this.bzV = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.bzG = file;
        this.bzK = i;
        this.bzH = new File(file, "journal");
        this.bzI = new File(file, "journal.tmp");
        this.bzJ = new File(file, "journal.bkp");
        this.bzM = i2;
        this.bzL = j;
    }

    private void Oh() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.bzH), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.bzK).equals(readLine3) || !Integer.toString(this.bzM).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.bzO.size();
                    if (bVar.C()) {
                        Oj();
                    } else {
                        this.bzN = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bzH, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void Oi() {
        c(this.bzI);
        Iterator<d> it = this.bzO.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.bzX != null) {
                next.bzX = null;
                for (int i = 0; i < this.bzM; i++) {
                    c(next.dT(i));
                    c(next.dU(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.bzM; i2++) {
                    this.size += next.bzV[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Oj() {
        Writer writer = this.bzN;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bzI), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bzK));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bzM));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.bzO.values()) {
            if (dVar.bzX != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.A() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.bzH.exists()) {
            a(this.bzH, this.bzJ, true);
        }
        a(this.bzI, this.bzH, false);
        this.bzJ.delete();
        this.bzN = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bzH, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ok() {
        int i = this.ad;
        return i >= 2000 && i >= this.bzO.size();
    }

    private void Ol() {
        if (this.bzN == null) {
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
                    this.bzO.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.bzO.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.bzO.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.bzW = true;
                dVar.bzX = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.bzX = new c(this, dVar, null);
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
        if (!bzE.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.bzL) {
            remove(this.bzO.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.bzN != null) {
            Iterator it = new ArrayList(this.bzO.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bzX != null) {
                    dVar.bzX.abort();
                }
            }
            trimToSize();
            this.bzN.close();
            this.bzN = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.bzG);
    }

    public synchronized void flush() {
        Ol();
        trimToSize();
        this.bzN.flush();
    }

    public synchronized e gC(String str) {
        e eVar = null;
        synchronized (this) {
            Ol();
            r(str);
            d dVar = this.bzO.get(str);
            if (dVar != null && dVar.bzW) {
                InputStream[] inputStreamArr = new InputStream[this.bzM];
                for (int i = 0; i < this.bzM; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.dT(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.bzM && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.bzN.append((CharSequence) ("READ " + str + '\n'));
                if (Ok()) {
                    this.bzP.submit(this.bzQ);
                }
                eVar = new e(this, str, dVar.bzY, inputStreamArr, dVar.bzV, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            Ol();
            r(str);
            d dVar = this.bzO.get(str);
            if (dVar == null || dVar.bzX != null) {
                z = false;
            } else {
                for (int i = 0; i < this.bzM; i++) {
                    File dT = dVar.dT(i);
                    if (!dT.exists() || dT.delete()) {
                        this.size -= dVar.bzV[i];
                        dVar.bzV[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + dT);
                    }
                }
                this.ad++;
                this.bzN.append((CharSequence) ("REMOVE " + str + '\n'));
                this.bzO.remove(str);
                if (Ok()) {
                    this.bzP.submit(this.bzQ);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.bzR;
            if (dVar.bzX == cVar) {
                if (z && !dVar.bzW) {
                    for (int i = 0; i < this.bzM; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.dU(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.bzM; i2++) {
                    File dU = dVar.dU(i2);
                    if (!z) {
                        c(dU);
                    } else if (dU.exists()) {
                        File dT = dVar.dT(i2);
                        dU.renameTo(dT);
                        long j = dVar.bzV[i2];
                        long length = dT.length();
                        dVar.bzV[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.bzX = null;
                if (!dVar.bzW && !z) {
                    this.bzO.remove(dVar.key);
                    this.bzN.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.bzW = true;
                    this.bzN.write("CLEAN " + dVar.key + dVar.A() + '\n');
                    if (z) {
                        long j2 = this.ami;
                        this.ami = 1 + j2;
                        dVar.bzY = j2;
                    }
                }
                this.bzN.flush();
                if (this.size > this.bzL || Ok()) {
                    this.bzP.submit(this.bzQ);
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

    public c gD(String str) {
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
                if (aVar.bzH.exists()) {
                    try {
                        aVar.Oh();
                        aVar.Oi();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.l("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.Oj();
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
        Ol();
        r(str);
        d dVar2 = this.bzO.get(str);
        if (j == -1 || (dVar2 != null && dVar2.bzY == j)) {
            if (dVar2 != null) {
                if (dVar2.bzX != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.bzO.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.bzX = cVar;
            this.bzN.write("DIRTY " + str + '\n');
            this.bzN.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
