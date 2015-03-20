package com.baidu.location;

import android.location.Location;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
/* loaded from: classes.dex */
public class y implements a0, n {
    private static final int e1 = 5;
    private static final int e3 = 3600;
    private static final int e8 = 1024;
    private static final int eZ = 12;
    private static final int ff = 5;
    private static final int fg = 750;
    private static final int fh = 1000;
    private static final int fj = 100;
    private String fi;
    private boolean fk = true;
    private static y fm = null;
    private static String fc = "Temp_in.dat";
    private static File e2 = new File(I, fc);
    private static StringBuffer e0 = null;
    private static boolean e7 = true;
    private static int fd = 0;
    private static int fl = 0;
    private static long e6 = 0;
    private static long e5 = 0;
    private static long fn = 0;
    private static double fa = 0.0d;
    private static double fb = 0.0d;
    private static int e4 = 0;
    private static int e9 = 0;
    private static int fe = 0;

    private y(String str) {
        this.fi = null;
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.fi = str;
    }

    private static boolean aO() {
        if (e2.exists()) {
            e2.delete();
        }
        if (!e2.getParentFile().exists()) {
            e2.getParentFile().mkdirs();
        }
        try {
            e2.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(e2, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            aQ();
            return e2.exists();
        } catch (IOException e) {
            return false;
        }
    }

    private void aP() {
        if (e0 != null && e0.length() >= 100) {
            i(e0.toString());
        }
        aQ();
    }

    private static void aQ() {
        e7 = true;
        e0 = null;
        fd = 0;
        fl = 0;
        e6 = 0L;
        e5 = 0L;
        fn = 0L;
        fa = 0.0d;
        fb = 0.0d;
        e4 = 0;
        e9 = 0;
        fe = 0;
    }

    public static y aR() {
        if (fm == null) {
            fm = new y(a2.cC().cz());
        }
        return fm;
    }

    private void aS() {
    }

    public static String aT() {
        if (e2 != null && e2.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(e2, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                if (!m364if(readInt, readInt2, readInt3)) {
                    randomAccessFile.close();
                    aO();
                    return null;
                } else if (readInt2 == 0 || readInt2 == readInt3) {
                    randomAccessFile.close();
                    return null;
                } else {
                    long j = 0 + ((readInt2 - 1) * 1024) + 12;
                    randomAccessFile.seek(j);
                    int readInt4 = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt4];
                    randomAccessFile.seek(j + 4);
                    for (int i = 0; i < readInt4; i++) {
                        bArr[i] = randomAccessFile.readByte();
                    }
                    String str = new String(bArr);
                    int i2 = readInt < c.aQ ? readInt2 + 1 : readInt2 == c.aQ ? 1 : readInt2 + 1;
                    randomAccessFile.seek(4L);
                    randomAccessFile.writeInt(i2);
                    randomAccessFile.close();
                    return str;
                }
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

    private boolean aU() {
        if (e2.exists()) {
            e2.delete();
        }
        aQ();
        return !e2.exists();
    }

    /* renamed from: for  reason: not valid java name */
    private String m363for(int i) {
        if (e2.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(e2, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                if (!m364if(readInt, randomAccessFile.readInt(), randomAccessFile.readInt())) {
                    randomAccessFile.close();
                    aO();
                    return null;
                } else if (i == 0 || i == readInt + 1) {
                    randomAccessFile.close();
                    return null;
                } else {
                    long j = 12 + 0 + ((i - 1) * 1024);
                    randomAccessFile.seek(j);
                    int readInt2 = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt2];
                    randomAccessFile.seek(j + 4);
                    for (int i2 = 0; i2 < readInt2; i2++) {
                        bArr[i2] = randomAccessFile.readByte();
                    }
                    randomAccessFile.close();
                    return new String(bArr);
                }
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

    private boolean i(String str) {
        if (str == null || !str.startsWith("&nr")) {
            return false;
        }
        if (e2.exists() || aO()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(e2, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                if (!m364if(readInt, readInt2, readInt3)) {
                    randomAccessFile.close();
                    aO();
                    return false;
                }
                if (c.ac) {
                    if (readInt == c.aQ) {
                        if (str.equals(m363for(readInt3 == 1 ? c.aQ : readInt3 - 1))) {
                            randomAccessFile.close();
                            return false;
                        }
                    } else if (readInt3 > 1 && str.equals(m363for(readInt3 - 1))) {
                        randomAccessFile.close();
                        return false;
                    }
                }
                randomAccessFile.seek(((readInt3 - 1) * 1024) + 12 + 0);
                if (str.length() > 750) {
                    randomAccessFile.close();
                    return false;
                }
                String j = Jni.j(str);
                int length = j.length();
                if (length > 1020) {
                    randomAccessFile.close();
                    return false;
                }
                randomAccessFile.writeInt(length);
                randomAccessFile.writeBytes(j);
                if (readInt == 0) {
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(1);
                    randomAccessFile.writeInt(1);
                    randomAccessFile.writeInt(2);
                } else if (readInt < c.aQ - 1) {
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(readInt + 1);
                    randomAccessFile.seek(8L);
                    randomAccessFile.writeInt(readInt + 2);
                } else if (readInt == c.aQ - 1) {
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(c.aQ);
                    if (readInt2 == 0 || readInt2 == 1) {
                        randomAccessFile.writeInt(2);
                    }
                    randomAccessFile.seek(8L);
                    randomAccessFile.writeInt(1);
                } else if (readInt3 == readInt2) {
                    int i = readInt3 == c.aQ ? 1 : readInt3 + 1;
                    int i2 = i == c.aQ ? 1 : i + 1;
                    randomAccessFile.seek(4L);
                    randomAccessFile.writeInt(i2);
                    randomAccessFile.writeInt(i);
                } else {
                    int i3 = readInt3 == c.aQ ? 1 : readInt3 + 1;
                    if (i3 == readInt2) {
                        int i4 = i3 == c.aQ ? 1 : i3 + 1;
                        randomAccessFile.seek(4L);
                        randomAccessFile.writeInt(i4);
                    }
                    randomAccessFile.seek(8L);
                    randomAccessFile.writeInt(i3);
                }
                randomAccessFile.close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: if  reason: not valid java name */
    private static boolean m364if(int i, int i2, int i3) {
        if (i < 0 || i > c.aQ) {
            return false;
        }
        if (i2 < 0 || i2 > i + 1) {
            return false;
        }
        return i3 >= 1 && i3 <= i + 1 && i3 <= c.aQ;
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m365if(Location location, int i, int i2) {
        if (location != null && c.aj && this.fk && aa.gq) {
            if (c.aZ < 5) {
                c.aZ = 5;
            } else if (c.aZ > 1000) {
                c.aZ = 1000;
            }
            if (c.a4 < 5) {
                c.a4 = 5;
            } else if (c.a4 > e3) {
                c.a4 = e3;
            }
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            long time = location.getTime() / 1000;
            if (e7) {
                fd = 1;
                e0 = new StringBuffer("");
                e0.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", this.fi, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
                fl = e0.length();
                e6 = time;
                fa = longitude;
                fb = latitude;
                e5 = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                fn = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                e7 = false;
                return true;
            }
            float[] fArr = new float[1];
            Location.distanceBetween(latitude, longitude, fb, fa, fArr);
            long j = time - e6;
            if (fArr[0] >= c.aZ || j >= c.a4) {
                if (e0 == null) {
                    fd++;
                    fl = 0;
                    e0 = new StringBuffer("");
                    e0.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", this.fi, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
                    fl = e0.length();
                    e6 = time;
                    fa = longitude;
                    fb = latitude;
                    e5 = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                    fn = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                } else {
                    fa = longitude;
                    fb = latitude;
                    long floor = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                    long floor2 = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                    e4 = (int) (time - e6);
                    e9 = (int) (floor - e5);
                    fe = (int) (floor2 - fn);
                    e0.append(String.format(Locale.CHINA, "%d,%d,%d|", Integer.valueOf(e4), Integer.valueOf(e9), Integer.valueOf(fe)));
                    fl = e0.length();
                    e6 = time;
                    e5 = floor;
                    fn = floor2;
                }
                if (fl + 15 > 750) {
                    i(e0.toString());
                    e0 = null;
                }
                if (fd >= c.aQ) {
                    this.fk = false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void aV() {
        aP();
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m366do(Location location) {
        return m365if(location, c.aZ, c.a4);
    }
}
