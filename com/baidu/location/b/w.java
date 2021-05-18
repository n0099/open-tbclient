package com.baidu.location.b;

import android.location.Location;
import android.net.wifi.ScanResult;
import com.baidu.location.Jni;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class w {
    public int B;

    /* renamed from: a  reason: collision with root package name */
    public long f6685a = 0;
    public a z;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<String> f6677b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<String> f6678c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<String> f6679d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public static String f6680e = com.baidu.location.e.j.f6817a + "/yo.dat";

    /* renamed from: f  reason: collision with root package name */
    public static String f6681f = com.baidu.location.e.j.f6817a + "/yoh.dat";

    /* renamed from: g  reason: collision with root package name */
    public static String f6682g = com.baidu.location.e.j.f6817a + "/yom.dat";

    /* renamed from: h  reason: collision with root package name */
    public static String f6683h = com.baidu.location.e.j.f6817a + "/yol.dat";

    /* renamed from: i  reason: collision with root package name */
    public static String f6684i = com.baidu.location.e.j.f6817a + "/yor.dat";
    public static File j = null;
    public static int k = 8;
    public static int l = 8;
    public static int m = 16;
    public static int n = 1024;
    public static double o = 0.0d;
    public static double p = 0.1d;
    public static double q = 30.0d;
    public static double r = 100.0d;
    public static int s = 0;
    public static int t = 64;
    public static int u = 128;
    public static Location v = null;
    public static Location w = null;
    public static Location x = null;
    public static com.baidu.location.c.h y = null;
    public static w A = null;
    public static long C = 0;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.location.e.e {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6686a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f6687b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f6688c = 0;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f6690e = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        public boolean f6691f = true;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            Map<String, Object> map;
            StringBuilder sb;
            String str;
            this.f6807h = com.baidu.location.e.k.e();
            if (this.f6687b != 1) {
                this.f6807h = com.baidu.location.e.k.g();
            }
            this.f6808i = 2;
            if (this.f6690e != null) {
                for (int i2 = 0; i2 < this.f6690e.size(); i2++) {
                    if (this.f6687b == 1) {
                        map = this.k;
                        sb = new StringBuilder();
                        str = "cldc[";
                    } else {
                        map = this.k;
                        sb = new StringBuilder();
                        str = "cltr[";
                    }
                    sb.append(str);
                    sb.append(i2);
                    sb.append("]");
                    map.put(sb.toString(), this.f6690e.get(i2));
                }
                this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
                if (this.f6687b != 1) {
                    this.k.put("qt", "cltrg");
                }
            }
        }

        @Override // com.baidu.location.e.e
        public void a(boolean z) {
            if (z && this.j != null) {
                ArrayList<String> arrayList = this.f6690e;
                if (arrayList != null) {
                    arrayList.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.f6691f = false;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Map<String, Object> map = this.k;
            if (map != null) {
                map.clear();
            }
            this.f6686a = false;
        }

        public synchronized void b() {
            ExecutorService c2;
            String str;
            String str2;
            if (this.f6686a) {
                return;
            }
            if (com.baidu.location.e.e.p > 4 && this.f6688c < com.baidu.location.e.e.p) {
                this.f6688c++;
                return;
            }
            this.f6688c = 0;
            this.f6686a = true;
            this.f6687b = 0;
            try {
                if (this.f6690e == null || this.f6690e.size() < 1) {
                    if (this.f6690e == null) {
                        this.f6690e = new ArrayList<>();
                    }
                    this.f6687b = 0;
                    int i2 = 0;
                    while (true) {
                        String str3 = null;
                        String b2 = this.f6687b < 2 ? w.b() : null;
                        if (b2 == null && this.f6687b != 1 && this.f6691f) {
                            this.f6687b = 2;
                            try {
                                str3 = g.a();
                            } catch (Exception unused) {
                            }
                        } else {
                            this.f6687b = 1;
                            str3 = b2;
                        }
                        if (str3 == null) {
                            break;
                        } else if (!str3.contains("err!")) {
                            this.f6690e.add(str3);
                            i2 += str3.length();
                            if (i2 >= com.baidu.location.e.a.f6775i) {
                                break;
                            }
                        }
                    }
                }
                if (this.f6690e == null || this.f6690e.size() < 1) {
                    if (this.f6690e != null) {
                        this.f6690e.clear();
                    }
                    this.f6686a = false;
                    return;
                }
                if (this.f6687b != 1) {
                    c2 = v.a().c();
                    if (c2 != null) {
                        str2 = com.baidu.location.e.k.g();
                        a(c2, str2);
                    } else {
                        str = com.baidu.location.e.k.g();
                        b(str);
                    }
                } else {
                    c2 = v.a().c();
                    if (c2 != null) {
                        str2 = com.baidu.location.e.k.f6824f;
                        a(c2, str2);
                    } else {
                        str = com.baidu.location.e.k.f6824f;
                        b(str);
                    }
                }
            } catch (Exception unused2) {
                if (this.f6690e != null) {
                    this.f6690e.clear();
                }
            }
        }
    }

    public w() {
        this.z = null;
        this.B = 0;
        this.z = new a();
        this.B = 0;
    }

    public static synchronized int a(List<String> list, int i2) {
        synchronized (w.class) {
            if (list != null && i2 <= 256) {
                if (i2 >= 0) {
                    try {
                        if (j == null) {
                            File file = new File(f6680e);
                            j = file;
                            if (!file.exists()) {
                                j = null;
                                return -2;
                            }
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(j, "rw");
                        if (randomAccessFile.length() < 1) {
                            randomAccessFile.close();
                            return -3;
                        }
                        long j2 = i2;
                        randomAccessFile.seek(j2);
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        long readLong = randomAccessFile.readLong();
                        long j3 = readLong;
                        if (a(readInt, readInt2, readInt3, readInt4, readLong)) {
                            int i3 = 1;
                            if (readInt2 >= 1) {
                                byte[] bArr = new byte[n];
                                int i4 = k;
                                while (i4 > 0 && readInt2 > 0) {
                                    byte[] bArr2 = bArr;
                                    long j4 = j3;
                                    randomAccessFile.seek(((((readInt + readInt2) - i3) % readInt3) * readInt4) + j4);
                                    int readInt5 = randomAccessFile.readInt();
                                    if (readInt5 > 0 && readInt5 < readInt4) {
                                        randomAccessFile.read(bArr2, 0, readInt5);
                                        int i5 = readInt5 - 1;
                                        if (bArr2[i5] == 0) {
                                            list.add(new String(bArr2, 0, i5));
                                        }
                                    }
                                    i4--;
                                    readInt2--;
                                    j3 = j4;
                                    bArr = bArr2;
                                    i3 = 1;
                                }
                                randomAccessFile.seek(j2);
                                randomAccessFile.writeInt(readInt);
                                randomAccessFile.writeInt(readInt2);
                                randomAccessFile.writeInt(readInt3);
                                randomAccessFile.writeInt(readInt4);
                                randomAccessFile.writeLong(j3);
                                randomAccessFile.close();
                                return k - i4;
                            }
                        }
                        randomAccessFile.close();
                        return -4;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return -5;
                    }
                }
            }
            return -1;
        }
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

    public static String a(int i2) {
        String str;
        ArrayList<String> arrayList;
        String str2 = null;
        if (i2 == 1) {
            str = f6681f;
            arrayList = f6677b;
        } else if (i2 == 2) {
            str = f6682g;
            arrayList = f6678c;
        } else {
            if (i2 == 3) {
                str = f6683h;
            } else if (i2 != 4) {
                return null;
            } else {
                str = f6684i;
            }
            arrayList = f6679d;
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
                int i3 = size - 1;
                try {
                    String str3 = arrayList.get(i3);
                    try {
                        arrayList.remove(i3);
                    } catch (Exception unused) {
                    }
                    str2 = str3;
                } catch (Exception unused2) {
                }
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
        if (r15 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001c, code lost:
        if (r15 != false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce A[EDGE_INSN: B:51:0x00ce->B:42:0x00ce ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i2, boolean z) {
        String str;
        ArrayList<String> arrayList;
        File file;
        int size;
        int i3;
        try {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        str = f6683h;
                    } else if (i2 != 4) {
                        return;
                    } else {
                        str = f6684i;
                        if (!z) {
                            return;
                        }
                    }
                    arrayList = f6679d;
                    file = new File(str);
                    if (!file.exists()) {
                        d(str);
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(4L);
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    int readInt4 = randomAccessFile.readInt();
                    int readInt5 = randomAccessFile.readInt();
                    size = arrayList.size();
                    while (true) {
                        i3 = 0;
                        if (size <= l) {
                            break;
                        }
                        if (z) {
                            readInt5++;
                        }
                        if (readInt3 >= readInt) {
                            if (!z) {
                                i3 = 1;
                                break;
                            }
                            randomAccessFile.seek((readInt4 * readInt2) + 128);
                            byte[] bytes = (arrayList.get(0) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes.length);
                            randomAccessFile.write(bytes, 0, bytes.length);
                            arrayList.remove(0);
                            int i4 = readInt4 + 1;
                            if (i4 <= readInt3) {
                                i3 = i4;
                            }
                            readInt4 = i3;
                        } else {
                            randomAccessFile.seek((readInt2 * readInt3) + 128);
                            byte[] bytes2 = (arrayList.get(0) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes2.length);
                            randomAccessFile.write(bytes2, 0, bytes2.length);
                            arrayList.remove(0);
                            readInt3++;
                        }
                        size--;
                    }
                    randomAccessFile.seek(12L);
                    randomAccessFile.writeInt(readInt3);
                    randomAccessFile.writeInt(readInt4);
                    randomAccessFile.writeInt(readInt5);
                    randomAccessFile.close();
                    if (i3 == 0 || i2 >= 4) {
                        return;
                    }
                    a(i2 + 1, true);
                    return;
                }
                str = f6682g;
                arrayList = f6678c;
                file = new File(str);
                if (!file.exists()) {
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                randomAccessFile2.seek(4L);
                int readInt6 = randomAccessFile2.readInt();
                int readInt22 = randomAccessFile2.readInt();
                int readInt32 = randomAccessFile2.readInt();
                int readInt42 = randomAccessFile2.readInt();
                int readInt52 = randomAccessFile2.readInt();
                size = arrayList.size();
                while (true) {
                    i3 = 0;
                    if (size <= l) {
                    }
                    size--;
                }
                randomAccessFile2.seek(12L);
                randomAccessFile2.writeInt(readInt32);
                randomAccessFile2.writeInt(readInt42);
                randomAccessFile2.writeInt(readInt52);
                randomAccessFile2.close();
                if (i3 == 0) {
                    return;
                }
                return;
            }
            str = f6681f;
            if (z) {
                return;
            }
            RandomAccessFile randomAccessFile22 = new RandomAccessFile(file, "rw");
            randomAccessFile22.seek(4L);
            int readInt62 = randomAccessFile22.readInt();
            int readInt222 = randomAccessFile22.readInt();
            int readInt322 = randomAccessFile22.readInt();
            int readInt422 = randomAccessFile22.readInt();
            int readInt522 = randomAccessFile22.readInt();
            size = arrayList.size();
            while (true) {
                i3 = 0;
                if (size <= l) {
                }
                size--;
            }
            randomAccessFile22.seek(12L);
            randomAccessFile22.writeInt(readInt322);
            randomAccessFile22.writeInt(readInt422);
            randomAccessFile22.writeInt(readInt522);
            randomAccessFile22.close();
            if (i3 == 0) {
            }
        } catch (Exception unused) {
            return;
        }
        arrayList = f6677b;
        file = new File(str);
        if (!file.exists()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.baidu.location.c.a aVar, com.baidu.location.c.h hVar, Location location, String str) {
        StringBuilder sb;
        String a2;
        StringBuilder sb2;
        String a3;
        if ((com.baidu.location.e.k.v == 3 && !a(location, hVar) && !a(location, false)) || aVar == null || aVar.c()) {
            return;
        }
        if (aVar != null && aVar.a()) {
            if (!a(location, hVar)) {
                hVar = null;
            }
            String a4 = com.baidu.location.e.k.a(aVar, hVar, location, str, 1);
            if (a4 != null) {
                a(Jni.encode(a4));
                w = location;
                v = location;
                if (hVar != null) {
                    y = hVar;
                }
            }
        } else if (hVar != null && hVar.l() && a(location, hVar)) {
            if (!a(location) && !com.baidu.location.c.b.a().d()) {
                sb2 = new StringBuilder();
                sb2.append("&cfr=1");
            } else if (a(location) || !com.baidu.location.c.b.a().d()) {
                if (com.baidu.location.c.b.a().d()) {
                    sb2 = new StringBuilder();
                    sb2.append("&cfr=2");
                }
                a3 = com.baidu.location.e.k.a(aVar, hVar, location, str, 2);
                if (a3 == null) {
                    b(Jni.encode(a3));
                    x = location;
                    v = location;
                    if (hVar != null) {
                        y = hVar;
                        return;
                    }
                    return;
                }
                return;
            } else {
                sb2 = new StringBuilder();
                sb2.append("&cfr=3");
            }
            sb2.append(str);
            str = sb2.toString();
            a3 = com.baidu.location.e.k.a(aVar, hVar, location, str, 2);
            if (a3 == null) {
            }
        } else {
            if (a(location) || com.baidu.location.c.b.a().d()) {
                if (!a(location) && com.baidu.location.c.b.a().d()) {
                    str = "&cfr=3" + str;
                } else if (com.baidu.location.c.b.a().d()) {
                    sb = new StringBuilder();
                    sb.append("&cfr=2");
                }
                if (!a(location, hVar)) {
                    hVar = null;
                }
                if ((aVar == null || hVar != null) && (a2 = com.baidu.location.e.k.a(aVar, hVar, location, str, 3)) != null) {
                    c(Jni.encode(a2));
                    v = location;
                    if (hVar == null) {
                        y = hVar;
                        return;
                    }
                    return;
                }
                return;
            }
            sb = new StringBuilder();
            sb.append("&cfr=1");
            sb.append(str);
            str = sb.toString();
            if (!a(location, hVar)) {
            }
            if (aVar == null) {
            }
            c(Jni.encode(a2));
            v = location;
            if (hVar == null) {
            }
        }
    }

    public static void a(String str) {
        e(str);
    }

    public static boolean a(int i2, int i3, int i4, int i5, long j2) {
        return i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024;
    }

    public static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        Location location2 = w;
        if (location2 == null || v == null) {
            w = location;
            return true;
        }
        double distanceTo = location.distanceTo(location2);
        return ((double) location.distanceTo(v)) > (((((double) com.baidu.location.e.k.T) * distanceTo) * distanceTo) + (((double) com.baidu.location.e.k.U) * distanceTo)) + ((double) com.baidu.location.e.k.V);
    }

    public static boolean a(Location location, com.baidu.location.c.h hVar) {
        List<ScanResult> list;
        boolean z = false;
        if (location != null && hVar != null && (list = hVar.f6737a) != null && !list.isEmpty()) {
            if (hVar.b(y)) {
                return false;
            }
            z = true;
            if (x == null) {
                x = location;
            }
        }
        return z;
    }

    public static boolean a(Location location, boolean z) {
        return com.baidu.location.c.e.a(v, location, z);
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
                            int i3 = readInt4 - 1;
                            if (bArr[i3] == 0) {
                                list.add(0, new String(bArr, 0, i3));
                                z = true;
                            }
                        }
                        i2--;
                        readInt2--;
                    } catch (Exception unused) {
                        return z;
                    }
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeInt(readInt2);
                randomAccessFile.writeInt(readInt3);
                randomAccessFile.close();
                return z;
            } catch (Exception unused2) {
                return false;
            }
        }
        return false;
    }

    public static String b() {
        return f();
    }

    public static void b(String str) {
        e(str);
    }

    public static void c(String str) {
        e(str);
    }

    public static void d() {
        l = 0;
        a(1, false);
        a(2, false);
        a(3, false);
        l = 8;
    }

    public static void d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(com.baidu.location.e.j.f6817a);
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
        } catch (Exception unused) {
        }
    }

    public static String e() {
        File file = new File(f6682g);
        String str = null;
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20L);
                int readInt = randomAccessFile.readInt();
                if (readInt > 128) {
                    String str2 = "&p1=" + readInt;
                    try {
                        randomAccessFile.seek(20L);
                        randomAccessFile.writeInt(0);
                        randomAccessFile.close();
                        return str2;
                    } catch (Exception unused) {
                        str = str2;
                    }
                } else {
                    randomAccessFile.close();
                }
            } catch (Exception unused2) {
            }
        }
        File file2 = new File(f6683h);
        if (file2.exists()) {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                randomAccessFile2.seek(20L);
                int readInt2 = randomAccessFile2.readInt();
                if (readInt2 > 256) {
                    String str3 = "&p2=" + readInt2;
                    try {
                        randomAccessFile2.seek(20L);
                        randomAccessFile2.writeInt(0);
                        randomAccessFile2.close();
                        return str3;
                    } catch (Exception unused3) {
                        str = str3;
                    }
                } else {
                    randomAccessFile2.close();
                }
            } catch (Exception unused4) {
            }
        }
        File file3 = new File(f6684i);
        if (file3.exists()) {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, "rw");
                randomAccessFile3.seek(20L);
                int readInt3 = randomAccessFile3.readInt();
                if (readInt3 > 512) {
                    String str4 = "&p3=" + readInt3;
                    try {
                        randomAccessFile3.seek(20L);
                        randomAccessFile3.writeInt(0);
                        randomAccessFile3.close();
                        return str4;
                    } catch (Exception unused5) {
                        str = str4;
                    }
                } else {
                    randomAccessFile3.close();
                }
            } catch (Exception unused6) {
            }
        }
        return str;
    }

    public static synchronized void e(String str) {
        ArrayList<String> arrayList;
        synchronized (w.class) {
            if (str.contains("err!")) {
                return;
            }
            int i2 = com.baidu.location.e.k.q;
            if (i2 == 1) {
                arrayList = f6677b;
            } else if (i2 == 2) {
                arrayList = f6678c;
            } else if (i2 != 3) {
                return;
            } else {
                arrayList = f6679d;
            }
            if (arrayList == null) {
                return;
            }
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

    public static String f() {
        String str = null;
        for (int i2 = 1; i2 < 5; i2++) {
            str = a(i2);
            if (str != null) {
                return str;
            }
        }
        a(f6679d, t);
        if (f6679d.size() > 0) {
            str = f6679d.get(0);
            f6679d.remove(0);
        }
        if (str != null) {
            return str;
        }
        a(f6679d, s);
        if (f6679d.size() > 0) {
            str = f6679d.get(0);
            f6679d.remove(0);
        }
        if (str != null) {
            return str;
        }
        a(f6679d, u);
        if (f6679d.size() > 0) {
            String str2 = f6679d.get(0);
            f6679d.remove(0);
            return str2;
        }
        return str;
    }

    public void c() {
        if (com.baidu.location.c.i.i() && !com.baidu.location.e.k.b()) {
            this.z.b();
        }
    }
}
