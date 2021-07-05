package com.baidu.apollon.statistics;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.format.Formatter;
import android.util.Base64;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f3952a = "utf-8";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3953b = "c82c403505338808201aad86f8194734";
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(boolean z, Context context, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), context, str})) == null) {
            if (context == null) {
                return null;
            }
            if (z) {
                return c(context, str);
            }
            return a(context, str);
        }
        return (String) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0032, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(Context context, String str) {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65549, null, context, str)) != null) {
            return (byte[]) invokeLL.objValue;
        }
        FileInputStream fileInputStream = null;
        r0 = null;
        r0 = null;
        byte[] bArr2 = null;
        r0 = null;
        FileInputStream fileInputStream2 = null;
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            if (openFileInput != null) {
                try {
                    bArr2 = new byte[openFileInput.available()];
                    openFileInput.read(bArr2);
                } catch (FileNotFoundException unused) {
                    byte[] bArr3 = bArr2;
                    fileInputStream2 = openFileInput;
                    bArr = bArr3;
                } catch (IOException unused2) {
                    byte[] bArr4 = bArr2;
                    fileInputStream2 = openFileInput;
                    bArr = bArr4;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = openFileInput;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            if (openFileInput != null) {
                try {
                    openFileInput.close();
                    return bArr2;
                } catch (IOException unused4) {
                    return bArr2;
                }
            }
            return bArr2;
        } catch (FileNotFoundException unused5) {
            bArr = null;
        } catch (IOException unused6) {
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return bArr;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        File externalFilesDir;
        FileInputStream fileInputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65551, null, context, str)) != null) {
            return (String) invokeLL.objValue;
        }
        if (context == null || (externalFilesDir = context.getExternalFilesDir("")) == null) {
            return "";
        }
        File file = new File(externalFilesDir + File.separator + "c82c403505338808201aad86f8194734" + File.separator + str);
        if (!file.exists()) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str2 = new String(Base64.decode(bArr, 2), "utf-8");
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return str2;
            } catch (FileNotFoundException unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 == null) {
                    return "";
                }
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                    return "";
                }
            } catch (IOException unused4) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 == null) {
                    return "";
                }
                fileInputStream2.close();
            } catch (IllegalArgumentException unused5) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 == null) {
                    return "";
                }
                fileInputStream2.close();
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused7) {
        } catch (IOException unused8) {
        } catch (IllegalArgumentException unused9) {
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static void a(boolean z, Context context, String str, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), context, str, str2, Boolean.valueOf(z2)}) == null) || context == null) {
            return;
        }
        if (z) {
            b(context, str, str2, z2);
        } else {
            a(context, str, str2, z2);
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) || context == null) {
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
            if (fileOutputStream == null) {
                return;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
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

    public static void b(Context context, String str, String str2, boolean z) {
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) && "mounted".equals(Environment.getExternalStorageState())) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    externalFilesDir = context.getExternalFilesDir("");
                } catch (IOException unused) {
                    return;
                }
            } catch (FileNotFoundException unused2) {
            } catch (IOException unused3) {
            } catch (Throwable th) {
                th = th;
            }
            if (externalFilesDir == null) {
                return;
            }
            String str3 = externalFilesDir + File.separator + "c82c403505338808201aad86f8194734" + File.separator;
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str3 + str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2, z);
            try {
                fileOutputStream2.write(Base64.encode(str2.getBytes("utf-8"), 2));
                fileOutputStream2.close();
            } catch (FileNotFoundException unused4) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream == null) {
                    return;
                }
                fileOutputStream.close();
            } catch (IOException unused5) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream == null) {
                    return;
                }
                fileOutputStream.close();
            } catch (Throwable th2) {
                fileOutputStream = fileOutputStream2;
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        }
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            try {
                byte[] b2 = b(context, str);
                return b2 != null ? new String(b2, "utf-8") : "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (context == null) {
                return false;
            }
            if (z) {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir == null) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(externalFilesDir);
                sb.append(File.separator);
                sb.append("c82c403505338808201aad86f8194734");
                sb.append(File.separator);
                sb.append(str);
                return new File(sb.toString()).exists();
            }
            return context.getFileStreamPath(str).exists();
        }
        return invokeCommon.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            long j = 0;
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                j = Long.valueOf(bufferedReader.readLine().split("\\s+")[1]).longValue() * 1024;
                bufferedReader.close();
            } catch (IOException unused) {
            }
            return Formatter.formatFileSize(context, j);
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory + File.separator + str);
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, bArr, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return a(messageDigest.digest(), "", z);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return Formatter.formatFileSize(context, memoryInfo.availMem) + "_" + memoryInfo.lowMemory + "_" + Formatter.formatFileSize(context, memoryInfo.threshold);
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65540, null, bArr, str, z)) == null) {
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

    public static boolean a(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isAvailable()) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e2) {
                PayStatisticsUtil.getInstance();
                PayStatisticsUtil.onEvent("Exception_On_getActiveNetworkInfo" + e2.toString());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) PayStatisticsUtil.c().getSystemService("connectivity")).getActiveNetworkInfo();
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
}
