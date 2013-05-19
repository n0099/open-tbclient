package com.baidu.location;

import android.location.Location;
import com.baidu.zeus.NotificationProxy;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class s {
    private String a;

    public s(String str) {
        this.a = null;
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.a = str;
    }

    private boolean a(String str) {
        File file;
        File file2;
        boolean b;
        String a;
        int length;
        boolean x;
        if (str == null || !str.startsWith("&nr")) {
            return false;
        }
        file = m.A;
        if (!file.exists()) {
            x = m.x();
            if (!x) {
                return false;
            }
        }
        try {
            file2 = m.A;
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            randomAccessFile.seek(0L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            b = m.b(readInt, readInt2, readInt3);
            if (!b) {
                randomAccessFile.close();
                m.x();
                return false;
            }
            if (ap.S) {
                if (readInt == ap.V) {
                    if (str.equals(a(readInt3 == 1 ? ap.V : readInt3 - 1))) {
                        randomAccessFile.close();
                        return false;
                    }
                } else if (readInt3 > 1 && str.equals(a(readInt3 - 1))) {
                    randomAccessFile.close();
                    return false;
                }
            }
            randomAccessFile.seek(((readInt3 - 1) * NotificationProxy.MAX_URL_LENGTH) + 12 + 0);
            if (str.length() > 750 || (length = (a = Jni.a(str)).length()) > 1020) {
                return false;
            }
            randomAccessFile.writeInt(length);
            randomAccessFile.writeBytes(a);
            if (readInt == 0) {
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(1);
                randomAccessFile.writeInt(1);
                randomAccessFile.writeInt(2);
            } else if (readInt < ap.V - 1) {
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(readInt + 1);
                randomAccessFile.seek(8L);
                randomAccessFile.writeInt(readInt + 2);
            } else if (readInt == ap.V - 1) {
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(ap.V);
                if (readInt2 == 0 || readInt2 == 1) {
                    randomAccessFile.writeInt(2);
                }
                randomAccessFile.seek(8L);
                randomAccessFile.writeInt(1);
            } else if (readInt3 == readInt2) {
                int i = readInt3 == ap.V ? 1 : readInt3 + 1;
                int i2 = i == ap.V ? 1 : i + 1;
                randomAccessFile.seek(4L);
                randomAccessFile.writeInt(i2);
                randomAccessFile.writeInt(i);
            } else {
                int i3 = readInt3 == ap.V ? 1 : readInt3 + 1;
                if (i3 == readInt2) {
                    int i4 = i3 == ap.V ? 1 : i3 + 1;
                    randomAccessFile.seek(4L);
                    randomAccessFile.writeInt(i4);
                }
                randomAccessFile.seek(8L);
                randomAccessFile.writeInt(i3);
            }
            randomAccessFile.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String a(int i) {
        File file;
        File file2;
        boolean b;
        file = m.A;
        if (file.exists()) {
            try {
                file2 = m.A;
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                b = m.b(readInt, randomAccessFile.readInt(), randomAccessFile.readInt());
                if (!b) {
                    randomAccessFile.close();
                    m.x();
                    return null;
                } else if (i == 0 || i == readInt + 1) {
                    return null;
                } else {
                    long j = 12 + 0 + ((i - 1) * NotificationProxy.MAX_URL_LENGTH);
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
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void a() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        stringBuffer = m.B;
        if (stringBuffer != null) {
            stringBuffer2 = m.B;
            if (stringBuffer2.length() >= 100) {
                stringBuffer3 = m.B;
                a(stringBuffer3.toString());
            }
        }
        m.y();
    }

    public boolean a(Location location) {
        return a(location, ap.T, ap.U);
    }

    public boolean a(Location location, int i, int i2) {
        boolean z;
        long j;
        long j2;
        long j3;
        StringBuffer stringBuffer;
        long j4;
        long j5;
        long j6;
        StringBuffer stringBuffer2;
        int i3;
        int i4;
        int i5;
        StringBuffer stringBuffer3;
        int i6;
        int i7;
        StringBuffer stringBuffer4;
        StringBuffer stringBuffer5;
        StringBuffer stringBuffer6;
        StringBuffer stringBuffer7;
        StringBuffer stringBuffer8;
        if (location == null || !ap.R) {
            return false;
        }
        if (ap.T < 5) {
            ap.T = 5;
        } else if (ap.T > 1000) {
            ap.T = 1000;
        }
        if (ap.U < 5) {
            ap.U = 5;
        } else if (ap.U > 3600) {
            ap.U = 3600;
        }
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        long time = location.getTime() / 1000;
        z = m.C;
        if (z) {
            int unused = m.D = 1;
            StringBuffer unused2 = m.B = new StringBuffer("");
            stringBuffer7 = m.B;
            stringBuffer7.append(String.format("&nr=%s&traj=%d,%.5f,%.5f|", this.a, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
            stringBuffer8 = m.B;
            int unused3 = m.E = stringBuffer8.length();
            long unused4 = m.F = time;
            long unused5 = m.G = (long) Math.floor((longitude * 100000.0d) + 0.5d);
            long unused6 = m.H = (long) Math.floor((latitude * 100000.0d) + 0.5d);
            boolean unused7 = m.C = false;
            return true;
        }
        float[] fArr = new float[1];
        j = m.H;
        j2 = m.G;
        Location.distanceBetween(latitude, longitude, 1.0E-5d * j, 1.0E-5d * j2, fArr);
        j3 = m.F;
        long j7 = time - j3;
        if (fArr[0] >= ap.T || j7 >= ap.U) {
            stringBuffer = m.B;
            if (stringBuffer == null) {
                m.o();
                int unused8 = m.E = 0;
                StringBuffer unused9 = m.B = new StringBuffer("");
                stringBuffer5 = m.B;
                stringBuffer5.append(String.format("&nr=%s&traj=%d,%.5f,%.5f|", this.a, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
                stringBuffer6 = m.B;
                int unused10 = m.E = stringBuffer6.length();
                long unused11 = m.F = time;
                long unused12 = m.G = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                long unused13 = m.H = (long) Math.floor((latitude * 100000.0d) + 0.5d);
            } else {
                long floor = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                long floor2 = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                j4 = m.F;
                int unused14 = m.I = (int) (time - j4);
                j5 = m.G;
                int unused15 = m.J = (int) (floor - j5);
                j6 = m.H;
                int unused16 = m.K = (int) (floor2 - j6);
                stringBuffer2 = m.B;
                i3 = m.I;
                i4 = m.J;
                i5 = m.K;
                stringBuffer2.append(String.format("%d,%d,%d|", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
                stringBuffer3 = m.B;
                int unused17 = m.E = stringBuffer3.length();
                long unused18 = m.F = time;
                long unused19 = m.G = floor;
                long unused20 = m.H = floor2;
            }
            i6 = m.E;
            if (i6 + 15 > 750) {
                stringBuffer4 = m.B;
                a(stringBuffer4.toString());
                StringBuffer unused21 = m.B = null;
            }
            i7 = m.D;
            if (i7 >= ap.V) {
                ap.R = false;
            }
            return true;
        }
        return false;
    }
}
