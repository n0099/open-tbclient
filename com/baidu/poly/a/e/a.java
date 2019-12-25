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
/* loaded from: classes9.dex */
public final class a implements Closeable {
    static final Pattern aLn = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream aLo = new b();
    private final File aLp;
    private final File aLq;
    private final File aLr;
    private final File aLs;
    private final int aLt;
    private long aLu;
    private final int aLv;
    private Writer aLw;
    private int aLy;
    private long size = 0;
    private final LinkedHashMap<String, d> aLx = new LinkedHashMap<>(0, 0.75f, true);
    private long aLz = 0;
    final ThreadPoolExecutor aLA = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> aLB = new CallableC0145a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class CallableC0145a implements Callable<Void> {
        CallableC0145a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.aLw != null) {
                    a.this.trimToSize();
                    if (a.this.BK()) {
                        a.this.Y();
                        a.this.aLy = 0;
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
        private final d aLC;
        private boolean aLD;
        private boolean aLE;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        private class C0146a extends FilterOutputStream {
            /* synthetic */ C0146a(c cVar, OutputStream outputStream, CallableC0145a callableC0145a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.aLD = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.aLD = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.aLD = true;
                }
            }

            private C0146a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.aLD = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0145a callableC0145a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.aLD) {
                a.this.a(this, false);
                a.this.remove(this.aLC.key);
            } else {
                a.this.a(this, true);
            }
            this.aLE = true;
        }

        private c(d dVar) {
            this.aLC = dVar;
            this.written = dVar.aLH ? null : new boolean[a.this.aLv];
        }

        public OutputStream dc(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.aLv) {
                synchronized (a.this) {
                    if (this.aLC.aLI == this) {
                        if (!this.aLC.aLH) {
                            this.written[i] = true;
                        }
                        File de = this.aLC.de(i);
                        try {
                            fileOutputStream = new FileOutputStream(de);
                        } catch (FileNotFoundException e) {
                            a.this.aLp.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(de);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.aLo;
                            }
                        }
                        outputStream = new C0146a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.aLv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class d {
        private final long[] aLG;
        private boolean aLH;
        private c aLI;
        private long aLJ;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0145a callableC0145a) {
            this(str);
        }

        public String j() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aLG) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.aLG = new long[a.this.aLv];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.aLv) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.aLG[i] = Long.parseLong(strArr[i]);
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

        public File dd(int i) {
            return new File(a.this.aLp, this.key + "." + i);
        }

        public File de(int i) {
            return new File(a.this.aLp, this.key + "." + i + ".tmp");
        }

        private IOException l(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes9.dex */
    public final class e implements Closeable {
        private final long[] aLG;
        private final long aLJ;
        private final InputStream[] aLK;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0145a callableC0145a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.aLK) {
                com.baidu.poly.a.e.c.a(inputStream);
            }
        }

        public InputStream df(int i) {
            return this.aLK[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aLJ = j;
            this.aLK = inputStreamArr;
            this.aLG = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.aLp = file;
        this.aLt = i;
        this.aLq = new File(file, "journal");
        this.aLr = new File(file, "journal.tmp");
        this.aLs = new File(file, "journal.bkp");
        this.aLv = i2;
        this.aLu = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BK() {
        int i = this.aLy;
        return i >= 2000 && i >= this.aLx.size();
    }

    private void U() {
        if (this.aLw == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void W() {
        b(this.aLr);
        Iterator<d> it = this.aLx.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.aLI != null) {
                next.aLI = null;
                for (int i = 0; i < this.aLv; i++) {
                    b(next.dd(i));
                    b(next.de(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.aLv; i2++) {
                    this.size += next.aLG[i2];
                }
            }
        }
    }

    private void X() {
        com.baidu.poly.a.e.b bVar = new com.baidu.poly.a.e.b(new FileInputStream(this.aLq), com.baidu.poly.a.e.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.aLt).equals(readLine3) || !Integer.toString(this.aLv).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    o(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.aLy = i - this.aLx.size();
                    if (bVar.l()) {
                        Y();
                    } else {
                        this.aLw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aLq, true), com.baidu.poly.a.e.c.US_ASCII));
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
        Writer writer = this.aLw;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aLr), com.baidu.poly.a.e.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aLt));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.aLv));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.aLx.values()) {
            if (dVar.aLI != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.j() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.aLq.exists()) {
            a(this.aLq, this.aLs, true);
        }
        a(this.aLr, this.aLq, false);
        this.aLs.delete();
        this.aLw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aLq, true), com.baidu.poly.a.e.c.US_ASCII));
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
                    this.aLx.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.aLx.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.aLx.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(HanziToPinyin.Token.SEPARATOR);
                dVar.aLH = true;
                dVar.aLI = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.aLI = new c(this, dVar, null);
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
        if (!aLn.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.aLu) {
            remove(this.aLx.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.aLw != null) {
            Iterator it = new ArrayList(this.aLx.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.aLI != null) {
                    dVar.aLI.abort();
                }
            }
            trimToSize();
            this.aLw.close();
            this.aLw = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.e.c.a(this.aLp);
    }

    public synchronized e ev(String str) {
        e eVar = null;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aLx.get(str);
            if (dVar != null && dVar.aLH) {
                InputStream[] inputStreamArr = new InputStream[this.aLv];
                for (int i = 0; i < this.aLv; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.dd(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.aLv && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.e.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.aLy++;
                this.aLw.append((CharSequence) ("READ " + str + '\n'));
                if (BK()) {
                    this.aLA.submit(this.aLB);
                }
                eVar = new e(this, str, dVar.aLJ, inputStreamArr, dVar.aLG, null);
            }
        }
        return eVar;
    }

    public c ew(String str) {
        return h(str, -1L);
    }

    public synchronized void flush() {
        U();
        trimToSize();
        this.aLw.flush();
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.aLx.get(str);
            if (dVar == null || dVar.aLI != null) {
                z = false;
            } else {
                for (int i = 0; i < this.aLv; i++) {
                    File dd = dVar.dd(i);
                    if (!dd.exists() || dd.delete()) {
                        this.size -= dVar.aLG[i];
                        dVar.aLG[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + dd);
                    }
                }
                this.aLy++;
                this.aLw.append((CharSequence) ("REMOVE " + str + '\n'));
                this.aLx.remove(str);
                if (BK()) {
                    this.aLA.submit(this.aLB);
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
                if (aVar.aLq.exists()) {
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
            d dVar = cVar.aLC;
            if (dVar.aLI == cVar) {
                if (z && !dVar.aLH) {
                    for (int i = 0; i < this.aLv; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.de(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.aLv; i2++) {
                    File de = dVar.de(i2);
                    if (!z) {
                        b(de);
                    } else if (de.exists()) {
                        File dd = dVar.dd(i2);
                        de.renameTo(dd);
                        long j = dVar.aLG[i2];
                        long length = dd.length();
                        dVar.aLG[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.aLy++;
                dVar.aLI = null;
                if (!(dVar.aLH | z)) {
                    this.aLx.remove(dVar.key);
                    this.aLw.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.aLH = true;
                    this.aLw.write("CLEAN " + dVar.key + dVar.j() + '\n');
                    if (z) {
                        long j2 = this.aLz;
                        this.aLz = 1 + j2;
                        dVar.aLJ = j2;
                    }
                }
                this.aLw.flush();
                if (this.size > this.aLu || BK()) {
                    this.aLA.submit(this.aLB);
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
        d dVar2 = this.aLx.get(str);
        if (j == -1 || (dVar2 != null && dVar2.aLJ == j)) {
            if (dVar2 != null) {
                if (dVar2.aLI != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.aLx.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.aLI = cVar;
            this.aLw.write("DIRTY " + str + '\n');
            this.aLw.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
