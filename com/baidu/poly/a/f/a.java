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
/* loaded from: classes6.dex */
public final class a implements Closeable {
    static final Pattern ccf = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream ccg = new b();
    private int ad;
    private final File cch;
    private final File cci;
    private final File ccj;
    private final File cck;
    private final int ccl;
    private long ccm;
    private final int ccn;
    private Writer cco;
    private long size = 0;
    private final LinkedHashMap<String, d> ccp = new LinkedHashMap<>(0, 0.75f, true);
    private long aoy = 0;
    final ThreadPoolExecutor ccq = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> ccr = new CallableC0304a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class CallableC0304a implements Callable<Void> {
        CallableC0304a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.cco != null) {
                    a.this.trimToSize();
                    if (a.this.abc()) {
                        a.this.abb();
                        a.this.ad = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes6.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes6.dex */
    public final class c {
        private final d cct;
        private boolean ccu;
        private boolean ccv;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private class C0305a extends FilterOutputStream {
            /* synthetic */ C0305a(c cVar, OutputStream outputStream, CallableC0304a callableC0304a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.ccu = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.ccu = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.ccu = true;
                }
            }

            private C0305a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.ccu = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0304a callableC0304a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.ccu) {
                a.this.a(this, false);
                a.this.remove(this.cct.key);
            } else {
                a.this.a(this, true);
            }
            this.ccv = true;
        }

        public OutputStream gM(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.ccn) {
                synchronized (a.this) {
                    if (this.cct.ccz == this) {
                        if (!this.cct.ccy) {
                            this.written[i] = true;
                        }
                        File gO = this.cct.gO(i);
                        try {
                            fileOutputStream = new FileOutputStream(gO);
                        } catch (FileNotFoundException e) {
                            a.this.cch.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(gO);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.ccg;
                            }
                        }
                        outputStream = new C0305a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.ccn);
        }

        private c(d dVar) {
            this.cct = dVar;
            this.written = dVar.ccy ? null : new boolean[a.this.ccn];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class d {
        private long ccA;
        private final long[] ccx;
        private boolean ccy;
        private c ccz;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0304a callableC0304a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.ccx) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.ccx = new long[a.this.ccn];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.ccn) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.ccx[i] = Long.parseLong(strArr[i]);
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

        public File gN(int i) {
            return new File(a.this.cch, this.key + "." + i);
        }

        public File gO(int i) {
            return new File(a.this.cch, this.key + "." + i + ".tmp");
        }

        private IOException p(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes6.dex */
    public final class e implements Closeable {
        private final long ccA;
        private final InputStream[] ccB;
        private final long[] ccx;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0304a callableC0304a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.ccB) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream gP(int i) {
            return this.ccB[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.ccA = j;
            this.ccB = inputStreamArr;
            this.ccx = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.cch = file;
        this.ccl = i;
        this.cci = new File(file, "journal");
        this.ccj = new File(file, "journal.tmp");
        this.cck = new File(file, "journal.bkp");
        this.ccn = i2;
        this.ccm = j;
    }

    private void aaZ() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.cci), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.ccl).equals(readLine3) || !Integer.toString(this.ccn).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.ccp.size();
                    if (bVar.abg()) {
                        abb();
                    } else {
                        this.cco = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cci, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void aba() {
        c(this.ccj);
        Iterator<d> it = this.ccp.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.ccz != null) {
                next.ccz = null;
                for (int i = 0; i < this.ccn; i++) {
                    c(next.gN(i));
                    c(next.gO(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.ccn; i2++) {
                    this.size += next.ccx[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void abb() {
        Writer writer = this.cco;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ccj), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.ccl));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.ccn));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.ccp.values()) {
            if (dVar.ccz != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.cci.exists()) {
            a(this.cci, this.cck, true);
        }
        a(this.ccj, this.cci, false);
        this.cck.delete();
        this.cco = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cci, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abc() {
        int i = this.ad;
        return i >= 2000 && i >= this.ccp.size();
    }

    private void abd() {
        if (this.cco == null) {
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
                    this.ccp.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.ccp.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.ccp.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.ccy = true;
                dVar.ccz = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.ccz = new c(this, dVar, null);
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
        if (!ccf.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.ccm) {
            remove(this.ccp.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.cco != null) {
            Iterator it = new ArrayList(this.ccp.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.ccz != null) {
                    dVar.ccz.abort();
                }
            }
            trimToSize();
            this.cco.close();
            this.cco = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.cch);
    }

    public synchronized void flush() {
        abd();
        trimToSize();
        this.cco.flush();
    }

    public synchronized e jy(String str) {
        e eVar = null;
        synchronized (this) {
            abd();
            r(str);
            d dVar = this.ccp.get(str);
            if (dVar != null && dVar.ccy) {
                InputStream[] inputStreamArr = new InputStream[this.ccn];
                for (int i = 0; i < this.ccn; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.gN(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.ccn && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.cco.append((CharSequence) ("READ " + str + '\n'));
                if (abc()) {
                    this.ccq.submit(this.ccr);
                }
                eVar = new e(this, str, dVar.ccA, inputStreamArr, dVar.ccx, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            abd();
            r(str);
            d dVar = this.ccp.get(str);
            if (dVar == null || dVar.ccz != null) {
                z = false;
            } else {
                for (int i = 0; i < this.ccn; i++) {
                    File gN = dVar.gN(i);
                    if (!gN.exists() || gN.delete()) {
                        this.size -= dVar.ccx[i];
                        dVar.ccx[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + gN);
                    }
                }
                this.ad++;
                this.cco.append((CharSequence) ("REMOVE " + str + '\n'));
                this.ccp.remove(str);
                if (abc()) {
                    this.ccq.submit(this.ccr);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.cct;
            if (dVar.ccz == cVar) {
                if (z && !dVar.ccy) {
                    for (int i = 0; i < this.ccn; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.gO(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.ccn; i2++) {
                    File gO = dVar.gO(i2);
                    if (!z) {
                        c(gO);
                    } else if (gO.exists()) {
                        File gN = dVar.gN(i2);
                        gO.renameTo(gN);
                        long j = dVar.ccx[i2];
                        long length = gN.length();
                        dVar.ccx[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.ccz = null;
                if (!dVar.ccy && !z) {
                    this.ccp.remove(dVar.key);
                    this.cco.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.ccy = true;
                    this.cco.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.aoy;
                        this.aoy = 1 + j2;
                        dVar.ccA = j2;
                    }
                }
                this.cco.flush();
                if (this.size > this.ccm || abc()) {
                    this.ccq.submit(this.ccr);
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

    public c jz(String str) {
        return h(str, -1L);
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
                if (aVar.cci.exists()) {
                    try {
                        aVar.aaZ();
                        aVar.aba();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.abb();
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
        abd();
        r(str);
        d dVar2 = this.ccp.get(str);
        if (j == -1 || (dVar2 != null && dVar2.ccA == j)) {
            if (dVar2 != null) {
                if (dVar2.ccz != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.ccp.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.ccz = cVar;
            this.cco.write("DIRTY " + str + '\n');
            this.cco.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
