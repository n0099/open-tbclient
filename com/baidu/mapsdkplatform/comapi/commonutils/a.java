package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        boolean z;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1117203753, "Lcom/baidu/mapsdkplatform/comapi/commonutils/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1117203753, "Lcom/baidu/mapsdkplatform/comapi/commonutils/a;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        a = z;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Bitmap a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, context)) == null) {
            try {
                InputStream open = context.getAssets().open(str);
                if (open != null) {
                    return BitmapFactory.decodeStream(open);
                }
                return null;
            } catch (Exception unused) {
                return BitmapFactory.decodeFile(a("assets/" + str, str, context));
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static String a(String str, String str2, Context context) {
        InterceptResult invokeLLL;
        String str3;
        ZipFile zipFile;
        File file;
        File file2;
        ZipEntry entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, context)) == null) {
            StringBuilder sb = new StringBuilder(context.getFilesDir().getAbsolutePath());
            if (a) {
                str3 = context.getPackageCodePath();
            } else {
                str3 = "";
            }
            ZipFile zipFile2 = null;
            try {
                try {
                    try {
                        zipFile = new ZipFile(str3);
                    } catch (IOException unused) {
                    }
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                int lastIndexOf = str2.lastIndexOf("/");
                if (lastIndexOf > 0) {
                    file = new File(context.getFilesDir().getAbsolutePath());
                    String substring = str2.substring(0, lastIndexOf);
                    String substring2 = str2.substring(lastIndexOf + 1, str2.length());
                    file2 = new File(file.getAbsolutePath() + "/" + substring, substring2);
                } else {
                    file = new File(context.getFilesDir(), "assets");
                    file2 = new File(file.getAbsolutePath(), str2);
                }
                file.mkdirs();
                entry = zipFile.getEntry(str);
            } catch (Exception e2) {
                e = e2;
                zipFile2 = zipFile;
                Log.e(a.class.getSimpleName(), "copyAssetsError", e);
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
            if (entry == null) {
                try {
                    zipFile.close();
                } catch (IOException unused3) {
                }
                return null;
            }
            a(zipFile.getInputStream(entry), new FileOutputStream(file2));
            sb.append("/");
            sb.append(str);
            zipFile.close();
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream, fileOutputStream) == null) {
            byte[] bArr = new byte[4096];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (IOException unused3) {
            }
        }
    }
}
