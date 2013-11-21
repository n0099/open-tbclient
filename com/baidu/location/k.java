package com.baidu.location;

import android.location.Location;
import cn.jingling.lib.file.ImageFile;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.location.c;
import com.baidu.location.e;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: else  reason: not valid java name */
    private static String f251else = f.v;

    /* renamed from: void  reason: not valid java name */
    private static ArrayList f259void = new ArrayList();

    /* renamed from: try  reason: not valid java name */
    private static ArrayList f258try = new ArrayList();
    private static ArrayList f = new ArrayList();
    private static String h = f.aa + "/yo.dat";
    private static File c = null;

    /* renamed from: char  reason: not valid java name */
    private static int f249char = 1024;

    /* renamed from: if  reason: not valid java name */
    private static int f254if = ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
    private static int i = 32;

    /* renamed from: case  reason: not valid java name */
    private static int f248case = 5;
    private static int j = 1024;
    private static int g = 256;
    private static double e = 0.0d;

    /* renamed from: a  reason: collision with root package name */
    private static double f939a = 0.1d;

    /* renamed from: long  reason: not valid java name */
    private static double f256long = 30.0d;
    private static double d = 100.0d;

    /* renamed from: new  reason: not valid java name */
    private static int f257new = 0;
    private static int b = 64;

    /* renamed from: int  reason: not valid java name */
    private static int f255int = DERTags.TAGGED;

    /* renamed from: goto  reason: not valid java name */
    private static Location f253goto = null;

    /* renamed from: byte  reason: not valid java name */
    private static Location f247byte = null;

    /* renamed from: do  reason: not valid java name */
    private static Location f250do = null;

    /* renamed from: for  reason: not valid java name */
    private static e.c f252for = null;

    k() {
    }

    private static int a(int i2, int i3, int i4, long j2) {
        if (i2 < 0 || i2 > 256 || i3 > 2048 || i4 > 1024 || j2 > ImageFile.MIN_SD_CARD_SPACE) {
            return -1;
        }
        j.a(f251else, "upload manager start to init cache ...");
        try {
            if (c == null) {
                c = new File(h);
                if (!c.exists()) {
                    File file = new File(f.aa);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (!c.createNewFile()) {
                        j.a(f251else, "upload manager create file error...");
                        c = null;
                        return -2;
                    }
                    j.a(f251else, "upload manager create file success");
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
            j.a(f251else, "cache inited ...");
            return 0;
        } catch (Exception e2) {
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
                    j.a(f251else, "upload man readfile does not exist...");
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
            return -5;
        }
    }

    public static String a() {
        String str = null;
        if (f259void == null || f259void.size() < 1) {
            a(f259void, f257new);
        }
        if (f259void != null && f259void.size() >= 1) {
            str = (String) f259void.get(0);
            f259void.remove(0);
            j.a(f251else, "upload manager get upload data from q1 ...");
        }
        if (str == null) {
            if (f258try == null || f258try.size() < 1) {
                a(f258try, b);
            }
            if (f258try != null && f258try.size() >= 1) {
                str = (String) f258try.get(0);
                f258try.remove(0);
                j.a(f251else, "upload manager get upload data from q2 ...");
            }
        }
        if (str == null) {
            if (f == null || f.size() < 1) {
                a(f, f255int);
            }
            if (f != null && f.size() >= 1) {
                str = (String) f.get(0);
                f.remove(0);
                j.a(f251else, "upload manager get upload data from q3 ...");
            }
        }
        j.a(f251else, "upload manager get upload data : " + str);
        return str;
    }

    public static void a(double d2, double d3, double d4, double d5) {
        if (d2 <= 0.0d) {
            d2 = e;
        }
        e = d2;
        f939a = d3;
        if (d4 <= 20.0d) {
            d4 = f256long;
        }
        f256long = d4;
        d = d5;
    }

    public static void a(c.a aVar, e.c cVar, Location location, String str) {
        String a2;
        j.a(f251else, "upload manager insert2UploadQueue...");
        if (j.f239long != 3 || a(location, cVar) || a(location, false)) {
            if (aVar != null && aVar.m128do()) {
                if (!a(location, cVar)) {
                    cVar = null;
                }
                String a3 = j.a(aVar, cVar, location, str, 1);
                if (a3 != null) {
                    m264if(Jni.m17if(a3));
                    f247byte = location;
                    f253goto = location;
                    if (cVar != null) {
                        f252for = cVar;
                    }
                }
            } else if (cVar != null && cVar.m153if() && a(location, cVar)) {
                String a4 = j.a(a(location) ? aVar : null, cVar, location, str, 2);
                if (a4 != null) {
                    String m17if = Jni.m17if(a4);
                    j.a(f251else, "upload size:" + m17if.length());
                    a(m17if);
                    f250do = location;
                    f253goto = location;
                    if (cVar != null) {
                        f252for = cVar;
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
                m261do(Jni.m17if(a2));
                f253goto = location;
                if (cVar2 != null) {
                    f252for = cVar2;
                }
            }
        }
    }

    public static void a(c.a aVar, e.c cVar, String str, double d2, double d3, String str2) {
        String str3 = String.format("&manll=%.5f|%.5f&manaddr=%s", Double.valueOf(d2), Double.valueOf(d3), str2) + j.a(aVar, cVar, null, str, 1);
        if (str3 != null) {
            m264if(Jni.m17if(str3));
        }
    }

    private static void a(String str) {
        if (f258try == null) {
            return;
        }
        j.a(f251else, "insert2WifiQueue...");
        if (f258try.size() <= i) {
            f258try.add(str);
        }
        if (f258try.size() < i || m262if(f258try, b) >= -1) {
            return;
        }
        a(b, j, f254if, g + (j * f254if));
        m262if(f258try, b);
    }

    private static boolean a(int i2, int i3, int i4, int i5, long j2) {
        return i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024;
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        if (f247byte == null || f253goto == null) {
            f247byte = location;
            return true;
        }
        double distanceTo = location.distanceTo(f247byte);
        return ((double) location.distanceTo(f253goto)) > ((distanceTo * ((double) j.P)) + ((((double) j.S) * distanceTo) * distanceTo)) + ((double) j.N);
    }

    private static boolean a(Location location, e.c cVar) {
        if (location == null || cVar == null || cVar.f162do == null || cVar.f162do.isEmpty() || cVar.m150do(f252for)) {
            return false;
        }
        if (f250do == null) {
            f250do = location;
            return true;
        }
        return true;
    }

    public static boolean a(Location location, boolean z) {
        return b.a(f253goto, location, z);
    }

    /* renamed from: do  reason: not valid java name */
    private static void m261do(String str) {
        if (f == null) {
            return;
        }
        j.a(f251else, "insert2GpsQueue...");
        if (f.size() <= i) {
            f.add(str);
        }
        if (f.size() < i || m262if(f, f255int) >= -1) {
            return;
        }
        a(f255int, j, f249char, g + (j * f254if * 2));
        m262if(f, f255int);
    }

    /* renamed from: if  reason: not valid java name */
    private static int m262if(List list, int i2) {
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
                    j.a(f251else, "upload man write file does not exist...");
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
            for (int size = list.size(); size > f248case; size--) {
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

    /* renamed from: if  reason: not valid java name */
    public static void m263if() {
        j.a(f251else, "upload manager flush...");
        f248case = 0;
        if (m262if(f259void, f257new) < -1) {
            a(f257new, j, f254if, g);
            m262if(f259void, f257new);
        }
        if (m262if(f258try, b) < -1) {
            a(b, j, f254if, g + (j * f254if));
            m262if(f258try, b);
        }
        if (m262if(f, f255int) < -1) {
            a(f255int, j, f249char, g + (j * f254if * 2));
            m262if(f, f255int);
        }
        f248case = 5;
    }

    /* renamed from: if  reason: not valid java name */
    private static void m264if(String str) {
        if (f259void == null) {
            return;
        }
        j.a(f251else, "insert2CellQueue...");
        if (f259void.size() <= i) {
            f259void.add(str);
        }
        if (f259void.size() < i || m262if(f259void, f257new) >= -1) {
            return;
        }
        a(f257new, j, f254if, g);
        m262if(f259void, f257new);
    }
}
