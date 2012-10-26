package com.baidu.location;

import android.location.Location;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.location.c;
import com.baidu.location.e;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: else  reason: not valid java name */
    private static String f195else = f.g;

    /* renamed from: void  reason: not valid java name */
    private static ArrayList f203void = new ArrayList();

    /* renamed from: try  reason: not valid java name */
    private static ArrayList f202try = new ArrayList();
    private static ArrayList f = new ArrayList();
    private static String h = f.O + "/yo.dat";
    private static File c = null;

    /* renamed from: char  reason: not valid java name */
    private static int f193char = AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END;

    /* renamed from: if  reason: not valid java name */
    private static int f198if = 512;
    private static int i = 32;

    /* renamed from: case  reason: not valid java name */
    private static int f192case = 5;
    private static int j = AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END;
    private static int g = AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
    private static double e = 0.0d;
    private static double a = 0.1d;

    /* renamed from: long  reason: not valid java name */
    private static double f200long = 30.0d;
    private static double d = 100.0d;

    /* renamed from: new  reason: not valid java name */
    private static int f201new = 0;
    private static int b = 64;

    /* renamed from: int  reason: not valid java name */
    private static int f199int = AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;

    /* renamed from: goto  reason: not valid java name */
    private static Location f197goto = null;

    /* renamed from: byte  reason: not valid java name */
    private static Location f191byte = null;

    /* renamed from: do  reason: not valid java name */
    private static Location f194do = null;

    /* renamed from: for  reason: not valid java name */
    private static e.c f196for = null;

    k() {
    }

    private static int a(int i2, int i3, int i4, long j2) {
        if (i2 < 0 || i2 > 256 || i3 > 2048 || i4 > 1024 || j2 > 5242880) {
            return -1;
        }
        j.a(f195else, "upload manager start to init cache ...");
        try {
            if (c == null) {
                c = new File(h);
                if (!c.exists()) {
                    File file = new File(f.O);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (!c.createNewFile()) {
                        j.a(f195else, "upload manager create file error...");
                        c = null;
                        return -2;
                    }
                    j.a(f195else, "upload manager create file success");
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
            randomAccessFile.seek(i2);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(i4);
            randomAccessFile.writeInt(i3);
            randomAccessFile.writeLong(j2);
            randomAccessFile.close();
            j.a(f195else, "cache inited ...");
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -3;
        }
    }

    private static int a(List list, int i2) {
        if (list == null || i2 > 256 || i2 < 0) {
            return -1;
        }
        try {
            if (c == null) {
                c = new File(h);
                if (!c.exists()) {
                    j.a(f195else, "upload man readfile does not exist...");
                    c = null;
                    return -2;
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
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
            byte[] bArr = new byte[j];
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
            e2.printStackTrace();
            return -5;
        }
    }

    public static String a() {
        String str = null;
        if (f203void == null || f203void.size() < 1) {
            a(f203void, f201new);
        }
        if (f203void != null && f203void.size() >= 1) {
            str = (String) f203void.get(0);
            f203void.remove(0);
            j.a(f195else, "upload manager get upload data from q1 ...");
        }
        if (str == null) {
            if (f202try == null || f202try.size() < 1) {
                a(f202try, b);
            }
            if (f202try != null && f202try.size() >= 1) {
                str = (String) f202try.get(0);
                f202try.remove(0);
                j.a(f195else, "upload manager get upload data from q2 ...");
            }
        }
        if (str == null) {
            if (f == null || f.size() < 1) {
                a(f, f199int);
            }
            if (f != null && f.size() >= 1) {
                str = (String) f.get(0);
                f.remove(0);
                j.a(f195else, "upload manager get upload data from q3 ...");
            }
        }
        j.a(f195else, "upload manager get upload data : " + str);
        return str;
    }

    public static void a(double d2, double d3, double d4, double d5) {
        if (d2 <= 0.0d) {
            d2 = e;
        }
        e = d2;
        a = d3;
        if (d4 <= 20.0d) {
            d4 = f200long;
        }
        f200long = d4;
        d = d5;
    }

    public static void a(c.a aVar, e.c cVar, Location location, String str) {
        String a2;
        j.a(f195else, "upload manager insert2UploadQueue...");
        if (aVar != null && aVar.m93if()) {
            if (!a(location, cVar)) {
                cVar = null;
            }
            String a3 = j.a(aVar, cVar, location, str, 1);
            if (a3 != null) {
                m193if(Jni.m0if(a3));
                f191byte = location;
                f197goto = location;
                if (cVar != null) {
                    f196for = cVar;
                }
            }
        } else if (cVar != null && cVar.m111if() && a(location, cVar)) {
            String a4 = j.a(a(location) ? aVar : null, cVar, location, str, 2);
            if (a4 != null) {
                String m0if = Jni.m0if(a4);
                j.a(f195else, "upload size:" + m0if.length());
                a(m0if);
                f194do = location;
                f197goto = location;
                if (cVar != null) {
                    f196for = cVar;
                }
            }
        } else {
            if (!a(location)) {
                aVar = null;
            }
            e.c cVar2 = a(location, cVar) ? cVar : null;
            if ((aVar == null && cVar2 == null) || (a2 = j.a(aVar, cVar2, location, str, 3)) == null) {
                return;
            }
            m190do(Jni.m0if(a2));
            f197goto = location;
            if (cVar2 != null) {
                f196for = cVar2;
            }
        }
    }

    public static void a(c.a aVar, e.c cVar, String str, double d2, double d3, String str2) {
        String str3 = String.format("&manll=%.5f|%.5f&manaddr=%s", Double.valueOf(d2), Double.valueOf(d3), str2) + j.a(aVar, cVar, null, str, 1);
        if (str3 != null) {
            m193if(Jni.m0if(str3));
        }
    }

    private static void a(String str) {
        if (f202try == null) {
            return;
        }
        j.a(f195else, "insert2WifiQueue...");
        if (f202try.size() <= i) {
            f202try.add(str);
        }
        if (f202try.size() < i || m191if(f202try, b) >= -1) {
            return;
        }
        a(b, j, f198if, g + (j * f198if));
        m191if(f202try, b);
    }

    private static boolean a(int i2, int i3, int i4, int i5, long j2) {
        return i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024;
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        if (f191byte == null) {
            f191byte = location;
            return true;
        }
        double distanceTo = location.distanceTo(f191byte);
        return ((double) location.distanceTo(f197goto)) > ((distanceTo * a) + ((e * distanceTo) * distanceTo)) + f200long;
    }

    private static boolean a(Location location, e.c cVar) {
        if (location == null || cVar == null || cVar.f124do == null) {
            return false;
        }
        if (f194do != null) {
            return ((double) location.distanceTo(f194do)) < d;
        }
        f194do = location;
        return true;
    }

    /* renamed from: do  reason: not valid java name */
    private static void m190do(String str) {
        if (f == null) {
            return;
        }
        j.a(f195else, "insert2GpsQueue...");
        if (f.size() <= i) {
            f.add(str);
        }
        if (f.size() < i || m191if(f, f199int) >= -1) {
            return;
        }
        a(f199int, j, f193char, g + (j * f198if * 2));
        m191if(f, f199int);
    }

    /* renamed from: if  reason: not valid java name */
    private static int m191if(List list, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (list == null || list.size() < 1 || i2 > 256 || i2 < 0) {
            return -1;
        }
        try {
            if (c == null) {
                c = new File(h);
                if (!c.exists()) {
                    j.a(f195else, "upload man write file does not exist...");
                    c = null;
                    return -2;
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
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
            for (int size = list.size(); size > f192case; size--) {
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
            e2.printStackTrace();
            return -5;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static void m192if() {
        j.a(f195else, "upload manager flush...");
        f192case = 0;
        if (m191if(f203void, f201new) < -1) {
            a(f201new, j, f198if, g);
            m191if(f203void, f201new);
        }
        if (m191if(f202try, b) < -1) {
            a(b, j, f198if, g + (j * f198if));
            m191if(f202try, b);
        }
        if (m191if(f, f199int) < -1) {
            a(f199int, j, f193char, g + (j * f198if * 2));
            m191if(f, f199int);
        }
        f192case = 5;
    }

    /* renamed from: if  reason: not valid java name */
    private static void m193if(String str) {
        if (f203void == null) {
            return;
        }
        j.a(f195else, "insert2CellQueue...");
        if (f203void.size() <= i) {
            f203void.add(str);
        }
        if (f203void.size() < i || m191if(f203void, f201new) >= -1) {
            return;
        }
        a(f201new, j, f198if, g);
        m191if(f203void, f201new);
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m194if(Location location) {
        return b.a(f197goto, location);
    }
}
