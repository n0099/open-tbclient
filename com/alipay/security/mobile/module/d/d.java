package com.alipay.security.mobile.module.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f35966a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f35967b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f35968c = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-920817348, "Lcom/alipay/security/mobile/module/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-920817348, "Lcom/alipay/security/mobile/module/d/d;");
        }
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            synchronized (d.class) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                a(arrayList);
            }
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            synchronized (d.class) {
                f35966a = str;
                f35967b = str2;
                f35968c = str3;
            }
        }
    }

    public static synchronized void a(Throwable th) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, th) == null) {
            synchronized (d.class) {
                ArrayList arrayList = new ArrayList();
                if (th != null) {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    str = stringWriter.toString();
                } else {
                    str = "";
                }
                arrayList.add(str);
                a(arrayList);
            }
        }
    }

    public static synchronized void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) {
            synchronized (d.class) {
                if (!com.alipay.security.mobile.module.a.a.a(f35967b) && !com.alipay.security.mobile.module.a.a.a(f35968c)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(f35968c);
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR + it.next());
                    }
                    stringBuffer.append(StringUtils.LF);
                    try {
                        File file = new File(f35966a);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(f35966a, f35967b);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                        fileWriter.write(stringBuffer.toString());
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
