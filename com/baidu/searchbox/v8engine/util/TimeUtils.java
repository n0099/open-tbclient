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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int accumField(int i2, int i3, boolean z, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)})) == null) {
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
        return invokeCommon.intValue;
    }

    public static void formatDuration(long j2, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65542, null, j2, sb) == null) {
            synchronized (sFormatSync) {
                sb.append(sFormatStr, 0, formatDurationLocked(j2, 0));
            }
        }
    }

    public static int formatDurationLocked(long j2, int i2) {
        InterceptResult invokeCommon;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            long j3 = j2;
            if (sFormatStr.length < i2) {
                sFormatStr = new char[i2];
            }
            char[] cArr = sFormatStr;
            int i8 = 0;
            int i9 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
            if (i9 == 0) {
                int i10 = i2 - 1;
                while (i8 < i10) {
                    cArr[i8] = WebvttCueParser.CHAR_SPACE;
                    i8++;
                }
                cArr[i8] = '0';
                return i8 + 1;
            }
            if (i9 > 0) {
                c2 = '+';
            } else {
                c2 = SignatureImpl.SEP;
                j3 = -j3;
            }
            int i11 = (int) (j3 % 1000);
            int floor = (int) Math.floor(j3 / 1000);
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
                    cArr[i7] = WebvttCueParser.CHAR_SPACE;
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
        return invokeCommon.intValue;
    }

    public static String formatForLogging(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j2)) == null) ? j2 <= 0 ? "unknown" : sLoggingFormat.format(new Date(j2)) : (String) invokeJ.objValue;
    }

    public static String formatUptime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j2)) == null) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            int i2 = (uptimeMillis > 0L ? 1 : (uptimeMillis == 0L ? 0 : -1));
            if (i2 > 0) {
                return j2 + " (in " + uptimeMillis + " ms)";
            } else if (i2 < 0) {
                return j2 + " (" + (-uptimeMillis) + " ms ago)";
            } else {
                return j2 + " (now)";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String logTimeOfDay(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j2)) == null) {
            Calendar calendar = Calendar.getInstance();
            if (j2 >= 0) {
                calendar.setTimeInMillis(j2);
                return String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar);
            }
            return Long.toString(j2);
        }
        return (String) invokeJ.objValue;
    }

    public static int printFieldLocked(char[] cArr, int i2, char c2, int i3, boolean z, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{cArr, Integer.valueOf(i2), Character.valueOf(c2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)})) == null) {
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
        return invokeCommon.intValue;
    }

    public static void formatDuration(long j2, PrintWriter printWriter, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j2), printWriter, Integer.valueOf(i2)}) == null) {
            synchronized (sFormatSync) {
                printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j2, i2)));
            }
        }
    }

    public static void formatDuration(long j2, PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TRACKBALL, null, j2, printWriter) == null) {
            formatDuration(j2, printWriter, 0);
        }
    }

    public static void formatDuration(long j2, long j3, PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), printWriter}) == null) {
            if (j2 == 0) {
                printWriter.print("--");
            } else {
                formatDuration(j2 - j3, printWriter, 0);
            }
        }
    }
}
