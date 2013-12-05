package com.baidu.location;

import com.baidu.location.c;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h {

    /* renamed from: if  reason: not valid java name */
    private static String f207if = f.v;

    /* renamed from: a  reason: collision with root package name */
    private static int f936a = 100;

    /* renamed from: try  reason: not valid java name */
    private static long f210try = 64;

    /* renamed from: new  reason: not valid java name */
    private static int f209new = 64;

    /* renamed from: for  reason: not valid java name */
    private static float f206for = 299.0f;

    /* renamed from: do  reason: not valid java name */
    private static String f205do = f.aa + "/juz.dat";

    /* renamed from: int  reason: not valid java name */
    private static ArrayList f208int = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        private int f937a;

        /* renamed from: do  reason: not valid java name */
        private int f211do;

        /* renamed from: for  reason: not valid java name */
        private float f212for;

        /* renamed from: if  reason: not valid java name */
        private int f213if;

        /* renamed from: int  reason: not valid java name */
        private double f214int;

        /* renamed from: new  reason: not valid java name */
        private double f215new;

        /* renamed from: try  reason: not valid java name */
        private int f216try;

        public a(int i, int i2, int i3, int i4, double d, double d2, float f) {
            this.f211do = 0;
            this.f216try = 0;
            this.f213if = 0;
            this.f937a = 0;
            this.f215new = 0.0d;
            this.f214int = 0.0d;
            this.f212for = 0.0f;
            this.f211do = i;
            this.f216try = i2;
            this.f213if = i3;
            this.f937a = i4;
            this.f215new = d;
            this.f214int = d2;
            this.f212for = f;
        }

        public boolean a(int i, int i2, int i3) {
            return this.f937a == i && this.f211do == i2 && this.f216try == i3;
        }
    }

    h() {
    }

    public static String a(int i, int i2, int i3) {
        a m235if = m235if(i, i2, i3);
        if (m235if != null) {
            return String.format("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"65\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\"}}", Double.valueOf(m235if.f215new), Double.valueOf(m235if.f214int), Integer.valueOf((int) m235if.f212for));
        }
        return null;
    }

    private static void a() {
        File file = new File(f205do);
        try {
            if (!file.exists()) {
                j.a(f207if, "locCache file does not exists...");
                return;
            }
            if (f208int != null) {
                f208int.clear();
                f208int = null;
            }
            f208int = new ArrayList();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            int readInt = randomAccessFile.readInt();
            j.a(f207if, "size of loc cache is " + readInt);
            for (int i = 0; i < readInt; i++) {
                randomAccessFile.seek(f210try + (f209new * i));
                float readFloat = randomAccessFile.readFloat();
                f208int.add(new a(randomAccessFile.readInt(), randomAccessFile.readInt(), randomAccessFile.readInt(), randomAccessFile.readInt(), randomAccessFile.readDouble(), randomAccessFile.readDouble(), readFloat));
            }
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(c.a aVar, double d, double d2, float f) {
        if (aVar == null) {
            return;
        }
        float f2 = f < f206for ? f206for : f;
        a m235if = m235if(aVar.f144if, aVar.f143for, aVar.f147try);
        if (m235if != null) {
            m235if.f215new = d;
            m235if.f214int = d2;
            m235if.f212for = f2;
            j.a(f207if, "locCache update loc cache ...");
            return;
        }
        if (f208int == null) {
            f208int = new ArrayList();
        }
        f208int.add(new a(aVar.f143for, aVar.f147try, aVar.f142do, aVar.f144if, d, d2, f2));
        if (f208int.size() > f936a) {
            f208int.remove(0);
        }
        j.a(f207if, "locCache add new cell info into loc cache ...");
    }

    /* renamed from: do  reason: not valid java name */
    private static void m234do() {
        File file;
        if (f208int == null) {
            return;
        }
        File file2 = new File(f205do);
        try {
            if (!file2.exists()) {
                if (!new File(f.aa).exists()) {
                    j.a(f207if, "locCache make dirs " + file.mkdirs());
                }
                if (!file2.createNewFile()) {
                    j.a(f207if, "locCache create loc cache file failure ...");
                    return;
                }
                j.a(f207if, "locCache create loc cache file success ...");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            if (randomAccessFile.length() < 1) {
                randomAccessFile.writeInt(0);
            }
            int size = f208int.size() - 1;
            int i = 0;
            while (size >= 0) {
                a aVar = (a) f208int.get(size);
                if (aVar != null) {
                    randomAccessFile.seek(f210try + (f209new * (size % f936a)));
                    randomAccessFile.writeFloat(aVar.f212for);
                    randomAccessFile.writeInt(aVar.f213if);
                    randomAccessFile.writeDouble(aVar.f215new);
                    randomAccessFile.writeInt(aVar.f937a);
                    randomAccessFile.writeDouble(aVar.f214int);
                    randomAccessFile.writeInt(aVar.f211do);
                    randomAccessFile.writeInt(aVar.f216try);
                    j.a(f207if, "add a new cell loc into file ...");
                }
                size--;
                i++;
            }
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(i);
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: if  reason: not valid java name */
    private static a m235if(int i, int i2, int i3) {
        try {
            if (f208int == null || f208int.size() < 1) {
                a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (f208int == null || f208int.size() < 1) {
            return null;
        }
        for (int size = f208int.size() - 1; size >= 0; size--) {
            a aVar = (a) f208int.get(size);
            if (aVar != null && aVar.a(i, i2, i3)) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m236if() {
        m234do();
    }
}
