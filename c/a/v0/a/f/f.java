package c.a.v0.a.f;

import android.os.Build;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String[] f30372a;

    /* renamed from: b  reason: collision with root package name */
    public static File f30373b;

    /* renamed from: c  reason: collision with root package name */
    public static RandomAccessFile f30374c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(681062491, "Lc/a/v0/a/f/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(681062491, "Lc/a/v0/a/f/f;");
                return;
            }
        }
        f30372a = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            File file = new File(str);
            f30373b = file;
            return file.exists();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            File file = new File(str);
            f30373b = file;
            return file.delete();
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            if (Build.VERSION.SDK_INT >= 23) {
                return c.a.v0.a.c.i().g().checkCallingOrSelfPermission(f30372a[0]) == 0 && externalStorageState.equals("mounted");
            }
            return externalStorageState.equals("mounted");
        }
        return invokeV.booleanValue;
    }

    public static synchronized boolean d(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            synchronized (f.class) {
                if (c() && f(str2, str3)) {
                    try {
                        f30373b = new File(str2 + str3);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(f30373b, "rwd");
                        f30374c = randomAccessFile;
                        randomAccessFile.seek(f30373b.length());
                        f30374c.write((str + Part.CRLF).getBytes("UTF-8"));
                        f30374c.close();
                        return true;
                    } catch (Exception e2) {
                        i.e(e2);
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static synchronized String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            synchronized (f.class) {
                if (c()) {
                    if (a(str + str2)) {
                        try {
                            f30373b = new File(str + str2);
                            f30374c = new RandomAccessFile(f30373b, r.f42342a);
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = f30374c.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8"));
                                stringBuffer.append(",");
                            }
                            String stringBuffer2 = stringBuffer.toString();
                            try {
                                f30374c.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return stringBuffer2;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            try {
                                f30374c.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                    return "";
                }
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            try {
                f30373b = new File(str);
                if (!a(str)) {
                    f30373b.mkdirs();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                File file = new File(str + str2);
                f30373b = file;
                if (file.exists()) {
                    return true;
                }
                return f30373b.createNewFile();
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
