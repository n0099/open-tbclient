package com.baidu.location;

import android.location.Location;
import com.baidu.location.au;
import com.baidu.location.u;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a0, n {
    private static final int cI = 2048;
    private static final int cc = 2048;
    private static final int cd = 2048;
    private static final int cl = 128;
    private static final int cr = 1040;
    private static final int ct = 32;
    private b cA;
    long cH = 0;
    private int cp;
    private static ArrayList cv = new ArrayList();
    private static ArrayList cm = new ArrayList();
    private static ArrayList cB = new ArrayList();
    private static ArrayList cN = new ArrayList();
    private static ArrayList cx = new ArrayList();
    private static ArrayList cG = new ArrayList();
    private static String cP = I + "/yo.dat";
    private static final String cK = I + "/yoh.dat";
    private static final String cJ = I + "/yom.dat";
    private static final String cy = I + "/yol.dat";
    private static final String cE = I + "/yor.dat";
    private static File ck = null;
    private static int ci = 1024;
    private static int cM = 512;
    private static int ch = 8;
    private static int cw = 5;
    private static int co = 8;
    private static int cg = 16;
    private static int cD = 1024;
    private static int cz = 256;
    private static double cf = 0.0d;
    private static double cC = 0.1d;
    private static double cn = 30.0d;
    private static double ce = 100.0d;
    private static int cq = 0;
    private static int cj = 64;
    private static int cL = 128;
    private static Location cs = null;
    private static Location cF = null;
    private static Location cb = null;
    private static au.b cu = null;
    private static q cO = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends t {
        private String du;

        public a(String str) {
            this.du = str;
            this.cZ = new ArrayList();
        }

        @Override // com.baidu.location.t
        void X() {
            this.cX = c.m265for();
            this.cZ.add(new BasicNameValuePair("cldc[0]", this.du));
        }

        public void aj() {
            R();
        }

        @Override // com.baidu.location.t
        /* renamed from: do */
        void mo112do(boolean z) {
            if (!z || this.cY != null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends t {
        boolean dw = false;
        int dz = 0;
        int dy = 0;
        private ArrayList dx = null;

        public b() {
            this.cZ = new ArrayList();
        }

        @Override // com.baidu.location.t
        void X() {
            this.cX = c.m265for();
            this.c8 = 2;
            if (this.dx != null) {
                for (int i = 0; i < this.dx.size(); i++) {
                    if (this.dz == 1) {
                        this.cZ.add(new BasicNameValuePair("cldc[" + i + "]", (String) this.dx.get(i)));
                    } else {
                        this.cZ.add(new BasicNameValuePair("cltr[" + i + "]", (String) this.dx.get(i)));
                    }
                }
                this.cZ.add(new BasicNameValuePair("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis()))));
            }
        }

        public void ak() {
            if (this.dw) {
                return;
            }
            if (c6 > 4 && this.dy < c6) {
                this.dy++;
                return;
            }
            this.dy = 0;
            this.dw = true;
            this.dz = 0;
            if (this.dx == null || this.dx.size() < 1) {
                if (this.dx == null) {
                    this.dx = new ArrayList();
                }
                this.dz = 0;
                int i = 0;
                do {
                    String C = this.dz < 2 ? q.C() : null;
                    if (C != null || this.dz == 1) {
                        this.dz = 1;
                    } else {
                        this.dz = 2;
                        try {
                            if (c.ba == 0) {
                                C = l.t();
                                if (C == null) {
                                    C = y.aT();
                                }
                            } else if (c.ba == 1 && (C = y.aT()) == null) {
                                C = l.t();
                            }
                        } catch (Exception e) {
                            C = null;
                        }
                    }
                    if (C == null) {
                        break;
                    }
                    this.dx.add(C);
                    i += C.length();
                } while (i < 5120);
            }
            if (this.dx != null && this.dx.size() >= 1) {
                R();
                return;
            }
            this.dx = null;
            this.dw = false;
        }

        @Override // com.baidu.location.t
        /* renamed from: do */
        void mo112do(boolean z) {
            if (z && this.cY != null && this.dx != null) {
                this.dx.clear();
            }
            if (this.cZ != null) {
                this.cZ.clear();
            }
            this.dw = false;
        }
    }

    private q() {
        this.cA = null;
        this.cp = 0;
        this.cA = new b();
        this.cp = 0;
    }

    public static String C() {
        return E();
    }

    public static void D() {
    }

    public static String E() {
        String str = null;
        for (int i = 1; i < 5; i++) {
            str = m322if(i);
            if (str != null) {
                return str;
            }
        }
        m321if(cG, cj);
        if (cG.size() > 0) {
            str = (String) cG.get(0);
            cG.remove(0);
        }
        if (str == null) {
            m321if(cG, cq);
            if (cG.size() > 0) {
                str = (String) cG.get(0);
                cG.remove(0);
            }
            if (str == null) {
                m321if(cG, cL);
                if (cG.size() > 0) {
                    String str2 = (String) cG.get(0);
                    cG.remove(0);
                    return str2;
                }
                return str;
            }
            return str;
        }
        return str;
    }

    public static void G() {
    }

    /* renamed from: case  reason: not valid java name */
    public static void m316case(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(I);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(32);
            randomAccessFile.writeInt(2048);
            randomAccessFile.writeInt(cr);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: char  reason: not valid java name */
    public static void m317char(String str) {
        ArrayList arrayList;
        int i = c.at;
        if (i == 1) {
            arrayList = cN;
        } else if (i == 2) {
            arrayList = cx;
        } else if (i != 3) {
            return;
        } else {
            arrayList = cG;
        }
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() <= cg) {
            arrayList.add(str);
        }
        if (arrayList.size() >= cg) {
            m327if(i, false);
        }
        while (arrayList.size() > cg) {
            arrayList.remove(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* renamed from: do  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m318do(u.a aVar, au.b bVar, Location location, String str) {
        String str2;
        String m270if;
        BDLocation m76case;
        if (!aa.go) {
            return;
        }
        if (!aa.gw) {
            int i = aVar.f107byte;
            if (i != -1 && i != 460) {
                return;
            }
            if (i == -1 && aa.gs) {
                return;
            }
        }
        if (c.aN == 3 && !m332if(location, bVar) && !m333if(location, false)) {
            return;
        }
        if (Math.random() < 0.1d) {
            if (a1.ct().m76case(true).getLocType() == 66) {
                str2 = str + String.format(Locale.CHINA, "&ofrt=%f|%f|%d", Double.valueOf(m76case.getLongitude()), Double.valueOf(m76case.getLatitude()), Integer.valueOf((int) m76case.getRadius()));
                if (aVar == null && aVar.m356if()) {
                    if (!m332if(location, bVar)) {
                        bVar = null;
                    }
                    String m270if2 = c.m270if(aVar, bVar, location, str2, 1);
                    if (m270if2 != null) {
                        m320goto(Jni.j(m270if2));
                        cF = location;
                        cs = location;
                        if (bVar != null) {
                            cu = bVar;
                            return;
                        }
                        return;
                    }
                    return;
                } else if (bVar == null && bVar.m223if() && m332if(location, bVar)) {
                    if (!m331if(location) && !aVar.toString().contains("&cfr")) {
                        str2 = "&cfr=1" + str2;
                    }
                    String m270if3 = c.m270if(aVar, bVar, location, str2, 2);
                    if (m270if3 != null) {
                        m319else(Jni.j(m270if3));
                        cb = location;
                        cs = location;
                        if (bVar != null) {
                            cu = bVar;
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    if (!m331if(location) && !aVar.toString().contains("&cfr")) {
                        str2 = "&cfr=1" + str2;
                    }
                    if (!m332if(location, bVar)) {
                        bVar = null;
                    }
                    if ((aVar == null || bVar != null) && (m270if = c.m270if(aVar, bVar, location, str2, 3)) != null) {
                        m335void(Jni.j(m270if));
                        cs = location;
                        if (bVar == null) {
                            cu = bVar;
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        str2 = str;
        if (aVar == null) {
        }
        if (bVar == null) {
        }
        if (!m331if(location)) {
            str2 = "&cfr=1" + str2;
        }
        if (!m332if(location, bVar)) {
        }
        if (aVar == null) {
        }
        m335void(Jni.j(m270if));
        cs = location;
        if (bVar == null) {
        }
    }

    /* renamed from: else  reason: not valid java name */
    private static void m319else(String str) {
        m317char(str);
    }

    /* renamed from: goto  reason: not valid java name */
    private static void m320goto(String str) {
        m317char(str);
    }

    /* renamed from: if  reason: not valid java name */
    private static int m321if(List list, int i) {
        if (list == null || i > 256 || i < 0) {
            return -1;
        }
        try {
            if (ck == null) {
                ck = new File(cP);
                if (!ck.exists()) {
                    ck = null;
                    return -2;
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(ck, "rw");
            if (randomAccessFile.length() < 1) {
                randomAccessFile.close();
                return -3;
            }
            randomAccessFile.seek(i);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            int readInt4 = randomAccessFile.readInt();
            long readLong = randomAccessFile.readLong();
            if (!m330if(readInt, readInt2, readInt3, readInt4, readLong) || readInt2 < 1) {
                randomAccessFile.close();
                return -4;
            }
            byte[] bArr = new byte[cD];
            int i2 = readInt2;
            int i3 = ch;
            while (i3 > 0 && i2 > 0) {
                randomAccessFile.seek(((((readInt + i2) - 1) % readInt3) * readInt4) + readLong);
                int readInt5 = randomAccessFile.readInt();
                if (readInt5 > 0 && readInt5 < readInt4) {
                    randomAccessFile.read(bArr, 0, readInt5);
                    if (bArr[readInt5 - 1] == 0) {
                        list.add(new String(bArr, 0, readInt5 - 1));
                    }
                }
                i3--;
                i2--;
            }
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(readInt);
            randomAccessFile.writeInt(i2);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.writeInt(readInt4);
            randomAccessFile.writeLong(readLong);
            randomAccessFile.close();
            return ch - i3;
        } catch (Exception e) {
            e.printStackTrace();
            return -5;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static String m322if(int i) {
        String str;
        ArrayList arrayList;
        String str2 = null;
        if (i == 1) {
            str = cK;
            arrayList = cN;
        } else if (i == 2) {
            str = cJ;
            arrayList = cx;
        } else if (i != 3) {
            if (i == 4) {
                str = cE;
                arrayList = cG;
            }
            return str2;
        } else {
            str = cy;
            arrayList = cG;
        }
        if (arrayList != null) {
            if (arrayList.size() < 1) {
                m334if(str, arrayList);
            }
            synchronized (q.class) {
                int size = arrayList.size();
                if (size > 0) {
                    str2 = (String) arrayList.get(size - 1);
                    arrayList.remove(size - 1);
                }
            }
        }
        return str2;
    }

    /* renamed from: if  reason: not valid java name */
    public static String m323if(u.a aVar, au.b bVar, Location location, String str, String str2) {
        if (aa.go) {
            if (!aa.gw) {
                int i = u.au().at().f107byte;
                if (i != -1 && i != 460) {
                    return null;
                }
                if (i == -1 && aa.gs) {
                    return null;
                }
            }
            return c.m269if(aVar, bVar, location, str) + str2;
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m324if(double d, double d2, double d3, double d4) {
        if (d <= 0.0d) {
            d = cf;
        }
        cf = d;
        cC = d2;
        if (d3 <= 20.0d) {
            d3 = cn;
        }
        cn = d3;
        ce = d4;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m325if(int i, int i2) {
    }

    /* renamed from: if  reason: not valid java name */
    public static void m326if(int i, int i2, boolean z) {
    }

    /* renamed from: if  reason: not valid java name */
    public static void m327if(int i, boolean z) {
        String str;
        ArrayList arrayList;
        int i2;
        boolean z2;
        int i3;
        int i4;
        if (i == 1) {
            String str2 = cK;
            if (z) {
                return;
            }
            str = str2;
            arrayList = cN;
        } else if (i == 2) {
            String str3 = cJ;
            if (z) {
                str = str3;
                arrayList = cN;
            } else {
                str = str3;
                arrayList = cx;
            }
        } else if (i == 3) {
            String str4 = cy;
            if (z) {
                str = str4;
                arrayList = cx;
            } else {
                str = str4;
                arrayList = cG;
            }
        } else if (i != 4) {
            return;
        } else {
            String str5 = cE;
            if (!z) {
                return;
            }
            str = str5;
            arrayList = cG;
        }
        File file = new File(str);
        if (!file.exists()) {
            m316case(str);
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            int readInt4 = randomAccessFile.readInt();
            int readInt5 = randomAccessFile.readInt();
            int size = arrayList.size();
            while (true) {
                i2 = readInt5;
                if (size <= co) {
                    z2 = false;
                    break;
                }
                readInt5 = z ? i2 + 1 : i2;
                if (readInt3 >= readInt) {
                    if (!z) {
                        z2 = true;
                        i2 = readInt5;
                        break;
                    }
                    randomAccessFile.seek((readInt4 * readInt2) + 128);
                    byte[] bytes = (((String) arrayList.get(0)) + (char) 0).getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes, 0, bytes.length);
                    arrayList.remove(0);
                    i3 = readInt4 + 1;
                    if (i3 > readInt3) {
                        i3 = 0;
                    }
                    i4 = readInt3;
                } else {
                    randomAccessFile.seek((readInt2 * readInt3) + 128);
                    byte[] bytes2 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                    randomAccessFile.writeInt(bytes2.length);
                    randomAccessFile.write(bytes2, 0, bytes2.length);
                    arrayList.remove(0);
                    int i5 = readInt4;
                    i4 = readInt3 + 1;
                    i3 = i5;
                }
                size--;
                readInt3 = i4;
                readInt4 = i3;
            }
            randomAccessFile.seek(12L);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.writeInt(readInt4);
            randomAccessFile.writeInt(i2);
            randomAccessFile.close();
            if (!z2 || i >= 4) {
                return;
            }
            m327if(i + 1, true);
        } catch (Exception e) {
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static void m328if(String str, int i) {
    }

    /* renamed from: if  reason: not valid java name */
    public static void m329if(String str, int i, boolean z) {
    }

    /* renamed from: if  reason: not valid java name */
    private static boolean m330if(int i, int i2, int i3, int i4, long j) {
        return i >= 0 && i < i3 && i2 >= 0 && i2 <= i3 && i3 >= 0 && i3 <= 1024 && i4 >= 128 && i4 <= 1024;
    }

    /* renamed from: if  reason: not valid java name */
    private static boolean m331if(Location location) {
        if (location == null) {
            return false;
        }
        if (cF == null || cs == null) {
            cF = location;
            return true;
        }
        double distanceTo = location.distanceTo(cF);
        return ((double) location.distanceTo(cs)) > ((distanceTo * ((double) c.aA)) + ((((double) c.aB) * distanceTo) * distanceTo)) + ((double) c.az);
    }

    /* renamed from: if  reason: not valid java name */
    private static boolean m332if(Location location, au.b bVar) {
        if (location == null || bVar == null || bVar.f74for == null || bVar.f74for.isEmpty() || bVar.m219do(cu)) {
            return false;
        }
        if (cb == null) {
            cb = location;
            return true;
        }
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m333if(Location location, boolean z) {
        return z.m399if(cs, location, z);
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m334if(String str, List list) {
        File file = new File(str);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(8L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                byte[] bArr = new byte[cD];
                int i = readInt2;
                int i2 = co + 1;
                boolean z = false;
                while (i2 > 0 && i > 0) {
                    if (i < readInt3) {
                        readInt3 = 0;
                    }
                    try {
                        randomAccessFile.seek(((i - 1) * readInt) + 128);
                        int readInt4 = randomAccessFile.readInt();
                        if (readInt4 > 0 && readInt4 < readInt) {
                            randomAccessFile.read(bArr, 0, readInt4);
                            if (bArr[readInt4 - 1] == 0) {
                                list.add(0, new String(bArr, 0, readInt4 - 1));
                                z = true;
                            }
                        }
                        i2--;
                        i--;
                    } catch (Exception e) {
                        return z;
                    }
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeInt(i);
                randomAccessFile.writeInt(readInt3);
                randomAccessFile.close();
                return z;
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: void  reason: not valid java name */
    private static void m335void(String str) {
        m317char(str);
    }

    public static void x() {
        co = 0;
        m327if(1, false);
        m327if(2, false);
        m327if(3, false);
        co = 8;
    }

    public static q y() {
        if (cO == null) {
            cO = new q();
        }
        return cO;
    }

    public static String z() {
        String str = null;
        File file = new File(cJ);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20L);
                int readInt = randomAccessFile.readInt();
                if (readInt > 128) {
                    String str2 = "&p1=" + readInt;
                    randomAccessFile.seek(20L);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.close();
                    return str2;
                }
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
        File file2 = new File(cy);
        if (file2.exists()) {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                randomAccessFile2.seek(20L);
                int readInt2 = randomAccessFile2.readInt();
                if (readInt2 > 256) {
                    String str3 = "&p2=" + readInt2;
                    randomAccessFile2.seek(20L);
                    randomAccessFile2.writeInt(0);
                    randomAccessFile2.close();
                    return str3;
                }
                randomAccessFile2.close();
            } catch (Exception e2) {
            }
        }
        File file3 = new File(cE);
        if (file3.exists()) {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, "rw");
                randomAccessFile3.seek(20L);
                int readInt3 = randomAccessFile3.readInt();
                if (readInt3 > 512) {
                    str = "&p3=" + readInt3;
                    randomAccessFile3.seek(20L);
                    randomAccessFile3.writeInt(0);
                    randomAccessFile3.close();
                } else {
                    randomAccessFile3.close();
                }
                return str;
            } catch (Exception e3) {
                return str;
            }
        }
        return null;
    }

    public void A() {
        if (!az.m252do().m255int() || this.cH == 0 || System.currentTimeMillis() - this.cH <= 1200000) {
            return;
        }
        B();
    }

    public void B() {
        this.cH = System.currentTimeMillis();
        if (o.ah().ag()) {
            return;
        }
        this.cp++;
        if (this.cp > 1) {
            this.cp = 0;
            F();
        }
    }

    public void F() {
        if (au.ca()) {
            this.cA.ak();
        }
    }

    /* renamed from: long  reason: not valid java name */
    public void m336long(String str) {
        new a(str).aj();
    }
}
