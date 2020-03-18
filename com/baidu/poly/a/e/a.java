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
    static final Pattern aQT = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream aQU = new b();
    private final File aQV;
    private final File aQW;
    private final File aQX;
    private final File aQY;
    private final int aQZ;
    private long aRa;
    private final int aRb;
    private Writer aRc;
    private int aRe;
    private long size = 0;
    private final LinkedHashMap<String, d> aRd = new LinkedHashMap<>(0, 0.75f, true);
    private long aRf = 0;
    final ThreadPoolExecutor aRg = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> aRh = new CallableC0156a();

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
                if (a.this.aRc != null) {
                    a.this.trimToSize();
                    if (a.this.or()) {
                        a.this.Y();
                        a.this.aRe = 0;
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
        private final d aRi;
        private boolean aRj;
        private boolean aRk;
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
                    c.this.aRj = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.aRj = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.aRj = true;
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
                    c.this.aRj = true;
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
            if (this.aRj) {
                a.this.a(this, false);
                a.this.remove(this.aRi.key);
            } else {
                a.this.a(this, true);
            }
            this.aRk = true;
        }

        private c(d dVar) {
            this.aRi = dVar;
            this.written = dVar.aRn ? null : new boolean[a.this.aRb];
        }

        public OutputStream du(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.aRb) {
                synchronized (a.this) {
                    if (this.aRi.aRo == this) {
                        if (!this.aRi.aRn) {
                            this.written[i] = true;
                        }
                        File dw = this.aRi.dw(i);
                        try {
                            fileOutputStream = new FileOutputStream(dw);
                        } catch (FileNotFoundException e) {
                            a.this.aQV.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(dw);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.aQU;
                            }
                        }
                        outputStream = new C0157a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.aRb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class d {
        private final long[] aRm;
        private boolean aRn;
        private c aRo;
        private long aRp;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0156a callableC0156a) {
            this(str);
        }

        public String j() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aRm) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.aRm = new long[a.this.aRb];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.aRb) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.aRm[i] = Long.parseLong(strArr[i]);
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
            return new File(a.this.aQV, this.key + "." + i);
        }

        public File dw(int i) {
            return new File(a.this.aQV, this.key + "." + i + ".tmp");
        }

        private IOException p(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes11.dex */
    public final class e implements Closeable {
        private final long[] aRm;
        private final long aRp;
        private final InputStream[] aRq;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0156a callableC0156a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.aRq) {
                com.baidu.poly.a.e.c.a(inputStream);
            }
        }

        public InputStream dx(int i) {
            return this.aRq[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aRp = j;
            this.aRq = inputStreamArr;
            this.aRm = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.aQV = file;
        this.aQZ = i;
        this.aQW = new File(file, "journal");
        this.aQX = new File(file, "journal.tmp");
        this.aQY = new File(file, "journal.bkp");
        this.aRb = i2;
        this.aRa = j;
    }

    private void U() {
        if (this.aRc == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void W() {
        b(this.aQX);
        Iterator<d> it = this.aRd.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.aRo != null) {
                next.aRo = null;
                for (int i = 0; i < this.aRb; i++) {
                    b(next.dv(i));
                    b(next.dw(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.aRb; i2++) {
                    this.size += next.aRm[i2];
                }
            }
        }
    }

    private void X() {
        com.baidu.poly.a.e.b bVar = new com.baidu.poly.a.e.b(new FileInputStream(this.aQW), com.baidu.poly.a.e.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.aQZ).equals(readLine3) || !Integer.toString(this.aRb).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    o(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.aRe = i - this.aRd.size();
                    if (bVar.l()) {
                        Y();
                    } else {
                        this.aRc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aQW, true), com.baidu.poly.a.e.c.US_ASCII));
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
        Writer writer = this.aRc;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aQX), com.baidu.poly.a.e.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aQZ));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aRb));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.aRd.values()) {
            if (dVar.aRo != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.j() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.aQW.exists()) {
            a(this.aQW, this.aQY, true);
        }
        a(this.aQX, this.aQW, false);
        this.aQY.delete();
        this.aRc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aQW, true), com.baidu.poly.a.e.c.US_ASCII));
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
                    this.aRd.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.aRd.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.aRd.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(HanziToPinyin.Token.SEPARATOR);
                dVar.aRn = true;
                dVar.aRo = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.aRo = new c(this, dVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean or() {
        int i = this.aRe;
        return i >= 2000 && i >= this.aRd.size();
    }

    private void p(String str) {
        if (!aQT.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.aRa) {
            remove(this.aRd.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.aRc != null) {
            Iterator it = new ArrayList(this.aRd.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.aRo != null) {
                    dVar.aRo.abort();
                }
            }
            trimToSize();
            this.aRc.close();
            this.aRc = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.e.c.a(this.aQV);
    }

    public synchronized e eN(String str) {
        e eVar = null;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aRd.get(str);
            if (dVar != null && dVar.aRn) {
                InputStream[] inputStreamArr = new InputStream[this.aRb];
                for (int i = 0; i < this.aRb; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.dv(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.aRb && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.e.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.aRe++;
                this.aRc.append((CharSequence) ("READ " + str + '\n'));
                if (or()) {
                    this.aRg.submit(this.aRh);
                }
                eVar = new e(this, str, dVar.aRp, inputStreamArr, dVar.aRm, null);
            }
        }
        return eVar;
    }

    public c eO(String str) {
        return h(str, -1L);
    }

    public synchronized void flush() {
        U();
        trimToSize();
        this.aRc.flush();
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aRd.get(str);
            if (dVar == null || dVar.aRo != null) {
                z = false;
            } else {
                for (int i = 0; i < this.aRb; i++) {
                    File dv = dVar.dv(i);
                    if (!dv.exists() || dv.delete()) {
                        this.size -= dVar.aRm[i];
                        dVar.aRm[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + dv);
                    }
                }
                this.aRe++;
                this.aRc.append((CharSequence) ("REMOVE " + str + '\n'));
                this.aRd.remove(str);
                if (or()) {
                    this.aRg.submit(this.aRh);
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
                if (aVar.aQW.exists()) {
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
            d dVar = cVar.aRi;
            if (dVar.aRo == cVar) {
                if (z && !dVar.aRn) {
                    for (int i = 0; i < this.aRb; i++) {
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
                for (int i2 = 0; i2 < this.aRb; i2++) {
                    File dw = dVar.dw(i2);
                    if (!z) {
                        b(dw);
                    } else if (dw.exists()) {
                        File dv = dVar.dv(i2);
                        dw.renameTo(dv);
                        long j = dVar.aRm[i2];
                        long length = dv.length();
                        dVar.aRm[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.aRe++;
                dVar.aRo = null;
                if (!(dVar.aRn | z)) {
                    this.aRd.remove(dVar.key);
                    this.aRc.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.aRn = true;
                    this.aRc.write("CLEAN " + dVar.key + dVar.j() + '\n');
                    if (z) {
                        long j2 = this.aRf;
                        this.aRf = 1 + j2;
                        dVar.aRp = j2;
                    }
                }
                this.aRc.flush();
                if (this.size > this.aRa || or()) {
                    this.aRg.submit(this.aRh);
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
        d dVar2 = this.aRd.get(str);
        if (j == -1 || (dVar2 != null && dVar2.aRp == j)) {
            if (dVar2 != null) {
                if (dVar2.aRo != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.aRd.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.aRo = cVar;
            this.aRc.write("DIRTY " + str + '\n');
            this.aRc.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
