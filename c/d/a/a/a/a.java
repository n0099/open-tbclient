package c.d.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.duxiaoman.dxmpay.statistics.StatApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) StatApi.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    String typeName = activeNetworkInfo.getTypeName();
                    return (typeName.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            try {
                byte[] l = l(context, str);
                if (l != null) {
                    return new String(l, "utf-8");
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String c(boolean z, Context context, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), context, str})) == null) {
            if (context == null) {
                return null;
            }
            if (z) {
                return n(context, str);
            }
            return b(context, str);
        }
        return (String) invokeCommon.objValue;
    }

    public static String d(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static String e(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return d(messageDigest.digest(), "", z);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static void f(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
            if (fileOutputStream != null) {
                fileOutputStream.write(str2.getBytes("utf-8"));
            }
            if (fileOutputStream == null) {
                return;
            }
        } catch (Exception unused) {
            if (0 == 0) {
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            fileOutputStream.close();
        } catch (Exception unused3) {
        }
    }

    public static void g(boolean z, Context context, String str, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), context, str, str2, Boolean.valueOf(z2)}) == null) || context == null) {
            return;
        }
        if (z) {
            j(context, str, str2, z2);
        } else {
            f(context, str, str2, z2);
        }
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            NetworkInfo m = m(context);
            return m != null && m.isConnected();
        }
        return invokeL.booleanValue;
    }

    public static boolean i(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (context == null) {
                return false;
            }
            if (z) {
                String externalStorageState = Environment.getExternalStorageState();
                if ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    StringBuilder sb = new StringBuilder();
                    sb.append(externalStorageDirectory);
                    sb.append(File.separator);
                    sb.append(com.baidu.fsg.base.statistics.a.f34734b);
                    sb.append(File.separator);
                    sb.append(context.getPackageName());
                    sb.append(File.separator);
                    sb.append(str);
                    return new File(sb.toString()).exists();
                }
                return false;
            }
            return context.getFileStreamPath(str).exists();
        }
        return invokeCommon.booleanValue;
    }

    public static void j(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) && "mounted".equals(Environment.getExternalStorageState())) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    StringBuilder sb = new StringBuilder();
                    sb.append(externalStorageDirectory);
                    sb.append(File.separator);
                    sb.append(com.baidu.fsg.base.statistics.a.f34734b);
                    sb.append(File.separator);
                    sb.append(context.getPackageName());
                    sb.append(File.separator);
                    String sb2 = sb.toString();
                    File file = new File(sb2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(sb2 + str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2, z);
                    try {
                        fileOutputStream2.write(Base64.encode(str2.getBytes("utf-8"), 2));
                        fileOutputStream2.close();
                    } catch (FileNotFoundException unused) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused4) {
                }
            } catch (FileNotFoundException unused5) {
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            NetworkInfo m = m(context);
            return m != null && m.isConnected() && 1 == m.getType();
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
        r1 = r0;
        r0 = r4;
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0039, code lost:
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] l(Context context, String str) {
        InterceptResult invokeLL;
        byte[] bArr;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65547, null, context, str)) != null) {
            return (byte[]) invokeLL.objValue;
        }
        FileInputStream fileInputStream2 = null;
        r0 = null;
        r0 = null;
        byte[] bArr2 = null;
        r0 = null;
        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream = context.openFileInput(str);
            if (fileInputStream != null) {
                try {
                    bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                } catch (FileNotFoundException unused) {
                    byte[] bArr3 = bArr2;
                    fileInputStream3 = fileInputStream;
                    bArr = bArr3;
                } catch (IOException unused2) {
                    byte[] bArr4 = bArr2;
                    fileInputStream3 = fileInputStream;
                    bArr = bArr4;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            if (fileInputStream == null) {
                return bArr2;
            }
        } catch (FileNotFoundException unused4) {
            bArr = null;
        } catch (IOException unused5) {
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused6) {
            return bArr2;
        }
    }

    public static NetworkInfo m(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return null;
            }
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception e2) {
                StatApi.getInstance();
                StatApi.onEvent("Exception_On_getActiveNetworkInfo" + e2.toString());
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static String n(Context context, String str) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory + File.separator + com.baidu.fsg.base.statistics.a.f34734b + File.separator + context.getPackageName() + File.separator + str);
                if (file.exists()) {
                    FileInputStream fileInputStream2 = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (FileNotFoundException unused) {
                    } catch (IOException unused2) {
                    } catch (IllegalArgumentException unused3) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        String str2 = new String(Base64.decode(bArr, 2), "utf-8");
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                        return str2;
                    } catch (FileNotFoundException unused5) {
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 == null) {
                            return "";
                        }
                        try {
                            fileInputStream2.close();
                            return "";
                        } catch (IOException unused6) {
                            return "";
                        }
                    } catch (IOException unused7) {
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 == null) {
                            return "";
                        }
                        fileInputStream2.close();
                        return "";
                    } catch (IllegalArgumentException unused8) {
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 == null) {
                            return "";
                        }
                        fileInputStream2.close();
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused9) {
                            }
                        }
                        throw th;
                    }
                }
                return "";
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }
}
