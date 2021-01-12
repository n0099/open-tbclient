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
/* loaded from: classes3.dex */
public final class a implements Closeable {
    static final Pattern cjk = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream cjl = new b();
    private int ad;
    private final File cjm;
    private final File cjn;
    private final File cjo;
    private final File cjp;
    private final int cjq;
    private long cjr;
    private final int cjs;
    private Writer cjt;
    private long size = 0;
    private final LinkedHashMap<String, d> cju = new LinkedHashMap<>(0, 0.75f, true);
    private long apd = 0;
    final ThreadPoolExecutor cjv = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> cjw = new CallableC0296a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class CallableC0296a implements Callable<Void> {
        CallableC0296a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.cjt != null) {
                    a.this.trimToSize();
                    if (a.this.abF()) {
                        a.this.abE();
                        a.this.ad = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes3.dex */
    public final class c {
        private final d cjx;
        private boolean cjy;
        private boolean cjz;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private class C0297a extends FilterOutputStream {
            /* synthetic */ C0297a(c cVar, OutputStream outputStream, CallableC0296a callableC0296a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.cjy = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.cjy = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.cjy = true;
                }
            }

            private C0297a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.cjy = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0296a callableC0296a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.cjy) {
                a.this.a(this, false);
                a.this.remove(this.cjx.key);
            } else {
                a.this.a(this, true);
            }
            this.cjz = true;
        }

        public OutputStream fy(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.cjs) {
                synchronized (a.this) {
                    if (this.cjx.cjD == this) {
                        if (!this.cjx.cjC) {
                            this.written[i] = true;
                        }
                        File fA = this.cjx.fA(i);
                        try {
                            fileOutputStream = new FileOutputStream(fA);
                        } catch (FileNotFoundException e) {
                            a.this.cjm.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(fA);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.cjl;
                            }
                        }
                        outputStream = new C0297a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.cjs);
        }

        private c(d dVar) {
            this.cjx = dVar;
            this.written = dVar.cjC ? null : new boolean[a.this.cjs];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class d {
        private final long[] cjB;
        private boolean cjC;
        private c cjD;
        private long cjE;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0296a callableC0296a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.cjB) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.cjB = new long[a.this.cjs];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.cjs) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.cjB[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException e) {
                        w(strArr);
                        throw null;
                    }
                }
                return;
            }
            w(strArr);
            throw null;
        }

        public File fA(int i) {
            return new File(a.this.cjm, this.key + "." + i + ".tmp");
        }

        public File fz(int i) {
            return new File(a.this.cjm, this.key + "." + i);
        }

        private IOException w(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes3.dex */
    public final class e implements Closeable {
        private final long[] cjB;
        private final long cjE;
        private final InputStream[] cjF;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0296a callableC0296a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.cjF) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream fB(int i) {
            return this.cjF[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.cjE = j;
            this.cjF = inputStreamArr;
            this.cjB = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.cjm = file;
        this.cjq = i;
        this.cjn = new File(file, "journal");
        this.cjo = new File(file, "journal.tmp");
        this.cjp = new File(file, "journal.bkp");
        this.cjs = i2;
        this.cjr = j;
    }

    private void abC() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.cjn), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.cjq).equals(readLine3) || !Integer.toString(this.cjs).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.cju.size();
                    if (bVar.D()) {
                        abE();
                    } else {
                        this.cjt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cjn, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void abD() {
        c(this.cjo);
        Iterator<d> it = this.cju.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.cjD != null) {
                next.cjD = null;
                for (int i = 0; i < this.cjs; i++) {
                    c(next.fz(i));
                    c(next.fA(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.cjs; i2++) {
                    this.size += next.cjB[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void abE() {
        Writer writer = this.cjt;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cjo), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.cjq));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.cjs));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.cju.values()) {
            if (dVar.cjD != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.cjn.exists()) {
            a(this.cjn, this.cjp, true);
        }
        a(this.cjo, this.cjn, false);
        this.cjp.delete();
        this.cjt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cjn, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abF() {
        int i = this.ad;
        return i >= 2000 && i >= this.cju.size();
    }

    private void abG() {
        if (this.cjt == null) {
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
                    this.cju.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.cju.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.cju.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.cjC = true;
                dVar.cjD = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.cjD = new c(this, dVar, null);
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
        if (!cjk.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.cjr) {
            remove(this.cju.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.cjt != null) {
            Iterator it = new ArrayList(this.cju.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.cjD != null) {
                    dVar.cjD.abort();
                }
            }
            trimToSize();
            this.cjt.close();
            this.cjt = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.cjm);
    }

    public synchronized void flush() {
        abG();
        trimToSize();
        this.cjt.flush();
    }

    public synchronized e iK(String str) {
        e eVar = null;
        synchronized (this) {
            abG();
            r(str);
            d dVar = this.cju.get(str);
            if (dVar != null && dVar.cjC) {
                InputStream[] inputStreamArr = new InputStream[this.cjs];
                for (int i = 0; i < this.cjs; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.fz(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.cjs && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.cjt.append((CharSequence) ("READ " + str + '\n'));
                if (abF()) {
                    this.cjv.submit(this.cjw);
                }
                eVar = new e(this, str, dVar.cjE, inputStreamArr, dVar.cjB, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            abG();
            r(str);
            d dVar = this.cju.get(str);
            if (dVar == null || dVar.cjD != null) {
                z = false;
            } else {
                for (int i = 0; i < this.cjs; i++) {
                    File fz = dVar.fz(i);
                    if (!fz.exists() || fz.delete()) {
                        this.size -= dVar.cjB[i];
                        dVar.cjB[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + fz);
                    }
                }
                this.ad++;
                this.cjt.append((CharSequence) ("REMOVE " + str + '\n'));
                this.cju.remove(str);
                if (abF()) {
                    this.cjv.submit(this.cjw);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.cjx;
            if (dVar.cjD == cVar) {
                if (z && !dVar.cjC) {
                    for (int i = 0; i < this.cjs; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.fA(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.cjs; i2++) {
                    File fA = dVar.fA(i2);
                    if (!z) {
                        c(fA);
                    } else if (fA.exists()) {
                        File fz = dVar.fz(i2);
                        fA.renameTo(fz);
                        long j = dVar.cjB[i2];
                        long length = fz.length();
                        dVar.cjB[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.cjD = null;
                if (!dVar.cjC && !z) {
                    this.cju.remove(dVar.key);
                    this.cjt.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.cjC = true;
                    this.cjt.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.apd;
                        this.apd = 1 + j2;
                        dVar.cjE = j2;
                    }
                }
                this.cjt.flush();
                if (this.size > this.cjr || abF()) {
                    this.cjv.submit(this.cjw);
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

    public c iL(String str) {
        return h(str, -1L);
    }

    public static a b(File file, int i, int i2, long j) {
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
                if (aVar.cjn.exists()) {
                    try {
                        aVar.abC();
                        aVar.abD();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.abE();
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
        abG();
        r(str);
        d dVar2 = this.cju.get(str);
        if (j == -1 || (dVar2 != null && dVar2.cjE == j)) {
            if (dVar2 != null) {
                if (dVar2.cjD != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.cju.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.cjD = cVar;
            this.cjt.write("DIRTY " + str + '\n');
            this.cjt.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
