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
    static final Pattern aQF = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream aQG = new b();
    private final File aQH;
    private final File aQI;
    private final File aQJ;
    private final File aQK;
    private final int aQL;
    private long aQM;
    private final int aQN;
    private Writer aQO;
    private int aQQ;
    private long size = 0;
    private final LinkedHashMap<String, d> aQP = new LinkedHashMap<>(0, 0.75f, true);
    private long aQR = 0;
    final ThreadPoolExecutor aQS = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> aQT = new CallableC0156a();

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
                if (a.this.aQO != null) {
                    a.this.trimToSize();
                    if (a.this.EE()) {
                        a.this.Y();
                        a.this.aQQ = 0;
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
        private final d aQU;
        private boolean aQV;
        private boolean aQW;
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
                    c.this.aQV = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.aQV = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.aQV = true;
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
                    c.this.aQV = true;
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
            if (this.aQV) {
                a.this.a(this, false);
                a.this.remove(this.aQU.key);
            } else {
                a.this.a(this, true);
            }
            this.aQW = true;
        }

        private c(d dVar) {
            this.aQU = dVar;
            this.written = dVar.aQZ ? null : new boolean[a.this.aQN];
        }

        public OutputStream du(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.aQN) {
                synchronized (a.this) {
                    if (this.aQU.aRa == this) {
                        if (!this.aQU.aQZ) {
                            this.written[i] = true;
                        }
                        File dw = this.aQU.dw(i);
                        try {
                            fileOutputStream = new FileOutputStream(dw);
                        } catch (FileNotFoundException e) {
                            a.this.aQH.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(dw);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.aQG;
                            }
                        }
                        outputStream = new C0157a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.aQN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class d {
        private final long[] aQY;
        private boolean aQZ;
        private c aRa;
        private long aRb;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0156a callableC0156a) {
            this(str);
        }

        public String j() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aQY) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.aQY = new long[a.this.aQN];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.aQN) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.aQY[i] = Long.parseLong(strArr[i]);
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
            return new File(a.this.aQH, this.key + "." + i);
        }

        public File dw(int i) {
            return new File(a.this.aQH, this.key + "." + i + ".tmp");
        }

        private IOException p(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes11.dex */
    public final class e implements Closeable {
        private final long[] aQY;
        private final long aRb;
        private final InputStream[] aRc;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0156a callableC0156a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.aRc) {
                com.baidu.poly.a.e.c.a(inputStream);
            }
        }

        public InputStream dx(int i) {
            return this.aRc[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aRb = j;
            this.aRc = inputStreamArr;
            this.aQY = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.aQH = file;
        this.aQL = i;
        this.aQI = new File(file, "journal");
        this.aQJ = new File(file, "journal.tmp");
        this.aQK = new File(file, "journal.bkp");
        this.aQN = i2;
        this.aQM = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean EE() {
        int i = this.aQQ;
        return i >= 2000 && i >= this.aQP.size();
    }

    private void U() {
        if (this.aQO == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void W() {
        b(this.aQJ);
        Iterator<d> it = this.aQP.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.aRa != null) {
                next.aRa = null;
                for (int i = 0; i < this.aQN; i++) {
                    b(next.dv(i));
                    b(next.dw(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.aQN; i2++) {
                    this.size += next.aQY[i2];
                }
            }
        }
    }

    private void X() {
        com.baidu.poly.a.e.b bVar = new com.baidu.poly.a.e.b(new FileInputStream(this.aQI), com.baidu.poly.a.e.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.aQL).equals(readLine3) || !Integer.toString(this.aQN).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    o(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.aQQ = i - this.aQP.size();
                    if (bVar.l()) {
                        Y();
                    } else {
                        this.aQO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aQI, true), com.baidu.poly.a.e.c.US_ASCII));
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
        Writer writer = this.aQO;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aQJ), com.baidu.poly.a.e.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aQL));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aQN));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.aQP.values()) {
            if (dVar.aRa != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.j() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.aQI.exists()) {
            a(this.aQI, this.aQK, true);
        }
        a(this.aQJ, this.aQI, false);
        this.aQK.delete();
        this.aQO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aQI, true), com.baidu.poly.a.e.c.US_ASCII));
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
                    this.aQP.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.aQP.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.aQP.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(HanziToPinyin.Token.SEPARATOR);
                dVar.aQZ = true;
                dVar.aRa = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.aRa = new c(this, dVar, null);
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
        if (!aQF.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.aQM) {
            remove(this.aQP.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.aQO != null) {
            Iterator it = new ArrayList(this.aQP.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.aRa != null) {
                    dVar.aRa.abort();
                }
            }
            trimToSize();
            this.aQO.close();
            this.aQO = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.e.c.a(this.aQH);
    }

    public synchronized e eO(String str) {
        e eVar = null;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aQP.get(str);
            if (dVar != null && dVar.aQZ) {
                InputStream[] inputStreamArr = new InputStream[this.aQN];
                for (int i = 0; i < this.aQN; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.dv(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.aQN && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.e.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.aQQ++;
                this.aQO.append((CharSequence) ("READ " + str + '\n'));
                if (EE()) {
                    this.aQS.submit(this.aQT);
                }
                eVar = new e(this, str, dVar.aRb, inputStreamArr, dVar.aQY, null);
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
        this.aQO.flush();
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aQP.get(str);
            if (dVar == null || dVar.aRa != null) {
                z = false;
            } else {
                for (int i = 0; i < this.aQN; i++) {
                    File dv = dVar.dv(i);
                    if (!dv.exists() || dv.delete()) {
                        this.size -= dVar.aQY[i];
                        dVar.aQY[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + dv);
                    }
                }
                this.aQQ++;
                this.aQO.append((CharSequence) ("REMOVE " + str + '\n'));
                this.aQP.remove(str);
                if (EE()) {
                    this.aQS.submit(this.aQT);
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
                if (aVar.aQI.exists()) {
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
            d dVar = cVar.aQU;
            if (dVar.aRa == cVar) {
                if (z && !dVar.aQZ) {
                    for (int i = 0; i < this.aQN; i++) {
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
                for (int i2 = 0; i2 < this.aQN; i2++) {
                    File dw = dVar.dw(i2);
                    if (!z) {
                        b(dw);
                    } else if (dw.exists()) {
                        File dv = dVar.dv(i2);
                        dw.renameTo(dv);
                        long j = dVar.aQY[i2];
                        long length = dv.length();
                        dVar.aQY[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.aQQ++;
                dVar.aRa = null;
                if (!(dVar.aQZ | z)) {
                    this.aQP.remove(dVar.key);
                    this.aQO.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.aQZ = true;
                    this.aQO.write("CLEAN " + dVar.key + dVar.j() + '\n');
                    if (z) {
                        long j2 = this.aQR;
                        this.aQR = 1 + j2;
                        dVar.aRb = j2;
                    }
                }
                this.aQO.flush();
                if (this.size > this.aQM || EE()) {
                    this.aQS.submit(this.aQT);
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
        d dVar2 = this.aQP.get(str);
        if (j == -1 || (dVar2 != null && dVar2.aRb == j)) {
            if (dVar2 != null) {
                if (dVar2.aRa != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.aQP.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.aRa = cVar;
            this.aQO.write("DIRTY " + str + '\n');
            this.aQO.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
