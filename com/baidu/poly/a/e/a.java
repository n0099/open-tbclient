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
    static final Pattern bmW = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream bmX = new b();
    private final File bmY;
    private final File bmZ;
    private final File bna;
    private final File bnb;
    private final int bnc;
    private long bnd;
    private final int bne;
    private Writer bnf;
    private int bnh;
    private long size = 0;
    private final LinkedHashMap<String, d> bng = new LinkedHashMap<>(0, 0.75f, true);
    private long bni = 0;
    final ThreadPoolExecutor bnj = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> bnk = new CallableC0180a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class CallableC0180a implements Callable<Void> {
        CallableC0180a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.bnf != null) {
                    a.this.trimToSize();
                    if (a.this.sL()) {
                        a.this.Y();
                        a.this.bnh = 0;
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
        private final d bnl;
        private boolean bnm;
        private boolean bnn;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        private class C0181a extends FilterOutputStream {
            /* synthetic */ C0181a(c cVar, OutputStream outputStream, CallableC0180a callableC0180a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.bnm = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.bnm = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.bnm = true;
                }
            }

            private C0181a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.bnm = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0180a callableC0180a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.bnm) {
                a.this.a(this, false);
                a.this.remove(this.bnl.key);
            } else {
                a.this.a(this, true);
            }
            this.bnn = true;
        }

        private c(d dVar) {
            this.bnl = dVar;
            this.written = dVar.bnq ? null : new boolean[a.this.bne];
        }

        public OutputStream dA(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.bne) {
                synchronized (a.this) {
                    if (this.bnl.bnr == this) {
                        if (!this.bnl.bnq) {
                            this.written[i] = true;
                        }
                        File dC = this.bnl.dC(i);
                        try {
                            fileOutputStream = new FileOutputStream(dC);
                        } catch (FileNotFoundException e) {
                            a.this.bmY.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(dC);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.bmX;
                            }
                        }
                        outputStream = new C0181a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.bne);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class d {
        private final long[] bnp;
        private boolean bnq;
        private c bnr;
        private long bns;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0180a callableC0180a) {
            this(str);
        }

        public String j() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bnp) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.bnp = new long[a.this.bne];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.bne) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.bnp[i] = Long.parseLong(strArr[i]);
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
            return new File(a.this.bmY, this.key + "." + i);
        }

        public File dC(int i) {
            return new File(a.this.bmY, this.key + "." + i + ".tmp");
        }

        private IOException p(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes11.dex */
    public final class e implements Closeable {
        private final long[] bnp;
        private final long bns;
        private final InputStream[] bnt;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0180a callableC0180a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.bnt) {
                com.baidu.poly.a.e.c.a(inputStream);
            }
        }

        public InputStream dD(int i) {
            return this.bnt[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bns = j;
            this.bnt = inputStreamArr;
            this.bnp = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.bmY = file;
        this.bnc = i;
        this.bmZ = new File(file, "journal");
        this.bna = new File(file, "journal.tmp");
        this.bnb = new File(file, "journal.bkp");
        this.bne = i2;
        this.bnd = j;
    }

    private void U() {
        if (this.bnf == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void W() {
        b(this.bna);
        Iterator<d> it = this.bng.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.bnr != null) {
                next.bnr = null;
                for (int i = 0; i < this.bne; i++) {
                    b(next.dB(i));
                    b(next.dC(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.bne; i2++) {
                    this.size += next.bnp[i2];
                }
            }
        }
    }

    private void X() {
        com.baidu.poly.a.e.b bVar = new com.baidu.poly.a.e.b(new FileInputStream(this.bmZ), com.baidu.poly.a.e.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.bnc).equals(readLine3) || !Integer.toString(this.bne).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    o(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.bnh = i - this.bng.size();
                    if (bVar.l()) {
                        Y();
                    } else {
                        this.bnf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bmZ, true), com.baidu.poly.a.e.c.US_ASCII));
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
        Writer writer = this.bnf;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bna), com.baidu.poly.a.e.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bnc));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bne));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.bng.values()) {
            if (dVar.bnr != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.j() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.bmZ.exists()) {
            a(this.bmZ, this.bnb, true);
        }
        a(this.bna, this.bmZ, false);
        this.bnb.delete();
        this.bnf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bmZ, true), com.baidu.poly.a.e.c.US_ASCII));
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
                    this.bng.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.bng.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.bng.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.bnq = true;
                dVar.bnr = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.bnr = new c(this, dVar, null);
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
        if (!bmW.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sL() {
        int i = this.bnh;
        return i >= 2000 && i >= this.bng.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.bnd) {
            remove(this.bng.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.bnf != null) {
            Iterator it = new ArrayList(this.bng.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bnr != null) {
                    dVar.bnr.abort();
                }
            }
            trimToSize();
            this.bnf.close();
            this.bnf = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.e.c.a(this.bmY);
    }

    public synchronized e fI(String str) {
        e eVar = null;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.bng.get(str);
            if (dVar != null && dVar.bnq) {
                InputStream[] inputStreamArr = new InputStream[this.bne];
                for (int i = 0; i < this.bne; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.dB(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.bne && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.e.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.bnh++;
                this.bnf.append((CharSequence) ("READ " + str + '\n'));
                if (sL()) {
                    this.bnj.submit(this.bnk);
                }
                eVar = new e(this, str, dVar.bns, inputStreamArr, dVar.bnp, null);
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
        this.bnf.flush();
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            U();
            p(str);
            d dVar = this.bng.get(str);
            if (dVar == null || dVar.bnr != null) {
                z = false;
            } else {
                for (int i = 0; i < this.bne; i++) {
                    File dB = dVar.dB(i);
                    if (!dB.exists() || dB.delete()) {
                        this.size -= dVar.bnp[i];
                        dVar.bnp[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + dB);
                    }
                }
                this.bnh++;
                this.bnf.append((CharSequence) ("REMOVE " + str + '\n'));
                this.bng.remove(str);
                if (sL()) {
                    this.bnj.submit(this.bnk);
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
                if (aVar.bmZ.exists()) {
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
            d dVar = cVar.bnl;
            if (dVar.bnr == cVar) {
                if (z && !dVar.bnq) {
                    for (int i = 0; i < this.bne; i++) {
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
                for (int i2 = 0; i2 < this.bne; i2++) {
                    File dC = dVar.dC(i2);
                    if (!z) {
                        b(dC);
                    } else if (dC.exists()) {
                        File dB = dVar.dB(i2);
                        dC.renameTo(dB);
                        long j = dVar.bnp[i2];
                        long length = dB.length();
                        dVar.bnp[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.bnh++;
                dVar.bnr = null;
                if (!(dVar.bnq | z)) {
                    this.bng.remove(dVar.key);
                    this.bnf.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.bnq = true;
                    this.bnf.write("CLEAN " + dVar.key + dVar.j() + '\n');
                    if (z) {
                        long j2 = this.bni;
                        this.bni = 1 + j2;
                        dVar.bns = j2;
                    }
                }
                this.bnf.flush();
                if (this.size > this.bnd || sL()) {
                    this.bnj.submit(this.bnk);
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
        d dVar2 = this.bng.get(str);
        if (j == -1 || (dVar2 != null && dVar2.bns == j)) {
            if (dVar2 != null) {
                if (dVar2.bnr != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.bng.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.bnr = cVar;
            this.bnf.write("DIRTY " + str + '\n');
            this.bnf.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
