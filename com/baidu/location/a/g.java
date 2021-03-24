package com.baidu.location.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f6493a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f6494b = "Temp_in.dat";

    /* renamed from: c  reason: collision with root package name */
    public static File f6495c = new File(com.baidu.location.d.i.f6712a, f6494b);

    /* renamed from: d  reason: collision with root package name */
    public static StringBuffer f6496d = null;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f6497e = true;

    /* renamed from: f  reason: collision with root package name */
    public static int f6498f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f6499g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static long f6500h = 0;
    public static long i = 0;
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
        File file = f6495c;
        if (file != null && file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(f6495c, "rw");
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
                if (readInt < com.baidu.location.d.j.ae) {
                    i2 = readInt2 + 1;
                } else {
                    if (readInt2 != com.baidu.location.d.j.ae) {
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
        return i2 >= 0 && i2 <= (i5 = com.baidu.location.d.j.ae) && i3 >= 0 && i3 <= (i6 = i2 + 1) && i4 >= 1 && i4 <= i6 && i4 <= i5;
    }

    public static void b() {
        f6497e = true;
        f6496d = null;
        f6498f = 0;
        f6499g = 0;
        f6500h = 0L;
        i = 0L;
        j = 0L;
        k = 0.0d;
        l = 0.0d;
        m = 0;
        n = 0;
        o = 0;
    }

    public static boolean c() {
        if (f6495c.exists()) {
            f6495c.delete();
        }
        if (!f6495c.getParentFile().exists()) {
            f6495c.getParentFile().mkdirs();
        }
        try {
            f6495c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(f6495c, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            b();
            return f6495c.exists();
        } catch (IOException unused) {
            return false;
        }
    }
}
