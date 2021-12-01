package c.a.c0.i;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, str, str2)) == null) {
            if (context == null) {
                b.a();
                return false;
            }
            try {
                InputStream open = context.getAssets().open(str);
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[4096];
                    if (open == null) {
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException unused) {
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        return false;
                    }
                    while (true) {
                        int read = open.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException unused3) {
                        }
                    }
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException unused4) {
                        return true;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream2 = fileOutputStream;
                    if (b.a()) {
                        String str3 = "copyAssetsTo: destOutputStream e=" + e.toString();
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused6) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused8) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                if (b.a()) {
                    String str4 = "copyAssetsTo: sourceInputStream e=" + e4.toString();
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(File file, File file2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, file, file2)) != null) {
            return invokeLL.booleanValue;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read >= 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            fileOutputStream2.flush();
                            try {
                                fileInputStream2.close();
                                fileOutputStream2.close();
                                return true;
                            } catch (IOException unused) {
                                return true;
                            }
                        }
                    }
                } catch (FileNotFoundException unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                            return false;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return false;
                } catch (IOException unused4) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                            return false;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return false;
                } catch (Throwable th) {
                    fileInputStream = fileInputStream2;
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused6) {
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused7) {
                fileOutputStream2 = null;
            } catch (IOException unused8) {
                fileOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            }
        } catch (FileNotFoundException unused9) {
            fileOutputStream2 = null;
        } catch (IOException unused10) {
            fileOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static boolean c(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, file)) == null) {
            if (inputStream != null && file != null) {
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    return true;
                } catch (IOException unused3) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static File d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) ? new File(i(context), str) : (File) invokeLL.objValue;
    }

    public static File e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            File file = new File(f(context, str), "lib");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static File f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            File file = new File(i(context), str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static File g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) ? new File(h(context), str) : (File) invokeLL.objValue;
    }

    public static File h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            File dir = context.getDir("nps_download", 0);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            return dir;
        }
        return (File) invokeL.objValue;
    }

    public static File i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            File dir = context.getDir("nps", 0);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            return dir;
        }
        return (File) invokeL.objValue;
    }
}
