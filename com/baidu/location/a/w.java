package com.baidu.location.a;

import android.location.Location;
import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.location.Jni;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class w {
    private int B;

    /* renamed from: a  reason: collision with root package name */
    long f2586a = 0;
    private a z;

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<String> f2585b = new ArrayList<>();
    private static ArrayList<String> c = new ArrayList<>();
    private static ArrayList<String> d = new ArrayList<>();
    private static String e = com.baidu.location.d.i.f2640a + "/yo.dat";
    private static final String f = com.baidu.location.d.i.f2640a + "/yoh.dat";
    private static final String g = com.baidu.location.d.i.f2640a + "/yom.dat";
    private static final String h = com.baidu.location.d.i.f2640a + "/yol.dat";
    private static final String i = com.baidu.location.d.i.f2640a + "/yor.dat";
    private static File j = null;
    private static int k = 8;
    private static int l = 8;
    private static int m = 16;
    private static int n = 1024;
    private static double o = 0.0d;
    private static double p = 0.1d;
    private static double q = 30.0d;
    private static double r = 100.0d;
    private static int s = 0;
    private static int t = 64;
    private static int u = 128;
    private static Location v = null;
    private static Location w = null;
    private static Location x = null;
    private static com.baidu.location.b.h y = null;
    private static w A = null;
    private static long C = 0;

    /* loaded from: classes4.dex */
    private class a extends com.baidu.location.d.e {

        /* renamed from: a  reason: collision with root package name */
        boolean f2587a = false;

        /* renamed from: b  reason: collision with root package name */
        int f2588b = 0;
        int c = 0;
        private ArrayList<String> e = new ArrayList<>();
        private boolean f = true;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.h = com.baidu.location.d.j.c();
            if (this.f2588b != 1) {
                this.h = com.baidu.location.d.j.e();
            }
            this.i = 2;
            if (this.e != null) {
                for (int i = 0; i < this.e.size(); i++) {
                    if (this.f2588b == 1) {
                        this.k.put("cldc[" + i + "]", this.e.get(i));
                    } else {
                        this.k.put("cltr[" + i + "]", this.e.get(i));
                    }
                }
                this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
                if (this.f2588b != 1) {
                    this.k.put("qt", "cltrg");
                }
            }
        }

        @Override // com.baidu.location.d.e
        public void a(boolean z) {
            if (z && this.j != null) {
                if (this.e != null) {
                    this.e.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.f2587a = false;
        }

        public synchronized void b() {
            int i = 0;
            synchronized (this) {
                if (!this.f2587a) {
                    if (p <= 4 || this.c >= p) {
                        this.c = 0;
                        this.f2587a = true;
                        this.f2588b = 0;
                        try {
                            if (this.e == null || this.e.size() < 1) {
                                if (this.e == null) {
                                    this.e = new ArrayList<>();
                                }
                                this.f2588b = 0;
                                while (true) {
                                    String b2 = this.f2588b < 2 ? w.b() : null;
                                    if (b2 == null && this.f2588b != 1 && this.f) {
                                        this.f2588b = 2;
                                        try {
                                            b2 = g.a();
                                        } catch (Exception e) {
                                            b2 = null;
                                        }
                                    } else {
                                        this.f2588b = 1;
                                    }
                                    if (b2 == null) {
                                        break;
                                    } else if (!b2.contains("err!")) {
                                        this.e.add(b2);
                                        i += b2.length();
                                        if (i >= com.baidu.location.d.a.i) {
                                            break;
                                        }
                                    }
                                }
                            }
                            if (this.e == null || this.e.size() < 1) {
                                if (this.e != null) {
                                    this.e.clear();
                                }
                                this.f2587a = false;
                            } else if (this.f2588b != 1) {
                                b(com.baidu.location.d.j.e());
                            } else {
                                b(com.baidu.location.d.j.f);
                            }
                        } catch (Exception e2) {
                            if (this.e != null) {
                                this.e.clear();
                            }
                        }
                    } else {
                        this.c++;
                    }
                }
            }
        }
    }

    private w() {
        this.z = null;
        this.B = 0;
        this.z = new a();
        this.B = 0;
    }

    private static synchronized int a(List<String> list, int i2) {
        int i3;
        synchronized (w.class) {
            if (list != null && i2 <= 256) {
                if (i2 >= 0) {
                    try {
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i3 = -5;
                    }
                    if (j == null) {
                        j = new File(e);
                        if (!j.exists()) {
                            j = null;
                            i3 = -2;
                        }
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(j, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
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
                            int i4 = k;
                            int i5 = readInt2;
                            while (i4 > 0 && i5 > 0) {
                                randomAccessFile.seek(((((readInt + i5) - 1) % readInt3) * readInt4) + readLong);
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
                            randomAccessFile.writeInt(i5);
                            randomAccessFile.writeInt(readInt3);
                            randomAccessFile.writeInt(readInt4);
                            randomAccessFile.writeLong(readLong);
                            randomAccessFile.close();
                            i3 = k - i4;
                        }
                    }
                }
            }
            i3 = -1;
        }
        return i3;
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (A == null) {
                A = new w();
            }
            wVar = A;
        }
        return wVar;
    }

    private static String a(int i2) {
        String str;
        ArrayList<String> arrayList;
        String str2;
        String str3 = null;
        if (i2 == 1) {
            str = f;
            arrayList = f2585b;
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
        synchronized (w.class) {
            int size = arrayList.size();
            if (size > 0) {
                try {
                    str2 = arrayList.get(size - 1);
                } catch (Exception e2) {
                }
                try {
                    arrayList.remove(size - 1);
                } catch (Exception e3) {
                    str3 = str2;
                    str2 = str3;
                    return str2;
                }
            } else {
                str2 = null;
            }
        }
        return str2;
    }

    private static void a(int i2, boolean z) {
        String str;
        ArrayList<String> arrayList;
        int i3;
        boolean z2;
        int i4;
        if (i2 == 1) {
            str = f;
            if (z) {
                return;
            }
            arrayList = f2585b;
        } else if (i2 == 2) {
            str = g;
            arrayList = z ? f2585b : c;
        } else if (i2 == 3) {
            str = h;
            arrayList = z ? c : d;
        } else if (i2 != 4) {
            return;
        } else {
            str = i;
            if (!z) {
                return;
            }
            arrayList = d;
        }
        File file = new File(str);
        if (!file.exists()) {
            d(str);
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            randomAccessFile.seek(4L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            int readInt4 = randomAccessFile.readInt();
            int readInt5 = randomAccessFile.readInt();
            int size = arrayList.size();
            while (true) {
                if (size <= l) {
                    i3 = readInt5;
                    z2 = false;
                    break;
                }
                if (z) {
                    readInt5++;
                }
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
                } else {
                    randomAccessFile.seek((readInt2 * readInt3) + 128);
                    byte[] bytes2 = (arrayList.get(0) + (char) 0).getBytes();
                    randomAccessFile.writeInt(bytes2.length);
                    randomAccessFile.write(bytes2, 0, bytes2.length);
                    arrayList.remove(0);
                    readInt3++;
                    i4 = readInt4;
                }
                size--;
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

    public static void a(com.baidu.location.b.a aVar, com.baidu.location.b.h hVar, Location location, String str) {
        String a2;
        if ((com.baidu.location.d.j.v == 3 && !a(location, hVar) && !a(location, false)) || aVar == null || aVar.c()) {
            return;
        }
        if (aVar != null && aVar.a()) {
            if (!a(location, hVar)) {
                hVar = null;
            }
            String a3 = com.baidu.location.d.j.a(aVar, hVar, location, str, 1);
            if (a3 != null) {
                a(Jni.encode(a3));
                w = location;
                v = location;
                if (hVar != null) {
                    y = hVar;
                }
            }
        } else if (hVar != null && hVar.k() && a(location, hVar)) {
            if (!a(location) && !com.baidu.location.b.b.a().d()) {
                str = "&cfr=1" + str;
            } else if (!a(location) && com.baidu.location.b.b.a().d()) {
                str = "&cfr=3" + str;
            } else if (com.baidu.location.b.b.a().d()) {
                str = "&cfr=2" + str;
            }
            String a4 = com.baidu.location.d.j.a(aVar, hVar, location, str, 2);
            if (a4 != null) {
                b(Jni.encode(a4));
                x = location;
                v = location;
                if (hVar != null) {
                    y = hVar;
                }
            }
        } else {
            if (!a(location) && !com.baidu.location.b.b.a().d()) {
                str = "&cfr=1" + str;
            } else if (!a(location) && com.baidu.location.b.b.a().d()) {
                str = "&cfr=3" + str;
            } else if (com.baidu.location.b.b.a().d()) {
                str = "&cfr=2" + str;
            }
            com.baidu.location.b.h hVar2 = a(location, hVar) ? hVar : null;
            if ((aVar == null && hVar2 == null) || (a2 = com.baidu.location.d.j.a(aVar, hVar2, location, str, 3)) == null) {
                return;
            }
            c(Jni.encode(a2));
            v = location;
            if (hVar2 != null) {
                y = hVar2;
            }
        }
    }

    private static void a(String str) {
        e(str);
    }

    private static boolean a(int i2, int i3, int i4, int i5, long j2) {
        return i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024;
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        if (w == null || v == null) {
            w = location;
            return true;
        }
        double distanceTo = location.distanceTo(w);
        return ((double) location.distanceTo(v)) > ((distanceTo * ((double) com.baidu.location.d.j.T)) + ((((double) com.baidu.location.d.j.S) * distanceTo) * distanceTo)) + ((double) com.baidu.location.d.j.U);
    }

    private static boolean a(Location location, com.baidu.location.b.h hVar) {
        if (location == null || hVar == null || hVar.f2610a == null || hVar.f2610a.isEmpty() || hVar.b(y)) {
            return false;
        }
        if (x == null) {
            x = location;
            return true;
        }
        return true;
    }

    public static boolean a(Location location, boolean z) {
        return com.baidu.location.b.e.a(v, location, z);
    }

    private static boolean a(String str, List<String> list) {
        File file = new File(str);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                randomAccessFile.seek(8L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                byte[] bArr = new byte[n];
                int i2 = l + 1;
                boolean z = false;
                while (i2 > 0 && readInt2 > 0) {
                    if (readInt2 < readInt3) {
                        readInt3 = 0;
                    }
                    try {
                        randomAccessFile.seek(((readInt2 - 1) * readInt) + 128);
                        int readInt4 = randomAccessFile.readInt();
                        if (readInt4 > 0 && readInt4 < readInt) {
                            randomAccessFile.read(bArr, 0, readInt4);
                            if (bArr[readInt4 - 1] == 0) {
                                list.add(0, new String(bArr, 0, readInt4 - 1));
                                z = true;
                            }
                        }
                        i2--;
                        readInt2--;
                    } catch (Exception e2) {
                        return z;
                    }
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeInt(readInt2);
                randomAccessFile.writeInt(readInt3);
                randomAccessFile.close();
                return z;
            } catch (Exception e3) {
                return false;
            }
        }
        return false;
    }

    public static String b() {
        return f();
    }

    private static void b(String str) {
        e(str);
    }

    private static void c(String str) {
        e(str);
    }

    public static void d() {
        l = 0;
        a(1, false);
        a(2, false);
        a(3, false);
        l = 8;
    }

    private static void d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(com.baidu.location.d.i.f2640a);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(32);
            randomAccessFile.writeInt(2048);
            randomAccessFile.writeInt(AlaLiveRtcConfig.NativeErroCode.ERROR_PROTOCAL_SESSION_ID);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception e2) {
        }
    }

    public static String e() {
        String str = null;
        File file = new File(g);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
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
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
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
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
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

    private static synchronized void e(String str) {
        ArrayList<String> arrayList;
        synchronized (w.class) {
            if (!str.contains("err!")) {
                int i2 = com.baidu.location.d.j.q;
                if (i2 == 1) {
                    arrayList = f2585b;
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
    }

    private static String f() {
        String str = null;
        for (int i2 = 1; i2 < 5; i2++) {
            str = a(i2);
            if (str != null) {
                return str;
            }
        }
        a(d, t);
        if (d.size() > 0) {
            str = d.get(0);
            d.remove(0);
        }
        if (str == null) {
            a(d, s);
            if (d.size() > 0) {
                str = d.get(0);
                d.remove(0);
            }
            if (str == null) {
                a(d, u);
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

    public void c() {
        if (com.baidu.location.b.i.i()) {
            this.z.b();
        }
    }
}
