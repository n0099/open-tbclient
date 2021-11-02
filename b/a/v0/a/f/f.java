package b.a.v0.a.f;

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
/* loaded from: classes6.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String[] f29145a;

    /* renamed from: b  reason: collision with root package name */
    public static File f29146b;

    /* renamed from: c  reason: collision with root package name */
    public static RandomAccessFile f29147c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(974465498, "Lb/a/v0/a/f/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(974465498, "Lb/a/v0/a/f/f;");
                return;
            }
        }
        f29145a = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            File file = new File(str);
            f29146b = file;
            return file.exists();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            File file = new File(str);
            f29146b = file;
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
                return b.a.v0.a.c.h().getContext().checkCallingOrSelfPermission(f29145a[0]) == 0 && externalStorageState.equals("mounted");
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
                        f29146b = new File(str2 + str3);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(f29146b, "rwd");
                        f29147c = randomAccessFile;
                        randomAccessFile.seek(f29146b.length());
                        f29147c.write((str + Part.CRLF).getBytes("UTF-8"));
                        f29147c.close();
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
                            f29146b = new File(str + str2);
                            f29147c = new RandomAccessFile(f29146b, r.f40168a);
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = f29147c.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8"));
                                stringBuffer.append(",");
                            }
                            String stringBuffer2 = stringBuffer.toString();
                            try {
                                f29147c.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return stringBuffer2;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            try {
                                f29147c.close();
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
                f29146b = new File(str);
                if (!a(str)) {
                    f29146b.mkdirs();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                File file = new File(str + str2);
                f29146b = file;
                if (file.exists()) {
                    return true;
                }
                return f29146b.createNewFile();
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
