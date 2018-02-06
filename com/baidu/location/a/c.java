package com.baidu.location.a;

import android.location.Location;
import com.baidu.location.Jni;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
/* loaded from: classes.dex */
public class c {
    private String p;
    private boolean q = true;
    private static c aBv = null;
    private static String b = "Temp_in.dat";
    private static File c = new File(com.baidu.location.h.h.a, b);
    private static StringBuffer aBw = null;
    private static boolean e = true;
    private static int f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static double k = 0.0d;
    private static double l = 0.0d;
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;

    private c(String str) {
        this.p = null;
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.p = str;
    }

    private String a(int i2) {
        if (c.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                if (!a(readInt, randomAccessFile.readInt(), randomAccessFile.readInt())) {
                    randomAccessFile.close();
                    d();
                    return null;
                } else if (i2 == 0 || i2 == readInt + 1) {
                    randomAccessFile.close();
                    return null;
                } else {
                    long j2 = 12 + 0 + ((i2 - 1) * 1024);
                    randomAccessFile.seek(j2);
                    int readInt2 = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt2];
                    randomAccessFile.seek(j2 + 4);
                    for (int i3 = 0; i3 < readInt2; i3++) {
                        bArr[i3] = randomAccessFile.readByte();
                    }
                    randomAccessFile.close();
                    return new String(bArr);
                }
            } catch (IOException e2) {
                return null;
            }
        }
        return null;
    }

    private static boolean a(int i2, int i3, int i4) {
        if (i2 < 0 || i2 > com.baidu.location.h.i.ab) {
            return false;
        }
        if (i3 < 0 || i3 > i2 + 1) {
            return false;
        }
        return i4 >= 1 && i4 <= i2 + 1 && i4 <= com.baidu.location.h.i.ab;
    }

    private boolean a(Location location, int i2, int i3) {
        if (location != null && com.baidu.location.h.i.X && this.q) {
            if (com.baidu.location.h.i.Z < 5) {
                com.baidu.location.h.i.Z = 5;
            } else if (com.baidu.location.h.i.Z > 1000) {
                com.baidu.location.h.i.Z = 1000;
            }
            if (com.baidu.location.h.i.aa < 5) {
                com.baidu.location.h.i.aa = 5;
            } else if (com.baidu.location.h.i.aa > 3600) {
                com.baidu.location.h.i.aa = 3600;
            }
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            long time = location.getTime() / 1000;
            if (e) {
                f = 1;
                aBw = new StringBuffer("");
                aBw.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", this.p, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
                g = aBw.length();
                h = time;
                k = longitude;
                l = latitude;
                i = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                j = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                e = false;
                return true;
            }
            float[] fArr = new float[1];
            Location.distanceBetween(latitude, longitude, l, k, fArr);
            long j2 = time - h;
            if (fArr[0] >= com.baidu.location.h.i.Z || j2 >= com.baidu.location.h.i.aa) {
                if (aBw == null) {
                    f++;
                    g = 0;
                    aBw = new StringBuffer("");
                    aBw.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", this.p, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
                    g = aBw.length();
                    h = time;
                    k = longitude;
                    l = latitude;
                    i = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                    j = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                } else {
                    k = longitude;
                    l = latitude;
                    long floor = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                    long floor2 = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                    m = (int) (time - h);
                    n = (int) (floor - i);
                    o = (int) (floor2 - j);
                    aBw.append(String.format(Locale.CHINA, "%d,%d,%d|", Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(o)));
                    g = aBw.length();
                    h = time;
                    i = floor;
                    j = floor2;
                }
                if (g + 15 > 750) {
                    a(aBw.toString());
                    aBw = null;
                }
                if (f >= com.baidu.location.h.i.ab) {
                    this.q = false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean a(String str) {
        if (str == null || !str.startsWith("&nr")) {
            return false;
        }
        if (c.exists() || d()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                if (!a(readInt, readInt2, readInt3)) {
                    randomAccessFile.close();
                    d();
                    return false;
                }
                if (com.baidu.location.h.i.Y) {
                    if (readInt == com.baidu.location.h.i.ab) {
                        if (str.equals(a(readInt3 == 1 ? com.baidu.location.h.i.ab : readInt3 - 1))) {
                            randomAccessFile.close();
                            return false;
                        }
                    } else if (readInt3 > 1 && str.equals(a(readInt3 - 1))) {
                        randomAccessFile.close();
                        return false;
                    }
                }
                randomAccessFile.seek(((readInt3 - 1) * 1024) + 12 + 0);
                if (str.length() > 750) {
                    randomAccessFile.close();
                    return false;
                }
                String encode = Jni.encode(str);
                int length = encode.length();
                if (length > 1020) {
                    randomAccessFile.close();
                    return false;
                }
                randomAccessFile.writeInt(length);
                randomAccessFile.writeBytes(encode);
                if (readInt == 0) {
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(1);
                    randomAccessFile.writeInt(1);
                    randomAccessFile.writeInt(2);
                } else if (readInt < com.baidu.location.h.i.ab - 1) {
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(readInt + 1);
                    randomAccessFile.seek(8L);
                    randomAccessFile.writeInt(readInt + 2);
                } else if (readInt == com.baidu.location.h.i.ab - 1) {
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(com.baidu.location.h.i.ab);
                    if (readInt2 == 0 || readInt2 == 1) {
                        randomAccessFile.writeInt(2);
                    }
                    randomAccessFile.seek(8L);
                    randomAccessFile.writeInt(1);
                } else if (readInt3 == readInt2) {
                    int i2 = readInt3 == com.baidu.location.h.i.ab ? 1 : readInt3 + 1;
                    int i3 = i2 == com.baidu.location.h.i.ab ? 1 : i2 + 1;
                    randomAccessFile.seek(4L);
                    randomAccessFile.writeInt(i3);
                    randomAccessFile.writeInt(i2);
                } else {
                    int i4 = readInt3 == com.baidu.location.h.i.ab ? 1 : readInt3 + 1;
                    if (i4 == readInt2) {
                        int i5 = i4 == com.baidu.location.h.i.ab ? 1 : i4 + 1;
                        randomAccessFile.seek(4L);
                        randomAccessFile.writeInt(i5);
                    }
                    randomAccessFile.seek(8L);
                    randomAccessFile.writeInt(i4);
                }
                randomAccessFile.close();
                return true;
            } catch (IOException e2) {
                return false;
            }
        }
        return false;
    }

    public static String b() {
        if (c != null && c.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                if (!a(readInt, readInt2, readInt3)) {
                    randomAccessFile.close();
                    d();
                    return null;
                } else if (readInt2 == 0 || readInt2 == readInt3) {
                    randomAccessFile.close();
                    return null;
                } else {
                    long j2 = 0 + ((readInt2 - 1) * 1024) + 12;
                    randomAccessFile.seek(j2);
                    int readInt4 = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt4];
                    randomAccessFile.seek(j2 + 4);
                    for (int i2 = 0; i2 < readInt4; i2++) {
                        bArr[i2] = randomAccessFile.readByte();
                    }
                    String str = new String(bArr);
                    int i3 = readInt < com.baidu.location.h.i.ab ? readInt2 + 1 : readInt2 == com.baidu.location.h.i.ab ? 1 : readInt2 + 1;
                    randomAccessFile.seek(4L);
                    randomAccessFile.writeInt(i3);
                    randomAccessFile.close();
                    return str;
                }
            } catch (IOException e2) {
                return null;
            }
        }
        return null;
    }

    private static void c() {
        e = true;
        aBw = null;
        f = 0;
        g = 0;
        h = 0L;
        i = 0L;
        j = 0L;
        k = 0.0d;
        l = 0.0d;
        m = 0;
        n = 0;
        o = 0;
    }

    private static boolean d() {
        if (c.exists()) {
            c.delete();
        }
        if (!c.getParentFile().exists()) {
            c.getParentFile().mkdirs();
        }
        try {
            c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            c();
            return c.exists();
        } catch (IOException e2) {
            return false;
        }
    }

    public static c uo() {
        if (aBv == null) {
            aBv = new c(com.baidu.location.h.c.vn().c());
        }
        return aBv;
    }

    public boolean b(Location location) {
        return a(location, com.baidu.location.h.i.Z, com.baidu.location.h.i.aa);
    }
}
