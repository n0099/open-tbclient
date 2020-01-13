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
/* loaded from: classes10.dex */
public final class a implements Closeable {
    static final Pattern aMf = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream aMg = new b();
    private final File aMh;
    private final File aMi;
    private final File aMj;
    private final File aMk;
    private final int aMl;
    private long aMm;
    private final int aMn;
    private Writer aMo;
    private int aMq;
    private long size = 0;
    private final LinkedHashMap<String, d> aMp = new LinkedHashMap<>(0, 0.75f, true);
    private long aMr = 0;
    final ThreadPoolExecutor aMs = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> aMt = new CallableC0147a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class CallableC0147a implements Callable<Void> {
        CallableC0147a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.aMo != null) {
                    a.this.trimToSize();
                    if (a.this.Cg()) {
                        a.this.Y();
                        a.this.aMq = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes10.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes10.dex */
    public final class c {
        private final d aMu;
        private boolean aMv;
        private boolean aMw;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        private class C0148a extends FilterOutputStream {
            /* synthetic */ C0148a(c cVar, OutputStream outputStream, CallableC0147a callableC0147a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.aMv = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.aMv = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.aMv = true;
                }
            }

            private C0148a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.aMv = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0147a callableC0147a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.aMv) {
                a.this.a(this, false);
                a.this.remove(this.aMu.key);
            } else {
                a.this.a(this, true);
            }
            this.aMw = true;
        }

        private c(d dVar) {
            this.aMu = dVar;
            this.written = dVar.aMz ? null : new boolean[a.this.aMn];
        }

        public OutputStream dd(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.aMn) {
                synchronized (a.this) {
                    if (this.aMu.aMA == this) {
                        if (!this.aMu.aMz) {
                            this.written[i] = true;
                        }
                        File df = this.aMu.df(i);
                        try {
                            fileOutputStream = new FileOutputStream(df);
                        } catch (FileNotFoundException e) {
                            a.this.aMh.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(df);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.aMg;
                            }
                        }
                        outputStream = new C0148a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.aMn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public final class d {
        private c aMA;
        private long aMB;
        private final long[] aMy;
        private boolean aMz;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0147a callableC0147a) {
            this(str);
        }

        public String j() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aMy) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.aMy = new long[a.this.aMn];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.aMn) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.aMy[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException e) {
                        l(strArr);
                        throw null;
                    }
                }
                return;
            }
            l(strArr);
            throw null;
        }

        public File de(int i) {
            return new File(a.this.aMh, this.key + "." + i);
        }

        public File df(int i) {
            return new File(a.this.aMh, this.key + "." + i + ".tmp");
        }

        private IOException l(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes10.dex */
    public final class e implements Closeable {
        private final long aMB;
        private final InputStream[] aMC;
        private final long[] aMy;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0147a callableC0147a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.aMC) {
                com.baidu.poly.a.e.c.a(inputStream);
            }
        }

        public InputStream dg(int i) {
            return this.aMC[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aMB = j;
            this.aMC = inputStreamArr;
            this.aMy = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.aMh = file;
        this.aMl = i;
        this.aMi = new File(file, "journal");
        this.aMj = new File(file, "journal.tmp");
        this.aMk = new File(file, "journal.bkp");
        this.aMn = i2;
        this.aMm = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Cg() {
        int i = this.aMq;
        return i >= 2000 && i >= this.aMp.size();
    }

    private void U() {
        if (this.aMo == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void W() {
        b(this.aMj);
        Iterator<d> it = this.aMp.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.aMA != null) {
                next.aMA = null;
                for (int i = 0; i < this.aMn; i++) {
                    b(next.de(i));
                    b(next.df(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.aMn; i2++) {
                    this.size += next.aMy[i2];
                }
            }
        }
    }

    private void X() {
        com.baidu.poly.a.e.b bVar = new com.baidu.poly.a.e.b(new FileInputStream(this.aMi), com.baidu.poly.a.e.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.aMl).equals(readLine3) || !Integer.toString(this.aMn).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    o(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.aMq = i - this.aMp.size();
                    if (bVar.l()) {
                        Y();
                    } else {
                        this.aMo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aMi, true), com.baidu.poly.a.e.c.US_ASCII));
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
        Writer writer = this.aMo;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aMj), com.baidu.poly.a.e.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aMl));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aMn));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.aMp.values()) {
            if (dVar.aMA != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.j() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.aMi.exists()) {
            a(this.aMi, this.aMk, true);
        }
        a(this.aMj, this.aMi, false);
        this.aMk.delete();
        this.aMo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aMi, true), com.baidu.poly.a.e.c.US_ASCII));
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
                    this.aMp.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.aMp.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.aMp.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(HanziToPinyin.Token.SEPARATOR);
                dVar.aMz = true;
                dVar.aMA = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.aMA = new c(this, dVar, null);
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
        if (!aMf.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.aMm) {
            remove(this.aMp.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.aMo != null) {
            Iterator it = new ArrayList(this.aMp.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.aMA != null) {
                    dVar.aMA.abort();
                }
            }
            trimToSize();
            this.aMo.close();
            this.aMo = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.e.c.a(this.aMh);
    }

    public synchronized e ey(String str) {
        e eVar = null;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aMp.get(str);
            if (dVar != null && dVar.aMz) {
                InputStream[] inputStreamArr = new InputStream[this.aMn];
                for (int i = 0; i < this.aMn; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.de(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.aMn && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.e.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.aMq++;
                this.aMo.append((CharSequence) ("READ " + str + '\n'));
                if (Cg()) {
                    this.aMs.submit(this.aMt);
                }
                eVar = new e(this, str, dVar.aMB, inputStreamArr, dVar.aMy, null);
            }
        }
        return eVar;
    }

    public c ez(String str) {
        return h(str, -1L);
    }

    public synchronized void flush() {
        U();
        trimToSize();
        this.aMo.flush();
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aMp.get(str);
            if (dVar == null || dVar.aMA != null) {
                z = false;
            } else {
                for (int i = 0; i < this.aMn; i++) {
                    File de = dVar.de(i);
                    if (!de.exists() || de.delete()) {
                        this.size -= dVar.aMy[i];
                        dVar.aMy[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + de);
                    }
                }
                this.aMq++;
                this.aMo.append((CharSequence) ("REMOVE " + str + '\n'));
                this.aMp.remove(str);
                if (Cg()) {
                    this.aMs.submit(this.aMt);
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
                if (aVar.aMi.exists()) {
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
            d dVar = cVar.aMu;
            if (dVar.aMA == cVar) {
                if (z && !dVar.aMz) {
                    for (int i = 0; i < this.aMn; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.df(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.aMn; i2++) {
                    File df = dVar.df(i2);
                    if (!z) {
                        b(df);
                    } else if (df.exists()) {
                        File de = dVar.de(i2);
                        df.renameTo(de);
                        long j = dVar.aMy[i2];
                        long length = de.length();
                        dVar.aMy[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.aMq++;
                dVar.aMA = null;
                if (!(dVar.aMz | z)) {
                    this.aMp.remove(dVar.key);
                    this.aMo.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.aMz = true;
                    this.aMo.write("CLEAN " + dVar.key + dVar.j() + '\n');
                    if (z) {
                        long j2 = this.aMr;
                        this.aMr = 1 + j2;
                        dVar.aMB = j2;
                    }
                }
                this.aMo.flush();
                if (this.size > this.aMm || Cg()) {
                    this.aMs.submit(this.aMt);
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
        d dVar2 = this.aMp.get(str);
        if (j == -1 || (dVar2 != null && dVar2.aMB == j)) {
            if (dVar2 != null) {
                if (dVar2.aMA != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.aMp.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.aMA = cVar;
            this.aMo.write("DIRTY " + str + '\n');
            this.aMo.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
