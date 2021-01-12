package com.baidu.location.d;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class c {
    static c c;

    /* renamed from: a  reason: collision with root package name */
    String f2627a = "firll.dat";

    /* renamed from: b  reason: collision with root package name */
    int f2628b = 3164;
    int d = 0;
    int e = 20;
    int f = 40;
    int g = 60;
    int h = 80;
    int i = 100;

    private long a(int i) {
        RandomAccessFile randomAccessFile;
        String h = j.h();
        if (h == null) {
            return -1L;
        }
        String str = h + File.separator + this.f2627a;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                randomAccessFile.seek(i);
                int readInt = randomAccessFile.readInt();
                long readLong = randomAccessFile.readLong();
                if (readInt == randomAccessFile.readInt()) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e) {
                        }
                    }
                    return readLong;
                } else if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        return -1L;
                    } catch (IOException e2) {
                        return -1L;
                    }
                } else {
                    return -1L;
                }
            } catch (Exception e3) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                        return -1L;
                    } catch (IOException e4) {
                        return -1L;
                    }
                }
                return -1L;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static c a() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    private void a(int i, long j) {
        String h = j.h();
        if (h == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(h + File.separator + this.f2627a, "rw");
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(this.f2628b);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.f2628b);
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    public void a(long j) {
        a(this.d, j);
    }

    public long b() {
        return a(this.d);
    }
}
