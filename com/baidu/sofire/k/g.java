package com.baidu.sofire.k;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
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
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import org.apache.commons.codec.binary4util.BaseNCodec;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final String b;
    public static final String c;
    public static final String d;
    public static b e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static byte[] a(byte[] bArr) {
            InterceptResult invokeL;
            byte b;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
                int length = bArr.length;
                int i2 = (length / 4) * 3;
                if (i2 == 0) {
                    return new byte[0];
                }
                byte[] bArr2 = new byte[i2];
                int i3 = 0;
                while (true) {
                    byte b2 = bArr[length - 1];
                    b = 10;
                    if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                        if (b2 != 61) {
                            break;
                        }
                        i3++;
                    }
                    length--;
                }
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i4 < length) {
                    byte b3 = bArr[i4];
                    if (b3 != b && b3 != 13 && b3 != 32 && b3 != 9) {
                        if (b3 >= 65 && b3 <= 90) {
                            i = b3 - 65;
                        } else if (b3 >= 97 && b3 <= 122) {
                            i = b3 - 71;
                        } else if (b3 >= 48 && b3 <= 57) {
                            i = b3 + 4;
                        } else if (b3 == 43) {
                            i = 62;
                        } else if (b3 != 47) {
                            return null;
                        } else {
                            i = 63;
                        }
                        i6 = (i6 << 6) | ((byte) i);
                        if (i7 % 4 == 3) {
                            int i8 = i5 + 1;
                            bArr2[i5] = (byte) ((i6 & 16711680) >> 16);
                            int i9 = i8 + 1;
                            bArr2[i8] = (byte) ((i6 & 65280) >> 8);
                            bArr2[i9] = (byte) (i6 & 255);
                            i5 = i9 + 1;
                        }
                        i7++;
                    }
                    i4++;
                    b = 10;
                }
                if (i3 > 0) {
                    int i10 = i6 << (i3 * 6);
                    int i11 = i5 + 1;
                    bArr2[i5] = (byte) ((i10 & 16711680) >> 16);
                    if (i3 == 1) {
                        i5 = i11 + 1;
                        bArr2[i11] = (byte) ((i10 & 65280) >> 8);
                    } else {
                        i5 = i11;
                    }
                }
                byte[] bArr3 = new byte[i5];
                System.arraycopy(bArr2, 0, bArr3, 0, i5);
                return bArr3;
            }
            return (byte[]) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public b() {
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

        public static b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("deviceid");
                    String string2 = jSONObject.getString("imei");
                    if (!TextUtils.isEmpty(string) && string2 != null) {
                        b bVar = new b();
                        bVar.a = string;
                        bVar.b = string2;
                        return bVar;
                    }
                    return null;
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074259047, "Lcom/baidu/sofire/k/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074259047, "Lcom/baidu/sofire/k/g;");
                return;
            }
        }
        String str = new String(a.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, BaseNCodec.PAD_DEFAULT}));
        b = str;
        String str2 = new String(a.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, BaseNCodec.PAD_DEFAULT}));
        c = str2;
        d = str + str2;
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
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
                    int i = com.baidu.sofire.a.b.a;
                }
                return charArrayWriter2;
            } catch (Throwable unused3) {
                try {
                    int i2 = com.baidu.sofire.a.b.a;
                    return null;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused4) {
                            int i3 = com.baidu.sofire.a.b.a;
                        }
                    }
                }
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized b b(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            synchronized (g.class) {
                if (e == null) {
                    g gVar = new g(context);
                    File file = new File(gVar.a.getFilesDir(), com.baidu.sofire.k.a.b("K5j7Snuat7HHCaEg62XaRa41Ukv_4vtSH9Z4FqXi1Fs="));
                    b a2 = file.exists() ? b.a(a(a(file))) : null;
                    if (a2 == null && (a2 = b.a(a(gVar.c(com.baidu.sofire.k.a.b("FLI7RPHK558lhmIMdK5V1-nh-gfSlVAFvUdffcjh8sgAXO2nb2l_YXWA6lX6geWt"))))) == null) {
                        boolean z = gVar.a.checkPermission(com.kuaishou.weapon.p0.h.i, Process.myPid(), Process.myUid()) == 0;
                        if (z) {
                            a2 = gVar.b();
                        }
                        if (a2 == null && (a2 = gVar.a()) == null && z) {
                            String str = "";
                            if (!TextUtils.isEmpty("0")) {
                                str = "0";
                            }
                            a2 = gVar.b(str);
                        }
                    }
                    e = a2;
                }
                bVar = e;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return m.c(this.a) ? Settings.System.getString(this.a.getContentResolver(), str) : "";
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                b b2 = b(context);
                if (b2 != null) {
                    String str = b2.b;
                    if (TextUtils.isEmpty(str)) {
                        str = "0";
                    }
                    String stringBuffer = new StringBuffer(str).reverse().toString();
                    return b2.a + "|" + stringBuffer;
                }
                return "";
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            if (m.b(this.a)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, com.baidu.sofire.k.a.b("_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J") + "/" + com.baidu.sofire.k.a.b("idzo8hWEQF2c4tBTa5WOlQMU8UU8Wq-86X4X9ljayiU="));
                if (file.exists()) {
                    String a2 = a(file);
                    if (!TextUtils.isEmpty(a2)) {
                        String str = d;
                        return b.a(new String(com.baidu.sofire.a.a.a(str, str, a.a(a2.getBytes()))));
                    }
                }
                return null;
            }
            return null;
        }
        return (b) invokeV.objValue;
    }

    public final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                String c2 = c(com.baidu.sofire.k.a.b("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                String c3 = c(com.baidu.sofire.k.a.b("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                if (TextUtils.isEmpty(c3)) {
                    c3 = "0";
                    if (TextUtils.isEmpty("0")) {
                        c3 = "";
                    }
                }
                if (TextUtils.isEmpty(c2)) {
                    String f = m.f(this.a);
                    c2 = c(com.baidu.sofire.a.a.a((com.baidu.sofire.k.a.b("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + c3 + f).getBytes(), true));
                }
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                b bVar = new b();
                bVar.a = c2;
                bVar.b = c3;
                return bVar;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (b) invokeV.objValue;
    }

    public final b b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = Build.VERSION.SDK_INT < 23;
            if (!(z && TextUtils.isEmpty(str)) && m.b(this.a)) {
                String str3 = "";
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, com.baidu.sofire.k.a.b("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + com.baidu.sofire.k.a.b("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
                if (!file.exists()) {
                    File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
                    file = new File(externalStorageDirectory2, com.baidu.sofire.k.a.b("_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J") + "/" + com.baidu.sofire.k.a.b("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
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
                        sb.append("\r\n");
                    }
                    bufferedReader.close();
                    String str4 = d;
                    String[] split = new String(com.baidu.sofire.a.a.a(str4, str4, a.a(sb.toString().getBytes()))).split("=");
                    if (split != null && split.length == 2) {
                        if (z && str.equals(split[0])) {
                            str2 = split[1];
                        } else if (!z) {
                            if (TextUtils.isEmpty(str)) {
                                str = split[1];
                            }
                            str2 = split[1];
                        }
                        str3 = str2;
                    }
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
                if (TextUtils.isEmpty(str3)) {
                    return null;
                }
                b bVar = new b();
                bVar.a = str3;
                bVar.b = str;
                return bVar;
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String str2 = d;
                return new String(com.baidu.sofire.a.a.a(str2, str2, a.a(str.getBytes())));
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
