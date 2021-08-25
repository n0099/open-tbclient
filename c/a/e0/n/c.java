package c.a.e0.n;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                return sb.toString();
            }
        }
    }

    public static void b(String str, File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, file) == null) || TextUtils.isEmpty(str) || file == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                c(fileOutputStream2);
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                c(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                c(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void c(Closeable... closeableArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeableArr) == null) || closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static String d(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String a2 = a(fileInputStream);
                c(fileInputStream);
                return a2;
            } catch (Exception unused) {
                c(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                c(fileInputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
