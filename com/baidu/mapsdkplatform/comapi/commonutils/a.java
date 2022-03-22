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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
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
        a = Build.VERSION.SDK_INT >= 8;
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
                return BitmapFactory.decodeFile(b("assets/" + str, str, context));
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, inputStream, fileOutputStream) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:43:0x009b A[Catch: IOException -> 0x0097, TRY_LEAVE, TryCatch #2 {IOException -> 0x0097, blocks: (B:39:0x0093, B:43:0x009b), top: B:53:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, String str2, Context context) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, context) != null) {
            return;
        }
        InputStream inputStream = null;
        FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        try {
            try {
                InputStream open = context.getAssets().open(str);
                if (open != null) {
                    try {
                        byte[] bArr = new byte[open.available()];
                        open.read(bArr);
                        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + str2);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(bArr);
                            fileOutputStream.close();
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception unused) {
                            inputStream = open;
                            try {
                                b("assets/" + str, str2, context);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = open;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception unused2) {
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                }
                if (open != null) {
                    open.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static String b(String str, String str2, Context context) {
        InterceptResult invokeLLL;
        ZipFile zipFile;
        File file;
        File file2;
        ZipEntry entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, context)) == null) {
            StringBuilder sb = new StringBuilder(context.getFilesDir().getAbsolutePath());
            ZipFile zipFile2 = null;
            try {
                try {
                    try {
                        zipFile = new ZipFile(a ? context.getPackageCodePath() : "");
                    } catch (IOException unused) {
                    }
                } catch (Exception e2) {
                    e = e2;
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
            } catch (Exception e3) {
                e = e3;
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
}
