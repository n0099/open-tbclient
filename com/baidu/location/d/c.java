package com.baidu.location.d;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f6684c;

    /* renamed from: a  reason: collision with root package name */
    public String f6685a = "firll.dat";

    /* renamed from: b  reason: collision with root package name */
    public int f6686b = 3164;

    /* renamed from: d  reason: collision with root package name */
    public int f6687d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f6688e = 20;

    /* renamed from: f  reason: collision with root package name */
    public int f6689f = 40;

    /* renamed from: g  reason: collision with root package name */
    public int f6690g = 60;

    /* renamed from: h  reason: collision with root package name */
    public int f6691h = 80;
    public int i = 100;

    private long a(int i) {
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
                randomAccessFile = new RandomAccessFile(h2 + File.separator + this.f6685a, "rw");
            } catch (IOException unused) {
            }
            try {
                randomAccessFile.seek(i);
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
        if (f6684c == null) {
            f6684c = new c();
        }
        return f6684c;
    }

    private void a(int i, long j) {
        String h2 = j.h();
        if (h2 == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(h2 + File.separator + this.f6685a, "rw");
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(this.f6686b);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.f6686b);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    public void a(long j) {
        a(this.f6687d, j);
    }

    public long b() {
        return a(this.f6687d);
    }
}
