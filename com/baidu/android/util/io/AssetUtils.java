package com.baidu.android.util.io;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public final class AssetUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "AssetUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public AssetUtils() {
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

    public static boolean exists(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            boolean z = false;
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    InputStream open = context.getAssets().open(str, 0);
                    z = true;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean extractFileFromAsset(AssetManager assetManager, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, assetManager, str, str2)) == null) {
            boolean z = false;
            try {
                z = StreamUtils.streamToFile(assetManager.open(str, 0), new File(str2));
                if (!z) {
                    new File(str2).delete();
                }
            } catch (IOException unused) {
            }
            return z;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006d A[EDGE_INSN: B:35:0x006d->B:23:0x006d ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean extractFolderFromAsset(AssetManager assetManager, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, assetManager, str, str2)) == null) {
            try {
                String[] list = assetManager.list(str);
                if (list != null) {
                    boolean z = false;
                    for (String str3 : list) {
                        try {
                            if (!TextUtils.isEmpty(str3)) {
                                String str4 = str + File.separator + str3;
                                String[] list2 = assetManager.list(str4);
                                if (list2 != null && list2.length != 0) {
                                    z = extractFolderFromAsset(assetManager, str4, str2 + File.separator + str3);
                                    if (z) {
                                        break;
                                    }
                                }
                                z = extractFileFromAsset(assetManager, str4, str2 + File.separator + str3);
                                if (z) {
                                }
                            }
                        } catch (IOException unused) {
                        }
                    }
                    return z;
                }
                return false;
            } catch (IOException unused2) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    @Deprecated
    public static String loadAssetsFile(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) ? loadFile(context, str) : (String) invokeLL.objValue;
    }

    public static String loadFile(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            InputStream inputStream2 = null;
            r0 = null;
            String str2 = null;
            try {
                inputStream = context.getAssets().open(str);
            } catch (IOException unused) {
                inputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            if (inputStream == null) {
                Closeables.closeSafely(inputStream);
                return null;
            }
            try {
                str2 = StreamUtils.streamToString(inputStream);
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                Closeables.closeSafely(inputStream2);
                throw th;
            }
            Closeables.closeSafely(inputStream);
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String readAsset(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            InputStream inputStream2 = null;
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    inputStream = context.getAssets().open(str);
                } catch (IOException unused) {
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    String readInputStream = FileUtils.readInputStream(inputStream);
                    Closeables.closeSafely(inputStream);
                    return readInputStream;
                } catch (IOException unused2) {
                    Closeables.closeSafely(inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    Closeables.closeSafely(inputStream2);
                    throw th;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean unzipFileFromAsset(String str, String str2, Context context) {
        InterceptResult invokeLLL;
        ZipInputStream zipInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, context)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                InputStream inputStream = null;
                try {
                    InputStream open = context.getApplicationContext().getAssets().open(str);
                    try {
                        zipInputStream = new ZipInputStream(open);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                ZipEntry nextEntry = zipInputStream.getNextEntry();
                                if (nextEntry != null) {
                                    if (!nextEntry.getName().contains("../")) {
                                        File file2 = new File(str2 + File.separator + nextEntry.getName());
                                        if (nextEntry.isDirectory()) {
                                            if (!file2.exists()) {
                                                file2.mkdir();
                                            }
                                        } else if (file2.exists()) {
                                            continue;
                                        } else {
                                            FileUtils.createFileSafely(file2);
                                            try {
                                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), 2048);
                                                while (true) {
                                                    try {
                                                        int read = zipInputStream.read(bArr);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        bufferedOutputStream.write(bArr, 0, read);
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        inputStream = bufferedOutputStream;
                                                        Closeables.closeSafely(inputStream);
                                                        throw th;
                                                    }
                                                }
                                                Closeables.closeSafely(bufferedOutputStream);
                                                inputStream = bufferedOutputStream;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                    }
                                } else {
                                    Closeables.closeSafely(open);
                                    Closeables.closeSafely(zipInputStream);
                                    return true;
                                }
                            }
                        } catch (IOException unused) {
                            inputStream = open;
                            Closeables.closeSafely(inputStream);
                            Closeables.closeSafely(zipInputStream);
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = open;
                            Closeables.closeSafely(inputStream);
                            Closeables.closeSafely(zipInputStream);
                            throw th;
                        }
                    } catch (IOException unused2) {
                        zipInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        zipInputStream = null;
                    }
                } catch (IOException unused3) {
                    zipInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    zipInputStream = null;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
