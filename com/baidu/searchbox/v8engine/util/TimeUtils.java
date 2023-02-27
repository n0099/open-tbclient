package com.baidu.searchbox.v8engine.util;

import android.os.SystemClock;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes3.dex */
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

    public static int accumField(int i, int i2, boolean z, int i3) {
        int i4 = 0;
        if (i > 999) {
            while (i != 0) {
                i4++;
                i /= 10;
            }
            return i4 + i2;
        } else if (i <= 99 && (!z || i3 < 3)) {
            if (i <= 9 && (!z || i3 < 2)) {
                if (!z && i <= 0) {
                    return 0;
                }
                return i2 + 1;
            }
            return i2 + 2;
        } else {
            return i2 + 3;
        }
    }

    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j - j2, printWriter, 0);
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i)));
        }
    }

    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    public static int formatDurationLocked(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        int i7;
        boolean z3;
        int i8;
        boolean z4;
        int i9;
        int i10;
        boolean z5;
        boolean z6;
        boolean z7;
        int i11;
        long j2 = j;
        if (sFormatStr.length < i) {
            sFormatStr = new char[i];
        }
        char[] cArr = sFormatStr;
        int i12 = 0;
        int i13 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i13 == 0) {
            int i14 = i - 1;
            while (i12 < i14) {
                cArr[i12] = WebvttCueParser.CHAR_SPACE;
                i12++;
            }
            cArr[i12] = TransactionIdCreater.FILL_BYTE;
            return i12 + 1;
        }
        if (i13 > 0) {
            c = '+';
        } else {
            c = SignatureImpl.SEP;
            j2 = -j2;
        }
        int i15 = (int) (j2 % 1000);
        int floor = (int) Math.floor(j2 / 1000);
        if (floor >= 86400) {
            i2 = floor / 86400;
            floor -= 86400 * i2;
        } else {
            i2 = 0;
        }
        if (floor >= 3600) {
            i3 = floor / 3600;
            floor -= i3 * 3600;
        } else {
            i3 = 0;
        }
        if (floor >= 60) {
            int i16 = floor / 60;
            i4 = floor - (i16 * 60);
            i5 = i16;
        } else {
            i4 = floor;
            i5 = 0;
        }
        if (i != 0) {
            int accumField = accumField(i2, 1, false, 0);
            if (accumField > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            int accumField2 = accumField + accumField(i3, 1, z5, 2);
            if (accumField2 > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            int accumField3 = accumField2 + accumField(i5, 1, z6, 2);
            if (accumField3 > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            int accumField4 = accumField3 + accumField(i4, 1, z7, 2);
            if (accumField4 > 0) {
                i11 = 3;
            } else {
                i11 = 0;
            }
            i6 = 0;
            for (int accumField5 = accumField4 + accumField(i15, 2, true, i11) + 1; accumField5 < i; accumField5++) {
                cArr[i6] = WebvttCueParser.CHAR_SPACE;
                i6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c;
        int i17 = i6 + 1;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        int printFieldLocked = printFieldLocked(cArr, i2, 'd', i17, false, 0);
        if (printFieldLocked != i17) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            i7 = 2;
        } else {
            i7 = 0;
        }
        int printFieldLocked2 = printFieldLocked(cArr, i3, 'h', printFieldLocked, z2, i7);
        if (printFieldLocked2 != i17) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z) {
            i8 = 2;
        } else {
            i8 = 0;
        }
        int printFieldLocked3 = printFieldLocked(cArr, i5, 'm', printFieldLocked2, z3, i8);
        if (printFieldLocked3 != i17) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z) {
            i9 = 2;
        } else {
            i9 = 0;
        }
        int printFieldLocked4 = printFieldLocked(cArr, i4, 's', printFieldLocked3, z4, i9);
        if (z && printFieldLocked4 != i17) {
            i10 = 3;
        } else {
            i10 = 0;
        }
        int printFieldLocked5 = printFieldLocked(cArr, i15, 'm', printFieldLocked4, true, i10);
        cArr[printFieldLocked5] = 's';
        return printFieldLocked5 + 1;
    }

    public static String formatForLogging(long j) {
        if (j <= 0) {
            return "unknown";
        }
        return sLoggingFormat.format(new Date(j));
    }

    public static String logTimeOfDay(long j) {
        Calendar calendar = Calendar.getInstance();
        if (j >= 0) {
            calendar.setTimeInMillis(j);
            return String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar);
        }
        return Long.toString(j);
    }

    public static String formatUptime(long j) {
        long uptimeMillis = j - SystemClock.uptimeMillis();
        int i = (uptimeMillis > 0L ? 1 : (uptimeMillis == 0L ? 0 : -1));
        if (i > 0) {
            return j + " (in " + uptimeMillis + " ms)";
        } else if (i < 0) {
            return j + " (" + (-uptimeMillis) + " ms ago)";
        } else {
            return j + " (now)";
        }
    }

    public static int printFieldLocked(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (z || i > 0) {
            if (i > 999) {
                int i5 = 0;
                while (i != 0) {
                    char[] cArr2 = sTmpFormatStr;
                    if (i5 >= cArr2.length) {
                        break;
                    }
                    cArr2[i5] = (char) ((i % 10) + 48);
                    i5++;
                    i /= 10;
                }
                while (true) {
                    i5--;
                    if (i5 < 0) {
                        break;
                    }
                    cArr[i2] = sTmpFormatStr[i5];
                    i2++;
                }
            } else {
                if ((z && i3 >= 3) || i > 99) {
                    int i6 = i / 100;
                    cArr[i2] = (char) (i6 + 48);
                    i4 = i2 + 1;
                    i -= i6 * 100;
                } else {
                    i4 = i2;
                }
                if ((z && i3 >= 2) || i > 9 || i2 != i4) {
                    int i7 = i / 10;
                    cArr[i4] = (char) (i7 + 48);
                    i4++;
                    i -= i7 * 10;
                }
                cArr[i4] = (char) (i + 48);
                i2 = i4 + 1;
            }
            cArr[i2] = c;
            return i2 + 1;
        }
        return i2;
    }
}
