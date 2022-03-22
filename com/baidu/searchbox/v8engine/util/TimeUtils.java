package com.baidu.searchbox.v8engine.util;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes4.dex */
public class TimeUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    public static final long NANOS_PER_MS = 1000000;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;
    public static final String TAG = "TimeUtils";
    public static char[] sFormatStr;
    public static final Object sFormatSync;
    public static SimpleDateFormat sLoggingFormat;
    public static char[] sTmpFormatStr;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1611900077, "Lcom/baidu/searchbox/v8engine/util/TimeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1611900077, "Lcom/baidu/searchbox/v8engine/util/TimeUtils;");
                return;
            }
        }
        sLoggingFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sFormatSync = new Object();
        sFormatStr = new char[29];
        sTmpFormatStr = new char[29];
    }

    public TimeUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int accumField(int i, int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
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
        return invokeCommon.intValue;
    }

    public static void formatDuration(long j, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65542, null, j, sb) == null) {
            synchronized (sFormatSync) {
                sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
            }
        }
    }

    public static int formatDurationLocked(long j, int i) {
        InterceptResult invokeCommon;
        char c2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            long j2 = j;
            if (sFormatStr.length < i) {
                sFormatStr = new char[i];
            }
            char[] cArr = sFormatStr;
            int i7 = 0;
            int i8 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i8 == 0) {
                int i9 = i - 1;
                while (i7 < i9) {
                    cArr[i7] = WebvttCueParser.CHAR_SPACE;
                    i7++;
                }
                cArr[i7] = '0';
                return i7 + 1;
            }
            if (i8 > 0) {
                c2 = '+';
            } else {
                c2 = SignatureImpl.SEP;
                j2 = -j2;
            }
            int i10 = (int) (j2 % 1000);
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
                int i11 = floor / 60;
                i4 = floor - (i11 * 60);
                i5 = i11;
            } else {
                i4 = floor;
                i5 = 0;
            }
            if (i != 0) {
                int accumField = accumField(i2, 1, false, 0);
                int accumField2 = accumField + accumField(i3, 1, accumField > 0, 2);
                int accumField3 = accumField2 + accumField(i5, 1, accumField2 > 0, 2);
                int accumField4 = accumField3 + accumField(i4, 1, accumField3 > 0, 2);
                i6 = 0;
                for (int accumField5 = accumField4 + accumField(i10, 2, true, accumField4 > 0 ? 3 : 0) + 1; accumField5 < i; accumField5++) {
                    cArr[i6] = WebvttCueParser.CHAR_SPACE;
                    i6++;
                }
            } else {
                i6 = 0;
            }
            cArr[i6] = c2;
            int i12 = i6 + 1;
            boolean z = i != 0;
            int printFieldLocked = printFieldLocked(cArr, i2, 'd', i12, false, 0);
            int printFieldLocked2 = printFieldLocked(cArr, i3, 'h', printFieldLocked, printFieldLocked != i12, z ? 2 : 0);
            int printFieldLocked3 = printFieldLocked(cArr, i5, 'm', printFieldLocked2, printFieldLocked2 != i12, z ? 2 : 0);
            int printFieldLocked4 = printFieldLocked(cArr, i4, 's', printFieldLocked3, printFieldLocked3 != i12, z ? 2 : 0);
            int printFieldLocked5 = printFieldLocked(cArr, i10, 'm', printFieldLocked4, true, (!z || printFieldLocked4 == i12) ? 0 : 3);
            cArr[printFieldLocked5] = 's';
            return printFieldLocked5 + 1;
        }
        return invokeCommon.intValue;
    }

    public static String formatForLogging(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j)) == null) ? j <= 0 ? "unknown" : sLoggingFormat.format(new Date(j)) : (String) invokeJ.objValue;
    }

    public static String formatUptime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j)) == null) {
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
        return (String) invokeJ.objValue;
    }

    public static String logTimeOfDay(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) {
            Calendar calendar = Calendar.getInstance();
            if (j >= 0) {
                calendar.setTimeInMillis(j);
                return String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar);
            }
            return Long.toString(j);
        }
        return (String) invokeJ.objValue;
    }

    public static int printFieldLocked(char[] cArr, int i, char c2, int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{cArr, Integer.valueOf(i), Character.valueOf(c2), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
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
                    if ((!z || i3 < 3) && i <= 99) {
                        i4 = i2;
                    } else {
                        int i6 = i / 100;
                        cArr[i2] = (char) (i6 + 48);
                        i4 = i2 + 1;
                        i -= i6 * 100;
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
                cArr[i2] = c2;
                return i2 + 1;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), printWriter, Integer.valueOf(i)}) == null) {
            synchronized (sFormatSync) {
                printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i)));
            }
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TRACKBALL, null, j, printWriter) == null) {
            formatDuration(j, printWriter, 0);
        }
    }

    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), printWriter}) == null) {
            if (j == 0) {
                printWriter.print("--");
            } else {
                formatDuration(j - j2, printWriter, 0);
            }
        }
    }
}
