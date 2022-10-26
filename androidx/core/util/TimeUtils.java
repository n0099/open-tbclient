package androidx.core.util;

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
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes.dex */
public final class TimeUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;
    public static char[] sFormatStr;
    public static final Object sFormatSync;
    public transient /* synthetic */ FieldHolder $fh;

    public static int accumField(int i, int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
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
        return invokeCommon.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1800325554, "Landroidx/core/util/TimeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1800325554, "Landroidx/core/util/TimeUtils;");
                return;
            }
        }
        sFormatSync = new Object();
        sFormatStr = new char[24];
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

    public static void formatDuration(long j, PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TRACKBALL, null, j, printWriter) == null) {
            formatDuration(j, printWriter, 0);
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), printWriter, Integer.valueOf(i)}) == null) {
            synchronized (sFormatSync) {
                printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i)));
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            long j2 = j;
            if (sFormatStr.length < i) {
                sFormatStr = new char[i];
            }
            char[] cArr = sFormatStr;
            int i12 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i12 == 0) {
                int i13 = i - 1;
                while (i13 > 0) {
                    cArr[0] = WebvttCueParser.CHAR_SPACE;
                }
                cArr[0] = '0';
                return 1;
            }
            if (i12 > 0) {
                c = '+';
            } else {
                c = SignatureImpl.SEP;
                j2 = -j2;
            }
            int i14 = (int) (j2 % 1000);
            int floor = (int) Math.floor(j2 / 1000);
            if (floor > 86400) {
                i2 = floor / 86400;
                floor -= 86400 * i2;
            } else {
                i2 = 0;
            }
            if (floor > 3600) {
                i3 = floor / 3600;
                floor -= i3 * 3600;
            } else {
                i3 = 0;
            }
            if (floor > 60) {
                int i15 = floor / 60;
                i4 = floor - (i15 * 60);
                i5 = i15;
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
                for (int accumField5 = accumField4 + accumField(i14, 2, true, i11) + 1; accumField5 < i; accumField5++) {
                    cArr[i6] = WebvttCueParser.CHAR_SPACE;
                    i6++;
                }
            } else {
                i6 = 0;
            }
            cArr[i6] = c;
            int i16 = i6 + 1;
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            int printField = printField(cArr, i2, 'd', i16, false, 0);
            if (printField != i16) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            int printField2 = printField(cArr, i3, 'h', printField, z2, i7);
            if (printField2 != i16) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z) {
                i8 = 2;
            } else {
                i8 = 0;
            }
            int printField3 = printField(cArr, i5, 'm', printField2, z3, i8);
            if (printField3 != i16) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z) {
                i9 = 2;
            } else {
                i9 = 0;
            }
            int printField4 = printField(cArr, i4, 's', printField3, z4, i9);
            if (z && printField4 != i16) {
                i10 = 3;
            } else {
                i10 = 0;
            }
            int printField5 = printField(cArr, i14, 'm', printField4, true, i10);
            cArr[printField5] = 's';
            return printField5 + 1;
        }
        return invokeCommon.intValue;
    }

    public static int printField(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{cArr, Integer.valueOf(i), Character.valueOf(c), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
            if (z || i > 0) {
                if ((z && i3 >= 3) || i > 99) {
                    int i5 = i / 100;
                    cArr[i2] = (char) (i5 + 48);
                    i4 = i2 + 1;
                    i -= i5 * 100;
                } else {
                    i4 = i2;
                }
                if ((z && i3 >= 2) || i > 9 || i2 != i4) {
                    int i6 = i / 10;
                    cArr[i4] = (char) (i6 + 48);
                    i4++;
                    i -= i6 * 10;
                }
                cArr[i4] = (char) (i + 48);
                int i7 = i4 + 1;
                cArr[i7] = c;
                return i7 + 1;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }
}
