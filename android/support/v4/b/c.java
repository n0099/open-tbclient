package android.support.v4.b;

import java.io.PrintWriter;
/* loaded from: classes.dex */
public class c {
    private static final Object a = new Object();
    private static char[] b = new char[24];

    private static int a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    private static int a(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        int i5;
        if (z || i > 0) {
            if ((!z || i3 < 3) && i <= 99) {
                i4 = i2;
                i5 = i;
            } else {
                int i6 = i / 100;
                cArr[i2] = (char) (i6 + 48);
                i4 = i2 + 1;
                i5 = i - (i6 * 100);
            }
            if ((z && i3 >= 2) || i5 > 9 || i2 != i4) {
                int i7 = i5 / 10;
                cArr[i4] = (char) (i7 + 48);
                i4++;
                i5 -= i7 * 10;
            }
            cArr[i4] = (char) (i5 + 48);
            int i8 = i4 + 1;
            cArr[i8] = c;
            return i8 + 1;
        }
        return i2;
    }

    private static int a(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (b.length < i) {
            b = new char[i];
        }
        char[] cArr = b;
        if (j == 0) {
            int i7 = i - 1;
            while (0 < i7) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j > 0) {
            c = '+';
        } else {
            j = -j;
            c = '-';
        }
        int i8 = (int) (j % 1000);
        int floor = (int) Math.floor(j / 1000);
        int i9 = 0;
        if (floor > 86400) {
            i9 = floor / 86400;
            floor -= 86400 * i9;
        }
        if (floor > 3600) {
            int i10 = floor / 3600;
            i2 = i10;
            i3 = floor - (i10 * 3600);
        } else {
            i2 = 0;
            i3 = floor;
        }
        if (i3 > 60) {
            int i11 = i3 / 60;
            i4 = i11;
            i5 = i3 - (i11 * 60);
        } else {
            i4 = 0;
            i5 = i3;
        }
        if (i == 0) {
            i6 = 0;
        } else {
            int a2 = a(i9, 1, false, 0);
            int a3 = a2 + a(i2, 1, a2 > 0, 2);
            int a4 = a3 + a(i4, 1, a3 > 0, 2);
            int a5 = a4 + a(i5, 1, a4 > 0, 2);
            i6 = 0;
            int a6 = a(i8, 2, true, a5 > 0 ? 3 : 0) + 1 + a5;
            while (a6 < i) {
                cArr[i6] = ' ';
                a6++;
                i6++;
            }
        }
        cArr[i6] = c;
        int i12 = i6 + 1;
        boolean z = i != 0;
        int a7 = a(cArr, i9, 'd', i12, false, 0);
        int a8 = a(cArr, i2, 'h', a7, a7 != i12, z ? 2 : 0);
        int a9 = a(cArr, i4, 'm', a8, a8 != i12, z ? 2 : 0);
        int a10 = a(cArr, i5, 's', a9, a9 != i12, z ? 2 : 0);
        int a11 = a(cArr, i8, 'm', a10, true, (!z || a10 == i12) ? 0 : 3);
        cArr[a11] = 's';
        return a11 + 1;
    }

    public static void a(long j, PrintWriter printWriter, int i) {
        synchronized (a) {
            printWriter.print(new String(b, 0, a(j, i)));
        }
    }

    public static void a(long j, PrintWriter printWriter) {
        a(j, printWriter, 0);
    }

    public static void a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            a(j - j2, printWriter, 0);
        }
    }
}
