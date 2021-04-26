package com.baidu.location.d;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f6953c;

    /* renamed from: a  reason: collision with root package name */
    public String f6954a = "firll.dat";

    /* renamed from: b  reason: collision with root package name */
    public int f6955b = 3164;

    /* renamed from: d  reason: collision with root package name */
    public int f6956d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f6957e = 20;

    /* renamed from: f  reason: collision with root package name */
    public int f6958f = 40;

    /* renamed from: g  reason: collision with root package name */
    public int f6959g = 60;

    /* renamed from: h  reason: collision with root package name */
    public int f6960h = 80;

    /* renamed from: i  reason: collision with root package name */
    public int f6961i = 100;

    private long a(int i2) {
        RandomAccessFile randomAccessFile;
        int readInt;
        long readLong;
        String h2 = j.h();
        if (h2 == null) {
            return -1L;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(h2 + File.separator + this.f6954a, "rw");
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
        if (f6953c == null) {
            f6953c = new c();
        }
        return f6953c;
    }

    private void a(int i2, long j) {
        String h2 = j.h();
        if (h2 == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(h2 + File.separator + this.f6954a, "rw");
            randomAccessFile.seek(i2);
            randomAccessFile.writeInt(this.f6955b);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.f6955b);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    public void a(long j) {
        a(this.f6956d, j);
    }

    public long b() {
        return a(this.f6956d);
    }
}
