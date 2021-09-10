package c.a.v0.a.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes4.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f30354a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30355b = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(681062584, "Lc/a/v0/a/f/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(681062584, "Lc/a/v0/a/f/i;");
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, str) == null) && f30355b) {
            c(2, "BaiDuAbSDK", str, null);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && f30355b) {
            c(5, "BaiDuAbSDK", str, null);
        }
    }

    public static void c(int i2, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), str, str2, th}) == null) {
            if (!TextUtils.isEmpty(str2)) {
                int length = str2.length();
                int i3 = f30354a;
                if (length >= i3) {
                    if (i2 == 1) {
                        str2.substring(0, i3);
                    } else if (i2 == 2) {
                        str2.substring(0, i3);
                    } else if (i2 == 3) {
                        str2.substring(0, i3);
                    } else if (i2 == 4) {
                        str2.substring(0, i3);
                    } else if (i2 == 5) {
                        str2.substring(0, i3);
                    }
                }
            }
            if (th != null) {
                TextUtils.isEmpty(f(th));
            }
        }
    }

    public static void d(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th) == null) && f30355b) {
            c(2, "BaiDuAbSDK", "", th);
        }
    }

    public static void e(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, th) == null) && f30355b) {
            c(4, "BaiDuAbSDK", "", th);
        }
    }

    public static String f(Throwable th) {
        InterceptResult invokeL;
        PrintWriter printWriter;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, th)) != null) {
            return (String) invokeL.objValue;
        }
        StringWriter stringWriter = null;
        try {
            StringWriter stringWriter2 = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    stringWriter2.flush();
                    String stringWriter3 = stringWriter2.toString();
                    try {
                        stringWriter2.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    printWriter.close();
                    return stringWriter3;
                } catch (Throwable th3) {
                    th = th3;
                    stringWriter = stringWriter2;
                    try {
                        th.printStackTrace();
                        return "";
                    } finally {
                        if (stringWriter != null) {
                            try {
                                stringWriter.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        if (printWriter != null) {
                            printWriter.close();
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                printWriter = null;
            }
        } catch (Throwable th6) {
            th = th6;
            printWriter = null;
        }
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            f30355b = z;
        }
    }
}
