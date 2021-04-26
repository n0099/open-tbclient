package com.baidu.searchbox.v8engine.util;

import android.os.SystemClock;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes2.dex */
public class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    public static final long NANOS_PER_MS = 1000000;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;
    public static final String TAG = "TimeUtils";
    public static SimpleDateFormat sLoggingFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final Object sFormatSync = new Object();
    public static char[] sFormatStr = new char[29];
    public static char[] sTmpFormatStr = new char[29];

    public static int accumField(int i2, int i3, boolean z, int i4) {
        int i5 = 0;
        if (i2 > 999) {
            while (i2 != 0) {
                i5++;
                i2 /= 10;
            }
            return i5 + i3;
        } else if (i2 > 99 || (z && i4 >= 3)) {
            return i3 + 3;
        } else {
            if (i2 > 9 || (z && i4 >= 2)) {
                return i3 + 2;
            }
            if (z || i2 > 0) {
                return i3 + 1;
            }
            return 0;
        }
    }

    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    public static int formatDurationLocked(long j, int i2) {
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2 = j;
        if (sFormatStr.length < i2) {
            sFormatStr = new char[i2];
        }
        char[] cArr = sFormatStr;
        int i8 = 0;
        int i9 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i9 == 0) {
            int i10 = i2 - 1;
            while (i8 < i10) {
                cArr[i8] = ' ';
                i8++;
            }
            cArr[i8] = '0';
            return i8 + 1;
        }
        if (i9 > 0) {
            c2 = '+';
        } else {
            c2 = '-';
            j2 = -j2;
        }
        int i11 = (int) (j2 % 1000);
        int floor = (int) Math.floor(j2 / 1000);
        if (floor >= 86400) {
            i3 = floor / 86400;
            floor -= 86400 * i3;
        } else {
            i3 = 0;
        }
        if (floor >= 3600) {
            i4 = floor / 3600;
            floor -= i4 * 3600;
        } else {
            i4 = 0;
        }
        if (floor >= 60) {
            int i12 = floor / 60;
            i5 = floor - (i12 * 60);
            i6 = i12;
        } else {
            i5 = floor;
            i6 = 0;
        }
        if (i2 != 0) {
            int accumField = accumField(i3, 1, false, 0);
            int accumField2 = accumField + accumField(i4, 1, accumField > 0, 2);
            int accumField3 = accumField2 + accumField(i6, 1, accumField2 > 0, 2);
            int accumField4 = accumField3 + accumField(i5, 1, accumField3 > 0, 2);
            i7 = 0;
            for (int accumField5 = accumField4 + accumField(i11, 2, true, accumField4 > 0 ? 3 : 0) + 1; accumField5 < i2; accumField5++) {
                cArr[i7] = ' ';
                i7++;
            }
        } else {
            i7 = 0;
        }
        cArr[i7] = c2;
        int i13 = i7 + 1;
        boolean z = i2 != 0;
        int printFieldLocked = printFieldLocked(cArr, i3, 'd', i13, false, 0);
        int printFieldLocked2 = printFieldLocked(cArr, i4, 'h', printFieldLocked, printFieldLocked != i13, z ? 2 : 0);
        int printFieldLocked3 = printFieldLocked(cArr, i6, 'm', printFieldLocked2, printFieldLocked2 != i13, z ? 2 : 0);
        int printFieldLocked4 = printFieldLocked(cArr, i5, 's', printFieldLocked3, printFieldLocked3 != i13, z ? 2 : 0);
        int printFieldLocked5 = printFieldLocked(cArr, i11, 'm', printFieldLocked4, true, (!z || printFieldLocked4 == i13) ? 0 : 3);
        cArr[printFieldLocked5] = 's';
        return printFieldLocked5 + 1;
    }

    public static String formatForLogging(long j) {
        return j <= 0 ? "unknown" : sLoggingFormat.format(new Date(j));
    }

    public static String formatUptime(long j) {
        long uptimeMillis = j - SystemClock.uptimeMillis();
        int i2 = (uptimeMillis > 0L ? 1 : (uptimeMillis == 0L ? 0 : -1));
        if (i2 > 0) {
            return j + " (in " + uptimeMillis + " ms)";
        } else if (i2 < 0) {
            return j + " (" + (-uptimeMillis) + " ms ago)";
        } else {
            return j + " (now)";
        }
    }

    public static String logTimeOfDay(long j) {
        Calendar calendar = Calendar.getInstance();
        if (j >= 0) {
            calendar.setTimeInMillis(j);
            return String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar);
        }
        return Long.toString(j);
    }

    public static int printFieldLocked(char[] cArr, int i2, char c2, int i3, boolean z, int i4) {
        int i5;
        if (z || i2 > 0) {
            if (i2 > 999) {
                int i6 = 0;
                while (i2 != 0) {
                    char[] cArr2 = sTmpFormatStr;
                    if (i6 >= cArr2.length) {
                        break;
                    }
                    cArr2[i6] = (char) ((i2 % 10) + 48);
                    i6++;
                    i2 /= 10;
                }
                while (true) {
                    i6--;
                    if (i6 < 0) {
                        break;
                    }
                    cArr[i3] = sTmpFormatStr[i6];
                    i3++;
                }
            } else {
                if ((!z || i4 < 3) && i2 <= 99) {
                    i5 = i3;
                } else {
                    int i7 = i2 / 100;
                    cArr[i3] = (char) (i7 + 48);
                    i5 = i3 + 1;
                    i2 -= i7 * 100;
                }
                if ((z && i4 >= 2) || i2 > 9 || i3 != i5) {
                    int i8 = i2 / 10;
                    cArr[i5] = (char) (i8 + 48);
                    i5++;
                    i2 -= i8 * 10;
                }
                cArr[i5] = (char) (i2 + 48);
                i3 = i5 + 1;
            }
            cArr[i3] = c2;
            return i3 + 1;
        }
        return i3;
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i2) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i2)));
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j - j2, printWriter, 0);
        }
    }
}
