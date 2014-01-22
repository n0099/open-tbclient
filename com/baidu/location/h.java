package com.baidu.location;

import com.baidu.location.c;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h {

    /* renamed from: if  reason: not valid java name */
    private static String f171if = f.v;
    private static int a = 100;

    /* renamed from: try  reason: not valid java name */
    private static long f174try = 64;

    /* renamed from: new  reason: not valid java name */
    private static int f173new = 64;

    /* renamed from: for  reason: not valid java name */
    private static float f170for = 299.0f;

    /* renamed from: do  reason: not valid java name */
    private static String f169do = f.aa + "/juz.dat";

    /* renamed from: int  reason: not valid java name */
    private static ArrayList f172int = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        private int a;

        /* renamed from: do  reason: not valid java name */
        private int f175do;

        /* renamed from: for  reason: not valid java name */
        private float f176for;

        /* renamed from: if  reason: not valid java name */
        private int f177if;

        /* renamed from: int  reason: not valid java name */
        private double f178int;

        /* renamed from: new  reason: not valid java name */
        private double f179new;

        /* renamed from: try  reason: not valid java name */
        private int f180try;

        public a(int i, int i2, int i3, int i4, double d, double d2, float f) {
            this.f175do = 0;
            this.f180try = 0;
            this.f177if = 0;
            this.a = 0;
            this.f179new = 0.0d;
            this.f178int = 0.0d;
            this.f176for = 0.0f;
            this.f175do = i;
            this.f180try = i2;
            this.f177if = i3;
            this.a = i4;
            this.f179new = d;
            this.f178int = d2;
            this.f176for = f;
        }

        public boolean a(int i, int i2, int i3) {
            return this.a == i && this.f175do == i2 && this.f180try == i3;
        }
    }

    h() {
    }

    public static String a(int i, int i2, int i3) {
        a m218if = m218if(i, i2, i3);
        if (m218if != null) {
            return String.format("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"65\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\"}}", Double.valueOf(m218if.f179new), Double.valueOf(m218if.f178int), Integer.valueOf((int) m218if.f176for));
        }
        return null;
    }

    private static void a() {
        File file = new File(f169do);
        try {
            if (!file.exists()) {
                j.a(f171if, "locCache file does not exists...");
                return;
            }
            if (f172int != null) {
                f172int.clear();
                f172int = null;
            }
            f172int = new ArrayList();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            int readInt = randomAccessFile.readInt();
            j.a(f171if, "size of loc cache is " + readInt);
            for (int i = 0; i < readInt; i++) {
                randomAccessFile.seek(f174try + (f173new * i));
                float readFloat = randomAccessFile.readFloat();
                f172int.add(new a(randomAccessFile.readInt(), randomAccessFile.readInt(), randomAccessFile.readInt(), randomAccessFile.readInt(), randomAccessFile.readDouble(), randomAccessFile.readDouble(), readFloat));
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
        float f2 = f < f170for ? f170for : f;
        a m218if = m218if(aVar.f108if, aVar.f107for, aVar.f111try);
        if (m218if != null) {
            m218if.f179new = d;
            m218if.f178int = d2;
            m218if.f176for = f2;
            j.a(f171if, "locCache update loc cache ...");
            return;
        }
        if (f172int == null) {
            f172int = new ArrayList();
        }
        f172int.add(new a(aVar.f107for, aVar.f111try, aVar.f106do, aVar.f108if, d, d2, f2));
        if (f172int.size() > a) {
            f172int.remove(0);
        }
        j.a(f171if, "locCache add new cell info into loc cache ...");
    }

    /* renamed from: do  reason: not valid java name */
    private static void m217do() {
        File file;
        if (f172int == null) {
            return;
        }
        File file2 = new File(f169do);
        try {
            if (!file2.exists()) {
                if (!new File(f.aa).exists()) {
                    j.a(f171if, "locCache make dirs " + file.mkdirs());
                }
                if (!file2.createNewFile()) {
                    j.a(f171if, "locCache create loc cache file failure ...");
                    return;
                }
                j.a(f171if, "locCache create loc cache file success ...");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            if (randomAccessFile.length() < 1) {
                randomAccessFile.writeInt(0);
            }
            int size = f172int.size() - 1;
            int i = 0;
            while (size >= 0) {
                a aVar = (a) f172int.get(size);
                if (aVar != null) {
                    randomAccessFile.seek(f174try + (f173new * (size % a)));
                    randomAccessFile.writeFloat(aVar.f176for);
                    randomAccessFile.writeInt(aVar.f177if);
                    randomAccessFile.writeDouble(aVar.f179new);
                    randomAccessFile.writeInt(aVar.a);
                    randomAccessFile.writeDouble(aVar.f178int);
                    randomAccessFile.writeInt(aVar.f175do);
                    randomAccessFile.writeInt(aVar.f180try);
                    j.a(f171if, "add a new cell loc into file ...");
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
    private static a m218if(int i, int i2, int i3) {
        try {
            if (f172int == null || f172int.size() < 1) {
                a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (f172int == null || f172int.size() < 1) {
            return null;
        }
        for (int size = f172int.size() - 1; size >= 0; size--) {
            a aVar = (a) f172int.get(size);
            if (aVar != null && aVar.a(i, i2, i3)) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m219if() {
        m217do();
    }
}
