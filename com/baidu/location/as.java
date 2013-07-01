package com.baidu.location;

import android.location.Location;
import cn.jingling.lib.file.ImageFile;
import com.baidu.zeus.NotificationProxy;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as {

    /* renamed from: a  reason: collision with root package name */
    private static String f466a = "baidu_location_service";
    private static ArrayList b = new ArrayList();
    private static ArrayList c = new ArrayList();
    private static ArrayList d = new ArrayList();
    private static String e = f.f470a + "/yo.dat";
    private static File f = null;
    private static int g = NotificationProxy.MAX_URL_LENGTH;
    private static int h = 512;
    private static int i = 32;
    private static int j = 5;
    private static int k = NotificationProxy.MAX_URL_LENGTH;
    private static int l = 256;
    private static double m = 0.0d;
    private static double n = 0.1d;
    private static double o = 30.0d;
    private static double p = 100.0d;
    private static int q = 0;
    private static int r = 64;
    private static int s = DERTags.TAGGED;
    private static Location t = null;
    private static Location u = null;
    private static Location v = null;
    private static aa w = null;

    private static int a(int i2, int i3, int i4, long j2) {
        if (i2 < 0 || i2 > 256 || i3 > 2048 || i4 > 1024 || j2 > ImageFile.MIN_SD_CARD_SPACE) {
            return -1;
        }
        ap.a(f466a, "upload manager start to init cache ...");
        try {
            if (f == null) {
                f = new File(e);
                if (!f.exists()) {
                    File file = new File(f.f470a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (!f.createNewFile()) {
                        ap.a(f466a, "upload manager create file error...");
                        f = null;
                        return -2;
                    }
                    ap.a(f466a, "upload manager create file success");
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
            randomAccessFile.seek(i2);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(i4);
            randomAccessFile.writeInt(i3);
            randomAccessFile.writeLong(j2);
            randomAccessFile.close();
            ap.a(f466a, "cache inited ...");
            return 0;
        } catch (Exception e2) {
            return -3;
        }
    }

    private static int a(List list, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (list == null || list.size() < 1 || i2 > 256 || i2 < 0) {
            return -1;
        }
        try {
            if (f == null) {
                f = new File(e);
                if (!f.exists()) {
                    ap.a(f466a, "upload man write file does not exist...");
                    f = null;
                    return -2;
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
            if (randomAccessFile.length() < 1) {
                randomAccessFile.close();
                return -3;
            }
            randomAccessFile.seek(i2);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            int readInt4 = randomAccessFile.readInt();
            long readLong = randomAccessFile.readLong();
            if (!a(readInt, readInt2, readInt3, readInt4, readLong)) {
                randomAccessFile.close();
                return -4;
            }
            for (int size = list.size(); size > j; size--) {
                randomAccessFile.seek(((((readInt + readInt2) + i5) % readInt3) * readInt4) + readLong);
                byte[] bytes = (((String) list.get(0)) + (char) 0).getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes, 0, bytes.length);
                list.remove(0);
                i5++;
            }
            int i6 = readInt2 + i5;
            if (i6 > readInt3) {
                i3 = (readInt + (i6 - readInt3)) % readInt3;
                i4 = readInt3;
            } else {
                i3 = readInt;
                i4 = i6;
            }
            randomAccessFile.seek(i2);
            randomAccessFile.writeInt(i3);
            randomAccessFile.writeInt(i4);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.writeInt(readInt4);
            randomAccessFile.writeLong(readLong);
            randomAccessFile.close();
            return i5;
        } catch (IOException e2) {
            return -5;
        }
    }

    public static String a() {
        String str = null;
        if (b == null || b.size() < 1) {
            b(b, q);
        }
        if (b != null && b.size() >= 1) {
            str = (String) b.get(0);
            b.remove(0);
            ap.a(f466a, "upload manager get upload data from q1 ...");
        }
        if (str == null) {
            if (c == null || c.size() < 1) {
                b(c, r);
            }
            if (c != null && c.size() >= 1) {
                str = (String) c.get(0);
                c.remove(0);
                ap.a(f466a, "upload manager get upload data from q2 ...");
            }
        }
        if (str == null) {
            if (d == null || d.size() < 1) {
                b(d, s);
            }
            if (d != null && d.size() >= 1) {
                str = (String) d.get(0);
                d.remove(0);
                ap.a(f466a, "upload manager get upload data from q3 ...");
            }
        }
        ap.a(f466a, "upload manager get upload data : " + str);
        return str;
    }

    public static void a(double d2, double d3, double d4, double d5) {
        if (d2 <= 0.0d) {
            d2 = m;
        }
        m = d2;
        n = d3;
        if (d4 <= 20.0d) {
            d4 = o;
        }
        o = d4;
        p = d5;
    }

    public static void a(u uVar, aa aaVar, Location location, String str) {
        String a2;
        ap.a(f466a, "upload manager insert2UploadQueue...");
        if (ap.q != 3 || a(location, aaVar) || a(location, false)) {
            if (uVar != null && uVar.a()) {
                if (!a(location, aaVar)) {
                    aaVar = null;
                }
                String a3 = ap.a(uVar, aaVar, location, str, 1);
                if (a3 != null) {
                    a(Jni.a(a3));
                    u = location;
                    t = location;
                    if (aaVar != null) {
                        w = aaVar;
                    }
                }
            } else if (aaVar != null && aaVar.h() && a(location, aaVar)) {
                String a4 = ap.a(a(location) ? uVar : null, aaVar, location, str, 2);
                if (a4 != null) {
                    String a5 = Jni.a(a4);
                    ap.a(f466a, "upload size:" + a5.length());
                    b(a5);
                    v = location;
                    t = location;
                    if (aaVar != null) {
                        w = aaVar;
                    }
                }
            } else {
                if (!a(location)) {
                    uVar = null;
                }
                aa aaVar2 = a(location, aaVar) ? aaVar : null;
                if ((uVar == null && aaVar2 == null) || (a2 = ap.a(uVar, aaVar2, location, str, 3)) == null) {
                    return;
                }
                c(Jni.a(a2));
                t = location;
                if (aaVar2 != null) {
                    w = aaVar2;
                }
            }
        }
    }

    public static void a(u uVar, aa aaVar, String str, double d2, double d3, String str2) {
        String str3 = String.format("&manll=%.5f|%.5f&manaddr=%s", Double.valueOf(d2), Double.valueOf(d3), str2) + ap.a(uVar, aaVar, null, str, 1);
        if (str3 != null) {
            a(Jni.a(str3));
        }
    }

    private static void a(String str) {
        if (b == null) {
            return;
        }
        ap.a(f466a, "insert2CellQueue...");
        if (b.size() <= i) {
            b.add(str);
        }
        if (b.size() < i || a(b, q) >= -1) {
            return;
        }
        a(q, k, h, l);
        a(b, q);
    }

    private static boolean a(int i2, int i3, int i4, int i5, long j2) {
        return i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024;
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        if (u == null || t == null) {
            u = location;
            return true;
        }
        double distanceTo = location.distanceTo(u);
        return ((double) location.distanceTo(t)) > ((distanceTo * ((double) ap.O)) + ((((double) ap.N) * distanceTo) * distanceTo)) + ((double) ap.P);
    }

    private static boolean a(Location location, aa aaVar) {
        if (location == null || aaVar == null || aaVar.f454a == null || aaVar.f454a.isEmpty() || aaVar.b(w)) {
            return false;
        }
        if (v == null) {
            v = location;
            return true;
        }
        return true;
    }

    public static boolean a(Location location, boolean z) {
        return m.a(t, location, z);
    }

    private static int b(List list, int i2) {
        if (list == null || i2 > 256 || i2 < 0) {
            return -1;
        }
        try {
            if (f == null) {
                f = new File(e);
                if (!f.exists()) {
                    ap.a(f466a, "upload man readfile does not exist...");
                    f = null;
                    return -2;
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
            if (randomAccessFile.length() < 1) {
                randomAccessFile.close();
                return -3;
            }
            randomAccessFile.seek(i2);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            int readInt4 = randomAccessFile.readInt();
            long readLong = randomAccessFile.readLong();
            if (!a(readInt, readInt2, readInt3, readInt4, readLong) || readInt2 < 1) {
                randomAccessFile.close();
                return -4;
            }
            byte[] bArr = new byte[k];
            int i3 = readInt2;
            int i4 = i;
            while (i4 > 0 && i3 > 0) {
                randomAccessFile.seek(((((readInt + i3) - 1) % readInt3) * readInt4) + readLong);
                int readInt5 = randomAccessFile.readInt();
                if (readInt5 > 0 && readInt5 < readInt4) {
                    randomAccessFile.read(bArr, 0, readInt5);
                    if (bArr[readInt5 - 1] == 0) {
                        list.add(new String(bArr, 0, readInt5 - 1));
                    }
                }
                i4--;
                i3--;
            }
            randomAccessFile.seek(i2);
            randomAccessFile.writeInt(readInt);
            randomAccessFile.writeInt(i3);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.writeInt(readInt4);
            randomAccessFile.writeLong(readLong);
            randomAccessFile.close();
            return i - i4;
        } catch (Exception e2) {
            return -5;
        }
    }

    public static void b() {
        ap.a(f466a, "upload manager flush...");
        j = 0;
        if (a(b, q) < -1) {
            a(q, k, h, l);
            a(b, q);
        }
        if (a(c, r) < -1) {
            a(r, k, h, l + (k * h));
            a(c, r);
        }
        if (a(d, s) < -1) {
            a(s, k, g, l + (k * h * 2));
            a(d, s);
        }
        j = 5;
    }

    private static void b(String str) {
        if (c == null) {
            return;
        }
        ap.a(f466a, "insert2WifiQueue...");
        if (c.size() <= i) {
            c.add(str);
        }
        if (c.size() < i || a(c, r) >= -1) {
            return;
        }
        a(r, k, h, l + (k * h));
        a(c, r);
    }

    private static void c(String str) {
        if (d == null) {
            return;
        }
        ap.a(f466a, "insert2GpsQueue...");
        if (d.size() <= i) {
            d.add(str);
        }
        if (d.size() < i || a(d, s) >= -1) {
            return;
        }
        a(s, k, g, l + (k * h * 2));
        a(d, s);
    }
}
