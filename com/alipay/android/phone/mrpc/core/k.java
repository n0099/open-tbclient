package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f31134b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f31135b;

        /* renamed from: c  reason: collision with root package name */
        public int f31136c;

        public a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f31135b = i3;
            this.f31136c = i4;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-834063211, "Lcom/alipay/android/phone/mrpc/core/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-834063211, "Lcom/alipay/android/phone/mrpc/core/k;");
                return;
            }
        }
        a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
        f31134b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
    }

    public static long a(String str) {
        InterceptResult invokeL;
        int c2;
        int d2;
        int i2;
        a aVar;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Matcher matcher = a.matcher(str);
            if (matcher.find()) {
                i2 = b(matcher.group(1));
                c2 = c(matcher.group(2));
                d2 = d(matcher.group(3));
                aVar = e(matcher.group(4));
            } else {
                Matcher matcher2 = f31134b.matcher(str);
                if (!matcher2.find()) {
                    throw new IllegalArgumentException();
                }
                c2 = c(matcher2.group(1));
                int b2 = b(matcher2.group(2));
                a e2 = e(matcher2.group(3));
                d2 = d(matcher2.group(4));
                i2 = b2;
                aVar = e2;
            }
            if (d2 >= 2038) {
                i3 = 1;
                i4 = 0;
                i5 = SpeedStatsStampTable.INIT_MSG_SIX_STAMP_KEY;
            } else {
                i3 = i2;
                i4 = c2;
                i5 = d2;
            }
            Time time = new Time("UTC");
            time.set(aVar.f31136c, aVar.f31135b, aVar.a, i3, i4, i5);
            return time.toMillis(false);
        }
        return invokeL.longValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0' : invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
            if (lowerCase != 9) {
                if (lowerCase != 10) {
                    if (lowerCase != 22) {
                        if (lowerCase != 26) {
                            if (lowerCase != 29) {
                                if (lowerCase != 32) {
                                    if (lowerCase != 40) {
                                        if (lowerCase != 42) {
                                            if (lowerCase != 48) {
                                                switch (lowerCase) {
                                                    case 35:
                                                        return 9;
                                                    case 36:
                                                        return 4;
                                                    case 37:
                                                        return 8;
                                                    default:
                                                        throw new IllegalArgumentException();
                                                }
                                            }
                                            return 10;
                                        }
                                        return 5;
                                    }
                                    return 6;
                                }
                                return 3;
                            }
                            return 2;
                        }
                        return 7;
                    }
                    return 0;
                }
                return 1;
            }
            return 11;
        }
        return invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str.length() == 2) {
                int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
                return charAt >= 70 ? charAt + 1900 : charAt + 2000;
            } else if (str.length() == 3) {
                return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
            } else {
                if (str.length() == 4) {
                    return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
                }
                return 1970;
            }
        }
        return invokeL.intValue;
    }

    public static a e(String str) {
        InterceptResult invokeL;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            int charAt = str.charAt(0) - '0';
            if (str.charAt(1) != ':') {
                i2 = 2;
                charAt = (charAt * 10) + (str.charAt(1) - '0');
            } else {
                i2 = 1;
            }
            int i5 = i2 + 1 + 1 + 1 + 1;
            return new a(charAt, ((str.charAt(i3) - '0') * 10) + (str.charAt(i4) - '0'), ((str.charAt(i5) - '0') * 10) + (str.charAt(i5 + 1) - '0'));
        }
        return (a) invokeL.objValue;
    }
}
