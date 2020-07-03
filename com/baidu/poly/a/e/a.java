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
    static final Pattern bzq = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream bzr = new b();
    private int bzB;
    private final File bzs;
    private final File bzt;
    private final File bzu;
    private final File bzv;
    private final int bzw;
    private long bzx;
    private final int bzy;
    private Writer bzz;
    private long size = 0;
    private final LinkedHashMap<String, d> bzA = new LinkedHashMap<>(0, 0.75f, true);
    private long bzC = 0;
    final ThreadPoolExecutor bzD = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> bzE = new CallableC0241a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class CallableC0241a implements Callable<Void> {
        CallableC0241a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.bzz != null) {
                    a.this.trimToSize();
                    if (a.this.Oc()) {
                        a.this.Ob();
                        a.this.bzB = 0;
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
        private final d bzF;
        private boolean bzG;
        private boolean bzH;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        private class C0242a extends FilterOutputStream {
            /* synthetic */ C0242a(c cVar, OutputStream outputStream, CallableC0241a callableC0241a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.bzG = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.bzG = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.bzG = true;
                }
            }

            private C0242a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.bzG = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0241a callableC0241a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.bzG) {
                a.this.a(this, false);
                a.this.remove(this.bzF.key);
            } else {
                a.this.a(this, true);
            }
            this.bzH = true;
        }

        private c(d dVar) {
            this.bzF = dVar;
            this.written = dVar.bzK ? null : new boolean[a.this.bzy];
        }

        public OutputStream dT(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.bzy) {
                synchronized (a.this) {
                    if (this.bzF.bzL == this) {
                        if (!this.bzF.bzK) {
                            this.written[i] = true;
                        }
                        File dV = this.bzF.dV(i);
                        try {
                            fileOutputStream = new FileOutputStream(dV);
                        } catch (FileNotFoundException e) {
                            a.this.bzs.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(dV);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.bzr;
                            }
                        }
                        outputStream = new C0242a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.bzy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class d {
        private final long[] bzJ;
        private boolean bzK;
        private c bzL;
        private long bzM;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0241a callableC0241a) {
            this(str);
        }

        public String q() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bzJ) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.bzJ = new long[a.this.bzy];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.bzy) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.bzJ[i] = Long.parseLong(strArr[i]);
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

        public File dU(int i) {
            return new File(a.this.bzs, this.key + "." + i);
        }

        public File dV(int i) {
            return new File(a.this.bzs, this.key + "." + i + ".tmp");
        }

        private IOException n(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes11.dex */
    public final class e implements Closeable {
        private final long[] bzJ;
        private final long bzM;
        private final InputStream[] bzN;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0241a callableC0241a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.bzN) {
                com.baidu.poly.a.e.c.a(inputStream);
            }
        }

        public InputStream dW(int i) {
            return this.bzN[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bzM = j;
            this.bzN = inputStreamArr;
            this.bzJ = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.bzs = file;
        this.bzw = i;
        this.bzt = new File(file, "journal");
        this.bzu = new File(file, "journal.tmp");
        this.bzv = new File(file, "journal.bkp");
        this.bzy = i2;
        this.bzx = j;
    }

    private void NZ() {
        com.baidu.poly.a.e.b bVar = new com.baidu.poly.a.e.b(new FileInputStream(this.bzt), com.baidu.poly.a.e.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.bzw).equals(readLine3) || !Integer.toString(this.bzy).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    p(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.bzB = i - this.bzA.size();
                    if (bVar.t()) {
                        Ob();
                    } else {
                        this.bzz = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bzt, true), com.baidu.poly.a.e.c.US_ASCII));
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

    private void Oa() {
        c(this.bzu);
        Iterator<d> it = this.bzA.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.bzL != null) {
                next.bzL = null;
                for (int i = 0; i < this.bzy; i++) {
                    c(next.dU(i));
                    c(next.dV(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.bzy; i2++) {
                    this.size += next.bzJ[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Ob() {
        Writer writer = this.bzz;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bzu), com.baidu.poly.a.e.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bzw));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.bzy));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.bzA.values()) {
            if (dVar.bzL != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.q() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.bzt.exists()) {
            a(this.bzt, this.bzv, true);
        }
        a(this.bzu, this.bzt, false);
        this.bzv.delete();
        this.bzz = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bzt, true), com.baidu.poly.a.e.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Oc() {
        int i = this.bzB;
        return i >= 2000 && i >= this.bzA.size();
    }

    private void Od() {
        if (this.bzz == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void p(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                String substring2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.bzA.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.bzA.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.bzA.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.bzK = true;
                dVar.bzL = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.bzL = new c(this, dVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void q(String str) {
        if (!bzq.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.bzx) {
            remove(this.bzA.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.bzz != null) {
            Iterator it = new ArrayList(this.bzA.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.bzL != null) {
                    dVar.bzL.abort();
                }
            }
            trimToSize();
            this.bzz.close();
            this.bzz = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.e.c.a(this.bzs);
    }

    public synchronized void flush() {
        Od();
        trimToSize();
        this.bzz.flush();
    }

    public synchronized e gD(String str) {
        e eVar = null;
        synchronized (this) {
            Od();
            q(str);
            d dVar = this.bzA.get(str);
            if (dVar != null && dVar.bzK) {
                InputStream[] inputStreamArr = new InputStream[this.bzy];
                for (int i = 0; i < this.bzy; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.dU(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.bzy && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.e.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.bzB++;
                this.bzz.append((CharSequence) ("READ " + str + '\n'));
                if (Oc()) {
                    this.bzD.submit(this.bzE);
                }
                eVar = new e(this, str, dVar.bzM, inputStreamArr, dVar.bzJ, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            Od();
            q(str);
            d dVar = this.bzA.get(str);
            if (dVar == null || dVar.bzL != null) {
                z = false;
            } else {
                for (int i = 0; i < this.bzy; i++) {
                    File dU = dVar.dU(i);
                    if (!dU.exists() || dU.delete()) {
                        this.size -= dVar.bzJ[i];
                        dVar.bzJ[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + dU);
                    }
                }
                this.bzB++;
                this.bzz.append((CharSequence) ("REMOVE " + str + '\n'));
                this.bzA.remove(str);
                if (Oc()) {
                    this.bzD.submit(this.bzE);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.bzF;
            if (dVar.bzL == cVar) {
                if (z && !dVar.bzK) {
                    for (int i = 0; i < this.bzy; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.dV(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.bzy; i2++) {
                    File dV = dVar.dV(i2);
                    if (!z) {
                        c(dV);
                    } else if (dV.exists()) {
                        File dU = dVar.dU(i2);
                        dV.renameTo(dU);
                        long j = dVar.bzJ[i2];
                        long length = dU.length();
                        dVar.bzJ[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.bzB++;
                dVar.bzL = null;
                if (!dVar.bzK && !z) {
                    this.bzA.remove(dVar.key);
                    this.bzz.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.bzK = true;
                    this.bzz.write("CLEAN " + dVar.key + dVar.q() + '\n');
                    if (z) {
                        long j2 = this.bzC;
                        this.bzC = 1 + j2;
                        dVar.bzM = j2;
                    }
                }
                this.bzz.flush();
                if (this.size > this.bzx || Oc()) {
                    this.bzD.submit(this.bzE);
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

    public c gE(String str) {
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
                if (aVar.bzt.exists()) {
                    try {
                        aVar.NZ();
                        aVar.Oa();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.l("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.Ob();
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
        Od();
        q(str);
        d dVar2 = this.bzA.get(str);
        if (j == -1 || (dVar2 != null && dVar2.bzM == j)) {
            if (dVar2 != null) {
                if (dVar2.bzL != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.bzA.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.bzL = cVar;
            this.bzz.write("DIRTY " + str + '\n');
            this.bzz.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
