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
    static final Pattern bnb = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream bnc = new b();
    private final File bnd;
    private final File bne;
    private final File bnf;
    private final File bng;
    private final int bnh;
    private long bni;
    private final int bnj;
    private Writer bnk;
    private int bnm;
    private long size = 0;
    private final LinkedHashMap<String, d> bnl = new LinkedHashMap<>(0, 0.75f, true);
    private long bnn = 0;
    final ThreadPoolExecutor bno = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> bnp = new CallableC0202a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class CallableC0202a implements Callable<Void> {
        CallableC0202a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.bnk != null) {
                    a.this.trimToSize();
                    if (a.this.sK()) {
                        a.this.Y();
                        a.this.bnm = 0;
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
        private final d bnq;
        private boolean bnr;
        private boolean bns;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        private class C0203a extends FilterOutputStream {
            /* synthetic */ C0203a(c cVar, OutputStream outputStream, CallableC0202a callableC0202a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.bnr = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.bnr = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.bnr = true;
                }
            }

            private C0203a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.bnr = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0202a callableC0202a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.bnr) {
                a.this.a(this, false);
                a.this.remove(this.bnq.key);
            } else {
                a.this.a(this, true);
            }
            this.bns = true;
        }

        private c(d dVar) {
            this.bnq = dVar;
            this.written = dVar.bnv ? null : new boolean[a.this.bnj];
        }

        public OutputStream dA(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.bnj) {
                synchronized (a.this) {
                    if (this.bnq.bnw == this) {
                        if (!this.bnq.bnv) {
                            this.written[i] = true;
                        }
                        File dC = this.bnq.dC(i);
                        try {
                            fileOutputStream = new FileOutputStream(dC);
                        } catch (FileNotFoundException e) {
                            a.this.bnd.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(dC);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.bnc;
                            }
                        }
                        outputStream = new C0203a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.bnj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class d {
        private final long[] bnu;
        private boolean bnv;
        private c bnw;
        private long bnx;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0202a callableC0202a) {
            this(str);
        }

        public String j() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bnu) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.bnu = new long[a.this.bnj];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.bnj) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.bnu[i] = Long.parseLong(strArr[i]);
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

        public File dB(int i) {
            return new File(a.this.bnd, this.key + "." + i);
        }

        public File dC(int i) {
            return new File(a.this.bnd, this.key + "." + i + ".tmp");
        }

        private IOException p(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes11.dex */
    public final class e implements Closeable {
        private final long[] bnu;
        private final long bnx;
        private final InputStream[] bny;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0202a callableC0202a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.bny) {
                com.baidu.poly.a.e.c.a(inputStream);
            }
        }

        public InputStream dD(int i) {
            return this.bny[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bnx = j;
            this.bny = inputStreamArr;
            this.bnu = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.bnd = file;
        this.bnh = i;
        this.bne = new File(file, "journal");
        this.bnf = new File(file, "journal.tmp");
        this.bng = new File(file, "journal.bkp");
        this.bnj = i2;
        this.bni = j;
    }

    private void U() {
        if (this.bnk == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void W() {
        b(this.bnf);
        Iterator<d> it = this.bnl.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.bnw != null) {
                next.bnw = null;
                for (int i = 0; i < this.bnj; i++) {
                    b(next.dB(i));
                    b(next.dC(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.bnj; i2++) {
                    this.size += next.bnu[i2];
                }
            }
        }
    }

    private void X() {
        com.baidu.poly.a.e.b bVar = new com.baidu.poly.a.e.b(new FileInputStream(this.bne), com.baidu.poly.a.e.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.bnh).equals(readLine3) || !Integer.toString(this.bnj).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    o(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.bnm = i - this.bnl.size();
                    if (bVar.l()) {
                        Y();
                    } else {
                        this.bnk = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bne, true), com.baidu.poly.a.e.c.US_ASCII));
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
        Writer writer = this.bnk;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bnf), com.baidu.poly.a.e.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bnh));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bnj));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.bnl.values()) {
            if (dVar.bnw != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.j() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.bne.exists()) {
            a(this.bne, this.bng, true);
        }
        a(this.bnf, this.bne, false);
        this.bng.delete();
        this.bnk = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bne, true), com.baidu.poly.a.e.c.US_ASCII));
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
                    this.bnl.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.bnl.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.bnl.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.bnv = true;
                dVar.bnw = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.bnw = new c(this, dVar, null);
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
        if (!bnb.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sK() {
        int i = this.bnm;
        return i >= 2000 && i >= this.bnl.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.bni) {
            remove(this.bnl.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.bnk != null) {
            Iterator it = new ArrayList(this.bnl.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bnw != null) {
                    dVar.bnw.abort();
                }
            }
            trimToSize();
            this.bnk.close();
            this.bnk = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.e.c.a(this.bnd);
    }

    public synchronized e fI(String str) {
        e eVar = null;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.bnl.get(str);
            if (dVar != null && dVar.bnv) {
                InputStream[] inputStreamArr = new InputStream[this.bnj];
                for (int i = 0; i < this.bnj; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.dB(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.bnj && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.e.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.bnm++;
                this.bnk.append((CharSequence) ("READ " + str + '\n'));
                if (sK()) {
                    this.bno.submit(this.bnp);
                }
                eVar = new e(this, str, dVar.bnx, inputStreamArr, dVar.bnu, null);
            }
        }
        return eVar;
    }

    public c fJ(String str) {
        return h(str, -1L);
    }

    public synchronized void flush() {
        U();
        trimToSize();
        this.bnk.flush();
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.bnl.get(str);
            if (dVar == null || dVar.bnw != null) {
                z = false;
            } else {
                for (int i = 0; i < this.bnj; i++) {
                    File dB = dVar.dB(i);
                    if (!dB.exists() || dB.delete()) {
                        this.size -= dVar.bnu[i];
                        dVar.bnu[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + dB);
                    }
                }
                this.bnm++;
                this.bnk.append((CharSequence) ("REMOVE " + str + '\n'));
                this.bnl.remove(str);
                if (sK()) {
                    this.bno.submit(this.bnp);
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
                if (aVar.bne.exists()) {
                    try {
                        aVar.X();
                        aVar.W();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.c.l("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
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
            d dVar = cVar.bnq;
            if (dVar.bnw == cVar) {
                if (z && !dVar.bnv) {
                    for (int i = 0; i < this.bnj; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.dC(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.bnj; i2++) {
                    File dC = dVar.dC(i2);
                    if (!z) {
                        b(dC);
                    } else if (dC.exists()) {
                        File dB = dVar.dB(i2);
                        dC.renameTo(dB);
                        long j = dVar.bnu[i2];
                        long length = dB.length();
                        dVar.bnu[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.bnm++;
                dVar.bnw = null;
                if (!(dVar.bnv | z)) {
                    this.bnl.remove(dVar.key);
                    this.bnk.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.bnv = true;
                    this.bnk.write("CLEAN " + dVar.key + dVar.j() + '\n');
                    if (z) {
                        long j2 = this.bnn;
                        this.bnn = 1 + j2;
                        dVar.bnx = j2;
                    }
                }
                this.bnk.flush();
                if (this.size > this.bni || sK()) {
                    this.bno.submit(this.bnp);
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
        d dVar2 = this.bnl.get(str);
        if (j == -1 || (dVar2 != null && dVar2.bnx == j)) {
            if (dVar2 != null) {
                if (dVar2.bnw != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.bnl.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.bnw = cVar;
            this.bnk.write("DIRTY " + str + '\n');
            this.bnk.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
