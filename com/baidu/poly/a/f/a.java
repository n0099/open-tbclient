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
/* loaded from: classes4.dex */
public final class a implements Closeable {
    static final Pattern cnY = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream cnZ = new b();
    private int ad;
    private final File coa;
    private final File cob;
    private final File coc;
    private final File cod;
    private final int coe;
    private long cof;
    private final int cog;
    private Writer coh;
    private long size = 0;
    private final LinkedHashMap<String, d> coi = new LinkedHashMap<>(0, 0.75f, true);
    private long apS = 0;
    final ThreadPoolExecutor coj = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> cok = new CallableC0313a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class CallableC0313a implements Callable<Void> {
        CallableC0313a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.coh != null) {
                    a.this.trimToSize();
                    if (a.this.afy()) {
                        a.this.afx();
                        a.this.ad = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes4.dex */
    public final class c {
        private final d col;

        /* renamed from: com  reason: collision with root package name */
        private boolean f4781com;
        private boolean coo;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        private class C0314a extends FilterOutputStream {
            /* synthetic */ C0314a(c cVar, OutputStream outputStream, CallableC0313a callableC0313a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.f4781com = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.f4781com = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.f4781com = true;
                }
            }

            private C0314a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.f4781com = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0313a callableC0313a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.f4781com) {
                a.this.a(this, false);
                a.this.remove(this.col.key);
            } else {
                a.this.a(this, true);
            }
            this.coo = true;
        }

        public OutputStream hf(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.cog) {
                synchronized (a.this) {
                    if (this.col.cos == this) {
                        if (!this.col.cor) {
                            this.written[i] = true;
                        }
                        File hh = this.col.hh(i);
                        try {
                            fileOutputStream = new FileOutputStream(hh);
                        } catch (FileNotFoundException e) {
                            a.this.coa.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(hh);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.cnZ;
                            }
                        }
                        outputStream = new C0314a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.cog);
        }

        private c(d dVar) {
            this.col = dVar;
            this.written = dVar.cor ? null : new boolean[a.this.cog];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class d {
        private final long[] coq;
        private boolean cor;
        private c cos;
        private long cot;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0313a callableC0313a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.coq) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.coq = new long[a.this.cog];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.cog) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.coq[i] = Long.parseLong(strArr[i]);
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

        public File hg(int i) {
            return new File(a.this.coa, this.key + "." + i);
        }

        public File hh(int i) {
            return new File(a.this.coa, this.key + "." + i + ".tmp");
        }

        private IOException w(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes4.dex */
    public final class e implements Closeable {
        private final long[] coq;
        private final long cot;
        private final InputStream[] cou;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0313a callableC0313a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.cou) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream hi(int i) {
            return this.cou[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.cot = j;
            this.cou = inputStreamArr;
            this.coq = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.coa = file;
        this.coe = i;
        this.cob = new File(file, "journal");
        this.coc = new File(file, "journal.tmp");
        this.cod = new File(file, "journal.bkp");
        this.cog = i2;
        this.cof = j;
    }

    private void afv() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.cob), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.coe).equals(readLine3) || !Integer.toString(this.cog).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.coi.size();
                    if (bVar.D()) {
                        afx();
                    } else {
                        this.coh = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cob, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void afw() {
        c(this.coc);
        Iterator<d> it = this.coi.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.cos != null) {
                next.cos = null;
                for (int i = 0; i < this.cog; i++) {
                    c(next.hg(i));
                    c(next.hh(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.cog; i2++) {
                    this.size += next.coq[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afx() {
        Writer writer = this.coh;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.coc), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.coe));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.cog));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.coi.values()) {
            if (dVar.cos != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.cob.exists()) {
            a(this.cob, this.cod, true);
        }
        a(this.coc, this.cob, false);
        this.cod.delete();
        this.coh = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cob, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afy() {
        int i = this.ad;
        return i >= 2000 && i >= this.coi.size();
    }

    private void afz() {
        if (this.coh == null) {
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
                    this.coi.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.coi.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.coi.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.cor = true;
                dVar.cos = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.cos = new c(this, dVar, null);
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
        if (!cnY.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.cof) {
            remove(this.coi.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.coh != null) {
            Iterator it = new ArrayList(this.coi.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.cos != null) {
                    dVar.cos.abort();
                }
            }
            trimToSize();
            this.coh.close();
            this.coh = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.coa);
    }

    public synchronized void flush() {
        afz();
        trimToSize();
        this.coh.flush();
    }

    public synchronized e jV(String str) {
        e eVar = null;
        synchronized (this) {
            afz();
            r(str);
            d dVar = this.coi.get(str);
            if (dVar != null && dVar.cor) {
                InputStream[] inputStreamArr = new InputStream[this.cog];
                for (int i = 0; i < this.cog; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.hg(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.cog && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.coh.append((CharSequence) ("READ " + str + '\n'));
                if (afy()) {
                    this.coj.submit(this.cok);
                }
                eVar = new e(this, str, dVar.cot, inputStreamArr, dVar.coq, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            afz();
            r(str);
            d dVar = this.coi.get(str);
            if (dVar == null || dVar.cos != null) {
                z = false;
            } else {
                for (int i = 0; i < this.cog; i++) {
                    File hg = dVar.hg(i);
                    if (!hg.exists() || hg.delete()) {
                        this.size -= dVar.coq[i];
                        dVar.coq[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + hg);
                    }
                }
                this.ad++;
                this.coh.append((CharSequence) ("REMOVE " + str + '\n'));
                this.coi.remove(str);
                if (afy()) {
                    this.coj.submit(this.cok);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.col;
            if (dVar.cos == cVar) {
                if (z && !dVar.cor) {
                    for (int i = 0; i < this.cog; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.hh(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.cog; i2++) {
                    File hh = dVar.hh(i2);
                    if (!z) {
                        c(hh);
                    } else if (hh.exists()) {
                        File hg = dVar.hg(i2);
                        hh.renameTo(hg);
                        long j = dVar.coq[i2];
                        long length = hg.length();
                        dVar.coq[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.cos = null;
                if (!dVar.cor && !z) {
                    this.coi.remove(dVar.key);
                    this.coh.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.cor = true;
                    this.coh.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.apS;
                        this.apS = 1 + j2;
                        dVar.cot = j2;
                    }
                }
                this.coh.flush();
                if (this.size > this.cof || afy()) {
                    this.coj.submit(this.cok);
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

    public c jW(String str) {
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
                if (aVar.cob.exists()) {
                    try {
                        aVar.afv();
                        aVar.afw();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.afx();
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
        afz();
        r(str);
        d dVar2 = this.coi.get(str);
        if (j == -1 || (dVar2 != null && dVar2.cot == j)) {
            if (dVar2 != null) {
                if (dVar2.cos != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.coi.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.cos = cVar;
            this.coh.write("DIRTY " + str + '\n');
            this.coh.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
