package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f43178a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f43179b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f43180c;

    /* renamed from: d  reason: collision with root package name */
    public static c f43181d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f43182e;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, str2, bArr)) == null) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
                return cipher.doFinal(bArr);
            }
            return (byte[]) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f43183a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(30325923, "Lcom/baidu/sofire/utility/l$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(30325923, "Lcom/baidu/sofire/utility/l$b;");
                    return;
                }
            }
            f43183a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, ExifInterface.WEBP_VP8L_SIGNATURE};
        }

        public static byte[] a(byte[] bArr) {
            InterceptResult invokeL;
            byte b2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
                int length = bArr.length;
                int i3 = (length / 4) * 3;
                if (i3 == 0) {
                    return new byte[0];
                }
                byte[] bArr2 = new byte[i3];
                int i4 = 0;
                while (true) {
                    byte b3 = bArr[length - 1];
                    b2 = 10;
                    if (b3 != 10 && b3 != 13 && b3 != 32 && b3 != 9) {
                        if (b3 != 61) {
                            break;
                        }
                        i4++;
                    }
                    length--;
                }
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (i5 < length) {
                    byte b4 = bArr[i5];
                    if (b4 != b2 && b4 != 13 && b4 != 32 && b4 != 9) {
                        if (b4 >= 65 && b4 <= 90) {
                            i2 = b4 - 65;
                        } else if (b4 >= 97 && b4 <= 122) {
                            i2 = b4 - 71;
                        } else if (b4 >= 48 && b4 <= 57) {
                            i2 = b4 + 4;
                        } else if (b4 == 43) {
                            i2 = 62;
                        } else if (b4 != 47) {
                            return null;
                        } else {
                            i2 = 63;
                        }
                        i6 = (i6 << 6) | ((byte) i2);
                        if (i8 % 4 == 3) {
                            int i9 = i7 + 1;
                            bArr2[i7] = (byte) ((i6 & 16711680) >> 16);
                            int i10 = i9 + 1;
                            bArr2[i9] = (byte) ((i6 & 65280) >> 8);
                            bArr2[i10] = (byte) (i6 & 255);
                            i7 = i10 + 1;
                        }
                        i8++;
                    }
                    i5++;
                    b2 = 10;
                }
                if (i4 > 0) {
                    int i11 = i6 << (i4 * 6);
                    int i12 = i7 + 1;
                    bArr2[i7] = (byte) ((i11 & 16711680) >> 16);
                    if (i4 == 1) {
                        i7 = i12 + 1;
                        bArr2[i12] = (byte) ((i11 & 65280) >> 8);
                    } else {
                        i7 = i12;
                    }
                }
                byte[] bArr3 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr3, 0, i7);
                return bArr3;
            }
            return (byte[]) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f43184a;

        /* renamed from: b  reason: collision with root package name */
        public String f43185b;

        public c() {
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

        public static c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString(DeviceUtils.KEY_OLD_NAME_STRING);
                    String string2 = jSONObject.getString("imei");
                    if (!TextUtils.isEmpty(string) && string2 != null) {
                        c cVar = new c();
                        cVar.f43184a = string;
                        cVar.f43185b = string2;
                        return cVar;
                    }
                    return null;
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    String str = this.f43185b;
                    if (TextUtils.isEmpty(str)) {
                        str = "0";
                    }
                    String stringBuffer = new StringBuffer(str).reverse().toString();
                    return this.f43184a + "|" + stringBuffer;
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.reset();
                    messageDigest.update(bArr);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        sb.append("");
                    }
                    return sb.toString();
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(e2);
                }
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1443542239, "Lcom/baidu/sofire/utility/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1443542239, "Lcom/baidu/sofire/utility/l;");
                return;
            }
        }
        f43178a = new String(b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        f43179b = new String(b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
        f43180c = f43178a + f43179b;
    }

    public l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43182e = context;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            try {
                return u.b(this.f43182e) ? Settings.System.getString(this.f43182e.getContentResolver(), str) : "";
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized c b(Context context) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (l.class) {
                if (f43181d == null) {
                    f43181d = new l(context).a();
                }
                cVar = f43181d;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    private c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            try {
                String a2 = a(com.baidu.sofire.utility.c.e("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                String a3 = a(com.baidu.sofire.utility.c.e("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                if (TextUtils.isEmpty(a3)) {
                    a3 = c("");
                }
                if (TextUtils.isEmpty(a2)) {
                    String i2 = u.i(this.f43182e);
                    a2 = a(d.a((com.baidu.sofire.utility.c.e("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + a3 + i2).getBytes()));
                }
                if (TextUtils.isEmpty(a2)) {
                    return null;
                }
                c cVar = new c((byte) 0);
                cVar.f43184a = a2;
                cVar.f43185b = a3;
                return cVar;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
        return (c) invokeV.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(a.a(f43180c, f43180c, b.a(str.getBytes())));
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            try {
                fileReader = new FileReader(file);
            } catch (Throwable unused) {
                fileReader = null;
            }
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, read);
                }
                String charArrayWriter2 = charArrayWriter.toString();
                try {
                    fileReader.close();
                } catch (Throwable unused2) {
                    com.baidu.sofire.utility.c.a();
                }
                return charArrayWriter2;
            } catch (Throwable unused3) {
                try {
                    com.baidu.sofire.utility.c.a();
                    return null;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused4) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                }
            }
        }
        return (String) invokeL.objValue;
    }

    private c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (u.c(this.f43182e)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, com.baidu.sofire.utility.c.e("_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J") + "/" + com.baidu.sofire.utility.c.e("idzo8hWEQF2c4tBTa5WOlQMU8UU8Wq-86X4X9ljayiU="));
                if (file.exists()) {
                    String a2 = a(file);
                    if (!TextUtils.isEmpty(a2)) {
                        return c.a(new String(a.a(f43180c, f43180c, b.a(a2.getBytes()))));
                    }
                }
                return null;
            }
            return null;
        }
        return (c) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                c b2 = b(context);
                return b2 != null ? b2.a() : "";
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private c b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            boolean z = Build.VERSION.SDK_INT < 23;
            if (!(z && TextUtils.isEmpty(str)) && u.c(this.f43182e)) {
                String str2 = "";
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, com.baidu.sofire.utility.c.e("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + com.baidu.sofire.utility.c.e("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
                if (!file.exists()) {
                    File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
                    file = new File(externalStorageDirectory2, com.baidu.sofire.utility.c.e("_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J") + "/" + com.baidu.sofire.utility.c.e("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append(Part.CRLF);
                    }
                    bufferedReader.close();
                    String[] split = new String(a.a(f43180c, f43180c, b.a(sb.toString().getBytes()))).split("=");
                    if (split != null && split.length == 2) {
                        if (z && str.equals(split[0])) {
                            str2 = split[1];
                        } else if (!z) {
                            if (TextUtils.isEmpty(str)) {
                                str = split[1];
                            }
                            str2 = split[1];
                        }
                    }
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                c cVar = new c((byte) 0);
                cVar.f43184a = str2;
                cVar.f43185b = str;
                return cVar;
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? TextUtils.isEmpty("0") ? str : "0" : (String) invokeL.objValue;
    }

    private c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                File file = new File(this.f43182e.getFilesDir(), com.baidu.sofire.utility.c.e("K5j7Snuat7HHCaEg62XaRa41Ukv_4vtSH9Z4FqXi1Fs="));
                c a2 = file.exists() ? c.a(d(a(file))) : null;
                if (a2 != null) {
                    return a2;
                }
                c a3 = c.a(d(a(com.baidu.sofire.utility.c.e("FLI7RPHK558lhmIMdK5V1-nh-gfSlVAFvUdffcjh8sgAXO2nb2l_YXWA6lX6geWt"))));
                if (a3 != null) {
                    return a3;
                }
                boolean z = this.f43182e.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0;
                if (z) {
                    a3 = b();
                }
                if (a3 != null) {
                    return a3;
                }
                c c2 = c();
                return (c2 == null && z) ? b(c("")) : c2;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
        return (c) invokeV.objValue;
    }
}
