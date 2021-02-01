package com.baidu.searchbox.v8engine.util;

import android.os.SystemClock;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes15.dex */
public class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    public static final long NANOS_PER_MS = 1000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final String TAG = "TimeUtils";
    private static SimpleDateFormat sLoggingFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[29];
    private static char[] sTmpFormatStr = new char[29];

    private static int accumField(int i, int i2, boolean z, int i3) {
        int i4 = 0;
        if (i > 999) {
            while (i != 0) {
                i4++;
                i /= 10;
            }
            return i4 + i2;
        } else if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        } else {
            if (i > 9 || (z && i3 >= 2)) {
                return i2 + 2;
            }
            if (z || i > 0) {
                return i2 + 1;
            }
            return 0;
        }
    }

    private static int printFieldLocked(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        int i5;
        int i6;
        if (z || i > 0) {
            if (i > 999) {
                int i7 = 0;
                while (i != 0 && i7 < sTmpFormatStr.length) {
                    sTmpFormatStr[i7] = (char) ((i % 10) + 48);
                    i7++;
                    i /= 10;
                }
                i6 = i2;
                for (int i8 = i7 - 1; i8 >= 0; i8--) {
                    cArr[i6] = sTmpFormatStr[i8];
                    i6++;
                }
            } else {
                if ((!z || i3 < 3) && i <= 99) {
                    i4 = i2;
                    i5 = i;
                } else {
                    int i9 = i / 100;
                    cArr[i2] = (char) (i9 + 48);
                    i4 = i2 + 1;
                    i5 = i - (i9 * 100);
                }
                if ((z && i3 >= 2) || i5 > 9 || i2 != i4) {
                    int i10 = i5 / 10;
                    cArr[i4] = (char) (i10 + 48);
                    i4++;
                    i5 -= i10 * 10;
                }
                cArr[i4] = (char) (i5 + 48);
                i6 = i4 + 1;
            }
            cArr[i6] = c;
            return i6 + 1;
        }
        return i2;
    }

    private static int formatDurationLocked(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        if (sFormatStr.length < i) {
            sFormatStr = new char[i];
        }
        char[] cArr = sFormatStr;
        if (j == 0) {
            int i6 = 0;
            int i7 = i - 1;
            while (i6 < i7) {
                cArr[i6] = ' ';
                i6++;
            }
            cArr[i6] = '0';
            return i6 + 1;
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
        if (floor >= SECONDS_PER_DAY) {
            i9 = floor / SECONDS_PER_DAY;
            floor -= SECONDS_PER_DAY * i9;
        }
        if (floor >= 3600) {
            int i10 = floor / 3600;
            floor -= i10 * 3600;
            i2 = i10;
        } else {
            i2 = 0;
        }
        if (floor >= 60) {
            int i11 = floor / 60;
            i3 = i11;
            i4 = floor - (i11 * 60);
        } else {
            i3 = 0;
            i4 = floor;
        }
        if (i == 0) {
            i5 = 0;
        } else {
            int accumField = accumField(i9, 1, false, 0);
            int accumField2 = accumField + accumField(i2, 1, accumField > 0, 2);
            int accumField3 = accumField2 + accumField(i3, 1, accumField2 > 0, 2);
            int accumField4 = accumField3 + accumField(i4, 1, accumField3 > 0, 2);
            i5 = 0;
            for (int accumField5 = accumField4 + accumField(i8, 2, true, accumField4 > 0 ? 3 : 0) + 1; accumField5 < i; accumField5++) {
                cArr[i5] = ' ';
                i5++;
            }
        }
        cArr[i5] = c;
        int i12 = i5 + 1;
        boolean z = i != 0;
        int printFieldLocked = printFieldLocked(cArr, i9, 'd', i12, false, 0);
        int printFieldLocked2 = printFieldLocked(cArr, i2, 'h', printFieldLocked, printFieldLocked != i12, z ? 2 : 0);
        int printFieldLocked3 = printFieldLocked(cArr, i3, 'm', printFieldLocked2, printFieldLocked2 != i12, z ? 2 : 0);
        int printFieldLocked4 = printFieldLocked(cArr, i4, 's', printFieldLocked3, printFieldLocked3 != i12, z ? 2 : 0);
        int printFieldLocked5 = printFieldLocked(cArr, i8, 'm', printFieldLocked4, true, (!z || printFieldLocked4 == i12) ? 0 : 3);
        cArr[printFieldLocked5] = 's';
        return printFieldLocked5 + 1;
    }

    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i)));
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

    public static String formatUptime(long j) {
        long uptimeMillis = j - SystemClock.uptimeMillis();
        if (uptimeMillis > 0) {
            return j + " (in " + uptimeMillis + " ms)";
        }
        if (uptimeMillis < 0) {
            return j + " (" + (-uptimeMillis) + " ms ago)";
        }
        return j + " (now)";
    }

    public static String logTimeOfDay(long j) {
        Calendar calendar = Calendar.getInstance();
        if (j >= 0) {
            calendar.setTimeInMillis(j);
            return String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar);
        }
        return Long.toString(j);
    }

    public static String formatForLogging(long j) {
        return j <= 0 ? "unknown" : sLoggingFormat.format(new Date(j));
    }
}
