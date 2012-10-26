package com.baidu.location;

import com.baidu.location.c;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {

    /* renamed from: if  reason: not valid java name */
    private static String f155if = f.g;
    private static int a = 100;

    /* renamed from: try  reason: not valid java name */
    private static long f158try = 64;

    /* renamed from: new  reason: not valid java name */
    private static int f157new = 64;

    /* renamed from: for  reason: not valid java name */
    private static float f154for = 299.0f;

    /* renamed from: do  reason: not valid java name */
    private static String f153do = f.O + "/juz.dat";

    /* renamed from: int  reason: not valid java name */
    private static ArrayList f156int = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private int a;

        /* renamed from: do  reason: not valid java name */
        private int f159do;

        /* renamed from: for  reason: not valid java name */
        private float f160for;

        /* renamed from: if  reason: not valid java name */
        private int f161if;

        /* renamed from: int  reason: not valid java name */
        private double f162int;

        /* renamed from: new  reason: not valid java name */
        private double f163new;

        /* renamed from: try  reason: not valid java name */
        private int f164try;

        public a(int i, int i2, int i3, int i4, double d, double d2, float f) {
            this.f159do = 0;
            this.f164try = 0;
            this.f161if = 0;
            this.a = 0;
            this.f163new = 0.0d;
            this.f162int = 0.0d;
            this.f160for = 0.0f;
            this.f159do = i;
            this.f164try = i2;
            this.f161if = i3;
            this.a = i4;
            this.f163new = d;
            this.f162int = d2;
            this.f160for = f;
        }

        public boolean a(int i, int i2, int i3) {
            return this.a == i && this.f159do == i2 && this.f164try == i3;
        }
    }

    h() {
    }

    public static String a(int i, int i2, int i3) {
        a m167if = m167if(i, i2, i3);
        if (m167if != null) {
            return String.format("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"65\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\"}}", Double.valueOf(m167if.f163new), Double.valueOf(m167if.f162int), Integer.valueOf((int) m167if.f160for));
        }
        return null;
    }

    private static void a() {
        File file = new File(f153do);
        try {
            if (!file.exists()) {
                j.a(f155if, "locCache file does not exists...");
                return;
            }
            if (f156int != null) {
                f156int.clear();
                f156int = null;
            }
            f156int = new ArrayList();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            int readInt = randomAccessFile.readInt();
            j.a(f155if, "size of loc cache is " + readInt);
            for (int i = 0; i < readInt; i++) {
                randomAccessFile.seek(f158try + (f157new * i));
                float readFloat = randomAccessFile.readFloat();
                f156int.add(new a(randomAccessFile.readInt(), randomAccessFile.readInt(), randomAccessFile.readInt(), randomAccessFile.readInt(), randomAccessFile.readDouble(), randomAccessFile.readDouble(), readFloat));
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
        float f2 = f < f154for ? f154for : f;
        a m167if = m167if(aVar.f106if, aVar.f105for, aVar.f109try);
        if (m167if != null) {
            m167if.f163new = d;
            m167if.f162int = d2;
            m167if.f160for = f2;
            j.a(f155if, "locCache update loc cache ...");
            return;
        }
        if (f156int == null) {
            f156int = new ArrayList();
        }
        f156int.add(new a(aVar.f105for, aVar.f109try, aVar.f104do, aVar.f106if, d, d2, f2));
        if (f156int.size() > a) {
            f156int.remove(0);
        }
        j.a(f155if, "locCache add new cell info into loc cache ...");
    }

    /* renamed from: do  reason: not valid java name */
    private static void m166do() {
        File file;
        if (f156int == null) {
            return;
        }
        File file2 = new File(f153do);
        try {
            if (!file2.exists()) {
                if (!new File(f.O).exists()) {
                    j.a(f155if, "locCache make dirs " + file.mkdirs());
                }
                if (!file2.createNewFile()) {
                    j.a(f155if, "locCache create loc cache file failure ...");
                    return;
                }
                j.a(f155if, "locCache create loc cache file success ...");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            if (randomAccessFile.length() < 1) {
                randomAccessFile.writeInt(0);
            }
            int size = f156int.size() - 1;
            int i = 0;
            while (size >= 0) {
                a aVar = (a) f156int.get(size);
                if (aVar != null) {
                    randomAccessFile.seek(f158try + (f157new * (size % a)));
                    randomAccessFile.writeFloat(aVar.f160for);
                    randomAccessFile.writeInt(aVar.f161if);
                    randomAccessFile.writeDouble(aVar.f163new);
                    randomAccessFile.writeInt(aVar.a);
                    randomAccessFile.writeDouble(aVar.f162int);
                    randomAccessFile.writeInt(aVar.f159do);
                    randomAccessFile.writeInt(aVar.f164try);
                    j.a(f155if, "add a new cell loc into file ...");
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
    private static a m167if(int i, int i2, int i3) {
        try {
            if (f156int == null || f156int.size() < 1) {
                a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (f156int == null || f156int.size() < 1) {
            return null;
        }
        for (int size = f156int.size() - 1; size >= 0; size--) {
            a aVar = (a) f156int.get(size);
            if (aVar != null && aVar.a(i, i2, i3)) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m168if() {
        m166do();
    }
}
