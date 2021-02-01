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
    static final Pattern cnA = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream cnB = new b();
    private int ad;
    private final File cnC;
    private final File cnD;
    private final File cnE;
    private final File cnF;
    private final int cnG;
    private long cnH;
    private final int cnI;
    private Writer cnJ;
    private long size = 0;
    private final LinkedHashMap<String, d> cnK = new LinkedHashMap<>(0, 0.75f, true);
    private long aoT = 0;
    final ThreadPoolExecutor cnL = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> cnM = new CallableC0300a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class CallableC0300a implements Callable<Void> {
        CallableC0300a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                if (a.this.cnJ != null) {
                    a.this.trimToSize();
                    if (a.this.adt()) {
                        a.this.ads();
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
        private final d cnN;
        private boolean cnO;
        private boolean cnP;
        private final boolean[] written;

        /* renamed from: com.baidu.poly.a.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        private class C0301a extends FilterOutputStream {
            /* synthetic */ C0301a(c cVar, OutputStream outputStream, CallableC0300a callableC0300a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException e) {
                    c.this.cnO = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException e) {
                    c.this.cnO = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException e) {
                    c.this.cnO = true;
                }
            }

            private C0301a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException e) {
                    c.this.cnO = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0300a callableC0300a) {
            this(dVar);
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void commit() {
            if (this.cnO) {
                a.this.a(this, false);
                a.this.remove(this.cnN.key);
            } else {
                a.this.a(this, true);
            }
            this.cnP = true;
        }

        public OutputStream fE(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i >= 0 && i < a.this.cnI) {
                synchronized (a.this) {
                    if (this.cnN.cnT == this) {
                        if (!this.cnN.cnS) {
                            this.written[i] = true;
                        }
                        File fG = this.cnN.fG(i);
                        try {
                            fileOutputStream = new FileOutputStream(fG);
                        } catch (FileNotFoundException e) {
                            a.this.cnC.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(fG);
                            } catch (FileNotFoundException e2) {
                                outputStream = a.cnB;
                            }
                        }
                        outputStream = new C0301a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return outputStream;
            }
            throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.cnI);
        }

        private c(d dVar) {
            this.cnN = dVar;
            this.written = dVar.cnS ? null : new boolean[a.this.cnI];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class d {
        private final long[] cnR;
        private boolean cnS;
        private c cnT;
        private long cnU;
        private final String key;

        /* synthetic */ d(a aVar, String str, CallableC0300a callableC0300a) {
            this(str);
        }

        public String B() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.cnR) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.key = str;
            this.cnR = new long[a.this.cnI];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.cnI) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.cnR[i] = Long.parseLong(strArr[i]);
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

        public File fF(int i) {
            return new File(a.this.cnC, this.key + "." + i);
        }

        public File fG(int i) {
            return new File(a.this.cnC, this.key + "." + i + ".tmp");
        }

        private IOException w(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* loaded from: classes4.dex */
    public final class e implements Closeable {
        private final long[] cnR;
        private final long cnU;
        private final InputStream[] cnV;
        private final String key;

        /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0300a callableC0300a) {
            this(str, j, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.cnV) {
                com.baidu.poly.a.f.c.a(inputStream);
            }
        }

        public InputStream fH(int i) {
            return this.cnV[i];
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.cnU = j;
            this.cnV = inputStreamArr;
            this.cnR = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.cnC = file;
        this.cnG = i;
        this.cnD = new File(file, "journal");
        this.cnE = new File(file, "journal.tmp");
        this.cnF = new File(file, "journal.bkp");
        this.cnI = i2;
        this.cnH = j;
    }

    private void adq() {
        com.baidu.poly.a.f.b bVar = new com.baidu.poly.a.f.b(new FileInputStream(this.cnD), com.baidu.poly.a.f.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.cnG).equals(readLine3) || !Integer.toString(this.cnI).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bVar.readLine());
                    i++;
                } catch (EOFException e2) {
                    this.ad = i - this.cnK.size();
                    if (bVar.D()) {
                        ads();
                    } else {
                        this.cnJ = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cnD, true), com.baidu.poly.a.f.c.US_ASCII));
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

    private void adr() {
        c(this.cnE);
        Iterator<d> it = this.cnK.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.cnT != null) {
                next.cnT = null;
                for (int i = 0; i < this.cnI; i++) {
                    c(next.fF(i));
                    c(next.fG(i));
                }
                it.remove();
            } else {
                for (int i2 = 0; i2 < this.cnI; i2++) {
                    this.size += next.cnR[i2];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ads() {
        Writer writer = this.cnJ;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cnE), com.baidu.poly.a.f.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.cnG));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.cnI));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.cnK.values()) {
            if (dVar.cnT != null) {
                bufferedWriter.write("DIRTY " + dVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.key + dVar.B() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.cnD.exists()) {
            a(this.cnD, this.cnF, true);
        }
        a(this.cnE, this.cnD, false);
        this.cnF.delete();
        this.cnJ = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.cnD, true), com.baidu.poly.a.f.c.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adt() {
        int i = this.ad;
        return i >= 2000 && i >= this.cnK.size();
    }

    private void adu() {
        if (this.cnJ == null) {
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
                    this.cnK.remove(substring2);
                    return;
                }
                substring = substring2;
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.cnK.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.cnK.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.cnS = true;
                dVar.cnT = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.cnT = new c(this, dVar, null);
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
        if (!cnA.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.cnH) {
            remove(this.cnK.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.cnJ != null) {
            Iterator it = new ArrayList(this.cnK.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.cnT != null) {
                    dVar.cnT.abort();
                }
            }
            trimToSize();
            this.cnJ.close();
            this.cnJ = null;
        }
    }

    public void delete() {
        close();
        com.baidu.poly.a.f.c.a(this.cnC);
    }

    public synchronized void flush() {
        adu();
        trimToSize();
        this.cnJ.flush();
    }

    public synchronized e jp(String str) {
        e eVar = null;
        synchronized (this) {
            adu();
            r(str);
            d dVar = this.cnK.get(str);
            if (dVar != null && dVar.cnS) {
                InputStream[] inputStreamArr = new InputStream[this.cnI];
                for (int i = 0; i < this.cnI; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(dVar.fF(i));
                    } catch (FileNotFoundException e2) {
                        for (int i2 = 0; i2 < this.cnI && inputStreamArr[i2] != null; i2++) {
                            com.baidu.poly.a.f.c.a(inputStreamArr[i2]);
                        }
                    }
                }
                this.ad++;
                this.cnJ.append((CharSequence) ("READ " + str + '\n'));
                if (adt()) {
                    this.cnL.submit(this.cnM);
                }
                eVar = new e(this, str, dVar.cnU, inputStreamArr, dVar.cnR, null);
            }
        }
        return eVar;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            adu();
            r(str);
            d dVar = this.cnK.get(str);
            if (dVar == null || dVar.cnT != null) {
                z = false;
            } else {
                for (int i = 0; i < this.cnI; i++) {
                    File fF = dVar.fF(i);
                    if (!fF.exists() || fF.delete()) {
                        this.size -= dVar.cnR[i];
                        dVar.cnR[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + fF);
                    }
                }
                this.ad++;
                this.cnJ.append((CharSequence) ("REMOVE " + str + '\n'));
                this.cnK.remove(str);
                if (adt()) {
                    this.cnL.submit(this.cnM);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        synchronized (this) {
            d dVar = cVar.cnN;
            if (dVar.cnT == cVar) {
                if (z && !dVar.cnS) {
                    for (int i = 0; i < this.cnI; i++) {
                        if (cVar.written[i]) {
                            if (!dVar.fG(i).exists()) {
                                cVar.abort();
                                break;
                            }
                        } else {
                            cVar.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.cnI; i2++) {
                    File fG = dVar.fG(i2);
                    if (!z) {
                        c(fG);
                    } else if (fG.exists()) {
                        File fF = dVar.fF(i2);
                        fG.renameTo(fF);
                        long j = dVar.cnR[i2];
                        long length = fF.length();
                        dVar.cnR[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                }
                this.ad++;
                dVar.cnT = null;
                if (!dVar.cnS && !z) {
                    this.cnK.remove(dVar.key);
                    this.cnJ.write("REMOVE " + dVar.key + '\n');
                } else {
                    dVar.cnS = true;
                    this.cnJ.write("CLEAN " + dVar.key + dVar.B() + '\n');
                    if (z) {
                        long j2 = this.aoT;
                        this.aoT = 1 + j2;
                        dVar.cnU = j2;
                    }
                }
                this.cnJ.flush();
                if (this.size > this.cnH || adt()) {
                    this.cnL.submit(this.cnM);
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

    public c jq(String str) {
        return g(str, -1L);
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
                if (aVar.cnD.exists()) {
                    try {
                        aVar.adq();
                        aVar.adr();
                        return aVar;
                    } catch (IOException e2) {
                        com.baidu.poly.util.d.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.ads();
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
        adu();
        r(str);
        d dVar2 = this.cnK.get(str);
        if (j == -1 || (dVar2 != null && dVar2.cnU == j)) {
            if (dVar2 != null) {
                if (dVar2.cnT != null) {
                    cVar = null;
                } else {
                    dVar = dVar2;
                }
            } else {
                d dVar3 = new d(this, str, null);
                this.cnK.put(str, dVar3);
                dVar = dVar3;
            }
            cVar = new c(this, dVar, null);
            dVar.cnT = cVar;
            this.cnJ.write("DIRTY " + str + '\n');
            this.cnJ.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }
}
