package com.baidu.ar.h;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public static String yb;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1921142857, "Lcom/baidu/ar/h/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1921142857, "Lcom/baidu/ar/h/i;");
        }
    }

    public static File a(Bitmap bitmap, File file, int i2) {
        InterceptResult invokeLLI;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, bitmap, file, i2)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                }
                return file;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return file;
        }
        return (File) invokeLLI.objValue;
    }

    public static String a(String str, Bitmap bitmap, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, str, bitmap, i2)) == null) {
            if (TextUtils.isEmpty(str) || bitmap == null) {
                return str;
            }
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdir();
            }
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                a(bitmap, file, i2);
                return file.getPath();
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLLI.objValue;
    }

    public static void a(File file, File file2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65539, null, file, file2, z) == null) && file.exists()) {
            if (z) {
                new AsyncTask<Void, Void, Void>(file, file2) { // from class: com.baidu.ar.h.i.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ File yc;
                    public final /* synthetic */ File yd;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {file, file2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.yc = file;
                        this.yd = file2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.AsyncTask
                    public Void doInBackground(Void... voidArr) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                            i.a(this.yc, this.yd, false);
                            return null;
                        }
                        return (Void) invokeL.objValue;
                    }
                }.execute(new Void[0]);
                return;
            }
            b(file2);
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file3 : listFiles) {
                if (file3.isFile()) {
                    a(file3, new File(file2, file3.getName()), Boolean.TRUE);
                } else {
                    a(file3, new File(file2, file3.getName()), false);
                }
            }
        }
    }

    public static boolean a(File file, File file2, Boolean bool) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2, bool)) == null) {
            if (file != null && file.exists() && file.isFile() && file.canRead()) {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (file2.exists() && bool.booleanValue()) {
                    file2.delete();
                }
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            k.a(fileInputStream2, fileOutputStream);
                            fileOutputStream.flush();
                            k.closeQuietly(fileInputStream2);
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            try {
                                e.printStackTrace();
                                k.closeQuietly(fileInputStream);
                                k.closeQuietly(fileOutputStream);
                                return true;
                            } catch (Throwable th) {
                                th = th;
                                k.closeQuietly(fileInputStream);
                                k.closeQuietly(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            k.closeQuietly(fileInputStream);
                            k.closeQuietly(fileOutputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
                k.closeQuietly(fileOutputStream);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, file) == null) {
            if (file.exists()) {
                if (!file.isFile()) {
                    return;
                }
                file.delete();
            }
            file.mkdirs();
        }
    }

    public static void c(File file) {
        File parentFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, file) == null) || file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            if (file != null && file.exists()) {
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static FileOutputStream e(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, file)) == null) {
            d(file);
            c(file);
            file.createNewFile();
            return new FileOutputStream(file);
        }
        return (FileOutputStream) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    public static String f(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65545, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        ?? g2 = g(file);
        FileInputStream fileInputStream2 = null;
        try {
            if (g2 != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String a = k.a(fileInputStream);
                        k.closeQuietly(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return a;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        k.closeQuietly(fileInputStream);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    k.closeQuietly(fileInputStream2);
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = g2;
        }
    }

    public static boolean g(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, file)) == null) ? file != null && file.exists() && file.isFile() : invokeL.booleanValue;
    }
}
