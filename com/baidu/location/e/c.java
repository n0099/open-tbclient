package com.baidu.location.e;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f6728c;

    /* renamed from: a  reason: collision with root package name */
    public String f6729a = "firll.dat";

    /* renamed from: b  reason: collision with root package name */
    public int f6730b = 3164;

    /* renamed from: d  reason: collision with root package name */
    public int f6731d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f6732e = 20;

    /* renamed from: f  reason: collision with root package name */
    public int f6733f = 40;

    /* renamed from: g  reason: collision with root package name */
    public int f6734g = 60;

    /* renamed from: h  reason: collision with root package name */
    public int f6735h = 80;

    /* renamed from: i  reason: collision with root package name */
    public int f6736i = 100;

    private long a(int i2) {
        RandomAccessFile randomAccessFile;
        int readInt;
        long readLong;
        String j = k.j();
        if (j == null) {
            return -1L;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(j + File.separator + this.f6729a, "rw");
            } catch (IOException unused) {
            }
            try {
                randomAccessFile.seek(i2);
                readInt = randomAccessFile.readInt();
                readLong = randomAccessFile.readLong();
            } catch (Exception unused2) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                return -1L;
            } catch (Throwable th) {
                th = th;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (readInt == randomAccessFile.readInt()) {
            try {
                randomAccessFile.close();
            } catch (IOException unused5) {
            }
            return readLong;
        }
        randomAccessFile.close();
        return -1L;
    }

    public static c a() {
        if (f6728c == null) {
            f6728c = new c();
        }
        return f6728c;
    }

    private void a(int i2, long j) {
        String j2 = k.j();
        if (j2 == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(j2 + File.separator + this.f6729a, "rw");
            randomAccessFile.seek(i2);
            randomAccessFile.writeInt(this.f6730b);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.f6730b);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    public void a(long j) {
        a(this.f6731d, j);
    }

    public long b() {
        return a(this.f6731d);
    }
}
