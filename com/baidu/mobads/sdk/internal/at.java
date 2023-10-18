package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class at extends av.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "local";
    public static final int b = 4000;
    public static final int c = 23;
    public static final int d = 5;
    public static final Pattern e;
    public static final char f = 9556;
    public static final char g = 9562;
    public static final char h = 9567;
    public static final char i = 9553;
    public static final String j = "════════════════════════════════════════════";
    public static final String k = "------------------------------------------";
    public static final String l = "╔════════════════════════════════════════════════════════════════════════════════════════";
    public static final String m = "╚════════════════════════════════════════════════════════════════════════════════════════";
    public static final String n = "╟------------------------------------------------------------------------------------";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.mobads.sdk.internal.av.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "local" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833693052, "Lcom/baidu/mobads/sdk/internal/at;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833693052, "Lcom/baidu/mobads/sdk/internal/at;");
                return;
            }
        }
        e = Pattern.compile("(\\$\\d+)+$");
    }

    public at() {
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

    @Override // com.baidu.mobads.sdk.internal.av.a
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String b2 = super.b();
            if (b2 != null) {
                return b2;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length <= 5) {
                return "";
            }
            return a(stackTrace[5]);
        }
        return (String) invokeV.objValue;
    }

    public static void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65538, null, i2, str, str2) == null) {
            if (i2 == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i2, str, str2);
            }
        }
    }

    public String a(StackTraceElement stackTraceElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stackTraceElement)) == null) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String substring = className.substring(className.lastIndexOf(46) + 1);
            if (substring.length() > 23 && Build.VERSION.SDK_INT < 24) {
                return substring.substring(0, 23);
            }
            return substring;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(int i2, String str, String str2, Throwable th) {
        String[] strArr;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, str2, th}) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("当前线程：");
                sb.append(Thread.currentThread().getName());
                sb.append(";  ");
                sb.append("调用位置：");
                sb.append(c());
                sb.append(";  ");
                sb.append("打印消息：");
                if (str2.length() > 4000) {
                    ArrayList arrayList = new ArrayList();
                    int length = str2.length();
                    int i3 = 0;
                    while (i3 < length) {
                        int indexOf = str2.indexOf(10, i3);
                        if (indexOf == -1) {
                            indexOf = length;
                        }
                        while (true) {
                            min = Math.min(indexOf, i3 + 4000);
                            arrayList.add(str2.substring(i3, min));
                            if (min >= indexOf) {
                                break;
                            }
                            i3 = min;
                        }
                        i3 = min + 1;
                    }
                    for (String str3 : (String[]) arrayList.toArray(new String[arrayList.size()])) {
                        a(i2, str, sb.toString() + str3);
                    }
                    return;
                }
                sb.append(str2);
                a(i2, str, sb.toString());
            } catch (Throwable th2) {
                a(6, str, th2.toString());
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z = false;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                Matcher matcher = e.matcher(className);
                if (matcher.find()) {
                    className = matcher.replaceAll("");
                }
                if (!className.equals(av.class.getName()) && !className.equals(br.class.getName())) {
                    if (z) {
                        break;
                    }
                } else {
                    z = true;
                }
                i2++;
            }
            String fileName = stackTrace[i2].getFileName();
            String methodName = stackTrace[i2].getMethodName();
            return "   (" + fileName + ":" + stackTrace[i2].getLineNumber() + ")# " + methodName;
        }
        return (String) invokeV.objValue;
    }
}
