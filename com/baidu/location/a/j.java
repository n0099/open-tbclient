package com.baidu.location.a;

import android.location.Location;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.e.d;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class j {
    private int B;
    private a Wp;
    long a = 0;
    private static ArrayList<String> b = new ArrayList<>();
    private static ArrayList<String> c = new ArrayList<>();
    private static ArrayList<String> d = new ArrayList<>();
    private static String e = com.baidu.location.h.h.a + "/yo.dat";
    private static final String f = com.baidu.location.h.h.a + "/yoh.dat";
    private static final String g = com.baidu.location.h.h.a + "/yom.dat";
    private static final String h = com.baidu.location.h.h.a + "/yol.dat";
    private static final String i = com.baidu.location.h.h.a + "/yor.dat";
    private static File Wi = null;
    private static int k = 8;
    private static int l = 8;
    private static int m = 16;
    private static int n = 1024;
    private static double o = 0.0d;
    private static double p = 0.1d;
    private static double Wj = 30.0d;
    private static double Wk = 100.0d;
    private static int s = 0;
    private static int t = 64;
    private static int u = 128;
    private static Location Wl = null;
    private static Location Wm = null;
    private static Location Wn = null;
    private static com.baidu.location.f.i Wo = null;
    private static j Wq = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends com.baidu.location.h.f {
        boolean a = false;
        int b = 0;
        int c = 0;
        private ArrayList<String> e = null;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.h.f
        public void a() {
            this.h = com.baidu.location.h.i.c();
            this.i = 2;
            if (this.e != null) {
                for (int i = 0; i < this.e.size(); i++) {
                    if (this.b == 1) {
                        this.k.put("cldc[" + i + "]", this.e.get(i));
                    } else {
                        this.k.put("cltr[" + i + "]", this.e.get(i));
                    }
                }
                this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
            }
        }

        @Override // com.baidu.location.h.f
        public void a(boolean z) {
            if (z && this.j != null && this.e != null) {
                this.e.clear();
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.a = false;
        }

        public void b() {
            if (this.a) {
                return;
            }
            if (o > 4 && this.c < o) {
                this.c++;
                return;
            }
            this.c = 0;
            this.a = true;
            this.b = 0;
            if (this.e == null || this.e.size() < 1) {
                if (this.e == null) {
                    this.e = new ArrayList<>();
                }
                this.b = 0;
                int i = 0;
                do {
                    String b = this.b < 2 ? j.b() : null;
                    if (b != null || this.b == 1) {
                        this.b = 1;
                    } else {
                        this.b = 2;
                        try {
                            b = c.b();
                        } catch (Exception e) {
                            b = null;
                        }
                    }
                    if (b == null) {
                        break;
                    }
                    this.e.add(b);
                    i += b.length();
                } while (i < com.baidu.location.h.b.i);
            }
            if (this.e != null && this.e.size() >= 1) {
                e();
                return;
            }
            this.e = null;
            this.a = false;
        }
    }

    private j() {
        this.Wp = null;
        this.B = 0;
        this.Wp = new a();
        this.B = 0;
    }

    public static String a(int i2) {
        String str;
        ArrayList<String> arrayList;
        String str2;
        String str3 = null;
        if (i2 == 1) {
            str = f;
            arrayList = b;
        } else if (i2 == 2) {
            str = g;
            arrayList = c;
        } else if (i2 == 3) {
            str = h;
            arrayList = d;
        } else if (i2 != 4) {
            return null;
        } else {
            str = i;
            arrayList = d;
        }
        if (arrayList == null) {
            return null;
        }
        if (arrayList.size() < 1) {
            a(str, arrayList);
        }
        synchronized (j.class) {
            int size = arrayList.size();
            if (size > 0) {
                try {
                    str2 = arrayList.get(size - 1);
                    try {
                        arrayList.remove(size - 1);
                    } catch (Exception e2) {
                        str3 = str2;
                        str2 = str3;
                        return str2;
                    }
                } catch (Exception e3) {
                }
            } else {
                str2 = null;
            }
        }
        return str2;
    }

    public static void a(int i2, boolean z) {
        String str;
        ArrayList<String> arrayList;
        int i3;
        boolean z2;
        int i4;
        int i5;
        if (i2 == 1) {
            String str2 = f;
            if (z) {
                return;
            }
            str = str2;
            arrayList = b;
        } else if (i2 == 2) {
            String str3 = g;
            if (z) {
                str = str3;
                arrayList = b;
            } else {
                str = str3;
                arrayList = c;
            }
        } else if (i2 == 3) {
            String str4 = h;
            if (z) {
                str = str4;
                arrayList = c;
            } else {
                str = str4;
                arrayList = d;
            }
        } else if (i2 != 4) {
            return;
        } else {
            String str5 = i;
            if (!z) {
                return;
            }
            str = str5;
            arrayList = d;
        }
        File file = new File(str);
        if (!file.exists()) {
            a(str);
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
                i3 = readInt5;
                if (size <= l) {
                    z2 = false;
                    break;
                }
                readInt5 = z ? i3 + 1 : i3;
                if (readInt3 >= readInt) {
                    if (!z) {
                        z2 = true;
                        i3 = readInt5;
                        break;
                    }
                    randomAccessFile.seek((readInt4 * readInt2) + 128);
                    byte[] bytes = (arrayList.get(0) + (char) 0).getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes, 0, bytes.length);
                    arrayList.remove(0);
                    i4 = readInt4 + 1;
                    if (i4 > readInt3) {
                        i4 = 0;
                    }
                    i5 = readInt3;
                } else {
                    randomAccessFile.seek((readInt2 * readInt3) + 128);
                    byte[] bytes2 = (arrayList.get(0) + (char) 0).getBytes();
                    randomAccessFile.writeInt(bytes2.length);
                    randomAccessFile.write(bytes2, 0, bytes2.length);
                    arrayList.remove(0);
                    int i6 = readInt4;
                    i5 = readInt3 + 1;
                    i4 = i6;
                }
                size--;
                readInt3 = i5;
                readInt4 = i4;
            }
            randomAccessFile.seek(12L);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.writeInt(readInt4);
            randomAccessFile.writeInt(i3);
            randomAccessFile.close();
            if (!z2 || i2 >= 4) {
                return;
            }
            a(i2 + 1, true);
        } catch (Exception e2) {
        }
    }

    public static void a(com.baidu.location.f.a aVar, com.baidu.location.f.i iVar, Location location, String str) {
        BDLocation af;
        String str2;
        String a2;
        if (com.baidu.location.c.c.qw().a) {
            if (com.baidu.location.h.i.s != 3 || a(location, iVar) || a(location, false)) {
                if (com.baidu.location.e.a.qC().af(true).getLocType() == 66) {
                    str = str + String.format(Locale.CHINA, "&ofrt=%f|%f|%d", Double.valueOf(af.getLongitude()), Double.valueOf(af.getLatitude()), Integer.valueOf((int) af.getRadius()));
                }
                BDLocation a3 = com.baidu.location.h.i.a(com.baidu.location.f.getServiceContext()) ? com.baidu.location.e.d.qD().a(aVar, iVar, null, d.b.IS_MIX_MODE, d.a.NO_NEED_TO_LOG) : com.baidu.location.e.d.qD().a(aVar, iVar, null, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                if (a3 == null || a3.getLocType() == 67) {
                    str2 = str + String.format(Locale.CHINA, "&ofl=%s|0", "1");
                } else {
                    int i2 = 0;
                    if (a3.getNetworkLocationType().equals("cl")) {
                        i2 = 1;
                    } else if (a3.getNetworkLocationType().equals("wf")) {
                        i2 = 2;
                    }
                    str2 = str + String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", "1", Integer.valueOf(i2), Double.valueOf(a3.getLongitude()), Double.valueOf(a3.getLatitude()), Integer.valueOf((int) a3.getRadius()));
                }
                if (aVar != null && aVar.a()) {
                    if (!a(location, iVar)) {
                        iVar = null;
                    }
                    String a4 = com.baidu.location.h.i.a(aVar, iVar, location, str2, 1);
                    if (a4 != null) {
                        c(Jni.encode(a4));
                        Wm = location;
                        Wl = location;
                        if (iVar != null) {
                            Wo = iVar;
                        }
                    }
                } else if (iVar != null && iVar.h() && a(location, iVar)) {
                    if (!a(location) && !com.baidu.location.f.b.qQ().d()) {
                        str2 = "&cfr=1" + str2;
                    } else if (!a(location) && com.baidu.location.f.b.qQ().d()) {
                        str2 = "&cfr=3" + str2;
                    } else if (com.baidu.location.f.b.qQ().d()) {
                        str2 = "&cfr=2" + str2;
                    }
                    String a5 = com.baidu.location.h.i.a(aVar, iVar, location, str2, 2);
                    if (a5 != null) {
                        d(Jni.encode(a5));
                        Wn = location;
                        Wl = location;
                        if (iVar != null) {
                            Wo = iVar;
                        }
                    }
                } else {
                    if (!a(location) && !com.baidu.location.f.b.qQ().d()) {
                        str2 = "&cfr=1" + str2;
                    } else if (!a(location) && com.baidu.location.f.b.qQ().d()) {
                        str2 = "&cfr=3" + str2;
                    } else if (com.baidu.location.f.b.qQ().d()) {
                        str2 = "&cfr=2" + str2;
                    }
                    if (!a(location, iVar)) {
                        iVar = null;
                    }
                    if ((aVar == null && iVar == null) || (a2 = com.baidu.location.h.i.a(aVar, iVar, location, str2, 3)) == null) {
                        return;
                    }
                    e(Jni.encode(a2));
                    Wl = location;
                    if (iVar != null) {
                        Wo = iVar;
                    }
                }
            }
        }
    }

    public static void a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(com.baidu.location.h.h.a);
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
            randomAccessFile.writeInt(1040);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception e2) {
        }
    }

    private static boolean a(int i2, int i3, int i4, int i5, long j) {
        return i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024;
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        if (Wm == null || Wl == null) {
            Wm = location;
            return true;
        }
        double distanceTo = location.distanceTo(Wm);
        return ((double) location.distanceTo(Wl)) > ((distanceTo * ((double) com.baidu.location.h.i.YK)) + ((((double) com.baidu.location.h.i.YJ) * distanceTo) * distanceTo)) + ((double) com.baidu.location.h.i.R);
    }

    private static boolean a(Location location, com.baidu.location.f.i iVar) {
        if (location == null || iVar == null || iVar.a == null || iVar.a.isEmpty() || iVar.b(Wo)) {
            return false;
        }
        if (Wn == null) {
            Wn = location;
            return true;
        }
        return true;
    }

    public static boolean a(Location location, boolean z) {
        return com.baidu.location.f.e.a(Wl, location, z);
    }

    public static boolean a(String str, List<String> list) {
        File file = new File(str);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(8L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                byte[] bArr = new byte[n];
                int i2 = readInt2;
                int i3 = l + 1;
                boolean z = false;
                while (i3 > 0 && i2 > 0) {
                    if (i2 < readInt3) {
                        readInt3 = 0;
                    }
                    try {
                        randomAccessFile.seek(((i2 - 1) * readInt) + 128);
                        int readInt4 = randomAccessFile.readInt();
                        if (readInt4 > 0 && readInt4 < readInt) {
                            randomAccessFile.read(bArr, 0, readInt4);
                            if (bArr[readInt4 - 1] == 0) {
                                list.add(0, new String(bArr, 0, readInt4 - 1));
                                z = true;
                            }
                        }
                        i3--;
                        i2--;
                    } catch (Exception e2) {
                        return z;
                    }
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeInt(i2);
                randomAccessFile.writeInt(readInt3);
                randomAccessFile.close();
                return z;
            } catch (Exception e3) {
                return false;
            }
        }
        return false;
    }

    private static synchronized int b(List<String> list, int i2) {
        int i3;
        synchronized (j.class) {
            if (list != null && i2 <= 256) {
                if (i2 >= 0) {
                    try {
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i3 = -5;
                    }
                    if (Wi == null) {
                        Wi = new File(e);
                        if (!Wi.exists()) {
                            Wi = null;
                            i3 = -2;
                        }
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(Wi, "rw");
                    if (randomAccessFile.length() < 1) {
                        randomAccessFile.close();
                        i3 = -3;
                    } else {
                        randomAccessFile.seek(i2);
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        long readLong = randomAccessFile.readLong();
                        if (!a(readInt, readInt2, readInt3, readInt4, readLong) || readInt2 < 1) {
                            randomAccessFile.close();
                            i3 = -4;
                        } else {
                            byte[] bArr = new byte[n];
                            int i4 = readInt2;
                            int i5 = k;
                            while (i5 > 0 && i4 > 0) {
                                randomAccessFile.seek(((((readInt + i4) - 1) % readInt3) * readInt4) + readLong);
                                int readInt5 = randomAccessFile.readInt();
                                if (readInt5 > 0 && readInt5 < readInt4) {
                                    randomAccessFile.read(bArr, 0, readInt5);
                                    if (bArr[readInt5 - 1] == 0) {
                                        list.add(new String(bArr, 0, readInt5 - 1));
                                    }
                                }
                                i5--;
                                i4--;
                            }
                            randomAccessFile.seek(i2);
                            randomAccessFile.writeInt(readInt);
                            randomAccessFile.writeInt(i4);
                            randomAccessFile.writeInt(readInt3);
                            randomAccessFile.writeInt(readInt4);
                            randomAccessFile.writeLong(readLong);
                            randomAccessFile.close();
                            i3 = k - i5;
                        }
                    }
                }
            }
            i3 = -1;
        }
        return i3;
    }

    public static String b() {
        return d();
    }

    public static synchronized void b(String str) {
        ArrayList<String> arrayList;
        synchronized (j.class) {
            int i2 = com.baidu.location.h.i.n;
            if (i2 == 1) {
                arrayList = b;
            } else if (i2 == 2) {
                arrayList = c;
            } else if (i2 == 3) {
                arrayList = d;
            }
            if (arrayList != null) {
                if (arrayList.size() <= m) {
                    arrayList.add(str);
                }
                if (arrayList.size() >= m) {
                    a(i2, false);
                }
                while (arrayList.size() > m) {
                    arrayList.remove(0);
                }
            }
        }
    }

    private static void c(String str) {
        b(str);
    }

    public static String d() {
        String str = null;
        for (int i2 = 1; i2 < 5; i2++) {
            str = a(i2);
            if (str != null) {
                return str;
            }
        }
        b(d, t);
        if (d.size() > 0) {
            str = d.get(0);
            d.remove(0);
        }
        if (str == null) {
            b(d, s);
            if (d.size() > 0) {
                str = d.get(0);
                d.remove(0);
            }
            if (str == null) {
                b(d, u);
                if (d.size() > 0) {
                    String str2 = d.get(0);
                    d.remove(0);
                    return str2;
                }
                return str;
            }
            return str;
        }
        return str;
    }

    private static void d(String str) {
        b(str);
    }

    public static void e() {
        l = 0;
        a(1, false);
        a(2, false);
        a(3, false);
        l = 8;
    }

    private static void e(String str) {
        b(str);
    }

    public static String f() {
        String str = null;
        File file = new File(g);
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
            } catch (Exception e2) {
            }
        }
        File file2 = new File(h);
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
            } catch (Exception e3) {
            }
        }
        File file3 = new File(i);
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
            } catch (Exception e4) {
                return str;
            }
        }
        return null;
    }

    public static synchronized j qq() {
        j jVar;
        synchronized (j.class) {
            if (Wq == null) {
                Wq = new j();
            }
            jVar = Wq;
        }
        return jVar;
    }

    public void c() {
        if (com.baidu.location.f.k.re().g()) {
            this.Wp.b();
        }
    }
}
