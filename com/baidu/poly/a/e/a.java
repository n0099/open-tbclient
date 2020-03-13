package com.baidu.poly.a.e;

import com.baidu.android.imsdk.utils.HanziToPinyin;
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
    static final Pattern aQG = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream aQH = new b();
    private final File aQI;
    private final File aQJ;
    private final File aQK;
    private final File aQL;
    private final int aQM;
    private long aQN;
    private final int aQO;
    private Writer aQP;
    private int aQR;
    private long size = 0;
    private final LinkedHashMap<String, d> aQQ = new LinkedHashMap<>(0, 0.75f, true);
    private long aQS = 0;
    final ThreadPoolExecutor aQT = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> aQU = new CallableC0156a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class CallableC0156a implements Callable<Void> {
        CallableC0156a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.aQP != null) {
                    a.this.trimToSize();
                    if (a.this.EE()) {
                        a.this.Y();
                        a.this.aQR = 0;
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
        private final d aQV;
        private boolean aQW;
        private boolean aQX;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        private class C0157a extends FilterOutputStream {
            /* synthetic */ C0157a(c cVar, OutputStream outputStream, CallableC0156a callableC0156a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.aQW = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.aQW = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.aQW = true;
                }
            }

            private C0157a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.aQW = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0156a callableC0156a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.aQW) {
                a.this.a(this, false);
                a.this.remove(this.aQV.key);
            } else {
                a.this.a(this, true);
            }
            this.aQX = true;
        }

        private c(d dVar) {
            this.aQV = dVar;
            this.written = dVar.aRa ? null : new boolean[a.this.aQO];
        }

        public OutputStream du(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.aQO) {
                synchronized (a.this) {
                    if (this.aQV.aRb == this) {
                        if (!this.aQV.aRa) {
                            this.written[i] = true;
                        }
                        File dw = this.aQV.dw(i);
                        try {
                            fileOutputStream = new FileOutputStream(dw);
                        } catch (FileNotFoundException e) {
                            a.this.aQI.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(dw);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.aQH;
                            }
                        }
                        outputStream = new C0157a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.aQO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class d {
        private final long[] aQZ;
        private boolean aRa;
        private c aRb;
        private long aRc;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0156a callableC0156a) {
            this(str);
        }

        public String j() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aQZ) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.aQZ = new long[a.this.aQO];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.aQO) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.aQZ[i] = Long.parseLong(strArr[i]);
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

        public File dv(int i) {
            return new File(a.this.aQI, this.key + "." + i);
        }

        public File dw(int i) {
            return new File(a.this.aQI, this.key + "." + i + ".tmp");
        }

        private IOException p(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes11.dex */
    public final class e implements Closeable {
        private final long[] aQZ;
        private final long aRc;
        private final InputStream[] aRd;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0156a callableC0156a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.aRd) {
                com.baidu.poly.a.e.c.a(inputStream);
            }
        }

        public InputStream dx(int i) {
            return this.aRd[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aRc = j;
            this.aRd = inputStreamArr;
            this.aQZ = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.aQI = file;
        this.aQM = i;
        this.aQJ = new File(file, "journal");
        this.aQK = new File(file, "journal.tmp");
        this.aQL = new File(file, "journal.bkp");
        this.aQO = i2;
        this.aQN = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean EE() {
        int i = this.aQR;
        return i >= 2000 && i >= this.aQQ.size();
    }

    private void U() {
        if (this.aQP == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void W() {
        b(this.aQK);
        Iterator<d> it = this.aQQ.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.aRb != null) {
                next.aRb = null;
                for (int i = 0; i < this.aQO; i++) {
                    b(next.dv(i));
                    b(next.dw(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.aQO; i2++) {
                    this.size += next.aQZ[i2];
                }
            }
        }
    }

    private void X() {
        com.baidu.poly.a.e.b bVar = new com.baidu.poly.a.e.b(new FileInputStream(this.aQJ), com.baidu.poly.a.e.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.aQM).equals(readLine3) || !Integer.toString(this.aQO).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    o(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.aQR = i - this.aQQ.size();
                    if (bVar.l()) {
                        Y();
                    } else {
                        this.aQP = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aQJ, true), com.baidu.poly.a.e.c.US_ASCII));
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Y() {
        Writer writer = this.aQP;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aQK), com.baidu.poly.a.e.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aQM));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aQO));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.aQQ.values()) {
            if (dVar.aRb != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.j() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.aQJ.exists()) {
            a(this.aQJ, this.aQL, true);
        }
        a(this.aQK, this.aQJ, false);
        this.aQL.delete();
        this.aQP = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aQJ, true), com.baidu.poly.a.e.c.US_ASCII));
    }

    private void o(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                String substring2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.aQQ.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.aQQ.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.aQQ.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(HanziToPinyin.Token.SEPARATOR);
                dVar.aRa = true;
                dVar.aRb = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.aRb = new c(this, dVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void p(String str) {
        if (!aQG.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.aQN) {
            remove(this.aQQ.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.aQP != null) {
            Iterator it = new ArrayList(this.aQQ.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.aRb != null) {
                    dVar.aRb.abort();
                }
            }
            trimToSize();
            this.aQP.close();
            this.aQP = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.e.c.a(this.aQI);
    }

    public synchronized e eO(String str) {
        e eVar = null;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aQQ.get(str);
            if (dVar != null && dVar.aRa) {
                InputStream[] inputStreamArr = new InputStream[this.aQO];
                for (int i = 0; i < this.aQO; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.dv(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.aQO && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.e.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.aQR++;
                this.aQP.append((CharSequence) ("READ " + str + '\n'));
                if (EE()) {
                    this.aQT.submit(this.aQU);
                }
                eVar = new e(this, str, dVar.aRc, inputStreamArr, dVar.aQZ, null);
            }
        }
        return eVar;
    }

    public c eP(String str) {
        return h(str, -1L);
    }

    public synchronized void flush() {
        U();
        trimToSize();
        this.aQP.flush();
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aQQ.get(str);
            if (dVar == null || dVar.aRb != null) {
                z = false;
            } else {
                for (int i = 0; i < this.aQO; i++) {
                    File dv = dVar.dv(i);
                    if (!dv.exists() || dv.delete()) {
                        this.size -= dVar.aQZ[i];
                        dVar.aQZ[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + dv);
                    }
                }
                this.aQR++;
                this.aQP.append((CharSequence) ("REMOVE " + str + '\n'));
                this.aQQ.remove(str);
                if (EE()) {
                    this.aQT.submit(this.aQU);
                }
                z = true;
            }
        }
        return z;
    }

    private static void b(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
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
                if (aVar.aQJ.exists()) {
                    try {
                        aVar.X();
                        aVar.W();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.c.j("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.Y();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.aQV;
            if (dVar.aRb == cVar) {
                if (z && !dVar.aRa) {
                    for (int i = 0; i < this.aQO; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.dw(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.aQO; i2++) {
                    File dw = dVar.dw(i2);
                    if (!z) {
                        b(dw);
                    } else if (dw.exists()) {
                        File dv = dVar.dv(i2);
                        dw.renameTo(dv);
                        long j = dVar.aQZ[i2];
                        long length = dv.length();
                        dVar.aQZ[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.aQR++;
                dVar.aRb = null;
                if (!(dVar.aRa | z)) {
                    this.aQQ.remove(dVar.key);
                    this.aQP.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.aRa = true;
                    this.aQP.write("CLEAN " + dVar.key + dVar.j() + '\n');
                    if (z) {
                        long j2 = this.aQS;
                        this.aQS = 1 + j2;
                        dVar.aRc = j2;
                    }
                }
                this.aQP.flush();
                if (this.size > this.aQN || EE()) {
                    this.aQT.submit(this.aQU);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            b(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private synchronized c h(String str, long j) {
        d dVar;
        c cVar;
        U();
        p(str);
        d dVar2 = this.aQQ.get(str);
        if (j == -1 || (dVar2 != null && dVar2.aRc == j)) {
            if (dVar2 != null) {
                if (dVar2.aRb != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.aQQ.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.aRb = cVar;
            this.aQP.write("DIRTY " + str + '\n');
            this.aQP.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
