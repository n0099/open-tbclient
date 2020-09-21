package com.baidu.location.e;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public class d {
    static d c;
    String a = "firll.dat";
    int b = 3164;
    int d = 0;
    int e = 20;
    int f = 40;
    int g = 60;
    int h = 80;
    int i = 100;

    private long a(int i) {
        RandomAccessFile randomAccessFile;
        String j = l.j();
        if (j == null) {
            return -1L;
        }
        String str = j + File.separator + this.a;
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

    public static d a() {
        if (c == null) {
            c = new d();
        }
        return c;
    }

    private void a(int i, long j) {
        String j2 = l.j();
        if (j2 == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(j2 + File.separator + this.a, "rw");
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(this.b);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.b);
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
