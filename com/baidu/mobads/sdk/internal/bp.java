package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class bp {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "IOUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public bp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            try {
                a(context.getAssets().open(str), str2);
            } catch (Exception e) {
                br.a().a(e);
            }
        }
    }

    public static void a(InputStream inputStream, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, inputStream, str) == null) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    inputStream.close();
                    fileOutputStream2.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file == null) {
                return false;
            }
            try {
                if (!file.exists() || !file.canRead()) {
                    return false;
                }
                if (file.length() <= 0) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                File file = new File(str);
                if (!file.exists() || !file.canRead()) {
                    return false;
                }
                if (file.length() <= 0) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            try {
                File file = new File(str);
                File file2 = new File(str2);
                if (!file.exists()) {
                    return false;
                }
                return file.renameTo(file2);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
