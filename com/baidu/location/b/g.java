package com.baidu.location.b;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f6525a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f6526b = "Temp_in.dat";

    /* renamed from: c  reason: collision with root package name */
    public static File f6527c = new File(com.baidu.location.e.j.f6760a, f6526b);

    /* renamed from: d  reason: collision with root package name */
    public static StringBuffer f6528d = null;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f6529e = true;

    /* renamed from: f  reason: collision with root package name */
    public static int f6530f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f6531g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static long f6532h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static long f6533i = 0;
    public static long j = 0;
    public static double k = 0.0d;
    public static double l = 0.0d;
    public static int m = 0;
    public static int n = 0;
    public static int o = 0;

    public static String a() {
        RandomAccessFile randomAccessFile;
        int readInt;
        int readInt2;
        int readInt3;
        int i2;
        File file = f6527c;
        if (file != null && file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(f6527c, "rw");
                randomAccessFile.seek(0L);
                readInt = randomAccessFile.readInt();
                readInt2 = randomAccessFile.readInt();
                readInt3 = randomAccessFile.readInt();
            } catch (IOException unused) {
            }
            if (!a(readInt, readInt2, readInt3)) {
                randomAccessFile.close();
                c();
                return null;
            }
            if (readInt2 != 0 && readInt2 != readInt3) {
                long j2 = ((readInt2 - 1) * 1024) + 12 + 0;
                randomAccessFile.seek(j2);
                int readInt4 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt4];
                randomAccessFile.seek(j2 + 4);
                for (int i3 = 0; i3 < readInt4; i3++) {
                    bArr[i3] = randomAccessFile.readByte();
                }
                String str = new String(bArr);
                int i4 = 1;
                if (readInt < com.baidu.location.e.k.af) {
                    i2 = readInt2 + 1;
                } else {
                    if (readInt2 != com.baidu.location.e.k.af) {
                        i4 = 1 + readInt2;
                    }
                    i2 = i4;
                }
                randomAccessFile.seek(4L);
                randomAccessFile.writeInt(i2);
                randomAccessFile.close();
                return str;
            }
            randomAccessFile.close();
            return null;
        }
        return null;
    }

    public static boolean a(int i2, int i3, int i4) {
        int i5;
        int i6;
        return i2 >= 0 && i2 <= (i5 = com.baidu.location.e.k.af) && i3 >= 0 && i3 <= (i6 = i2 + 1) && i4 >= 1 && i4 <= i6 && i4 <= i5;
    }

    public static void b() {
        f6529e = true;
        f6528d = null;
        f6530f = 0;
        f6531g = 0;
        f6532h = 0L;
        f6533i = 0L;
        j = 0L;
        k = 0.0d;
        l = 0.0d;
        m = 0;
        n = 0;
        o = 0;
    }

    public static boolean c() {
        if (f6527c.exists()) {
            f6527c.delete();
        }
        if (!f6527c.getParentFile().exists()) {
            f6527c.getParentFile().mkdirs();
        }
        try {
            f6527c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(f6527c, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            b();
            return f6527c.exists();
        } catch (IOException unused) {
            return false;
        }
    }
}
